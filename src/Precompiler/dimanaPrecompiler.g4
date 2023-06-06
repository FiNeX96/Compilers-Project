grammar dimanaPrecompiler;


program: statement* EOF;

statement: preprocessorDirective | code;

preprocessorDirective: 'use' SPACE* filename ';';
code: (LINE_COMMENT | LETTER | SYMBOLS | STRING | SPACE | NEWLINE ) semicolon=';'?;

filename: STRING;

STRING: '"' ~["]* '"';
SYMBOLS: [\u0021-\u007E];
LETTER: [a-zA-Z];
//WS: [ \t\r\n] -> skip;
SPACE: [ \t\r];
NEWLINE: [\n];
LINE_COMMENT: '#' ~[\r\n]*;
