grammar CalculatorV2;


prog : stat*;

stat: ID '=' expr NEWLINE                                                           # assign
    | IF cond=expr':' NEWLINE then=stat* ('else:' else_=else_in_if)? ENDIF NEWLINE  # handleConditional
    | WHILE cond=expr':' NEWLINE body=stat* ENDWHILE                                # while
    | 'def' funcName=ID '('')' ':' NEWLINE BEGINFUNC funcBody=stat* ENDFUNC         # functionDecl
    | funcName=ID '('')' NEWLINE                                                    # functionCall
    | 'print' expr NEWLINE                                                          # printExpr
    | NEWLINE                                                                       # blank
    ;
// Ify pętle funkcje (początkowe bez parametrów)*, zmienne lokalne**
// IF statements
// START
else_in_if: stat* ;


comp: ISEQ
    | LT
    | GT
    ;
// END

// Number declaration and operations
//START

expr
    : left=expr op=('*'|'/') right=expr     # MulDiv
    | left=expr op=('+'|'-') right=expr     # AddSub
    | left=expr op=AND right=expr           # andExpr
    | left=expr op=OR right=expr            # orExpr
    | left=expr op=(ISEQ|LT|GT) right=expr  # compExpr
    | INT                                   # int
    | ID                                    # id
    | '(' expr ')'                          # parens
    ;
// END

// Grammar for IF statements
IF: 'if';
AND: 'and';
OR: 'or';
ISEQ: '==';
GT: '>';
LT: '<';
ENDIF: 'fi';
TRUE: 'true';
FALSE: 'false';
// end
// keywordy do operacji arytmetycznych
MUL: '*';
DIV: '/';
ADD: '+';
SUB: '-';
// keywordy do pętli
WHILE: 'while';
ENDWHILE: 'done';
// keywordy do funkcji
BEGINFUNC: 'begin';
ENDFUNC: 'end';

ID : [a-zA-Z]+ ; // match identifiers
INT : [0-9]+ ; // match integers
NEWLINE:'\r'? '\n' ; // return newlines to parser (end-statement signal)
WS : [ \t]+ -> skip ;