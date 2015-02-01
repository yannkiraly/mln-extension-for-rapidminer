/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

grammar TuffyMLNGrammar;
//Overall file structure MLN
ruleFile: (NL* ((typeDecl NL+)*)? 
         (((predicateDecl|functionDecl) NL+)*)?
         (formula NL+)*)?;

//Overall file structure DB
dbFile: (groundFormula NL+)*;

//Overall file structure inference result
infFile: (probabilityStatement NL+)*;

//Overall file structure queries
queryFile: (predicateDecl NL+)*;

//Variables, Types and Constants
constant: STRING | CONST_ID;
expVariable: PLUS variable;
variableLabel: VAR_ID | CONST_ID;
variable: VAR_ID;
number: INT | FLOAT;
exclType: variableLabel EXCL;
type: VAR_ID | exclType;
startNum: number;
endNum: number;
cardinality: INT;

//Lists
constantList: constant (COM constant)*;
variableList: (variable|expVariable) (COM (variable|expVariable))*;
typeList: type (COM type)*;
exNumList: startNum COM DOTS COM endNum;
plainNumList: number (COM number)*;
numList: exNumList | plainNumList;

//Operators
or : OR;
eq : EQ;

//Predicates and functions
function: variableLabel;
builtinFunctionSymbol: PLUS | MINUS | STAR | SLASH | MOD | AND;
builtinPrefixFunctionSymbol: MINUS;
predicate : variableLabel;
builtinPredicateSymbol: GT | LT | GE | LE | EQ | NE;
predicateApplication: (predicate LP  (argument (COM argument)*)? RP) |
				argument builtinPredicateSymbol argument;
functionApplication: (function LP  (argument (COM argument)*)? RP) |
				argument builtinFunctionSymbol argument |
        builtinPrefixFunctionSymbol argument;
argument: 	((predicate|function) LP  (argument (COM argument)*)? RP) |
				argument (builtinPredicateSymbol|builtinFunctionSymbol) argument |
        builtinPrefixFunctionSymbol argument |
				variable|expVariable|constant|number | LP argument RP;

//Ground predicates and functions
groundPredicateApplication: EXCL? (((predicate LP  (groundArgument (COM groundArgument)*)? RP) |
				groundArgument (builtinPredicateSymbol|builtinFunctionSymbol) groundArgument) |
        builtinPrefixFunctionSymbol argument);
groundFunctionApplication: (function LP  (groundArgument (COM groundArgument)*)? RP) |
				groundArgument (builtinPredicateSymbol|builtinFunctionSymbol) groundArgument |
        builtinPrefixFunctionSymbol argument;
groundArgument: 	((predicate|function) LP  (groundArgument (COM groundArgument)*)? RP) |
				groundArgument (builtinPredicateSymbol|builtinFunctionSymbol) groundArgument |
        builtinPrefixFunctionSymbol argument |
				constant|number | LP groundArgument RP;

//Function Definitions
returnValue: constant | number;
functionDef: returnValue EQ groundFunctionApplication;

//Declarations
typeDecl: type EQ LCP (constantList | numList) RCP;
plainPredicate: predicate LP typeList RP;
closedWorldPredicate: STAR plainPredicate;
predicateDecl: (closedWorldPredicate | plainPredicate);
functionDecl: type function LP typeList RP;

//Formulas
plainFormula: predicateApplication | functionApplication | LSP plainFormula RSP |
              LP plainFormula RP | EXCL plainFormula | plainFormula 
              EQ plainFormula | plainFormula or plainFormula | quantification;
probability: FLOAT|INT;
probabilityStatement: probability? groundFormula;
weight: INT | FLOAT | (variable COL);
weights: weight;
weightedFormula: weights plainFormula;
hardFormula: plainFormula DOT;
formula: (plainFormula | weightedFormula | hardFormula);
quantifier: E_QUANT | U_QUANT;
quantification: quantifier variableList plainFormula;
groundFormula: (groundPredicateApplication | functionDef);
//Lexer grammar
//Comments and white space
WEIGHT_OF_LAST: '//////////////WEIGHT OF LAST ITERATION//////////////' .* -> skip;
LINE_COMMENT: '//' ~[\r\n]* -> skip;
COMMENT : '/*' .*? '*/' -> skip;
WS : [ '\t']+ -> skip;
NL : '\r'? '\n';
//Punctuation
LP : '(';
RP : ')';
LCP: '{';
RCP: '}';
LSP: '[';
RSP: ']';
DOTS: '...';
DOT: '.';
BAR: '|';
COL: ':';
COM: ',';
//Special symbols
EXCL: '!';
AND: '^';
OR: 'v';
IMPLIES: '=>';
IFF: '<=>';
U_QUANT: 'FORALL'|'forall'|'Forall';
E_QUANT: 'EXIST'|'exist'|'Exist';
EQ: '=';
PLUS: '+';
STAR : '*';
GT: '>';
LT: '<';
GE: '>=';
LE: '<=';
NE: '!=';
MINUS: '-';
SLASH: '/';
MOD: '%';

//Numbers
INT : '-'?[0-9]+;
FLOAT: '-'?DIGIT+ '.' DIGIT*
     |        '.' DIGIT+
     ;
fragment
    DIGIT:  [0-9]|'e-'|'E-';



//Variables and constants
//Assumption: Variables can begin with a special symbol, constants cannot.
VAR_ID: [a-z'-''_']ID;
CONST_ID: ([A-Z]ID);
fragment 
    ID : [a-zA-Z0-9'-''_'\']*;
//Strings
STRING : '"' (~('"' | '\\' | '\r' | '\n') | '\\' ('"' | '\\'))* '"';
