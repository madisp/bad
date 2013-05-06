grammar Expr;

line: prog EOF;
prog: expr ';' prog
	| expr;
expr: NOT center=expr
	| left=expr AND right=expr
	| left=expr OR right=expr
	| leftVar=value ASSIGN right=expr
	| '(' center=expr ')'
	| value
	| constant
	;
value: left=value DOT right=value
	| call
	| variable
	;
constant: bool
	| STRING
	| resource;
resource: '@' (( pckg ':' )? type=IDENTIFIER '/' name=IDENTIFIER | NULL);
pckg: IDENTIFIER ('.' IDENTIFIER)*;
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
ASSIGN: '=';
OR: 'or';
INT: DIGIT+;
TRUE: 'true';
FALSE: 'false';
NULL: 'null';
IDENTIFIER: (ALPHA|DOLLAR) (ALPHANUMERIC)*;

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

DOLLAR: '$';

fragment
ALPHANUMERIC: (UPPERC|LOWERC|UNDERS|DIGIT);
WS: [ \r\t\u000C\n]+ -> skip;
DOT: '.';