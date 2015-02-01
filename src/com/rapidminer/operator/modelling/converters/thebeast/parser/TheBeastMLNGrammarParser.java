// Generated from TheBeastMLNGrammar.g4 by ANTLR 4.2
package com.rapidminer.operator.modelling.converters.thebeast.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TheBeastMLNGrammarParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LINE_COMMENT=1, COMMENT=2, WS=3, NL=4, LP=5, RP=6, LCP=7, RCP=8, LSP=9, 
		RSP=10, DOTS=11, DOT=12, COL=13, COM=14, SCOL=15, EXCL=16, BAR=17, AND=18, 
		OR=19, IMPLIES=20, IFF=21, U_QUANT=22, E_QUANT=23, EQ=24, PLUS=25, STAR=26, 
		GT=27, LT=28, GE=29, LE=30, NE=31, MINUS=32, SLASH=33, MOD=34, ARROW=35, 
		INT=36, FLOAT=37, TYPE=38, INTLABEL=39, DOUBLELABEL=40, PREDICATE=41, 
		X=42, LEQLABEL=43, GEQLABEL=44, EQLABEL=45, UNDEFINEDLABEL=46, OBSERVED=47, 
		HIDDEN=48, GLOBAL=49, ADDFUNC=50, TRUELABEL=51, FALSELABEL=52, MINUSFUNC=53, 
		PRODUCTFUNC=54, DOUBLEFUNC=55, ABSFUNC=56, BINSFUNC=57, WEIGHTLABEL=58, 
		FACTORLABEL=59, FORLABEL=60, IFLABEL=61, ACYCLICLABEL=62, GROUNDALL=63, 
		LOADLABEL=64, FROMLABEL=65, CORPUSLABEL=66, SAVELABEL=67, TYPESLABEL=68, 
		TOLABEL=69, GLOBALLABEL=70, PRINTLABEL=71, ATOMSLABEL=72, WEIGHTSLABEL=73, 
		RAMLABEL=74, COLLECTLABEL=75, INSTANCESLABEL=76, INCLUDELABEL=77, EVALLABEL=78, 
		NEXTLABEL=79, EPOCHSLABEL=80, LEARNLABEL=81, DUMPLABEL=82, GROUNDALLLABEL=83, 
		SETLABEL=84, VAR_ID=85, CONST_ID=86, STRING=87;
	public static final String[] tokenNames = {
		"<INVALID>", "LINE_COMMENT", "COMMENT", "WS", "NL", "'('", "')'", "'{'", 
		"'}'", "'['", "']'", "'...'", "'.'", "':'", "','", "';'", "'!'", "BAR", 
		"'&'", "OR", "'=>'", "'<=>'", "U_QUANT", "E_QUANT", "'='", "'+'", "'*'", 
		"'>'", "'<'", "'>='", "'<='", "'!='", "'-'", "'/'", "'%'", "'->'", "INT", 
		"FLOAT", "'type'", "'Int'", "'Double'", "'predicate'", "'x'", "'leq'", 
		"'geq'", "'eq'", "'undefined'", "'observed'", "'hidden'", "GLOBAL", "'add'", 
		"'true'", "'false'", "'minus'", "'product'", "'double'", "'abs'", "'bins'", 
		"'weight'", "'factor'", "'for'", "'if'", "'acyclic'", "GROUNDALL", "'load'", 
		"'from'", "'corpus'", "'save'", "'types'", "'to'", "GLOBALLABEL", "'print'", 
		"'atoms'", "'weights'", "'ram'", "'collect'", "'instances'", "'include'", 
		"'eval'", "'next'", "'epochs'", "'learn'", "'dump'", "GROUNDALLLABEL", 
		"'set'", "VAR_ID", "CONST_ID", "STRING"
	};
	public static final int
		RULE_ruleFile = 0, RULE_dbFile = 1, RULE_constant = 2, RULE_variable = 3, 
		RULE_term = 4, RULE_typedVariableList = 5, RULE_typeLabel = 6, RULE_typeDefinition = 7, 
		RULE_type = 8, RULE_predicateLabel = 9, RULE_predicateDefinition = 10, 
		RULE_predicate = 11, RULE_predicateCategory = 12, RULE_predicateCategoryDefinition = 13, 
		RULE_prefixFunction = 14, RULE_infixFunction = 15, RULE_weightFunction = 16, 
		RULE_weightFunctionDefinition = 17, RULE_weightFunctionApplication = 18, 
		RULE_groundAtomValue = 19, RULE_groundAtomDefinitionRow = 20, RULE_groundAtomDefinition = 21, 
		RULE_possibleWorld = 22, RULE_functionApplication = 23, RULE_builtinPredicate = 24, 
		RULE_weightTerm = 25, RULE_quantification = 26, RULE_booleanFormula = 27, 
		RULE_formulaName = 28, RULE_order = 29, RULE_weightedFormulaSplit = 30, 
		RULE_weightedFormulaUnsplit = 31, RULE_weightedFormulaAcyclic = 32, RULE_weightedFormula = 33, 
		RULE_operationInstruction = 34, RULE_file = 35, RULE_path = 36, RULE_setValue = 37, 
		RULE_setStatement = 38, RULE_loadStatement = 39, RULE_saveStatement = 40, 
		RULE_printStatement = 41, RULE_typeStatement = 42, RULE_collectStatement = 43, 
		RULE_includeStatement = 44, RULE_nextStatement = 45, RULE_learnStatement = 46;
	public static final String[] ruleNames = {
		"ruleFile", "dbFile", "constant", "variable", "term", "typedVariableList", 
		"typeLabel", "typeDefinition", "type", "predicateLabel", "predicateDefinition", 
		"predicate", "predicateCategory", "predicateCategoryDefinition", "prefixFunction", 
		"infixFunction", "weightFunction", "weightFunctionDefinition", "weightFunctionApplication", 
		"groundAtomValue", "groundAtomDefinitionRow", "groundAtomDefinition", 
		"possibleWorld", "functionApplication", "builtinPredicate", "weightTerm", 
		"quantification", "booleanFormula", "formulaName", "order", "weightedFormulaSplit", 
		"weightedFormulaUnsplit", "weightedFormulaAcyclic", "weightedFormula", 
		"operationInstruction", "file", "path", "setValue", "setStatement", "loadStatement", 
		"saveStatement", "printStatement", "typeStatement", "collectStatement", 
		"includeStatement", "nextStatement", "learnStatement"
	};

	@Override
	public String getGrammarFileName() { return "TheBeastMLNGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TheBeastMLNGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RuleFileContext extends ParserRuleContext {
		public List<TerminalNode> NL() { return getTokens(TheBeastMLNGrammarParser.NL); }
		public List<WeightFunctionDefinitionContext> weightFunctionDefinition() {
			return getRuleContexts(WeightFunctionDefinitionContext.class);
		}
		public PredicateDefinitionContext predicateDefinition(int i) {
			return getRuleContext(PredicateDefinitionContext.class,i);
		}
		public List<OperationInstructionContext> operationInstruction() {
			return getRuleContexts(OperationInstructionContext.class);
		}
		public List<WeightedFormulaContext> weightedFormula() {
			return getRuleContexts(WeightedFormulaContext.class);
		}
		public List<PredicateDefinitionContext> predicateDefinition() {
			return getRuleContexts(PredicateDefinitionContext.class);
		}
		public WeightFunctionDefinitionContext weightFunctionDefinition(int i) {
			return getRuleContext(WeightFunctionDefinitionContext.class,i);
		}
		public TerminalNode NL(int i) {
			return getToken(TheBeastMLNGrammarParser.NL, i);
		}
		public OperationInstructionContext operationInstruction(int i) {
			return getRuleContext(OperationInstructionContext.class,i);
		}
		public WeightedFormulaContext weightedFormula(int i) {
			return getRuleContext(WeightedFormulaContext.class,i);
		}
		public RuleFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleFile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterRuleFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitRuleFile(this);
		}
	}

	public final RuleFileContext ruleFile() throws RecognitionException {
		RuleFileContext _localctx = new RuleFileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_ruleFile);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(94); match(NL);
					}
					} 
				}
				setState(99);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(105); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(105);
				switch (_input.LA(1)) {
				case LOADLABEL:
				case SAVELABEL:
				case TYPESLABEL:
				case PRINTLABEL:
				case COLLECTLABEL:
				case INCLUDELABEL:
				case NEXTLABEL:
				case LEARNLABEL:
				case SETLABEL:
					{
					setState(100); operationInstruction();
					}
					break;
				case WEIGHTLABEL:
					{
					setState(101); weightFunctionDefinition();
					}
					break;
				case PREDICATE:
					{
					setState(102); predicateDefinition();
					}
					break;
				case FACTORLABEL:
					{
					setState(103); weightedFormula();
					}
					break;
				case NL:
					{
					setState(104); match(NL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(107); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NL) | (1L << PREDICATE) | (1L << WEIGHTLABEL) | (1L << FACTORLABEL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (LOADLABEL - 64)) | (1L << (SAVELABEL - 64)) | (1L << (TYPESLABEL - 64)) | (1L << (PRINTLABEL - 64)) | (1L << (COLLECTLABEL - 64)) | (1L << (INCLUDELABEL - 64)) | (1L << (NEXTLABEL - 64)) | (1L << (LEARNLABEL - 64)) | (1L << (SETLABEL - 64)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DbFileContext extends ParserRuleContext {
		public List<TerminalNode> NL() { return getTokens(TheBeastMLNGrammarParser.NL); }
		public PossibleWorldContext possibleWorld(int i) {
			return getRuleContext(PossibleWorldContext.class,i);
		}
		public List<PossibleWorldContext> possibleWorld() {
			return getRuleContexts(PossibleWorldContext.class);
		}
		public TerminalNode NL(int i) {
			return getToken(TheBeastMLNGrammarParser.NL, i);
		}
		public DbFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dbFile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterDbFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitDbFile(this);
		}
	}

	public final DbFileContext dbFile() throws RecognitionException {
		DbFileContext _localctx = new DbFileContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dbFile);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(109); possibleWorld();
			setState(118);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(111); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(110); match(NL);
						}
						}
						setState(113); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NL );
					setState(115); possibleWorld();
					}
					} 
				}
				setState(120);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(122);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(121); match(NL);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(TheBeastMLNGrammarParser.STRING, 0); }
		public TerminalNode CONST_ID() { return getToken(TheBeastMLNGrammarParser.CONST_ID, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			_la = _input.LA(1);
			if ( !(_la==CONST_ID || _la==STRING) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode VAR_ID() { return getToken(TheBeastMLNGrammarParser.VAR_ID, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitVariable(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126); match(VAR_ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public TerminalNode RP() { return getToken(TheBeastMLNGrammarParser.RP, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> COM() { return getTokens(TheBeastMLNGrammarParser.COM); }
		public WeightFunctionApplicationContext weightFunctionApplication() {
			return getRuleContext(WeightFunctionApplicationContext.class,0);
		}
		public TerminalNode LP() { return getToken(TheBeastMLNGrammarParser.LP, 0); }
		public BuiltinPredicateContext builtinPredicate() {
			return getRuleContext(BuiltinPredicateContext.class,0);
		}
		public TerminalNode COM(int i) {
			return getToken(TheBeastMLNGrammarParser.COM, i);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_term, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(129); constant();
				}
				break;

			case 2:
				{
				setState(130); variable();
				}
				break;

			case 3:
				{
				{
				setState(131); predicate();
				setState(132); match(LP);
				setState(133); term(0);
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COM) {
					{
					{
					setState(134); match(COM);
					setState(135); term(0);
					}
					}
					setState(140);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(141); match(RP);
				}
				}
				break;

			case 4:
				{
				setState(143); weightFunctionApplication();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(152);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TermContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_term);
					setState(146);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(147); builtinPredicate();
					setState(148); term(3);
					}
					} 
				}
				setState(154);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TypedVariableListContext extends ParserRuleContext {
		public List<TerminalNode> COM() { return getTokens(TheBeastMLNGrammarParser.COM); }
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public TerminalNode COM(int i) {
			return getToken(TheBeastMLNGrammarParser.COM, i);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public TypedVariableListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedVariableList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterTypedVariableList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitTypedVariableList(this);
		}
	}

	public final TypedVariableListContext typedVariableList() throws RecognitionException {
		TypedVariableListContext _localctx = new TypedVariableListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_typedVariableList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155); type();
			setState(156); variable();
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COM) {
				{
				{
				setState(157); match(COM);
				setState(158); type();
				setState(159); variable();
				}
				}
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeLabelContext extends ParserRuleContext {
		public TerminalNode CONST_ID() { return getToken(TheBeastMLNGrammarParser.CONST_ID, 0); }
		public TypeLabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeLabel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterTypeLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitTypeLabel(this);
		}
	}

	public final TypeLabelContext typeLabel() throws RecognitionException {
		TypeLabelContext _localctx = new TypeLabelContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_typeLabel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166); match(CONST_ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeDefinitionContext extends ParserRuleContext {
		public TerminalNode SCOL() { return getToken(TheBeastMLNGrammarParser.SCOL, 0); }
		public List<ConstantContext> constant() {
			return getRuleContexts(ConstantContext.class);
		}
		public TerminalNode DOTS() { return getToken(TheBeastMLNGrammarParser.DOTS, 0); }
		public List<TerminalNode> COM() { return getTokens(TheBeastMLNGrammarParser.COM); }
		public TerminalNode TYPE() { return getToken(TheBeastMLNGrammarParser.TYPE, 0); }
		public TypeLabelContext typeLabel() {
			return getRuleContext(TypeLabelContext.class,0);
		}
		public TerminalNode COL() { return getToken(TheBeastMLNGrammarParser.COL, 0); }
		public TerminalNode COM(int i) {
			return getToken(TheBeastMLNGrammarParser.COM, i);
		}
		public ConstantContext constant(int i) {
			return getRuleContext(ConstantContext.class,i);
		}
		public TypeDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterTypeDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitTypeDefinition(this);
		}
	}

	public final TypeDefinitionContext typeDefinition() throws RecognitionException {
		TypeDefinitionContext _localctx = new TypeDefinitionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_typeDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168); match(TYPE);
			setState(169); typeLabel();
			setState(170); match(COL);
			setState(180);
			switch (_input.LA(1)) {
			case DOTS:
				{
				setState(171); match(DOTS);
				}
				break;
			case CONST_ID:
			case STRING:
				{
				{
				setState(172); constant();
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COM) {
					{
					{
					setState(173); match(COM);
					setState(174); constant();
					}
					}
					setState(179);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(182); match(SCOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INTLABEL() { return getToken(TheBeastMLNGrammarParser.INTLABEL, 0); }
		public TerminalNode DOUBLELABEL() { return getToken(TheBeastMLNGrammarParser.DOUBLELABEL, 0); }
		public TypeLabelContext typeLabel() {
			return getRuleContext(TypeLabelContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_type);
		try {
			setState(187);
			switch (_input.LA(1)) {
			case CONST_ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(184); typeLabel();
				}
				break;
			case INTLABEL:
				enterOuterAlt(_localctx, 2);
				{
				setState(185); match(INTLABEL);
				}
				break;
			case DOUBLELABEL:
				enterOuterAlt(_localctx, 3);
				{
				setState(186); match(DOUBLELABEL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateLabelContext extends ParserRuleContext {
		public TerminalNode VAR_ID() { return getToken(TheBeastMLNGrammarParser.VAR_ID, 0); }
		public PredicateLabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateLabel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterPredicateLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitPredicateLabel(this);
		}
	}

	public final PredicateLabelContext predicateLabel() throws RecognitionException {
		PredicateLabelContext _localctx = new PredicateLabelContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_predicateLabel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189); match(VAR_ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateDefinitionContext extends ParserRuleContext {
		public TerminalNode SCOL() { return getToken(TheBeastMLNGrammarParser.SCOL, 0); }
		public TerminalNode X(int i) {
			return getToken(TheBeastMLNGrammarParser.X, i);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> X() { return getTokens(TheBeastMLNGrammarParser.X); }
		public TerminalNode PREDICATE() { return getToken(TheBeastMLNGrammarParser.PREDICATE, 0); }
		public TerminalNode COL() { return getToken(TheBeastMLNGrammarParser.COL, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public PredicateLabelContext predicateLabel() {
			return getRuleContext(PredicateLabelContext.class,0);
		}
		public PredicateDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterPredicateDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitPredicateDefinition(this);
		}
	}

	public final PredicateDefinitionContext predicateDefinition() throws RecognitionException {
		PredicateDefinitionContext _localctx = new PredicateDefinitionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_predicateDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191); match(PREDICATE);
			setState(192); predicateLabel();
			setState(193); match(COL);
			setState(194); type();
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==X) {
				{
				{
				setState(195); match(X);
				setState(196); type();
				}
				}
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(202); match(SCOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateContext extends ParserRuleContext {
		public TerminalNode LEQLABEL() { return getToken(TheBeastMLNGrammarParser.LEQLABEL, 0); }
		public TerminalNode EQLABEL() { return getToken(TheBeastMLNGrammarParser.EQLABEL, 0); }
		public TerminalNode UNDEFINEDLABEL() { return getToken(TheBeastMLNGrammarParser.UNDEFINEDLABEL, 0); }
		public PredicateLabelContext predicateLabel() {
			return getRuleContext(PredicateLabelContext.class,0);
		}
		public TerminalNode GEQLABEL() { return getToken(TheBeastMLNGrammarParser.GEQLABEL, 0); }
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitPredicate(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_predicate);
		try {
			setState(209);
			switch (_input.LA(1)) {
			case VAR_ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(204); predicateLabel();
				}
				break;
			case LEQLABEL:
				enterOuterAlt(_localctx, 2);
				{
				setState(205); match(LEQLABEL);
				}
				break;
			case GEQLABEL:
				enterOuterAlt(_localctx, 3);
				{
				setState(206); match(GEQLABEL);
				}
				break;
			case EQLABEL:
				enterOuterAlt(_localctx, 4);
				{
				setState(207); match(EQLABEL);
				}
				break;
			case UNDEFINEDLABEL:
				enterOuterAlt(_localctx, 5);
				{
				setState(208); match(UNDEFINEDLABEL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateCategoryContext extends ParserRuleContext {
		public TerminalNode OBSERVED() { return getToken(TheBeastMLNGrammarParser.OBSERVED, 0); }
		public PredicateCategoryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateCategory; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterPredicateCategory(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitPredicateCategory(this);
		}
	}

	public final PredicateCategoryContext predicateCategory() throws RecognitionException {
		PredicateCategoryContext _localctx = new PredicateCategoryContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_predicateCategory);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211); match(OBSERVED);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateCategoryDefinitionContext extends ParserRuleContext {
		public PredicateCategoryContext predicateCategory() {
			return getRuleContext(PredicateCategoryContext.class,0);
		}
		public TerminalNode SCOL() { return getToken(TheBeastMLNGrammarParser.SCOL, 0); }
		public List<TerminalNode> COM() { return getTokens(TheBeastMLNGrammarParser.COM); }
		public TerminalNode COL() { return getToken(TheBeastMLNGrammarParser.COL, 0); }
		public TerminalNode COM(int i) {
			return getToken(TheBeastMLNGrammarParser.COM, i);
		}
		public PredicateContext predicate(int i) {
			return getRuleContext(PredicateContext.class,i);
		}
		public List<PredicateContext> predicate() {
			return getRuleContexts(PredicateContext.class);
		}
		public PredicateCategoryDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateCategoryDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterPredicateCategoryDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitPredicateCategoryDefinition(this);
		}
	}

	public final PredicateCategoryDefinitionContext predicateCategoryDefinition() throws RecognitionException {
		PredicateCategoryDefinitionContext _localctx = new PredicateCategoryDefinitionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_predicateCategoryDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213); predicateCategory();
			setState(214); match(COL);
			setState(215); predicate();
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COM) {
				{
				{
				setState(216); match(COM);
				setState(217); predicate();
				}
				}
				setState(222);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(223); match(SCOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrefixFunctionContext extends ParserRuleContext {
		public TerminalNode BINSFUNC() { return getToken(TheBeastMLNGrammarParser.BINSFUNC, 0); }
		public TerminalNode ADDFUNC() { return getToken(TheBeastMLNGrammarParser.ADDFUNC, 0); }
		public TerminalNode PRODUCTFUNC() { return getToken(TheBeastMLNGrammarParser.PRODUCTFUNC, 0); }
		public TerminalNode MINUSFUNC() { return getToken(TheBeastMLNGrammarParser.MINUSFUNC, 0); }
		public TerminalNode DOUBLEFUNC() { return getToken(TheBeastMLNGrammarParser.DOUBLEFUNC, 0); }
		public TerminalNode ABSFUNC() { return getToken(TheBeastMLNGrammarParser.ABSFUNC, 0); }
		public PrefixFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterPrefixFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitPrefixFunction(this);
		}
	}

	public final PrefixFunctionContext prefixFunction() throws RecognitionException {
		PrefixFunctionContext _localctx = new PrefixFunctionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_prefixFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADDFUNC) | (1L << MINUSFUNC) | (1L << PRODUCTFUNC) | (1L << DOUBLEFUNC) | (1L << ABSFUNC) | (1L << BINSFUNC))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InfixFunctionContext extends ParserRuleContext {
		public TerminalNode SLASH() { return getToken(TheBeastMLNGrammarParser.SLASH, 0); }
		public TerminalNode PLUS() { return getToken(TheBeastMLNGrammarParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(TheBeastMLNGrammarParser.MINUS, 0); }
		public TerminalNode STAR() { return getToken(TheBeastMLNGrammarParser.STAR, 0); }
		public InfixFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_infixFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterInfixFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitInfixFunction(this);
		}
	}

	public final InfixFunctionContext infixFunction() throws RecognitionException {
		InfixFunctionContext _localctx = new InfixFunctionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_infixFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << STAR) | (1L << MINUS) | (1L << SLASH))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WeightFunctionContext extends ParserRuleContext {
		public TerminalNode VAR_ID() { return getToken(TheBeastMLNGrammarParser.VAR_ID, 0); }
		public WeightFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_weightFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterWeightFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitWeightFunction(this);
		}
	}

	public final WeightFunctionContext weightFunction() throws RecognitionException {
		WeightFunctionContext _localctx = new WeightFunctionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_weightFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229); match(VAR_ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WeightFunctionDefinitionContext extends ParserRuleContext {
		public TerminalNode WEIGHTLABEL() { return getToken(TheBeastMLNGrammarParser.WEIGHTLABEL, 0); }
		public TerminalNode SCOL() { return getToken(TheBeastMLNGrammarParser.SCOL, 0); }
		public WeightFunctionContext weightFunction() {
			return getRuleContext(WeightFunctionContext.class,0);
		}
		public TerminalNode X(int i) {
			return getToken(TheBeastMLNGrammarParser.X, i);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> X() { return getTokens(TheBeastMLNGrammarParser.X); }
		public TerminalNode COL() { return getToken(TheBeastMLNGrammarParser.COL, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TerminalNode PLUS() { return getToken(TheBeastMLNGrammarParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(TheBeastMLNGrammarParser.MINUS, 0); }
		public TerminalNode ARROW() { return getToken(TheBeastMLNGrammarParser.ARROW, 0); }
		public WeightFunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_weightFunctionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterWeightFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitWeightFunctionDefinition(this);
		}
	}

	public final WeightFunctionDefinitionContext weightFunctionDefinition() throws RecognitionException {
		WeightFunctionDefinitionContext _localctx = new WeightFunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_weightFunctionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231); match(WEIGHTLABEL);
			setState(232); weightFunction();
			setState(233); match(COL);
			setState(234); type();
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==X) {
				{
				{
				setState(235); match(X);
				setState(236); type();
				}
				}
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(242); match(ARROW);
			setState(243); type();
			setState(245);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(244);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(247); match(SCOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WeightFunctionApplicationContext extends ParserRuleContext {
		public TerminalNode RP() { return getToken(TheBeastMLNGrammarParser.RP, 0); }
		public WeightFunctionContext weightFunction() {
			return getRuleContext(WeightFunctionContext.class,0);
		}
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> COM() { return getTokens(TheBeastMLNGrammarParser.COM); }
		public TerminalNode LP() { return getToken(TheBeastMLNGrammarParser.LP, 0); }
		public TerminalNode COM(int i) {
			return getToken(TheBeastMLNGrammarParser.COM, i);
		}
		public WeightFunctionApplicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_weightFunctionApplication; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterWeightFunctionApplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitWeightFunctionApplication(this);
		}
	}

	public final WeightFunctionApplicationContext weightFunctionApplication() throws RecognitionException {
		WeightFunctionApplicationContext _localctx = new WeightFunctionApplicationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_weightFunctionApplication);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249); weightFunction();
			setState(250); match(LP);
			setState(251); term(0);
			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COM) {
				{
				{
				setState(252); match(COM);
				setState(253); term(0);
				}
				}
				setState(258);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(259); match(RP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroundAtomValueContext extends ParserRuleContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public TerminalNode INT() { return getToken(TheBeastMLNGrammarParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(TheBeastMLNGrammarParser.FLOAT, 0); }
		public GroundAtomValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groundAtomValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterGroundAtomValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitGroundAtomValue(this);
		}
	}

	public final GroundAtomValueContext groundAtomValue() throws RecognitionException {
		GroundAtomValueContext _localctx = new GroundAtomValueContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_groundAtomValue);
		try {
			setState(264);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(261); match(INT);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(262); match(FLOAT);
				}
				break;
			case CONST_ID:
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(263); constant();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroundAtomDefinitionRowContext extends ParserRuleContext {
		public TerminalNode NL() { return getToken(TheBeastMLNGrammarParser.NL, 0); }
		public List<GroundAtomValueContext> groundAtomValue() {
			return getRuleContexts(GroundAtomValueContext.class);
		}
		public GroundAtomValueContext groundAtomValue(int i) {
			return getRuleContext(GroundAtomValueContext.class,i);
		}
		public GroundAtomDefinitionRowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groundAtomDefinitionRow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterGroundAtomDefinitionRow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitGroundAtomDefinitionRow(this);
		}
	}

	public final GroundAtomDefinitionRowContext groundAtomDefinitionRow() throws RecognitionException {
		GroundAtomDefinitionRowContext _localctx = new GroundAtomDefinitionRowContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_groundAtomDefinitionRow);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 36)) & ~0x3f) == 0 && ((1L << (_la - 36)) & ((1L << (INT - 36)) | (1L << (FLOAT - 36)) | (1L << (CONST_ID - 36)) | (1L << (STRING - 36)))) != 0)) {
				{
				{
				setState(266); groundAtomValue();
				}
				}
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(272); match(NL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroundAtomDefinitionContext extends ParserRuleContext {
		public List<TerminalNode> NL() { return getTokens(TheBeastMLNGrammarParser.NL); }
		public TerminalNode GT() { return getToken(TheBeastMLNGrammarParser.GT, 0); }
		public GroundAtomDefinitionRowContext groundAtomDefinitionRow() {
			return getRuleContext(GroundAtomDefinitionRowContext.class,0);
		}
		public TerminalNode NL(int i) {
			return getToken(TheBeastMLNGrammarParser.NL, i);
		}
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public GroundAtomDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groundAtomDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterGroundAtomDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitGroundAtomDefinition(this);
		}
	}

	public final GroundAtomDefinitionContext groundAtomDefinition() throws RecognitionException {
		GroundAtomDefinitionContext _localctx = new GroundAtomDefinitionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_groundAtomDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274); match(GT);
			setState(275); predicate();
			setState(276); match(NL);
			{
			setState(277); groundAtomDefinitionRow();
			}
			setState(278); match(NL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PossibleWorldContext extends ParserRuleContext {
		public TerminalNode NL() { return getToken(TheBeastMLNGrammarParser.NL, 0); }
		public GroundAtomDefinitionContext groundAtomDefinition(int i) {
			return getRuleContext(GroundAtomDefinitionContext.class,i);
		}
		public List<TerminalNode> GT() { return getTokens(TheBeastMLNGrammarParser.GT); }
		public List<GroundAtomDefinitionContext> groundAtomDefinition() {
			return getRuleContexts(GroundAtomDefinitionContext.class);
		}
		public TerminalNode GT(int i) {
			return getToken(TheBeastMLNGrammarParser.GT, i);
		}
		public PossibleWorldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_possibleWorld; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterPossibleWorld(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitPossibleWorld(this);
		}
	}

	public final PossibleWorldContext possibleWorld() throws RecognitionException {
		PossibleWorldContext _localctx = new PossibleWorldContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_possibleWorld);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280); match(GT);
			setState(281); match(GT);
			setState(282); match(NL);
			setState(286);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GT) {
				{
				{
				setState(283); groundAtomDefinition();
				}
				}
				setState(288);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionApplicationContext extends ParserRuleContext {
		public TerminalNode RP() { return getToken(TheBeastMLNGrammarParser.RP, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> COM() { return getTokens(TheBeastMLNGrammarParser.COM); }
		public TerminalNode LP() { return getToken(TheBeastMLNGrammarParser.LP, 0); }
		public InfixFunctionContext infixFunction() {
			return getRuleContext(InfixFunctionContext.class,0);
		}
		public TerminalNode COM(int i) {
			return getToken(TheBeastMLNGrammarParser.COM, i);
		}
		public PrefixFunctionContext prefixFunction() {
			return getRuleContext(PrefixFunctionContext.class,0);
		}
		public FunctionApplicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionApplication; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterFunctionApplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitFunctionApplication(this);
		}
	}

	public final FunctionApplicationContext functionApplication() throws RecognitionException {
		FunctionApplicationContext _localctx = new FunctionApplicationContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_functionApplication);
		int _la;
		try {
			setState(306);
			switch (_input.LA(1)) {
			case ADDFUNC:
			case MINUSFUNC:
			case PRODUCTFUNC:
			case DOUBLEFUNC:
			case ABSFUNC:
			case BINSFUNC:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(289); prefixFunction();
				setState(290); match(LP);
				{
				setState(291); term(0);
				}
				setState(297);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (LEQLABEL - 43)) | (1L << (GEQLABEL - 43)) | (1L << (EQLABEL - 43)) | (1L << (UNDEFINEDLABEL - 43)) | (1L << (VAR_ID - 43)) | (1L << (CONST_ID - 43)) | (1L << (STRING - 43)))) != 0)) {
					{
					{
					{
					setState(292); term(0);
					}
					setState(293); match(COM);
					}
					}
					setState(299);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(300); match(RP);
				}
				}
				break;
			case LEQLABEL:
			case GEQLABEL:
			case EQLABEL:
			case UNDEFINEDLABEL:
			case VAR_ID:
			case CONST_ID:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				{
				{
				setState(302); term(0);
				}
				setState(303); infixFunction();
				{
				setState(304); term(0);
				}
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BuiltinPredicateContext extends ParserRuleContext {
		public TerminalNode GE() { return getToken(TheBeastMLNGrammarParser.GE, 0); }
		public TerminalNode LT() { return getToken(TheBeastMLNGrammarParser.LT, 0); }
		public TerminalNode GT() { return getToken(TheBeastMLNGrammarParser.GT, 0); }
		public TerminalNode LE() { return getToken(TheBeastMLNGrammarParser.LE, 0); }
		public TerminalNode EQ() { return getToken(TheBeastMLNGrammarParser.EQ, 0); }
		public BuiltinPredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtinPredicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterBuiltinPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitBuiltinPredicate(this);
		}
	}

	public final BuiltinPredicateContext builtinPredicate() throws RecognitionException {
		BuiltinPredicateContext _localctx = new BuiltinPredicateContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_builtinPredicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << GT) | (1L << LT) | (1L << GE) | (1L << LE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WeightTermContext extends ParserRuleContext {
		public TerminalNode RP() { return getToken(TheBeastMLNGrammarParser.RP, 0); }
		public WeightFunctionContext weightFunction() {
			return getRuleContext(WeightFunctionContext.class,0);
		}
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> COM() { return getTokens(TheBeastMLNGrammarParser.COM); }
		public TerminalNode LP() { return getToken(TheBeastMLNGrammarParser.LP, 0); }
		public TerminalNode COM(int i) {
			return getToken(TheBeastMLNGrammarParser.COM, i);
		}
		public WeightTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_weightTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterWeightTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitWeightTerm(this);
		}
	}

	public final WeightTermContext weightTerm() throws RecognitionException {
		WeightTermContext _localctx = new WeightTermContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_weightTerm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310); weightFunction();
			setState(311); match(LP);
			setState(312); term(0);
			setState(318);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (LEQLABEL - 43)) | (1L << (GEQLABEL - 43)) | (1L << (EQLABEL - 43)) | (1L << (UNDEFINEDLABEL - 43)) | (1L << (VAR_ID - 43)) | (1L << (CONST_ID - 43)) | (1L << (STRING - 43)))) != 0)) {
				{
				{
				setState(313); term(0);
				setState(314); match(COM);
				}
				}
				setState(320);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(321); match(RP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantificationContext extends ParserRuleContext {
		public TerminalNode RP() { return getToken(TheBeastMLNGrammarParser.RP, 0); }
		public TerminalNode GE() { return getToken(TheBeastMLNGrammarParser.GE, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> COM() { return getTokens(TheBeastMLNGrammarParser.COM); }
		public BuiltinPredicateContext builtinPredicate() {
			return getRuleContext(BuiltinPredicateContext.class,0);
		}
		public TerminalNode BAR(int i) {
			return getToken(TheBeastMLNGrammarParser.BAR, i);
		}
		public TerminalNode LE() { return getToken(TheBeastMLNGrammarParser.LE, 0); }
		public TerminalNode COM(int i) {
			return getToken(TheBeastMLNGrammarParser.COM, i);
		}
		public TerminalNode INT() { return getToken(TheBeastMLNGrammarParser.INT, 0); }
		public List<TerminalNode> BAR() { return getTokens(TheBeastMLNGrammarParser.BAR); }
		public TerminalNode LP() { return getToken(TheBeastMLNGrammarParser.LP, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode COL() { return getToken(TheBeastMLNGrammarParser.COL, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public QuantificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterQuantification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitQuantification(this);
		}
	}

	public final QuantificationContext quantification() throws RecognitionException {
		QuantificationContext _localctx = new QuantificationContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_quantification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(323); match(BAR);
			setState(324); type();
			setState(325); variable();
			setState(326); match(COL);
			setState(343);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				{
				setState(327); predicate();
				setState(328); match(LP);
				setState(329); term(0);
				setState(334);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COM) {
					{
					{
					setState(330); match(COM);
					setState(331); term(0);
					}
					}
					setState(336);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(337); match(RP);
				}
				}
				break;

			case 2:
				{
				{
				setState(339); term(0);
				setState(340); builtinPredicate();
				setState(341); term(0);
				}
				}
				break;
			}
			setState(345); match(BAR);
			setState(346);
			_la = _input.LA(1);
			if ( !(_la==GE || _la==LE) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(347); match(INT);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanFormulaContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public QuantificationContext quantification() {
			return getRuleContext(QuantificationContext.class,0);
		}
		public BooleanFormulaContext booleanFormula(int i) {
			return getRuleContext(BooleanFormulaContext.class,i);
		}
		public TerminalNode IMPLIES() { return getToken(TheBeastMLNGrammarParser.IMPLIES, 0); }
		public TerminalNode AND() { return getToken(TheBeastMLNGrammarParser.AND, 0); }
		public TerminalNode OR() { return getToken(TheBeastMLNGrammarParser.OR, 0); }
		public List<BooleanFormulaContext> booleanFormula() {
			return getRuleContexts(BooleanFormulaContext.class);
		}
		public BooleanFormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanFormula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterBooleanFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitBooleanFormula(this);
		}
	}

	public final BooleanFormulaContext booleanFormula() throws RecognitionException {
		return booleanFormula(0);
	}

	private BooleanFormulaContext booleanFormula(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BooleanFormulaContext _localctx = new BooleanFormulaContext(_ctx, _parentState);
		BooleanFormulaContext _prevctx = _localctx;
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_booleanFormula, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			switch (_input.LA(1)) {
			case LEQLABEL:
			case GEQLABEL:
			case EQLABEL:
			case UNDEFINEDLABEL:
			case VAR_ID:
			case CONST_ID:
			case STRING:
				{
				setState(350); term(0);
				}
				break;
			case BAR:
				{
				setState(351); quantification();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(365);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(363);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						_localctx = new BooleanFormulaContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_booleanFormula);
						setState(354);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(355); match(AND);
						setState(356); booleanFormula(5);
						}
						break;

					case 2:
						{
						_localctx = new BooleanFormulaContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_booleanFormula);
						setState(357);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(358); match(OR);
						setState(359); booleanFormula(4);
						}
						break;

					case 3:
						{
						_localctx = new BooleanFormulaContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_booleanFormula);
						setState(360);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(361); match(IMPLIES);
						setState(362); booleanFormula(3);
						}
						break;
					}
					} 
				}
				setState(367);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FormulaNameContext extends ParserRuleContext {
		public TerminalNode VAR_ID() { return getToken(TheBeastMLNGrammarParser.VAR_ID, 0); }
		public FormulaNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formulaName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterFormulaName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitFormulaName(this);
		}
	}

	public final FormulaNameContext formulaName() throws RecognitionException {
		FormulaNameContext _localctx = new FormulaNameContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_formulaName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368); match(VAR_ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrderContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(TheBeastMLNGrammarParser.INT, 0); }
		public OrderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_order; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterOrder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitOrder(this);
		}
	}

	public final OrderContext order() throws RecognitionException {
		OrderContext _localctx = new OrderContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_order);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370); match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WeightedFormulaSplitContext extends ParserRuleContext {
		public TerminalNode NL() { return getToken(TheBeastMLNGrammarParser.NL, 0); }
		public TerminalNode FORLABEL() { return getToken(TheBeastMLNGrammarParser.FORLABEL, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public BooleanFormulaContext booleanFormula(int i) {
			return getRuleContext(BooleanFormulaContext.class,i);
		}
		public TerminalNode ADDFUNC() { return getToken(TheBeastMLNGrammarParser.ADDFUNC, 0); }
		public TerminalNode GROUNDALLLABEL() { return getToken(TheBeastMLNGrammarParser.GROUNDALLLABEL, 0); }
		public OrderContext order() {
			return getRuleContext(OrderContext.class,0);
		}
		public List<TerminalNode> LSP() { return getTokens(TheBeastMLNGrammarParser.LSP); }
		public TerminalNode LSP(int i) {
			return getToken(TheBeastMLNGrammarParser.LSP, i);
		}
		public TypedVariableListContext typedVariableList() {
			return getRuleContext(TypedVariableListContext.class,0);
		}
		public TerminalNode RSP(int i) {
			return getToken(TheBeastMLNGrammarParser.RSP, i);
		}
		public List<TerminalNode> STAR() { return getTokens(TheBeastMLNGrammarParser.STAR); }
		public TerminalNode IFLABEL() { return getToken(TheBeastMLNGrammarParser.IFLABEL, 0); }
		public TerminalNode STAR(int i) {
			return getToken(TheBeastMLNGrammarParser.STAR, i);
		}
		public TerminalNode SCOL() { return getToken(TheBeastMLNGrammarParser.SCOL, 0); }
		public TerminalNode FACTORLABEL() { return getToken(TheBeastMLNGrammarParser.FACTORLABEL, 0); }
		public List<TerminalNode> RSP() { return getTokens(TheBeastMLNGrammarParser.RSP); }
		public TerminalNode COL() { return getToken(TheBeastMLNGrammarParser.COL, 0); }
		public List<BooleanFormulaContext> booleanFormula() {
			return getRuleContexts(BooleanFormulaContext.class);
		}
		public FormulaNameContext formulaName() {
			return getRuleContext(FormulaNameContext.class,0);
		}
		public WeightedFormulaSplitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_weightedFormulaSplit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterWeightedFormulaSplit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitWeightedFormulaSplit(this);
		}
	}

	public final WeightedFormulaSplitContext weightedFormulaSplit() throws RecognitionException {
		WeightedFormulaSplitContext _localctx = new WeightedFormulaSplitContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_weightedFormulaSplit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372); match(FACTORLABEL);
			setState(377);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(373); match(LSP);
				setState(374); order();
				setState(375); match(RSP);
				}
				break;
			}
			setState(380);
			_la = _input.LA(1);
			if (_la==VAR_ID) {
				{
				setState(379); formulaName();
				}
			}

			setState(385);
			_la = _input.LA(1);
			if (_la==LSP) {
				{
				setState(382); match(LSP);
				setState(383); match(GROUNDALLLABEL);
				setState(384); match(RSP);
				}
			}

			setState(387); match(COL);
			setState(388); match(FORLABEL);
			setState(389); typedVariableList();
			setState(390); match(NL);
			setState(391); match(IFLABEL);
			setState(392); booleanFormula(0);
			setState(393); match(ADDFUNC);
			setState(394); match(LSP);
			setState(395); booleanFormula(0);
			setState(396); match(RSP);
			setState(399);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(397); match(STAR);
				setState(398); term(0);
				}
				break;
			}
			setState(401); match(STAR);
			setState(402); term(0);
			setState(403); match(SCOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WeightedFormulaUnsplitContext extends ParserRuleContext {
		public TerminalNode NL() { return getToken(TheBeastMLNGrammarParser.NL, 0); }
		public TerminalNode FORLABEL() { return getToken(TheBeastMLNGrammarParser.FORLABEL, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode ADDFUNC() { return getToken(TheBeastMLNGrammarParser.ADDFUNC, 0); }
		public BooleanFormulaContext booleanFormula(int i) {
			return getRuleContext(BooleanFormulaContext.class,i);
		}
		public TerminalNode GROUNDALLLABEL() { return getToken(TheBeastMLNGrammarParser.GROUNDALLLABEL, 0); }
		public OrderContext order() {
			return getRuleContext(OrderContext.class,0);
		}
		public List<TerminalNode> LSP() { return getTokens(TheBeastMLNGrammarParser.LSP); }
		public TerminalNode LSP(int i) {
			return getToken(TheBeastMLNGrammarParser.LSP, i);
		}
		public TypedVariableListContext typedVariableList() {
			return getRuleContext(TypedVariableListContext.class,0);
		}
		public TerminalNode RSP(int i) {
			return getToken(TheBeastMLNGrammarParser.RSP, i);
		}
		public List<TerminalNode> STAR() { return getTokens(TheBeastMLNGrammarParser.STAR); }
		public TerminalNode STAR(int i) {
			return getToken(TheBeastMLNGrammarParser.STAR, i);
		}
		public TerminalNode SCOL() { return getToken(TheBeastMLNGrammarParser.SCOL, 0); }
		public TerminalNode FACTORLABEL() { return getToken(TheBeastMLNGrammarParser.FACTORLABEL, 0); }
		public TerminalNode IMPLIES() { return getToken(TheBeastMLNGrammarParser.IMPLIES, 0); }
		public List<TerminalNode> RSP() { return getTokens(TheBeastMLNGrammarParser.RSP); }
		public TerminalNode COL() { return getToken(TheBeastMLNGrammarParser.COL, 0); }
		public List<BooleanFormulaContext> booleanFormula() {
			return getRuleContexts(BooleanFormulaContext.class);
		}
		public FormulaNameContext formulaName() {
			return getRuleContext(FormulaNameContext.class,0);
		}
		public WeightedFormulaUnsplitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_weightedFormulaUnsplit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterWeightedFormulaUnsplit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitWeightedFormulaUnsplit(this);
		}
	}

	public final WeightedFormulaUnsplitContext weightedFormulaUnsplit() throws RecognitionException {
		WeightedFormulaUnsplitContext _localctx = new WeightedFormulaUnsplitContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_weightedFormulaUnsplit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(405); match(FACTORLABEL);
			setState(410);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(406); match(LSP);
				setState(407); order();
				setState(408); match(RSP);
				}
				break;
			}
			setState(413);
			_la = _input.LA(1);
			if (_la==VAR_ID) {
				{
				setState(412); formulaName();
				}
			}

			setState(418);
			_la = _input.LA(1);
			if (_la==LSP) {
				{
				setState(415); match(LSP);
				setState(416); match(GROUNDALLLABEL);
				setState(417); match(RSP);
				}
			}

			setState(420); match(COL);
			setState(421); match(FORLABEL);
			setState(422); typedVariableList();
			setState(423); match(NL);
			setState(424); match(ADDFUNC);
			setState(425); match(LSP);
			setState(426); booleanFormula(0);
			setState(427); match(IMPLIES);
			setState(428); booleanFormula(0);
			setState(429); match(RSP);
			setState(432);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(430); match(STAR);
				setState(431); term(0);
				}
				break;
			}
			setState(434); match(STAR);
			setState(435); term(0);
			setState(436); match(SCOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WeightedFormulaAcyclicContext extends ParserRuleContext {
		public TerminalNode ACYCLICLABEL() { return getToken(TheBeastMLNGrammarParser.ACYCLICLABEL, 0); }
		public TerminalNode SCOL() { return getToken(TheBeastMLNGrammarParser.SCOL, 0); }
		public TerminalNode FACTORLABEL() { return getToken(TheBeastMLNGrammarParser.FACTORLABEL, 0); }
		public TerminalNode COL() { return getToken(TheBeastMLNGrammarParser.COL, 0); }
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public WeightedFormulaAcyclicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_weightedFormulaAcyclic; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterWeightedFormulaAcyclic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitWeightedFormulaAcyclic(this);
		}
	}

	public final WeightedFormulaAcyclicContext weightedFormulaAcyclic() throws RecognitionException {
		WeightedFormulaAcyclicContext _localctx = new WeightedFormulaAcyclicContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_weightedFormulaAcyclic);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(438); match(FACTORLABEL);
			setState(439); match(COL);
			setState(440); predicate();
			setState(441); match(ACYCLICLABEL);
			setState(442); match(SCOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WeightedFormulaContext extends ParserRuleContext {
		public WeightedFormulaSplitContext weightedFormulaSplit() {
			return getRuleContext(WeightedFormulaSplitContext.class,0);
		}
		public WeightedFormulaAcyclicContext weightedFormulaAcyclic() {
			return getRuleContext(WeightedFormulaAcyclicContext.class,0);
		}
		public WeightedFormulaUnsplitContext weightedFormulaUnsplit() {
			return getRuleContext(WeightedFormulaUnsplitContext.class,0);
		}
		public WeightedFormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_weightedFormula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterWeightedFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitWeightedFormula(this);
		}
	}

	public final WeightedFormulaContext weightedFormula() throws RecognitionException {
		WeightedFormulaContext _localctx = new WeightedFormulaContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_weightedFormula);
		try {
			setState(447);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(444); weightedFormulaSplit();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(445); weightedFormulaUnsplit();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(446); weightedFormulaAcyclic();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperationInstructionContext extends ParserRuleContext {
		public TypeStatementContext typeStatement() {
			return getRuleContext(TypeStatementContext.class,0);
		}
		public SaveStatementContext saveStatement() {
			return getRuleContext(SaveStatementContext.class,0);
		}
		public IncludeStatementContext includeStatement() {
			return getRuleContext(IncludeStatementContext.class,0);
		}
		public SetStatementContext setStatement() {
			return getRuleContext(SetStatementContext.class,0);
		}
		public LoadStatementContext loadStatement() {
			return getRuleContext(LoadStatementContext.class,0);
		}
		public CollectStatementContext collectStatement() {
			return getRuleContext(CollectStatementContext.class,0);
		}
		public PrintStatementContext printStatement() {
			return getRuleContext(PrintStatementContext.class,0);
		}
		public LearnStatementContext learnStatement() {
			return getRuleContext(LearnStatementContext.class,0);
		}
		public NextStatementContext nextStatement() {
			return getRuleContext(NextStatementContext.class,0);
		}
		public OperationInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operationInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterOperationInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitOperationInstruction(this);
		}
	}

	public final OperationInstructionContext operationInstruction() throws RecognitionException {
		OperationInstructionContext _localctx = new OperationInstructionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_operationInstruction);
		try {
			setState(458);
			switch (_input.LA(1)) {
			case LOADLABEL:
				enterOuterAlt(_localctx, 1);
				{
				setState(449); loadStatement();
				}
				break;
			case SAVELABEL:
				enterOuterAlt(_localctx, 2);
				{
				setState(450); saveStatement();
				}
				break;
			case PRINTLABEL:
				enterOuterAlt(_localctx, 3);
				{
				setState(451); printStatement();
				}
				break;
			case TYPESLABEL:
				enterOuterAlt(_localctx, 4);
				{
				setState(452); typeStatement();
				}
				break;
			case COLLECTLABEL:
				enterOuterAlt(_localctx, 5);
				{
				setState(453); collectStatement();
				}
				break;
			case INCLUDELABEL:
				enterOuterAlt(_localctx, 6);
				{
				setState(454); includeStatement();
				}
				break;
			case NEXTLABEL:
				enterOuterAlt(_localctx, 7);
				{
				setState(455); nextStatement();
				}
				break;
			case LEARNLABEL:
				enterOuterAlt(_localctx, 8);
				{
				setState(456); learnStatement();
				}
				break;
			case SETLABEL:
				enterOuterAlt(_localctx, 9);
				{
				setState(457); setStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FileContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(TheBeastMLNGrammarParser.STRING, 0); }
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitFile(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_file);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(460); match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(TheBeastMLNGrammarParser.DOT); }
		public List<TerminalNode> VAR_ID() { return getTokens(TheBeastMLNGrammarParser.VAR_ID); }
		public TerminalNode VAR_ID(int i) {
			return getToken(TheBeastMLNGrammarParser.VAR_ID, i);
		}
		public TerminalNode DOT(int i) {
			return getToken(TheBeastMLNGrammarParser.DOT, i);
		}
		public PathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitPath(this);
		}
	}

	public final PathContext path() throws RecognitionException {
		PathContext _localctx = new PathContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_path);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(462); match(VAR_ID);
			setState(467);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(463); match(DOT);
				setState(464); match(VAR_ID);
				}
				}
				setState(469);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetValueContext extends ParserRuleContext {
		public TerminalNode FALSELABEL() { return getToken(TheBeastMLNGrammarParser.FALSELABEL, 0); }
		public TerminalNode STRING() { return getToken(TheBeastMLNGrammarParser.STRING, 0); }
		public TerminalNode INT() { return getToken(TheBeastMLNGrammarParser.INT, 0); }
		public TerminalNode TRUELABEL() { return getToken(TheBeastMLNGrammarParser.TRUELABEL, 0); }
		public TerminalNode FLOAT() { return getToken(TheBeastMLNGrammarParser.FLOAT, 0); }
		public SetValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterSetValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitSetValue(this);
		}
	}

	public final SetValueContext setValue() throws RecognitionException {
		SetValueContext _localctx = new SetValueContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_setValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(470);
			_la = _input.LA(1);
			if ( !(((((_la - 36)) & ~0x3f) == 0 && ((1L << (_la - 36)) & ((1L << (INT - 36)) | (1L << (FLOAT - 36)) | (1L << (TRUELABEL - 36)) | (1L << (FALSELABEL - 36)) | (1L << (STRING - 36)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetStatementContext extends ParserRuleContext {
		public TerminalNode SCOL() { return getToken(TheBeastMLNGrammarParser.SCOL, 0); }
		public SetValueContext setValue() {
			return getRuleContext(SetValueContext.class,0);
		}
		public TerminalNode SETLABEL() { return getToken(TheBeastMLNGrammarParser.SETLABEL, 0); }
		public TerminalNode EQ() { return getToken(TheBeastMLNGrammarParser.EQ, 0); }
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public SetStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterSetStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitSetStatement(this);
		}
	}

	public final SetStatementContext setStatement() throws RecognitionException {
		SetStatementContext _localctx = new SetStatementContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_setStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(472); match(SETLABEL);
			setState(473); path();
			setState(474); match(EQ);
			setState(475); setValue();
			setState(476); match(SCOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoadStatementContext extends ParserRuleContext {
		public TerminalNode SCOL() { return getToken(TheBeastMLNGrammarParser.SCOL, 0); }
		public TerminalNode FROMLABEL() { return getToken(TheBeastMLNGrammarParser.FROMLABEL, 0); }
		public TerminalNode LOADLABEL() { return getToken(TheBeastMLNGrammarParser.LOADLABEL, 0); }
		public TerminalNode RAMLABEL() { return getToken(TheBeastMLNGrammarParser.RAMLABEL, 0); }
		public TerminalNode DUMPLABEL() { return getToken(TheBeastMLNGrammarParser.DUMPLABEL, 0); }
		public TerminalNode CORPUSLABEL() { return getToken(TheBeastMLNGrammarParser.CORPUSLABEL, 0); }
		public FileContext file() {
			return getRuleContext(FileContext.class,0);
		}
		public TerminalNode GLOBALLABEL() { return getToken(TheBeastMLNGrammarParser.GLOBALLABEL, 0); }
		public LoadStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loadStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterLoadStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitLoadStatement(this);
		}
	}

	public final LoadStatementContext loadStatement() throws RecognitionException {
		LoadStatementContext _localctx = new LoadStatementContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_loadStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(478); match(LOADLABEL);
			setState(479);
			_la = _input.LA(1);
			if ( !(_la==CORPUSLABEL || _la==GLOBALLABEL) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(480); match(FROMLABEL);
			setState(482);
			_la = _input.LA(1);
			if (_la==DUMPLABEL) {
				{
				setState(481); match(DUMPLABEL);
				}
			}

			setState(486);
			switch (_input.LA(1)) {
			case STRING:
				{
				setState(484); file();
				}
				break;
			case RAMLABEL:
				{
				setState(485); match(RAMLABEL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(488); match(SCOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SaveStatementContext extends ParserRuleContext {
		public TerminalNode SCOL() { return getToken(TheBeastMLNGrammarParser.SCOL, 0); }
		public TerminalNode INSTANCESLABEL() { return getToken(TheBeastMLNGrammarParser.INSTANCESLABEL, 0); }
		public TerminalNode RAMLABEL() { return getToken(TheBeastMLNGrammarParser.RAMLABEL, 0); }
		public TerminalNode TOLABEL() { return getToken(TheBeastMLNGrammarParser.TOLABEL, 0); }
		public TerminalNode CORPUSLABEL() { return getToken(TheBeastMLNGrammarParser.CORPUSLABEL, 0); }
		public FileContext file() {
			return getRuleContext(FileContext.class,0);
		}
		public TerminalNode SAVELABEL() { return getToken(TheBeastMLNGrammarParser.SAVELABEL, 0); }
		public TerminalNode WEIGHTSLABEL() { return getToken(TheBeastMLNGrammarParser.WEIGHTSLABEL, 0); }
		public SaveStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_saveStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterSaveStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitSaveStatement(this);
		}
	}

	public final SaveStatementContext saveStatement() throws RecognitionException {
		SaveStatementContext _localctx = new SaveStatementContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_saveStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(490); match(SAVELABEL);
			setState(491);
			_la = _input.LA(1);
			if ( !(_la==CORPUSLABEL || _la==WEIGHTSLABEL) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(492); match(TOLABEL);
			setState(494);
			_la = _input.LA(1);
			if (_la==INSTANCESLABEL) {
				{
				setState(493); match(INSTANCESLABEL);
				}
			}

			setState(498);
			switch (_input.LA(1)) {
			case STRING:
				{
				setState(496); file();
				}
				break;
			case RAMLABEL:
				{
				setState(497); match(RAMLABEL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(500); match(SCOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintStatementContext extends ParserRuleContext {
		public TerminalNode SCOL() { return getToken(TheBeastMLNGrammarParser.SCOL, 0); }
		public TerminalNode EVALLABEL() { return getToken(TheBeastMLNGrammarParser.EVALLABEL, 0); }
		public TerminalNode DOT() { return getToken(TheBeastMLNGrammarParser.DOT, 0); }
		public TerminalNode PRINTLABEL() { return getToken(TheBeastMLNGrammarParser.PRINTLABEL, 0); }
		public WeightFunctionApplicationContext weightFunctionApplication() {
			return getRuleContext(WeightFunctionApplicationContext.class,0);
		}
		public TerminalNode ATOMSLABEL() { return getToken(TheBeastMLNGrammarParser.ATOMSLABEL, 0); }
		public TerminalNode WEIGHTSLABEL() { return getToken(TheBeastMLNGrammarParser.WEIGHTSLABEL, 0); }
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public PrintStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterPrintStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitPrintStatement(this);
		}
	}

	public final PrintStatementContext printStatement() throws RecognitionException {
		PrintStatementContext _localctx = new PrintStatementContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_printStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(502); match(PRINTLABEL);
			setState(512);
			switch (_input.LA(1)) {
			case ATOMSLABEL:
				{
				setState(503); match(ATOMSLABEL);
				setState(506);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(504); match(DOT);
					setState(505); predicate();
					}
				}

				}
				break;
			case WEIGHTSLABEL:
				{
				setState(508); match(WEIGHTSLABEL);
				{
				setState(509); match(DOT);
				setState(510); weightFunctionApplication();
				}
				}
				break;
			case EVALLABEL:
				{
				setState(511); match(EVALLABEL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(514); match(SCOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeStatementContext extends ParserRuleContext {
		public TerminalNode SCOL() { return getToken(TheBeastMLNGrammarParser.SCOL, 0); }
		public TerminalNode RAMLABEL() { return getToken(TheBeastMLNGrammarParser.RAMLABEL, 0); }
		public TerminalNode TOLABEL() { return getToken(TheBeastMLNGrammarParser.TOLABEL, 0); }
		public FileContext file() {
			return getRuleContext(FileContext.class,0);
		}
		public TerminalNode TYPESLABEL() { return getToken(TheBeastMLNGrammarParser.TYPESLABEL, 0); }
		public TypeStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterTypeStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitTypeStatement(this);
		}
	}

	public final TypeStatementContext typeStatement() throws RecognitionException {
		TypeStatementContext _localctx = new TypeStatementContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_typeStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(516); match(TYPESLABEL);
			setState(517); match(TOLABEL);
			setState(520);
			switch (_input.LA(1)) {
			case STRING:
				{
				setState(518); file();
				}
				break;
			case RAMLABEL:
				{
				setState(519); match(RAMLABEL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(522); match(SCOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CollectStatementContext extends ParserRuleContext {
		public TerminalNode SCOL() { return getToken(TheBeastMLNGrammarParser.SCOL, 0); }
		public TerminalNode COLLECTLABEL() { return getToken(TheBeastMLNGrammarParser.COLLECTLABEL, 0); }
		public CollectStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collectStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterCollectStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitCollectStatement(this);
		}
	}

	public final CollectStatementContext collectStatement() throws RecognitionException {
		CollectStatementContext _localctx = new CollectStatementContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_collectStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(524); match(COLLECTLABEL);
			setState(525); match(SCOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IncludeStatementContext extends ParserRuleContext {
		public TerminalNode SCOL() { return getToken(TheBeastMLNGrammarParser.SCOL, 0); }
		public FileContext file() {
			return getRuleContext(FileContext.class,0);
		}
		public TerminalNode INCLUDELABEL() { return getToken(TheBeastMLNGrammarParser.INCLUDELABEL, 0); }
		public IncludeStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_includeStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterIncludeStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitIncludeStatement(this);
		}
	}

	public final IncludeStatementContext includeStatement() throws RecognitionException {
		IncludeStatementContext _localctx = new IncludeStatementContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_includeStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(527); match(INCLUDELABEL);
			setState(528); file();
			setState(529); match(SCOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NextStatementContext extends ParserRuleContext {
		public TerminalNode SCOL() { return getToken(TheBeastMLNGrammarParser.SCOL, 0); }
		public TerminalNode NEXTLABEL() { return getToken(TheBeastMLNGrammarParser.NEXTLABEL, 0); }
		public NextStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nextStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterNextStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitNextStatement(this);
		}
	}

	public final NextStatementContext nextStatement() throws RecognitionException {
		NextStatementContext _localctx = new NextStatementContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_nextStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(531); match(NEXTLABEL);
			setState(532); match(SCOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LearnStatementContext extends ParserRuleContext {
		public TerminalNode FORLABEL() { return getToken(TheBeastMLNGrammarParser.FORLABEL, 0); }
		public TerminalNode LEARNLABEL() { return getToken(TheBeastMLNGrammarParser.LEARNLABEL, 0); }
		public TerminalNode EPOCHSLABEL() { return getToken(TheBeastMLNGrammarParser.EPOCHSLABEL, 0); }
		public TerminalNode INT() { return getToken(TheBeastMLNGrammarParser.INT, 0); }
		public LearnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_learnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).enterLearnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheBeastMLNGrammarListener ) ((TheBeastMLNGrammarListener)listener).exitLearnStatement(this);
		}
	}

	public final LearnStatementContext learnStatement() throws RecognitionException {
		LearnStatementContext _localctx = new LearnStatementContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_learnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(534); match(LEARNLABEL);
			setState(535); match(FORLABEL);
			setState(536); match(INT);
			setState(537); match(EPOCHSLABEL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4: return term_sempred((TermContext)_localctx, predIndex);

		case 27: return booleanFormula_sempred((BooleanFormulaContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean booleanFormula_sempred(BooleanFormulaContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return precpred(_ctx, 4);

		case 2: return precpred(_ctx, 3);

		case 3: return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3Y\u021e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\7\2b\n\2\f\2\16\2e\13\2\3\2\3\2\3"+
		"\2\3\2\3\2\6\2l\n\2\r\2\16\2m\3\3\3\3\6\3r\n\3\r\3\16\3s\3\3\7\3w\n\3"+
		"\f\3\16\3z\13\3\3\3\5\3}\n\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\7\6\u008b\n\6\f\6\16\6\u008e\13\6\3\6\3\6\3\6\5\6\u0093\n\6\3\6"+
		"\3\6\3\6\3\6\7\6\u0099\n\6\f\6\16\6\u009c\13\6\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\7\7\u00a4\n\7\f\7\16\7\u00a7\13\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\7\t\u00b2\n\t\f\t\16\t\u00b5\13\t\5\t\u00b7\n\t\3\t\3\t\3\n\3\n\3\n\5"+
		"\n\u00be\n\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00c8\n\f\f\f\16\f"+
		"\u00cb\13\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\5\r\u00d4\n\r\3\16\3\16\3\17\3"+
		"\17\3\17\3\17\3\17\7\17\u00dd\n\17\f\17\16\17\u00e0\13\17\3\17\3\17\3"+
		"\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u00f0"+
		"\n\23\f\23\16\23\u00f3\13\23\3\23\3\23\3\23\5\23\u00f8\n\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\24\7\24\u0101\n\24\f\24\16\24\u0104\13\24\3\24"+
		"\3\24\3\25\3\25\3\25\5\25\u010b\n\25\3\26\7\26\u010e\n\26\f\26\16\26\u0111"+
		"\13\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\7\30"+
		"\u011f\n\30\f\30\16\30\u0122\13\30\3\31\3\31\3\31\3\31\3\31\3\31\7\31"+
		"\u012a\n\31\f\31\16\31\u012d\13\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31"+
		"\u0135\n\31\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\7\33\u013f\n\33\f"+
		"\33\16\33\u0142\13\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\7\34\u014f\n\34\f\34\16\34\u0152\13\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\5\34\u015a\n\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\5\35\u0163\n"+
		"\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\7\35\u016e\n\35\f\35"+
		"\16\35\u0171\13\35\3\36\3\36\3\37\3\37\3 \3 \3 \3 \3 \5 \u017c\n \3 \5"+
		" \u017f\n \3 \3 \3 \5 \u0184\n \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \5"+
		" \u0192\n \3 \3 \3 \3 \3!\3!\3!\3!\3!\5!\u019d\n!\3!\5!\u01a0\n!\3!\3"+
		"!\3!\5!\u01a5\n!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u01b3\n!\3!\3"+
		"!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\5#\u01c2\n#\3$\3$\3$\3$\3$\3"+
		"$\3$\3$\3$\5$\u01cd\n$\3%\3%\3&\3&\3&\7&\u01d4\n&\f&\16&\u01d7\13&\3\'"+
		"\3\'\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\5)\u01e5\n)\3)\3)\5)\u01e9\n)\3)\3"+
		")\3*\3*\3*\3*\5*\u01f1\n*\3*\3*\5*\u01f5\n*\3*\3*\3+\3+\3+\3+\5+\u01fd"+
		"\n+\3+\3+\3+\3+\5+\u0203\n+\3+\3+\3,\3,\3,\3,\5,\u020b\n,\3,\3,\3-\3-"+
		"\3-\3.\3.\3.\3.\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\2\4\n8\61\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRT"+
		"VXZ\\^\2\13\3\2XY\4\2\64\64\67;\4\2\33\34\"#\4\2\33\33\"\"\4\2\32\32\35"+
		" \3\2\37 \5\2&\'\65\66YY\4\2DDHH\4\2DDKK\u0232\2c\3\2\2\2\4o\3\2\2\2\6"+
		"~\3\2\2\2\b\u0080\3\2\2\2\n\u0092\3\2\2\2\f\u009d\3\2\2\2\16\u00a8\3\2"+
		"\2\2\20\u00aa\3\2\2\2\22\u00bd\3\2\2\2\24\u00bf\3\2\2\2\26\u00c1\3\2\2"+
		"\2\30\u00d3\3\2\2\2\32\u00d5\3\2\2\2\34\u00d7\3\2\2\2\36\u00e3\3\2\2\2"+
		" \u00e5\3\2\2\2\"\u00e7\3\2\2\2$\u00e9\3\2\2\2&\u00fb\3\2\2\2(\u010a\3"+
		"\2\2\2*\u010f\3\2\2\2,\u0114\3\2\2\2.\u011a\3\2\2\2\60\u0134\3\2\2\2\62"+
		"\u0136\3\2\2\2\64\u0138\3\2\2\2\66\u0145\3\2\2\28\u0162\3\2\2\2:\u0172"+
		"\3\2\2\2<\u0174\3\2\2\2>\u0176\3\2\2\2@\u0197\3\2\2\2B\u01b8\3\2\2\2D"+
		"\u01c1\3\2\2\2F\u01cc\3\2\2\2H\u01ce\3\2\2\2J\u01d0\3\2\2\2L\u01d8\3\2"+
		"\2\2N\u01da\3\2\2\2P\u01e0\3\2\2\2R\u01ec\3\2\2\2T\u01f8\3\2\2\2V\u0206"+
		"\3\2\2\2X\u020e\3\2\2\2Z\u0211\3\2\2\2\\\u0215\3\2\2\2^\u0218\3\2\2\2"+
		"`b\7\6\2\2a`\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2dk\3\2\2\2ec\3\2\2\2"+
		"fl\5F$\2gl\5$\23\2hl\5\26\f\2il\5D#\2jl\7\6\2\2kf\3\2\2\2kg\3\2\2\2kh"+
		"\3\2\2\2ki\3\2\2\2kj\3\2\2\2lm\3\2\2\2mk\3\2\2\2mn\3\2\2\2n\3\3\2\2\2"+
		"ox\5.\30\2pr\7\6\2\2qp\3\2\2\2rs\3\2\2\2sq\3\2\2\2st\3\2\2\2tu\3\2\2\2"+
		"uw\5.\30\2vq\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y|\3\2\2\2zx\3\2\2\2"+
		"{}\7\6\2\2|{\3\2\2\2|}\3\2\2\2}\5\3\2\2\2~\177\t\2\2\2\177\7\3\2\2\2\u0080"+
		"\u0081\7W\2\2\u0081\t\3\2\2\2\u0082\u0083\b\6\1\2\u0083\u0093\5\6\4\2"+
		"\u0084\u0093\5\b\5\2\u0085\u0086\5\30\r\2\u0086\u0087\7\7\2\2\u0087\u008c"+
		"\5\n\6\2\u0088\u0089\7\20\2\2\u0089\u008b\5\n\6\2\u008a\u0088\3\2\2\2"+
		"\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008f"+
		"\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0090\7\b\2\2\u0090\u0093\3\2\2\2\u0091"+
		"\u0093\5&\24\2\u0092\u0082\3\2\2\2\u0092\u0084\3\2\2\2\u0092\u0085\3\2"+
		"\2\2\u0092\u0091\3\2\2\2\u0093\u009a\3\2\2\2\u0094\u0095\f\4\2\2\u0095"+
		"\u0096\5\62\32\2\u0096\u0097\5\n\6\5\u0097\u0099\3\2\2\2\u0098\u0094\3"+
		"\2\2\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b"+
		"\13\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u009e\5\22\n\2\u009e\u00a5\5\b\5"+
		"\2\u009f\u00a0\7\20\2\2\u00a0\u00a1\5\22\n\2\u00a1\u00a2\5\b\5\2\u00a2"+
		"\u00a4\3\2\2\2\u00a3\u009f\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2"+
		"\2\2\u00a5\u00a6\3\2\2\2\u00a6\r\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00a9"+
		"\7X\2\2\u00a9\17\3\2\2\2\u00aa\u00ab\7(\2\2\u00ab\u00ac\5\16\b\2\u00ac"+
		"\u00b6\7\17\2\2\u00ad\u00b7\7\r\2\2\u00ae\u00b3\5\6\4\2\u00af\u00b0\7"+
		"\20\2\2\u00b0\u00b2\5\6\4\2\u00b1\u00af\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3"+
		"\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2"+
		"\2\2\u00b6\u00ad\3\2\2\2\u00b6\u00ae\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8"+
		"\u00b9\7\21\2\2\u00b9\21\3\2\2\2\u00ba\u00be\5\16\b\2\u00bb\u00be\7)\2"+
		"\2\u00bc\u00be\7*\2\2\u00bd\u00ba\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00bc"+
		"\3\2\2\2\u00be\23\3\2\2\2\u00bf\u00c0\7W\2\2\u00c0\25\3\2\2\2\u00c1\u00c2"+
		"\7+\2\2\u00c2\u00c3\5\24\13\2\u00c3\u00c4\7\17\2\2\u00c4\u00c9\5\22\n"+
		"\2\u00c5\u00c6\7,\2\2\u00c6\u00c8\5\22\n\2\u00c7\u00c5\3\2\2\2\u00c8\u00cb"+
		"\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cc\3\2\2\2\u00cb"+
		"\u00c9\3\2\2\2\u00cc\u00cd\7\21\2\2\u00cd\27\3\2\2\2\u00ce\u00d4\5\24"+
		"\13\2\u00cf\u00d4\7-\2\2\u00d0\u00d4\7.\2\2\u00d1\u00d4\7/\2\2\u00d2\u00d4"+
		"\7\60\2\2\u00d3\u00ce\3\2\2\2\u00d3\u00cf\3\2\2\2\u00d3\u00d0\3\2\2\2"+
		"\u00d3\u00d1\3\2\2\2\u00d3\u00d2\3\2\2\2\u00d4\31\3\2\2\2\u00d5\u00d6"+
		"\7\61\2\2\u00d6\33\3\2\2\2\u00d7\u00d8\5\32\16\2\u00d8\u00d9\7\17\2\2"+
		"\u00d9\u00de\5\30\r\2\u00da\u00db\7\20\2\2\u00db\u00dd\5\30\r\2\u00dc"+
		"\u00da\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2"+
		"\2\2\u00df\u00e1\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e2\7\21\2\2\u00e2"+
		"\35\3\2\2\2\u00e3\u00e4\t\3\2\2\u00e4\37\3\2\2\2\u00e5\u00e6\t\4\2\2\u00e6"+
		"!\3\2\2\2\u00e7\u00e8\7W\2\2\u00e8#\3\2\2\2\u00e9\u00ea\7<\2\2\u00ea\u00eb"+
		"\5\"\22\2\u00eb\u00ec\7\17\2\2\u00ec\u00f1\5\22\n\2\u00ed\u00ee\7,\2\2"+
		"\u00ee\u00f0\5\22\n\2\u00ef\u00ed\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00ef"+
		"\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f4\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4"+
		"\u00f5\7%\2\2\u00f5\u00f7\5\22\n\2\u00f6\u00f8\t\5\2\2\u00f7\u00f6\3\2"+
		"\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\7\21\2\2\u00fa"+
		"%\3\2\2\2\u00fb\u00fc\5\"\22\2\u00fc\u00fd\7\7\2\2\u00fd\u0102\5\n\6\2"+
		"\u00fe\u00ff\7\20\2\2\u00ff\u0101\5\n\6\2\u0100\u00fe\3\2\2\2\u0101\u0104"+
		"\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0105\3\2\2\2\u0104"+
		"\u0102\3\2\2\2\u0105\u0106\7\b\2\2\u0106\'\3\2\2\2\u0107\u010b\7&\2\2"+
		"\u0108\u010b\7\'\2\2\u0109\u010b\5\6\4\2\u010a\u0107\3\2\2\2\u010a\u0108"+
		"\3\2\2\2\u010a\u0109\3\2\2\2\u010b)\3\2\2\2\u010c\u010e\5(\25\2\u010d"+
		"\u010c\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2"+
		"\2\2\u0110\u0112\3\2\2\2\u0111\u010f\3\2\2\2\u0112\u0113\7\6\2\2\u0113"+
		"+\3\2\2\2\u0114\u0115\7\35\2\2\u0115\u0116\5\30\r\2\u0116\u0117\7\6\2"+
		"\2\u0117\u0118\5*\26\2\u0118\u0119\7\6\2\2\u0119-\3\2\2\2\u011a\u011b"+
		"\7\35\2\2\u011b\u011c\7\35\2\2\u011c\u0120\7\6\2\2\u011d\u011f\5,\27\2"+
		"\u011e\u011d\3\2\2\2\u011f\u0122\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121"+
		"\3\2\2\2\u0121/\3\2\2\2\u0122\u0120\3\2\2\2\u0123\u0124\5\36\20\2\u0124"+
		"\u0125\7\7\2\2\u0125\u012b\5\n\6\2\u0126\u0127\5\n\6\2\u0127\u0128\7\20"+
		"\2\2\u0128\u012a\3\2\2\2\u0129\u0126\3\2\2\2\u012a\u012d\3\2\2\2\u012b"+
		"\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012e\3\2\2\2\u012d\u012b\3\2"+
		"\2\2\u012e\u012f\7\b\2\2\u012f\u0135\3\2\2\2\u0130\u0131\5\n\6\2\u0131"+
		"\u0132\5 \21\2\u0132\u0133\5\n\6\2\u0133\u0135\3\2\2\2\u0134\u0123\3\2"+
		"\2\2\u0134\u0130\3\2\2\2\u0135\61\3\2\2\2\u0136\u0137\t\6\2\2\u0137\63"+
		"\3\2\2\2\u0138\u0139\5\"\22\2\u0139\u013a\7\7\2\2\u013a\u0140\5\n\6\2"+
		"\u013b\u013c\5\n\6\2\u013c\u013d\7\20\2\2\u013d\u013f\3\2\2\2\u013e\u013b"+
		"\3\2\2\2\u013f\u0142\3\2\2\2\u0140\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141"+
		"\u0143\3\2\2\2\u0142\u0140\3\2\2\2\u0143\u0144\7\b\2\2\u0144\65\3\2\2"+
		"\2\u0145\u0146\7\23\2\2\u0146\u0147\5\22\n\2\u0147\u0148\5\b\5\2\u0148"+
		"\u0159\7\17\2\2\u0149\u014a\5\30\r\2\u014a\u014b\7\7\2\2\u014b\u0150\5"+
		"\n\6\2\u014c\u014d\7\20\2\2\u014d\u014f\5\n\6\2\u014e\u014c\3\2\2\2\u014f"+
		"\u0152\3\2\2\2\u0150\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0153\3\2"+
		"\2\2\u0152\u0150\3\2\2\2\u0153\u0154\7\b\2\2\u0154\u015a\3\2\2\2\u0155"+
		"\u0156\5\n\6\2\u0156\u0157\5\62\32\2\u0157\u0158\5\n\6\2\u0158\u015a\3"+
		"\2\2\2\u0159\u0149\3\2\2\2\u0159\u0155\3\2\2\2\u015a\u015b\3\2\2\2\u015b"+
		"\u015c\7\23\2\2\u015c\u015d\t\7\2\2\u015d\u015e\7&\2\2\u015e\67\3\2\2"+
		"\2\u015f\u0160\b\35\1\2\u0160\u0163\5\n\6\2\u0161\u0163\5\66\34\2\u0162"+
		"\u015f\3\2\2\2\u0162\u0161\3\2\2\2\u0163\u016f\3\2\2\2\u0164\u0165\f\6"+
		"\2\2\u0165\u0166\7\24\2\2\u0166\u016e\58\35\7\u0167\u0168\f\5\2\2\u0168"+
		"\u0169\7\25\2\2\u0169\u016e\58\35\6\u016a\u016b\f\4\2\2\u016b\u016c\7"+
		"\26\2\2\u016c\u016e\58\35\5\u016d\u0164\3\2\2\2\u016d\u0167\3\2\2\2\u016d"+
		"\u016a\3\2\2\2\u016e\u0171\3\2\2\2\u016f\u016d\3\2\2\2\u016f\u0170\3\2"+
		"\2\2\u01709\3\2\2\2\u0171\u016f\3\2\2\2\u0172\u0173\7W\2\2\u0173;\3\2"+
		"\2\2\u0174\u0175\7&\2\2\u0175=\3\2\2\2\u0176\u017b\7=\2\2\u0177\u0178"+
		"\7\13\2\2\u0178\u0179\5<\37\2\u0179\u017a\7\f\2\2\u017a\u017c\3\2\2\2"+
		"\u017b\u0177\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u017e\3\2\2\2\u017d\u017f"+
		"\5:\36\2\u017e\u017d\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0183\3\2\2\2\u0180"+
		"\u0181\7\13\2\2\u0181\u0182\7U\2\2\u0182\u0184\7\f\2\2\u0183\u0180\3\2"+
		"\2\2\u0183\u0184\3\2\2\2\u0184\u0185\3\2\2\2\u0185\u0186\7\17\2\2\u0186"+
		"\u0187\7>\2\2\u0187\u0188\5\f\7\2\u0188\u0189\7\6\2\2\u0189\u018a\7?\2"+
		"\2\u018a\u018b\58\35\2\u018b\u018c\7\64\2\2\u018c\u018d\7\13\2\2\u018d"+
		"\u018e\58\35\2\u018e\u0191\7\f\2\2\u018f\u0190\7\34\2\2\u0190\u0192\5"+
		"\n\6\2\u0191\u018f\3\2\2\2\u0191\u0192\3\2\2\2\u0192\u0193\3\2\2\2\u0193"+
		"\u0194\7\34\2\2\u0194\u0195\5\n\6\2\u0195\u0196\7\21\2\2\u0196?\3\2\2"+
		"\2\u0197\u019c\7=\2\2\u0198\u0199\7\13\2\2\u0199\u019a\5<\37\2\u019a\u019b"+
		"\7\f\2\2\u019b\u019d\3\2\2\2\u019c\u0198\3\2\2\2\u019c\u019d\3\2\2\2\u019d"+
		"\u019f\3\2\2\2\u019e\u01a0\5:\36\2\u019f\u019e\3\2\2\2\u019f\u01a0\3\2"+
		"\2\2\u01a0\u01a4\3\2\2\2\u01a1\u01a2\7\13\2\2\u01a2\u01a3\7U\2\2\u01a3"+
		"\u01a5\7\f\2\2\u01a4\u01a1\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a6\3\2"+
		"\2\2\u01a6\u01a7\7\17\2\2\u01a7\u01a8\7>\2\2\u01a8\u01a9\5\f\7\2\u01a9"+
		"\u01aa\7\6\2\2\u01aa\u01ab\7\64\2\2\u01ab\u01ac\7\13\2\2\u01ac\u01ad\5"+
		"8\35\2\u01ad\u01ae\7\26\2\2\u01ae\u01af\58\35\2\u01af\u01b2\7\f\2\2\u01b0"+
		"\u01b1\7\34\2\2\u01b1\u01b3\5\n\6\2\u01b2\u01b0\3\2\2\2\u01b2\u01b3\3"+
		"\2\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01b5\7\34\2\2\u01b5\u01b6\5\n\6\2\u01b6"+
		"\u01b7\7\21\2\2\u01b7A\3\2\2\2\u01b8\u01b9\7=\2\2\u01b9\u01ba\7\17\2\2"+
		"\u01ba\u01bb\5\30\r\2\u01bb\u01bc\7@\2\2\u01bc\u01bd\7\21\2\2\u01bdC\3"+
		"\2\2\2\u01be\u01c2\5> \2\u01bf\u01c2\5@!\2\u01c0\u01c2\5B\"\2\u01c1\u01be"+
		"\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c1\u01c0\3\2\2\2\u01c2E\3\2\2\2\u01c3"+
		"\u01cd\5P)\2\u01c4\u01cd\5R*\2\u01c5\u01cd\5T+\2\u01c6\u01cd\5V,\2\u01c7"+
		"\u01cd\5X-\2\u01c8\u01cd\5Z.\2\u01c9\u01cd\5\\/\2\u01ca\u01cd\5^\60\2"+
		"\u01cb\u01cd\5N(\2\u01cc\u01c3\3\2\2\2\u01cc\u01c4\3\2\2\2\u01cc\u01c5"+
		"\3\2\2\2\u01cc\u01c6\3\2\2\2\u01cc\u01c7\3\2\2\2\u01cc\u01c8\3\2\2\2\u01cc"+
		"\u01c9\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cc\u01cb\3\2\2\2\u01cdG\3\2\2\2"+
		"\u01ce\u01cf\7Y\2\2\u01cfI\3\2\2\2\u01d0\u01d5\7W\2\2\u01d1\u01d2\7\16"+
		"\2\2\u01d2\u01d4\7W\2\2\u01d3\u01d1\3\2\2\2\u01d4\u01d7\3\2\2\2\u01d5"+
		"\u01d3\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6K\3\2\2\2\u01d7\u01d5\3\2\2\2"+
		"\u01d8\u01d9\t\b\2\2\u01d9M\3\2\2\2\u01da\u01db\7V\2\2\u01db\u01dc\5J"+
		"&\2\u01dc\u01dd\7\32\2\2\u01dd\u01de\5L\'\2\u01de\u01df\7\21\2\2\u01df"+
		"O\3\2\2\2\u01e0\u01e1\7B\2\2\u01e1\u01e2\t\t\2\2\u01e2\u01e4\7C\2\2\u01e3"+
		"\u01e5\7T\2\2\u01e4\u01e3\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5\u01e8\3\2"+
		"\2\2\u01e6\u01e9\5H%\2\u01e7\u01e9\7L\2\2\u01e8\u01e6\3\2\2\2\u01e8\u01e7"+
		"\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01eb\7\21\2\2\u01ebQ\3\2\2\2\u01ec"+
		"\u01ed\7E\2\2\u01ed\u01ee\t\n\2\2\u01ee\u01f0\7G\2\2\u01ef\u01f1\7N\2"+
		"\2\u01f0\u01ef\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1\u01f4\3\2\2\2\u01f2\u01f5"+
		"\5H%\2\u01f3\u01f5\7L\2\2\u01f4\u01f2\3\2\2\2\u01f4\u01f3\3\2\2\2\u01f5"+
		"\u01f6\3\2\2\2\u01f6\u01f7\7\21\2\2\u01f7S\3\2\2\2\u01f8\u0202\7I\2\2"+
		"\u01f9\u01fc\7J\2\2\u01fa\u01fb\7\16\2\2\u01fb\u01fd\5\30\r\2\u01fc\u01fa"+
		"\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd\u0203\3\2\2\2\u01fe\u01ff\7K\2\2\u01ff"+
		"\u0200\7\16\2\2\u0200\u0203\5&\24\2\u0201\u0203\7P\2\2\u0202\u01f9\3\2"+
		"\2\2\u0202\u01fe\3\2\2\2\u0202\u0201\3\2\2\2\u0203\u0204\3\2\2\2\u0204"+
		"\u0205\7\21\2\2\u0205U\3\2\2\2\u0206\u0207\7F\2\2\u0207\u020a\7G\2\2\u0208"+
		"\u020b\5H%\2\u0209\u020b\7L\2\2\u020a\u0208\3\2\2\2\u020a\u0209\3\2\2"+
		"\2\u020b\u020c\3\2\2\2\u020c\u020d\7\21\2\2\u020dW\3\2\2\2\u020e\u020f"+
		"\7M\2\2\u020f\u0210\7\21\2\2\u0210Y\3\2\2\2\u0211\u0212\7O\2\2\u0212\u0213"+
		"\5H%\2\u0213\u0214\7\21\2\2\u0214[\3\2\2\2\u0215\u0216\7Q\2\2\u0216\u0217"+
		"\7\21\2\2\u0217]\3\2\2\2\u0218\u0219\7S\2\2\u0219\u021a\7>\2\2\u021a\u021b"+
		"\7&\2\2\u021b\u021c\7R\2\2\u021c_\3\2\2\2\62ckmsx|\u008c\u0092\u009a\u00a5"+
		"\u00b3\u00b6\u00bd\u00c9\u00d3\u00de\u00f1\u00f7\u0102\u010a\u010f\u0120"+
		"\u012b\u0134\u0140\u0150\u0159\u0162\u016d\u016f\u017b\u017e\u0183\u0191"+
		"\u019c\u019f\u01a4\u01b2\u01c1\u01cc\u01d5\u01e4\u01e8\u01f0\u01f4\u01fc"+
		"\u0202\u020a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}