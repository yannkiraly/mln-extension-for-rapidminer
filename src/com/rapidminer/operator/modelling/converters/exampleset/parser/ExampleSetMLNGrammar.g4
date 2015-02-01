/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

grammar ExampleSetMLNGrammar;
//Overall file structure MLN
ruleFile: ((NL*) ((typeDecl (NL*))*) 
         (((predicateDecl|functionDecl) (NL*))*)
         (formula NL*)*);

//Overall file structure DB
dbFile: (groundFormula NL*)*;

//Overall file structure inference result
infFile: (probabilityStatement NL*)*;

//Overall file structure query predicates
queryFile: ((predicateDecl (NL*))*);

//Variables, Types and Constants
constant: CONST_ID | STRING;
expVariable: PLUS variable;
variable: VAR_ID;
exclType: VAR_ID EXCL;
type: VAR_ID | exclType;
startNumber: number;
endNumber: number;
doubleNL: NL+;
cardinality: INT;
number: INT|FLOAT;

//Lists
constantList: constant NL* (COM constant)*;
variableList: (variable|expVariable) (COM (variable|expVariable))*;
typeList: ((type (COM type)*) | );
exNumList: startNumber COM DOTS COM endNumber;
plainNumList: number (COM number)*;
numList: exNumList | plainNumList;

//Operators
and : AND NL*;
or : OR NL*;
implies: IMPLIES NL*;
iff: IFF NL*;
quantifier: E_QUANT | U_QUANT;
eq : EQ;

//Predicates and functions
function: CONST_ID;
builtinFunctionSymbol: PLUS | MINUS | STAR | SLASH | MOD | AND;
builtinPrefixFunctionSymbol: MINUS;
predicate : CONST_ID;
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
typeDecl: type EQ LCP (|constantList | numList)? RCP;
plainPredicate: predicate LP typeList RP;
closedWorldPredicate: STAR plainPredicate;
predicateDecl: (closedWorldPredicate | plainPredicate);
functionDecl: type function LP typeList RP;

//Formulas
plainFormula: predicateApplication | functionApplication | LSP plainFormula RSP |
              LP plainFormula RP | EXCL plainFormula | 
              plainFormula EQ plainFormula |
              plainFormula and plainFormula | 
              plainFormula or plainFormula | plainFormula implies plainFormula
              | plainFormula iff plainFormula | quantification;
probability: FLOAT | INT;
probabilityStatement: groundFormula probability?;
weight: INT | FLOAT | variable;
utilWeight: weight;
probWeight: weight;
weights: probWeight | COL utilWeight | probWeight COL utilWeight;
weightedFormula: weights plainFormula;
hardFormula: plainFormula DOT;
formula: plainFormula | weightedFormula | hardFormula;
groundFormula: NL* (groundPredicateApplication | functionDef) NL?;
quantification: (quantifier variableList
              plainFormula) | (BAR variableList BAR plainFormula 
                (GE | LE) cardinality);

//Lexer grammar
//Comments and white space
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
COL: ':';
COM: ',';
//Special symbols
EXCL: '!';
BAR: '|';
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
FLOAT: '-'?DIGIT+ '.' DIGIT+
     |        '.' DIGIT+
     ;
fragment
    DIGIT:  [0-9]|'e-'|'E-';

fragment
    ESC:'\\"' | '\\\\';
//Variables and constants
//Assumption: Variables can begin with a special symbol, constants cannot.
VAR_ID: [a-z'-''_']ID;
CONST_ID: [A-Z]ID;
fragment 
    ID : [a-zA-Z0-9'-''_'\']*;
//Strings
STRING: '"' (ESC|.)*? '"';
