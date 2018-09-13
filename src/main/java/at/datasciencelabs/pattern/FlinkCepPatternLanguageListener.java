package at.datasciencelabs.pattern;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.antlr.v4.runtime.ParserRuleContext;
import org.apache.flink.cep.nfa.aftermatch.AfterMatchSkipStrategy;
import org.apache.flink.cep.pattern.Pattern;
import org.apache.flink.streaming.api.windowing.time.Time;

import at.datasciencelabs.pattern.generated.PatternLanguageBaseListener;
import at.datasciencelabs.pattern.generated.PatternLanguageParser;

public class FlinkCepPatternLanguageListener extends PatternLanguageBaseListener {

    private Pattern<Event, Event> pattern;
    private Expression expression;
    private AggregatingContextMatcher orAggregatingContextMatcher;
    private AggregatingContextMatcher currentExpressionList;
    private AggregatingContextMatcher outerContextMatcher;
    private Quantifier.Builder quantifierBuilder;
    private boolean isTimeWindow;
    private boolean strictEventTypeMatching;
    private EvaluationCondition stopCondition;
    private static Map<String,Function<String,AfterMatchSkipStrategy>> skipStrategies;
    private static Map<String,BiFunction<Integer,Pattern<Event,Event>,Pattern<Event,Event>>> timeWindowAppliers;
    private PatternCombiner patternCombiner;
    private Stack<BiConsumer<FlinkCepPatternLanguageListener, Integer>> numberConstantApplier = new Stack<>();
    private Stack<StringConstantApplier> stringConstantApplier = new Stack<>();


    static {
        skipStrategies = new HashMap<>();
        skipStrategies.put("#NO_SKIP", (m) -> AfterMatchSkipStrategy.noSkip());
        skipStrategies.put("#SKIP_PAST_LAST", (m) -> AfterMatchSkipStrategy.skipPastLastEvent());
        skipStrategies.put("#SKIP_TO_LAST", AfterMatchSkipStrategy::skipToLast);
        skipStrategies.put("#SKIP_TO_FIRST", AfterMatchSkipStrategy::skipToFirst);

        timeWindowAppliers.put("s", (v,p) -> p.within(Time.seconds(v)));
        timeWindowAppliers.put("h", (v,p) -> p.within(Time.hours(v)));
        timeWindowAppliers.put("m", (v,p) -> p.within(Time.minutes(v)));
        timeWindowAppliers.put("ms", (v,p) -> p.within(Time.milliseconds(v)));
    }

    private boolean isSkipStrategy;
    private String skipStrategyClass;
    private AfterMatchSkipStrategy afterMatchSkipStrategy = AfterMatchSkipStrategy.noSkip();

    FlinkCepPatternLanguageListener(boolean strictEventTypeMatching) {
        this.strictEventTypeMatching = strictEventTypeMatching;
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        super.enterEveryRule(ctx);
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        super.exitEveryRule(ctx);
    }

    @Override
    public void enterFollowedByOrNext(PatternLanguageParser.FollowedByOrNextContext ctx) {
        if (ctx.f != null && "!".equals(ctx.f.getText())) {
            patternCombiner = Pattern::notNext;
        }
    }

