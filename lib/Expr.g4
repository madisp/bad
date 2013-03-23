grammar Expr;

line: expr EOF;
expr: NOT center=expr
	| left=expr AND right=expr
	| left=expr OR right=expr
	| '(' center=expr ')'
	| value;
value: variable
	| call
	| bool
    | STRING
	;
variable: IDENTIFIER
	| NULL;
call: IDENTIFIER '(' argslist ')';
argslist: expr ',' argslist
    | expr
	| ;
bool: TRUE
	| FALSE
	;


STRING:
	'"'
	(
	ESC
	| ~('\\'|'"')
	)*

	'"' { setText(getText().substring(1, getText().length() - 1)); };

fragment ESC:
	'\\'
	( 't'
	| 'n'
	| 'r'
	| '"'
	| '\\'
	);

NOT: '!';
AND: 'and';
OR: 'or';
INT: DIGIT+;
TRUE: 'true';
FALSE: 'false';
NULL: 'null';
IDENTIFIER: ALPHA ALPHANUMERIC*;

ESCAPE: '\\' ('\\' | '"');

fragment
DIGIT: '0'..'9';

fragment
UPPERC: [A-Z];

fragment
LOWERC: [a-z];

fragment
UNDERS: '_';

fragment
ALPHA: (UPPERC|LOWERC|UNDERS);

fragment
ALPHANUMERIC: (UPPERC|LOWERC|UNDERS|DIGIT);
WS: [ \r\t\u000C\n]+ -> skip;