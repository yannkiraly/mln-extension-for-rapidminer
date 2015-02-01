/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

grammar TheBeastMLNGrammar;
ruleFile: NL*
          (operationInstruction | weightFunctionDefinition
          | predicateDefinition | weightedFormula | NL)+;
dbFile: possibleWorld (NL+ possibleWorld)* NL?;

//Signature
constant: CONST_ID | STRING;
variable: VAR_ID;
term: constant | variable | (predicate LP term (COM term)* RP) | 
      term builtinPredicate term |
      weightFunctionApplication;
typedVariableList: type variable (COM type variable)*;
//Types
typeLabel: CONST_ID;
typeDefinition: TYPE typeLabel COL (DOTS | (constant (COM constant)*)) SCOL;
type: typeLabel | INTLABEL | DOUBLELABEL;
//Predicates
predicateLabel: VAR_ID;
predicateDefinition: PREDICATE predicateLabel COL type (X type)* SCOL;
predicate: predicateLabel | LEQLABEL | GEQLABEL | EQLABEL | UNDEFINEDLABEL ;
predicateCategory: OBSERVED;
predicateCategoryDefinition: predicateCategory COL predicate (COM predicate)* 
                             SCOL;
//Functions
prefixFunction: ADDFUNC | MINUSFUNC | PRODUCTFUNC | DOUBLEFUNC | ABSFUNC | BINSFUNC;
infixFunction: PLUS | MINUS | STAR | SLASH;
//Weight Functions
weightFunction: VAR_ID;
weightFunctionDefinition: WEIGHTLABEL weightFunction COL type (X type)*
                          ARROW type 
                          (PLUS|MINUS)? SCOL;
weightFunctionApplication: weightFunction LP term (COM term)* RP;

//Data
groundAtomValue: INT | FLOAT | constant;
groundAtomDefinitionRow: groundAtomValue* NL;
groundAtomDefinition: GT predicate NL (groundAtomDefinitionRow) NL;
possibleWorld: GT GT NL (groundAtomDefinition)*;

//Formulas
functionApplication: (prefixFunction LP (term) 
                      ((term) COM)* RP) | 
                      ((term) infixFunction 
                      (term));
builtinPredicate: LT | GT | EQ | LE | GE;
weightTerm: weightFunction LP term (term COM)* RP;
quantification: (BAR type variable COL ((predicate LP term (COM term)* RP)
                | (term builtinPredicate term)) BAR (GE | LE)
    INT);
booleanFormula: term | booleanFormula AND booleanFormula | booleanFormula
                OR booleanFormula | booleanFormula IMPLIES booleanFormula
              | quantification;
formulaName: VAR_ID;
order: INT;
weightedFormulaSplit: FACTORLABEL (LSP order RSP)? formulaName?
                      (LSP GROUNDALLLABEL RSP)?  COL FORLABEL 
                 typedVariableList 
                 NL IFLABEL booleanFormula ADDFUNC LSP booleanFormula RSP 
                 (STAR term)? STAR term SCOL;
weightedFormulaUnsplit: FACTORLABEL (LSP order RSP)? formulaName?
                        (LSP GROUNDALLLABEL RSP)? COL FORLABEL 
                        typedVariableList 
                        NL ADDFUNC LSP booleanFormula IMPLIES booleanFormula RSP
                        (STAR term)? STAR term SCOL;
weightedFormulaAcyclic: FACTORLABEL COL predicate ACYCLICLABEL SCOL;
weightedFormula: weightedFormulaSplit | weightedFormulaUnsplit | 
                 weightedFormulaAcyclic;
//Operation Instructions
operationInstruction: loadStatement |  saveStatement | printStatement |
                typeStatement | collectStatement | includeStatement
                | nextStatement | learnStatement | setStatement;
file: STRING;
path : VAR_ID (DOT VAR_ID)*;
setValue: INT | FLOAT | STRING | TRUELABEL | FALSELABEL;
setStatement: SETLABEL path EQ setValue SCOL;
loadStatement: LOADLABEL (CORPUSLABEL | GLOBALLABEL) FROMLABEL DUMPLABEL?
               (file | RAMLABEL) SCOL;
saveStatement: SAVELABEL (WEIGHTSLABEL | CORPUSLABEL) TOLABEL INSTANCESLABEL? 
               (file | RAMLABEL) SCOL;
printStatement: PRINTLABEL (ATOMSLABEL (DOT predicate)? | WEIGHTSLABEL (DOT 
                weightFunctionApplication) | EVALLABEL) SCOL;
typeStatement: TYPESLABEL TOLABEL (file | RAMLABEL) SCOL;
collectStatement: COLLECTLABEL SCOL;
includeStatement: INCLUDELABEL file SCOL;
nextStatement: NEXTLABEL SCOL;
learnStatement: LEARNLABEL FORLABEL INT EPOCHSLABEL;
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
SCOL: ';';
//Special symbols
EXCL: '!';
BAR: '|';
AND: '&';
OR: '|';
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
ARROW: '->';
//Numbers
INT : '-'?[0-9]+;
FLOAT: '-'?DIGIT+ '.' DIGIT+
     |        '.' DIGIT+
     ;
fragment
    DIGIT:  [0-9]|'e-'|'E-';
//Keywords
TYPE: 'type';
INTLABEL: 'Int';
DOUBLELABEL: 'Double';
PREDICATE: 'predicate';
X: 'x';
LEQLABEL: 'leq';
GEQLABEL: 'geq';
EQLABEL: 'eq';
UNDEFINEDLABEL: 'undefined';
OBSERVED: 'observed';
HIDDEN: 'hidden';
GLOBAL: 'global';
ADDFUNC: 'add';
TRUELABEL: 'true';
FALSELABEL: 'false';
MINUSFUNC: 'minus';
PRODUCTFUNC: 'product';
DOUBLEFUNC: 'double';
ABSFUNC: 'abs';
BINSFUNC: 'bins';
WEIGHTLABEL: 'weight';
FACTORLABEL: 'factor';
FORLABEL: 'for';
IFLABEL: 'if';
ACYCLICLABEL: 'acyclic';
GROUNDALL: 'ground-all';
LOADLABEL: 'load';
FROMLABEL: 'from';
CORPUSLABEL: 'corpus';
SAVELABEL: 'save';
TYPESLABEL: 'types';
TOLABEL: 'to';
GLOBALLABEL: 'global';
PRINTLABEL: 'print';
ATOMSLABEL: 'atoms';
WEIGHTSLABEL: 'weights';
RAMLABEL: 'ram';
COLLECTLABEL: 'collect';
INSTANCESLABEL: 'instances';
INCLUDELABEL: 'include';
EVALLABEL: 'eval';
NEXTLABEL: 'next';
EPOCHSLABEL: 'epochs';
LEARNLABEL: 'learn';
DUMPLABEL: 'dump';
GROUNDALLLABEL: 'ground-all';
SETLABEL: 'set';
//Variables and constants
//Assumption: Variables can begin with a special symbol, constants cannot.
VAR_ID: [a-z'-''_']ID;
CONST_ID: [A-Z]ID;
fragment 
    ID : [a-zA-Z0-9'-''_'\']*;
//Strings
STRING: '"' (ESC|.)*? '"';
fragment
    ESC:'\\"' | '\\\\';