// Define a grammar called Hello
grammar PatternLanguage;

@header {
package at.datasciencelabs.pattern.generated;
}


startPatternExpressionRule : patternExpression EOF;
patternExpression : orExpression (followedByOrNextRepeat)*;
orExpression : andExpression (o=OR_EXPR andExpression)*;
followedByOrNextRepeat : followedByRepeat | followedByAnyRepeat | orExpression;
followedByRepeat: f=FOLLOWED_BY orExpression;
followedByAnyRepeat: f=FOLLOWED_BY_ANY orExpression;
andExpression :	matchUntilExpression (a=AND_EXPR matchUntilExpression)*;
matchUntilExpression : qualifyExpression;
qualifyExpression : (e=EVERY_EXPR | n=NOT_EXPR)? guardPostFix;
guardPostFix : patternFilterExpression | l=LPAREN patternExpression RPAREN;
patternFilterExpression
    		: patternFilterExpressionOptional | patternFilterExpressionMandatory;
patternFilterExpressionMandatory
    		: (i=IDENT EQUALS)? classIdentifier quantifier? (LPAREN expressionList? RPAREN)?;
patternFilterExpressionOptional
    		: (i=IDENT EQUALS)? classIdentifier quantifier? (LPAREN expressionList? RPAREN)? QUESTION;
quantifier: plus_quantifier | star_quantifier | number_quantifier | number_quantifier_greedy;
number_quantifier_greedy: s=LCURLY numberconstant upper_bound? t=RCURLY QUESTION;
number_quantifier: s=LCURLY numberconstant upper_bound? t=RCURLY;
star_quantifier: r=STAR;
plus_quantifier: q=PLUS;
upper_bound: z=COMMA (upper_bound_unlimited | upper_bound_limited);
upper_bound_limited: numberconstant;
upper_bound_unlimited: k=PLUS;
classIdentifier : i1=escapableStr (DOT i2=escapableStr)*;
escapableStr : i1=IDENT | i2=EVENTS | i3=TICKED_STRING_LITERAL;

expressionList : expression (COMMA expression)*;

expression : evalOrExpression;

evalOrExpression : evalAndExpression (op=OR_EXPR evalAndExpression)*;

evalAndExpression : negatedExpression (op=AND_EXPR negatedExpression)*;

negatedExpression : evalEqualsExpression
		| NOT_EXPR evalEqualsExpression;

evalEqualsExpression : evalRelationalExpression (
			    (eq=EQUALS
			      |  is=IS
			      |  isnot=IS NOT_EXPR
			      |  sqlne=SQL_NE
			      |  ne=NOT_EQUAL
			     )
		       (
			evalRelationalExpression
			|  (a=ANY | a=SOME | a=ALL) ( (LPAREN expressionList? RPAREN))
		       )
		     )*;

evalRelationalExpression : concatenationExpr (
			(
			  (
			    (r=LT|r=GT|r=LE|r=GE)
			    	(
			    	  concatenationExpr
			    	  | (g=ANY | g=SOME | g=ALL) ( (LPAREN expressionList? RPAREN))
			    	)

			  )*
			)
			| (n=NOT_EXPR)?
			(
				// Represent the greedy NOT prefix using the token type by
				// testing 'n' and setting the token type accordingly.
				(in=IN_SET
					  (l=LPAREN | l=LBRACK) expression	// brackets are for inclusive/exclusive
						(
							( col=COLON (expression) )		// range
							|
							( (COMMA expression)* )		// list of values
						)
					  (r=RPAREN | r=RBRACK)
					)			)
		);

concatenationExpr : additiveExpression ( c=LOR additiveExpression ( LOR additiveExpression)* )?;
additiveExpression : multiplyExpression ( (PLUS|MINUS) multiplyExpression )*;

multiplyExpression : unaryExpression ( (STAR|DIV|MOD) unaryExpression )*;

unaryExpression : MINUS eventProperty
		| constant
		| eventProperty;

eventProperty : eventPropertyAtomic (DOT eventPropertyAtomic)*;

eventPropertyAtomic : eventPropertyIdent (
			lb=LBRACK ni=number RBRACK (q=QUESTION)?
			|
			lp=LPAREN (s=STRING_LITERAL | s=QUOTED_STRING_LITERAL) RPAREN (q=QUESTION)?
			|
			q1=QUESTION
			)?;

