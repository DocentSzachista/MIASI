
grammar Calculator;

file_ : expression* EOF;

//equation
//   : expression relop expression
//   ;

expression
   :  left=expression  op=POW right=expression #pow_exp
   |  left=expression  op=(TIMES | DIV)  right=expression #mult_or_div_exp
   |  left=expression  op=(PLUS | MINUS) right=expression #plus_or_minus_exp
   |  LPAREN atom RPAREN #in_params
   |  (PLUS | MINUS)* atom  #variable
   ;

atom
   : scientific
//   | variable
   ;

scientific
   : SCIENTIFIC_NUMBER
   ;

//variable
//   : VARIABLE
//   ;

//relop
//   : EQ
//   ;


VARIABLE
   : VALID_ID_START VALID_ID_CHAR*
   ;


fragment VALID_ID_START
   : ('a' .. 'z') | ('A' .. 'Z') | '_'
   ;


fragment VALID_ID_CHAR
   : VALID_ID_START | ('0' .. '9')
   ;

//The NUMBER part gets its potential sign from "(PLUS | MINUS)* atom" in the expression rule
SCIENTIFIC_NUMBER
   : NUMBER (E SIGN? UNSIGNED_INTEGER)?
   ;

fragment NUMBER
   : ('0' .. '9') + ('.' ('0' .. '9') +)?
   ;

fragment UNSIGNED_INTEGER
   : ('0' .. '9')+
   ;


fragment E
   : 'E' | 'e'
   ;


fragment SIGN
   : ('+' | '-')
   ;


LPAREN
   : '('
   ;


RPAREN
   : ')'
   ;


PLUS
   : '+'
   ;


MINUS
   : '-'
   ;


TIMES
   : '*'
   ;


DIV
   : '/'
   ;

EQ
   : '='
   ;


POINT
   : '.'
   ;


POW
   : '^'
   ;


WS
   : [ \r\n\t] + -> skip
   ;