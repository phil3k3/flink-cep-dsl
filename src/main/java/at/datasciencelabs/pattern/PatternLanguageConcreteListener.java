package at.datasciencelabs.pattern;

import at.datasciencelabs.pattern.generated.PatternLanguageBaseListener;
import at.datasciencelabs.pattern.generated.PatternLanguageParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.apache.flink.cep.nfa.AfterMatchSkipStrategy;
import org.apache.flink.cep.pattern.Pattern;

public class PatternLanguageConcreteListener extends PatternLanguageBaseListener {


    private Pattern<Event, Event> pattern;
    private EvaluationCondition condition;
    private Expression expression;
    private ExpressionList expressionList;
    private boolean isFollowedBy;

    public PatternLanguageConcreteListener() {
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



    public Pattern<Event, Event> getPattern() {
        return pattern;
    }
}
