package at.datasciencelabs.pattern;

import at.datasciencelabs.pattern.generated.PatternLanguageBaseListener;
import at.datasciencelabs.pattern.generated.PatternLanguageParser;
import org.antlr.v4.runtime.Token;
import org.apache.flink.cep.nfa.aftermatch.AfterMatchSkipStrategy;
import org.apache.flink.cep.pattern.Pattern;
import org.apache.flink.streaming.api.windowing.time.Time;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FlinkCepPatternLanguageListener extends PatternLanguageBaseListener {

    private Pattern<Event, Event> pattern;
    private Expression expression;
    private AggregatingContextMatcher orAggregatingContextMatcher;
    private AggregatingContextMatcher currentExpressionList;
    private AggregatingContextMatcher outerContextMatcher;
    private Quantifier.Builder quantifierBuilder;
    private boolean strictEventTypeMatching;
    private EvaluationCondition stopCondition;
    private static Map<String,Function<String,AfterMatchSkipStrategy>> skipStrategies;
    private static Map<String,BiFunction<Integer,Pattern<Event,Event>,Pattern<Event,Event>>> timeWindowAppliers = new HashMap<>();
    private BiFunction<Pattern<Event,Event>, String, Pattern<Event,Event>> patternCombiner = Pattern::next;
    private Stack<BiConsumer<FlinkCepPatternLanguageListener, Integer>> numberConstantApplier = new Stack<>();
    private Stack<BiConsumer<FlinkCepPatternLanguageListener, String>> stringConstantApplier = new Stack<>();


    static {
        skipStrategies = new HashMap<>();
        skipStrategies.put("NO_SKIP", (m) -> AfterMatchSkipStrategy.noSkip());
        skipStrategies.put("SKIP_PAST_LAST", (m) -> AfterMatchSkipStrategy.skipPastLastEvent());
        skipStrategies.put("SKIP_TO_LAST", AfterMatchSkipStrategy::skipToLast);
        skipStrategies.put("SKIP_TO_FIRST", AfterMatchSkipStrategy::skipToFirst);

        timeWindowAppliers.put("s", (v,p) -> p.within(Time.seconds(v)));
        timeWindowAppliers.put("h", (v,p) -> p.within(Time.hours(v)));
        timeWindowAppliers.put("m", (v,p) -> p.within(Time.minutes(v)));
        timeWindowAppliers.put("ms", (v,p) -> p.within(Time.milliseconds(v)));
    }

    private String skipStrategyClass;
    private AfterMatchSkipStrategy afterMatchSkipStrategy = AfterMatchSkipStrategy.noSkip();

    FlinkCepPatternLanguageListener(boolean strictEventTypeMatching) {
        this.strictEventTypeMatching = strictEventTypeMatching;
    }

    @Override
    public void enterPatternExpression(PatternLanguageParser.PatternExpressionContext ctx) {
        super.enterPatternExpression(ctx);
    }

    @Override
    public void enterFollowedByOrNext(PatternLanguageParser.FollowedByOrNextContext ctx) {
        if (ctx.f != null && "!".equals(ctx.f.getText())) {
            patternCombiner = Pattern::notNext;
        }
    }

    @Override
    public void enterClassIdentifier(PatternLanguageParser.ClassIdentifierContext ctx) {
        if (pattern == null) {
            pattern = Pattern.begin(ctx.getText(), afterMatchSkipStrategy);
        }
        else {
            pattern = patternCombiner.apply(pattern,ctx.getText());
        }
        outerContextMatcher.add(eventTypeMatcherFor(ctx.getText()));
    }

    private ContextMatcher eventTypeMatcherFor(String text) {
        return strictEventTypeMatching ?
                EventTypeContextMatcher.matching(text) :
                EventTypeContextMatcher.ignoring();
    }

    @Override
    public void exitExpressionList(PatternLanguageParser.ExpressionListContext ctx) {
        outerContextMatcher.add(orAggregatingContextMatcher);
    }

    @Override
    public void exitStopCondition(PatternLanguageParser.StopConditionContext ctx) {
        stopCondition = new EvaluationCondition(orAggregatingContextMatcher);
    }

    @Override
    public void enterEvalAndExpression(PatternLanguageParser.EvalAndExpressionContext ctx) {
        currentExpressionList = AggregatingContextMatcher.and();
    }

    @Override
    public void enterTimeWindow(PatternLanguageParser.TimeWindowContext ctx) {
        pattern = timeWindowAppliers.get(ctx.u.getText()).apply(Integer.parseInt(ctx.c.getText()), pattern);
		numberConstantApplier.push((l,v) -> {});
    }

    @Override
    public void exitTimeWindow(PatternLanguageParser.TimeWindowContext ctx) {
        numberConstantApplier.pop();
    }

    @Override
    public void exitEvalAndExpression(PatternLanguageParser.EvalAndExpressionContext ctx) {
        orAggregatingContextMatcher.add(currentExpressionList);
        currentExpressionList = orAggregatingContextMatcher;
    }

    @Override
    public void enterEvalOrExpression(PatternLanguageParser.EvalOrExpressionContext ctx) {
        orAggregatingContextMatcher = AggregatingContextMatcher.or();
        currentExpressionList = orAggregatingContextMatcher;
    }

    @Override
    public void exitEventPropertyIdent(PatternLanguageParser.EventPropertyIdentContext ctx) {
        if (expression.hasAttribute()) {
            if (expression.hasValueClassIdentiifer()) {
                expression.setValueAttribute(ctx.getText());
            }
            else {
                expression.setValueClassIdentifier(ctx.getText());
            }
        }
        else {
            expression.setAttribute(ctx.getText());
        }
    }

    @Override
    public void exitStringconstant(PatternLanguageParser.StringconstantContext ctx) {
        String substring = ctx.getText().substring(1, ctx.getText().length() - 1);
        stringConstantApplier.peek().accept(this, substring);
    }

    @Override
    public void exitConstant(PatternLanguageParser.ConstantContext ctx) {
        if ((true+"").equals(ctx.getText())) {
            this.expression.setValue(true);
        }
        if ((false+"").equals(ctx.getText())) {
            this.expression.setValue(false);
        }
    }

    @Override
    public void enterEvalEqualsExpression(PatternLanguageParser.EvalEqualsExpressionContext ctx) {
        this.expression = new Expression();
        if (ctx.eq != null) {
            this.expression.setOperator(Operator.EQUALS);
        }
        if (ctx.ne != null) {
            this.expression.setOperator(Operator.NOT_EQUALS);
        }
        numberConstantApplier.push((t,v) -> t.expression.setValue(v));
        stringConstantApplier.push((t,v) -> t.expression.setValue(v));
    }

    @Override
    public void enterEvalRelationalExpression(PatternLanguageParser.EvalRelationalExpressionContext ctx) {
        if (ctx.r != null) {
            try {
                String operatorToken = ctx.r.getText();
                Operator operator = Operator.fromText(operatorToken);
                expression.setOperator(operator);
            } catch (Throwable throwable) {
                throw new RuntimeException(throwable);
            }
        }
    }

    @Override
    public void exitEvalEqualsExpression(PatternLanguageParser.EvalEqualsExpressionContext ctx) {
        currentExpressionList.add(expression);
        expression = null;
        numberConstantApplier.pop();
        stringConstantApplier.pop();
    }

    @Override
    public void enterFollowedBy(PatternLanguageParser.FollowedByContext ctx) {
        patternCombiner = Pattern::followedBy;
    }

    @Override
    public void enterNotFollowedBy(PatternLanguageParser.NotFollowedByContext ctx) {
        patternCombiner = Pattern::notFollowedBy;
    }

    @Override
    public void enterFollowedByAny(PatternLanguageParser.FollowedByAnyContext ctx) {
        patternCombiner = Pattern::followedByAny;
    }

    @Override
    public void exitNumberconstant(PatternLanguageParser.NumberconstantContext ctx) {
        int timesOrValue = Integer.parseInt(ctx.getText());
        numberConstantApplier.peek().accept(this, timesOrValue);
    }

    @Override
    public void enterNumber_quantifier_greedy(PatternLanguageParser.Number_quantifier_greedyContext ctx) {
        this.quantifierBuilder = quantifierBuilder.greedy();
    }

    @Override
    public void enterPlus_quantifier(PatternLanguageParser.Plus_quantifierContext ctx) {
        quantifierBuilder = quantifierBuilder.oneOrMore();
    }

    @Override
    public void enterSkipStrategy(PatternLanguageParser.SkipStrategyContext ctx) {
        stringConstantApplier.push((t,v) -> t.skipStrategyClass = v);
    }

    @Override
    public void exitSkipStrategy(PatternLanguageParser.SkipStrategyContext ctx) {
        stringConstantApplier.pop();
        String text = Optional.ofNullable(ctx.s).map(Token::getText).orElse("");
        afterMatchSkipStrategy = skipStrategies.get(text).apply(skipStrategyClass);
    }

    @Override
    public void enterStar_quantifier(PatternLanguageParser.Star_quantifierContext ctx) {
        quantifierBuilder = quantifierBuilder.zeroOrMore();
    }

    @Override
    public void enterPatternFilterExpressionOptional(PatternLanguageParser.PatternFilterExpressionOptionalContext ctx) {
        this.quantifierBuilder = this.quantifierBuilder.optional();
    }

    @Override
    public void enterPatternFilterExpression(PatternLanguageParser.PatternFilterExpressionContext ctx) {
        this.quantifierBuilder = new Quantifier.Builder();
        this.outerContextMatcher = AggregatingContextMatcher.and();
        this.numberConstantApplier.push((t,v) -> t.quantifierBuilder = t.quantifierBuilder.bound(v));
    }

    @Override
    public void exitPatternFilterExpression(PatternLanguageParser.PatternFilterExpressionContext ctx) {
        pattern = pattern.where(new EvaluationCondition(outerContextMatcher));
        this.pattern = this.quantifierBuilder.build().apply(pattern);
        this.numberConstantApplier.pop();
    }

    @Override
    public void enterUpper_bound_unlimited(PatternLanguageParser.Upper_bound_unlimitedContext ctx) {
        this.quantifierBuilder = quantifierBuilder.bound(Integer.MAX_VALUE);
    }

    public Pattern<Event, Event> getPattern() {
        if (stopCondition != null) {
            pattern = pattern.until(stopCondition);
        }
        return pattern;
    }
}