eventPropertyIdent : ipi=keywordAllowedIdent (ESCAPECHAR DOT ipi2=keywordAllowedIdent?)*;

constant : numberconstant
		| stringconstant
		| t=BOOLEAN_TRUE
		| f=BOOLEAN_FALSE
		| nu=VALUE_NULL;

numberconstant : (m=MINUS | p=PLUS)? number;

stringconstant : sl=STRING_LITERAL
		| qsl=QUOTED_STRING_LITERAL;



keywordAllowedIdent : i1=IDENT
		| i2=TICKED_STRING_LITERAL
		| AT
		| COUNT
		| ESCAPE
    		| EVERY_EXPR
		| SCHEMA
		| SUM
		| AVG
		| MAX
		| MIN
		| COALESCE
		| MEDIAN
		| STDDEV
		| AVEDEV
		| EVENTS
		| FIRST
		| LAST
		| WHILE
		| MERGE
		| MATCHED
		| UNIDIRECTIONAL
		| RETAINUNION
		| RETAININTERSECTION
		| UNTIL
		| PATTERN
		| SQL
		| METADATASQL
		| PREVIOUS
		| PREVIOUSTAIL
		| PRIOR
		| WEEKDAY
		| LW
		| INSTANCEOF
		| TYPEOF
		| CAST
		| SNAPSHOT
		| VARIABLE
		| TABLE
		| INDEX
		| WINDOW
		| LEFT
		| RIGHT
		| OUTER
		| FULL
		| JOIN
		| DEFINE
		| PARTITION
		| MATCHES
		| CONTEXT
		| FOR
		| USING;

number : IntegerLiteral | FloatingPointLiteral;

// Tokens
CREATE:'create';
WINDOW:'window';
IN_SET:'in';
BETWEEN:'between';
LIKE:'like';
REGEXP:'regexp';
ESCAPE:'escape';
OR_EXPR:'or';
AND_EXPR:'and';
NOT_EXPR:'not';
EVERY_EXPR:'every';
EVERY_DISTINCT_EXPR:'every-distinct';
WHERE:'where';
AS:'as';
SUM:'sum';
AVG:'avg';
MAX:'max';
MIN:'min';
COALESCE:'coalesce';
MEDIAN:'median';
STDDEV:'stddev';
AVEDEV:'avedev';
COUNT:'count';
SELECT:'select';
CASE:'case';
ELSE:'else';
WHEN:'when';
THEN:'then';
END:'end';
FROM:'from';
OUTER:'outer';
INNER:'inner';
JOIN:'join';
LEFT:'left';
RIGHT:'right';
FULL:'full';
ON:'on';
IS:'is';
BY:'by';
GROUP:'group';
HAVING:'having';
DISTINCT:'distinct';
ALL:'all';
ANY:'any';
SOME:'some';
OUTPUT:'output';
EVENTS:'events';
FIRST:'first';
LAST:'last';
INSERT:'insert';
INTO:'into';
VALUES:'values';
ORDER:'order';
ASC:'asc';
DESC:'desc';
RSTREAM:'rstream';
ISTREAM:'istream';
IRSTREAM:'irstream';
SCHEMA:'schema';
UNIDIRECTIONAL:'unidirectional';
RETAINUNION:'retain-union';
RETAININTERSECTION:'retain-intersection';
PATTERN:'pattern';
SQL:'sql';
METADATASQL:'metadatasql';
PREVIOUS:'prev';
PREVIOUSTAIL:'prevtail';
PREVIOUSCOUNT:'prevcount';
PREVIOUSWINDOW:'prevwindow';
PRIOR:'prior';
EXISTS:'exists';
WEEKDAY:'weekday';
LW:'lastweekday';
INSTANCEOF:'instanceof';
TYPEOF:'typeof';
CAST:'cast';
CURRENT_TIMESTAMP:'current_timestamp';
DELETE:'delete';
SNAPSHOT:'snapshot';
SET:'set';
VARIABLE:'variable';
TABLE:'table';
UNTIL:'until';
AT:'at';
INDEX:'index';
TIMEPERIOD_YEAR:'year';
TIMEPERIOD_YEARS:'years';
TIMEPERIOD_MONTH:'month';
TIMEPERIOD_MONTHS:'months';
TIMEPERIOD_WEEK:'week';
TIMEPERIOD_WEEKS:'weeks';
TIMEPERIOD_DAY:'day';
TIMEPERIOD_DAYS:'days';
TIMEPERIOD_HOUR:'hour';
TIMEPERIOD_HOURS:'hours';
TIMEPERIOD_MINUTE:'minute';
TIMEPERIOD_MINUTES:'minutes';
TIMEPERIOD_SEC:'sec';
TIMEPERIOD_SECOND:'second';
TIMEPERIOD_SECONDS:'seconds';
TIMEPERIOD_MILLISEC:'msec';
TIMEPERIOD_MILLISECOND:'millisecond';
TIMEPERIOD_MILLISECONDS:'milliseconds';
TIMEPERIOD_MICROSEC:'usec';
TIMEPERIOD_MICROSECOND:'microsecond';
TIMEPERIOD_MICROSECONDS:'microseconds';
BOOLEAN_TRUE:'true';
BOOLEAN_FALSE:'false';
VALUE_NULL:'null';
ROW_LIMIT_EXPR:'limit';
OFFSET:'offset';
UPDATE:'update';
MATCH_RECOGNIZE:'match_recognize';
MATCH_RECOGNIZE_PERMUTE:'match_recognize_permute';
MEASURES:'measures';
DEFINE:'define';
PARTITION:'partition';
MATCHES:'matches';
AFTER:'after';
FOR:'for';
WHILE:'while';
USING:'using';
MERGE:'merge';
MATCHED:'matched';
EXPRESSIONDECL:'expression';
NEWKW:'new';
START:'start';
CONTEXT:'context';
INITIATED:'initiated';
TERMINATED:'terminated';
DATAFLOW:'dataflow';
CUBE:'cube';
ROLLUP:'rollup';
GROUPING:'grouping';
GROUPING_ID:'grouping_id';
SETS:'sets';

