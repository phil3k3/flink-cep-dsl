package at.datasciencelabs.pattern;

import at.datasciencelabs.pattern.generated.PatternLanguageBaseListener;
import at.datasciencelabs.pattern.generated.PatternLanguageParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.apache.flink.cep.nfa.AfterMatchSkipStrategy;
import org.apache.flink.cep.pattern.Pattern;

public class FlinkCepPatternLanguageListener extends PatternLanguageBaseListener {

    private Pattern<Event, Event> pattern;
    private EvaluationCondition condition;
    private Expression expression;
    private ExpressionList expressionList;
    private boolean isFollowedBy;
    private boolean isQuantifier;
    private Quantifier.Builder quantifierBuilder;
    private boolean isOptionalQuantifier;

    public FlinkCepPatternLanguageListener() {
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
            else {
                pattern = pattern.next(ctx.getText());
            }
        }
    }


    @Override
    public void exitClassIdentifier(PatternLanguageParser.ClassIdentifierContext ctx) {
        super.exitClassIdentifier(ctx);
    }

    @Override
    public void enterExpressionList(PatternLanguageParser.ExpressionListContext ctx) {
        super.enterExpressionList(ctx);
        expressionList = new ExpressionList();
    }

    @Override
    public void enterExpression(PatternLanguageParser.ExpressionContext ctx) {
        super.enterExpression(ctx);
    }


    @Override
    public void exitExpressionList(PatternLanguageParser.ExpressionListContext ctx) {
        pattern = pattern.where(new EvaluationCondition(expressionList));
        super.exitExpressionList(ctx);
    }

    @Override
    public void exitExpression(PatternLanguageParser.ExpressionContext ctx) {
        super.exitExpression(ctx);
        expressionList.add(expression);
    }

    @Override
    public void enterEvalAndExpression(PatternLanguageParser.EvalAndExpressionContext ctx) {
        super.enterEvalAndExpression(ctx);
    }

    @Override
    public void exitEvalAndExpression(PatternLanguageParser.EvalAndExpressionContext ctx) {
        super.exitEvalAndExpression(ctx);
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
        expression.setAttribute(ctx.getText());
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
        expression = new Expression(Operator.EQUALS);
    }

    @Override
    public void exitEvalEqualsExpression(PatternLanguageParser.EvalEqualsExpressionContext ctx) {
        super.exitEvalEqualsExpression(ctx);
    }

    @Override
    public void enterFollowedByRepeat(PatternLanguageParser.FollowedByRepeatContext ctx) {
        super.enterFollowedByRepeat(ctx);
        isFollowedBy = true;
    }

    @Override
    public void exitFollowedByRepeat(PatternLanguageParser.FollowedByRepeatContext ctx) {
        super.exitFollowedByRepeat(ctx);
    }

    @Override
    public void exitNumberconstant(PatternLanguageParser.NumberconstantContext ctx) {
        super.exitNumberconstant(ctx);
        int timesOrValue = Integer.parseInt(ctx.getText());
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
        super.enterPatternFilterExpressionOptional(ctx);;
        this.quantifierBuilder = this.quantifierBuilder.optional();
    }

    @Override
    public void enterPatternExpression(PatternLanguageParser.PatternExpressionContext ctx) {
        super.enterPatternExpression(ctx);
        this.quantifierBuilder = new Quantifier.Builder();
    }

    @Override
    public void exitPatternExpression(PatternLanguageParser.PatternExpressionContext ctx) {
        this.pattern = this.quantifierBuilder.build().apply(pattern);
    }

    public Pattern<Event, Event> getPattern() {
        return pattern;
    }
}
