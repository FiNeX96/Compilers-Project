grammar dimana;

// see if necessary

// @parser::header {
// import java.util.Map;
// import java.util.HashMap;
// import java.util.List;
// }

// @parser::members { // first is variable name, second are types (maybe) ex: l, [meter, inch]
// // or v, [meter/time]
// static protected Map<String,List<String>> typeTable = new HashMap<>();
// }

program: statList EOF;

statList: (statement? ';')*;

statement: 
     inputStatement
    | assignment
    | readToArray
    | variableDeclaration
    | conditional
    | outputStatement
    | loopStatement
    | whileStatement
    | doWhileStatement
    | whileStatement
    | headerFile
    | prefixUnit
    | unit
    | alternativeUnit
    | listDeclaration  
    | breakStatement
    | continueStatement
    ;

variableDeclaration: dataType ID ('=' expression)?;

readToArray: castTypes? '('?'read' STRING ')'? ('*'ID)? '>>' ID ;

assignment: ID '=' expression;

inputStatement: ID '=' dataType? '('? 'read' STRING ')'? ('*' ID)?;

outputStatement: write_expr outputFormat (',' outputFormat)*;

outputFormat: ('string' '(' (  ID | STRING | expression ) ',' INT ')') | (STRING ',' ID) | ID | STRING ;

write_expr: 'write' | 'writeln';

loopStatement: 'for' ID '=' (INT | ID) 'to' (INT | ID | length '(' ID ')') 'do' ((statement ';')+ ) 'end';

whileStatement: 'while' '(' expression ')' '{' (statement ';')+ '}';

doWhileStatement: 'do' '{' (statement ';')+ '}' 'while' '(' expression ')';

length : 'length';

breakStatement: 'stop';

continueStatement: 'procede';

headerFile: 'use' STRING;

prefixUnit: 'prefix' dataType ID '=' (INT |  '1e' minus='-'? INT);

unit: 
        'dimension' dataType ID    ('[' ID (',' ID)? ']')                       #independentUnit         
    |   'dimension' dataType ID   ( ('[' ID (',' ID) ']')? '=' expression)      #dependantUnit
;

alternativeUnit: 'unit' ID '[' ID (',' ID)? ']' '=' expression;

listDeclaration: 'list' '[' dataType ']' ID ('=' 'new' 'list' '[' dataType ']')?;

conditional
    : ifBlock (elseBlock)?
    ;

ifBlock
    : 'if' '(' expression ')' '{' (statement ';')+ '}'
    ;
elseBlock
    : 'else' '{' (statement ';')+ '}'
    ;

expression returns[String varName, String dimension, String type]
    : expression op=('*' | '/') expression                                      # MulDivExpression
    | expression op=('+' | '-') expression                                      # AddSubExpression
    | dataType '(' expression ')'                                               # TypeConversion
    | e1=expression op=('==' | '!=' | '<' | '>' | '>=' | '<=') e2=expression    # ConditionalExpression
    | expression op=('and' | 'or') expression                                   # AndOrExpression
    | '(' expression ')'                                                        # ParenExpression
    | 'get' ID '[' INT ']'                                                      # Get_array_idx
    | ID '[' (ID | INT) ']'                                                     # IndexExpression
    | ID                                                                        # IdExpression
    | REAL                                                                      # RealLiteral
    | INT                                                                       # IntLiteral
    | REAL expression                                                           # RealSuffix
    | INT expression                                                            # IntSuffix
    | STRING                                                                    # StringLiteral
    | BOOL                                                                      # BoolLiteral
    ;

dataType  returns [String type] : 
'integer' 
| 'real' 
| 'string' 
| 'list' '[' ID ']' 
| 'bool'
| ID ;

castTypes : 'integer' | 'real';

ID: [a-zA-Z_][a-zA-Z0-9_]*;
INT: [0-9]+;
REAL: [0-9]* '.' [0-9]+;
STRING: '"' .*? '"';
BOOL: 'true' | 'false';

WS: [ \t\r\n]+ -> skip;
LINE_COMMENT: '#' ~[\r\n]* -> skip;
ERROR: .;