// Operators
FOLLOWMAX_BEGIN : '-[';
FOLLOWMAX_END   : ']>';
FOLLOWED_BY 	: '->';
FOLLOWED_BY_ANY : '->>';
GOES 		: '=>';
EQUALS 		: '=';
SQL_NE 		: '<>';
QUESTION 	: '?';
LPAREN 		: '(';
RPAREN 		: ')';
LBRACK 		: '[';
RBRACK 		: ']';
LCURLY 		: '{';
RCURLY 		: '}';
COLON 		: ':';
COMMA 		: ',';
EQUAL 		: '==';
LNOT 		: '!';
BNOT 		: '~';
NOT_EQUAL 	: '!=';
DIV 		: '/';
DIV_ASSIGN 	: '/=';
PLUS 		: '+';
PLUS_ASSIGN	: '+=';
INC 		: '++';
MINUS 		: '-';
MINUS_ASSIGN 	: '-=';
DEC 		: '--';
STAR 		: '*';
STAR_ASSIGN 	: '*=';
MOD 		: '%';
MOD_ASSIGN 	: '%=';
GE 		: '>=';
GT 		: '>';
LE 		: '<=';
LT 		: '<';
BXOR 		: '^';
BXOR_ASSIGN 	: '^=';
BOR		: '|';
BOR_ASSIGN 	: '|=';
LOR		: '||';
BAND 		: '&';
BAND_ASSIGN 	: '&=';
LAND 		: '&&';
SEMI 		: ';';
DOT 		: '.';
NUM_LONG	: '\u18FF';  // assign bogus unicode characters so the token exists
NUM_DOUBLE	: '\u18FE';
NUM_FLOAT	: '\u18FD';
ESCAPECHAR	: '\\';
ESCAPEBACKTICK	: '`';
ATCHAR		: '@';
HASHCHAR	: '#';

// Whitespace -- ignored
WS	:	(	' '
		|	'\t'
		|	'\f'
			// handle newlines
		|	(
				'\r'    // Macintosh
			|	'\n'    // Unix (the right way)
			)
		)+
		-> channel(HIDDEN)
	;

// Single-line comments
SL_COMMENT
	:	'//'
		(~('\n'|'\r'))* ('\n'|'\r'('\n')?)?
		-> channel(HIDDEN)
	;

// multiple-line comments
ML_COMMENT
    	:   	'/*' (.)*? '*/'
		-> channel(HIDDEN)
    	;

TICKED_STRING_LITERAL
    :   '`' ( EscapeSequence | ~('`'|'\\') )* '`'
    ;

QUOTED_STRING_LITERAL
    :   '\'' ( EscapeSequence | ~('\''|'\\') )* '\''
    ;

