grammar Expr;

line: prog EOF;
prog: expr ';' prog
	| expr;
expr: NOT center=expr
	| MINUS center=expr
	| left=expr STAR right=expr
	| left=expr SLASH right=expr
	| left=expr PLUS right=expr
	| left=expr MINUS right=expr
	| left=expr AND right=expr
	| left=expr OR right=expr
	| '(' center=expr ')'
	| leftVar=value ASSIGN right=expr
	| value
	| constant
	;
value: left=value DOT right=value
	| call
	| variable
	;
constant: bool
	| STRING
	| resource
	| DOUBLE
	| INT;
resource: '@' (( pckg ':' )? type=IDENTIFIER '/' name=IDENTIFIER | NULL);
pckg: IDENTIFIER ('.' IDENTIFIER)*;
variable: IDENTIFIER
	| NULL;
call: IDENTIFIER '(' argslist? ')';
argslist: expr ',' argslist
    | expr;
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

DOUBLE: INT ('d'|'f')
	| INT '.' INT ('d'|'f')?
	;

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
PLUS: '+';
MINUS: '-';
SLASH: '/';
STAR: '*';
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