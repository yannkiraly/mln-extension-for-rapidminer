// Generated from alchemyMLNGrammar.g4 by ANTLR 4.2
package com.rapidminer.operator.modelling.converters.alchemy.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class alchemyMLNGrammarParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LINE_COMMENT=1, COMMENT=2, WS=3, NL=4, LP=5, RP=6, LCP=7, RCP=8, LSP=9, 
		RSP=10, DOTS=11, DOT=12, COL=13, COM=14, EXCL=15, AND=16, OR=17, IMPLIES=18, 
		IFF=19, U_QUANT=20, E_QUANT=21, EQ=22, PLUS=23, STAR=24, GT=25, LT=26, 
		GE=27, LE=28, NE=29, MINUS=30, SLASH=31, MOD=32, INT=33, FLOAT=34, VAR_ID=35, 
		CONST_ID=36, STRING=37;
	public static final String[] tokenNames = {
		"<INVALID>", "LINE_COMMENT", "COMMENT", "WS", "NL", "'('", "')'", "'{'", 
		"'}'", "'['", "']'", "'...'", "'.'", "':'", "','", "'!'", "'^'", "'v'", 
		"'=>'", "'<=>'", "U_QUANT", "E_QUANT", "'='", "'+'", "'*'", "'>'", "'<'", 
		"'>='", "'<='", "'!='", "'-'", "'/'", "'%'", "INT", "FLOAT", "VAR_ID", 
		"CONST_ID", "STRING"
	};
	public static final int
		RULE_ruleFile = 0, RULE_dbFile = 1, RULE_infFile = 2, RULE_constant = 3, 
		RULE_expVariable = 4, RULE_variable = 5, RULE_exclType = 6, RULE_type = 7, 
		RULE_startInt = 8, RULE_endInt = 9, RULE_doubleNL = 10, RULE_constantList = 11, 
		RULE_variableList = 12, RULE_typeList = 13, RULE_exIntList = 14, RULE_plainIntList = 15, 
		RULE_intList = 16, RULE_number = 17, RULE_and = 18, RULE_or = 19, RULE_implies = 20, 
		RULE_iff = 21, RULE_quantifier = 22, RULE_eq = 23, RULE_function = 24, 
		RULE_builtinFunctionSymbol = 25, RULE_builtinPrefixFunctionSymbol = 26, 
		RULE_predicate = 27, RULE_builtinPredicateSymbol = 28, RULE_predicateApplication = 29, 
		RULE_functionApplication = 30, RULE_argument = 31, RULE_groundPredicateApplication = 32, 
		RULE_groundFunctionApplication = 33, RULE_groundArgument = 34, RULE_returnValue = 35, 
		RULE_functionDef = 36, RULE_typeDecl = 37, RULE_predicateDecl = 38, RULE_functionDecl = 39, 
		RULE_plainFormula = 40, RULE_probability = 41, RULE_probabilityStatement = 42, 
		RULE_weight = 43, RULE_utilWeight = 44, RULE_probWeight = 45, RULE_weights = 46, 
		RULE_weightedFormula = 47, RULE_hardFormula = 48, RULE_formula = 49, RULE_groundFormula = 50;
	public static final String[] ruleNames = {
		"ruleFile", "dbFile", "infFile", "constant", "expVariable", "variable", 
		"exclType", "type", "startInt", "endInt", "doubleNL", "constantList", 
		"variableList", "typeList", "exIntList", "plainIntList", "intList", "number", 
		"and", "or", "implies", "iff", "quantifier", "eq", "function", "builtinFunctionSymbol", 
		"builtinPrefixFunctionSymbol", "predicate", "builtinPredicateSymbol", 
		"predicateApplication", "functionApplication", "argument", "groundPredicateApplication", 
		"groundFunctionApplication", "groundArgument", "returnValue", "functionDef", 
		"typeDecl", "predicateDecl", "functionDecl", "plainFormula", "probability", 
		"probabilityStatement", "weight", "utilWeight", "probWeight", "weights", 
		"weightedFormula", "hardFormula", "formula", "groundFormula"
	};

	@Override
	public String getGrammarFileName() { return "alchemyMLNGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public alchemyMLNGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RuleFileContext extends ParserRuleContext {
		public List<TerminalNode> NL() { return getTokens(alchemyMLNGrammarParser.NL); }
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
			return getToken(alchemyMLNGrammarParser.NL, i);
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
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterRuleFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitRuleFile(this);
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
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(102); match(NL);
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(119);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(116);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(108); typeDecl();
						{
						setState(110); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(109); match(NL);
							}
							}
							setState(112); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==NL );
						}
						}
						} 
					}
					setState(118);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				}
				}
				break;
			}
			setState(135);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(132);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(123);
						switch (_input.LA(1)) {
						case CONST_ID:
							{
							setState(121); predicateDecl();
							}
							break;
						case VAR_ID:
							{
							setState(122); functionDecl();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						{
						setState(126); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(125); match(NL);
							}
							}
							setState(128); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==NL );
						}
						}
						} 
					}
					setState(134);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				}
				}
				break;
			}
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << LSP) | (1L << COL) | (1L << EXCL) | (1L << U_QUANT) | (1L << E_QUANT) | (1L << PLUS) | (1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << VAR_ID) | (1L << CONST_ID) | (1L << STRING))) != 0)) {
				{
				{
				setState(137); formula();
				setState(139); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(138); match(NL);
					}
					}
					setState(141); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NL );
				}
				}
				setState(147);
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
		public List<TerminalNode> NL() { return getTokens(alchemyMLNGrammarParser.NL); }
		public GroundFormulaContext groundFormula(int i) {
			return getRuleContext(GroundFormulaContext.class,i);
		}
		public List<GroundFormulaContext> groundFormula() {
			return getRuleContexts(GroundFormulaContext.class);
		}
		public TerminalNode NL(int i) {
			return getToken(alchemyMLNGrammarParser.NL, i);
		}
		public DbFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dbFile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterDbFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitDbFile(this);
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
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NL) | (1L << LP) | (1L << EXCL) | (1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << CONST_ID) | (1L << STRING))) != 0)) {
				{
				{
				setState(148); groundFormula();
				setState(152);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(149); match(NL);
						}
						} 
					}
					setState(154);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				}
				}
				setState(159);
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
		public List<TerminalNode> NL() { return getTokens(alchemyMLNGrammarParser.NL); }
		public ProbabilityStatementContext probabilityStatement(int i) {
			return getRuleContext(ProbabilityStatementContext.class,i);
		}
		public TerminalNode NL(int i) {
			return getToken(alchemyMLNGrammarParser.NL, i);
		}
		public InfFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_infFile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterInfFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitInfFile(this);
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
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NL) | (1L << LP) | (1L << EXCL) | (1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << CONST_ID) | (1L << STRING))) != 0)) {
				{
				{
				setState(160); probabilityStatement();
				setState(164);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(161); match(NL);
						}
						} 
					}
					setState(166);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				}
				}
				}
				setState(171);
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

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(alchemyMLNGrammarParser.STRING, 0); }
		public TerminalNode CONST_ID() { return getToken(alchemyMLNGrammarParser.CONST_ID, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
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
		public TerminalNode PLUS() { return getToken(alchemyMLNGrammarParser.PLUS, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ExpVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterExpVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitExpVariable(this);
		}
	}

	public final ExpVariableContext expVariable() throws RecognitionException {
		ExpVariableContext _localctx = new ExpVariableContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174); match(PLUS);
			setState(175); variable();
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
		public TerminalNode VAR_ID() { return getToken(alchemyMLNGrammarParser.VAR_ID, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitVariable(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177); match(VAR_ID);
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
		public TerminalNode VAR_ID() { return getToken(alchemyMLNGrammarParser.VAR_ID, 0); }
		public TerminalNode EXCL() { return getToken(alchemyMLNGrammarParser.EXCL, 0); }
		public ExclTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exclType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterExclType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitExclType(this);
		}
	}

	public final ExclTypeContext exclType() throws RecognitionException {
		ExclTypeContext _localctx = new ExclTypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_exclType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179); match(VAR_ID);
			setState(180); match(EXCL);
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
		public TerminalNode VAR_ID() { return getToken(alchemyMLNGrammarParser.VAR_ID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		try {
			setState(184);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(182); match(VAR_ID);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(183); exclType();
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

	public static class StartIntContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(alchemyMLNGrammarParser.INT, 0); }
		public StartIntContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_startInt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterStartInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitStartInt(this);
		}
	}

	public final StartIntContext startInt() throws RecognitionException {
		StartIntContext _localctx = new StartIntContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_startInt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186); match(INT);
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

	public static class EndIntContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(alchemyMLNGrammarParser.INT, 0); }
		public EndIntContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endInt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterEndInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitEndInt(this);
		}
	}

	public final EndIntContext endInt() throws RecognitionException {
		EndIntContext _localctx = new EndIntContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_endInt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188); match(INT);
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
		public List<TerminalNode> NL() { return getTokens(alchemyMLNGrammarParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(alchemyMLNGrammarParser.NL, i);
		}
		public DoubleNLContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubleNL; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterDoubleNL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitDoubleNL(this);
		}
	}

	public final DoubleNLContext doubleNL() throws RecognitionException {
		DoubleNLContext _localctx = new DoubleNLContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_doubleNL);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(190); match(NL);
				}
				}
				setState(193); 
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

	public static class ConstantListContext extends ParserRuleContext {
		public List<TerminalNode> NL() { return getTokens(alchemyMLNGrammarParser.NL); }
		public List<ConstantContext> constant() {
			return getRuleContexts(ConstantContext.class);
		}
		public List<TerminalNode> COM() { return getTokens(alchemyMLNGrammarParser.COM); }
		public TerminalNode NL(int i) {
			return getToken(alchemyMLNGrammarParser.NL, i);
		}
		public TerminalNode COM(int i) {
			return getToken(alchemyMLNGrammarParser.COM, i);
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
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterConstantList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitConstantList(this);
		}
	}

	public final ConstantListContext constantList() throws RecognitionException {
		ConstantListContext _localctx = new ConstantListContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_constantList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195); constant();
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(196); match(NL);
				}
				}
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COM) {
				{
				{
				setState(202); match(COM);
				setState(203); constant();
				}
				}
				setState(208);
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
		public List<TerminalNode> COM() { return getTokens(alchemyMLNGrammarParser.COM); }
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
			return getToken(alchemyMLNGrammarParser.COM, i);
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
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterVariableList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitVariableList(this);
		}
	}

	public final VariableListContext variableList() throws RecognitionException {
		VariableListContext _localctx = new VariableListContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_variableList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			switch (_input.LA(1)) {
			case VAR_ID:
				{
				setState(209); variable();
				}
				break;
			case PLUS:
				{
				setState(210); expVariable();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COM) {
				{
				{
				setState(213); match(COM);
				setState(216);
				switch (_input.LA(1)) {
				case VAR_ID:
					{
					setState(214); variable();
					}
					break;
				case PLUS:
					{
					setState(215); expVariable();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(222);
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
		public List<TerminalNode> COM() { return getTokens(alchemyMLNGrammarParser.COM); }
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TerminalNode COM(int i) {
			return getToken(alchemyMLNGrammarParser.COM, i);
		}
		public TypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitTypeList(this);
		}
	}

	public final TypeListContext typeList() throws RecognitionException {
		TypeListContext _localctx = new TypeListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_typeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223); type();
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COM) {
				{
				{
				setState(224); match(COM);
				setState(225); type();
				}
				}
				setState(230);
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

	public static class ExIntListContext extends ParserRuleContext {
		public EndIntContext endInt() {
			return getRuleContext(EndIntContext.class,0);
		}
		public List<TerminalNode> COM() { return getTokens(alchemyMLNGrammarParser.COM); }
		public TerminalNode DOTS() { return getToken(alchemyMLNGrammarParser.DOTS, 0); }
		public TerminalNode COM(int i) {
			return getToken(alchemyMLNGrammarParser.COM, i);
		}
		public StartIntContext startInt() {
			return getRuleContext(StartIntContext.class,0);
		}
		public ExIntListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exIntList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterExIntList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitExIntList(this);
		}
	}

	public final ExIntListContext exIntList() throws RecognitionException {
		ExIntListContext _localctx = new ExIntListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_exIntList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231); startInt();
			setState(232); match(COM);
			setState(233); match(DOTS);
			setState(234); match(COM);
			setState(235); endInt();
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

	public static class PlainIntListContext extends ParserRuleContext {
		public TerminalNode INT(int i) {
			return getToken(alchemyMLNGrammarParser.INT, i);
		}
		public List<TerminalNode> COM() { return getTokens(alchemyMLNGrammarParser.COM); }
		public TerminalNode COM(int i) {
			return getToken(alchemyMLNGrammarParser.COM, i);
		}
		public List<TerminalNode> INT() { return getTokens(alchemyMLNGrammarParser.INT); }
		public PlainIntListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plainIntList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterPlainIntList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitPlainIntList(this);
		}
	}

	public final PlainIntListContext plainIntList() throws RecognitionException {
		PlainIntListContext _localctx = new PlainIntListContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_plainIntList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237); match(INT);
			setState(242);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COM) {
				{
				{
				setState(238); match(COM);
				setState(239); match(INT);
				}
				}
				setState(244);
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

	public static class IntListContext extends ParserRuleContext {
		public ExIntListContext exIntList() {
			return getRuleContext(ExIntListContext.class,0);
		}
		public PlainIntListContext plainIntList() {
			return getRuleContext(PlainIntListContext.class,0);
		}
		public IntListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterIntList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitIntList(this);
		}
	}

	public final IntListContext intList() throws RecognitionException {
		IntListContext _localctx = new IntListContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_intList);
		try {
			setState(247);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(245); exIntList();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(246); plainIntList();
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

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(alchemyMLNGrammarParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(alchemyMLNGrammarParser.FLOAT, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitNumber(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
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

	public static class AndContext extends ParserRuleContext {
		public List<TerminalNode> NL() { return getTokens(alchemyMLNGrammarParser.NL); }
		public TerminalNode AND() { return getToken(alchemyMLNGrammarParser.AND, 0); }
		public TerminalNode NL(int i) {
			return getToken(alchemyMLNGrammarParser.NL, i);
		}
		public AndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitAnd(this);
		}
	}

	public final AndContext and() throws RecognitionException {
		AndContext _localctx = new AndContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_and);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251); match(AND);
			setState(255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(252); match(NL);
				}
				}
				setState(257);
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
		public List<TerminalNode> NL() { return getTokens(alchemyMLNGrammarParser.NL); }
		public TerminalNode OR() { return getToken(alchemyMLNGrammarParser.OR, 0); }
		public TerminalNode NL(int i) {
			return getToken(alchemyMLNGrammarParser.NL, i);
		}
		public OrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitOr(this);
		}
	}

	public final OrContext or() throws RecognitionException {
		OrContext _localctx = new OrContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_or);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258); match(OR);
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(259); match(NL);
				}
				}
				setState(264);
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
		public List<TerminalNode> NL() { return getTokens(alchemyMLNGrammarParser.NL); }
		public TerminalNode IMPLIES() { return getToken(alchemyMLNGrammarParser.IMPLIES, 0); }
		public TerminalNode NL(int i) {
			return getToken(alchemyMLNGrammarParser.NL, i);
		}
		public ImpliesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_implies; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterImplies(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitImplies(this);
		}
	}

	public final ImpliesContext implies() throws RecognitionException {
		ImpliesContext _localctx = new ImpliesContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_implies);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265); match(IMPLIES);
			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(266); match(NL);
				}
				}
				setState(271);
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
		public List<TerminalNode> NL() { return getTokens(alchemyMLNGrammarParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(alchemyMLNGrammarParser.NL, i);
		}
		public TerminalNode IFF() { return getToken(alchemyMLNGrammarParser.IFF, 0); }
		public IffContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iff; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterIff(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitIff(this);
		}
	}

	public final IffContext iff() throws RecognitionException {
		IffContext _localctx = new IffContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_iff);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272); match(IFF);
			setState(276);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(273); match(NL);
				}
				}
				setState(278);
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
		public TerminalNode U_QUANT() { return getToken(alchemyMLNGrammarParser.U_QUANT, 0); }
		public TerminalNode E_QUANT() { return getToken(alchemyMLNGrammarParser.E_QUANT, 0); }
		public QuantifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterQuantifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitQuantifier(this);
		}
	}

	public final QuantifierContext quantifier() throws RecognitionException {
		QuantifierContext _localctx = new QuantifierContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_quantifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
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
		public TerminalNode EQ() { return getToken(alchemyMLNGrammarParser.EQ, 0); }
		public EqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitEq(this);
		}
	}

	public final EqContext eq() throws RecognitionException {
		EqContext _localctx = new EqContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_eq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281); match(EQ);
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
		public TerminalNode CONST_ID() { return getToken(alchemyMLNGrammarParser.CONST_ID, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283); match(CONST_ID);
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
		public TerminalNode SLASH() { return getToken(alchemyMLNGrammarParser.SLASH, 0); }
		public TerminalNode AND() { return getToken(alchemyMLNGrammarParser.AND, 0); }
		public TerminalNode PLUS() { return getToken(alchemyMLNGrammarParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(alchemyMLNGrammarParser.MINUS, 0); }
		public TerminalNode STAR() { return getToken(alchemyMLNGrammarParser.STAR, 0); }
		public TerminalNode MOD() { return getToken(alchemyMLNGrammarParser.MOD, 0); }
		public BuiltinFunctionSymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtinFunctionSymbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterBuiltinFunctionSymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitBuiltinFunctionSymbol(this);
		}
	}

	public final BuiltinFunctionSymbolContext builtinFunctionSymbol() throws RecognitionException {
		BuiltinFunctionSymbolContext _localctx = new BuiltinFunctionSymbolContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_builtinFunctionSymbol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
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
		public TerminalNode MINUS() { return getToken(alchemyMLNGrammarParser.MINUS, 0); }
		public BuiltinPrefixFunctionSymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtinPrefixFunctionSymbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterBuiltinPrefixFunctionSymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitBuiltinPrefixFunctionSymbol(this);
		}
	}

	public final BuiltinPrefixFunctionSymbolContext builtinPrefixFunctionSymbol() throws RecognitionException {
		BuiltinPrefixFunctionSymbolContext _localctx = new BuiltinPrefixFunctionSymbolContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_builtinPrefixFunctionSymbol);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287); match(MINUS);
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
		public TerminalNode CONST_ID() { return getToken(alchemyMLNGrammarParser.CONST_ID, 0); }
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitPredicate(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289); match(CONST_ID);
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
		public TerminalNode GE() { return getToken(alchemyMLNGrammarParser.GE, 0); }
		public TerminalNode LT() { return getToken(alchemyMLNGrammarParser.LT, 0); }
		public TerminalNode GT() { return getToken(alchemyMLNGrammarParser.GT, 0); }
		public TerminalNode LE() { return getToken(alchemyMLNGrammarParser.LE, 0); }
		public TerminalNode EQ() { return getToken(alchemyMLNGrammarParser.EQ, 0); }
		public TerminalNode NE() { return getToken(alchemyMLNGrammarParser.NE, 0); }
		public BuiltinPredicateSymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtinPredicateSymbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterBuiltinPredicateSymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitBuiltinPredicateSymbol(this);
		}
	}

	public final BuiltinPredicateSymbolContext builtinPredicateSymbol() throws RecognitionException {
		BuiltinPredicateSymbolContext _localctx = new BuiltinPredicateSymbolContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_builtinPredicateSymbol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
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
		public TerminalNode RP() { return getToken(alchemyMLNGrammarParser.RP, 0); }
		public BuiltinPredicateSymbolContext builtinPredicateSymbol() {
			return getRuleContext(BuiltinPredicateSymbolContext.class,0);
		}
		public List<TerminalNode> COM() { return getTokens(alchemyMLNGrammarParser.COM); }
		public TerminalNode LP() { return getToken(alchemyMLNGrammarParser.LP, 0); }
		public TerminalNode COM(int i) {
			return getToken(alchemyMLNGrammarParser.COM, i);
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
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterPredicateApplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitPredicateApplication(this);
		}
	}

	public final PredicateApplicationContext predicateApplication() throws RecognitionException {
		PredicateApplicationContext _localctx = new PredicateApplicationContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_predicateApplication);
		int _la;
		try {
			setState(311);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(293); predicate();
				setState(294); match(LP);
				setState(303);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << PLUS) | (1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << VAR_ID) | (1L << CONST_ID) | (1L << STRING))) != 0)) {
					{
					setState(295); argument(0);
					setState(300);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COM) {
						{
						{
						setState(296); match(COM);
						setState(297); argument(0);
						}
						}
						setState(302);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(305); match(RP);
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(307); argument(0);
				setState(308); builtinPredicateSymbol();
				setState(309); argument(0);
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
		public TerminalNode RP() { return getToken(alchemyMLNGrammarParser.RP, 0); }
		public BuiltinPrefixFunctionSymbolContext builtinPrefixFunctionSymbol() {
			return getRuleContext(BuiltinPrefixFunctionSymbolContext.class,0);
		}
		public List<TerminalNode> COM() { return getTokens(alchemyMLNGrammarParser.COM); }
		public TerminalNode LP() { return getToken(alchemyMLNGrammarParser.LP, 0); }
		public TerminalNode COM(int i) {
			return getToken(alchemyMLNGrammarParser.COM, i);
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
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterFunctionApplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitFunctionApplication(this);
		}
	}

	public final FunctionApplicationContext functionApplication() throws RecognitionException {
		FunctionApplicationContext _localctx = new FunctionApplicationContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_functionApplication);
		int _la;
		try {
			setState(334);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(313); function();
				setState(314); match(LP);
				setState(323);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << PLUS) | (1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << VAR_ID) | (1L << CONST_ID) | (1L << STRING))) != 0)) {
					{
					setState(315); argument(0);
					setState(320);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COM) {
						{
						{
						setState(316); match(COM);
						setState(317); argument(0);
						}
						}
						setState(322);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(325); match(RP);
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(327); argument(0);
				setState(328); builtinFunctionSymbol();
				setState(329); argument(0);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(331); builtinPrefixFunctionSymbol();
				setState(332); argument(0);
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
		public TerminalNode RP() { return getToken(alchemyMLNGrammarParser.RP, 0); }
		public List<TerminalNode> COM() { return getTokens(alchemyMLNGrammarParser.COM); }
		public ExpVariableContext expVariable() {
			return getRuleContext(ExpVariableContext.class,0);
		}
		public TerminalNode COM(int i) {
			return getToken(alchemyMLNGrammarParser.COM, i);
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
		public TerminalNode LP() { return getToken(alchemyMLNGrammarParser.LP, 0); }
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
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitArgument(this);
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
		int _startState = 62;
		enterRecursionRule(_localctx, 62, RULE_argument, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(337); builtinPrefixFunctionSymbol();
				setState(338); argument(6);
				}
				break;

			case 2:
				{
				{
				setState(342);
				switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
				case 1:
					{
					setState(340); predicate();
					}
					break;

				case 2:
					{
					setState(341); function();
					}
					break;
				}
				setState(344); match(LP);
				setState(353);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << PLUS) | (1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << VAR_ID) | (1L << CONST_ID) | (1L << STRING))) != 0)) {
					{
					setState(345); argument(0);
					setState(350);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COM) {
						{
						{
						setState(346); match(COM);
						setState(347); argument(0);
						}
						}
						setState(352);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(355); match(RP);
				}
				}
				break;

			case 3:
				{
				setState(357); variable();
				}
				break;

			case 4:
				{
				setState(358); expVariable();
				}
				break;

			case 5:
				{
				setState(359); constant();
				}
				break;

			case 6:
				{
				setState(360); number();
				}
				break;

			case 7:
				{
				setState(361); match(LP);
				setState(362); argument(0);
				setState(363); match(RP);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(376);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArgumentContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_argument);
					setState(367);
					if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
					setState(370);
					switch (_input.LA(1)) {
					case EQ:
					case GT:
					case LT:
					case GE:
					case LE:
					case NE:
						{
						setState(368); builtinPredicateSymbol();
						}
						break;
					case AND:
					case PLUS:
					case STAR:
					case MINUS:
					case SLASH:
					case MOD:
						{
						setState(369); builtinFunctionSymbol();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(372); argument(8);
					}
					} 
				}
				setState(378);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
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
		public TerminalNode RP() { return getToken(alchemyMLNGrammarParser.RP, 0); }
		public BuiltinPrefixFunctionSymbolContext builtinPrefixFunctionSymbol() {
			return getRuleContext(BuiltinPrefixFunctionSymbolContext.class,0);
		}
		public GroundArgumentContext groundArgument(int i) {
			return getRuleContext(GroundArgumentContext.class,i);
		}
		public BuiltinPredicateSymbolContext builtinPredicateSymbol() {
			return getRuleContext(BuiltinPredicateSymbolContext.class,0);
		}
		public List<TerminalNode> COM() { return getTokens(alchemyMLNGrammarParser.COM); }
		public TerminalNode LP() { return getToken(alchemyMLNGrammarParser.LP, 0); }
		public TerminalNode EXCL() { return getToken(alchemyMLNGrammarParser.EXCL, 0); }
		public List<GroundArgumentContext> groundArgument() {
			return getRuleContexts(GroundArgumentContext.class);
		}
		public BuiltinFunctionSymbolContext builtinFunctionSymbol() {
			return getRuleContext(BuiltinFunctionSymbolContext.class,0);
		}
		public TerminalNode COM(int i) {
			return getToken(alchemyMLNGrammarParser.COM, i);
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
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterGroundPredicateApplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitGroundPredicateApplication(this);
		}
	}

	public final GroundPredicateApplicationContext groundPredicateApplication() throws RecognitionException {
		GroundPredicateApplicationContext _localctx = new GroundPredicateApplicationContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_groundPredicateApplication);
		int _la;
		try {
			setState(408);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(380);
				_la = _input.LA(1);
				if (_la==EXCL) {
					{
					setState(379); match(EXCL);
					}
				}

				setState(403);
				switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
				case 1:
					{
					{
					setState(382); predicate();
					setState(383); match(LP);
					setState(392);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << CONST_ID) | (1L << STRING))) != 0)) {
						{
						setState(384); groundArgument(0);
						setState(389);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COM) {
							{
							{
							setState(385); match(COM);
							setState(386); groundArgument(0);
							}
							}
							setState(391);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(394); match(RP);
					}
					}
					break;

				case 2:
					{
					setState(396); groundArgument(0);
					setState(399);
					switch (_input.LA(1)) {
					case EQ:
					case GT:
					case LT:
					case GE:
					case LE:
					case NE:
						{
						setState(397); builtinPredicateSymbol();
						}
						break;
					case AND:
					case PLUS:
					case STAR:
					case MINUS:
					case SLASH:
					case MOD:
						{
						setState(398); builtinFunctionSymbol();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(401); groundArgument(0);
					}
					break;
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(405); builtinPrefixFunctionSymbol();
				setState(406); argument(0);
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

	public static class GroundFunctionApplicationContext extends ParserRuleContext {
		public TerminalNode RP() { return getToken(alchemyMLNGrammarParser.RP, 0); }
		public BuiltinPrefixFunctionSymbolContext builtinPrefixFunctionSymbol() {
			return getRuleContext(BuiltinPrefixFunctionSymbolContext.class,0);
		}
		public GroundArgumentContext groundArgument(int i) {
			return getRuleContext(GroundArgumentContext.class,i);
		}
		public BuiltinPredicateSymbolContext builtinPredicateSymbol() {
			return getRuleContext(BuiltinPredicateSymbolContext.class,0);
		}
		public List<TerminalNode> COM() { return getTokens(alchemyMLNGrammarParser.COM); }
		public TerminalNode LP() { return getToken(alchemyMLNGrammarParser.LP, 0); }
		public List<GroundArgumentContext> groundArgument() {
			return getRuleContexts(GroundArgumentContext.class);
		}
		public TerminalNode COM(int i) {
			return getToken(alchemyMLNGrammarParser.COM, i);
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
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterGroundFunctionApplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitGroundFunctionApplication(this);
		}
	}

	public final GroundFunctionApplicationContext groundFunctionApplication() throws RecognitionException {
		GroundFunctionApplicationContext _localctx = new GroundFunctionApplicationContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_groundFunctionApplication);
		int _la;
		try {
			setState(434);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(410); function();
				setState(411); match(LP);
				setState(420);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << CONST_ID) | (1L << STRING))) != 0)) {
					{
					setState(412); groundArgument(0);
					setState(417);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COM) {
						{
						{
						setState(413); match(COM);
						setState(414); groundArgument(0);
						}
						}
						setState(419);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(422); match(RP);
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(424); groundArgument(0);
				setState(427);
				switch (_input.LA(1)) {
				case EQ:
				case GT:
				case LT:
				case GE:
				case LE:
				case NE:
					{
					setState(425); builtinPredicateSymbol();
					}
					break;
				case AND:
				case PLUS:
				case STAR:
				case MINUS:
				case SLASH:
				case MOD:
					{
					setState(426); builtinFunctionSymbol();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(429); groundArgument(0);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(431); builtinPrefixFunctionSymbol();
				setState(432); argument(0);
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
		public TerminalNode RP() { return getToken(alchemyMLNGrammarParser.RP, 0); }
		public BuiltinPrefixFunctionSymbolContext builtinPrefixFunctionSymbol() {
			return getRuleContext(BuiltinPrefixFunctionSymbolContext.class,0);
		}
		public GroundArgumentContext groundArgument(int i) {
			return getRuleContext(GroundArgumentContext.class,i);
		}
		public List<TerminalNode> COM() { return getTokens(alchemyMLNGrammarParser.COM); }
		public List<GroundArgumentContext> groundArgument() {
			return getRuleContexts(GroundArgumentContext.class);
		}
		public TerminalNode COM(int i) {
			return getToken(alchemyMLNGrammarParser.COM, i);
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
		public TerminalNode LP() { return getToken(alchemyMLNGrammarParser.LP, 0); }
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
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterGroundArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitGroundArgument(this);
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
		int _startState = 68;
		enterRecursionRule(_localctx, 68, RULE_groundArgument, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(463);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				{
				{
				setState(439);
				switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
				case 1:
					{
					setState(437); predicate();
					}
					break;

				case 2:
					{
					setState(438); function();
					}
					break;
				}
				setState(441); match(LP);
				setState(450);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << CONST_ID) | (1L << STRING))) != 0)) {
					{
					setState(442); groundArgument(0);
					setState(447);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COM) {
						{
						{
						setState(443); match(COM);
						setState(444); groundArgument(0);
						}
						}
						setState(449);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(452); match(RP);
				}
				}
				break;

			case 2:
				{
				setState(454); builtinPrefixFunctionSymbol();
				setState(455); argument(0);
				}
				break;

			case 3:
				{
				setState(457); constant();
				}
				break;

			case 4:
				{
				setState(458); number();
				}
				break;

			case 5:
				{
				setState(459); match(LP);
				setState(460); groundArgument(0);
				setState(461); match(RP);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(474);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new GroundArgumentContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_groundArgument);
					setState(465);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(468);
					switch (_input.LA(1)) {
					case EQ:
					case GT:
					case LT:
					case GE:
					case LE:
					case NE:
						{
						setState(466); builtinPredicateSymbol();
						}
						break;
					case AND:
					case PLUS:
					case STAR:
					case MINUS:
					case SLASH:
					case MOD:
						{
						setState(467); builtinFunctionSymbol();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(470); groundArgument(6);
					}
					} 
				}
				setState(476);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
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
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterReturnValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitReturnValue(this);
		}
	}

	public final ReturnValueContext returnValue() throws RecognitionException {
		ReturnValueContext _localctx = new ReturnValueContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_returnValue);
		try {
			setState(479);
			switch (_input.LA(1)) {
			case CONST_ID:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(477); constant();
				}
				break;
			case INT:
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(478); number();
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
		public TerminalNode EQ() { return getToken(alchemyMLNGrammarParser.EQ, 0); }
		public FunctionDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterFunctionDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitFunctionDef(this);
		}
	}

	public final FunctionDefContext functionDef() throws RecognitionException {
		FunctionDefContext _localctx = new FunctionDefContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_functionDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(481); returnValue();
			setState(482); match(EQ);
			setState(483); groundFunctionApplication();
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
		public TerminalNode RCP() { return getToken(alchemyMLNGrammarParser.RCP, 0); }
		public ConstantListContext constantList() {
			return getRuleContext(ConstantListContext.class,0);
		}
		public TerminalNode LCP() { return getToken(alchemyMLNGrammarParser.LCP, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode EQ() { return getToken(alchemyMLNGrammarParser.EQ, 0); }
		public IntListContext intList() {
			return getRuleContext(IntListContext.class,0);
		}
		public TypeDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterTypeDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitTypeDecl(this);
		}
	}

	public final TypeDeclContext typeDecl() throws RecognitionException {
		TypeDeclContext _localctx = new TypeDeclContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_typeDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(485); type();
			setState(486); match(EQ);
			setState(487); match(LCP);
			setState(490);
			switch (_input.LA(1)) {
			case CONST_ID:
			case STRING:
				{
				setState(488); constantList();
				}
				break;
			case INT:
				{
				setState(489); intList();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(492); match(RCP);
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
		public TerminalNode RP() { return getToken(alchemyMLNGrammarParser.RP, 0); }
		public TerminalNode LP() { return getToken(alchemyMLNGrammarParser.LP, 0); }
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public PredicateDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterPredicateDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitPredicateDecl(this);
		}
	}

	public final PredicateDeclContext predicateDecl() throws RecognitionException {
		PredicateDeclContext _localctx = new PredicateDeclContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_predicateDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(494); predicate();
			setState(495); match(LP);
			setState(496); typeList();
			setState(497); match(RP);
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
		public TerminalNode RP() { return getToken(alchemyMLNGrammarParser.RP, 0); }
		public TerminalNode LP() { return getToken(alchemyMLNGrammarParser.LP, 0); }
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
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterFunctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitFunctionDecl(this);
		}
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_functionDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(499); type();
			setState(500); function();
			setState(501); match(LP);
			setState(502); typeList();
			setState(503); match(RP);
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
		public TerminalNode RP() { return getToken(alchemyMLNGrammarParser.RP, 0); }
		public ImpliesContext implies() {
			return getRuleContext(ImpliesContext.class,0);
		}
		public OrContext or() {
			return getRuleContext(OrContext.class,0);
		}
		public List<PlainFormulaContext> plainFormula() {
			return getRuleContexts(PlainFormulaContext.class);
		}
		public TerminalNode LSP() { return getToken(alchemyMLNGrammarParser.LSP, 0); }
		public FunctionApplicationContext functionApplication() {
			return getRuleContext(FunctionApplicationContext.class,0);
		}
		public TerminalNode LP() { return getToken(alchemyMLNGrammarParser.LP, 0); }
		public TerminalNode RSP() { return getToken(alchemyMLNGrammarParser.RSP, 0); }
		public IffContext iff() {
			return getRuleContext(IffContext.class,0);
		}
		public TerminalNode EXCL() { return getToken(alchemyMLNGrammarParser.EXCL, 0); }
		public QuantifierContext quantifier() {
			return getRuleContext(QuantifierContext.class,0);
		}
		public VariableListContext variableList() {
			return getRuleContext(VariableListContext.class,0);
		}
		public TerminalNode EQ() { return getToken(alchemyMLNGrammarParser.EQ, 0); }
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
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterPlainFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitPlainFormula(this);
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
		int _startState = 80;
		enterRecursionRule(_localctx, 80, RULE_plainFormula, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(522);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				{
				setState(506); match(EXCL);
				setState(507); plainFormula(7);
				}
				break;

			case 2:
				{
				setState(508); quantifier();
				setState(509); variableList();
				setState(510); plainFormula(1);
				}
				break;

			case 3:
				{
				setState(512); predicateApplication();
				}
				break;

			case 4:
				{
				setState(513); functionApplication();
				}
				break;

			case 5:
				{
				setState(514); match(LSP);
				setState(515); plainFormula(0);
				setState(516); match(RSP);
				}
				break;

			case 6:
				{
				setState(518); match(LP);
				setState(519); plainFormula(0);
				setState(520); match(RP);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(545);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(543);
					switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
					case 1:
						{
						_localctx = new PlainFormulaContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_plainFormula);
						setState(524);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(525); match(EQ);
						setState(526); plainFormula(7);
						}
						break;

					case 2:
						{
						_localctx = new PlainFormulaContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_plainFormula);
						setState(527);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(528); and();
						setState(529); plainFormula(6);
						}
						break;

					case 3:
						{
						_localctx = new PlainFormulaContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_plainFormula);
						setState(531);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(532); or();
						setState(533); plainFormula(5);
						}
						break;

					case 4:
						{
						_localctx = new PlainFormulaContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_plainFormula);
						setState(535);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(536); implies();
						setState(537); plainFormula(4);
						}
						break;

					case 5:
						{
						_localctx = new PlainFormulaContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_plainFormula);
						setState(539);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(540); iff();
						setState(541); plainFormula(3);
						}
						break;
					}
					} 
				}
				setState(547);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
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
		public TerminalNode INT() { return getToken(alchemyMLNGrammarParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(alchemyMLNGrammarParser.FLOAT, 0); }
		public ProbabilityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_probability; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterProbability(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitProbability(this);
		}
	}

	public final ProbabilityContext probability() throws RecognitionException {
		ProbabilityContext _localctx = new ProbabilityContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_probability);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(548);
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
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterProbabilityStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitProbabilityStatement(this);
		}
	}

	public final ProbabilityStatementContext probabilityStatement() throws RecognitionException {
		ProbabilityStatementContext _localctx = new ProbabilityStatementContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_probabilityStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550); groundFormula();
			setState(552);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				{
				setState(551); probability();
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
		public TerminalNode INT() { return getToken(alchemyMLNGrammarParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(alchemyMLNGrammarParser.FLOAT, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public WeightContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_weight; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterWeight(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitWeight(this);
		}
	}

	public final WeightContext weight() throws RecognitionException {
		WeightContext _localctx = new WeightContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_weight);
		try {
			setState(557);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(554); match(INT);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(555); match(FLOAT);
				}
				break;
			case VAR_ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(556); variable();
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
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterUtilWeight(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitUtilWeight(this);
		}
	}

	public final UtilWeightContext utilWeight() throws RecognitionException {
		UtilWeightContext _localctx = new UtilWeightContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_utilWeight);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(559); weight();
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
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterProbWeight(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitProbWeight(this);
		}
	}

	public final ProbWeightContext probWeight() throws RecognitionException {
		ProbWeightContext _localctx = new ProbWeightContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_probWeight);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(561); weight();
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
		public TerminalNode COL() { return getToken(alchemyMLNGrammarParser.COL, 0); }
		public WeightsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_weights; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterWeights(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitWeights(this);
		}
	}

	public final WeightsContext weights() throws RecognitionException {
		WeightsContext _localctx = new WeightsContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_weights);
		try {
			setState(570);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(563); probWeight();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(564); match(COL);
				setState(565); utilWeight();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(566); probWeight();
				setState(567); match(COL);
				setState(568); utilWeight();
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
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterWeightedFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitWeightedFormula(this);
		}
	}

	public final WeightedFormulaContext weightedFormula() throws RecognitionException {
		WeightedFormulaContext _localctx = new WeightedFormulaContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_weightedFormula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(572); weights();
			setState(573); plainFormula(0);
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
		public TerminalNode DOT() { return getToken(alchemyMLNGrammarParser.DOT, 0); }
		public PlainFormulaContext plainFormula() {
			return getRuleContext(PlainFormulaContext.class,0);
		}
		public HardFormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hardFormula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterHardFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitHardFormula(this);
		}
	}

	public final HardFormulaContext hardFormula() throws RecognitionException {
		HardFormulaContext _localctx = new HardFormulaContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_hardFormula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(575); plainFormula(0);
			setState(576); match(DOT);
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
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitFormula(this);
		}
	}

	public final FormulaContext formula() throws RecognitionException {
		FormulaContext _localctx = new FormulaContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_formula);
		try {
			setState(581);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(578); plainFormula(0);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(579); weightedFormula();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(580); hardFormula();
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
		public List<TerminalNode> NL() { return getTokens(alchemyMLNGrammarParser.NL); }
		public FunctionDefContext functionDef() {
			return getRuleContext(FunctionDefContext.class,0);
		}
		public GroundPredicateApplicationContext groundPredicateApplication() {
			return getRuleContext(GroundPredicateApplicationContext.class,0);
		}
		public TerminalNode NL(int i) {
			return getToken(alchemyMLNGrammarParser.NL, i);
		}
		public GroundFormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groundFormula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).enterGroundFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof alchemyMLNGrammarListener ) ((alchemyMLNGrammarListener)listener).exitGroundFormula(this);
		}
	}

	public final GroundFormulaContext groundFormula() throws RecognitionException {
		GroundFormulaContext _localctx = new GroundFormulaContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_groundFormula);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(586);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(583); match(NL);
				}
				}
				setState(588);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(591);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				{
				setState(589); groundPredicateApplication();
				}
				break;

			case 2:
				{
				setState(590); functionDef();
				}
				break;
			}
			setState(594);
			switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
			case 1:
				{
				setState(593); match(NL);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 31: return argument_sempred((ArgumentContext)_localctx, predIndex);

		case 34: return groundArgument_sempred((GroundArgumentContext)_localctx, predIndex);

		case 40: return plainFormula_sempred((PlainFormulaContext)_localctx, predIndex);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\'\u0257\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\3\2\7\2j\n\2\f\2\16\2m\13\2\3\2\3\2\6\2q\n\2\r\2\16\2r\7\2u\n\2\f"+
		"\2\16\2x\13\2\5\2z\n\2\3\2\3\2\5\2~\n\2\3\2\6\2\u0081\n\2\r\2\16\2\u0082"+
		"\7\2\u0085\n\2\f\2\16\2\u0088\13\2\5\2\u008a\n\2\3\2\3\2\6\2\u008e\n\2"+
		"\r\2\16\2\u008f\7\2\u0092\n\2\f\2\16\2\u0095\13\2\3\3\3\3\7\3\u0099\n"+
		"\3\f\3\16\3\u009c\13\3\7\3\u009e\n\3\f\3\16\3\u00a1\13\3\3\4\3\4\7\4\u00a5"+
		"\n\4\f\4\16\4\u00a8\13\4\7\4\u00aa\n\4\f\4\16\4\u00ad\13\4\3\5\3\5\3\6"+
		"\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\5\t\u00bb\n\t\3\n\3\n\3\13\3\13\3"+
		"\f\6\f\u00c2\n\f\r\f\16\f\u00c3\3\r\3\r\7\r\u00c8\n\r\f\r\16\r\u00cb\13"+
		"\r\3\r\3\r\7\r\u00cf\n\r\f\r\16\r\u00d2\13\r\3\16\3\16\5\16\u00d6\n\16"+
		"\3\16\3\16\3\16\5\16\u00db\n\16\7\16\u00dd\n\16\f\16\16\16\u00e0\13\16"+
		"\3\17\3\17\3\17\7\17\u00e5\n\17\f\17\16\17\u00e8\13\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\7\21\u00f3\n\21\f\21\16\21\u00f6\13\21"+
		"\3\22\3\22\5\22\u00fa\n\22\3\23\3\23\3\24\3\24\7\24\u0100\n\24\f\24\16"+
		"\24\u0103\13\24\3\25\3\25\7\25\u0107\n\25\f\25\16\25\u010a\13\25\3\26"+
		"\3\26\7\26\u010e\n\26\f\26\16\26\u0111\13\26\3\27\3\27\7\27\u0115\n\27"+
		"\f\27\16\27\u0118\13\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3"+
		"\34\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3\37\3\37\7\37\u012d\n\37\f\37"+
		"\16\37\u0130\13\37\5\37\u0132\n\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37"+
		"\u013a\n\37\3 \3 \3 \3 \3 \7 \u0141\n \f \16 \u0144\13 \5 \u0146\n \3"+
		" \3 \3 \3 \3 \3 \3 \3 \3 \5 \u0151\n \3!\3!\3!\3!\3!\3!\5!\u0159\n!\3"+
		"!\3!\3!\3!\7!\u015f\n!\f!\16!\u0162\13!\5!\u0164\n!\3!\3!\3!\3!\3!\3!"+
		"\3!\3!\3!\3!\5!\u0170\n!\3!\3!\3!\5!\u0175\n!\3!\3!\7!\u0179\n!\f!\16"+
		"!\u017c\13!\3\"\5\"\u017f\n\"\3\"\3\"\3\"\3\"\3\"\7\"\u0186\n\"\f\"\16"+
		"\"\u0189\13\"\5\"\u018b\n\"\3\"\3\"\3\"\3\"\3\"\5\"\u0192\n\"\3\"\3\""+
		"\5\"\u0196\n\"\3\"\3\"\3\"\5\"\u019b\n\"\3#\3#\3#\3#\3#\7#\u01a2\n#\f"+
		"#\16#\u01a5\13#\5#\u01a7\n#\3#\3#\3#\3#\3#\5#\u01ae\n#\3#\3#\3#\3#\3#"+
		"\5#\u01b5\n#\3$\3$\3$\5$\u01ba\n$\3$\3$\3$\3$\7$\u01c0\n$\f$\16$\u01c3"+
		"\13$\5$\u01c5\n$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\5$\u01d2\n$\3$\3$\3"+
		"$\5$\u01d7\n$\3$\3$\7$\u01db\n$\f$\16$\u01de\13$\3%\3%\5%\u01e2\n%\3&"+
		"\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\5\'\u01ed\n\'\3\'\3\'\3(\3(\3(\3(\3(\3)"+
		"\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\5*"+
		"\u020d\n*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\7*"+
		"\u0222\n*\f*\16*\u0225\13*\3+\3+\3,\3,\5,\u022b\n,\3-\3-\3-\5-\u0230\n"+
		"-\3.\3.\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\5\60\u023d\n\60\3\61"+
		"\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\63\5\63\u0248\n\63\3\64\7\64\u024b"+
		"\n\64\f\64\16\64\u024e\13\64\3\64\3\64\5\64\u0252\n\64\3\64\5\64\u0255"+
		"\n\64\3\64\2\5@FR\65\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdf\2\7\3\2&\'\3\2#$\3\2\26\27\5\2\22\22"+
		"\31\32 \"\4\2\30\30\33\37\u027b\2k\3\2\2\2\4\u009f\3\2\2\2\6\u00ab\3\2"+
		"\2\2\b\u00ae\3\2\2\2\n\u00b0\3\2\2\2\f\u00b3\3\2\2\2\16\u00b5\3\2\2\2"+
		"\20\u00ba\3\2\2\2\22\u00bc\3\2\2\2\24\u00be\3\2\2\2\26\u00c1\3\2\2\2\30"+
		"\u00c5\3\2\2\2\32\u00d5\3\2\2\2\34\u00e1\3\2\2\2\36\u00e9\3\2\2\2 \u00ef"+
		"\3\2\2\2\"\u00f9\3\2\2\2$\u00fb\3\2\2\2&\u00fd\3\2\2\2(\u0104\3\2\2\2"+
		"*\u010b\3\2\2\2,\u0112\3\2\2\2.\u0119\3\2\2\2\60\u011b\3\2\2\2\62\u011d"+
		"\3\2\2\2\64\u011f\3\2\2\2\66\u0121\3\2\2\28\u0123\3\2\2\2:\u0125\3\2\2"+
		"\2<\u0139\3\2\2\2>\u0150\3\2\2\2@\u016f\3\2\2\2B\u019a\3\2\2\2D\u01b4"+
		"\3\2\2\2F\u01d1\3\2\2\2H\u01e1\3\2\2\2J\u01e3\3\2\2\2L\u01e7\3\2\2\2N"+
		"\u01f0\3\2\2\2P\u01f5\3\2\2\2R\u020c\3\2\2\2T\u0226\3\2\2\2V\u0228\3\2"+
		"\2\2X\u022f\3\2\2\2Z\u0231\3\2\2\2\\\u0233\3\2\2\2^\u023c\3\2\2\2`\u023e"+
		"\3\2\2\2b\u0241\3\2\2\2d\u0247\3\2\2\2f\u024c\3\2\2\2hj\7\6\2\2ih\3\2"+
		"\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2ly\3\2\2\2mk\3\2\2\2np\5L\'\2oq\7\6"+
		"\2\2po\3\2\2\2qr\3\2\2\2rp\3\2\2\2rs\3\2\2\2su\3\2\2\2tn\3\2\2\2ux\3\2"+
		"\2\2vt\3\2\2\2vw\3\2\2\2wz\3\2\2\2xv\3\2\2\2yv\3\2\2\2yz\3\2\2\2z\u0089"+
		"\3\2\2\2{~\5N(\2|~\5P)\2}{\3\2\2\2}|\3\2\2\2~\u0080\3\2\2\2\177\u0081"+
		"\7\6\2\2\u0080\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0080\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\u0085\3\2\2\2\u0084}\3\2\2\2\u0085\u0088\3\2\2\2"+
		"\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086"+
		"\3\2\2\2\u0089\u0086\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u0093\3\2\2\2\u008b"+
		"\u008d\5d\63\2\u008c\u008e\7\6\2\2\u008d\u008c\3\2\2\2\u008e\u008f\3\2"+
		"\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092\3\2\2\2\u0091"+
		"\u008b\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2"+
		"\2\2\u0094\3\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u009a\5f\64\2\u0097\u0099"+
		"\7\6\2\2\u0098\u0097\3\2\2\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a"+
		"\u009b\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u0096\3\2"+
		"\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0"+
		"\5\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a6\5V,\2\u00a3\u00a5\7\6\2\2\u00a4"+
		"\u00a3\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2"+
		"\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00a2\3\2\2\2\u00aa"+
		"\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\7\3\2\2\2"+
		"\u00ad\u00ab\3\2\2\2\u00ae\u00af\t\2\2\2\u00af\t\3\2\2\2\u00b0\u00b1\7"+
		"\31\2\2\u00b1\u00b2\5\f\7\2\u00b2\13\3\2\2\2\u00b3\u00b4\7%\2\2\u00b4"+
		"\r\3\2\2\2\u00b5\u00b6\7%\2\2\u00b6\u00b7\7\21\2\2\u00b7\17\3\2\2\2\u00b8"+
		"\u00bb\7%\2\2\u00b9\u00bb\5\16\b\2\u00ba\u00b8\3\2\2\2\u00ba\u00b9\3\2"+
		"\2\2\u00bb\21\3\2\2\2\u00bc\u00bd\7#\2\2\u00bd\23\3\2\2\2\u00be\u00bf"+
		"\7#\2\2\u00bf\25\3\2\2\2\u00c0\u00c2\7\6\2\2\u00c1\u00c0\3\2\2\2\u00c2"+
		"\u00c3\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\27\3\2\2"+
		"\2\u00c5\u00c9\5\b\5\2\u00c6\u00c8\7\6\2\2\u00c7\u00c6\3\2\2\2\u00c8\u00cb"+
		"\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00d0\3\2\2\2\u00cb"+
		"\u00c9\3\2\2\2\u00cc\u00cd\7\20\2\2\u00cd\u00cf\5\b\5\2\u00ce\u00cc\3"+
		"\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1"+
		"\31\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00d6\5\f\7\2\u00d4\u00d6\5\n\6"+
		"\2\u00d5\u00d3\3\2\2\2\u00d5\u00d4\3\2\2\2\u00d6\u00de\3\2\2\2\u00d7\u00da"+
		"\7\20\2\2\u00d8\u00db\5\f\7\2\u00d9\u00db\5\n\6\2\u00da\u00d8\3\2\2\2"+
		"\u00da\u00d9\3\2\2\2\u00db\u00dd\3\2\2\2\u00dc\u00d7\3\2\2\2\u00dd\u00e0"+
		"\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\33\3\2\2\2\u00e0"+
		"\u00de\3\2\2\2\u00e1\u00e6\5\20\t\2\u00e2\u00e3\7\20\2\2\u00e3\u00e5\5"+
		"\20\t\2\u00e4\u00e2\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6"+
		"\u00e7\3\2\2\2\u00e7\35\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00ea\5\22\n"+
		"\2\u00ea\u00eb\7\20\2\2\u00eb\u00ec\7\r\2\2\u00ec\u00ed\7\20\2\2\u00ed"+
		"\u00ee\5\24\13\2\u00ee\37\3\2\2\2\u00ef\u00f4\7#\2\2\u00f0\u00f1\7\20"+
		"\2\2\u00f1\u00f3\7#\2\2\u00f2\u00f0\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4"+
		"\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5!\3\2\2\2\u00f6\u00f4\3\2\2\2"+
		"\u00f7\u00fa\5\36\20\2\u00f8\u00fa\5 \21\2\u00f9\u00f7\3\2\2\2\u00f9\u00f8"+
		"\3\2\2\2\u00fa#\3\2\2\2\u00fb\u00fc\t\3\2\2\u00fc%\3\2\2\2\u00fd\u0101"+
		"\7\22\2\2\u00fe\u0100\7\6\2\2\u00ff\u00fe\3\2\2\2\u0100\u0103\3\2\2\2"+
		"\u0101\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\'\3\2\2\2\u0103\u0101\3"+
		"\2\2\2\u0104\u0108\7\23\2\2\u0105\u0107\7\6\2\2\u0106\u0105\3\2\2\2\u0107"+
		"\u010a\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109)\3\2\2\2"+
		"\u010a\u0108\3\2\2\2\u010b\u010f\7\24\2\2\u010c\u010e\7\6\2\2\u010d\u010c"+
		"\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110"+
		"+\3\2\2\2\u0111\u010f\3\2\2\2\u0112\u0116\7\25\2\2\u0113\u0115\7\6\2\2"+
		"\u0114\u0113\3\2\2\2\u0115\u0118\3\2\2\2\u0116\u0114\3\2\2\2\u0116\u0117"+
		"\3\2\2\2\u0117-\3\2\2\2\u0118\u0116\3\2\2\2\u0119\u011a\t\4\2\2\u011a"+
		"/\3\2\2\2\u011b\u011c\7\30\2\2\u011c\61\3\2\2\2\u011d\u011e\7&\2\2\u011e"+
		"\63\3\2\2\2\u011f\u0120\t\5\2\2\u0120\65\3\2\2\2\u0121\u0122\7 \2\2\u0122"+
		"\67\3\2\2\2\u0123\u0124\7&\2\2\u01249\3\2\2\2\u0125\u0126\t\6\2\2\u0126"+
		";\3\2\2\2\u0127\u0128\58\35\2\u0128\u0131\7\7\2\2\u0129\u012e\5@!\2\u012a"+
		"\u012b\7\20\2\2\u012b\u012d\5@!\2\u012c\u012a\3\2\2\2\u012d\u0130\3\2"+
		"\2\2\u012e\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0132\3\2\2\2\u0130"+
		"\u012e\3\2\2\2\u0131\u0129\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0133\3\2"+
		"\2\2\u0133\u0134\7\b\2\2\u0134\u013a\3\2\2\2\u0135\u0136\5@!\2\u0136\u0137"+
		"\5:\36\2\u0137\u0138\5@!\2\u0138\u013a\3\2\2\2\u0139\u0127\3\2\2\2\u0139"+
		"\u0135\3\2\2\2\u013a=\3\2\2\2\u013b\u013c\5\62\32\2\u013c\u0145\7\7\2"+
		"\2\u013d\u0142\5@!\2\u013e\u013f\7\20\2\2\u013f\u0141\5@!\2\u0140\u013e"+
		"\3\2\2\2\u0141\u0144\3\2\2\2\u0142\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143"+
		"\u0146\3\2\2\2\u0144\u0142\3\2\2\2\u0145\u013d\3\2\2\2\u0145\u0146\3\2"+
		"\2\2\u0146\u0147\3\2\2\2\u0147\u0148\7\b\2\2\u0148\u0151\3\2\2\2\u0149"+
		"\u014a\5@!\2\u014a\u014b\5\64\33\2\u014b\u014c\5@!\2\u014c\u0151\3\2\2"+
		"\2\u014d\u014e\5\66\34\2\u014e\u014f\5@!\2\u014f\u0151\3\2\2\2\u0150\u013b"+
		"\3\2\2\2\u0150\u0149\3\2\2\2\u0150\u014d\3\2\2\2\u0151?\3\2\2\2\u0152"+
		"\u0153\b!\1\2\u0153\u0154\5\66\34\2\u0154\u0155\5@!\b\u0155\u0170\3\2"+
		"\2\2\u0156\u0159\58\35\2\u0157\u0159\5\62\32\2\u0158\u0156\3\2\2\2\u0158"+
		"\u0157\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u0163\7\7\2\2\u015b\u0160\5@"+
		"!\2\u015c\u015d\7\20\2\2\u015d\u015f\5@!\2\u015e\u015c\3\2\2\2\u015f\u0162"+
		"\3\2\2\2\u0160\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161\u0164\3\2\2\2\u0162"+
		"\u0160\3\2\2\2\u0163\u015b\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0165\3\2"+
		"\2\2\u0165\u0166\7\b\2\2\u0166\u0170\3\2\2\2\u0167\u0170\5\f\7\2\u0168"+
		"\u0170\5\n\6\2\u0169\u0170\5\b\5\2\u016a\u0170\5$\23\2\u016b\u016c\7\7"+
		"\2\2\u016c\u016d\5@!\2\u016d\u016e\7\b\2\2\u016e\u0170\3\2\2\2\u016f\u0152"+
		"\3\2\2\2\u016f\u0158\3\2\2\2\u016f\u0167\3\2\2\2\u016f\u0168\3\2\2\2\u016f"+
		"\u0169\3\2\2\2\u016f\u016a\3\2\2\2\u016f\u016b\3\2\2\2\u0170\u017a\3\2"+
		"\2\2\u0171\u0174\f\t\2\2\u0172\u0175\5:\36\2\u0173\u0175\5\64\33\2\u0174"+
		"\u0172\3\2\2\2\u0174\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0177\5@"+
		"!\n\u0177\u0179\3\2\2\2\u0178\u0171\3\2\2\2\u0179\u017c\3\2\2\2\u017a"+
		"\u0178\3\2\2\2\u017a\u017b\3\2\2\2\u017bA\3\2\2\2\u017c\u017a\3\2\2\2"+
		"\u017d\u017f\7\21\2\2\u017e\u017d\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0195"+
		"\3\2\2\2\u0180\u0181\58\35\2\u0181\u018a\7\7\2\2\u0182\u0187\5F$\2\u0183"+
		"\u0184\7\20\2\2\u0184\u0186\5F$\2\u0185\u0183\3\2\2\2\u0186\u0189\3\2"+
		"\2\2\u0187\u0185\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u018b\3\2\2\2\u0189"+
		"\u0187\3\2\2\2\u018a\u0182\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u018c\3\2"+
		"\2\2\u018c\u018d\7\b\2\2\u018d\u0196\3\2\2\2\u018e\u0191\5F$\2\u018f\u0192"+
		"\5:\36\2\u0190\u0192\5\64\33\2\u0191\u018f\3\2\2\2\u0191\u0190\3\2\2\2"+
		"\u0192\u0193\3\2\2\2\u0193\u0194\5F$\2\u0194\u0196\3\2\2\2\u0195\u0180"+
		"\3\2\2\2\u0195\u018e\3\2\2\2\u0196\u019b\3\2\2\2\u0197\u0198\5\66\34\2"+
		"\u0198\u0199\5@!\2\u0199\u019b\3\2\2\2\u019a\u017e\3\2\2\2\u019a\u0197"+
		"\3\2\2\2\u019bC\3\2\2\2\u019c\u019d\5\62\32\2\u019d\u01a6\7\7\2\2\u019e"+
		"\u01a3\5F$\2\u019f\u01a0\7\20\2\2\u01a0\u01a2\5F$\2\u01a1\u019f\3\2\2"+
		"\2\u01a2\u01a5\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a7"+
		"\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a6\u019e\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7"+
		"\u01a8\3\2\2\2\u01a8\u01a9\7\b\2\2\u01a9\u01b5\3\2\2\2\u01aa\u01ad\5F"+
		"$\2\u01ab\u01ae\5:\36\2\u01ac\u01ae\5\64\33\2\u01ad\u01ab\3\2\2\2\u01ad"+
		"\u01ac\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01b0\5F$\2\u01b0\u01b5\3\2\2"+
		"\2\u01b1\u01b2\5\66\34\2\u01b2\u01b3\5@!\2\u01b3\u01b5\3\2\2\2\u01b4\u019c"+
		"\3\2\2\2\u01b4\u01aa\3\2\2\2\u01b4\u01b1\3\2\2\2\u01b5E\3\2\2\2\u01b6"+
		"\u01b9\b$\1\2\u01b7\u01ba\58\35\2\u01b8\u01ba\5\62\32\2\u01b9\u01b7\3"+
		"\2\2\2\u01b9\u01b8\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01c4\7\7\2\2\u01bc"+
		"\u01c1\5F$\2\u01bd\u01be\7\20\2\2\u01be\u01c0\5F$\2\u01bf\u01bd\3\2\2"+
		"\2\u01c0\u01c3\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2\u01c5"+
		"\3\2\2\2\u01c3\u01c1\3\2\2\2\u01c4\u01bc\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5"+
		"\u01c6\3\2\2\2\u01c6\u01c7\7\b\2\2\u01c7\u01d2\3\2\2\2\u01c8\u01c9\5\66"+
		"\34\2\u01c9\u01ca\5@!\2\u01ca\u01d2\3\2\2\2\u01cb\u01d2\5\b\5\2\u01cc"+
		"\u01d2\5$\23\2\u01cd\u01ce\7\7\2\2\u01ce\u01cf\5F$\2\u01cf\u01d0\7\b\2"+
		"\2\u01d0\u01d2\3\2\2\2\u01d1\u01b6\3\2\2\2\u01d1\u01c8\3\2\2\2\u01d1\u01cb"+
		"\3\2\2\2\u01d1\u01cc\3\2\2\2\u01d1\u01cd\3\2\2\2\u01d2\u01dc\3\2\2\2\u01d3"+
		"\u01d6\f\7\2\2\u01d4\u01d7\5:\36\2\u01d5\u01d7\5\64\33\2\u01d6\u01d4\3"+
		"\2\2\2\u01d6\u01d5\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8\u01d9\5F$\b\u01d9"+
		"\u01db\3\2\2\2\u01da\u01d3\3\2\2\2\u01db\u01de\3\2\2\2\u01dc\u01da\3\2"+
		"\2\2\u01dc\u01dd\3\2\2\2\u01ddG\3\2\2\2\u01de\u01dc\3\2\2\2\u01df\u01e2"+
		"\5\b\5\2\u01e0\u01e2\5$\23\2\u01e1\u01df\3\2\2\2\u01e1\u01e0\3\2\2\2\u01e2"+
		"I\3\2\2\2\u01e3\u01e4\5H%\2\u01e4\u01e5\7\30\2\2\u01e5\u01e6\5D#\2\u01e6"+
		"K\3\2\2\2\u01e7\u01e8\5\20\t\2\u01e8\u01e9\7\30\2\2\u01e9\u01ec\7\t\2"+
		"\2\u01ea\u01ed\5\30\r\2\u01eb\u01ed\5\"\22\2\u01ec\u01ea\3\2\2\2\u01ec"+
		"\u01eb\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ee\u01ef\7\n\2\2\u01efM\3\2\2\2"+
		"\u01f0\u01f1\58\35\2\u01f1\u01f2\7\7\2\2\u01f2\u01f3\5\34\17\2\u01f3\u01f4"+
		"\7\b\2\2\u01f4O\3\2\2\2\u01f5\u01f6\5\20\t\2\u01f6\u01f7\5\62\32\2\u01f7"+
		"\u01f8\7\7\2\2\u01f8\u01f9\5\34\17\2\u01f9\u01fa\7\b\2\2\u01faQ\3\2\2"+
		"\2\u01fb\u01fc\b*\1\2\u01fc\u01fd\7\21\2\2\u01fd\u020d\5R*\t\u01fe\u01ff"+
		"\5.\30\2\u01ff\u0200\5\32\16\2\u0200\u0201\5R*\3\u0201\u020d\3\2\2\2\u0202"+
		"\u020d\5<\37\2\u0203\u020d\5> \2\u0204\u0205\7\13\2\2\u0205\u0206\5R*"+
		"\2\u0206\u0207\7\f\2\2\u0207\u020d\3\2\2\2\u0208\u0209\7\7\2\2\u0209\u020a"+
		"\5R*\2\u020a\u020b\7\b\2\2\u020b\u020d\3\2\2\2\u020c\u01fb\3\2\2\2\u020c"+
		"\u01fe\3\2\2\2\u020c\u0202\3\2\2\2\u020c\u0203\3\2\2\2\u020c\u0204\3\2"+
		"\2\2\u020c\u0208\3\2\2\2\u020d\u0223\3\2\2\2\u020e\u020f\f\b\2\2\u020f"+
		"\u0210\7\30\2\2\u0210\u0222\5R*\t\u0211\u0212\f\7\2\2\u0212\u0213\5&\24"+
		"\2\u0213\u0214\5R*\b\u0214\u0222\3\2\2\2\u0215\u0216\f\6\2\2\u0216\u0217"+
		"\5(\25\2\u0217\u0218\5R*\7\u0218\u0222\3\2\2\2\u0219\u021a\f\5\2\2\u021a"+
		"\u021b\5*\26\2\u021b\u021c\5R*\6\u021c\u0222\3\2\2\2\u021d\u021e\f\4\2"+
		"\2\u021e\u021f\5,\27\2\u021f\u0220\5R*\5\u0220\u0222\3\2\2\2\u0221\u020e"+
		"\3\2\2\2\u0221\u0211\3\2\2\2\u0221\u0215\3\2\2\2\u0221\u0219\3\2\2\2\u0221"+
		"\u021d\3\2\2\2\u0222\u0225\3\2\2\2\u0223\u0221\3\2\2\2\u0223\u0224\3\2"+
		"\2\2\u0224S\3\2\2\2\u0225\u0223\3\2\2\2\u0226\u0227\t\3\2\2\u0227U\3\2"+
		"\2\2\u0228\u022a\5f\64\2\u0229\u022b\5T+\2\u022a\u0229\3\2\2\2\u022a\u022b"+
		"\3\2\2\2\u022bW\3\2\2\2\u022c\u0230\7#\2\2\u022d\u0230\7$\2\2\u022e\u0230"+
		"\5\f\7\2\u022f\u022c\3\2\2\2\u022f\u022d\3\2\2\2\u022f\u022e\3\2\2\2\u0230"+
		"Y\3\2\2\2\u0231\u0232\5X-\2\u0232[\3\2\2\2\u0233\u0234\5X-\2\u0234]\3"+
		"\2\2\2\u0235\u023d\5\\/\2\u0236\u0237\7\17\2\2\u0237\u023d\5Z.\2\u0238"+
		"\u0239\5\\/\2\u0239\u023a\7\17\2\2\u023a\u023b\5Z.\2\u023b\u023d\3\2\2"+
		"\2\u023c\u0235\3\2\2\2\u023c\u0236\3\2\2\2\u023c\u0238\3\2\2\2\u023d_"+
		"\3\2\2\2\u023e\u023f\5^\60\2\u023f\u0240\5R*\2\u0240a\3\2\2\2\u0241\u0242"+
		"\5R*\2\u0242\u0243\7\16\2\2\u0243c\3\2\2\2\u0244\u0248\5R*\2\u0245\u0248"+
		"\5`\61\2\u0246\u0248\5b\62\2\u0247\u0244\3\2\2\2\u0247\u0245\3\2\2\2\u0247"+
		"\u0246\3\2\2\2\u0248e\3\2\2\2\u0249\u024b\7\6\2\2\u024a\u0249\3\2\2\2"+
		"\u024b\u024e\3\2\2\2\u024c\u024a\3\2\2\2\u024c\u024d\3\2\2\2\u024d\u0251"+
		"\3\2\2\2\u024e\u024c\3\2\2\2\u024f\u0252\5B\"\2\u0250\u0252\5J&\2\u0251"+
		"\u024f\3\2\2\2\u0251\u0250\3\2\2\2\u0252\u0254\3\2\2\2\u0253\u0255\7\6"+
		"\2\2\u0254\u0253\3\2\2\2\u0254\u0255\3\2\2\2\u0255g\3\2\2\2Fkrvy}\u0082"+
		"\u0086\u0089\u008f\u0093\u009a\u009f\u00a6\u00ab\u00ba\u00c3\u00c9\u00d0"+
		"\u00d5\u00da\u00de\u00e6\u00f4\u00f9\u0101\u0108\u010f\u0116\u012e\u0131"+
		"\u0139\u0142\u0145\u0150\u0158\u0160\u0163\u016f\u0174\u017a\u017e\u0187"+
		"\u018a\u0191\u0195\u019a\u01a3\u01a6\u01ad\u01b4\u01b9\u01c1\u01c4\u01d1"+
		"\u01d6\u01dc\u01e1\u01ec\u020c\u0221\u0223\u022a\u022f\u023c\u0247\u024c"+
		"\u0251\u0254";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}