    @Override
    public void enterClassIdentifier(PatternLanguageParser.ClassIdentifierContext ctx) {
        super.enterClassIdentifier(ctx);
        if (pattern == null) {
            pattern = Pattern.begin(ctx.getText(), afterMatchSkipStrategy);
        }
        else {
            pattern = patternCombiner.combine(pattern,ctx.getText());
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
        super.exitExpressionList(ctx);
        outerContextMatcher.add(orAggregatingContextMatcher);
    }

    @Override
    public void exitStopCondition(PatternLanguageParser.StopConditionContext ctx) {
        super.exitStopCondition(ctx);
        stopCondition = new EvaluationCondition(orAggregatingContextMatcher);
    }

    @Override
    public void enterEvalAndExpression(PatternLanguageParser.EvalAndExpressionContext ctx) {
        super.enterEvalAndExpression(ctx);
        currentExpressionList = AggregatingContextMatcher.and();
    }

    @Override
    public void enterTimeWindow(PatternLanguageParser.TimeWindowContext ctx) {
        super.enterTimeWindow(ctx);
        pattern = timeWindowAppliers.get(ctx.u.getText()).apply(Integer.parseInt(ctx.c.getText()), pattern);
		numberConstantApplier.push((l,v) -> {});
    }

    @Override
    public void exitTimeWindow(PatternLanguageParser.TimeWindowContext ctx) {
        super.exitTimeWindow(ctx);
        numberConstantApplier.pop();
    }

    @Override
    public void exitEvalAndExpression(PatternLanguageParser.EvalAndExpressionContext ctx) {
        super.exitEvalAndExpression(ctx);
        orAggregatingContextMatcher.add(currentExpressionList);
        currentExpressionList = orAggregatingContextMatcher;
    }

    @Override
    public void enterEvalOrExpression(PatternLanguageParser.EvalOrExpressionContext ctx) {
        super.enterEvalOrExpression(ctx);
        orAggregatingContextMatcher = AggregatingContextMatcher.or();
        currentExpressionList = orAggregatingContextMatcher;
    }

    @Override
    public void exitEvalOrExpression(PatternLanguageParser.EvalOrExpressionContext ctx) {
        super.exitEvalOrExpression(ctx);
    }

    @Override
    public void enterEventProperty(PatternLanguageParser.EventPropertyContext ctx) {
        super.enterEventProperty(ctx);
    }

    @Override
    public void exitEventProperty(PatternLanguageParser.EventPropertyContext ctx) {
        super.exitEventProperty(ctx);
    }

    @Override
    public void enterEventPropertyAtomic(PatternLanguageParser.EventPropertyAtomicContext ctx) {
        super.enterEventPropertyAtomic(ctx);
    }

    @Override
    public void exitEventPropertyAtomic(PatternLanguageParser.EventPropertyAtomicContext ctx) {
        super.exitEventPropertyAtomic(ctx);
    }

    @Override
    public void enterEventPropertyIdent(PatternLanguageParser.EventPropertyIdentContext ctx) {
        super.enterEventPropertyIdent(ctx);
    }

    @Override
    public void exitEventPropertyIdent(PatternLanguageParser.EventPropertyIdentContext ctx) {
        super.exitEventPropertyIdent(ctx);
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
    public void enterConstant(PatternLanguageParser.ConstantContext ctx) {
        super.enterConstant(ctx);
    }

    @Override
    public void enterStringconstant(PatternLanguageParser.StringconstantContext ctx) {
        super.enterStringconstant(ctx);
    }



    @Override
    public void exitStringconstant(PatternLanguageParser.StringconstantContext ctx) {
        super.exitStringconstant(ctx);
        String substring = ctx.getText().substring(1, ctx.getText().length() - 1);
        if (isSkipStrategy) {
            skipStrategyClass = substring;
            return;
        }
        expression.setValue(substring);
    }

    @Override
    public void exitConstant(PatternLanguageParser.ConstantContext ctx) {
        super.exitConstant(ctx);
        if ((true+"").equals(ctx.getText())) {
            this.expression.setValue(true);
        }
        if ((false+"").equals(ctx.getText())) {
            this.expression.setValue(false);
        }
    }


    @Override
    public void enterEvalEqualsExpression(PatternLanguageParser.EvalEqualsExpressionContext ctx) {
        super.enterEvalEqualsExpression(ctx);
        this.expression = new Expression();
        if (ctx.eq != null) {
            this.expression.setOperator(Operator.EQUALS);
        }
        if (ctx.ne != null) {
            this.expression.setOperator(Operator.NOT_EQUALS);
        }
        numberConstantApplier.push((t,v) -> t.expression.setValue(v));
    }


    @Override
    public void enterExpression(PatternLanguageParser.ExpressionContext ctx) {
        super.enterExpression(ctx);
    }

    @Override
    public void enterEvalRelationalExpression(PatternLanguageParser.EvalRelationalExpressionContext ctx) {
        super.enterEvalRelationalExpression(ctx);
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
    public void exitEvalRelationalExpression(PatternLanguageParser.EvalRelationalExpressionContext ctx) {
        super.exitEvalRelationalExpression(ctx);
    }

    @Override
    public void exitEvalEqualsExpression(PatternLanguageParser.EvalEqualsExpressionContext ctx) {
        super.exitEvalEqualsExpression(ctx);
        currentExpressionList.add(expression);
        expression = null;
        numberConstantApplier.pop();
    }

    @Override
    public void enterFollowedBy(PatternLanguageParser.FollowedByContext ctx) {
        super.enterFollowedBy(ctx);
        patternCombiner = Pattern::followedBy;
    }

    @Override
    public void enterNotFollowedBy(PatternLanguageParser.NotFollowedByContext ctx) {
        super.enterNotFollowedBy(ctx);
        patternCombiner = Pattern::notFollowedBy;
    }

    @Override
    public void enterFollowedByAny(PatternLanguageParser.FollowedByAnyContext ctx) {
        super.enterFollowedByAny(ctx);
        patternCombiner = Pattern::followedByAny;
    }

    @Override
    public void exitNumberconstant(PatternLanguageParser.NumberconstantContext ctx) {
        super.exitNumberconstant(ctx);
        int timesOrValue = Integer.parseInt(ctx.getText());
        numberConstantApplier.peek().accept(this, timesOrValue);


            quantifierBuilder = quantifierBuilder.bound(timesOrValue);
        }
    }



    @Override
    public void enterQuantifier(PatternLanguageParser.QuantifierContext ctx) {
        super.enterQuantifier(ctx);

    }


    @Override
    public void exitQuantifier(PatternLanguageParser.QuantifierContext ctx) {
        super.exitQuantifier(ctx);
    }

    @Override
    public void exitNumber(PatternLanguageParser.NumberContext ctx) {
        super.exitNumber(ctx);
    }

    @Override
    public void enterNumber_quantifier(PatternLanguageParser.Number_quantifierContext ctx) {
        super.enterNumber_quantifier(ctx);
    }

    @Override
    public void enterNumber_quantifier_greedy(PatternLanguageParser.Number_quantifier_greedyContext ctx) {
        super.enterNumber_quantifier_greedy(ctx);
        this.quantifierBuilder = quantifierBuilder.greedy();
    }

    @Override
    public void exitNumber_quantifier(PatternLanguageParser.Number_quantifierContext ctx) {
        super.exitNumber_quantifier(ctx);
    }

    @Override
    public void exitNumber_quantifier_greedy(PatternLanguageParser.Number_quantifier_greedyContext ctx) {
        super.exitNumber_quantifier_greedy(ctx);
    }

    @Override
    public void enterPlus_quantifier(PatternLanguageParser.Plus_quantifierContext ctx) {
        super.enterPlus_quantifier(ctx);
        quantifierBuilder = quantifierBuilder.oneOrMore();
    }

    @Override
    public void exitPlus_quantifier(PatternLanguageParser.Plus_quantifierContext ctx) {
        super.exitPlus_quantifier(ctx);
    }

    @Override
    public void enterSkipStrategy(PatternLanguageParser.SkipStrategyContext ctx) {
        isSkipStrategy = true;
    }

    @Override
    public void exitSkipStrategy(PatternLanguageParser.SkipStrategyContext ctx) {
        isSkipStrategy = false;
        afterMatchSkipStrategy = skipStrategies.get(ctx.s.getText()).apply(skipStrategyClass);
    }

    @Override
    public void enterStar_quantifier(PatternLanguageParser.Star_quantifierContext ctx) {
        super.enterStar_quantifier(ctx);
        quantifierBuilder = quantifierBuilder.zeroOrMore();
    }

    @Override
    public void exitStar_quantifier(PatternLanguageParser.Star_quantifierContext ctx) {
        super.exitStar_quantifier(ctx);
    }

    @Override
    public void enterPatternFilterExpressionOptional(PatternLanguageParser.PatternFilterExpressionOptionalContext ctx) {
        super.enterPatternFilterExpressionOptional(ctx);
        this.quantifierBuilder = this.quantifierBuilder.optional();
    }

    @Override
    public void enterPatternFilterExpression(PatternLanguageParser.PatternFilterExpressionContext ctx) {
        super.enterPatternFilterExpression(ctx);
        this.quantifierBuilder = new Quantifier.Builder();
        this.outerContextMatcher = AggregatingContextMatcher.and();
        this.numberConstantApplier.push((t,v) -> quantifierBuilder)
    }

    @Override
    public void exitPatternFilterExpression(PatternLanguageParser.PatternFilterExpressionContext ctx) {
        super.exitPatternFilterExpression(ctx);
        pattern = pattern.where(new EvaluationCondition(outerContextMatcher));
        this.pattern = this.quantifierBuilder.build().apply(pattern);
    }

    @Override
    public void enterUpper_bound_unlimited(PatternLanguageParser.Upper_bound_unlimitedContext ctx) {
        super.enterUpper_bound_unlimited(ctx);
        this.quantifierBuilder = quantifierBuilder.bound(Integer.MAX_VALUE);
    }


    @Override
    public void exitUpper_bound_unlimited(PatternLanguageParser.Upper_bound_unlimitedContext ctx) {
        super.exitUpper_bound_unlimited(ctx);
    }

    public Pattern<Event, Event> getPattern() {
        if (stopCondition != null) {
            pattern = pattern.until(stopCondition);
        }
        return pattern;
    }
}
