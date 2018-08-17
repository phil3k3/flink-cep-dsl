package at.datasciencelabs.pattern;

import org.antlr.v4.runtime.ParserRuleContext;
import org.apache.flink.cep.nfa.AfterMatchSkipStrategy;
import org.apache.flink.cep.pattern.Pattern;
import org.apache.flink.streaming.api.windowing.time.Time;

import at.datasciencelabs.pattern.generated.PatternLanguageBaseListener;
import at.datasciencelabs.pattern.generated.PatternLanguageParser;

public class FlinkCepPatternLanguageListener extends PatternLanguageBaseListener {

    private Pattern<Event, Event> pattern;
    private Expression expression;
    private AggregatingContextMatcher andExpressionContextMathcher;
    private AggregatingContextMatcher orAggregatingContextMatcher;
    private AggregatingContextMatcher currentExpressioList;
    private boolean isFollowedBy;
    private boolean isFollowedByAny;
    private Quantifier.Builder quantifierBuilder;
    private boolean isTimeWindow;
    private boolean strictEventTypeMatching;

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
    public void enterClassIdentifier(PatternLanguageParser.ClassIdentifierContext ctx) {
        super.enterClassIdentifier(ctx);
        if (pattern == null) {
            pattern = Pattern.begin(ctx.getText(), AfterMatchSkipStrategy.noSkip());
        }
        else {
            if (isFollowedBy) {
                pattern = pattern.followedBy(ctx.getText());
            }
            else if (isFollowedByAny) {
                pattern = pattern.followedByAny(ctx.getText());
            }
            else {
                pattern = pattern.next(ctx.getText());
            }
        }
        andExpressionContextMathcher = AggregatingContextMatcher.and();
        andExpressionContextMathcher.add(eventTypeMatcherFor(ctx.getText()));
    }

    private ContextMatcher eventTypeMatcherFor(String text) {
        return strictEventTypeMatching ?
                EventTypeContextMatcher.matching(text) :
                EventTypeContextMatcher.ignoring();
    }


    @Override
    public void exitClassIdentifier(PatternLanguageParser.ClassIdentifierContext ctx) {
    }

    @Override
    public void enterExpressionList(PatternLanguageParser.ExpressionListContext ctx) {
        super.enterExpressionList(ctx);
    }

    @Override
    public void exitExpressionList(PatternLanguageParser.ExpressionListContext ctx) {
        super.exitExpressionList(ctx);
        andExpressionContextMathcher.add(orAggregatingContextMatcher);
    }

    @Override
    public void enterEvalAndExpression(PatternLanguageParser.EvalAndExpressionContext ctx) {
        super.enterEvalAndExpression(ctx);
        currentExpressioList = AggregatingContextMatcher.and();
    }

    @Override
    public void enterTimeWindow(PatternLanguageParser.TimeWindowContext ctx) {
        super.enterTimeWindow(ctx);
        if (ctx.u.getText().equals("s")) {
            pattern = pattern.within(Time.seconds(Integer.parseInt(ctx.c.getText())));
        }
        if (ctx.u.getText().endsWith("h")) {
            pattern = pattern.within(Time.hours(Integer.parseInt(ctx.c.getText())));
        }
        if (ctx.u.getText().equals("m")) {
            pattern = pattern.within(Time.minutes(Integer.parseInt(ctx.c.getText())));
        }
        if (ctx.u.getText().equals("ms")) {
			pattern = pattern.within(Time.milliseconds(Integer.parseInt(ctx.c.getText())));
		}
		isTimeWindow = true;
    }

    @Override
    public void exitTimeWindow(PatternLanguageParser.TimeWindowContext ctx) {
        super.exitTimeWindow(ctx);
        isTimeWindow = false;
    }

    @Override
    public void exitEvalAndExpression(PatternLanguageParser.EvalAndExpressionContext ctx) {
        super.exitEvalAndExpression(ctx);
        orAggregatingContextMatcher.add(currentExpressioList);
        currentExpressioList = orAggregatingContextMatcher;
    }

    @Override
    public void enterEvalOrExpression(PatternLanguageParser.EvalOrExpressionContext ctx) {
        super.enterEvalOrExpression(ctx);
        orAggregatingContextMatcher = AggregatingContextMatcher.or();
        currentExpressioList = orAggregatingContextMatcher;
    }

    @Override
    public void exitEvalOrExpression(PatternLanguageParser.EvalOrExpressionContext ctx) {
        super.exitEvalOrExpression(ctx);
        pattern = pattern.where(new EvaluationCondition(andExpressionContextMathcher));
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
            if (expression.hasValueClassIdentifier()) {
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
        expression.setValue(ctx.getText().substring(1, ctx.getText().length()-1));
    }

    @Override
    public void exitConstant(PatternLanguageParser.ConstantContext ctx) {
        super.exitConstant(ctx);
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
        currentExpressioList.add(expression);
    }

    @Override
    public void enterFollowedBy(PatternLanguageParser.FollowedByContext ctx) {
        super.enterFollowedBy(ctx);
        isFollowedBy = true;
    }

    @Override
    public void enterFollowedByAny(PatternLanguageParser.FollowedByAnyContext ctx) {
        super.enterFollowedByAny(ctx);
        isFollowedByAny = true;
    }

    @Override
    public void exitFollowedBy(PatternLanguageParser.FollowedByContext ctx) {
        super.exitFollowedBy(ctx);
    }

    @Override
    public void exitNumberconstant(PatternLanguageParser.NumberconstantContext ctx) {
        super.exitNumberconstant(ctx);
        int timesOrValue = Integer.parseInt(ctx.getText());
        if (isTimeWindow) {
            return;
        }
        if (this.expression != null) {
            this.expression.setValue(timesOrValue);
        }
        else {
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
    }

    @Override
    public void exitPatternFilterExpression(PatternLanguageParser.PatternFilterExpressionContext ctx) {
        super.exitPatternFilterExpression(ctx);
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

    public Pattern<? extends Event, ?> getPattern() {
        return pattern;
    }
}
