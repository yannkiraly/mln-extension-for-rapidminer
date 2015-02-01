// Generated from ExampleSetMLNGrammar.g4 by ANTLR 4.2
package com.rapidminer.operator.modelling.converters.exampleset.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExampleSetMLNGrammarParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LINE_COMMENT=1, COMMENT=2, WS=3, NL=4, LP=5, RP=6, LCP=7, RCP=8, LSP=9, 
		RSP=10, DOTS=11, DOT=12, COL=13, COM=14, EXCL=15, BAR=16, AND=17, OR=18, 
		IMPLIES=19, IFF=20, U_QUANT=21, E_QUANT=22, EQ=23, PLUS=24, STAR=25, GT=26, 
		LT=27, GE=28, LE=29, NE=30, MINUS=31, SLASH=32, MOD=33, INT=34, FLOAT=35, 
		VAR_ID=36, CONST_ID=37, STRING=38;
	public static final String[] tokenNames = {
		"<INVALID>", "LINE_COMMENT", "COMMENT", "WS", "NL", "'('", "')'", "'{'", 
		"'}'", "'['", "']'", "'...'", "'.'", "':'", "','", "'!'", "'|'", "'^'", 
		"'v'", "'=>'", "'<=>'", "U_QUANT", "E_QUANT", "'='", "'+'", "'*'", "'>'", 
		"'<'", "'>='", "'<='", "'!='", "'-'", "'/'", "'%'", "INT", "FLOAT", "VAR_ID", 
		"CONST_ID", "STRING"
	};
	public static final int
		RULE_ruleFile = 0, RULE_dbFile = 1, RULE_infFile = 2, RULE_queryFile = 3, 
		RULE_constant = 4, RULE_expVariable = 5, RULE_variable = 6, RULE_exclType = 7, 
		RULE_type = 8, RULE_startNumber = 9, RULE_endNumber = 10, RULE_doubleNL = 11, 
		RULE_cardinality = 12, RULE_number = 13, RULE_constantList = 14, RULE_variableList = 15, 
		RULE_typeList = 16, RULE_exNumList = 17, RULE_plainNumList = 18, RULE_numList = 19, 
		RULE_and = 20, RULE_or = 21, RULE_implies = 22, RULE_iff = 23, RULE_quantifier = 24, 
		RULE_eq = 25, RULE_function = 26, RULE_builtinFunctionSymbol = 27, RULE_builtinPrefixFunctionSymbol = 28, 
		RULE_predicate = 29, RULE_builtinPredicateSymbol = 30, RULE_predicateApplication = 31, 
		RULE_functionApplication = 32, RULE_argument = 33, RULE_groundPredicateApplication = 34, 
		RULE_groundFunctionApplication = 35, RULE_groundArgument = 36, RULE_returnValue = 37, 
		RULE_functionDef = 38, RULE_typeDecl = 39, RULE_plainPredicate = 40, RULE_closedWorldPredicate = 41, 
		RULE_predicateDecl = 42, RULE_functionDecl = 43, RULE_plainFormula = 44, 
		RULE_probability = 45, RULE_probabilityStatement = 46, RULE_weight = 47, 
		RULE_utilWeight = 48, RULE_probWeight = 49, RULE_weights = 50, RULE_weightedFormula = 51, 
		RULE_hardFormula = 52, RULE_formula = 53, RULE_groundFormula = 54, RULE_quantification = 55;
	public static final String[] ruleNames = {
		"ruleFile", "dbFile", "infFile", "queryFile", "constant", "expVariable", 
		"variable", "exclType", "type", "startNumber", "endNumber", "doubleNL", 
		"cardinality", "number", "constantList", "variableList", "typeList", "exNumList", 
		"plainNumList", "numList", "and", "or", "implies", "iff", "quantifier", 
		"eq", "function", "builtinFunctionSymbol", "builtinPrefixFunctionSymbol", 
		"predicate", "builtinPredicateSymbol", "predicateApplication", "functionApplication", 
		"argument", "groundPredicateApplication", "groundFunctionApplication", 
		"groundArgument", "returnValue", "functionDef", "typeDecl", "plainPredicate", 
		"closedWorldPredicate", "predicateDecl", "functionDecl", "plainFormula", 
		"probability", "probabilityStatement", "weight", "utilWeight", "probWeight", 
		"weights", "weightedFormula", "hardFormula", "formula", "groundFormula", 
		"quantification"
	};

	@Override
	public String getGrammarFileName() { return "ExampleSetMLNGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExampleSetMLNGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RuleFileContext extends ParserRuleContext {
		public List<TerminalNode> NL() { return getTokens(ExampleSetMLNGrammarParser.NL); }
		public List<PredicateDeclContext> predicateDecl() {
			return getRuleContexts(PredicateDeclContext.class);
		}
		public FunctionDeclContext functionDecl(int i) {
			return getRuleContext(FunctionDeclContext.class,i);
		}
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public List<FunctionDeclContext> functionDecl() {
			return getRuleContexts(FunctionDeclContext.class);
		}
		public List<TypeDeclContext> typeDecl() {
			return getRuleContexts(TypeDeclContext.class);
		}
		public TerminalNode NL(int i) {
			return getToken(ExampleSetMLNGrammarParser.NL, i);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TypeDeclContext typeDecl(int i) {
			return getRuleContext(TypeDeclContext.class,i);
		}
		public PredicateDeclContext predicateDecl(int i) {
			return getRuleContext(PredicateDeclContext.class,i);
		}
		public RuleFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleFile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterRuleFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitRuleFile(this);
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
			{
			{
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(112); match(NL);
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			{
			setState(127);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(118); typeDecl();
					{
					setState(122);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(119); match(NL);
						}
						}
						setState(124);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					} 
				}
				setState(129);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
			{
			setState(142);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(132);
					switch (_input.LA(1)) {
					case STAR:
					case CONST_ID:
						{
						setState(130); predicateDecl();
						}
						break;
					case VAR_ID:
						{
						setState(131); functionDecl();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					{
					setState(137);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(134); match(NL);
						}
						}
						setState(139);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					} 
				}
				setState(144);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << LSP) | (1L << COL) | (1L << EXCL) | (1L << BAR) | (1L << U_QUANT) | (1L << E_QUANT) | (1L << PLUS) | (1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << VAR_ID) | (1L << CONST_ID) | (1L << STRING))) != 0)) {
				{
				{
				setState(145); formula();
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(146); match(NL);
					}
					}
					setState(151);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class DbFileContext extends ParserRuleContext {
		public List<TerminalNode> NL() { return getTokens(ExampleSetMLNGrammarParser.NL); }
		public GroundFormulaContext groundFormula(int i) {
			return getRuleContext(GroundFormulaContext.class,i);
		}
		public List<GroundFormulaContext> groundFormula() {
			return getRuleContexts(GroundFormulaContext.class);
		}
		public TerminalNode NL(int i) {
			return getToken(ExampleSetMLNGrammarParser.NL, i);
		}
		public DbFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dbFile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterDbFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitDbFile(this);
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
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NL) | (1L << LP) | (1L << EXCL) | (1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << CONST_ID) | (1L << STRING))) != 0)) {
				{
				{
				setState(157); groundFormula();
				setState(161);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(158); match(NL);
						}
						} 
					}
					setState(163);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				}
				}
				}
				setState(168);
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

	public static class InfFileContext extends ParserRuleContext {
		public List<ProbabilityStatementContext> probabilityStatement() {
			return getRuleContexts(ProbabilityStatementContext.class);
		}
		public List<TerminalNode> NL() { return getTokens(ExampleSetMLNGrammarParser.NL); }
		public ProbabilityStatementContext probabilityStatement(int i) {
			return getRuleContext(ProbabilityStatementContext.class,i);
		}
		public TerminalNode NL(int i) {
			return getToken(ExampleSetMLNGrammarParser.NL, i);
		}
		public InfFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_infFile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterInfFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitInfFile(this);
		}
	}

	public final InfFileContext infFile() throws RecognitionException {
		InfFileContext _localctx = new InfFileContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_infFile);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NL) | (1L << LP) | (1L << EXCL) | (1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << CONST_ID) | (1L << STRING))) != 0)) {
				{
				{
				setState(169); probabilityStatement();
				setState(173);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(170); match(NL);
						}
						} 
					}
					setState(175);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				}
				}
				setState(180);
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

	public static class QueryFileContext extends ParserRuleContext {
		public List<TerminalNode> NL() { return getTokens(ExampleSetMLNGrammarParser.NL); }
		public List<PredicateDeclContext> predicateDecl() {
			return getRuleContexts(PredicateDeclContext.class);
		}
		public TerminalNode NL(int i) {
			return getToken(ExampleSetMLNGrammarParser.NL, i);
		}
		public PredicateDeclContext predicateDecl(int i) {
			return getRuleContext(PredicateDeclContext.class,i);
		}
		public QueryFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryFile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterQueryFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitQueryFile(this);
		}
	}

	public final QueryFileContext queryFile() throws RecognitionException {
		QueryFileContext _localctx = new QueryFileContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_queryFile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STAR || _la==CONST_ID) {
				{
				{
				setState(181); predicateDecl();
				{
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(182); match(NL);
					}
					}
					setState(187);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				}
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
		public TerminalNode STRING() { return getToken(ExampleSetMLNGrammarParser.STRING, 0); }
		public TerminalNode CONST_ID() { return getToken(ExampleSetMLNGrammarParser.CONST_ID, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
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

	public static class ExpVariableContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(ExampleSetMLNGrammarParser.PLUS, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ExpVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterExpVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitExpVariable(this);
		}
	}

	public final ExpVariableContext expVariable() throws RecognitionException {
		ExpVariableContext _localctx = new ExpVariableContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195); match(PLUS);
			setState(196); variable();
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
		public TerminalNode VAR_ID() { return getToken(ExampleSetMLNGrammarParser.VAR_ID, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitVariable(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198); match(VAR_ID);
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

	public static class ExclTypeContext extends ParserRuleContext {
		public TerminalNode VAR_ID() { return getToken(ExampleSetMLNGrammarParser.VAR_ID, 0); }
		public TerminalNode EXCL() { return getToken(ExampleSetMLNGrammarParser.EXCL, 0); }
		public ExclTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exclType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterExclType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitExclType(this);
		}
	}

	public final ExclTypeContext exclType() throws RecognitionException {
		ExclTypeContext _localctx = new ExclTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_exclType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200); match(VAR_ID);
			setState(201); match(EXCL);
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
		public ExclTypeContext exclType() {
			return getRuleContext(ExclTypeContext.class,0);
		}
		public TerminalNode VAR_ID() { return getToken(ExampleSetMLNGrammarParser.VAR_ID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_type);
		try {
			setState(205);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(203); match(VAR_ID);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(204); exclType();
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

	public static class StartNumberContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public StartNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_startNumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterStartNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitStartNumber(this);
		}
	}

	public final StartNumberContext startNumber() throws RecognitionException {
		StartNumberContext _localctx = new StartNumberContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_startNumber);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207); number();
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

	public static class EndNumberContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public EndNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endNumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterEndNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitEndNumber(this);
		}
	}

	public final EndNumberContext endNumber() throws RecognitionException {
		EndNumberContext _localctx = new EndNumberContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_endNumber);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209); number();
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

	public static class DoubleNLContext extends ParserRuleContext {
		public List<TerminalNode> NL() { return getTokens(ExampleSetMLNGrammarParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(ExampleSetMLNGrammarParser.NL, i);
		}
		public DoubleNLContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubleNL; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterDoubleNL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitDoubleNL(this);
		}
	}

	public final DoubleNLContext doubleNL() throws RecognitionException {
		DoubleNLContext _localctx = new DoubleNLContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_doubleNL);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(211); match(NL);
				}
				}
				setState(214); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NL );
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

	public static class CardinalityContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(ExampleSetMLNGrammarParser.INT, 0); }
		public CardinalityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cardinality; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterCardinality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitCardinality(this);
		}
	}

	public final CardinalityContext cardinality() throws RecognitionException {
		CardinalityContext _localctx = new CardinalityContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_cardinality);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216); match(INT);
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

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(ExampleSetMLNGrammarParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(ExampleSetMLNGrammarParser.FLOAT, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitNumber(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==FLOAT) ) {
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

	public static class ConstantListContext extends ParserRuleContext {
		public List<TerminalNode> NL() { return getTokens(ExampleSetMLNGrammarParser.NL); }
		public List<ConstantContext> constant() {
			return getRuleContexts(ConstantContext.class);
		}
		public List<TerminalNode> COM() { return getTokens(ExampleSetMLNGrammarParser.COM); }
		public TerminalNode NL(int i) {
			return getToken(ExampleSetMLNGrammarParser.NL, i);
		}
		public TerminalNode COM(int i) {
			return getToken(ExampleSetMLNGrammarParser.COM, i);
		}
		public ConstantContext constant(int i) {
			return getRuleContext(ConstantContext.class,i);
		}
		public ConstantListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterConstantList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitConstantList(this);
		}
	}

	public final ConstantListContext constantList() throws RecognitionException {
		ConstantListContext _localctx = new ConstantListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_constantList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220); constant();
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(221); match(NL);
				}
				}
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COM) {
				{
				{
				setState(227); match(COM);
				setState(228); constant();
				}
				}
				setState(233);
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

	public static class VariableListContext extends ParserRuleContext {
		public List<TerminalNode> COM() { return getTokens(ExampleSetMLNGrammarParser.COM); }
		public ExpVariableContext expVariable(int i) {
			return getRuleContext(ExpVariableContext.class,i);
		}
		public List<ExpVariableContext> expVariable() {
			return getRuleContexts(ExpVariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public TerminalNode COM(int i) {
			return getToken(ExampleSetMLNGrammarParser.COM, i);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterVariableList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitVariableList(this);
		}
	}

	public final VariableListContext variableList() throws RecognitionException {
		VariableListContext _localctx = new VariableListContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_variableList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			switch (_input.LA(1)) {
			case VAR_ID:
				{
				setState(234); variable();
				}
				break;
			case PLUS:
				{
				setState(235); expVariable();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COM) {
				{
				{
				setState(238); match(COM);
				setState(241);
				switch (_input.LA(1)) {
				case VAR_ID:
					{
					setState(239); variable();
					}
					break;
				case PLUS:
					{
					setState(240); expVariable();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(247);
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

	public static class TypeListContext extends ParserRuleContext {
		public List<TerminalNode> COM() { return getTokens(ExampleSetMLNGrammarParser.COM); }
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TerminalNode COM(int i) {
			return getToken(ExampleSetMLNGrammarParser.COM, i);
		}
		public TypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitTypeList(this);
		}
	}

	public final TypeListContext typeList() throws RecognitionException {
		TypeListContext _localctx = new TypeListContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_typeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			switch (_input.LA(1)) {
			case VAR_ID:
				{
				{
				setState(248); type();
				setState(253);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COM) {
					{
					{
					setState(249); match(COM);
					setState(250); type();
					}
					}
					setState(255);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case RP:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ExNumListContext extends ParserRuleContext {
		public EndNumberContext endNumber() {
			return getRuleContext(EndNumberContext.class,0);
		}
		public List<TerminalNode> COM() { return getTokens(ExampleSetMLNGrammarParser.COM); }
		public TerminalNode DOTS() { return getToken(ExampleSetMLNGrammarParser.DOTS, 0); }
		public TerminalNode COM(int i) {
			return getToken(ExampleSetMLNGrammarParser.COM, i);
		}
		public StartNumberContext startNumber() {
			return getRuleContext(StartNumberContext.class,0);
		}
		public ExNumListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exNumList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterExNumList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitExNumList(this);
		}
	}

	public final ExNumListContext exNumList() throws RecognitionException {
		ExNumListContext _localctx = new ExNumListContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_exNumList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259); startNumber();
			setState(260); match(COM);
			setState(261); match(DOTS);
			setState(262); match(COM);
			setState(263); endNumber();
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

	public static class PlainNumListContext extends ParserRuleContext {
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public List<TerminalNode> COM() { return getTokens(ExampleSetMLNGrammarParser.COM); }
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
		}
		public TerminalNode COM(int i) {
			return getToken(ExampleSetMLNGrammarParser.COM, i);
		}
		public PlainNumListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plainNumList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterPlainNumList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitPlainNumList(this);
		}
	}

	public final PlainNumListContext plainNumList() throws RecognitionException {
		PlainNumListContext _localctx = new PlainNumListContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_plainNumList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265); number();
			setState(270);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COM) {
				{
				{
				setState(266); match(COM);
				setState(267); number();
				}
				}
				setState(272);
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

	public static class NumListContext extends ParserRuleContext {
		public PlainNumListContext plainNumList() {
			return getRuleContext(PlainNumListContext.class,0);
		}
		public ExNumListContext exNumList() {
			return getRuleContext(ExNumListContext.class,0);
		}
		public NumListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterNumList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitNumList(this);
		}
	}

	public final NumListContext numList() throws RecognitionException {
		NumListContext _localctx = new NumListContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_numList);
		try {
			setState(275);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(273); exNumList();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(274); plainNumList();
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

	public static class AndContext extends ParserRuleContext {
		public List<TerminalNode> NL() { return getTokens(ExampleSetMLNGrammarParser.NL); }
		public TerminalNode AND() { return getToken(ExampleSetMLNGrammarParser.AND, 0); }
		public TerminalNode NL(int i) {
			return getToken(ExampleSetMLNGrammarParser.NL, i);
		}
		public AndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitAnd(this);
		}
	}

	public final AndContext and() throws RecognitionException {
		AndContext _localctx = new AndContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_and);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277); match(AND);
			setState(281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(278); match(NL);
				}
				}
				setState(283);
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

	public static class OrContext extends ParserRuleContext {
		public List<TerminalNode> NL() { return getTokens(ExampleSetMLNGrammarParser.NL); }
		public TerminalNode OR() { return getToken(ExampleSetMLNGrammarParser.OR, 0); }
		public TerminalNode NL(int i) {
			return getToken(ExampleSetMLNGrammarParser.NL, i);
		}
		public OrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitOr(this);
		}
	}

	public final OrContext or() throws RecognitionException {
		OrContext _localctx = new OrContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_or);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284); match(OR);
			setState(288);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(285); match(NL);
				}
				}
				setState(290);
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

	public static class ImpliesContext extends ParserRuleContext {
		public List<TerminalNode> NL() { return getTokens(ExampleSetMLNGrammarParser.NL); }
		public TerminalNode IMPLIES() { return getToken(ExampleSetMLNGrammarParser.IMPLIES, 0); }
		public TerminalNode NL(int i) {
			return getToken(ExampleSetMLNGrammarParser.NL, i);
		}
		public ImpliesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_implies; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterImplies(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitImplies(this);
		}
	}

	public final ImpliesContext implies() throws RecognitionException {
		ImpliesContext _localctx = new ImpliesContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_implies);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291); match(IMPLIES);
			setState(295);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(292); match(NL);
				}
				}
				setState(297);
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

	public static class IffContext extends ParserRuleContext {
		public List<TerminalNode> NL() { return getTokens(ExampleSetMLNGrammarParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(ExampleSetMLNGrammarParser.NL, i);
		}
		public TerminalNode IFF() { return getToken(ExampleSetMLNGrammarParser.IFF, 0); }
		public IffContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iff; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterIff(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitIff(this);
		}
	}

	public final IffContext iff() throws RecognitionException {
		IffContext _localctx = new IffContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_iff);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298); match(IFF);
			setState(302);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(299); match(NL);
				}
				}
				setState(304);
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

	public static class QuantifierContext extends ParserRuleContext {
		public TerminalNode U_QUANT() { return getToken(ExampleSetMLNGrammarParser.U_QUANT, 0); }
		public TerminalNode E_QUANT() { return getToken(ExampleSetMLNGrammarParser.E_QUANT, 0); }
		public QuantifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterQuantifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitQuantifier(this);
		}
	}

	public final QuantifierContext quantifier() throws RecognitionException {
		QuantifierContext _localctx = new QuantifierContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_quantifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			_la = _input.LA(1);
			if ( !(_la==U_QUANT || _la==E_QUANT) ) {
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

	public static class EqContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(ExampleSetMLNGrammarParser.EQ, 0); }
		public EqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitEq(this);
		}
	}

	public final EqContext eq() throws RecognitionException {
		EqContext _localctx = new EqContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_eq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307); match(EQ);
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

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode CONST_ID() { return getToken(ExampleSetMLNGrammarParser.CONST_ID, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309); match(CONST_ID);
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

	public static class BuiltinFunctionSymbolContext extends ParserRuleContext {
		public TerminalNode SLASH() { return getToken(ExampleSetMLNGrammarParser.SLASH, 0); }
		public TerminalNode AND() { return getToken(ExampleSetMLNGrammarParser.AND, 0); }
		public TerminalNode PLUS() { return getToken(ExampleSetMLNGrammarParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(ExampleSetMLNGrammarParser.MINUS, 0); }
		public TerminalNode STAR() { return getToken(ExampleSetMLNGrammarParser.STAR, 0); }
		public TerminalNode MOD() { return getToken(ExampleSetMLNGrammarParser.MOD, 0); }
		public BuiltinFunctionSymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtinFunctionSymbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterBuiltinFunctionSymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitBuiltinFunctionSymbol(this);
		}
	}

	public final BuiltinFunctionSymbolContext builtinFunctionSymbol() throws RecognitionException {
		BuiltinFunctionSymbolContext _localctx = new BuiltinFunctionSymbolContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_builtinFunctionSymbol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << PLUS) | (1L << STAR) | (1L << MINUS) | (1L << SLASH) | (1L << MOD))) != 0)) ) {
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

	public static class BuiltinPrefixFunctionSymbolContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(ExampleSetMLNGrammarParser.MINUS, 0); }
		public BuiltinPrefixFunctionSymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtinPrefixFunctionSymbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterBuiltinPrefixFunctionSymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitBuiltinPrefixFunctionSymbol(this);
		}
	}

	public final BuiltinPrefixFunctionSymbolContext builtinPrefixFunctionSymbol() throws RecognitionException {
		BuiltinPrefixFunctionSymbolContext _localctx = new BuiltinPrefixFunctionSymbolContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_builtinPrefixFunctionSymbol);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313); match(MINUS);
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
		public TerminalNode CONST_ID() { return getToken(ExampleSetMLNGrammarParser.CONST_ID, 0); }
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitPredicate(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315); match(CONST_ID);
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

	public static class BuiltinPredicateSymbolContext extends ParserRuleContext {
		public TerminalNode GE() { return getToken(ExampleSetMLNGrammarParser.GE, 0); }
		public TerminalNode LT() { return getToken(ExampleSetMLNGrammarParser.LT, 0); }
		public TerminalNode GT() { return getToken(ExampleSetMLNGrammarParser.GT, 0); }
		public TerminalNode LE() { return getToken(ExampleSetMLNGrammarParser.LE, 0); }
		public TerminalNode EQ() { return getToken(ExampleSetMLNGrammarParser.EQ, 0); }
		public TerminalNode NE() { return getToken(ExampleSetMLNGrammarParser.NE, 0); }
		public BuiltinPredicateSymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtinPredicateSymbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterBuiltinPredicateSymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitBuiltinPredicateSymbol(this);
		}
	}

	public final BuiltinPredicateSymbolContext builtinPredicateSymbol() throws RecognitionException {
		BuiltinPredicateSymbolContext _localctx = new BuiltinPredicateSymbolContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_builtinPredicateSymbol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << GT) | (1L << LT) | (1L << GE) | (1L << LE) | (1L << NE))) != 0)) ) {
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

	public static class PredicateApplicationContext extends ParserRuleContext {
		public TerminalNode RP() { return getToken(ExampleSetMLNGrammarParser.RP, 0); }
		public BuiltinPredicateSymbolContext builtinPredicateSymbol() {
			return getRuleContext(BuiltinPredicateSymbolContext.class,0);
		}
		public List<TerminalNode> COM() { return getTokens(ExampleSetMLNGrammarParser.COM); }
		public TerminalNode LP() { return getToken(ExampleSetMLNGrammarParser.LP, 0); }
		public TerminalNode COM(int i) {
			return getToken(ExampleSetMLNGrammarParser.COM, i);
		}
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public PredicateApplicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateApplication; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterPredicateApplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitPredicateApplication(this);
		}
	}

	public final PredicateApplicationContext predicateApplication() throws RecognitionException {
		PredicateApplicationContext _localctx = new PredicateApplicationContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_predicateApplication);
		int _la;
		try {
			setState(337);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(319); predicate();
				setState(320); match(LP);
				setState(329);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << PLUS) | (1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << VAR_ID) | (1L << CONST_ID) | (1L << STRING))) != 0)) {
					{
					setState(321); argument(0);
					setState(326);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COM) {
						{
						{
						setState(322); match(COM);
						setState(323); argument(0);
						}
						}
						setState(328);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(331); match(RP);
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(333); argument(0);
				setState(334); builtinPredicateSymbol();
				setState(335); argument(0);
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

	public static class FunctionApplicationContext extends ParserRuleContext {
		public TerminalNode RP() { return getToken(ExampleSetMLNGrammarParser.RP, 0); }
		public BuiltinPrefixFunctionSymbolContext builtinPrefixFunctionSymbol() {
			return getRuleContext(BuiltinPrefixFunctionSymbolContext.class,0);
		}
		public List<TerminalNode> COM() { return getTokens(ExampleSetMLNGrammarParser.COM); }
		public TerminalNode LP() { return getToken(ExampleSetMLNGrammarParser.LP, 0); }
		public TerminalNode COM(int i) {
			return getToken(ExampleSetMLNGrammarParser.COM, i);
		}
		public BuiltinFunctionSymbolContext builtinFunctionSymbol() {
			return getRuleContext(BuiltinFunctionSymbolContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public FunctionApplicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionApplication; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterFunctionApplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitFunctionApplication(this);
		}
	}

	public final FunctionApplicationContext functionApplication() throws RecognitionException {
		FunctionApplicationContext _localctx = new FunctionApplicationContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_functionApplication);
		int _la;
		try {
			setState(360);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(339); function();
				setState(340); match(LP);
				setState(349);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << PLUS) | (1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << VAR_ID) | (1L << CONST_ID) | (1L << STRING))) != 0)) {
					{
					setState(341); argument(0);
					setState(346);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COM) {
						{
						{
						setState(342); match(COM);
						setState(343); argument(0);
						}
						}
						setState(348);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(351); match(RP);
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(353); argument(0);
				setState(354); builtinFunctionSymbol();
				setState(355); argument(0);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(357); builtinPrefixFunctionSymbol();
				setState(358); argument(0);
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

	public static class ArgumentContext extends ParserRuleContext {
		public BuiltinPrefixFunctionSymbolContext builtinPrefixFunctionSymbol() {
			return getRuleContext(BuiltinPrefixFunctionSymbolContext.class,0);
		}
		public TerminalNode RP() { return getToken(ExampleSetMLNGrammarParser.RP, 0); }
		public List<TerminalNode> COM() { return getTokens(ExampleSetMLNGrammarParser.COM); }
		public ExpVariableContext expVariable() {
			return getRuleContext(ExpVariableContext.class,0);
		}
		public TerminalNode COM(int i) {
			return getToken(ExampleSetMLNGrammarParser.COM, i);
		}
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public BuiltinPredicateSymbolContext builtinPredicateSymbol() {
			return getRuleContext(BuiltinPredicateSymbolContext.class,0);
		}
		public TerminalNode LP() { return getToken(ExampleSetMLNGrammarParser.LP, 0); }
		public BuiltinFunctionSymbolContext builtinFunctionSymbol() {
			return getRuleContext(BuiltinFunctionSymbolContext.class,0);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitArgument(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		return argument(0);
	}

	private ArgumentContext argument(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArgumentContext _localctx = new ArgumentContext(_ctx, _parentState);
		ArgumentContext _prevctx = _localctx;
		int _startState = 66;
		enterRecursionRule(_localctx, 66, RULE_argument, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(391);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(363); builtinPrefixFunctionSymbol();
				setState(364); argument(6);
				}
				break;

			case 2:
				{
				{
				setState(368);
				switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
				case 1:
					{
					setState(366); predicate();
					}
					break;

				case 2:
					{
					setState(367); function();
					}
					break;
				}
				setState(370); match(LP);
				setState(379);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << PLUS) | (1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << VAR_ID) | (1L << CONST_ID) | (1L << STRING))) != 0)) {
					{
					setState(371); argument(0);
					setState(376);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COM) {
						{
						{
						setState(372); match(COM);
						setState(373); argument(0);
						}
						}
						setState(378);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(381); match(RP);
				}
				}
				break;

			case 3:
				{
				setState(383); variable();
				}
				break;

			case 4:
				{
				setState(384); expVariable();
				}
				break;

			case 5:
				{
				setState(385); constant();
				}
				break;

			case 6:
				{
				setState(386); number();
				}
				break;

			case 7:
				{
				setState(387); match(LP);
				setState(388); argument(0);
				setState(389); match(RP);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(402);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArgumentContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_argument);
					setState(393);
					if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
					setState(396);
					switch (_input.LA(1)) {
					case EQ:
					case GT:
					case LT:
					case GE:
					case LE:
					case NE:
						{
						setState(394); builtinPredicateSymbol();
						}
						break;
					case AND:
					case PLUS:
					case STAR:
					case MINUS:
					case SLASH:
					case MOD:
						{
						setState(395); builtinFunctionSymbol();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(398); argument(8);
					}
					} 
				}
				setState(404);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
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

	public static class GroundPredicateApplicationContext extends ParserRuleContext {
		public BuiltinPrefixFunctionSymbolContext builtinPrefixFunctionSymbol() {
			return getRuleContext(BuiltinPrefixFunctionSymbolContext.class,0);
		}
		public TerminalNode RP() { return getToken(ExampleSetMLNGrammarParser.RP, 0); }
		public GroundArgumentContext groundArgument(int i) {
			return getRuleContext(GroundArgumentContext.class,i);
		}
		public BuiltinPredicateSymbolContext builtinPredicateSymbol() {
			return getRuleContext(BuiltinPredicateSymbolContext.class,0);
		}
		public List<TerminalNode> COM() { return getTokens(ExampleSetMLNGrammarParser.COM); }
		public TerminalNode LP() { return getToken(ExampleSetMLNGrammarParser.LP, 0); }
		public TerminalNode EXCL() { return getToken(ExampleSetMLNGrammarParser.EXCL, 0); }
		public List<GroundArgumentContext> groundArgument() {
			return getRuleContexts(GroundArgumentContext.class);
		}
		public BuiltinFunctionSymbolContext builtinFunctionSymbol() {
			return getRuleContext(BuiltinFunctionSymbolContext.class,0);
		}
		public TerminalNode COM(int i) {
			return getToken(ExampleSetMLNGrammarParser.COM, i);
		}
		public ArgumentContext argument() {
			return getRuleContext(ArgumentContext.class,0);
		}
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public GroundPredicateApplicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groundPredicateApplication; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterGroundPredicateApplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitGroundPredicateApplication(this);
		}
	}

	public final GroundPredicateApplicationContext groundPredicateApplication() throws RecognitionException {
		GroundPredicateApplicationContext _localctx = new GroundPredicateApplicationContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_groundPredicateApplication);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			_la = _input.LA(1);
			if (_la==EXCL) {
				{
				setState(405); match(EXCL);
				}
			}

			setState(434);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				{
				setState(429);
				switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
				case 1:
					{
					{
					setState(408); predicate();
					setState(409); match(LP);
					setState(418);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << CONST_ID) | (1L << STRING))) != 0)) {
						{
						setState(410); groundArgument(0);
						setState(415);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COM) {
							{
							{
							setState(411); match(COM);
							setState(412); groundArgument(0);
							}
							}
							setState(417);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(420); match(RP);
					}
					}
					break;

				case 2:
					{
					setState(422); groundArgument(0);
					setState(425);
					switch (_input.LA(1)) {
					case EQ:
					case GT:
					case LT:
					case GE:
					case LE:
					case NE:
						{
						setState(423); builtinPredicateSymbol();
						}
						break;
					case AND:
					case PLUS:
					case STAR:
					case MINUS:
					case SLASH:
					case MOD:
						{
						setState(424); builtinFunctionSymbol();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(427); groundArgument(0);
					}
					break;
				}
				}
				break;

			case 2:
				{
				setState(431); builtinPrefixFunctionSymbol();
				setState(432); argument(0);
				}
				break;
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

	public static class GroundFunctionApplicationContext extends ParserRuleContext {
		public TerminalNode RP() { return getToken(ExampleSetMLNGrammarParser.RP, 0); }
		public BuiltinPrefixFunctionSymbolContext builtinPrefixFunctionSymbol() {
			return getRuleContext(BuiltinPrefixFunctionSymbolContext.class,0);
		}
		public GroundArgumentContext groundArgument(int i) {
			return getRuleContext(GroundArgumentContext.class,i);
		}
		public BuiltinPredicateSymbolContext builtinPredicateSymbol() {
			return getRuleContext(BuiltinPredicateSymbolContext.class,0);
		}
		public List<TerminalNode> COM() { return getTokens(ExampleSetMLNGrammarParser.COM); }
		public TerminalNode LP() { return getToken(ExampleSetMLNGrammarParser.LP, 0); }
		public List<GroundArgumentContext> groundArgument() {
			return getRuleContexts(GroundArgumentContext.class);
		}
		public TerminalNode COM(int i) {
			return getToken(ExampleSetMLNGrammarParser.COM, i);
		}
		public BuiltinFunctionSymbolContext builtinFunctionSymbol() {
			return getRuleContext(BuiltinFunctionSymbolContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public ArgumentContext argument() {
			return getRuleContext(ArgumentContext.class,0);
		}
		public GroundFunctionApplicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groundFunctionApplication; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterGroundFunctionApplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitGroundFunctionApplication(this);
		}
	}

	public final GroundFunctionApplicationContext groundFunctionApplication() throws RecognitionException {
		GroundFunctionApplicationContext _localctx = new GroundFunctionApplicationContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_groundFunctionApplication);
		int _la;
		try {
			setState(460);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(436); function();
				setState(437); match(LP);
				setState(446);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << CONST_ID) | (1L << STRING))) != 0)) {
					{
					setState(438); groundArgument(0);
					setState(443);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COM) {
						{
						{
						setState(439); match(COM);
						setState(440); groundArgument(0);
						}
						}
						setState(445);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(448); match(RP);
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(450); groundArgument(0);
				setState(453);
				switch (_input.LA(1)) {
				case EQ:
				case GT:
				case LT:
				case GE:
				case LE:
				case NE:
					{
					setState(451); builtinPredicateSymbol();
					}
					break;
				case AND:
				case PLUS:
				case STAR:
				case MINUS:
				case SLASH:
				case MOD:
					{
					setState(452); builtinFunctionSymbol();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(455); groundArgument(0);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(457); builtinPrefixFunctionSymbol();
				setState(458); argument(0);
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

	public static class GroundArgumentContext extends ParserRuleContext {
		public TerminalNode RP() { return getToken(ExampleSetMLNGrammarParser.RP, 0); }
		public BuiltinPrefixFunctionSymbolContext builtinPrefixFunctionSymbol() {
			return getRuleContext(BuiltinPrefixFunctionSymbolContext.class,0);
		}
		public GroundArgumentContext groundArgument(int i) {
			return getRuleContext(GroundArgumentContext.class,i);
		}
		public List<TerminalNode> COM() { return getTokens(ExampleSetMLNGrammarParser.COM); }
		public List<GroundArgumentContext> groundArgument() {
			return getRuleContexts(GroundArgumentContext.class);
		}
		public TerminalNode COM(int i) {
			return getToken(ExampleSetMLNGrammarParser.COM, i);
		}
		public ArgumentContext argument() {
			return getRuleContext(ArgumentContext.class,0);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public BuiltinPredicateSymbolContext builtinPredicateSymbol() {
			return getRuleContext(BuiltinPredicateSymbolContext.class,0);
		}
		public TerminalNode LP() { return getToken(ExampleSetMLNGrammarParser.LP, 0); }
		public BuiltinFunctionSymbolContext builtinFunctionSymbol() {
			return getRuleContext(BuiltinFunctionSymbolContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public GroundArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groundArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterGroundArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitGroundArgument(this);
		}
	}

	public final GroundArgumentContext groundArgument() throws RecognitionException {
		return groundArgument(0);
	}

	private GroundArgumentContext groundArgument(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		GroundArgumentContext _localctx = new GroundArgumentContext(_ctx, _parentState);
		GroundArgumentContext _prevctx = _localctx;
		int _startState = 72;
		enterRecursionRule(_localctx, 72, RULE_groundArgument, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(489);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				{
				{
				setState(465);
				switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
				case 1:
					{
					setState(463); predicate();
					}
					break;

				case 2:
					{
					setState(464); function();
					}
					break;
				}
				setState(467); match(LP);
				setState(476);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << CONST_ID) | (1L << STRING))) != 0)) {
					{
					setState(468); groundArgument(0);
					setState(473);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COM) {
						{
						{
						setState(469); match(COM);
						setState(470); groundArgument(0);
						}
						}
						setState(475);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(478); match(RP);
				}
				}
				break;

			case 2:
				{
				setState(480); builtinPrefixFunctionSymbol();
				setState(481); argument(0);
				}
				break;

			case 3:
				{
				setState(483); constant();
				}
				break;

			case 4:
				{
				setState(484); number();
				}
				break;

			case 5:
				{
				setState(485); match(LP);
				setState(486); groundArgument(0);
				setState(487); match(RP);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(500);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new GroundArgumentContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_groundArgument);
					setState(491);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(494);
					switch (_input.LA(1)) {
					case EQ:
					case GT:
					case LT:
					case GE:
					case LE:
					case NE:
						{
						setState(492); builtinPredicateSymbol();
						}
						break;
					case AND:
					case PLUS:
					case STAR:
					case MINUS:
					case SLASH:
					case MOD:
						{
						setState(493); builtinFunctionSymbol();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(496); groundArgument(6);
					}
					} 
				}
				setState(502);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
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

	public static class ReturnValueContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ReturnValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterReturnValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitReturnValue(this);
		}
	}

	public final ReturnValueContext returnValue() throws RecognitionException {
		ReturnValueContext _localctx = new ReturnValueContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_returnValue);
		try {
			setState(505);
			switch (_input.LA(1)) {
			case CONST_ID:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(503); constant();
				}
				break;
			case INT:
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(504); number();
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

	public static class FunctionDefContext extends ParserRuleContext {
		public ReturnValueContext returnValue() {
			return getRuleContext(ReturnValueContext.class,0);
		}
		public GroundFunctionApplicationContext groundFunctionApplication() {
			return getRuleContext(GroundFunctionApplicationContext.class,0);
		}
		public TerminalNode EQ() { return getToken(ExampleSetMLNGrammarParser.EQ, 0); }
		public FunctionDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterFunctionDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitFunctionDef(this);
		}
	}

	public final FunctionDefContext functionDef() throws RecognitionException {
		FunctionDefContext _localctx = new FunctionDefContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_functionDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(507); returnValue();
			setState(508); match(EQ);
			setState(509); groundFunctionApplication();
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

	public static class TypeDeclContext extends ParserRuleContext {
		public TerminalNode RCP() { return getToken(ExampleSetMLNGrammarParser.RCP, 0); }
		public ConstantListContext constantList() {
			return getRuleContext(ConstantListContext.class,0);
		}
		public TerminalNode LCP() { return getToken(ExampleSetMLNGrammarParser.LCP, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode EQ() { return getToken(ExampleSetMLNGrammarParser.EQ, 0); }
		public NumListContext numList() {
			return getRuleContext(NumListContext.class,0);
		}
		public TypeDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterTypeDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitTypeDecl(this);
		}
	}

	public final TypeDeclContext typeDecl() throws RecognitionException {
		TypeDeclContext _localctx = new TypeDeclContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_typeDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(511); type();
			setState(512); match(EQ);
			setState(513); match(LCP);
			setState(517);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				{
				}
				break;

			case 2:
				{
				setState(515); constantList();
				}
				break;

			case 3:
				{
				setState(516); numList();
				}
				break;
			}
			setState(519); match(RCP);
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

	public static class PlainPredicateContext extends ParserRuleContext {
		public TerminalNode RP() { return getToken(ExampleSetMLNGrammarParser.RP, 0); }
		public TerminalNode LP() { return getToken(ExampleSetMLNGrammarParser.LP, 0); }
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public PlainPredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plainPredicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterPlainPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitPlainPredicate(this);
		}
	}

	public final PlainPredicateContext plainPredicate() throws RecognitionException {
		PlainPredicateContext _localctx = new PlainPredicateContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_plainPredicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(521); predicate();
			setState(522); match(LP);
			setState(523); typeList();
			setState(524); match(RP);
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

	public static class ClosedWorldPredicateContext extends ParserRuleContext {
		public PlainPredicateContext plainPredicate() {
			return getRuleContext(PlainPredicateContext.class,0);
		}
		public TerminalNode STAR() { return getToken(ExampleSetMLNGrammarParser.STAR, 0); }
		public ClosedWorldPredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closedWorldPredicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterClosedWorldPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitClosedWorldPredicate(this);
		}
	}

	public final ClosedWorldPredicateContext closedWorldPredicate() throws RecognitionException {
		ClosedWorldPredicateContext _localctx = new ClosedWorldPredicateContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_closedWorldPredicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(526); match(STAR);
			setState(527); plainPredicate();
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

	public static class PredicateDeclContext extends ParserRuleContext {
		public PlainPredicateContext plainPredicate() {
			return getRuleContext(PlainPredicateContext.class,0);
		}
		public ClosedWorldPredicateContext closedWorldPredicate() {
			return getRuleContext(ClosedWorldPredicateContext.class,0);
		}
		public PredicateDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterPredicateDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitPredicateDecl(this);
		}
	}

	public final PredicateDeclContext predicateDecl() throws RecognitionException {
		PredicateDeclContext _localctx = new PredicateDeclContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_predicateDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(531);
			switch (_input.LA(1)) {
			case STAR:
				{
				setState(529); closedWorldPredicate();
				}
				break;
			case CONST_ID:
				{
				setState(530); plainPredicate();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class FunctionDeclContext extends ParserRuleContext {
		public TerminalNode RP() { return getToken(ExampleSetMLNGrammarParser.RP, 0); }
		public TerminalNode LP() { return getToken(ExampleSetMLNGrammarParser.LP, 0); }
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public FunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterFunctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitFunctionDecl(this);
		}
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_functionDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(533); type();
			setState(534); function();
			setState(535); match(LP);
			setState(536); typeList();
			setState(537); match(RP);
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

	public static class PlainFormulaContext extends ParserRuleContext {
		public TerminalNode RP() { return getToken(ExampleSetMLNGrammarParser.RP, 0); }
		public ImpliesContext implies() {
			return getRuleContext(ImpliesContext.class,0);
		}
		public OrContext or() {
			return getRuleContext(OrContext.class,0);
		}
		public List<PlainFormulaContext> plainFormula() {
			return getRuleContexts(PlainFormulaContext.class);
		}
		public TerminalNode LSP() { return getToken(ExampleSetMLNGrammarParser.LSP, 0); }
		public FunctionApplicationContext functionApplication() {
			return getRuleContext(FunctionApplicationContext.class,0);
		}
		public QuantificationContext quantification() {
			return getRuleContext(QuantificationContext.class,0);
		}
		public TerminalNode LP() { return getToken(ExampleSetMLNGrammarParser.LP, 0); }
		public TerminalNode RSP() { return getToken(ExampleSetMLNGrammarParser.RSP, 0); }
		public IffContext iff() {
			return getRuleContext(IffContext.class,0);
		}
		public TerminalNode EXCL() { return getToken(ExampleSetMLNGrammarParser.EXCL, 0); }
		public TerminalNode EQ() { return getToken(ExampleSetMLNGrammarParser.EQ, 0); }
		public PlainFormulaContext plainFormula(int i) {
			return getRuleContext(PlainFormulaContext.class,i);
		}
		public PredicateApplicationContext predicateApplication() {
			return getRuleContext(PredicateApplicationContext.class,0);
		}
		public AndContext and() {
			return getRuleContext(AndContext.class,0);
		}
		public PlainFormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plainFormula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterPlainFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitPlainFormula(this);
		}
	}

	public final PlainFormulaContext plainFormula() throws RecognitionException {
		return plainFormula(0);
	}

	private PlainFormulaContext plainFormula(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PlainFormulaContext _localctx = new PlainFormulaContext(_ctx, _parentState);
		PlainFormulaContext _prevctx = _localctx;
		int _startState = 88;
		enterRecursionRule(_localctx, 88, RULE_plainFormula, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(553);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				{
				setState(540); match(EXCL);
				setState(541); plainFormula(7);
				}
				break;

			case 2:
				{
				setState(542); predicateApplication();
				}
				break;

			case 3:
				{
				setState(543); functionApplication();
				}
				break;

			case 4:
				{
				setState(544); match(LSP);
				setState(545); plainFormula(0);
				setState(546); match(RSP);
				}
				break;

			case 5:
				{
				setState(548); match(LP);
				setState(549); plainFormula(0);
				setState(550); match(RP);
				}
				break;

			case 6:
				{
				setState(552); quantification();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(576);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(574);
					switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
					case 1:
						{
						_localctx = new PlainFormulaContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_plainFormula);
						setState(555);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(556); match(EQ);
						setState(557); plainFormula(7);
						}
						break;

					case 2:
						{
						_localctx = new PlainFormulaContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_plainFormula);
						setState(558);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(559); and();
						setState(560); plainFormula(6);
						}
						break;

					case 3:
						{
						_localctx = new PlainFormulaContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_plainFormula);
						setState(562);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(563); or();
						setState(564); plainFormula(5);
						}
						break;

					case 4:
						{
						_localctx = new PlainFormulaContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_plainFormula);
						setState(566);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(567); implies();
						setState(568); plainFormula(4);
						}
						break;

					case 5:
						{
						_localctx = new PlainFormulaContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_plainFormula);
						setState(570);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(571); iff();
						setState(572); plainFormula(3);
						}
						break;
					}
					} 
				}
				setState(578);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
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

	public static class ProbabilityContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(ExampleSetMLNGrammarParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(ExampleSetMLNGrammarParser.FLOAT, 0); }
		public ProbabilityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_probability; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterProbability(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitProbability(this);
		}
	}

	public final ProbabilityContext probability() throws RecognitionException {
		ProbabilityContext _localctx = new ProbabilityContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_probability);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(579);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==FLOAT) ) {
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

	public static class ProbabilityStatementContext extends ParserRuleContext {
		public ProbabilityContext probability() {
			return getRuleContext(ProbabilityContext.class,0);
		}
		public GroundFormulaContext groundFormula() {
			return getRuleContext(GroundFormulaContext.class,0);
		}
		public ProbabilityStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_probabilityStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterProbabilityStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitProbabilityStatement(this);
		}
	}

	public final ProbabilityStatementContext probabilityStatement() throws RecognitionException {
		ProbabilityStatementContext _localctx = new ProbabilityStatementContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_probabilityStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(581); groundFormula();
			setState(583);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				{
				setState(582); probability();
				}
				break;
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

	public static class WeightContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(ExampleSetMLNGrammarParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(ExampleSetMLNGrammarParser.FLOAT, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public WeightContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_weight; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterWeight(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitWeight(this);
		}
	}

	public final WeightContext weight() throws RecognitionException {
		WeightContext _localctx = new WeightContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_weight);
		try {
			setState(588);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(585); match(INT);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(586); match(FLOAT);
				}
				break;
			case VAR_ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(587); variable();
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

	public static class UtilWeightContext extends ParserRuleContext {
		public WeightContext weight() {
			return getRuleContext(WeightContext.class,0);
		}
		public UtilWeightContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_utilWeight; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterUtilWeight(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitUtilWeight(this);
		}
	}

	public final UtilWeightContext utilWeight() throws RecognitionException {
		UtilWeightContext _localctx = new UtilWeightContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_utilWeight);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(590); weight();
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

	public static class ProbWeightContext extends ParserRuleContext {
		public WeightContext weight() {
			return getRuleContext(WeightContext.class,0);
		}
		public ProbWeightContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_probWeight; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterProbWeight(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitProbWeight(this);
		}
	}

	public final ProbWeightContext probWeight() throws RecognitionException {
		ProbWeightContext _localctx = new ProbWeightContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_probWeight);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(592); weight();
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

	public static class WeightsContext extends ParserRuleContext {
		public ProbWeightContext probWeight() {
			return getRuleContext(ProbWeightContext.class,0);
		}
		public UtilWeightContext utilWeight() {
			return getRuleContext(UtilWeightContext.class,0);
		}
		public TerminalNode COL() { return getToken(ExampleSetMLNGrammarParser.COL, 0); }
		public WeightsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_weights; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterWeights(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitWeights(this);
		}
	}

	public final WeightsContext weights() throws RecognitionException {
		WeightsContext _localctx = new WeightsContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_weights);
		try {
			setState(601);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(594); probWeight();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(595); match(COL);
				setState(596); utilWeight();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(597); probWeight();
				setState(598); match(COL);
				setState(599); utilWeight();
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

	public static class WeightedFormulaContext extends ParserRuleContext {
		public PlainFormulaContext plainFormula() {
			return getRuleContext(PlainFormulaContext.class,0);
		}
		public WeightsContext weights() {
			return getRuleContext(WeightsContext.class,0);
		}
		public WeightedFormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_weightedFormula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterWeightedFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitWeightedFormula(this);
		}
	}

	public final WeightedFormulaContext weightedFormula() throws RecognitionException {
		WeightedFormulaContext _localctx = new WeightedFormulaContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_weightedFormula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(603); weights();
			setState(604); plainFormula(0);
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

	public static class HardFormulaContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(ExampleSetMLNGrammarParser.DOT, 0); }
		public PlainFormulaContext plainFormula() {
			return getRuleContext(PlainFormulaContext.class,0);
		}
		public HardFormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hardFormula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterHardFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitHardFormula(this);
		}
	}

	public final HardFormulaContext hardFormula() throws RecognitionException {
		HardFormulaContext _localctx = new HardFormulaContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_hardFormula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(606); plainFormula(0);
			setState(607); match(DOT);
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

	public static class FormulaContext extends ParserRuleContext {
		public HardFormulaContext hardFormula() {
			return getRuleContext(HardFormulaContext.class,0);
		}
		public WeightedFormulaContext weightedFormula() {
			return getRuleContext(WeightedFormulaContext.class,0);
		}
		public PlainFormulaContext plainFormula() {
			return getRuleContext(PlainFormulaContext.class,0);
		}
		public FormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitFormula(this);
		}
	}

	public final FormulaContext formula() throws RecognitionException {
		FormulaContext _localctx = new FormulaContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_formula);
		try {
			setState(612);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(609); plainFormula(0);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(610); weightedFormula();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(611); hardFormula();
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

	public static class GroundFormulaContext extends ParserRuleContext {
		public List<TerminalNode> NL() { return getTokens(ExampleSetMLNGrammarParser.NL); }
		public FunctionDefContext functionDef() {
			return getRuleContext(FunctionDefContext.class,0);
		}
		public GroundPredicateApplicationContext groundPredicateApplication() {
			return getRuleContext(GroundPredicateApplicationContext.class,0);
		}
		public TerminalNode NL(int i) {
			return getToken(ExampleSetMLNGrammarParser.NL, i);
		}
		public GroundFormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groundFormula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterGroundFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitGroundFormula(this);
		}
	}

	public final GroundFormulaContext groundFormula() throws RecognitionException {
		GroundFormulaContext _localctx = new GroundFormulaContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_groundFormula);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(617);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(614); match(NL);
				}
				}
				setState(619);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(622);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				{
				setState(620); groundPredicateApplication();
				}
				break;

			case 2:
				{
				setState(621); functionDef();
				}
				break;
			}
			setState(625);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				{
				setState(624); match(NL);
				}
				break;
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

	public static class QuantificationContext extends ParserRuleContext {
		public List<TerminalNode> BAR() { return getTokens(ExampleSetMLNGrammarParser.BAR); }
		public TerminalNode GE() { return getToken(ExampleSetMLNGrammarParser.GE, 0); }
		public CardinalityContext cardinality() {
			return getRuleContext(CardinalityContext.class,0);
		}
		public TerminalNode BAR(int i) {
			return getToken(ExampleSetMLNGrammarParser.BAR, i);
		}
		public PlainFormulaContext plainFormula() {
			return getRuleContext(PlainFormulaContext.class,0);
		}
		public TerminalNode LE() { return getToken(ExampleSetMLNGrammarParser.LE, 0); }
		public QuantifierContext quantifier() {
			return getRuleContext(QuantifierContext.class,0);
		}
		public VariableListContext variableList() {
			return getRuleContext(VariableListContext.class,0);
		}
		public QuantificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).enterQuantification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleSetMLNGrammarListener ) ((ExampleSetMLNGrammarListener)listener).exitQuantification(this);
		}
	}

	public final QuantificationContext quantification() throws RecognitionException {
		QuantificationContext _localctx = new QuantificationContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_quantification);
		int _la;
		try {
			setState(638);
			switch (_input.LA(1)) {
			case U_QUANT:
			case E_QUANT:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(627); quantifier();
				setState(628); variableList();
				setState(629); plainFormula(0);
				}
				}
				break;
			case BAR:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(631); match(BAR);
				setState(632); variableList();
				setState(633); match(BAR);
				setState(634); plainFormula(0);
				setState(635);
				_la = _input.LA(1);
				if ( !(_la==GE || _la==LE) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(636); cardinality();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 33: return argument_sempred((ArgumentContext)_localctx, predIndex);

		case 36: return groundArgument_sempred((GroundArgumentContext)_localctx, predIndex);

		case 44: return plainFormula_sempred((PlainFormulaContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean groundArgument_sempred(GroundArgumentContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return precpred(_ctx, 5);
		}
		return true;
	}
	private boolean argument_sempred(ArgumentContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 7);
		}
		return true;
	}
	private boolean plainFormula_sempred(PlainFormulaContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return precpred(_ctx, 6);

		case 3: return precpred(_ctx, 5);

		case 4: return precpred(_ctx, 4);

		case 5: return precpred(_ctx, 3);

		case 6: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3(\u0283\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\3\2\7\2t\n\2\f\2\16\2w\13"+
		"\2\3\2\3\2\7\2{\n\2\f\2\16\2~\13\2\7\2\u0080\n\2\f\2\16\2\u0083\13\2\3"+
		"\2\3\2\5\2\u0087\n\2\3\2\7\2\u008a\n\2\f\2\16\2\u008d\13\2\7\2\u008f\n"+
		"\2\f\2\16\2\u0092\13\2\3\2\3\2\7\2\u0096\n\2\f\2\16\2\u0099\13\2\7\2\u009b"+
		"\n\2\f\2\16\2\u009e\13\2\3\3\3\3\7\3\u00a2\n\3\f\3\16\3\u00a5\13\3\7\3"+
		"\u00a7\n\3\f\3\16\3\u00aa\13\3\3\4\3\4\7\4\u00ae\n\4\f\4\16\4\u00b1\13"+
		"\4\7\4\u00b3\n\4\f\4\16\4\u00b6\13\4\3\5\3\5\7\5\u00ba\n\5\f\5\16\5\u00bd"+
		"\13\5\7\5\u00bf\n\5\f\5\16\5\u00c2\13\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3"+
		"\t\3\t\3\t\3\n\3\n\5\n\u00d0\n\n\3\13\3\13\3\f\3\f\3\r\6\r\u00d7\n\r\r"+
		"\r\16\r\u00d8\3\16\3\16\3\17\3\17\3\20\3\20\7\20\u00e1\n\20\f\20\16\20"+
		"\u00e4\13\20\3\20\3\20\7\20\u00e8\n\20\f\20\16\20\u00eb\13\20\3\21\3\21"+
		"\5\21\u00ef\n\21\3\21\3\21\3\21\5\21\u00f4\n\21\7\21\u00f6\n\21\f\21\16"+
		"\21\u00f9\13\21\3\22\3\22\3\22\7\22\u00fe\n\22\f\22\16\22\u0101\13\22"+
		"\3\22\5\22\u0104\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\7\24"+
		"\u010f\n\24\f\24\16\24\u0112\13\24\3\25\3\25\5\25\u0116\n\25\3\26\3\26"+
		"\7\26\u011a\n\26\f\26\16\26\u011d\13\26\3\27\3\27\7\27\u0121\n\27\f\27"+
		"\16\27\u0124\13\27\3\30\3\30\7\30\u0128\n\30\f\30\16\30\u012b\13\30\3"+
		"\31\3\31\7\31\u012f\n\31\f\31\16\31\u0132\13\31\3\32\3\32\3\33\3\33\3"+
		"\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3!\3!\3!\7!\u0147\n"+
		"!\f!\16!\u014a\13!\5!\u014c\n!\3!\3!\3!\3!\3!\3!\5!\u0154\n!\3\"\3\"\3"+
		"\"\3\"\3\"\7\"\u015b\n\"\f\"\16\"\u015e\13\"\5\"\u0160\n\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u016b\n\"\3#\3#\3#\3#\3#\3#\5#\u0173\n#\3"+
		"#\3#\3#\3#\7#\u0179\n#\f#\16#\u017c\13#\5#\u017e\n#\3#\3#\3#\3#\3#\3#"+
		"\3#\3#\3#\3#\5#\u018a\n#\3#\3#\3#\5#\u018f\n#\3#\3#\7#\u0193\n#\f#\16"+
		"#\u0196\13#\3$\5$\u0199\n$\3$\3$\3$\3$\3$\7$\u01a0\n$\f$\16$\u01a3\13"+
		"$\5$\u01a5\n$\3$\3$\3$\3$\3$\5$\u01ac\n$\3$\3$\5$\u01b0\n$\3$\3$\3$\5"+
		"$\u01b5\n$\3%\3%\3%\3%\3%\7%\u01bc\n%\f%\16%\u01bf\13%\5%\u01c1\n%\3%"+
		"\3%\3%\3%\3%\5%\u01c8\n%\3%\3%\3%\3%\3%\5%\u01cf\n%\3&\3&\3&\5&\u01d4"+
		"\n&\3&\3&\3&\3&\7&\u01da\n&\f&\16&\u01dd\13&\5&\u01df\n&\3&\3&\3&\3&\3"+
		"&\3&\3&\3&\3&\3&\3&\5&\u01ec\n&\3&\3&\3&\5&\u01f1\n&\3&\3&\7&\u01f5\n"+
		"&\f&\16&\u01f8\13&\3\'\3\'\5\'\u01fc\n\'\3(\3(\3(\3(\3)\3)\3)\3)\3)\3"+
		")\5)\u0208\n)\3)\3)\3*\3*\3*\3*\3*\3+\3+\3+\3,\3,\5,\u0216\n,\3-\3-\3"+
		"-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\5.\u022c\n.\3.\3"+
		".\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\7.\u0241\n.\f.\16"+
		".\u0244\13.\3/\3/\3\60\3\60\5\60\u024a\n\60\3\61\3\61\3\61\5\61\u024f"+
		"\n\61\3\62\3\62\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\5\64\u025c"+
		"\n\64\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3\67\3\67\5\67\u0267\n\67\38"+
		"\78\u026a\n8\f8\168\u026d\138\38\38\58\u0271\n8\38\58\u0274\n8\39\39\3"+
		"9\39\39\39\39\39\39\39\39\59\u0281\n9\39\2\5DJZ:\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnp"+
		"\2\b\3\2\'(\3\2$%\3\2\27\30\5\2\23\23\32\33!#\4\2\31\31\34 \3\2\36\37"+
		"\u02a7\2u\3\2\2\2\4\u00a8\3\2\2\2\6\u00b4\3\2\2\2\b\u00c0\3\2\2\2\n\u00c3"+
		"\3\2\2\2\f\u00c5\3\2\2\2\16\u00c8\3\2\2\2\20\u00ca\3\2\2\2\22\u00cf\3"+
		"\2\2\2\24\u00d1\3\2\2\2\26\u00d3\3\2\2\2\30\u00d6\3\2\2\2\32\u00da\3\2"+
		"\2\2\34\u00dc\3\2\2\2\36\u00de\3\2\2\2 \u00ee\3\2\2\2\"\u0103\3\2\2\2"+
		"$\u0105\3\2\2\2&\u010b\3\2\2\2(\u0115\3\2\2\2*\u0117\3\2\2\2,\u011e\3"+
		"\2\2\2.\u0125\3\2\2\2\60\u012c\3\2\2\2\62\u0133\3\2\2\2\64\u0135\3\2\2"+
		"\2\66\u0137\3\2\2\28\u0139\3\2\2\2:\u013b\3\2\2\2<\u013d\3\2\2\2>\u013f"+
		"\3\2\2\2@\u0153\3\2\2\2B\u016a\3\2\2\2D\u0189\3\2\2\2F\u0198\3\2\2\2H"+
		"\u01ce\3\2\2\2J\u01eb\3\2\2\2L\u01fb\3\2\2\2N\u01fd\3\2\2\2P\u0201\3\2"+
		"\2\2R\u020b\3\2\2\2T\u0210\3\2\2\2V\u0215\3\2\2\2X\u0217\3\2\2\2Z\u022b"+
		"\3\2\2\2\\\u0245\3\2\2\2^\u0247\3\2\2\2`\u024e\3\2\2\2b\u0250\3\2\2\2"+
		"d\u0252\3\2\2\2f\u025b\3\2\2\2h\u025d\3\2\2\2j\u0260\3\2\2\2l\u0266\3"+
		"\2\2\2n\u026b\3\2\2\2p\u0280\3\2\2\2rt\7\6\2\2sr\3\2\2\2tw\3\2\2\2us\3"+
		"\2\2\2uv\3\2\2\2v\u0081\3\2\2\2wu\3\2\2\2x|\5P)\2y{\7\6\2\2zy\3\2\2\2"+
		"{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2\177x\3\2\2\2\u0080"+
		"\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0090\3\2\2"+
		"\2\u0083\u0081\3\2\2\2\u0084\u0087\5V,\2\u0085\u0087\5X-\2\u0086\u0084"+
		"\3\2\2\2\u0086\u0085\3\2\2\2\u0087\u008b\3\2\2\2\u0088\u008a\7\6\2\2\u0089"+
		"\u0088\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2"+
		"\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u0086\3\2\2\2\u008f"+
		"\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u009c\3\2"+
		"\2\2\u0092\u0090\3\2\2\2\u0093\u0097\5l\67\2\u0094\u0096\7\6\2\2\u0095"+
		"\u0094\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2"+
		"\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u0093\3\2\2\2\u009b"+
		"\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\3\3\2\2\2"+
		"\u009e\u009c\3\2\2\2\u009f\u00a3\5n8\2\u00a0\u00a2\7\6\2\2\u00a1\u00a0"+
		"\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4"+
		"\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6\u009f\3\2\2\2\u00a7\u00aa\3\2"+
		"\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\5\3\2\2\2\u00aa\u00a8"+
		"\3\2\2\2\u00ab\u00af\5^\60\2\u00ac\u00ae\7\6\2\2\u00ad\u00ac\3\2\2\2\u00ae"+
		"\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b3\3\2"+
		"\2\2\u00b1\u00af\3\2\2\2\u00b2\u00ab\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4"+
		"\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\7\3\2\2\2\u00b6\u00b4\3\2\2\2"+
		"\u00b7\u00bb\5V,\2\u00b8\u00ba\7\6\2\2\u00b9\u00b8\3\2\2\2\u00ba\u00bd"+
		"\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd"+
		"\u00bb\3\2\2\2\u00be\u00b7\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2"+
		"\2\2\u00c0\u00c1\3\2\2\2\u00c1\t\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00c4"+
		"\t\2\2\2\u00c4\13\3\2\2\2\u00c5\u00c6\7\32\2\2\u00c6\u00c7\5\16\b\2\u00c7"+
		"\r\3\2\2\2\u00c8\u00c9\7&\2\2\u00c9\17\3\2\2\2\u00ca\u00cb\7&\2\2\u00cb"+
		"\u00cc\7\21\2\2\u00cc\21\3\2\2\2\u00cd\u00d0\7&\2\2\u00ce\u00d0\5\20\t"+
		"\2\u00cf\u00cd\3\2\2\2\u00cf\u00ce\3\2\2\2\u00d0\23\3\2\2\2\u00d1\u00d2"+
		"\5\34\17\2\u00d2\25\3\2\2\2\u00d3\u00d4\5\34\17\2\u00d4\27\3\2\2\2\u00d5"+
		"\u00d7\7\6\2\2\u00d6\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d6\3\2"+
		"\2\2\u00d8\u00d9\3\2\2\2\u00d9\31\3\2\2\2\u00da\u00db\7$\2\2\u00db\33"+
		"\3\2\2\2\u00dc\u00dd\t\3\2\2\u00dd\35\3\2\2\2\u00de\u00e2\5\n\6\2\u00df"+
		"\u00e1\7\6\2\2\u00e0\u00df\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2"+
		"\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e9\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5"+
		"\u00e6\7\20\2\2\u00e6\u00e8\5\n\6\2\u00e7\u00e5\3\2\2\2\u00e8\u00eb\3"+
		"\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\37\3\2\2\2\u00eb"+
		"\u00e9\3\2\2\2\u00ec\u00ef\5\16\b\2\u00ed\u00ef\5\f\7\2\u00ee\u00ec\3"+
		"\2\2\2\u00ee\u00ed\3\2\2\2\u00ef\u00f7\3\2\2\2\u00f0\u00f3\7\20\2\2\u00f1"+
		"\u00f4\5\16\b\2\u00f2\u00f4\5\f\7\2\u00f3\u00f1\3\2\2\2\u00f3\u00f2\3"+
		"\2\2\2\u00f4\u00f6\3\2\2\2\u00f5\u00f0\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7"+
		"\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8!\3\2\2\2\u00f9\u00f7\3\2\2\2"+
		"\u00fa\u00ff\5\22\n\2\u00fb\u00fc\7\20\2\2\u00fc\u00fe\5\22\n\2\u00fd"+
		"\u00fb\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2"+
		"\2\2\u0100\u0104\3\2\2\2\u0101\u00ff\3\2\2\2\u0102\u0104\3\2\2\2\u0103"+
		"\u00fa\3\2\2\2\u0103\u0102\3\2\2\2\u0104#\3\2\2\2\u0105\u0106\5\24\13"+
		"\2\u0106\u0107\7\20\2\2\u0107\u0108\7\r\2\2\u0108\u0109\7\20\2\2\u0109"+
		"\u010a\5\26\f\2\u010a%\3\2\2\2\u010b\u0110\5\34\17\2\u010c\u010d\7\20"+
		"\2\2\u010d\u010f\5\34\17\2\u010e\u010c\3\2\2\2\u010f\u0112\3\2\2\2\u0110"+
		"\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111\'\3\2\2\2\u0112\u0110\3\2\2\2"+
		"\u0113\u0116\5$\23\2\u0114\u0116\5&\24\2\u0115\u0113\3\2\2\2\u0115\u0114"+
		"\3\2\2\2\u0116)\3\2\2\2\u0117\u011b\7\23\2\2\u0118\u011a\7\6\2\2\u0119"+
		"\u0118\3\2\2\2\u011a\u011d\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2"+
		"\2\2\u011c+\3\2\2\2\u011d\u011b\3\2\2\2\u011e\u0122\7\24\2\2\u011f\u0121"+
		"\7\6\2\2\u0120\u011f\3\2\2\2\u0121\u0124\3\2\2\2\u0122\u0120\3\2\2\2\u0122"+
		"\u0123\3\2\2\2\u0123-\3\2\2\2\u0124\u0122\3\2\2\2\u0125\u0129\7\25\2\2"+
		"\u0126\u0128\7\6\2\2\u0127\u0126\3\2\2\2\u0128\u012b\3\2\2\2\u0129\u0127"+
		"\3\2\2\2\u0129\u012a\3\2\2\2\u012a/\3\2\2\2\u012b\u0129\3\2\2\2\u012c"+
		"\u0130\7\26\2\2\u012d\u012f\7\6\2\2\u012e\u012d\3\2\2\2\u012f\u0132\3"+
		"\2\2\2\u0130\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131\61\3\2\2\2\u0132"+
		"\u0130\3\2\2\2\u0133\u0134\t\4\2\2\u0134\63\3\2\2\2\u0135\u0136\7\31\2"+
		"\2\u0136\65\3\2\2\2\u0137\u0138\7\'\2\2\u0138\67\3\2\2\2\u0139\u013a\t"+
		"\5\2\2\u013a9\3\2\2\2\u013b\u013c\7!\2\2\u013c;\3\2\2\2\u013d\u013e\7"+
		"\'\2\2\u013e=\3\2\2\2\u013f\u0140\t\6\2\2\u0140?\3\2\2\2\u0141\u0142\5"+
		"<\37\2\u0142\u014b\7\7\2\2\u0143\u0148\5D#\2\u0144\u0145\7\20\2\2\u0145"+
		"\u0147\5D#\2\u0146\u0144\3\2\2\2\u0147\u014a\3\2\2\2\u0148\u0146\3\2\2"+
		"\2\u0148\u0149\3\2\2\2\u0149\u014c\3\2\2\2\u014a\u0148\3\2\2\2\u014b\u0143"+
		"\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014e\7\b\2\2\u014e"+
		"\u0154\3\2\2\2\u014f\u0150\5D#\2\u0150\u0151\5> \2\u0151\u0152\5D#\2\u0152"+
		"\u0154\3\2\2\2\u0153\u0141\3\2\2\2\u0153\u014f\3\2\2\2\u0154A\3\2\2\2"+
		"\u0155\u0156\5\66\34\2\u0156\u015f\7\7\2\2\u0157\u015c\5D#\2\u0158\u0159"+
		"\7\20\2\2\u0159\u015b\5D#\2\u015a\u0158\3\2\2\2\u015b\u015e\3\2\2\2\u015c"+
		"\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u0160\3\2\2\2\u015e\u015c\3\2"+
		"\2\2\u015f\u0157\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0161\3\2\2\2\u0161"+
		"\u0162\7\b\2\2\u0162\u016b\3\2\2\2\u0163\u0164\5D#\2\u0164\u0165\58\35"+
		"\2\u0165\u0166\5D#\2\u0166\u016b\3\2\2\2\u0167\u0168\5:\36\2\u0168\u0169"+
		"\5D#\2\u0169\u016b\3\2\2\2\u016a\u0155\3\2\2\2\u016a\u0163\3\2\2\2\u016a"+
		"\u0167\3\2\2\2\u016bC\3\2\2\2\u016c\u016d\b#\1\2\u016d\u016e\5:\36\2\u016e"+
		"\u016f\5D#\b\u016f\u018a\3\2\2\2\u0170\u0173\5<\37\2\u0171\u0173\5\66"+
		"\34\2\u0172\u0170\3\2\2\2\u0172\u0171\3\2\2\2\u0173\u0174\3\2\2\2\u0174"+
		"\u017d\7\7\2\2\u0175\u017a\5D#\2\u0176\u0177\7\20\2\2\u0177\u0179\5D#"+
		"\2\u0178\u0176\3\2\2\2\u0179\u017c\3\2\2\2\u017a\u0178\3\2\2\2\u017a\u017b"+
		"\3\2\2\2\u017b\u017e\3\2\2\2\u017c\u017a\3\2\2\2\u017d\u0175\3\2\2\2\u017d"+
		"\u017e\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0180\7\b\2\2\u0180\u018a\3\2"+
		"\2\2\u0181\u018a\5\16\b\2\u0182\u018a\5\f\7\2\u0183\u018a\5\n\6\2\u0184"+
		"\u018a\5\34\17\2\u0185\u0186\7\7\2\2\u0186\u0187\5D#\2\u0187\u0188\7\b"+
		"\2\2\u0188\u018a\3\2\2\2\u0189\u016c\3\2\2\2\u0189\u0172\3\2\2\2\u0189"+
		"\u0181\3\2\2\2\u0189\u0182\3\2\2\2\u0189\u0183\3\2\2\2\u0189\u0184\3\2"+
		"\2\2\u0189\u0185\3\2\2\2\u018a\u0194\3\2\2\2\u018b\u018e\f\t\2\2\u018c"+
		"\u018f\5> \2\u018d\u018f\58\35\2\u018e\u018c\3\2\2\2\u018e\u018d\3\2\2"+
		"\2\u018f\u0190\3\2\2\2\u0190\u0191\5D#\n\u0191\u0193\3\2\2\2\u0192\u018b"+
		"\3\2\2\2\u0193\u0196\3\2\2\2\u0194\u0192\3\2\2\2\u0194\u0195\3\2\2\2\u0195"+
		"E\3\2\2\2\u0196\u0194\3\2\2\2\u0197\u0199\7\21\2\2\u0198\u0197\3\2\2\2"+
		"\u0198\u0199\3\2\2\2\u0199\u01b4\3\2\2\2\u019a\u019b\5<\37\2\u019b\u01a4"+
		"\7\7\2\2\u019c\u01a1\5J&\2\u019d\u019e\7\20\2\2\u019e\u01a0\5J&\2\u019f"+
		"\u019d\3\2\2\2\u01a0\u01a3\3\2\2\2\u01a1\u019f\3\2\2\2\u01a1\u01a2\3\2"+
		"\2\2\u01a2\u01a5\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a4\u019c\3\2\2\2\u01a4"+
		"\u01a5\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a7\7\b\2\2\u01a7\u01b0\3\2"+
		"\2\2\u01a8\u01ab\5J&\2\u01a9\u01ac\5> \2\u01aa\u01ac\58\35\2\u01ab\u01a9"+
		"\3\2\2\2\u01ab\u01aa\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01ae\5J&\2\u01ae"+
		"\u01b0\3\2\2\2\u01af\u019a\3\2\2\2\u01af\u01a8\3\2\2\2\u01b0\u01b5\3\2"+
		"\2\2\u01b1\u01b2\5:\36\2\u01b2\u01b3\5D#\2\u01b3\u01b5\3\2\2\2\u01b4\u01af"+
		"\3\2\2\2\u01b4\u01b1\3\2\2\2\u01b5G\3\2\2\2\u01b6\u01b7\5\66\34\2\u01b7"+
		"\u01c0\7\7\2\2\u01b8\u01bd\5J&\2\u01b9\u01ba\7\20\2\2\u01ba\u01bc\5J&"+
		"\2\u01bb\u01b9\3\2\2\2\u01bc\u01bf\3\2\2\2\u01bd\u01bb\3\2\2\2\u01bd\u01be"+
		"\3\2\2\2\u01be\u01c1\3\2\2\2\u01bf\u01bd\3\2\2\2\u01c0\u01b8\3\2\2\2\u01c0"+
		"\u01c1\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2\u01c3\7\b\2\2\u01c3\u01cf\3\2"+
		"\2\2\u01c4\u01c7\5J&\2\u01c5\u01c8\5> \2\u01c6\u01c8\58\35\2\u01c7\u01c5"+
		"\3\2\2\2\u01c7\u01c6\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01ca\5J&\2\u01ca"+
		"\u01cf\3\2\2\2\u01cb\u01cc\5:\36\2\u01cc\u01cd\5D#\2\u01cd\u01cf\3\2\2"+
		"\2\u01ce\u01b6\3\2\2\2\u01ce\u01c4\3\2\2\2\u01ce\u01cb\3\2\2\2\u01cfI"+
		"\3\2\2\2\u01d0\u01d3\b&\1\2\u01d1\u01d4\5<\37\2\u01d2\u01d4\5\66\34\2"+
		"\u01d3\u01d1\3\2\2\2\u01d3\u01d2\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01de"+
		"\7\7\2\2\u01d6\u01db\5J&\2\u01d7\u01d8\7\20\2\2\u01d8\u01da\5J&\2\u01d9"+
		"\u01d7\3\2\2\2\u01da\u01dd\3\2\2\2\u01db\u01d9\3\2\2\2\u01db\u01dc\3\2"+
		"\2\2\u01dc\u01df\3\2\2\2\u01dd\u01db\3\2\2\2\u01de\u01d6\3\2\2\2\u01de"+
		"\u01df\3\2\2\2\u01df\u01e0\3\2\2\2\u01e0\u01e1\7\b\2\2\u01e1\u01ec\3\2"+
		"\2\2\u01e2\u01e3\5:\36\2\u01e3\u01e4\5D#\2\u01e4\u01ec\3\2\2\2\u01e5\u01ec"+
		"\5\n\6\2\u01e6\u01ec\5\34\17\2\u01e7\u01e8\7\7\2\2\u01e8\u01e9\5J&\2\u01e9"+
		"\u01ea\7\b\2\2\u01ea\u01ec\3\2\2\2\u01eb\u01d0\3\2\2\2\u01eb\u01e2\3\2"+
		"\2\2\u01eb\u01e5\3\2\2\2\u01eb\u01e6\3\2\2\2\u01eb\u01e7\3\2\2\2\u01ec"+
		"\u01f6\3\2\2\2\u01ed\u01f0\f\7\2\2\u01ee\u01f1\5> \2\u01ef\u01f1\58\35"+
		"\2\u01f0\u01ee\3\2\2\2\u01f0\u01ef\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2\u01f3"+
		"\5J&\b\u01f3\u01f5\3\2\2\2\u01f4\u01ed\3\2\2\2\u01f5\u01f8\3\2\2\2\u01f6"+
		"\u01f4\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7K\3\2\2\2\u01f8\u01f6\3\2\2\2"+
		"\u01f9\u01fc\5\n\6\2\u01fa\u01fc\5\34\17\2\u01fb\u01f9\3\2\2\2\u01fb\u01fa"+
		"\3\2\2\2\u01fcM\3\2\2\2\u01fd\u01fe\5L\'\2\u01fe\u01ff\7\31\2\2\u01ff"+
		"\u0200\5H%\2\u0200O\3\2\2\2\u0201\u0202\5\22\n\2\u0202\u0203\7\31\2\2"+
		"\u0203\u0207\7\t\2\2\u0204\u0208\3\2\2\2\u0205\u0208\5\36\20\2\u0206\u0208"+
		"\5(\25\2\u0207\u0204\3\2\2\2\u0207\u0205\3\2\2\2\u0207\u0206\3\2\2\2\u0207"+
		"\u0208\3\2\2\2\u0208\u0209\3\2\2\2\u0209\u020a\7\n\2\2\u020aQ\3\2\2\2"+
		"\u020b\u020c\5<\37\2\u020c\u020d\7\7\2\2\u020d\u020e\5\"\22\2\u020e\u020f"+
		"\7\b\2\2\u020fS\3\2\2\2\u0210\u0211\7\33\2\2\u0211\u0212\5R*\2\u0212U"+
		"\3\2\2\2\u0213\u0216\5T+\2\u0214\u0216\5R*\2\u0215\u0213\3\2\2\2\u0215"+
		"\u0214\3\2\2\2\u0216W\3\2\2\2\u0217\u0218\5\22\n\2\u0218\u0219\5\66\34"+
		"\2\u0219\u021a\7\7\2\2\u021a\u021b\5\"\22\2\u021b\u021c\7\b\2\2\u021c"+
		"Y\3\2\2\2\u021d\u021e\b.\1\2\u021e\u021f\7\21\2\2\u021f\u022c\5Z.\t\u0220"+
		"\u022c\5@!\2\u0221\u022c\5B\"\2\u0222\u0223\7\13\2\2\u0223\u0224\5Z.\2"+
		"\u0224\u0225\7\f\2\2\u0225\u022c\3\2\2\2\u0226\u0227\7\7\2\2\u0227\u0228"+
		"\5Z.\2\u0228\u0229\7\b\2\2\u0229\u022c\3\2\2\2\u022a\u022c\5p9\2\u022b"+
		"\u021d\3\2\2\2\u022b\u0220\3\2\2\2\u022b\u0221\3\2\2\2\u022b\u0222\3\2"+
		"\2\2\u022b\u0226\3\2\2\2\u022b\u022a\3\2\2\2\u022c\u0242\3\2\2\2\u022d"+
		"\u022e\f\b\2\2\u022e\u022f\7\31\2\2\u022f\u0241\5Z.\t\u0230\u0231\f\7"+
		"\2\2\u0231\u0232\5*\26\2\u0232\u0233\5Z.\b\u0233\u0241\3\2\2\2\u0234\u0235"+
		"\f\6\2\2\u0235\u0236\5,\27\2\u0236\u0237\5Z.\7\u0237\u0241\3\2\2\2\u0238"+
		"\u0239\f\5\2\2\u0239\u023a\5.\30\2\u023a\u023b\5Z.\6\u023b\u0241\3\2\2"+
		"\2\u023c\u023d\f\4\2\2\u023d\u023e\5\60\31\2\u023e\u023f\5Z.\5\u023f\u0241"+
		"\3\2\2\2\u0240\u022d\3\2\2\2\u0240\u0230\3\2\2\2\u0240\u0234\3\2\2\2\u0240"+
		"\u0238\3\2\2\2\u0240\u023c\3\2\2\2\u0241\u0244\3\2\2\2\u0242\u0240\3\2"+
		"\2\2\u0242\u0243\3\2\2\2\u0243[\3\2\2\2\u0244\u0242\3\2\2\2\u0245\u0246"+
		"\t\3\2\2\u0246]\3\2\2\2\u0247\u0249\5n8\2\u0248\u024a\5\\/\2\u0249\u0248"+
		"\3\2\2\2\u0249\u024a\3\2\2\2\u024a_\3\2\2\2\u024b\u024f\7$\2\2\u024c\u024f"+
		"\7%\2\2\u024d\u024f\5\16\b\2\u024e\u024b\3\2\2\2\u024e\u024c\3\2\2\2\u024e"+
		"\u024d\3\2\2\2\u024fa\3\2\2\2\u0250\u0251\5`\61\2\u0251c\3\2\2\2\u0252"+
		"\u0253\5`\61\2\u0253e\3\2\2\2\u0254\u025c\5d\63\2\u0255\u0256\7\17\2\2"+
		"\u0256\u025c\5b\62\2\u0257\u0258\5d\63\2\u0258\u0259\7\17\2\2\u0259\u025a"+
		"\5b\62\2\u025a\u025c\3\2\2\2\u025b\u0254\3\2\2\2\u025b\u0255\3\2\2\2\u025b"+
		"\u0257\3\2\2\2\u025cg\3\2\2\2\u025d\u025e\5f\64\2\u025e\u025f\5Z.\2\u025f"+
		"i\3\2\2\2\u0260\u0261\5Z.\2\u0261\u0262\7\16\2\2\u0262k\3\2\2\2\u0263"+
		"\u0267\5Z.\2\u0264\u0267\5h\65\2\u0265\u0267\5j\66\2\u0266\u0263\3\2\2"+
		"\2\u0266\u0264\3\2\2\2\u0266\u0265\3\2\2\2\u0267m\3\2\2\2\u0268\u026a"+
		"\7\6\2\2\u0269\u0268\3\2\2\2\u026a\u026d\3\2\2\2\u026b\u0269\3\2\2\2\u026b"+
		"\u026c\3\2\2\2\u026c\u0270\3\2\2\2\u026d\u026b\3\2\2\2\u026e\u0271\5F"+
		"$\2\u026f\u0271\5N(\2\u0270\u026e\3\2\2\2\u0270\u026f\3\2\2\2\u0271\u0273"+
		"\3\2\2\2\u0272\u0274\7\6\2\2\u0273\u0272\3\2\2\2\u0273\u0274\3\2\2\2\u0274"+
		"o\3\2\2\2\u0275\u0276\5\62\32\2\u0276\u0277\5 \21\2\u0277\u0278\5Z.\2"+
		"\u0278\u0281\3\2\2\2\u0279\u027a\7\22\2\2\u027a\u027b\5 \21\2\u027b\u027c"+
		"\7\22\2\2\u027c\u027d\5Z.\2\u027d\u027e\t\7\2\2\u027e\u027f\5\32\16\2"+
		"\u027f\u0281\3\2\2\2\u0280\u0275\3\2\2\2\u0280\u0279\3\2\2\2\u0281q\3"+
		"\2\2\2Iu|\u0081\u0086\u008b\u0090\u0097\u009c\u00a3\u00a8\u00af\u00b4"+
		"\u00bb\u00c0\u00cf\u00d8\u00e2\u00e9\u00ee\u00f3\u00f7\u00ff\u0103\u0110"+
		"\u0115\u011b\u0122\u0129\u0130\u0148\u014b\u0153\u015c\u015f\u016a\u0172"+
		"\u017a\u017d\u0189\u018e\u0194\u0198\u01a1\u01a4\u01ab\u01af\u01b4\u01bd"+
		"\u01c0\u01c7\u01ce\u01d3\u01db\u01de\u01eb\u01f0\u01f6\u01fb\u0207\u0215"+
		"\u022b\u0240\u0242\u0249\u024e\u025b\u0266\u026b\u0270\u0273\u0280";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}