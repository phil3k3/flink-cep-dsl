// Generated from PatternLanguage.g4 by ANTLR 4.7.1

package at.datasciencelabs.pattern.generated;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PatternLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CREATE=1, WINDOW=2, IN_SET=3, BETWEEN=4, LIKE=5, REGEXP=6, ESCAPE=7, OR_EXPR=8, 
		AND_EXPR=9, NOT_EXPR=10, EVERY_EXPR=11, EVERY_DISTINCT_EXPR=12, WHERE=13, 
		AS=14, SUM=15, AVG=16, MAX=17, MIN=18, COALESCE=19, MEDIAN=20, STDDEV=21, 
		AVEDEV=22, COUNT=23, SELECT=24, CASE=25, ELSE=26, WHEN=27, THEN=28, END=29, 
		FROM=30, OUTER=31, INNER=32, JOIN=33, LEFT=34, RIGHT=35, FULL=36, ON=37, 
		IS=38, BY=39, GROUP=40, HAVING=41, DISTINCT=42, ALL=43, ANY=44, SOME=45, 
		OUTPUT=46, EVENTS=47, FIRST=48, LAST=49, INSERT=50, INTO=51, VALUES=52, 
		ORDER=53, ASC=54, DESC=55, RSTREAM=56, ISTREAM=57, IRSTREAM=58, SCHEMA=59, 
		UNIDIRECTIONAL=60, RETAINUNION=61, RETAININTERSECTION=62, PATTERN=63, 
		SQL=64, METADATASQL=65, PREVIOUS=66, PREVIOUSTAIL=67, PREVIOUSCOUNT=68, 
		PREVIOUSWINDOW=69, PRIOR=70, EXISTS=71, WEEKDAY=72, LW=73, INSTANCEOF=74, 
		TYPEOF=75, CAST=76, CURRENT_TIMESTAMP=77, DELETE=78, SNAPSHOT=79, SET=80, 
		VARIABLE=81, TABLE=82, UNTIL=83, AT=84, INDEX=85, TIMEPERIOD_YEAR=86, 
		TIMEPERIOD_YEARS=87, TIMEPERIOD_MONTH=88, TIMEPERIOD_MONTHS=89, TIMEPERIOD_WEEK=90, 
		TIMEPERIOD_WEEKS=91, TIMEPERIOD_DAY=92, TIMEPERIOD_DAYS=93, TIMEPERIOD_HOUR=94, 
		TIMEPERIOD_HOURS=95, TIMEPERIOD_MINUTE=96, TIMEPERIOD_MINUTES=97, TIMEPERIOD_SEC=98, 
		TIMEPERIOD_SECOND=99, TIMEPERIOD_SECONDS=100, TIMEPERIOD_MILLISEC=101, 
		TIMEPERIOD_MILLISECOND=102, TIMEPERIOD_MILLISECONDS=103, TIMEPERIOD_MICROSEC=104, 
		TIMEPERIOD_MICROSECOND=105, TIMEPERIOD_MICROSECONDS=106, BOOLEAN_TRUE=107, 
		BOOLEAN_FALSE=108, VALUE_NULL=109, ROW_LIMIT_EXPR=110, OFFSET=111, UPDATE=112, 
		MATCH_RECOGNIZE=113, MATCH_RECOGNIZE_PERMUTE=114, MEASURES=115, DEFINE=116, 
		PARTITION=117, MATCHES=118, AFTER=119, FOR=120, WHILE=121, USING=122, 
		MERGE=123, MATCHED=124, EXPRESSIONDECL=125, NEWKW=126, START=127, CONTEXT=128, 
		INITIATED=129, TERMINATED=130, DATAFLOW=131, CUBE=132, ROLLUP=133, GROUPING=134, 
		GROUPING_ID=135, SETS=136, FOLLOWMAX_BEGIN=137, FOLLOWMAX_END=138, FOLLOWED_BY=139, 
		GOES=140, EQUALS=141, SQL_NE=142, QUESTION=143, LPAREN=144, RPAREN=145, 
		LBRACK=146, RBRACK=147, LCURLY=148, RCURLY=149, COLON=150, COMMA=151, 
		EQUAL=152, LNOT=153, BNOT=154, NOT_EQUAL=155, DIV=156, DIV_ASSIGN=157, 
		PLUS=158, PLUS_ASSIGN=159, INC=160, MINUS=161, MINUS_ASSIGN=162, DEC=163, 
		STAR=164, STAR_ASSIGN=165, MOD=166, MOD_ASSIGN=167, GE=168, GT=169, LE=170, 
		LT=171, BXOR=172, BXOR_ASSIGN=173, BOR=174, BOR_ASSIGN=175, LOR=176, BAND=177, 
		BAND_ASSIGN=178, LAND=179, SEMI=180, DOT=181, NUM_LONG=182, NUM_DOUBLE=183, 
		NUM_FLOAT=184, ESCAPECHAR=185, ESCAPEBACKTICK=186, ATCHAR=187, HASHCHAR=188, 
		WS=189, SL_COMMENT=190, ML_COMMENT=191, TICKED_STRING_LITERAL=192, QUOTED_STRING_LITERAL=193, 
		STRING_LITERAL=194, IDENT=195, IntegerLiteral=196, FloatingPointLiteral=197;
	public static final int
		RULE_startPatternExpressionRule = 0, RULE_patternExpression = 1, RULE_orExpression = 2, 
		RULE_followedByOrNextRepeat = 3, RULE_followedByRepeat = 4, RULE_andExpression = 5, 
		RULE_matchUntilExpression = 6, RULE_qualifyExpression = 7, RULE_guardPostFix = 8, 
		RULE_patternFilterExpression = 9, RULE_patternFilterExpressionMandatory = 10, 
		RULE_patternFilterExpressionOptional = 11, RULE_quantifier = 12, RULE_number_quantifier_greedy = 13, 
		RULE_number_quantifier = 14, RULE_star_quantifier = 15, RULE_plus_quantifier = 16, 
		RULE_upper_bound = 17, RULE_upper_bound_limited = 18, RULE_upper_bound_unlimited = 19, 
		RULE_classIdentifier = 20, RULE_escapableStr = 21, RULE_expressionList = 22, 
		RULE_expression = 23, RULE_evalOrExpression = 24, RULE_evalAndExpression = 25, 
		RULE_negatedExpression = 26, RULE_evalEqualsExpression = 27, RULE_evalRelationalExpression = 28, 
		RULE_concatenationExpr = 29, RULE_additiveExpression = 30, RULE_multiplyExpression = 31, 
		RULE_unaryExpression = 32, RULE_eventProperty = 33, RULE_eventPropertyAtomic = 34, 
		RULE_eventPropertyIdent = 35, RULE_constant = 36, RULE_numberconstant = 37, 
		RULE_stringconstant = 38, RULE_keywordAllowedIdent = 39, RULE_number = 40;
	public static final String[] ruleNames = {
		"startPatternExpressionRule", "patternExpression", "orExpression", "followedByOrNextRepeat", 
		"followedByRepeat", "andExpression", "matchUntilExpression", "qualifyExpression", 
		"guardPostFix", "patternFilterExpression", "patternFilterExpressionMandatory", 
		"patternFilterExpressionOptional", "quantifier", "number_quantifier_greedy", 
		"number_quantifier", "star_quantifier", "plus_quantifier", "upper_bound", 
		"upper_bound_limited", "upper_bound_unlimited", "classIdentifier", "escapableStr", 
		"expressionList", "expression", "evalOrExpression", "evalAndExpression", 
		"negatedExpression", "evalEqualsExpression", "evalRelationalExpression", 
		"concatenationExpr", "additiveExpression", "multiplyExpression", "unaryExpression", 
		"eventProperty", "eventPropertyAtomic", "eventPropertyIdent", "constant", 
		"numberconstant", "stringconstant", "keywordAllowedIdent", "number"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'create'", "'window'", "'in'", "'between'", "'like'", "'regexp'", 
		"'escape'", "'or'", "'and'", "'not'", "'every'", "'every-distinct'", "'where'", 
		"'as'", "'sum'", "'avg'", "'max'", "'min'", "'coalesce'", "'median'", 
		"'stddev'", "'avedev'", "'count'", "'select'", "'case'", "'else'", "'when'", 
		"'then'", "'end'", "'from'", "'outer'", "'inner'", "'join'", "'left'", 
		"'right'", "'full'", "'on'", "'is'", "'by'", "'group'", "'having'", "'distinct'", 
		"'all'", "'any'", "'some'", "'output'", "'events'", "'first'", "'last'", 
		"'insert'", "'into'", "'values'", "'order'", "'asc'", "'desc'", "'rstream'", 
		"'istream'", "'irstream'", "'schema'", "'unidirectional'", "'retain-union'", 
		"'retain-intersection'", "'pattern'", "'sql'", "'metadatasql'", "'prev'", 
		"'prevtail'", "'prevcount'", "'prevwindow'", "'prior'", "'exists'", "'weekday'", 
		"'lastweekday'", "'instanceof'", "'typeof'", "'cast'", "'current_timestamp'", 
		"'delete'", "'snapshot'", "'set'", "'variable'", "'table'", "'until'", 
		"'at'", "'index'", "'year'", "'years'", "'month'", "'months'", "'week'", 
		"'weeks'", "'day'", "'days'", "'hour'", "'hours'", "'minute'", "'minutes'", 
		"'sec'", "'second'", "'seconds'", "'msec'", "'millisecond'", "'milliseconds'", 
		"'usec'", "'microsecond'", "'microseconds'", "'true'", "'false'", "'null'", 
		"'limit'", "'offset'", "'update'", "'match_recognize'", "'match_recognize_permute'", 
		"'measures'", "'define'", "'partition'", "'matches'", "'after'", "'for'", 
		"'while'", "'using'", "'merge'", "'matched'", "'expression'", "'new'", 
		"'start'", "'context'", "'initiated'", "'terminated'", "'dataflow'", "'cube'", 
		"'rollup'", "'grouping'", "'grouping_id'", "'sets'", "'-['", "']>'", "'->'", 
		"'=>'", "'='", "'<>'", "'?'", "'('", "')'", "'['", "']'", "'{'", "'}'", 
		"':'", "','", "'=='", "'!'", "'~'", "'!='", "'/'", "'/='", "'+'", "'+='", 
		"'++'", "'-'", "'-='", "'--'", "'*'", "'*='", "'%'", "'%='", "'>='", "'>'", 
		"'<='", "'<'", "'^'", "'^='", "'|'", "'|='", "'||'", "'&'", "'&='", "'&&'", 
		"';'", "'.'", "'\u18FF'", "'\u18FE'", "'\u18FD'", "'\\'", "'`'", "'@'", 
		"'#'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "CREATE", "WINDOW", "IN_SET", "BETWEEN", "LIKE", "REGEXP", "ESCAPE", 
		"OR_EXPR", "AND_EXPR", "NOT_EXPR", "EVERY_EXPR", "EVERY_DISTINCT_EXPR", 
		"WHERE", "AS", "SUM", "AVG", "MAX", "MIN", "COALESCE", "MEDIAN", "STDDEV", 
		"AVEDEV", "COUNT", "SELECT", "CASE", "ELSE", "WHEN", "THEN", "END", "FROM", 
		"OUTER", "INNER", "JOIN", "LEFT", "RIGHT", "FULL", "ON", "IS", "BY", "GROUP", 
		"HAVING", "DISTINCT", "ALL", "ANY", "SOME", "OUTPUT", "EVENTS", "FIRST", 
		"LAST", "INSERT", "INTO", "VALUES", "ORDER", "ASC", "DESC", "RSTREAM", 
		"ISTREAM", "IRSTREAM", "SCHEMA", "UNIDIRECTIONAL", "RETAINUNION", "RETAININTERSECTION", 
		"PATTERN", "SQL", "METADATASQL", "PREVIOUS", "PREVIOUSTAIL", "PREVIOUSCOUNT", 
		"PREVIOUSWINDOW", "PRIOR", "EXISTS", "WEEKDAY", "LW", "INSTANCEOF", "TYPEOF", 
		"CAST", "CURRENT_TIMESTAMP", "DELETE", "SNAPSHOT", "SET", "VARIABLE", 
		"TABLE", "UNTIL", "AT", "INDEX", "TIMEPERIOD_YEAR", "TIMEPERIOD_YEARS", 
		"TIMEPERIOD_MONTH", "TIMEPERIOD_MONTHS", "TIMEPERIOD_WEEK", "TIMEPERIOD_WEEKS", 
		"TIMEPERIOD_DAY", "TIMEPERIOD_DAYS", "TIMEPERIOD_HOUR", "TIMEPERIOD_HOURS", 
		"TIMEPERIOD_MINUTE", "TIMEPERIOD_MINUTES", "TIMEPERIOD_SEC", "TIMEPERIOD_SECOND", 
		"TIMEPERIOD_SECONDS", "TIMEPERIOD_MILLISEC", "TIMEPERIOD_MILLISECOND", 
		"TIMEPERIOD_MILLISECONDS", "TIMEPERIOD_MICROSEC", "TIMEPERIOD_MICROSECOND", 
		"TIMEPERIOD_MICROSECONDS", "BOOLEAN_TRUE", "BOOLEAN_FALSE", "VALUE_NULL", 
		"ROW_LIMIT_EXPR", "OFFSET", "UPDATE", "MATCH_RECOGNIZE", "MATCH_RECOGNIZE_PERMUTE", 
		"MEASURES", "DEFINE", "PARTITION", "MATCHES", "AFTER", "FOR", "WHILE", 
		"USING", "MERGE", "MATCHED", "EXPRESSIONDECL", "NEWKW", "START", "CONTEXT", 
		"INITIATED", "TERMINATED", "DATAFLOW", "CUBE", "ROLLUP", "GROUPING", "GROUPING_ID", 
		"SETS", "FOLLOWMAX_BEGIN", "FOLLOWMAX_END", "FOLLOWED_BY", "GOES", "EQUALS", 
		"SQL_NE", "QUESTION", "LPAREN", "RPAREN", "LBRACK", "RBRACK", "LCURLY", 
		"RCURLY", "COLON", "COMMA", "EQUAL", "LNOT", "BNOT", "NOT_EQUAL", "DIV", 
		"DIV_ASSIGN", "PLUS", "PLUS_ASSIGN", "INC", "MINUS", "MINUS_ASSIGN", "DEC", 
		"STAR", "STAR_ASSIGN", "MOD", "MOD_ASSIGN", "GE", "GT", "LE", "LT", "BXOR", 
		"BXOR_ASSIGN", "BOR", "BOR_ASSIGN", "LOR", "BAND", "BAND_ASSIGN", "LAND", 
		"SEMI", "DOT", "NUM_LONG", "NUM_DOUBLE", "NUM_FLOAT", "ESCAPECHAR", "ESCAPEBACKTICK", 
		"ATCHAR", "HASHCHAR", "WS", "SL_COMMENT", "ML_COMMENT", "TICKED_STRING_LITERAL", 
		"QUOTED_STRING_LITERAL", "STRING_LITERAL", "IDENT", "IntegerLiteral", 
		"FloatingPointLiteral"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "PatternLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PatternLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartPatternExpressionRuleContext extends ParserRuleContext {
		public PatternExpressionContext patternExpression() {
			return getRuleContext(PatternExpressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PatternLanguageParser.EOF, 0); }
		public StartPatternExpressionRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_startPatternExpressionRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterStartPatternExpressionRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitStartPatternExpressionRule(this);
		}
	}

	public final StartPatternExpressionRuleContext startPatternExpressionRule() throws RecognitionException {
		StartPatternExpressionRuleContext _localctx = new StartPatternExpressionRuleContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_startPatternExpressionRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			patternExpression();
			setState(83);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PatternExpressionContext extends ParserRuleContext {
		public OrExpressionContext orExpression() {
			return getRuleContext(OrExpressionContext.class,0);
		}
		public List<FollowedByOrNextRepeatContext> followedByOrNextRepeat() {
			return getRuleContexts(FollowedByOrNextRepeatContext.class);
		}
		public FollowedByOrNextRepeatContext followedByOrNextRepeat(int i) {
			return getRuleContext(FollowedByOrNextRepeatContext.class,i);
		}
		public PatternExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_patternExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterPatternExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitPatternExpression(this);
		}
	}

	public final PatternExpressionContext patternExpression() throws RecognitionException {
		PatternExpressionContext _localctx = new PatternExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_patternExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			orExpression();
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT_EXPR) | (1L << EVERY_EXPR) | (1L << EVENTS))) != 0) || ((((_la - 139)) & ~0x3f) == 0 && ((1L << (_la - 139)) & ((1L << (FOLLOWED_BY - 139)) | (1L << (LPAREN - 139)) | (1L << (TICKED_STRING_LITERAL - 139)) | (1L << (IDENT - 139)))) != 0)) {
				{
				{
				setState(86);
				followedByOrNextRepeat();
				}
				}
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrExpressionContext extends ParserRuleContext {
		public Token o;
		public List<AndExpressionContext> andExpression() {
			return getRuleContexts(AndExpressionContext.class);
		}
		public AndExpressionContext andExpression(int i) {
			return getRuleContext(AndExpressionContext.class,i);
		}
		public List<TerminalNode> OR_EXPR() { return getTokens(PatternLanguageParser.OR_EXPR); }
		public TerminalNode OR_EXPR(int i) {
			return getToken(PatternLanguageParser.OR_EXPR, i);
		}
		public OrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitOrExpression(this);
		}
	}

	public final OrExpressionContext orExpression() throws RecognitionException {
		OrExpressionContext _localctx = new OrExpressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_orExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			andExpression();
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR_EXPR) {
				{
				{
				setState(93);
				((OrExpressionContext)_localctx).o = match(OR_EXPR);
				setState(94);
				andExpression();
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FollowedByOrNextRepeatContext extends ParserRuleContext {
		public FollowedByRepeatContext followedByRepeat() {
			return getRuleContext(FollowedByRepeatContext.class,0);
		}
		public OrExpressionContext orExpression() {
			return getRuleContext(OrExpressionContext.class,0);
		}
		public FollowedByOrNextRepeatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_followedByOrNextRepeat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterFollowedByOrNextRepeat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitFollowedByOrNextRepeat(this);
		}
	}

	public final FollowedByOrNextRepeatContext followedByOrNextRepeat() throws RecognitionException {
		FollowedByOrNextRepeatContext _localctx = new FollowedByOrNextRepeatContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_followedByOrNextRepeat);
		try {
			setState(102);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOLLOWED_BY:
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				followedByRepeat();
				}
				break;
			case NOT_EXPR:
			case EVERY_EXPR:
			case EVENTS:
			case LPAREN:
			case TICKED_STRING_LITERAL:
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				orExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FollowedByRepeatContext extends ParserRuleContext {
		public Token f;
		public OrExpressionContext orExpression() {
			return getRuleContext(OrExpressionContext.class,0);
		}
		public TerminalNode FOLLOWED_BY() { return getToken(PatternLanguageParser.FOLLOWED_BY, 0); }
		public FollowedByRepeatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_followedByRepeat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterFollowedByRepeat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitFollowedByRepeat(this);
		}
	}

	public final FollowedByRepeatContext followedByRepeat() throws RecognitionException {
		FollowedByRepeatContext _localctx = new FollowedByRepeatContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_followedByRepeat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			((FollowedByRepeatContext)_localctx).f = match(FOLLOWED_BY);
			setState(105);
			orExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AndExpressionContext extends ParserRuleContext {
		public Token a;
		public List<MatchUntilExpressionContext> matchUntilExpression() {
			return getRuleContexts(MatchUntilExpressionContext.class);
		}
		public MatchUntilExpressionContext matchUntilExpression(int i) {
			return getRuleContext(MatchUntilExpressionContext.class,i);
		}
		public List<TerminalNode> AND_EXPR() { return getTokens(PatternLanguageParser.AND_EXPR); }
		public TerminalNode AND_EXPR(int i) {
			return getToken(PatternLanguageParser.AND_EXPR, i);
		}
		public AndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitAndExpression(this);
		}
	}

	public final AndExpressionContext andExpression() throws RecognitionException {
		AndExpressionContext _localctx = new AndExpressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_andExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			matchUntilExpression();
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND_EXPR) {
				{
				{
				setState(108);
				((AndExpressionContext)_localctx).a = match(AND_EXPR);
				setState(109);
				matchUntilExpression();
				}
				}
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MatchUntilExpressionContext extends ParserRuleContext {
		public QualifyExpressionContext qualifyExpression() {
			return getRuleContext(QualifyExpressionContext.class,0);
		}
		public MatchUntilExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchUntilExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterMatchUntilExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitMatchUntilExpression(this);
		}
	}

	public final MatchUntilExpressionContext matchUntilExpression() throws RecognitionException {
		MatchUntilExpressionContext _localctx = new MatchUntilExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_matchUntilExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			qualifyExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QualifyExpressionContext extends ParserRuleContext {
		public Token e;
		public Token n;
		public GuardPostFixContext guardPostFix() {
			return getRuleContext(GuardPostFixContext.class,0);
		}
		public TerminalNode EVERY_EXPR() { return getToken(PatternLanguageParser.EVERY_EXPR, 0); }
		public TerminalNode NOT_EXPR() { return getToken(PatternLanguageParser.NOT_EXPR, 0); }
		public QualifyExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifyExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterQualifyExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitQualifyExpression(this);
		}
	}

	public final QualifyExpressionContext qualifyExpression() throws RecognitionException {
		QualifyExpressionContext _localctx = new QualifyExpressionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_qualifyExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EVERY_EXPR:
				{
				setState(117);
				((QualifyExpressionContext)_localctx).e = match(EVERY_EXPR);
				}
				break;
			case NOT_EXPR:
				{
				setState(118);
				((QualifyExpressionContext)_localctx).n = match(NOT_EXPR);
				}
				break;
			case EVENTS:
			case LPAREN:
			case TICKED_STRING_LITERAL:
			case IDENT:
				break;
			default:
				break;
			}
			setState(121);
			guardPostFix();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GuardPostFixContext extends ParserRuleContext {
		public Token l;
		public PatternFilterExpressionContext patternFilterExpression() {
			return getRuleContext(PatternFilterExpressionContext.class,0);
		}
		public PatternExpressionContext patternExpression() {
			return getRuleContext(PatternExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PatternLanguageParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(PatternLanguageParser.LPAREN, 0); }
		public GuardPostFixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guardPostFix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterGuardPostFix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitGuardPostFix(this);
		}
	}

	public final GuardPostFixContext guardPostFix() throws RecognitionException {
		GuardPostFixContext _localctx = new GuardPostFixContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_guardPostFix);
		try {
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EVENTS:
			case TICKED_STRING_LITERAL:
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				patternFilterExpression();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				((GuardPostFixContext)_localctx).l = match(LPAREN);
				setState(125);
				patternExpression();
				setState(126);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PatternFilterExpressionContext extends ParserRuleContext {
		public PatternFilterExpressionOptionalContext patternFilterExpressionOptional() {
			return getRuleContext(PatternFilterExpressionOptionalContext.class,0);
		}
		public PatternFilterExpressionMandatoryContext patternFilterExpressionMandatory() {
			return getRuleContext(PatternFilterExpressionMandatoryContext.class,0);
		}
		public PatternFilterExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_patternFilterExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterPatternFilterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitPatternFilterExpression(this);
		}
	}

	public final PatternFilterExpressionContext patternFilterExpression() throws RecognitionException {
		PatternFilterExpressionContext _localctx = new PatternFilterExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_patternFilterExpression);
		try {
			setState(132);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				patternFilterExpressionOptional();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				patternFilterExpressionMandatory();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PatternFilterExpressionMandatoryContext extends ParserRuleContext {
		public Token i;
		public ClassIdentifierContext classIdentifier() {
			return getRuleContext(ClassIdentifierContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(PatternLanguageParser.EQUALS, 0); }
		public QuantifierContext quantifier() {
			return getRuleContext(QuantifierContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(PatternLanguageParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PatternLanguageParser.RPAREN, 0); }
		public TerminalNode IDENT() { return getToken(PatternLanguageParser.IDENT, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public PatternFilterExpressionMandatoryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_patternFilterExpressionMandatory; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterPatternFilterExpressionMandatory(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitPatternFilterExpressionMandatory(this);
		}
	}

	public final PatternFilterExpressionMandatoryContext patternFilterExpressionMandatory() throws RecognitionException {
		PatternFilterExpressionMandatoryContext _localctx = new PatternFilterExpressionMandatoryContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_patternFilterExpressionMandatory);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(134);
				((PatternFilterExpressionMandatoryContext)_localctx).i = match(IDENT);
				setState(135);
				match(EQUALS);
				}
				break;
			}
			setState(138);
			classIdentifier();
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 148)) & ~0x3f) == 0 && ((1L << (_la - 148)) & ((1L << (LCURLY - 148)) | (1L << (PLUS - 148)) | (1L << (STAR - 148)))) != 0)) {
				{
				setState(139);
				quantifier();
				}
			}

			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(142);
				match(LPAREN);
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 2)) & ~0x3f) == 0 && ((1L << (_la - 2)) & ((1L << (WINDOW - 2)) | (1L << (ESCAPE - 2)) | (1L << (NOT_EXPR - 2)) | (1L << (EVERY_EXPR - 2)) | (1L << (SUM - 2)) | (1L << (AVG - 2)) | (1L << (MAX - 2)) | (1L << (MIN - 2)) | (1L << (COALESCE - 2)) | (1L << (MEDIAN - 2)) | (1L << (STDDEV - 2)) | (1L << (AVEDEV - 2)) | (1L << (COUNT - 2)) | (1L << (OUTER - 2)) | (1L << (JOIN - 2)) | (1L << (LEFT - 2)) | (1L << (RIGHT - 2)) | (1L << (FULL - 2)) | (1L << (EVENTS - 2)) | (1L << (FIRST - 2)) | (1L << (LAST - 2)) | (1L << (SCHEMA - 2)) | (1L << (UNIDIRECTIONAL - 2)) | (1L << (RETAINUNION - 2)) | (1L << (RETAININTERSECTION - 2)) | (1L << (PATTERN - 2)) | (1L << (SQL - 2)) | (1L << (METADATASQL - 2)))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (PREVIOUS - 66)) | (1L << (PREVIOUSTAIL - 66)) | (1L << (PRIOR - 66)) | (1L << (WEEKDAY - 66)) | (1L << (LW - 66)) | (1L << (INSTANCEOF - 66)) | (1L << (TYPEOF - 66)) | (1L << (CAST - 66)) | (1L << (SNAPSHOT - 66)) | (1L << (VARIABLE - 66)) | (1L << (TABLE - 66)) | (1L << (UNTIL - 66)) | (1L << (AT - 66)) | (1L << (INDEX - 66)) | (1L << (BOOLEAN_TRUE - 66)) | (1L << (BOOLEAN_FALSE - 66)) | (1L << (VALUE_NULL - 66)) | (1L << (DEFINE - 66)) | (1L << (PARTITION - 66)) | (1L << (MATCHES - 66)) | (1L << (FOR - 66)) | (1L << (WHILE - 66)) | (1L << (USING - 66)) | (1L << (MERGE - 66)) | (1L << (MATCHED - 66)) | (1L << (CONTEXT - 66)))) != 0) || ((((_la - 158)) & ~0x3f) == 0 && ((1L << (_la - 158)) & ((1L << (PLUS - 158)) | (1L << (MINUS - 158)) | (1L << (TICKED_STRING_LITERAL - 158)) | (1L << (QUOTED_STRING_LITERAL - 158)) | (1L << (STRING_LITERAL - 158)) | (1L << (IDENT - 158)) | (1L << (IntegerLiteral - 158)) | (1L << (FloatingPointLiteral - 158)))) != 0)) {
					{
					setState(143);
					expressionList();
					}
				}

				setState(146);
				match(RPAREN);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PatternFilterExpressionOptionalContext extends ParserRuleContext {
		public Token i;
		public ClassIdentifierContext classIdentifier() {
			return getRuleContext(ClassIdentifierContext.class,0);
		}
		public TerminalNode QUESTION() { return getToken(PatternLanguageParser.QUESTION, 0); }
		public TerminalNode EQUALS() { return getToken(PatternLanguageParser.EQUALS, 0); }
		public QuantifierContext quantifier() {
			return getRuleContext(QuantifierContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(PatternLanguageParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PatternLanguageParser.RPAREN, 0); }
		public TerminalNode IDENT() { return getToken(PatternLanguageParser.IDENT, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public PatternFilterExpressionOptionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_patternFilterExpressionOptional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterPatternFilterExpressionOptional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitPatternFilterExpressionOptional(this);
		}
	}

	public final PatternFilterExpressionOptionalContext patternFilterExpressionOptional() throws RecognitionException {
		PatternFilterExpressionOptionalContext _localctx = new PatternFilterExpressionOptionalContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_patternFilterExpressionOptional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(149);
				((PatternFilterExpressionOptionalContext)_localctx).i = match(IDENT);
				setState(150);
				match(EQUALS);
				}
				break;
			}
			setState(153);
			classIdentifier();
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 148)) & ~0x3f) == 0 && ((1L << (_la - 148)) & ((1L << (LCURLY - 148)) | (1L << (PLUS - 148)) | (1L << (STAR - 148)))) != 0)) {
				{
				setState(154);
				quantifier();
				}
			}

			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(157);
				match(LPAREN);
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 2)) & ~0x3f) == 0 && ((1L << (_la - 2)) & ((1L << (WINDOW - 2)) | (1L << (ESCAPE - 2)) | (1L << (NOT_EXPR - 2)) | (1L << (EVERY_EXPR - 2)) | (1L << (SUM - 2)) | (1L << (AVG - 2)) | (1L << (MAX - 2)) | (1L << (MIN - 2)) | (1L << (COALESCE - 2)) | (1L << (MEDIAN - 2)) | (1L << (STDDEV - 2)) | (1L << (AVEDEV - 2)) | (1L << (COUNT - 2)) | (1L << (OUTER - 2)) | (1L << (JOIN - 2)) | (1L << (LEFT - 2)) | (1L << (RIGHT - 2)) | (1L << (FULL - 2)) | (1L << (EVENTS - 2)) | (1L << (FIRST - 2)) | (1L << (LAST - 2)) | (1L << (SCHEMA - 2)) | (1L << (UNIDIRECTIONAL - 2)) | (1L << (RETAINUNION - 2)) | (1L << (RETAININTERSECTION - 2)) | (1L << (PATTERN - 2)) | (1L << (SQL - 2)) | (1L << (METADATASQL - 2)))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (PREVIOUS - 66)) | (1L << (PREVIOUSTAIL - 66)) | (1L << (PRIOR - 66)) | (1L << (WEEKDAY - 66)) | (1L << (LW - 66)) | (1L << (INSTANCEOF - 66)) | (1L << (TYPEOF - 66)) | (1L << (CAST - 66)) | (1L << (SNAPSHOT - 66)) | (1L << (VARIABLE - 66)) | (1L << (TABLE - 66)) | (1L << (UNTIL - 66)) | (1L << (AT - 66)) | (1L << (INDEX - 66)) | (1L << (BOOLEAN_TRUE - 66)) | (1L << (BOOLEAN_FALSE - 66)) | (1L << (VALUE_NULL - 66)) | (1L << (DEFINE - 66)) | (1L << (PARTITION - 66)) | (1L << (MATCHES - 66)) | (1L << (FOR - 66)) | (1L << (WHILE - 66)) | (1L << (USING - 66)) | (1L << (MERGE - 66)) | (1L << (MATCHED - 66)) | (1L << (CONTEXT - 66)))) != 0) || ((((_la - 158)) & ~0x3f) == 0 && ((1L << (_la - 158)) & ((1L << (PLUS - 158)) | (1L << (MINUS - 158)) | (1L << (TICKED_STRING_LITERAL - 158)) | (1L << (QUOTED_STRING_LITERAL - 158)) | (1L << (STRING_LITERAL - 158)) | (1L << (IDENT - 158)) | (1L << (IntegerLiteral - 158)) | (1L << (FloatingPointLiteral - 158)))) != 0)) {
					{
					setState(158);
					expressionList();
					}
				}

				setState(161);
				match(RPAREN);
				}
			}

			setState(164);
			match(QUESTION);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantifierContext extends ParserRuleContext {
		public Plus_quantifierContext plus_quantifier() {
			return getRuleContext(Plus_quantifierContext.class,0);
		}
		public Star_quantifierContext star_quantifier() {
			return getRuleContext(Star_quantifierContext.class,0);
		}
		public Number_quantifierContext number_quantifier() {
			return getRuleContext(Number_quantifierContext.class,0);
		}
		public Number_quantifier_greedyContext number_quantifier_greedy() {
			return getRuleContext(Number_quantifier_greedyContext.class,0);
		}
		public QuantifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterQuantifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitQuantifier(this);
		}
	}

	public final QuantifierContext quantifier() throws RecognitionException {
		QuantifierContext _localctx = new QuantifierContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_quantifier);
		try {
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				plus_quantifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				star_quantifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(168);
				number_quantifier();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(169);
				number_quantifier_greedy();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Number_quantifier_greedyContext extends ParserRuleContext {
		public Token s;
		public Token t;
		public NumberconstantContext numberconstant() {
			return getRuleContext(NumberconstantContext.class,0);
		}
		public TerminalNode QUESTION() { return getToken(PatternLanguageParser.QUESTION, 0); }
		public TerminalNode LCURLY() { return getToken(PatternLanguageParser.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(PatternLanguageParser.RCURLY, 0); }
		public Upper_boundContext upper_bound() {
			return getRuleContext(Upper_boundContext.class,0);
		}
		public Number_quantifier_greedyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number_quantifier_greedy; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterNumber_quantifier_greedy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitNumber_quantifier_greedy(this);
		}
	}

	public final Number_quantifier_greedyContext number_quantifier_greedy() throws RecognitionException {
		Number_quantifier_greedyContext _localctx = new Number_quantifier_greedyContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_number_quantifier_greedy);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			((Number_quantifier_greedyContext)_localctx).s = match(LCURLY);
			setState(173);
			numberconstant();
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(174);
				upper_bound();
				}
			}

			setState(177);
			((Number_quantifier_greedyContext)_localctx).t = match(RCURLY);
			setState(178);
			match(QUESTION);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Number_quantifierContext extends ParserRuleContext {
		public Token s;
		public Token t;
		public NumberconstantContext numberconstant() {
			return getRuleContext(NumberconstantContext.class,0);
		}
		public TerminalNode LCURLY() { return getToken(PatternLanguageParser.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(PatternLanguageParser.RCURLY, 0); }
		public Upper_boundContext upper_bound() {
			return getRuleContext(Upper_boundContext.class,0);
		}
		public Number_quantifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number_quantifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterNumber_quantifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitNumber_quantifier(this);
		}
	}

	public final Number_quantifierContext number_quantifier() throws RecognitionException {
		Number_quantifierContext _localctx = new Number_quantifierContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_number_quantifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			((Number_quantifierContext)_localctx).s = match(LCURLY);
			setState(181);
			numberconstant();
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(182);
				upper_bound();
				}
			}

			setState(185);
			((Number_quantifierContext)_localctx).t = match(RCURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Star_quantifierContext extends ParserRuleContext {
		public Token r;
		public TerminalNode STAR() { return getToken(PatternLanguageParser.STAR, 0); }
		public Star_quantifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_star_quantifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterStar_quantifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitStar_quantifier(this);
		}
	}

	public final Star_quantifierContext star_quantifier() throws RecognitionException {
		Star_quantifierContext _localctx = new Star_quantifierContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_star_quantifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			((Star_quantifierContext)_localctx).r = match(STAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Plus_quantifierContext extends ParserRuleContext {
		public Token q;
		public TerminalNode PLUS() { return getToken(PatternLanguageParser.PLUS, 0); }
		public Plus_quantifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plus_quantifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterPlus_quantifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitPlus_quantifier(this);
		}
	}

	public final Plus_quantifierContext plus_quantifier() throws RecognitionException {
		Plus_quantifierContext _localctx = new Plus_quantifierContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_plus_quantifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			((Plus_quantifierContext)_localctx).q = match(PLUS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Upper_boundContext extends ParserRuleContext {
		public Token z;
		public TerminalNode COMMA() { return getToken(PatternLanguageParser.COMMA, 0); }
		public Upper_bound_unlimitedContext upper_bound_unlimited() {
			return getRuleContext(Upper_bound_unlimitedContext.class,0);
		}
		public Upper_bound_limitedContext upper_bound_limited() {
			return getRuleContext(Upper_bound_limitedContext.class,0);
		}
		public Upper_boundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_upper_bound; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterUpper_bound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitUpper_bound(this);
		}
	}

	public final Upper_boundContext upper_bound() throws RecognitionException {
		Upper_boundContext _localctx = new Upper_boundContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_upper_bound);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			((Upper_boundContext)_localctx).z = match(COMMA);
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(192);
				upper_bound_unlimited();
				}
				break;
			case 2:
				{
				setState(193);
				upper_bound_limited();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Upper_bound_limitedContext extends ParserRuleContext {
		public NumberconstantContext numberconstant() {
			return getRuleContext(NumberconstantContext.class,0);
		}
		public Upper_bound_limitedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_upper_bound_limited; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterUpper_bound_limited(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitUpper_bound_limited(this);
		}
	}

	public final Upper_bound_limitedContext upper_bound_limited() throws RecognitionException {
		Upper_bound_limitedContext _localctx = new Upper_bound_limitedContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_upper_bound_limited);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			numberconstant();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Upper_bound_unlimitedContext extends ParserRuleContext {
		public Token k;
		public TerminalNode PLUS() { return getToken(PatternLanguageParser.PLUS, 0); }
		public Upper_bound_unlimitedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_upper_bound_unlimited; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterUpper_bound_unlimited(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitUpper_bound_unlimited(this);
		}
	}

	public final Upper_bound_unlimitedContext upper_bound_unlimited() throws RecognitionException {
		Upper_bound_unlimitedContext _localctx = new Upper_bound_unlimitedContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_upper_bound_unlimited);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			((Upper_bound_unlimitedContext)_localctx).k = match(PLUS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassIdentifierContext extends ParserRuleContext {
		public EscapableStrContext i1;
		public EscapableStrContext i2;
		public List<EscapableStrContext> escapableStr() {
			return getRuleContexts(EscapableStrContext.class);
		}
		public EscapableStrContext escapableStr(int i) {
			return getRuleContext(EscapableStrContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(PatternLanguageParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(PatternLanguageParser.DOT, i);
		}
		public ClassIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterClassIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitClassIdentifier(this);
		}
	}

	public final ClassIdentifierContext classIdentifier() throws RecognitionException {
		ClassIdentifierContext _localctx = new ClassIdentifierContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_classIdentifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			((ClassIdentifierContext)_localctx).i1 = escapableStr();
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(201);
				match(DOT);
				setState(202);
				((ClassIdentifierContext)_localctx).i2 = escapableStr();
				}
				}
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EscapableStrContext extends ParserRuleContext {
		public Token i1;
		public Token i2;
		public Token i3;
		public TerminalNode IDENT() { return getToken(PatternLanguageParser.IDENT, 0); }
		public TerminalNode EVENTS() { return getToken(PatternLanguageParser.EVENTS, 0); }
		public TerminalNode TICKED_STRING_LITERAL() { return getToken(PatternLanguageParser.TICKED_STRING_LITERAL, 0); }
		public EscapableStrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_escapableStr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterEscapableStr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitEscapableStr(this);
		}
	}

	public final EscapableStrContext escapableStr() throws RecognitionException {
		EscapableStrContext _localctx = new EscapableStrContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_escapableStr);
		try {
			setState(211);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(208);
				((EscapableStrContext)_localctx).i1 = match(IDENT);
				}
				break;
			case EVENTS:
				enterOuterAlt(_localctx, 2);
				{
				setState(209);
				((EscapableStrContext)_localctx).i2 = match(EVENTS);
				}
				break;
			case TICKED_STRING_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(210);
				((EscapableStrContext)_localctx).i3 = match(TICKED_STRING_LITERAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PatternLanguageParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PatternLanguageParser.COMMA, i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitExpressionList(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			expression();
			setState(218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(214);
				match(COMMA);
				setState(215);
				expression();
				}
				}
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public EvalOrExpressionContext evalOrExpression() {
			return getRuleContext(EvalOrExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			evalOrExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EvalOrExpressionContext extends ParserRuleContext {
		public Token op;
		public List<EvalAndExpressionContext> evalAndExpression() {
			return getRuleContexts(EvalAndExpressionContext.class);
		}
		public EvalAndExpressionContext evalAndExpression(int i) {
			return getRuleContext(EvalAndExpressionContext.class,i);
		}
		public List<TerminalNode> OR_EXPR() { return getTokens(PatternLanguageParser.OR_EXPR); }
		public TerminalNode OR_EXPR(int i) {
			return getToken(PatternLanguageParser.OR_EXPR, i);
		}
		public EvalOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_evalOrExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterEvalOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitEvalOrExpression(this);
		}
	}

	public final EvalOrExpressionContext evalOrExpression() throws RecognitionException {
		EvalOrExpressionContext _localctx = new EvalOrExpressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_evalOrExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			evalAndExpression();
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR_EXPR) {
				{
				{
				setState(224);
				((EvalOrExpressionContext)_localctx).op = match(OR_EXPR);
				setState(225);
				evalAndExpression();
				}
				}
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EvalAndExpressionContext extends ParserRuleContext {
		public Token op;
		public List<NegatedExpressionContext> negatedExpression() {
			return getRuleContexts(NegatedExpressionContext.class);
		}
		public NegatedExpressionContext negatedExpression(int i) {
			return getRuleContext(NegatedExpressionContext.class,i);
		}
		public List<TerminalNode> AND_EXPR() { return getTokens(PatternLanguageParser.AND_EXPR); }
		public TerminalNode AND_EXPR(int i) {
			return getToken(PatternLanguageParser.AND_EXPR, i);
		}
		public EvalAndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_evalAndExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterEvalAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitEvalAndExpression(this);
		}
	}

	public final EvalAndExpressionContext evalAndExpression() throws RecognitionException {
		EvalAndExpressionContext _localctx = new EvalAndExpressionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_evalAndExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			negatedExpression();
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND_EXPR) {
				{
				{
				setState(232);
				((EvalAndExpressionContext)_localctx).op = match(AND_EXPR);
				setState(233);
				negatedExpression();
				}
				}
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NegatedExpressionContext extends ParserRuleContext {
		public EvalEqualsExpressionContext evalEqualsExpression() {
			return getRuleContext(EvalEqualsExpressionContext.class,0);
		}
		public TerminalNode NOT_EXPR() { return getToken(PatternLanguageParser.NOT_EXPR, 0); }
		public NegatedExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negatedExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterNegatedExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitNegatedExpression(this);
		}
	}

	public final NegatedExpressionContext negatedExpression() throws RecognitionException {
		NegatedExpressionContext _localctx = new NegatedExpressionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_negatedExpression);
		try {
			setState(242);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WINDOW:
			case ESCAPE:
			case EVERY_EXPR:
			case SUM:
			case AVG:
			case MAX:
			case MIN:
			case COALESCE:
			case MEDIAN:
			case STDDEV:
			case AVEDEV:
			case COUNT:
			case OUTER:
			case JOIN:
			case LEFT:
			case RIGHT:
			case FULL:
			case EVENTS:
			case FIRST:
			case LAST:
			case SCHEMA:
			case UNIDIRECTIONAL:
			case RETAINUNION:
			case RETAININTERSECTION:
			case PATTERN:
			case SQL:
			case METADATASQL:
			case PREVIOUS:
			case PREVIOUSTAIL:
			case PRIOR:
			case WEEKDAY:
			case LW:
			case INSTANCEOF:
			case TYPEOF:
			case CAST:
			case SNAPSHOT:
			case VARIABLE:
			case TABLE:
			case UNTIL:
			case AT:
			case INDEX:
			case BOOLEAN_TRUE:
			case BOOLEAN_FALSE:
			case VALUE_NULL:
			case DEFINE:
			case PARTITION:
			case MATCHES:
			case FOR:
			case WHILE:
			case USING:
			case MERGE:
			case MATCHED:
			case CONTEXT:
			case PLUS:
			case MINUS:
			case TICKED_STRING_LITERAL:
			case QUOTED_STRING_LITERAL:
			case STRING_LITERAL:
			case IDENT:
			case IntegerLiteral:
			case FloatingPointLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(239);
				evalEqualsExpression();
				}
				break;
			case NOT_EXPR:
				enterOuterAlt(_localctx, 2);
				{
				setState(240);
				match(NOT_EXPR);
				setState(241);
				evalEqualsExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EvalEqualsExpressionContext extends ParserRuleContext {
		public Token eq;
		public Token is;
		public Token isnot;
		public Token sqlne;
		public Token ne;
		public Token a;
		public List<EvalRelationalExpressionContext> evalRelationalExpression() {
			return getRuleContexts(EvalRelationalExpressionContext.class);
		}
		public EvalRelationalExpressionContext evalRelationalExpression(int i) {
			return getRuleContext(EvalRelationalExpressionContext.class,i);
		}
		public List<TerminalNode> NOT_EXPR() { return getTokens(PatternLanguageParser.NOT_EXPR); }
		public TerminalNode NOT_EXPR(int i) {
			return getToken(PatternLanguageParser.NOT_EXPR, i);
		}
		public List<TerminalNode> EQUALS() { return getTokens(PatternLanguageParser.EQUALS); }
		public TerminalNode EQUALS(int i) {
			return getToken(PatternLanguageParser.EQUALS, i);
		}
		public List<TerminalNode> IS() { return getTokens(PatternLanguageParser.IS); }
		public TerminalNode IS(int i) {
			return getToken(PatternLanguageParser.IS, i);
		}
		public List<TerminalNode> SQL_NE() { return getTokens(PatternLanguageParser.SQL_NE); }
		public TerminalNode SQL_NE(int i) {
			return getToken(PatternLanguageParser.SQL_NE, i);
		}
		public List<TerminalNode> NOT_EQUAL() { return getTokens(PatternLanguageParser.NOT_EQUAL); }
		public TerminalNode NOT_EQUAL(int i) {
			return getToken(PatternLanguageParser.NOT_EQUAL, i);
		}
		public List<TerminalNode> ANY() { return getTokens(PatternLanguageParser.ANY); }
		public TerminalNode ANY(int i) {
			return getToken(PatternLanguageParser.ANY, i);
		}
		public List<TerminalNode> SOME() { return getTokens(PatternLanguageParser.SOME); }
		public TerminalNode SOME(int i) {
			return getToken(PatternLanguageParser.SOME, i);
		}
		public List<TerminalNode> ALL() { return getTokens(PatternLanguageParser.ALL); }
		public TerminalNode ALL(int i) {
			return getToken(PatternLanguageParser.ALL, i);
		}
		public List<TerminalNode> LPAREN() { return getTokens(PatternLanguageParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(PatternLanguageParser.LPAREN, i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(PatternLanguageParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(PatternLanguageParser.RPAREN, i);
		}
		public List<ExpressionListContext> expressionList() {
			return getRuleContexts(ExpressionListContext.class);
		}
		public ExpressionListContext expressionList(int i) {
			return getRuleContext(ExpressionListContext.class,i);
		}
		public EvalEqualsExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_evalEqualsExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterEvalEqualsExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitEvalEqualsExpression(this);
		}
	}

	public final EvalEqualsExpressionContext evalEqualsExpression() throws RecognitionException {
		EvalEqualsExpressionContext _localctx = new EvalEqualsExpressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_evalEqualsExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			evalRelationalExpression();
			setState(268);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IS || ((((_la - 141)) & ~0x3f) == 0 && ((1L << (_la - 141)) & ((1L << (EQUALS - 141)) | (1L << (SQL_NE - 141)) | (1L << (NOT_EQUAL - 141)))) != 0)) {
				{
				{
				setState(251);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(245);
					((EvalEqualsExpressionContext)_localctx).eq = match(EQUALS);
					}
					break;
				case 2:
					{
					setState(246);
					((EvalEqualsExpressionContext)_localctx).is = match(IS);
					}
					break;
				case 3:
					{
					setState(247);
					((EvalEqualsExpressionContext)_localctx).isnot = match(IS);
					setState(248);
					match(NOT_EXPR);
					}
					break;
				case 4:
					{
					setState(249);
					((EvalEqualsExpressionContext)_localctx).sqlne = match(SQL_NE);
					}
					break;
				case 5:
					{
					setState(250);
					((EvalEqualsExpressionContext)_localctx).ne = match(NOT_EQUAL);
					}
					break;
				}
				setState(264);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case WINDOW:
				case ESCAPE:
				case EVERY_EXPR:
				case SUM:
				case AVG:
				case MAX:
				case MIN:
				case COALESCE:
				case MEDIAN:
				case STDDEV:
				case AVEDEV:
				case COUNT:
				case OUTER:
				case JOIN:
				case LEFT:
				case RIGHT:
				case FULL:
				case EVENTS:
				case FIRST:
				case LAST:
				case SCHEMA:
				case UNIDIRECTIONAL:
				case RETAINUNION:
				case RETAININTERSECTION:
				case PATTERN:
				case SQL:
				case METADATASQL:
				case PREVIOUS:
				case PREVIOUSTAIL:
				case PRIOR:
				case WEEKDAY:
				case LW:
				case INSTANCEOF:
				case TYPEOF:
				case CAST:
				case SNAPSHOT:
				case VARIABLE:
				case TABLE:
				case UNTIL:
				case AT:
				case INDEX:
				case BOOLEAN_TRUE:
				case BOOLEAN_FALSE:
				case VALUE_NULL:
				case DEFINE:
				case PARTITION:
				case MATCHES:
				case FOR:
				case WHILE:
				case USING:
				case MERGE:
				case MATCHED:
				case CONTEXT:
				case PLUS:
				case MINUS:
				case TICKED_STRING_LITERAL:
				case QUOTED_STRING_LITERAL:
				case STRING_LITERAL:
				case IDENT:
				case IntegerLiteral:
				case FloatingPointLiteral:
					{
					setState(253);
					evalRelationalExpression();
					}
					break;
				case ALL:
				case ANY:
				case SOME:
					{
					setState(257);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case ANY:
						{
						setState(254);
						((EvalEqualsExpressionContext)_localctx).a = match(ANY);
						}
						break;
					case SOME:
						{
						setState(255);
						((EvalEqualsExpressionContext)_localctx).a = match(SOME);
						}
						break;
					case ALL:
						{
						setState(256);
						((EvalEqualsExpressionContext)_localctx).a = match(ALL);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					{
					{
					setState(259);
					match(LPAREN);
					setState(261);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (((((_la - 2)) & ~0x3f) == 0 && ((1L << (_la - 2)) & ((1L << (WINDOW - 2)) | (1L << (ESCAPE - 2)) | (1L << (NOT_EXPR - 2)) | (1L << (EVERY_EXPR - 2)) | (1L << (SUM - 2)) | (1L << (AVG - 2)) | (1L << (MAX - 2)) | (1L << (MIN - 2)) | (1L << (COALESCE - 2)) | (1L << (MEDIAN - 2)) | (1L << (STDDEV - 2)) | (1L << (AVEDEV - 2)) | (1L << (COUNT - 2)) | (1L << (OUTER - 2)) | (1L << (JOIN - 2)) | (1L << (LEFT - 2)) | (1L << (RIGHT - 2)) | (1L << (FULL - 2)) | (1L << (EVENTS - 2)) | (1L << (FIRST - 2)) | (1L << (LAST - 2)) | (1L << (SCHEMA - 2)) | (1L << (UNIDIRECTIONAL - 2)) | (1L << (RETAINUNION - 2)) | (1L << (RETAININTERSECTION - 2)) | (1L << (PATTERN - 2)) | (1L << (SQL - 2)) | (1L << (METADATASQL - 2)))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (PREVIOUS - 66)) | (1L << (PREVIOUSTAIL - 66)) | (1L << (PRIOR - 66)) | (1L << (WEEKDAY - 66)) | (1L << (LW - 66)) | (1L << (INSTANCEOF - 66)) | (1L << (TYPEOF - 66)) | (1L << (CAST - 66)) | (1L << (SNAPSHOT - 66)) | (1L << (VARIABLE - 66)) | (1L << (TABLE - 66)) | (1L << (UNTIL - 66)) | (1L << (AT - 66)) | (1L << (INDEX - 66)) | (1L << (BOOLEAN_TRUE - 66)) | (1L << (BOOLEAN_FALSE - 66)) | (1L << (VALUE_NULL - 66)) | (1L << (DEFINE - 66)) | (1L << (PARTITION - 66)) | (1L << (MATCHES - 66)) | (1L << (FOR - 66)) | (1L << (WHILE - 66)) | (1L << (USING - 66)) | (1L << (MERGE - 66)) | (1L << (MATCHED - 66)) | (1L << (CONTEXT - 66)))) != 0) || ((((_la - 158)) & ~0x3f) == 0 && ((1L << (_la - 158)) & ((1L << (PLUS - 158)) | (1L << (MINUS - 158)) | (1L << (TICKED_STRING_LITERAL - 158)) | (1L << (QUOTED_STRING_LITERAL - 158)) | (1L << (STRING_LITERAL - 158)) | (1L << (IDENT - 158)) | (1L << (IntegerLiteral - 158)) | (1L << (FloatingPointLiteral - 158)))) != 0)) {
						{
						setState(260);
						expressionList();
						}
					}

					setState(263);
					match(RPAREN);
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(270);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EvalRelationalExpressionContext extends ParserRuleContext {
		public Token r;
		public Token g;
		public Token n;
		public Token in;
		public Token l;
		public Token col;
		public List<ConcatenationExprContext> concatenationExpr() {
			return getRuleContexts(ConcatenationExprContext.class);
		}
		public ConcatenationExprContext concatenationExpr(int i) {
			return getRuleContext(ConcatenationExprContext.class,i);
		}
		public TerminalNode NOT_EXPR() { return getToken(PatternLanguageParser.NOT_EXPR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode IN_SET() { return getToken(PatternLanguageParser.IN_SET, 0); }
		public List<TerminalNode> LPAREN() { return getTokens(PatternLanguageParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(PatternLanguageParser.LPAREN, i);
		}
		public TerminalNode LBRACK() { return getToken(PatternLanguageParser.LBRACK, 0); }
		public List<TerminalNode> RPAREN() { return getTokens(PatternLanguageParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(PatternLanguageParser.RPAREN, i);
		}
		public TerminalNode RBRACK() { return getToken(PatternLanguageParser.RBRACK, 0); }
		public List<TerminalNode> LT() { return getTokens(PatternLanguageParser.LT); }
		public TerminalNode LT(int i) {
			return getToken(PatternLanguageParser.LT, i);
		}
		public List<TerminalNode> GT() { return getTokens(PatternLanguageParser.GT); }
		public TerminalNode GT(int i) {
			return getToken(PatternLanguageParser.GT, i);
		}
		public List<TerminalNode> LE() { return getTokens(PatternLanguageParser.LE); }
		public TerminalNode LE(int i) {
			return getToken(PatternLanguageParser.LE, i);
		}
		public List<TerminalNode> GE() { return getTokens(PatternLanguageParser.GE); }
		public TerminalNode GE(int i) {
			return getToken(PatternLanguageParser.GE, i);
		}
		public TerminalNode COLON() { return getToken(PatternLanguageParser.COLON, 0); }
		public List<TerminalNode> ANY() { return getTokens(PatternLanguageParser.ANY); }
		public TerminalNode ANY(int i) {
			return getToken(PatternLanguageParser.ANY, i);
		}
		public List<TerminalNode> SOME() { return getTokens(PatternLanguageParser.SOME); }
		public TerminalNode SOME(int i) {
			return getToken(PatternLanguageParser.SOME, i);
		}
		public List<TerminalNode> ALL() { return getTokens(PatternLanguageParser.ALL); }
		public TerminalNode ALL(int i) {
			return getToken(PatternLanguageParser.ALL, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PatternLanguageParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PatternLanguageParser.COMMA, i);
		}
		public List<ExpressionListContext> expressionList() {
			return getRuleContexts(ExpressionListContext.class);
		}
		public ExpressionListContext expressionList(int i) {
			return getRuleContext(ExpressionListContext.class,i);
		}
		public EvalRelationalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_evalRelationalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterEvalRelationalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitEvalRelationalExpression(this);
		}
	}

	public final EvalRelationalExpressionContext evalRelationalExpression() throws RecognitionException {
		EvalRelationalExpressionContext _localctx = new EvalRelationalExpressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_evalRelationalExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			concatenationExpr();
			setState(320);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OR_EXPR:
			case AND_EXPR:
			case IS:
			case EQUALS:
			case SQL_NE:
			case RPAREN:
			case RBRACK:
			case COLON:
			case COMMA:
			case NOT_EQUAL:
			case GE:
			case GT:
			case LE:
			case LT:
				{
				{
				setState(293);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 168)) & ~0x3f) == 0 && ((1L << (_la - 168)) & ((1L << (GE - 168)) | (1L << (GT - 168)) | (1L << (LE - 168)) | (1L << (LT - 168)))) != 0)) {
					{
					{
					setState(276);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LT:
						{
						setState(272);
						((EvalRelationalExpressionContext)_localctx).r = match(LT);
						}
						break;
					case GT:
						{
						setState(273);
						((EvalRelationalExpressionContext)_localctx).r = match(GT);
						}
						break;
					case LE:
						{
						setState(274);
						((EvalRelationalExpressionContext)_localctx).r = match(LE);
						}
						break;
					case GE:
						{
						setState(275);
						((EvalRelationalExpressionContext)_localctx).r = match(GE);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(289);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case WINDOW:
					case ESCAPE:
					case EVERY_EXPR:
					case SUM:
					case AVG:
					case MAX:
					case MIN:
					case COALESCE:
					case MEDIAN:
					case STDDEV:
					case AVEDEV:
					case COUNT:
					case OUTER:
					case JOIN:
					case LEFT:
					case RIGHT:
					case FULL:
					case EVENTS:
					case FIRST:
					case LAST:
					case SCHEMA:
					case UNIDIRECTIONAL:
					case RETAINUNION:
					case RETAININTERSECTION:
					case PATTERN:
					case SQL:
					case METADATASQL:
					case PREVIOUS:
					case PREVIOUSTAIL:
					case PRIOR:
					case WEEKDAY:
					case LW:
					case INSTANCEOF:
					case TYPEOF:
					case CAST:
					case SNAPSHOT:
					case VARIABLE:
					case TABLE:
					case UNTIL:
					case AT:
					case INDEX:
					case BOOLEAN_TRUE:
					case BOOLEAN_FALSE:
					case VALUE_NULL:
					case DEFINE:
					case PARTITION:
					case MATCHES:
					case FOR:
					case WHILE:
					case USING:
					case MERGE:
					case MATCHED:
					case CONTEXT:
					case PLUS:
					case MINUS:
					case TICKED_STRING_LITERAL:
					case QUOTED_STRING_LITERAL:
					case STRING_LITERAL:
					case IDENT:
					case IntegerLiteral:
					case FloatingPointLiteral:
						{
						setState(278);
						concatenationExpr();
						}
						break;
					case ALL:
					case ANY:
					case SOME:
						{
						setState(282);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case ANY:
							{
							setState(279);
							((EvalRelationalExpressionContext)_localctx).g = match(ANY);
							}
							break;
						case SOME:
							{
							setState(280);
							((EvalRelationalExpressionContext)_localctx).g = match(SOME);
							}
							break;
						case ALL:
							{
							setState(281);
							((EvalRelationalExpressionContext)_localctx).g = match(ALL);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						{
						{
						setState(284);
						match(LPAREN);
						setState(286);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 2)) & ~0x3f) == 0 && ((1L << (_la - 2)) & ((1L << (WINDOW - 2)) | (1L << (ESCAPE - 2)) | (1L << (NOT_EXPR - 2)) | (1L << (EVERY_EXPR - 2)) | (1L << (SUM - 2)) | (1L << (AVG - 2)) | (1L << (MAX - 2)) | (1L << (MIN - 2)) | (1L << (COALESCE - 2)) | (1L << (MEDIAN - 2)) | (1L << (STDDEV - 2)) | (1L << (AVEDEV - 2)) | (1L << (COUNT - 2)) | (1L << (OUTER - 2)) | (1L << (JOIN - 2)) | (1L << (LEFT - 2)) | (1L << (RIGHT - 2)) | (1L << (FULL - 2)) | (1L << (EVENTS - 2)) | (1L << (FIRST - 2)) | (1L << (LAST - 2)) | (1L << (SCHEMA - 2)) | (1L << (UNIDIRECTIONAL - 2)) | (1L << (RETAINUNION - 2)) | (1L << (RETAININTERSECTION - 2)) | (1L << (PATTERN - 2)) | (1L << (SQL - 2)) | (1L << (METADATASQL - 2)))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (PREVIOUS - 66)) | (1L << (PREVIOUSTAIL - 66)) | (1L << (PRIOR - 66)) | (1L << (WEEKDAY - 66)) | (1L << (LW - 66)) | (1L << (INSTANCEOF - 66)) | (1L << (TYPEOF - 66)) | (1L << (CAST - 66)) | (1L << (SNAPSHOT - 66)) | (1L << (VARIABLE - 66)) | (1L << (TABLE - 66)) | (1L << (UNTIL - 66)) | (1L << (AT - 66)) | (1L << (INDEX - 66)) | (1L << (BOOLEAN_TRUE - 66)) | (1L << (BOOLEAN_FALSE - 66)) | (1L << (VALUE_NULL - 66)) | (1L << (DEFINE - 66)) | (1L << (PARTITION - 66)) | (1L << (MATCHES - 66)) | (1L << (FOR - 66)) | (1L << (WHILE - 66)) | (1L << (USING - 66)) | (1L << (MERGE - 66)) | (1L << (MATCHED - 66)) | (1L << (CONTEXT - 66)))) != 0) || ((((_la - 158)) & ~0x3f) == 0 && ((1L << (_la - 158)) & ((1L << (PLUS - 158)) | (1L << (MINUS - 158)) | (1L << (TICKED_STRING_LITERAL - 158)) | (1L << (QUOTED_STRING_LITERAL - 158)) | (1L << (STRING_LITERAL - 158)) | (1L << (IDENT - 158)) | (1L << (IntegerLiteral - 158)) | (1L << (FloatingPointLiteral - 158)))) != 0)) {
							{
							setState(285);
							expressionList();
							}
						}

						setState(288);
						match(RPAREN);
						}
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					}
					setState(295);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case IN_SET:
			case NOT_EXPR:
				{
				setState(297);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT_EXPR) {
					{
					setState(296);
					((EvalRelationalExpressionContext)_localctx).n = match(NOT_EXPR);
					}
				}

				{
				{
				setState(299);
				((EvalRelationalExpressionContext)_localctx).in = match(IN_SET);
				setState(302);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LPAREN:
					{
					setState(300);
					((EvalRelationalExpressionContext)_localctx).l = match(LPAREN);
					}
					break;
				case LBRACK:
					{
					setState(301);
					((EvalRelationalExpressionContext)_localctx).l = match(LBRACK);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(304);
				expression();
				setState(314);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case COLON:
					{
					{
					setState(305);
					((EvalRelationalExpressionContext)_localctx).col = match(COLON);
					{
					setState(306);
					expression();
					}
					}
					}
					break;
				case RPAREN:
				case RBRACK:
				case COMMA:
					{
					{
					setState(311);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(307);
						match(COMMA);
						setState(308);
						expression();
						}
						}
						setState(313);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(318);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case RPAREN:
					{
					setState(316);
					((EvalRelationalExpressionContext)_localctx).r = match(RPAREN);
					}
					break;
				case RBRACK:
					{
					setState(317);
					((EvalRelationalExpressionContext)_localctx).r = match(RBRACK);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConcatenationExprContext extends ParserRuleContext {
		public Token c;
		public List<AdditiveExpressionContext> additiveExpression() {
			return getRuleContexts(AdditiveExpressionContext.class);
		}
		public AdditiveExpressionContext additiveExpression(int i) {
			return getRuleContext(AdditiveExpressionContext.class,i);
		}
		public List<TerminalNode> LOR() { return getTokens(PatternLanguageParser.LOR); }
		public TerminalNode LOR(int i) {
			return getToken(PatternLanguageParser.LOR, i);
		}
		public ConcatenationExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_concatenationExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterConcatenationExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitConcatenationExpr(this);
		}
	}

	public final ConcatenationExprContext concatenationExpr() throws RecognitionException {
		ConcatenationExprContext _localctx = new ConcatenationExprContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_concatenationExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			additiveExpression();
			setState(332);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LOR) {
				{
				setState(323);
				((ConcatenationExprContext)_localctx).c = match(LOR);
				setState(324);
				additiveExpression();
				setState(329);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LOR) {
					{
					{
					setState(325);
					match(LOR);
					setState(326);
					additiveExpression();
					}
					}
					setState(331);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AdditiveExpressionContext extends ParserRuleContext {
		public List<MultiplyExpressionContext> multiplyExpression() {
			return getRuleContexts(MultiplyExpressionContext.class);
		}
		public MultiplyExpressionContext multiplyExpression(int i) {
			return getRuleContext(MultiplyExpressionContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(PatternLanguageParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(PatternLanguageParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(PatternLanguageParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(PatternLanguageParser.MINUS, i);
		}
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitAdditiveExpression(this);
		}
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_additiveExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			multiplyExpression();
			setState(339);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(335);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(336);
				multiplyExpression();
				}
				}
				setState(341);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplyExpressionContext extends ParserRuleContext {
		public List<UnaryExpressionContext> unaryExpression() {
			return getRuleContexts(UnaryExpressionContext.class);
		}
		public UnaryExpressionContext unaryExpression(int i) {
			return getRuleContext(UnaryExpressionContext.class,i);
		}
		public List<TerminalNode> STAR() { return getTokens(PatternLanguageParser.STAR); }
		public TerminalNode STAR(int i) {
			return getToken(PatternLanguageParser.STAR, i);
		}
		public List<TerminalNode> DIV() { return getTokens(PatternLanguageParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(PatternLanguageParser.DIV, i);
		}
		public List<TerminalNode> MOD() { return getTokens(PatternLanguageParser.MOD); }
		public TerminalNode MOD(int i) {
			return getToken(PatternLanguageParser.MOD, i);
		}
		public MultiplyExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplyExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterMultiplyExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitMultiplyExpression(this);
		}
	}

	public final MultiplyExpressionContext multiplyExpression() throws RecognitionException {
		MultiplyExpressionContext _localctx = new MultiplyExpressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_multiplyExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			unaryExpression();
			setState(347);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 156)) & ~0x3f) == 0 && ((1L << (_la - 156)) & ((1L << (DIV - 156)) | (1L << (STAR - 156)) | (1L << (MOD - 156)))) != 0)) {
				{
				{
				setState(343);
				_la = _input.LA(1);
				if ( !(((((_la - 156)) & ~0x3f) == 0 && ((1L << (_la - 156)) & ((1L << (DIV - 156)) | (1L << (STAR - 156)) | (1L << (MOD - 156)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(344);
				unaryExpression();
				}
				}
				setState(349);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryExpressionContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(PatternLanguageParser.MINUS, 0); }
		public EventPropertyContext eventProperty() {
			return getRuleContext(EventPropertyContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitUnaryExpression(this);
		}
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_unaryExpression);
		try {
			setState(354);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(350);
				match(MINUS);
				setState(351);
				eventProperty();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(352);
				constant();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(353);
				eventProperty();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EventPropertyContext extends ParserRuleContext {
		public List<EventPropertyAtomicContext> eventPropertyAtomic() {
			return getRuleContexts(EventPropertyAtomicContext.class);
		}
		public EventPropertyAtomicContext eventPropertyAtomic(int i) {
			return getRuleContext(EventPropertyAtomicContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(PatternLanguageParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(PatternLanguageParser.DOT, i);
		}
		public EventPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterEventProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitEventProperty(this);
		}
	}

	public final EventPropertyContext eventProperty() throws RecognitionException {
		EventPropertyContext _localctx = new EventPropertyContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_eventProperty);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			eventPropertyAtomic();
			setState(361);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(357);
				match(DOT);
				setState(358);
				eventPropertyAtomic();
				}
				}
				setState(363);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EventPropertyAtomicContext extends ParserRuleContext {
		public Token lb;
		public NumberContext ni;
		public Token q;
		public Token lp;
		public Token s;
		public Token q1;
		public EventPropertyIdentContext eventPropertyIdent() {
			return getRuleContext(EventPropertyIdentContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(PatternLanguageParser.RBRACK, 0); }
		public TerminalNode RPAREN() { return getToken(PatternLanguageParser.RPAREN, 0); }
		public TerminalNode LBRACK() { return getToken(PatternLanguageParser.LBRACK, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(PatternLanguageParser.LPAREN, 0); }
		public TerminalNode QUESTION() { return getToken(PatternLanguageParser.QUESTION, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(PatternLanguageParser.STRING_LITERAL, 0); }
		public TerminalNode QUOTED_STRING_LITERAL() { return getToken(PatternLanguageParser.QUOTED_STRING_LITERAL, 0); }
		public EventPropertyAtomicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventPropertyAtomic; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterEventPropertyAtomic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitEventPropertyAtomic(this);
		}
	}

	public final EventPropertyAtomicContext eventPropertyAtomic() throws RecognitionException {
		EventPropertyAtomicContext _localctx = new EventPropertyAtomicContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_eventPropertyAtomic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			eventPropertyIdent();
			setState(381);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACK:
				{
				setState(365);
				((EventPropertyAtomicContext)_localctx).lb = match(LBRACK);
				setState(366);
				((EventPropertyAtomicContext)_localctx).ni = number();
				setState(367);
				match(RBRACK);
				setState(369);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==QUESTION) {
					{
					setState(368);
					((EventPropertyAtomicContext)_localctx).q = match(QUESTION);
					}
				}

				}
				break;
			case LPAREN:
				{
				setState(371);
				((EventPropertyAtomicContext)_localctx).lp = match(LPAREN);
				setState(374);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING_LITERAL:
					{
					setState(372);
					((EventPropertyAtomicContext)_localctx).s = match(STRING_LITERAL);
					}
					break;
				case QUOTED_STRING_LITERAL:
					{
					setState(373);
					((EventPropertyAtomicContext)_localctx).s = match(QUOTED_STRING_LITERAL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(376);
				match(RPAREN);
				setState(378);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==QUESTION) {
					{
					setState(377);
					((EventPropertyAtomicContext)_localctx).q = match(QUESTION);
					}
				}

				}
				break;
			case QUESTION:
				{
				setState(380);
				((EventPropertyAtomicContext)_localctx).q1 = match(QUESTION);
				}
				break;
			case IN_SET:
			case OR_EXPR:
			case AND_EXPR:
			case NOT_EXPR:
			case IS:
			case EQUALS:
			case SQL_NE:
			case RPAREN:
			case RBRACK:
			case COLON:
			case COMMA:
			case NOT_EQUAL:
			case DIV:
			case PLUS:
			case MINUS:
			case STAR:
			case MOD:
			case GE:
			case GT:
			case LE:
			case LT:
			case LOR:
			case DOT:
				break;
			default:
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EventPropertyIdentContext extends ParserRuleContext {
		public KeywordAllowedIdentContext ipi;
		public KeywordAllowedIdentContext ipi2;
		public List<KeywordAllowedIdentContext> keywordAllowedIdent() {
			return getRuleContexts(KeywordAllowedIdentContext.class);
		}
		public KeywordAllowedIdentContext keywordAllowedIdent(int i) {
			return getRuleContext(KeywordAllowedIdentContext.class,i);
		}
		public List<TerminalNode> ESCAPECHAR() { return getTokens(PatternLanguageParser.ESCAPECHAR); }
		public TerminalNode ESCAPECHAR(int i) {
			return getToken(PatternLanguageParser.ESCAPECHAR, i);
		}
		public List<TerminalNode> DOT() { return getTokens(PatternLanguageParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(PatternLanguageParser.DOT, i);
		}
		public EventPropertyIdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventPropertyIdent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterEventPropertyIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitEventPropertyIdent(this);
		}
	}

	public final EventPropertyIdentContext eventPropertyIdent() throws RecognitionException {
		EventPropertyIdentContext _localctx = new EventPropertyIdentContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_eventPropertyIdent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
			((EventPropertyIdentContext)_localctx).ipi = keywordAllowedIdent();
			setState(391);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ESCAPECHAR) {
				{
				{
				setState(384);
				match(ESCAPECHAR);
				setState(385);
				match(DOT);
				setState(387);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 2)) & ~0x3f) == 0 && ((1L << (_la - 2)) & ((1L << (WINDOW - 2)) | (1L << (ESCAPE - 2)) | (1L << (EVERY_EXPR - 2)) | (1L << (SUM - 2)) | (1L << (AVG - 2)) | (1L << (MAX - 2)) | (1L << (MIN - 2)) | (1L << (COALESCE - 2)) | (1L << (MEDIAN - 2)) | (1L << (STDDEV - 2)) | (1L << (AVEDEV - 2)) | (1L << (COUNT - 2)) | (1L << (OUTER - 2)) | (1L << (JOIN - 2)) | (1L << (LEFT - 2)) | (1L << (RIGHT - 2)) | (1L << (FULL - 2)) | (1L << (EVENTS - 2)) | (1L << (FIRST - 2)) | (1L << (LAST - 2)) | (1L << (SCHEMA - 2)) | (1L << (UNIDIRECTIONAL - 2)) | (1L << (RETAINUNION - 2)) | (1L << (RETAININTERSECTION - 2)) | (1L << (PATTERN - 2)) | (1L << (SQL - 2)) | (1L << (METADATASQL - 2)))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (PREVIOUS - 66)) | (1L << (PREVIOUSTAIL - 66)) | (1L << (PRIOR - 66)) | (1L << (WEEKDAY - 66)) | (1L << (LW - 66)) | (1L << (INSTANCEOF - 66)) | (1L << (TYPEOF - 66)) | (1L << (CAST - 66)) | (1L << (SNAPSHOT - 66)) | (1L << (VARIABLE - 66)) | (1L << (TABLE - 66)) | (1L << (UNTIL - 66)) | (1L << (AT - 66)) | (1L << (INDEX - 66)) | (1L << (DEFINE - 66)) | (1L << (PARTITION - 66)) | (1L << (MATCHES - 66)) | (1L << (FOR - 66)) | (1L << (WHILE - 66)) | (1L << (USING - 66)) | (1L << (MERGE - 66)) | (1L << (MATCHED - 66)) | (1L << (CONTEXT - 66)))) != 0) || _la==TICKED_STRING_LITERAL || _la==IDENT) {
					{
					setState(386);
					((EventPropertyIdentContext)_localctx).ipi2 = keywordAllowedIdent();
					}
				}

				}
				}
				setState(393);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public Token t;
		public Token f;
		public Token nu;
		public NumberconstantContext numberconstant() {
			return getRuleContext(NumberconstantContext.class,0);
		}
		public StringconstantContext stringconstant() {
			return getRuleContext(StringconstantContext.class,0);
		}
		public TerminalNode BOOLEAN_TRUE() { return getToken(PatternLanguageParser.BOOLEAN_TRUE, 0); }
		public TerminalNode BOOLEAN_FALSE() { return getToken(PatternLanguageParser.BOOLEAN_FALSE, 0); }
		public TerminalNode VALUE_NULL() { return getToken(PatternLanguageParser.VALUE_NULL, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_constant);
		try {
			setState(399);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
			case MINUS:
			case IntegerLiteral:
			case FloatingPointLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(394);
				numberconstant();
				}
				break;
			case QUOTED_STRING_LITERAL:
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(395);
				stringconstant();
				}
				break;
			case BOOLEAN_TRUE:
				enterOuterAlt(_localctx, 3);
				{
				setState(396);
				((ConstantContext)_localctx).t = match(BOOLEAN_TRUE);
				}
				break;
			case BOOLEAN_FALSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(397);
				((ConstantContext)_localctx).f = match(BOOLEAN_FALSE);
				}
				break;
			case VALUE_NULL:
				enterOuterAlt(_localctx, 5);
				{
				setState(398);
				((ConstantContext)_localctx).nu = match(VALUE_NULL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberconstantContext extends ParserRuleContext {
		public Token m;
		public Token p;
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(PatternLanguageParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(PatternLanguageParser.PLUS, 0); }
		public NumberconstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberconstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterNumberconstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitNumberconstant(this);
		}
	}

	public final NumberconstantContext numberconstant() throws RecognitionException {
		NumberconstantContext _localctx = new NumberconstantContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_numberconstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
				{
				setState(401);
				((NumberconstantContext)_localctx).m = match(MINUS);
				}
				break;
			case PLUS:
				{
				setState(402);
				((NumberconstantContext)_localctx).p = match(PLUS);
				}
				break;
			case IntegerLiteral:
			case FloatingPointLiteral:
				break;
			default:
				break;
			}
			setState(405);
			number();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringconstantContext extends ParserRuleContext {
		public Token sl;
		public Token qsl;
		public TerminalNode STRING_LITERAL() { return getToken(PatternLanguageParser.STRING_LITERAL, 0); }
		public TerminalNode QUOTED_STRING_LITERAL() { return getToken(PatternLanguageParser.QUOTED_STRING_LITERAL, 0); }
		public StringconstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringconstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterStringconstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitStringconstant(this);
		}
	}

	public final StringconstantContext stringconstant() throws RecognitionException {
		StringconstantContext _localctx = new StringconstantContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_stringconstant);
		try {
			setState(409);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(407);
				((StringconstantContext)_localctx).sl = match(STRING_LITERAL);
				}
				break;
			case QUOTED_STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(408);
				((StringconstantContext)_localctx).qsl = match(QUOTED_STRING_LITERAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeywordAllowedIdentContext extends ParserRuleContext {
		public Token i1;
		public Token i2;
		public TerminalNode IDENT() { return getToken(PatternLanguageParser.IDENT, 0); }
		public TerminalNode TICKED_STRING_LITERAL() { return getToken(PatternLanguageParser.TICKED_STRING_LITERAL, 0); }
		public TerminalNode AT() { return getToken(PatternLanguageParser.AT, 0); }
		public TerminalNode COUNT() { return getToken(PatternLanguageParser.COUNT, 0); }
		public TerminalNode ESCAPE() { return getToken(PatternLanguageParser.ESCAPE, 0); }
		public TerminalNode EVERY_EXPR() { return getToken(PatternLanguageParser.EVERY_EXPR, 0); }
		public TerminalNode SCHEMA() { return getToken(PatternLanguageParser.SCHEMA, 0); }
		public TerminalNode SUM() { return getToken(PatternLanguageParser.SUM, 0); }
		public TerminalNode AVG() { return getToken(PatternLanguageParser.AVG, 0); }
		public TerminalNode MAX() { return getToken(PatternLanguageParser.MAX, 0); }
		public TerminalNode MIN() { return getToken(PatternLanguageParser.MIN, 0); }
		public TerminalNode COALESCE() { return getToken(PatternLanguageParser.COALESCE, 0); }
		public TerminalNode MEDIAN() { return getToken(PatternLanguageParser.MEDIAN, 0); }
		public TerminalNode STDDEV() { return getToken(PatternLanguageParser.STDDEV, 0); }
		public TerminalNode AVEDEV() { return getToken(PatternLanguageParser.AVEDEV, 0); }
		public TerminalNode EVENTS() { return getToken(PatternLanguageParser.EVENTS, 0); }
		public TerminalNode FIRST() { return getToken(PatternLanguageParser.FIRST, 0); }
		public TerminalNode LAST() { return getToken(PatternLanguageParser.LAST, 0); }
		public TerminalNode WHILE() { return getToken(PatternLanguageParser.WHILE, 0); }
		public TerminalNode MERGE() { return getToken(PatternLanguageParser.MERGE, 0); }
		public TerminalNode MATCHED() { return getToken(PatternLanguageParser.MATCHED, 0); }
		public TerminalNode UNIDIRECTIONAL() { return getToken(PatternLanguageParser.UNIDIRECTIONAL, 0); }
		public TerminalNode RETAINUNION() { return getToken(PatternLanguageParser.RETAINUNION, 0); }
		public TerminalNode RETAININTERSECTION() { return getToken(PatternLanguageParser.RETAININTERSECTION, 0); }
		public TerminalNode UNTIL() { return getToken(PatternLanguageParser.UNTIL, 0); }
		public TerminalNode PATTERN() { return getToken(PatternLanguageParser.PATTERN, 0); }
		public TerminalNode SQL() { return getToken(PatternLanguageParser.SQL, 0); }
		public TerminalNode METADATASQL() { return getToken(PatternLanguageParser.METADATASQL, 0); }
		public TerminalNode PREVIOUS() { return getToken(PatternLanguageParser.PREVIOUS, 0); }
		public TerminalNode PREVIOUSTAIL() { return getToken(PatternLanguageParser.PREVIOUSTAIL, 0); }
		public TerminalNode PRIOR() { return getToken(PatternLanguageParser.PRIOR, 0); }
		public TerminalNode WEEKDAY() { return getToken(PatternLanguageParser.WEEKDAY, 0); }
		public TerminalNode LW() { return getToken(PatternLanguageParser.LW, 0); }
		public TerminalNode INSTANCEOF() { return getToken(PatternLanguageParser.INSTANCEOF, 0); }
		public TerminalNode TYPEOF() { return getToken(PatternLanguageParser.TYPEOF, 0); }
		public TerminalNode CAST() { return getToken(PatternLanguageParser.CAST, 0); }
		public TerminalNode SNAPSHOT() { return getToken(PatternLanguageParser.SNAPSHOT, 0); }
		public TerminalNode VARIABLE() { return getToken(PatternLanguageParser.VARIABLE, 0); }
		public TerminalNode TABLE() { return getToken(PatternLanguageParser.TABLE, 0); }
		public TerminalNode INDEX() { return getToken(PatternLanguageParser.INDEX, 0); }
		public TerminalNode WINDOW() { return getToken(PatternLanguageParser.WINDOW, 0); }
		public TerminalNode LEFT() { return getToken(PatternLanguageParser.LEFT, 0); }
		public TerminalNode RIGHT() { return getToken(PatternLanguageParser.RIGHT, 0); }
		public TerminalNode OUTER() { return getToken(PatternLanguageParser.OUTER, 0); }
		public TerminalNode FULL() { return getToken(PatternLanguageParser.FULL, 0); }
		public TerminalNode JOIN() { return getToken(PatternLanguageParser.JOIN, 0); }
		public TerminalNode DEFINE() { return getToken(PatternLanguageParser.DEFINE, 0); }
		public TerminalNode PARTITION() { return getToken(PatternLanguageParser.PARTITION, 0); }
		public TerminalNode MATCHES() { return getToken(PatternLanguageParser.MATCHES, 0); }
		public TerminalNode CONTEXT() { return getToken(PatternLanguageParser.CONTEXT, 0); }
		public TerminalNode FOR() { return getToken(PatternLanguageParser.FOR, 0); }
		public TerminalNode USING() { return getToken(PatternLanguageParser.USING, 0); }
		public KeywordAllowedIdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keywordAllowedIdent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterKeywordAllowedIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitKeywordAllowedIdent(this);
		}
	}

	public final KeywordAllowedIdentContext keywordAllowedIdent() throws RecognitionException {
		KeywordAllowedIdentContext _localctx = new KeywordAllowedIdentContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_keywordAllowedIdent);
		try {
			setState(463);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(411);
				((KeywordAllowedIdentContext)_localctx).i1 = match(IDENT);
				}
				break;
			case TICKED_STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(412);
				((KeywordAllowedIdentContext)_localctx).i2 = match(TICKED_STRING_LITERAL);
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 3);
				{
				setState(413);
				match(AT);
				}
				break;
			case COUNT:
				enterOuterAlt(_localctx, 4);
				{
				setState(414);
				match(COUNT);
				}
				break;
			case ESCAPE:
				enterOuterAlt(_localctx, 5);
				{
				setState(415);
				match(ESCAPE);
				}
				break;
			case EVERY_EXPR:
				enterOuterAlt(_localctx, 6);
				{
				setState(416);
				match(EVERY_EXPR);
				}
				break;
			case SCHEMA:
				enterOuterAlt(_localctx, 7);
				{
				setState(417);
				match(SCHEMA);
				}
				break;
			case SUM:
				enterOuterAlt(_localctx, 8);
				{
				setState(418);
				match(SUM);
				}
				break;
			case AVG:
				enterOuterAlt(_localctx, 9);
				{
				setState(419);
				match(AVG);
				}
				break;
			case MAX:
				enterOuterAlt(_localctx, 10);
				{
				setState(420);
				match(MAX);
				}
				break;
			case MIN:
				enterOuterAlt(_localctx, 11);
				{
				setState(421);
				match(MIN);
				}
				break;
			case COALESCE:
				enterOuterAlt(_localctx, 12);
				{
				setState(422);
				match(COALESCE);
				}
				break;
			case MEDIAN:
				enterOuterAlt(_localctx, 13);
				{
				setState(423);
				match(MEDIAN);
				}
				break;
			case STDDEV:
				enterOuterAlt(_localctx, 14);
				{
				setState(424);
				match(STDDEV);
				}
				break;
			case AVEDEV:
				enterOuterAlt(_localctx, 15);
				{
				setState(425);
				match(AVEDEV);
				}
				break;
			case EVENTS:
				enterOuterAlt(_localctx, 16);
				{
				setState(426);
				match(EVENTS);
				}
				break;
			case FIRST:
				enterOuterAlt(_localctx, 17);
				{
				setState(427);
				match(FIRST);
				}
				break;
			case LAST:
				enterOuterAlt(_localctx, 18);
				{
				setState(428);
				match(LAST);
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 19);
				{
				setState(429);
				match(WHILE);
				}
				break;
			case MERGE:
				enterOuterAlt(_localctx, 20);
				{
				setState(430);
				match(MERGE);
				}
				break;
			case MATCHED:
				enterOuterAlt(_localctx, 21);
				{
				setState(431);
				match(MATCHED);
				}
				break;
			case UNIDIRECTIONAL:
				enterOuterAlt(_localctx, 22);
				{
				setState(432);
				match(UNIDIRECTIONAL);
				}
				break;
			case RETAINUNION:
				enterOuterAlt(_localctx, 23);
				{
				setState(433);
				match(RETAINUNION);
				}
				break;
			case RETAININTERSECTION:
				enterOuterAlt(_localctx, 24);
				{
				setState(434);
				match(RETAININTERSECTION);
				}
				break;
			case UNTIL:
				enterOuterAlt(_localctx, 25);
				{
				setState(435);
				match(UNTIL);
				}
				break;
			case PATTERN:
				enterOuterAlt(_localctx, 26);
				{
				setState(436);
				match(PATTERN);
				}
				break;
			case SQL:
				enterOuterAlt(_localctx, 27);
				{
				setState(437);
				match(SQL);
				}
				break;
			case METADATASQL:
				enterOuterAlt(_localctx, 28);
				{
				setState(438);
				match(METADATASQL);
				}
				break;
			case PREVIOUS:
				enterOuterAlt(_localctx, 29);
				{
				setState(439);
				match(PREVIOUS);
				}
				break;
			case PREVIOUSTAIL:
				enterOuterAlt(_localctx, 30);
				{
				setState(440);
				match(PREVIOUSTAIL);
				}
				break;
			case PRIOR:
				enterOuterAlt(_localctx, 31);
				{
				setState(441);
				match(PRIOR);
				}
				break;
			case WEEKDAY:
				enterOuterAlt(_localctx, 32);
				{
				setState(442);
				match(WEEKDAY);
				}
				break;
			case LW:
				enterOuterAlt(_localctx, 33);
				{
				setState(443);
				match(LW);
				}
				break;
			case INSTANCEOF:
				enterOuterAlt(_localctx, 34);
				{
				setState(444);
				match(INSTANCEOF);
				}
				break;
			case TYPEOF:
				enterOuterAlt(_localctx, 35);
				{
				setState(445);
				match(TYPEOF);
				}
				break;
			case CAST:
				enterOuterAlt(_localctx, 36);
				{
				setState(446);
				match(CAST);
				}
				break;
			case SNAPSHOT:
				enterOuterAlt(_localctx, 37);
				{
				setState(447);
				match(SNAPSHOT);
				}
				break;
			case VARIABLE:
				enterOuterAlt(_localctx, 38);
				{
				setState(448);
				match(VARIABLE);
				}
				break;
			case TABLE:
				enterOuterAlt(_localctx, 39);
				{
				setState(449);
				match(TABLE);
				}
				break;
			case INDEX:
				enterOuterAlt(_localctx, 40);
				{
				setState(450);
				match(INDEX);
				}
				break;
			case WINDOW:
				enterOuterAlt(_localctx, 41);
				{
				setState(451);
				match(WINDOW);
				}
				break;
			case LEFT:
				enterOuterAlt(_localctx, 42);
				{
				setState(452);
				match(LEFT);
				}
				break;
			case RIGHT:
				enterOuterAlt(_localctx, 43);
				{
				setState(453);
				match(RIGHT);
				}
				break;
			case OUTER:
				enterOuterAlt(_localctx, 44);
				{
				setState(454);
				match(OUTER);
				}
				break;
			case FULL:
				enterOuterAlt(_localctx, 45);
				{
				setState(455);
				match(FULL);
				}
				break;
			case JOIN:
				enterOuterAlt(_localctx, 46);
				{
				setState(456);
				match(JOIN);
				}
				break;
			case DEFINE:
				enterOuterAlt(_localctx, 47);
				{
				setState(457);
				match(DEFINE);
				}
				break;
			case PARTITION:
				enterOuterAlt(_localctx, 48);
				{
				setState(458);
				match(PARTITION);
				}
				break;
			case MATCHES:
				enterOuterAlt(_localctx, 49);
				{
				setState(459);
				match(MATCHES);
				}
				break;
			case CONTEXT:
				enterOuterAlt(_localctx, 50);
				{
				setState(460);
				match(CONTEXT);
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 51);
				{
				setState(461);
				match(FOR);
				}
				break;
			case USING:
				enterOuterAlt(_localctx, 52);
				{
				setState(462);
				match(USING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode IntegerLiteral() { return getToken(PatternLanguageParser.IntegerLiteral, 0); }
		public TerminalNode FloatingPointLiteral() { return getToken(PatternLanguageParser.FloatingPointLiteral, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternLanguageListener ) ((PatternLanguageListener)listener).exitNumber(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465);
			_la = _input.LA(1);
			if ( !(_la==IntegerLiteral || _la==FloatingPointLiteral) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u00c7\u01d6\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\3\2\3\3\3\3\7\3Z\n\3\f\3\16\3]\13\3\3\4\3\4\3\4\7\4b\n\4\f\4\16\4e\13"+
		"\4\3\5\3\5\5\5i\n\5\3\6\3\6\3\6\3\7\3\7\3\7\7\7q\n\7\f\7\16\7t\13\7\3"+
		"\b\3\b\3\t\3\t\5\tz\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\5\n\u0083\n\n\3\13"+
		"\3\13\5\13\u0087\n\13\3\f\3\f\5\f\u008b\n\f\3\f\3\f\5\f\u008f\n\f\3\f"+
		"\3\f\5\f\u0093\n\f\3\f\5\f\u0096\n\f\3\r\3\r\5\r\u009a\n\r\3\r\3\r\5\r"+
		"\u009e\n\r\3\r\3\r\5\r\u00a2\n\r\3\r\5\r\u00a5\n\r\3\r\3\r\3\16\3\16\3"+
		"\16\3\16\5\16\u00ad\n\16\3\17\3\17\3\17\5\17\u00b2\n\17\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\5\20\u00ba\n\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23"+
		"\3\23\5\23\u00c5\n\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\7\26\u00ce\n"+
		"\26\f\26\16\26\u00d1\13\26\3\27\3\27\3\27\5\27\u00d6\n\27\3\30\3\30\3"+
		"\30\7\30\u00db\n\30\f\30\16\30\u00de\13\30\3\31\3\31\3\32\3\32\3\32\7"+
		"\32\u00e5\n\32\f\32\16\32\u00e8\13\32\3\33\3\33\3\33\7\33\u00ed\n\33\f"+
		"\33\16\33\u00f0\13\33\3\34\3\34\3\34\5\34\u00f5\n\34\3\35\3\35\3\35\3"+
		"\35\3\35\3\35\3\35\5\35\u00fe\n\35\3\35\3\35\3\35\3\35\5\35\u0104\n\35"+
		"\3\35\3\35\5\35\u0108\n\35\3\35\5\35\u010b\n\35\7\35\u010d\n\35\f\35\16"+
		"\35\u0110\13\35\3\36\3\36\3\36\3\36\3\36\5\36\u0117\n\36\3\36\3\36\3\36"+
		"\3\36\5\36\u011d\n\36\3\36\3\36\5\36\u0121\n\36\3\36\5\36\u0124\n\36\7"+
		"\36\u0126\n\36\f\36\16\36\u0129\13\36\3\36\5\36\u012c\n\36\3\36\3\36\3"+
		"\36\5\36\u0131\n\36\3\36\3\36\3\36\3\36\3\36\7\36\u0138\n\36\f\36\16\36"+
		"\u013b\13\36\5\36\u013d\n\36\3\36\3\36\5\36\u0141\n\36\5\36\u0143\n\36"+
		"\3\37\3\37\3\37\3\37\3\37\7\37\u014a\n\37\f\37\16\37\u014d\13\37\5\37"+
		"\u014f\n\37\3 \3 \3 \7 \u0154\n \f \16 \u0157\13 \3!\3!\3!\7!\u015c\n"+
		"!\f!\16!\u015f\13!\3\"\3\"\3\"\3\"\5\"\u0165\n\"\3#\3#\3#\7#\u016a\n#"+
		"\f#\16#\u016d\13#\3$\3$\3$\3$\3$\5$\u0174\n$\3$\3$\3$\5$\u0179\n$\3$\3"+
		"$\5$\u017d\n$\3$\5$\u0180\n$\3%\3%\3%\3%\5%\u0186\n%\7%\u0188\n%\f%\16"+
		"%\u018b\13%\3&\3&\3&\3&\3&\5&\u0192\n&\3\'\3\'\5\'\u0196\n\'\3\'\3\'\3"+
		"(\3(\5(\u019c\n(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3"+
		")\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3"+
		")\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u01d2\n)\3*\3*\3*\2\2+\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPR\2\5\4"+
		"\2\u00a0\u00a0\u00a3\u00a3\5\2\u009e\u009e\u00a6\u00a6\u00a8\u00a8\3\2"+
		"\u00c6\u00c7\2\u0229\2T\3\2\2\2\4W\3\2\2\2\6^\3\2\2\2\bh\3\2\2\2\nj\3"+
		"\2\2\2\fm\3\2\2\2\16u\3\2\2\2\20y\3\2\2\2\22\u0082\3\2\2\2\24\u0086\3"+
		"\2\2\2\26\u008a\3\2\2\2\30\u0099\3\2\2\2\32\u00ac\3\2\2\2\34\u00ae\3\2"+
		"\2\2\36\u00b6\3\2\2\2 \u00bd\3\2\2\2\"\u00bf\3\2\2\2$\u00c1\3\2\2\2&\u00c6"+
		"\3\2\2\2(\u00c8\3\2\2\2*\u00ca\3\2\2\2,\u00d5\3\2\2\2.\u00d7\3\2\2\2\60"+
		"\u00df\3\2\2\2\62\u00e1\3\2\2\2\64\u00e9\3\2\2\2\66\u00f4\3\2\2\28\u00f6"+
		"\3\2\2\2:\u0111\3\2\2\2<\u0144\3\2\2\2>\u0150\3\2\2\2@\u0158\3\2\2\2B"+
		"\u0164\3\2\2\2D\u0166\3\2\2\2F\u016e\3\2\2\2H\u0181\3\2\2\2J\u0191\3\2"+
		"\2\2L\u0195\3\2\2\2N\u019b\3\2\2\2P\u01d1\3\2\2\2R\u01d3\3\2\2\2TU\5\4"+
		"\3\2UV\7\2\2\3V\3\3\2\2\2W[\5\6\4\2XZ\5\b\5\2YX\3\2\2\2Z]\3\2\2\2[Y\3"+
		"\2\2\2[\\\3\2\2\2\\\5\3\2\2\2][\3\2\2\2^c\5\f\7\2_`\7\n\2\2`b\5\f\7\2"+
		"a_\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2d\7\3\2\2\2ec\3\2\2\2fi\5\n\6"+
		"\2gi\5\6\4\2hf\3\2\2\2hg\3\2\2\2i\t\3\2\2\2jk\7\u008d\2\2kl\5\6\4\2l\13"+
		"\3\2\2\2mr\5\16\b\2no\7\13\2\2oq\5\16\b\2pn\3\2\2\2qt\3\2\2\2rp\3\2\2"+
		"\2rs\3\2\2\2s\r\3\2\2\2tr\3\2\2\2uv\5\20\t\2v\17\3\2\2\2wz\7\r\2\2xz\7"+
		"\f\2\2yw\3\2\2\2yx\3\2\2\2yz\3\2\2\2z{\3\2\2\2{|\5\22\n\2|\21\3\2\2\2"+
		"}\u0083\5\24\13\2~\177\7\u0092\2\2\177\u0080\5\4\3\2\u0080\u0081\7\u0093"+
		"\2\2\u0081\u0083\3\2\2\2\u0082}\3\2\2\2\u0082~\3\2\2\2\u0083\23\3\2\2"+
		"\2\u0084\u0087\5\30\r\2\u0085\u0087\5\26\f\2\u0086\u0084\3\2\2\2\u0086"+
		"\u0085\3\2\2\2\u0087\25\3\2\2\2\u0088\u0089\7\u00c5\2\2\u0089\u008b\7"+
		"\u008f\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\3\2\2\2"+
		"\u008c\u008e\5*\26\2\u008d\u008f\5\32\16\2\u008e\u008d\3\2\2\2\u008e\u008f"+
		"\3\2\2\2\u008f\u0095\3\2\2\2\u0090\u0092\7\u0092\2\2\u0091\u0093\5.\30"+
		"\2\u0092\u0091\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0096"+
		"\7\u0093\2\2\u0095\u0090\3\2\2\2\u0095\u0096\3\2\2\2\u0096\27\3\2\2\2"+
		"\u0097\u0098\7\u00c5\2\2\u0098\u009a\7\u008f\2\2\u0099\u0097\3\2\2\2\u0099"+
		"\u009a\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009d\5*\26\2\u009c\u009e\5\32"+
		"\16\2\u009d\u009c\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a4\3\2\2\2\u009f"+
		"\u00a1\7\u0092\2\2\u00a0\u00a2\5.\30\2\u00a1\u00a0\3\2\2\2\u00a1\u00a2"+
		"\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a5\7\u0093\2\2\u00a4\u009f\3\2\2"+
		"\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\7\u0091\2\2\u00a7"+
		"\31\3\2\2\2\u00a8\u00ad\5\"\22\2\u00a9\u00ad\5 \21\2\u00aa\u00ad\5\36"+
		"\20\2\u00ab\u00ad\5\34\17\2\u00ac\u00a8\3\2\2\2\u00ac\u00a9\3\2\2\2\u00ac"+
		"\u00aa\3\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\33\3\2\2\2\u00ae\u00af\7\u0096"+
		"\2\2\u00af\u00b1\5L\'\2\u00b0\u00b2\5$\23\2\u00b1\u00b0\3\2\2\2\u00b1"+
		"\u00b2\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\7\u0097\2\2\u00b4\u00b5"+
		"\7\u0091\2\2\u00b5\35\3\2\2\2\u00b6\u00b7\7\u0096\2\2\u00b7\u00b9\5L\'"+
		"\2\u00b8\u00ba\5$\23\2\u00b9\u00b8\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb"+
		"\3\2\2\2\u00bb\u00bc\7\u0097\2\2\u00bc\37\3\2\2\2\u00bd\u00be\7\u00a6"+
		"\2\2\u00be!\3\2\2\2\u00bf\u00c0\7\u00a0\2\2\u00c0#\3\2\2\2\u00c1\u00c4"+
		"\7\u0099\2\2\u00c2\u00c5\5(\25\2\u00c3\u00c5\5&\24\2\u00c4\u00c2\3\2\2"+
		"\2\u00c4\u00c3\3\2\2\2\u00c5%\3\2\2\2\u00c6\u00c7\5L\'\2\u00c7\'\3\2\2"+
		"\2\u00c8\u00c9\7\u00a0\2\2\u00c9)\3\2\2\2\u00ca\u00cf\5,\27\2\u00cb\u00cc"+
		"\7\u00b7\2\2\u00cc\u00ce\5,\27\2\u00cd\u00cb\3\2\2\2\u00ce\u00d1\3\2\2"+
		"\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0+\3\2\2\2\u00d1\u00cf"+
		"\3\2\2\2\u00d2\u00d6\7\u00c5\2\2\u00d3\u00d6\7\61\2\2\u00d4\u00d6\7\u00c2"+
		"\2\2\u00d5\u00d2\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d4\3\2\2\2\u00d6"+
		"-\3\2\2\2\u00d7\u00dc\5\60\31\2\u00d8\u00d9\7\u0099\2\2\u00d9\u00db\5"+
		"\60\31\2\u00da\u00d8\3\2\2\2\u00db\u00de\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc"+
		"\u00dd\3\2\2\2\u00dd/\3\2\2\2\u00de\u00dc\3\2\2\2\u00df\u00e0\5\62\32"+
		"\2\u00e0\61\3\2\2\2\u00e1\u00e6\5\64\33\2\u00e2\u00e3\7\n\2\2\u00e3\u00e5"+
		"\5\64\33\2\u00e4\u00e2\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2"+
		"\u00e6\u00e7\3\2\2\2\u00e7\63\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00ee"+
		"\5\66\34\2\u00ea\u00eb\7\13\2\2\u00eb\u00ed\5\66\34\2\u00ec\u00ea\3\2"+
		"\2\2\u00ed\u00f0\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef"+
		"\65\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f5\58\35\2\u00f2\u00f3\7\f\2"+
		"\2\u00f3\u00f5\58\35\2\u00f4\u00f1\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\67"+
		"\3\2\2\2\u00f6\u010e\5:\36\2\u00f7\u00fe\7\u008f\2\2\u00f8\u00fe\7(\2"+
		"\2\u00f9\u00fa\7(\2\2\u00fa\u00fe\7\f\2\2\u00fb\u00fe\7\u0090\2\2\u00fc"+
		"\u00fe\7\u009d\2\2\u00fd\u00f7\3\2\2\2\u00fd\u00f8\3\2\2\2\u00fd\u00f9"+
		"\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fc\3\2\2\2\u00fe\u010a\3\2\2\2\u00ff"+
		"\u010b\5:\36\2\u0100\u0104\7.\2\2\u0101\u0104\7/\2\2\u0102\u0104\7-\2"+
		"\2\u0103\u0100\3\2\2\2\u0103\u0101\3\2\2\2\u0103\u0102\3\2\2\2\u0104\u0105"+
		"\3\2\2\2\u0105\u0107\7\u0092\2\2\u0106\u0108\5.\30\2\u0107\u0106\3\2\2"+
		"\2\u0107\u0108\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010b\7\u0093\2\2\u010a"+
		"\u00ff\3\2\2\2\u010a\u0103\3\2\2\2\u010b\u010d\3\2\2\2\u010c\u00fd\3\2"+
		"\2\2\u010d\u0110\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f"+
		"9\3\2\2\2\u0110\u010e\3\2\2\2\u0111\u0142\5<\37\2\u0112\u0117\7\u00ad"+
		"\2\2\u0113\u0117\7\u00ab\2\2\u0114\u0117\7\u00ac\2\2\u0115\u0117\7\u00aa"+
		"\2\2\u0116\u0112\3\2\2\2\u0116\u0113\3\2\2\2\u0116\u0114\3\2\2\2\u0116"+
		"\u0115\3\2\2\2\u0117\u0123\3\2\2\2\u0118\u0124\5<\37\2\u0119\u011d\7."+
		"\2\2\u011a\u011d\7/\2\2\u011b\u011d\7-\2\2\u011c\u0119\3\2\2\2\u011c\u011a"+
		"\3\2\2\2\u011c\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u0120\7\u0092\2"+
		"\2\u011f\u0121\5.\30\2\u0120\u011f\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0122"+
		"\3\2\2\2\u0122\u0124\7\u0093\2\2\u0123\u0118\3\2\2\2\u0123\u011c\3\2\2"+
		"\2\u0124\u0126\3\2\2\2\u0125\u0116\3\2\2\2\u0126\u0129\3\2\2\2\u0127\u0125"+
		"\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u0143\3\2\2\2\u0129\u0127\3\2\2\2\u012a"+
		"\u012c\7\f\2\2\u012b\u012a\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012d\3\2"+
		"\2\2\u012d\u0130\7\5\2\2\u012e\u0131\7\u0092\2\2\u012f\u0131\7\u0094\2"+
		"\2\u0130\u012e\3\2\2\2\u0130\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u013c"+
		"\5\60\31\2\u0133\u0134\7\u0098\2\2\u0134\u013d\5\60\31\2\u0135\u0136\7"+
		"\u0099\2\2\u0136\u0138\5\60\31\2\u0137\u0135\3\2\2\2\u0138\u013b\3\2\2"+
		"\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013d\3\2\2\2\u013b\u0139"+
		"\3\2\2\2\u013c\u0133\3\2\2\2\u013c\u0139\3\2\2\2\u013d\u0140\3\2\2\2\u013e"+
		"\u0141\7\u0093\2\2\u013f\u0141\7\u0095\2\2\u0140\u013e\3\2\2\2\u0140\u013f"+
		"\3\2\2\2\u0141\u0143\3\2\2\2\u0142\u0127\3\2\2\2\u0142\u012b\3\2\2\2\u0143"+
		";\3\2\2\2\u0144\u014e\5> \2\u0145\u0146\7\u00b2\2\2\u0146\u014b\5> \2"+
		"\u0147\u0148\7\u00b2\2\2\u0148\u014a\5> \2\u0149\u0147\3\2\2\2\u014a\u014d"+
		"\3\2\2\2\u014b\u0149\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014f\3\2\2\2\u014d"+
		"\u014b\3\2\2\2\u014e\u0145\3\2\2\2\u014e\u014f\3\2\2\2\u014f=\3\2\2\2"+
		"\u0150\u0155\5@!\2\u0151\u0152\t\2\2\2\u0152\u0154\5@!\2\u0153\u0151\3"+
		"\2\2\2\u0154\u0157\3\2\2\2\u0155\u0153\3\2\2\2\u0155\u0156\3\2\2\2\u0156"+
		"?\3\2\2\2\u0157\u0155\3\2\2\2\u0158\u015d\5B\"\2\u0159\u015a\t\3\2\2\u015a"+
		"\u015c\5B\"\2\u015b\u0159\3\2\2\2\u015c\u015f\3\2\2\2\u015d\u015b\3\2"+
		"\2\2\u015d\u015e\3\2\2\2\u015eA\3\2\2\2\u015f\u015d\3\2\2\2\u0160\u0161"+
		"\7\u00a3\2\2\u0161\u0165\5D#\2\u0162\u0165\5J&\2\u0163\u0165\5D#\2\u0164"+
		"\u0160\3\2\2\2\u0164\u0162\3\2\2\2\u0164\u0163\3\2\2\2\u0165C\3\2\2\2"+
		"\u0166\u016b\5F$\2\u0167\u0168\7\u00b7\2\2\u0168\u016a\5F$\2\u0169\u0167"+
		"\3\2\2\2\u016a\u016d\3\2\2\2\u016b\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016c"+
		"E\3\2\2\2\u016d\u016b\3\2\2\2\u016e\u017f\5H%\2\u016f\u0170\7\u0094\2"+
		"\2\u0170\u0171\5R*\2\u0171\u0173\7\u0095\2\2\u0172\u0174\7\u0091\2\2\u0173"+
		"\u0172\3\2\2\2\u0173\u0174\3\2\2\2\u0174\u0180\3\2\2\2\u0175\u0178\7\u0092"+
		"\2\2\u0176\u0179\7\u00c4\2\2\u0177\u0179\7\u00c3\2\2\u0178\u0176\3\2\2"+
		"\2\u0178\u0177\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u017c\7\u0093\2\2\u017b"+
		"\u017d\7\u0091\2\2\u017c\u017b\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u0180"+
		"\3\2\2\2\u017e\u0180\7\u0091\2\2\u017f\u016f\3\2\2\2\u017f\u0175\3\2\2"+
		"\2\u017f\u017e\3\2\2\2\u017f\u0180\3\2\2\2\u0180G\3\2\2\2\u0181\u0189"+
		"\5P)\2\u0182\u0183\7\u00bb\2\2\u0183\u0185\7\u00b7\2\2\u0184\u0186\5P"+
		")\2\u0185\u0184\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0188\3\2\2\2\u0187"+
		"\u0182\3\2\2\2\u0188\u018b\3\2\2\2\u0189\u0187\3\2\2\2\u0189\u018a\3\2"+
		"\2\2\u018aI\3\2\2\2\u018b\u0189\3\2\2\2\u018c\u0192\5L\'\2\u018d\u0192"+
		"\5N(\2\u018e\u0192\7m\2\2\u018f\u0192\7n\2\2\u0190\u0192\7o\2\2\u0191"+
		"\u018c\3\2\2\2\u0191\u018d\3\2\2\2\u0191\u018e\3\2\2\2\u0191\u018f\3\2"+
		"\2\2\u0191\u0190\3\2\2\2\u0192K\3\2\2\2\u0193\u0196\7\u00a3\2\2\u0194"+
		"\u0196\7\u00a0\2\2\u0195\u0193\3\2\2\2\u0195\u0194\3\2\2\2\u0195\u0196"+
		"\3\2\2\2\u0196\u0197\3\2\2\2\u0197\u0198\5R*\2\u0198M\3\2\2\2\u0199\u019c"+
		"\7\u00c4\2\2\u019a\u019c\7\u00c3\2\2\u019b\u0199\3\2\2\2\u019b\u019a\3"+
		"\2\2\2\u019cO\3\2\2\2\u019d\u01d2\7\u00c5\2\2\u019e\u01d2\7\u00c2\2\2"+
		"\u019f\u01d2\7V\2\2\u01a0\u01d2\7\31\2\2\u01a1\u01d2\7\t\2\2\u01a2\u01d2"+
		"\7\r\2\2\u01a3\u01d2\7=\2\2\u01a4\u01d2\7\21\2\2\u01a5\u01d2\7\22\2\2"+
		"\u01a6\u01d2\7\23\2\2\u01a7\u01d2\7\24\2\2\u01a8\u01d2\7\25\2\2\u01a9"+
		"\u01d2\7\26\2\2\u01aa\u01d2\7\27\2\2\u01ab\u01d2\7\30\2\2\u01ac\u01d2"+
		"\7\61\2\2\u01ad\u01d2\7\62\2\2\u01ae\u01d2\7\63\2\2\u01af\u01d2\7{\2\2"+
		"\u01b0\u01d2\7}\2\2\u01b1\u01d2\7~\2\2\u01b2\u01d2\7>\2\2\u01b3\u01d2"+
		"\7?\2\2\u01b4\u01d2\7@\2\2\u01b5\u01d2\7U\2\2\u01b6\u01d2\7A\2\2\u01b7"+
		"\u01d2\7B\2\2\u01b8\u01d2\7C\2\2\u01b9\u01d2\7D\2\2\u01ba\u01d2\7E\2\2"+
		"\u01bb\u01d2\7H\2\2\u01bc\u01d2\7J\2\2\u01bd\u01d2\7K\2\2\u01be\u01d2"+
		"\7L\2\2\u01bf\u01d2\7M\2\2\u01c0\u01d2\7N\2\2\u01c1\u01d2\7Q\2\2\u01c2"+
		"\u01d2\7S\2\2\u01c3\u01d2\7T\2\2\u01c4\u01d2\7W\2\2\u01c5\u01d2\7\4\2"+
		"\2\u01c6\u01d2\7$\2\2\u01c7\u01d2\7%\2\2\u01c8\u01d2\7!\2\2\u01c9\u01d2"+
		"\7&\2\2\u01ca\u01d2\7#\2\2\u01cb\u01d2\7v\2\2\u01cc\u01d2\7w\2\2\u01cd"+
		"\u01d2\7x\2\2\u01ce\u01d2\7\u0082\2\2\u01cf\u01d2\7z\2\2\u01d0\u01d2\7"+
		"|\2\2\u01d1\u019d\3\2\2\2\u01d1\u019e\3\2\2\2\u01d1\u019f\3\2\2\2\u01d1"+
		"\u01a0\3\2\2\2\u01d1\u01a1\3\2\2\2\u01d1\u01a2\3\2\2\2\u01d1\u01a3\3\2"+
		"\2\2\u01d1\u01a4\3\2\2\2\u01d1\u01a5\3\2\2\2\u01d1\u01a6\3\2\2\2\u01d1"+
		"\u01a7\3\2\2\2\u01d1\u01a8\3\2\2\2\u01d1\u01a9\3\2\2\2\u01d1\u01aa\3\2"+
		"\2\2\u01d1\u01ab\3\2\2\2\u01d1\u01ac\3\2\2\2\u01d1\u01ad\3\2\2\2\u01d1"+
		"\u01ae\3\2\2\2\u01d1\u01af\3\2\2\2\u01d1\u01b0\3\2\2\2\u01d1\u01b1\3\2"+
		"\2\2\u01d1\u01b2\3\2\2\2\u01d1\u01b3\3\2\2\2\u01d1\u01b4\3\2\2\2\u01d1"+
		"\u01b5\3\2\2\2\u01d1\u01b6\3\2\2\2\u01d1\u01b7\3\2\2\2\u01d1\u01b8\3\2"+
		"\2\2\u01d1\u01b9\3\2\2\2\u01d1\u01ba\3\2\2\2\u01d1\u01bb\3\2\2\2\u01d1"+
		"\u01bc\3\2\2\2\u01d1\u01bd\3\2\2\2\u01d1\u01be\3\2\2\2\u01d1\u01bf\3\2"+
		"\2\2\u01d1\u01c0\3\2\2\2\u01d1\u01c1\3\2\2\2\u01d1\u01c2\3\2\2\2\u01d1"+
		"\u01c3\3\2\2\2\u01d1\u01c4\3\2\2\2\u01d1\u01c5\3\2\2\2\u01d1\u01c6\3\2"+
		"\2\2\u01d1\u01c7\3\2\2\2\u01d1\u01c8\3\2\2\2\u01d1\u01c9\3\2\2\2\u01d1"+
		"\u01ca\3\2\2\2\u01d1\u01cb\3\2\2\2\u01d1\u01cc\3\2\2\2\u01d1\u01cd\3\2"+
		"\2\2\u01d1\u01ce\3\2\2\2\u01d1\u01cf\3\2\2\2\u01d1\u01d0\3\2\2\2\u01d2"+
		"Q\3\2\2\2\u01d3\u01d4\t\4\2\2\u01d4S\3\2\2\2;[chry\u0082\u0086\u008a\u008e"+
		"\u0092\u0095\u0099\u009d\u00a1\u00a4\u00ac\u00b1\u00b9\u00c4\u00cf\u00d5"+
		"\u00dc\u00e6\u00ee\u00f4\u00fd\u0103\u0107\u010a\u010e\u0116\u011c\u0120"+
		"\u0123\u0127\u012b\u0130\u0139\u013c\u0140\u0142\u014b\u014e\u0155\u015d"+
		"\u0164\u016b\u0173\u0178\u017c\u017f\u0185\u0189\u0191\u0195\u019b\u01d1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}