STRING_LITERAL
    :  '"' ( EscapeSequence | ~('\\'|'"') )* '"'
    ;

fragment
EscapeSequence	:	'\\'
		(	'n'
		|	'r'
		|	't'
		|	'b'
		|	'f'
		|	'"'
		|	'\''
		|	'\\'
		|	UnicodeEscape
		|	OctalEscape
		|	. // unknown, leave as it is
		)
    ;

// an identifier.  Note that testLiterals is set to true!  This means
// that after we match the rule, we look in the literals table to see
// if it's a literal or really an identifer
IDENT
	:	('a'..'z'|'_'|'$') ('a'..'z'|'_'|'0'..'9'|'$')*
	;
IntegerLiteral
    :   DecimalIntegerLiteral
    |   HexIntegerLiteral
    |   OctalIntegerLiteral
    |   BinaryIntegerLiteral
    ;

FloatingPointLiteral
    :   DecimalFloatingPointLiteral
    |   HexadecimalFloatingPointLiteral
    ;
fragment
OctalEscape
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;
fragment
UnicodeEscape
    :   '\\' 'u' HexDigit HexDigit HexDigit HexDigit
    ;

fragment
DecimalIntegerLiteral
    :   DecimalNumeral IntegerTypeSuffix?
    ;
fragment
HexIntegerLiteral
    :   HexNumeral IntegerTypeSuffix?
    ;
fragment
OctalIntegerLiteral
    :   OctalNumeral IntegerTypeSuffix?
    ;
fragment
BinaryIntegerLiteral
    :   BinaryNumeral IntegerTypeSuffix?
    ;
fragment
IntegerTypeSuffix
    :   [lL]
    ;
fragment
DecimalNumeral
    :   '0'
    |   ('0')* NonZeroDigit (Digits? | Underscores Digits)
    ;
fragment
Digits
    :   Digit (DigitOrUnderscore* Digit)?
    ;
fragment
Digit
    :   '0'
    |   NonZeroDigit
    ;
fragment
NonZeroDigit
    :   [1-9]
    ;
fragment
DigitOrUnderscore
    :   Digit
    |   '_'
    ;
fragment
Underscores
    :   '_'+
    ;
fragment
HexNumeral
    :   '0' [xX] HexDigits
    ;
fragment
HexDigits
    :   HexDigit (HexDigitOrUnderscore* HexDigit)?
    ;
fragment
HexDigit
    :   [0-9a-fA-F]
    ;
fragment
HexDigitOrUnderscore
    :   HexDigit
    |   '_'
    ;
fragment
OctalNumeral
    :   '0' Underscores? OctalDigits
    ;
fragment
OctalDigits
    :   OctalDigit (OctalDigitOrUnderscore* OctalDigit)?
    ;
fragment
OctalDigit
    :   [0-7]
    ;
fragment
OctalDigitOrUnderscore
    :   OctalDigit
    |   '_'
    ;
fragment
BinaryNumeral
    :   '0' [bB] BinaryDigits
    ;
fragment
BinaryDigits
    :   BinaryDigit (BinaryDigitOrUnderscore* BinaryDigit)?
    ;
fragment
BinaryDigit
    :   [01]
    ;
fragment
BinaryDigitOrUnderscore
    :   BinaryDigit
    |   '_'
    ;
fragment
DecimalFloatingPointLiteral
    :   Digits '.' Digits? ExponentPart? FloatTypeSuffix?
    |   '.' Digits ExponentPart? FloatTypeSuffix?
    |   Digits ExponentPart FloatTypeSuffix?
    |   Digits FloatTypeSuffix
    ;
fragment
ExponentPart
    :   ExponentIndicator SignedInteger
    ;
fragment
ExponentIndicator
    :   [eE]
    ;
fragment
SignedInteger
    :   Sign? Digits
    ;
fragment
Sign
    :   [+-]
    ;
fragment
FloatTypeSuffix
    :   [fFdD]
    ;
fragment
HexadecimalFloatingPointLiteral
    :   HexSignificand BinaryExponent FloatTypeSuffix?
    ;
fragment
HexSignificand
    :   HexNumeral '.'?
    |   '0' [xX] HexDigits? '.' HexDigits
    ;
fragment
BinaryExponent
    :   BinaryExponentIndicator SignedInteger
    ;
fragment
BinaryExponentIndicator
    :   [pP]
    ;