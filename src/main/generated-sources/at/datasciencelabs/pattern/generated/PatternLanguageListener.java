// Generated from PatternLanguage.g4 by ANTLR 4.7.1

package at.datasciencelabs.pattern.generated;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PatternLanguageParser}.
 */
public interface PatternLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#startPatternExpressionRule}.
	 * @param ctx the parse tree
	 */
	void enterStartPatternExpressionRule(PatternLanguageParser.StartPatternExpressionRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#startPatternExpressionRule}.
	 * @param ctx the parse tree
	 */
	void exitStartPatternExpressionRule(PatternLanguageParser.StartPatternExpressionRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#patternExpression}.
	 * @param ctx the parse tree
	 */
	void enterPatternExpression(PatternLanguageParser.PatternExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#patternExpression}.
	 * @param ctx the parse tree
	 */
	void exitPatternExpression(PatternLanguageParser.PatternExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#orExpression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(PatternLanguageParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#orExpression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(PatternLanguageParser.OrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#followedByOrNextRepeat}.
	 * @param ctx the parse tree
	 */
	void enterFollowedByOrNextRepeat(PatternLanguageParser.FollowedByOrNextRepeatContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#followedByOrNextRepeat}.
	 * @param ctx the parse tree
	 */
	void exitFollowedByOrNextRepeat(PatternLanguageParser.FollowedByOrNextRepeatContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#followedByRepeat}.
	 * @param ctx the parse tree
	 */
	void enterFollowedByRepeat(PatternLanguageParser.FollowedByRepeatContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#followedByRepeat}.
	 * @param ctx the parse tree
	 */
	void exitFollowedByRepeat(PatternLanguageParser.FollowedByRepeatContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(PatternLanguageParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(PatternLanguageParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#matchUntilExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatchUntilExpression(PatternLanguageParser.MatchUntilExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#matchUntilExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatchUntilExpression(PatternLanguageParser.MatchUntilExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#qualifyExpression}.
	 * @param ctx the parse tree
	 */
	void enterQualifyExpression(PatternLanguageParser.QualifyExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#qualifyExpression}.
	 * @param ctx the parse tree
	 */
	void exitQualifyExpression(PatternLanguageParser.QualifyExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#guardPostFix}.
	 * @param ctx the parse tree
	 */
	void enterGuardPostFix(PatternLanguageParser.GuardPostFixContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#guardPostFix}.
	 * @param ctx the parse tree
	 */
	void exitGuardPostFix(PatternLanguageParser.GuardPostFixContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#patternFilterExpression}.
	 * @param ctx the parse tree
	 */
	void enterPatternFilterExpression(PatternLanguageParser.PatternFilterExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#patternFilterExpression}.
	 * @param ctx the parse tree
	 */
	void exitPatternFilterExpression(PatternLanguageParser.PatternFilterExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#patternFilterExpressionMandatory}.
	 * @param ctx the parse tree
	 */
	void enterPatternFilterExpressionMandatory(PatternLanguageParser.PatternFilterExpressionMandatoryContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#patternFilterExpressionMandatory}.
	 * @param ctx the parse tree
	 */
	void exitPatternFilterExpressionMandatory(PatternLanguageParser.PatternFilterExpressionMandatoryContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#patternFilterExpressionOptional}.
	 * @param ctx the parse tree
	 */
	void enterPatternFilterExpressionOptional(PatternLanguageParser.PatternFilterExpressionOptionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#patternFilterExpressionOptional}.
	 * @param ctx the parse tree
	 */
	void exitPatternFilterExpressionOptional(PatternLanguageParser.PatternFilterExpressionOptionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void enterQuantifier(PatternLanguageParser.QuantifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void exitQuantifier(PatternLanguageParser.QuantifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#number_quantifier_greedy}.
	 * @param ctx the parse tree
	 */
	void enterNumber_quantifier_greedy(PatternLanguageParser.Number_quantifier_greedyContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#number_quantifier_greedy}.
	 * @param ctx the parse tree
	 */
	void exitNumber_quantifier_greedy(PatternLanguageParser.Number_quantifier_greedyContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#number_quantifier}.
	 * @param ctx the parse tree
	 */
	void enterNumber_quantifier(PatternLanguageParser.Number_quantifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#number_quantifier}.
	 * @param ctx the parse tree
	 */
	void exitNumber_quantifier(PatternLanguageParser.Number_quantifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#star_quantifier}.
	 * @param ctx the parse tree
	 */
	void enterStar_quantifier(PatternLanguageParser.Star_quantifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#star_quantifier}.
	 * @param ctx the parse tree
	 */
	void exitStar_quantifier(PatternLanguageParser.Star_quantifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#plus_quantifier}.
	 * @param ctx the parse tree
	 */
	void enterPlus_quantifier(PatternLanguageParser.Plus_quantifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#plus_quantifier}.
	 * @param ctx the parse tree
	 */
	void exitPlus_quantifier(PatternLanguageParser.Plus_quantifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#upper_bound}.
	 * @param ctx the parse tree
	 */
	void enterUpper_bound(PatternLanguageParser.Upper_boundContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#upper_bound}.
	 * @param ctx the parse tree
	 */
	void exitUpper_bound(PatternLanguageParser.Upper_boundContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#upper_bound_limited}.
	 * @param ctx the parse tree
	 */
	void enterUpper_bound_limited(PatternLanguageParser.Upper_bound_limitedContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#upper_bound_limited}.
	 * @param ctx the parse tree
	 */
	void exitUpper_bound_limited(PatternLanguageParser.Upper_bound_limitedContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#upper_bound_unlimited}.
	 * @param ctx the parse tree
	 */
	void enterUpper_bound_unlimited(PatternLanguageParser.Upper_bound_unlimitedContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#upper_bound_unlimited}.
	 * @param ctx the parse tree
	 */
	void exitUpper_bound_unlimited(PatternLanguageParser.Upper_bound_unlimitedContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#classIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterClassIdentifier(PatternLanguageParser.ClassIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#classIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitClassIdentifier(PatternLanguageParser.ClassIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#escapableStr}.
	 * @param ctx the parse tree
	 */
	void enterEscapableStr(PatternLanguageParser.EscapableStrContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#escapableStr}.
	 * @param ctx the parse tree
	 */
	void exitEscapableStr(PatternLanguageParser.EscapableStrContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(PatternLanguageParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(PatternLanguageParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(PatternLanguageParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(PatternLanguageParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#evalOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterEvalOrExpression(PatternLanguageParser.EvalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#evalOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitEvalOrExpression(PatternLanguageParser.EvalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#evalAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterEvalAndExpression(PatternLanguageParser.EvalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#evalAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitEvalAndExpression(PatternLanguageParser.EvalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#negatedExpression}.
	 * @param ctx the parse tree
	 */
	void enterNegatedExpression(PatternLanguageParser.NegatedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#negatedExpression}.
	 * @param ctx the parse tree
	 */
	void exitNegatedExpression(PatternLanguageParser.NegatedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#evalEqualsExpression}.
	 * @param ctx the parse tree
	 */
	void enterEvalEqualsExpression(PatternLanguageParser.EvalEqualsExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#evalEqualsExpression}.
	 * @param ctx the parse tree
	 */
	void exitEvalEqualsExpression(PatternLanguageParser.EvalEqualsExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#evalRelationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterEvalRelationalExpression(PatternLanguageParser.EvalRelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#evalRelationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitEvalRelationalExpression(PatternLanguageParser.EvalRelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#concatenationExpr}.
	 * @param ctx the parse tree
	 */
	void enterConcatenationExpr(PatternLanguageParser.ConcatenationExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#concatenationExpr}.
	 * @param ctx the parse tree
	 */
	void exitConcatenationExpr(PatternLanguageParser.ConcatenationExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(PatternLanguageParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(PatternLanguageParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#multiplyExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplyExpression(PatternLanguageParser.MultiplyExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#multiplyExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplyExpression(PatternLanguageParser.MultiplyExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(PatternLanguageParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(PatternLanguageParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#eventProperty}.
	 * @param ctx the parse tree
	 */
	void enterEventProperty(PatternLanguageParser.EventPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#eventProperty}.
	 * @param ctx the parse tree
	 */
	void exitEventProperty(PatternLanguageParser.EventPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#eventPropertyAtomic}.
	 * @param ctx the parse tree
	 */
	void enterEventPropertyAtomic(PatternLanguageParser.EventPropertyAtomicContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#eventPropertyAtomic}.
	 * @param ctx the parse tree
	 */
	void exitEventPropertyAtomic(PatternLanguageParser.EventPropertyAtomicContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#eventPropertyIdent}.
	 * @param ctx the parse tree
	 */
	void enterEventPropertyIdent(PatternLanguageParser.EventPropertyIdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#eventPropertyIdent}.
	 * @param ctx the parse tree
	 */
	void exitEventPropertyIdent(PatternLanguageParser.EventPropertyIdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(PatternLanguageParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(PatternLanguageParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#numberconstant}.
	 * @param ctx the parse tree
	 */
	void enterNumberconstant(PatternLanguageParser.NumberconstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#numberconstant}.
	 * @param ctx the parse tree
	 */
	void exitNumberconstant(PatternLanguageParser.NumberconstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#stringconstant}.
	 * @param ctx the parse tree
	 */
	void enterStringconstant(PatternLanguageParser.StringconstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#stringconstant}.
	 * @param ctx the parse tree
	 */
	void exitStringconstant(PatternLanguageParser.StringconstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#keywordAllowedIdent}.
	 * @param ctx the parse tree
	 */
	void enterKeywordAllowedIdent(PatternLanguageParser.KeywordAllowedIdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#keywordAllowedIdent}.
	 * @param ctx the parse tree
	 */
	void exitKeywordAllowedIdent(PatternLanguageParser.KeywordAllowedIdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatternLanguageParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(PatternLanguageParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatternLanguageParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(PatternLanguageParser.NumberContext ctx);
}