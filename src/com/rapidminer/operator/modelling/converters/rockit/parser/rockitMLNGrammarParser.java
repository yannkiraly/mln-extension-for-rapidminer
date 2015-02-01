// Generated from rockitMLNGrammar.g4 by ANTLR 4.2
package com.rapidminer.operator.modelling.converters.rockit.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class rockitMLNGrammarParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LINE_COMMENT=1, COMMENT=2, WS=3, NL=4, LP=5, RP=6, LCP=7, RCP=8, LSP=9, 
		RSP=10, DOTS=11, DOT=12, BAR=13, COL=14, COM=15, EXCL=16, AND=17, OR=18, 
		IMPLIES=19, IFF=20, U_QUANT=21, E_QUANT=22, EQ=23, PLUS=24, STAR=25, GT=26, 
		LT=27, GE=28, LE=29, NE=30, MINUS=31, SLASH=32, MOD=33, INT=34, FLOAT=35, 
		VAR_ID=36, CONST_ID=37, STRING=38;
	public static final String[] tokenNames = {
		"<INVALID>", "LINE_COMMENT", "COMMENT", "WS", "NL", "'('", "')'", "'{'", 
		"'}'", "'['", "']'", "'...'", "'.'", "'|'", "':'", "','", "'!'", "'^'", 
		"'v'", "'=>'", "'<=>'", "U_QUANT", "E_QUANT", "'='", "'+'", "'*'", "'>'", 
		"'<'", "'>='", "'<='", "'!='", "'-'", "'/'", "'%'", "INT", "FLOAT", "VAR_ID", 
		"CONST_ID", "STRING"
	};
	public static final int
		RULE_ruleFile = 0, RULE_dbFile = 1, RULE_infFile = 2, RULE_constant = 3, 
		RULE_expVariable = 4, RULE_variableLabel = 5, RULE_variable = 6, RULE_number = 7, 
		RULE_exclType = 8, RULE_type = 9, RULE_startNum = 10, RULE_endNum = 11, 
		RULE_cardinality = 12, RULE_doubleNL = 13, RULE_constantList = 14, RULE_variableList = 15, 
		RULE_typeList = 16, RULE_exNumList = 17, RULE_plainNumList = 18, RULE_numList = 19, 
		RULE_or = 20, RULE_eq = 21, RULE_function = 22, RULE_builtinFunctionSymbol = 23, 
		RULE_builtinPrefixFunctionSymbol = 24, RULE_predicate = 25, RULE_builtinPredicateSymbol = 26, 
		RULE_predicateApplication = 27, RULE_functionApplication = 28, RULE_argument = 29, 
		RULE_groundPredicateApplication = 30, RULE_groundFunctionApplication = 31, 
		RULE_groundArgument = 32, RULE_returnValue = 33, RULE_functionDef = 34, 
		RULE_typeDecl = 35, RULE_plainPredicate = 36, RULE_closedWorldPredicate = 37, 
		RULE_predicateDecl = 38, RULE_functionDecl = 39, RULE_plainFormula = 40, 
		RULE_probability = 41, RULE_probabilityStatement = 42, RULE_weight = 43, 
		RULE_weights = 44, RULE_weightedFormula = 45, RULE_hardFormula = 46, RULE_formula = 47, 
		RULE_quantification = 48, RULE_groundFormula = 49;
	public static final String[] ruleNames = {
		"ruleFile", "dbFile", "infFile", "constant", "expVariable", "variableLabel", 
		"variable", "number", "exclType", "type", "startNum", "endNum", "cardinality", 
		"doubleNL", "constantList", "variableList", "typeList", "exNumList", "plainNumList", 
		"numList", "or", "eq", "function", "builtinFunctionSymbol", "builtinPrefixFunctionSymbol", 
		"predicate", "builtinPredicateSymbol", "predicateApplication", "functionApplication", 
		"argument", "groundPredicateApplication", "groundFunctionApplication", 
		"groundArgument", "returnValue", "functionDef", "typeDecl", "plainPredicate", 
		"closedWorldPredicate", "predicateDecl", "functionDecl", "plainFormula", 
		"probability", "probabilityStatement", "weight", "weights", "weightedFormula", 
		"hardFormula", "formula", "quantification", "groundFormula"
	};

	@Override
	public String getGrammarFileName() { return "rockitMLNGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public rockitMLNGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RuleFileContext extends ParserRuleContext {
		public List<TerminalNode> NL() { return getTokens(rockitMLNGrammarParser.NL); }
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
			return getToken(rockitMLNGrammarParser.NL, i);
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
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterRuleFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitRuleFile(this);
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
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(100); match(NL);
				}
				}
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(118);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(115);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(106); typeDecl();
						{
						setState(110);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==NL) {
							{
							{
							setState(107); match(NL);
							}
							}
							setState(112);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
						}
						} 
					}
					setState(117);
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
						setState(122);
						switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
						case 1:
							{
							setState(120); predicateDecl();
							}
							break;

						case 2:
							{
							setState(121); functionDecl();
							}
							break;
						}
						{
						setState(127);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==NL) {
							{
							{
							setState(124); match(NL);
							}
							}
							setState(129);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
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
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << LSP) | (1L << BAR) | (1L << EXCL) | (1L << PLUS) | (1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << VAR_ID) | (1L << CONST_ID) | (1L << STRING))) != 0)) {
				{
				{
				setState(137); formula();
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(138); match(NL);
					}
					}
					setState(143);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(148);
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
		public List<TerminalNode> NL() { return getTokens(rockitMLNGrammarParser.NL); }
		public GroundFormulaContext groundFormula(int i) {
			return getRuleContext(GroundFormulaContext.class,i);
		}
		public List<GroundFormulaContext> groundFormula() {
			return getRuleContexts(GroundFormulaContext.class);
		}
		public TerminalNode NL(int i) {
			return getToken(rockitMLNGrammarParser.NL, i);
		}
		public DbFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dbFile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterDbFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitDbFile(this);
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
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NL) | (1L << LP) | (1L << EXCL) | (1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << VAR_ID) | (1L << CONST_ID) | (1L << STRING))) != 0)) {
				{
				{
				setState(149); groundFormula();
				setState(153);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(150); match(NL);
						}
						} 
					}
					setState(155);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				}
				}
				setState(160);
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
		public List<TerminalNode> NL() { return getTokens(rockitMLNGrammarParser.NL); }
		public ProbabilityStatementContext probabilityStatement(int i) {
			return getRuleContext(ProbabilityStatementContext.class,i);
		}
		public TerminalNode NL(int i) {
			return getToken(rockitMLNGrammarParser.NL, i);
		}
		public InfFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_infFile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterInfFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitInfFile(this);
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
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NL) | (1L << LP) | (1L << EXCL) | (1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << VAR_ID) | (1L << CONST_ID) | (1L << STRING))) != 0)) {
				{
				{
				setState(161); probabilityStatement();
				setState(165);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(162); match(NL);
						}
						} 
					}
					setState(167);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				}
				}
				}
				setState(172);
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
		public TerminalNode STRING() { return getToken(rockitMLNGrammarParser.STRING, 0); }
		public TerminalNode CONST_ID() { return getToken(rockitMLNGrammarParser.CONST_ID, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
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
		public TerminalNode PLUS() { return getToken(rockitMLNGrammarParser.PLUS, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ExpVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterExpVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitExpVariable(this);
		}
	}

	public final ExpVariableContext expVariable() throws RecognitionException {
		ExpVariableContext _localctx = new ExpVariableContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175); match(PLUS);
			setState(176); variable();
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

	public static class VariableLabelContext extends ParserRuleContext {
		public TerminalNode VAR_ID() { return getToken(rockitMLNGrammarParser.VAR_ID, 0); }
		public TerminalNode CONST_ID() { return getToken(rockitMLNGrammarParser.CONST_ID, 0); }
		public VariableLabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableLabel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterVariableLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitVariableLabel(this);
		}
	}

	public final VariableLabelContext variableLabel() throws RecognitionException {
		VariableLabelContext _localctx = new VariableLabelContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_variableLabel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			_la = _input.LA(1);
			if ( !(_la==VAR_ID || _la==CONST_ID) ) {
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
		public TerminalNode VAR_ID() { return getToken(rockitMLNGrammarParser.VAR_ID, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitVariable(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180); match(VAR_ID);
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
		public TerminalNode INT() { return getToken(rockitMLNGrammarParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(rockitMLNGrammarParser.FLOAT, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitNumber(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
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

	public static class ExclTypeContext extends ParserRuleContext {
		public VariableLabelContext variableLabel() {
			return getRuleContext(VariableLabelContext.class,0);
		}
		public TerminalNode EXCL() { return getToken(rockitMLNGrammarParser.EXCL, 0); }
		public ExclTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exclType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterExclType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitExclType(this);
		}
	}

	public final ExclTypeContext exclType() throws RecognitionException {
		ExclTypeContext _localctx = new ExclTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_exclType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184); variableLabel();
			setState(185); match(EXCL);
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
		public VariableLabelContext variableLabel() {
			return getRuleContext(VariableLabelContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type);
		try {
			setState(189);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(187); variableLabel();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(188); exclType();
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

	public static class StartNumContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public StartNumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_startNum; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterStartNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitStartNum(this);
		}
	}

	public final StartNumContext startNum() throws RecognitionException {
		StartNumContext _localctx = new StartNumContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_startNum);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191); number();
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

	public static class EndNumContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public EndNumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endNum; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterEndNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitEndNum(this);
		}
	}

	public final EndNumContext endNum() throws RecognitionException {
		EndNumContext _localctx = new EndNumContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_endNum);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193); number();
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
		public TerminalNode INT() { return getToken(rockitMLNGrammarParser.INT, 0); }
		public CardinalityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cardinality; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterCardinality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitCardinality(this);
		}
	}

	public final CardinalityContext cardinality() throws RecognitionException {
		CardinalityContext _localctx = new CardinalityContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_cardinality);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195); match(INT);
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
		public List<TerminalNode> NL() { return getTokens(rockitMLNGrammarParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(rockitMLNGrammarParser.NL, i);
		}
		public DoubleNLContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubleNL; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterDoubleNL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitDoubleNL(this);
		}
	}

	public final DoubleNLContext doubleNL() throws RecognitionException {
		DoubleNLContext _localctx = new DoubleNLContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_doubleNL);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(197); match(NL);
				}
				}
				setState(200); 
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
		public List<TerminalNode> NL() { return getTokens(rockitMLNGrammarParser.NL); }
		public List<ConstantContext> constant() {
			return getRuleContexts(ConstantContext.class);
		}
		public List<TerminalNode> COM() { return getTokens(rockitMLNGrammarParser.COM); }
		public TerminalNode NL(int i) {
			return getToken(rockitMLNGrammarParser.NL, i);
		}
		public TerminalNode COM(int i) {
			return getToken(rockitMLNGrammarParser.COM, i);
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
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterConstantList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitConstantList(this);
		}
	}

	public final ConstantListContext constantList() throws RecognitionException {
		ConstantListContext _localctx = new ConstantListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_constantList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202); constant();
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(203); match(NL);
				}
				}
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COM) {
				{
				{
				setState(209); match(COM);
				setState(210); constant();
				}
				}
				setState(215);
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
		public List<TerminalNode> COM() { return getTokens(rockitMLNGrammarParser.COM); }
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
			return getToken(rockitMLNGrammarParser.COM, i);
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
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterVariableList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitVariableList(this);
		}
	}

	public final VariableListContext variableList() throws RecognitionException {
		VariableListContext _localctx = new VariableListContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_variableList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			switch (_input.LA(1)) {
			case VAR_ID:
				{
				setState(216); variable();
				}
				break;
			case PLUS:
				{
				setState(217); expVariable();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COM) {
				{
				{
				setState(220); match(COM);
				setState(223);
				switch (_input.LA(1)) {
				case VAR_ID:
					{
					setState(221); variable();
					}
					break;
				case PLUS:
					{
					setState(222); expVariable();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(229);
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
		public List<TerminalNode> COM() { return getTokens(rockitMLNGrammarParser.COM); }
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TerminalNode COM(int i) {
			return getToken(rockitMLNGrammarParser.COM, i);
		}
		public TypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitTypeList(this);
		}
	}

	public final TypeListContext typeList() throws RecognitionException {
		TypeListContext _localctx = new TypeListContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_typeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230); type();
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COM) {
				{
				{
				setState(231); match(COM);
				setState(232); type();
				}
				}
				setState(237);
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

	public static class ExNumListContext extends ParserRuleContext {
		public List<TerminalNode> COM() { return getTokens(rockitMLNGrammarParser.COM); }
		public TerminalNode DOTS() { return getToken(rockitMLNGrammarParser.DOTS, 0); }
		public EndNumContext endNum() {
			return getRuleContext(EndNumContext.class,0);
		}
		public TerminalNode COM(int i) {
			return getToken(rockitMLNGrammarParser.COM, i);
		}
		public StartNumContext startNum() {
			return getRuleContext(StartNumContext.class,0);
		}
		public ExNumListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exNumList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterExNumList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitExNumList(this);
		}
	}

	public final ExNumListContext exNumList() throws RecognitionException {
		ExNumListContext _localctx = new ExNumListContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_exNumList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238); startNum();
			setState(239); match(COM);
			setState(240); match(DOTS);
			setState(241); match(COM);
			setState(242); endNum();
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
		public List<TerminalNode> COM() { return getTokens(rockitMLNGrammarParser.COM); }
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
		}
		public TerminalNode COM(int i) {
			return getToken(rockitMLNGrammarParser.COM, i);
		}
		public PlainNumListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plainNumList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterPlainNumList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitPlainNumList(this);
		}
	}

	public final PlainNumListContext plainNumList() throws RecognitionException {
		PlainNumListContext _localctx = new PlainNumListContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_plainNumList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244); number();
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COM) {
				{
				{
				setState(245); match(COM);
				setState(246); number();
				}
				}
				setState(251);
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
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterNumList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitNumList(this);
		}
	}

	public final NumListContext numList() throws RecognitionException {
		NumListContext _localctx = new NumListContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_numList);
		try {
			setState(254);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(252); exNumList();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(253); plainNumList();
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

	public static class OrContext extends ParserRuleContext {
		public List<TerminalNode> NL() { return getTokens(rockitMLNGrammarParser.NL); }
		public TerminalNode OR() { return getToken(rockitMLNGrammarParser.OR, 0); }
		public TerminalNode NL(int i) {
			return getToken(rockitMLNGrammarParser.NL, i);
		}
		public OrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitOr(this);
		}
	}

	public final OrContext or() throws RecognitionException {
		OrContext _localctx = new OrContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_or);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256); match(OR);
			setState(260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(257); match(NL);
				}
				}
				setState(262);
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

	public static class EqContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(rockitMLNGrammarParser.EQ, 0); }
		public EqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitEq(this);
		}
	}

	public final EqContext eq() throws RecognitionException {
		EqContext _localctx = new EqContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_eq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263); match(EQ);
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
		public VariableLabelContext variableLabel() {
			return getRuleContext(VariableLabelContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265); variableLabel();
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
		public TerminalNode SLASH() { return getToken(rockitMLNGrammarParser.SLASH, 0); }
		public TerminalNode AND() { return getToken(rockitMLNGrammarParser.AND, 0); }
		public TerminalNode PLUS() { return getToken(rockitMLNGrammarParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(rockitMLNGrammarParser.MINUS, 0); }
		public TerminalNode STAR() { return getToken(rockitMLNGrammarParser.STAR, 0); }
		public TerminalNode MOD() { return getToken(rockitMLNGrammarParser.MOD, 0); }
		public BuiltinFunctionSymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtinFunctionSymbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterBuiltinFunctionSymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitBuiltinFunctionSymbol(this);
		}
	}

	public final BuiltinFunctionSymbolContext builtinFunctionSymbol() throws RecognitionException {
		BuiltinFunctionSymbolContext _localctx = new BuiltinFunctionSymbolContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_builtinFunctionSymbol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
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
		public TerminalNode MINUS() { return getToken(rockitMLNGrammarParser.MINUS, 0); }
		public BuiltinPrefixFunctionSymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtinPrefixFunctionSymbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterBuiltinPrefixFunctionSymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitBuiltinPrefixFunctionSymbol(this);
		}
	}

	public final BuiltinPrefixFunctionSymbolContext builtinPrefixFunctionSymbol() throws RecognitionException {
		BuiltinPrefixFunctionSymbolContext _localctx = new BuiltinPrefixFunctionSymbolContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_builtinPrefixFunctionSymbol);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269); match(MINUS);
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
		public VariableLabelContext variableLabel() {
			return getRuleContext(VariableLabelContext.class,0);
		}
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitPredicate(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271); variableLabel();
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
		public TerminalNode GE() { return getToken(rockitMLNGrammarParser.GE, 0); }
		public TerminalNode LT() { return getToken(rockitMLNGrammarParser.LT, 0); }
		public TerminalNode GT() { return getToken(rockitMLNGrammarParser.GT, 0); }
		public TerminalNode LE() { return getToken(rockitMLNGrammarParser.LE, 0); }
		public TerminalNode EQ() { return getToken(rockitMLNGrammarParser.EQ, 0); }
		public TerminalNode NE() { return getToken(rockitMLNGrammarParser.NE, 0); }
		public BuiltinPredicateSymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtinPredicateSymbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterBuiltinPredicateSymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitBuiltinPredicateSymbol(this);
		}
	}

	public final BuiltinPredicateSymbolContext builtinPredicateSymbol() throws RecognitionException {
		BuiltinPredicateSymbolContext _localctx = new BuiltinPredicateSymbolContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_builtinPredicateSymbol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
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
		public TerminalNode RP() { return getToken(rockitMLNGrammarParser.RP, 0); }
		public BuiltinPredicateSymbolContext builtinPredicateSymbol() {
			return getRuleContext(BuiltinPredicateSymbolContext.class,0);
		}
		public List<TerminalNode> COM() { return getTokens(rockitMLNGrammarParser.COM); }
		public TerminalNode LP() { return getToken(rockitMLNGrammarParser.LP, 0); }
		public TerminalNode COM(int i) {
			return getToken(rockitMLNGrammarParser.COM, i);
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
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterPredicateApplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitPredicateApplication(this);
		}
	}

	public final PredicateApplicationContext predicateApplication() throws RecognitionException {
		PredicateApplicationContext _localctx = new PredicateApplicationContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_predicateApplication);
		int _la;
		try {
			setState(293);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(275); predicate();
				setState(276); match(LP);
				setState(285);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << PLUS) | (1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << VAR_ID) | (1L << CONST_ID) | (1L << STRING))) != 0)) {
					{
					setState(277); argument(0);
					setState(282);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COM) {
						{
						{
						setState(278); match(COM);
						setState(279); argument(0);
						}
						}
						setState(284);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(287); match(RP);
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(289); argument(0);
				setState(290); builtinPredicateSymbol();
				setState(291); argument(0);
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
		public TerminalNode RP() { return getToken(rockitMLNGrammarParser.RP, 0); }
		public BuiltinPrefixFunctionSymbolContext builtinPrefixFunctionSymbol() {
			return getRuleContext(BuiltinPrefixFunctionSymbolContext.class,0);
		}
		public List<TerminalNode> COM() { return getTokens(rockitMLNGrammarParser.COM); }
		public TerminalNode LP() { return getToken(rockitMLNGrammarParser.LP, 0); }
		public TerminalNode COM(int i) {
			return getToken(rockitMLNGrammarParser.COM, i);
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
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterFunctionApplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitFunctionApplication(this);
		}
	}

	public final FunctionApplicationContext functionApplication() throws RecognitionException {
		FunctionApplicationContext _localctx = new FunctionApplicationContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_functionApplication);
		int _la;
		try {
			setState(316);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(295); function();
				setState(296); match(LP);
				setState(305);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << PLUS) | (1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << VAR_ID) | (1L << CONST_ID) | (1L << STRING))) != 0)) {
					{
					setState(297); argument(0);
					setState(302);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COM) {
						{
						{
						setState(298); match(COM);
						setState(299); argument(0);
						}
						}
						setState(304);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(307); match(RP);
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(309); argument(0);
				setState(310); builtinFunctionSymbol();
				setState(311); argument(0);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(313); builtinPrefixFunctionSymbol();
				setState(314); argument(0);
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
		public TerminalNode RP() { return getToken(rockitMLNGrammarParser.RP, 0); }
		public List<TerminalNode> COM() { return getTokens(rockitMLNGrammarParser.COM); }
		public ExpVariableContext expVariable() {
			return getRuleContext(ExpVariableContext.class,0);
		}
		public TerminalNode COM(int i) {
			return getToken(rockitMLNGrammarParser.COM, i);
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
		public TerminalNode LP() { return getToken(rockitMLNGrammarParser.LP, 0); }
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
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitArgument(this);
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
		int _startState = 58;
		enterRecursionRule(_localctx, 58, RULE_argument, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(319); builtinPrefixFunctionSymbol();
				setState(320); argument(6);
				}
				break;

			case 2:
				{
				{
				setState(324);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(322); predicate();
					}
					break;

				case 2:
					{
					setState(323); function();
					}
					break;
				}
				setState(326); match(LP);
				setState(335);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << PLUS) | (1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << VAR_ID) | (1L << CONST_ID) | (1L << STRING))) != 0)) {
					{
					setState(327); argument(0);
					setState(332);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COM) {
						{
						{
						setState(328); match(COM);
						setState(329); argument(0);
						}
						}
						setState(334);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(337); match(RP);
				}
				}
				break;

			case 3:
				{
				setState(339); variable();
				}
				break;

			case 4:
				{
				setState(340); expVariable();
				}
				break;

			case 5:
				{
				setState(341); constant();
				}
				break;

			case 6:
				{
				setState(342); number();
				}
				break;

			case 7:
				{
				setState(343); match(LP);
				setState(344); argument(0);
				setState(345); match(RP);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(358);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArgumentContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_argument);
					setState(349);
					if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
					setState(352);
					switch (_input.LA(1)) {
					case EQ:
					case GT:
					case LT:
					case GE:
					case LE:
					case NE:
						{
						setState(350); builtinPredicateSymbol();
						}
						break;
					case AND:
					case PLUS:
					case STAR:
					case MINUS:
					case SLASH:
					case MOD:
						{
						setState(351); builtinFunctionSymbol();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(354); argument(8);
					}
					} 
				}
				setState(360);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
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
		public TerminalNode RP() { return getToken(rockitMLNGrammarParser.RP, 0); }
		public BuiltinPrefixFunctionSymbolContext builtinPrefixFunctionSymbol() {
			return getRuleContext(BuiltinPrefixFunctionSymbolContext.class,0);
		}
		public GroundArgumentContext groundArgument(int i) {
			return getRuleContext(GroundArgumentContext.class,i);
		}
		public BuiltinPredicateSymbolContext builtinPredicateSymbol() {
			return getRuleContext(BuiltinPredicateSymbolContext.class,0);
		}
		public List<TerminalNode> COM() { return getTokens(rockitMLNGrammarParser.COM); }
		public TerminalNode LP() { return getToken(rockitMLNGrammarParser.LP, 0); }
		public TerminalNode EXCL() { return getToken(rockitMLNGrammarParser.EXCL, 0); }
		public List<GroundArgumentContext> groundArgument() {
			return getRuleContexts(GroundArgumentContext.class);
		}
		public BuiltinFunctionSymbolContext builtinFunctionSymbol() {
			return getRuleContext(BuiltinFunctionSymbolContext.class,0);
		}
		public TerminalNode COM(int i) {
			return getToken(rockitMLNGrammarParser.COM, i);
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
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterGroundPredicateApplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitGroundPredicateApplication(this);
		}
	}

	public final GroundPredicateApplicationContext groundPredicateApplication() throws RecognitionException {
		GroundPredicateApplicationContext _localctx = new GroundPredicateApplicationContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_groundPredicateApplication);
		int _la;
		try {
			setState(390);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(362);
				_la = _input.LA(1);
				if (_la==EXCL) {
					{
					setState(361); match(EXCL);
					}
				}

				setState(385);
				switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
				case 1:
					{
					{
					setState(364); predicate();
					setState(365); match(LP);
					setState(374);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << VAR_ID) | (1L << CONST_ID) | (1L << STRING))) != 0)) {
						{
						setState(366); groundArgument(0);
						setState(371);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COM) {
							{
							{
							setState(367); match(COM);
							setState(368); groundArgument(0);
							}
							}
							setState(373);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(376); match(RP);
					}
					}
					break;

				case 2:
					{
					setState(378); groundArgument(0);
					setState(381);
					switch (_input.LA(1)) {
					case EQ:
					case GT:
					case LT:
					case GE:
					case LE:
					case NE:
						{
						setState(379); builtinPredicateSymbol();
						}
						break;
					case AND:
					case PLUS:
					case STAR:
					case MINUS:
					case SLASH:
					case MOD:
						{
						setState(380); builtinFunctionSymbol();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(383); groundArgument(0);
					}
					break;
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(387); builtinPrefixFunctionSymbol();
				setState(388); argument(0);
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
		public TerminalNode RP() { return getToken(rockitMLNGrammarParser.RP, 0); }
		public BuiltinPrefixFunctionSymbolContext builtinPrefixFunctionSymbol() {
			return getRuleContext(BuiltinPrefixFunctionSymbolContext.class,0);
		}
		public GroundArgumentContext groundArgument(int i) {
			return getRuleContext(GroundArgumentContext.class,i);
		}
		public BuiltinPredicateSymbolContext builtinPredicateSymbol() {
			return getRuleContext(BuiltinPredicateSymbolContext.class,0);
		}
		public List<TerminalNode> COM() { return getTokens(rockitMLNGrammarParser.COM); }
		public TerminalNode LP() { return getToken(rockitMLNGrammarParser.LP, 0); }
		public List<GroundArgumentContext> groundArgument() {
			return getRuleContexts(GroundArgumentContext.class);
		}
		public TerminalNode COM(int i) {
			return getToken(rockitMLNGrammarParser.COM, i);
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
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterGroundFunctionApplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitGroundFunctionApplication(this);
		}
	}

	public final GroundFunctionApplicationContext groundFunctionApplication() throws RecognitionException {
		GroundFunctionApplicationContext _localctx = new GroundFunctionApplicationContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_groundFunctionApplication);
		int _la;
		try {
			setState(416);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(392); function();
				setState(393); match(LP);
				setState(402);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << VAR_ID) | (1L << CONST_ID) | (1L << STRING))) != 0)) {
					{
					setState(394); groundArgument(0);
					setState(399);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COM) {
						{
						{
						setState(395); match(COM);
						setState(396); groundArgument(0);
						}
						}
						setState(401);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(404); match(RP);
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(406); groundArgument(0);
				setState(409);
				switch (_input.LA(1)) {
				case EQ:
				case GT:
				case LT:
				case GE:
				case LE:
				case NE:
					{
					setState(407); builtinPredicateSymbol();
					}
					break;
				case AND:
				case PLUS:
				case STAR:
				case MINUS:
				case SLASH:
				case MOD:
					{
					setState(408); builtinFunctionSymbol();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(411); groundArgument(0);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(413); builtinPrefixFunctionSymbol();
				setState(414); argument(0);
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
		public TerminalNode RP() { return getToken(rockitMLNGrammarParser.RP, 0); }
		public BuiltinPrefixFunctionSymbolContext builtinPrefixFunctionSymbol() {
			return getRuleContext(BuiltinPrefixFunctionSymbolContext.class,0);
		}
		public GroundArgumentContext groundArgument(int i) {
			return getRuleContext(GroundArgumentContext.class,i);
		}
		public List<TerminalNode> COM() { return getTokens(rockitMLNGrammarParser.COM); }
		public List<GroundArgumentContext> groundArgument() {
			return getRuleContexts(GroundArgumentContext.class);
		}
		public TerminalNode COM(int i) {
			return getToken(rockitMLNGrammarParser.COM, i);
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
		public TerminalNode LP() { return getToken(rockitMLNGrammarParser.LP, 0); }
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
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterGroundArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitGroundArgument(this);
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
		int _startState = 64;
		enterRecursionRule(_localctx, 64, RULE_groundArgument, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(445);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				{
				{
				setState(421);
				switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
				case 1:
					{
					setState(419); predicate();
					}
					break;

				case 2:
					{
					setState(420); function();
					}
					break;
				}
				setState(423); match(LP);
				setState(432);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << VAR_ID) | (1L << CONST_ID) | (1L << STRING))) != 0)) {
					{
					setState(424); groundArgument(0);
					setState(429);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COM) {
						{
						{
						setState(425); match(COM);
						setState(426); groundArgument(0);
						}
						}
						setState(431);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(434); match(RP);
				}
				}
				break;

			case 2:
				{
				setState(436); builtinPrefixFunctionSymbol();
				setState(437); argument(0);
				}
				break;

			case 3:
				{
				setState(439); constant();
				}
				break;

			case 4:
				{
				setState(440); number();
				}
				break;

			case 5:
				{
				setState(441); match(LP);
				setState(442); groundArgument(0);
				setState(443); match(RP);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(456);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new GroundArgumentContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_groundArgument);
					setState(447);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(450);
					switch (_input.LA(1)) {
					case EQ:
					case GT:
					case LT:
					case GE:
					case LE:
					case NE:
						{
						setState(448); builtinPredicateSymbol();
						}
						break;
					case AND:
					case PLUS:
					case STAR:
					case MINUS:
					case SLASH:
					case MOD:
						{
						setState(449); builtinFunctionSymbol();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(452); groundArgument(6);
					}
					} 
				}
				setState(458);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
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
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterReturnValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitReturnValue(this);
		}
	}

	public final ReturnValueContext returnValue() throws RecognitionException {
		ReturnValueContext _localctx = new ReturnValueContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_returnValue);
		try {
			setState(461);
			switch (_input.LA(1)) {
			case CONST_ID:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(459); constant();
				}
				break;
			case INT:
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(460); number();
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
		public TerminalNode EQ() { return getToken(rockitMLNGrammarParser.EQ, 0); }
		public FunctionDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterFunctionDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitFunctionDef(this);
		}
	}

	public final FunctionDefContext functionDef() throws RecognitionException {
		FunctionDefContext _localctx = new FunctionDefContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_functionDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(463); returnValue();
			setState(464); match(EQ);
			setState(465); groundFunctionApplication();
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
		public TerminalNode RCP() { return getToken(rockitMLNGrammarParser.RCP, 0); }
		public ConstantListContext constantList() {
			return getRuleContext(ConstantListContext.class,0);
		}
		public TerminalNode LCP() { return getToken(rockitMLNGrammarParser.LCP, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode EQ() { return getToken(rockitMLNGrammarParser.EQ, 0); }
		public NumListContext numList() {
			return getRuleContext(NumListContext.class,0);
		}
		public TypeDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterTypeDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitTypeDecl(this);
		}
	}

	public final TypeDeclContext typeDecl() throws RecognitionException {
		TypeDeclContext _localctx = new TypeDeclContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_typeDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(467); type();
			setState(468); match(EQ);
			setState(469); match(LCP);
			setState(472);
			switch (_input.LA(1)) {
			case CONST_ID:
			case STRING:
				{
				setState(470); constantList();
				}
				break;
			case INT:
			case FLOAT:
				{
				setState(471); numList();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(474); match(RCP);
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
		public TerminalNode RP() { return getToken(rockitMLNGrammarParser.RP, 0); }
		public TerminalNode LP() { return getToken(rockitMLNGrammarParser.LP, 0); }
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
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterPlainPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitPlainPredicate(this);
		}
	}

	public final PlainPredicateContext plainPredicate() throws RecognitionException {
		PlainPredicateContext _localctx = new PlainPredicateContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_plainPredicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(476); predicate();
			setState(477); match(LP);
			setState(478); typeList();
			setState(479); match(RP);
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
		public TerminalNode STAR() { return getToken(rockitMLNGrammarParser.STAR, 0); }
		public ClosedWorldPredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closedWorldPredicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterClosedWorldPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitClosedWorldPredicate(this);
		}
	}

	public final ClosedWorldPredicateContext closedWorldPredicate() throws RecognitionException {
		ClosedWorldPredicateContext _localctx = new ClosedWorldPredicateContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_closedWorldPredicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(481); match(STAR);
			setState(482); plainPredicate();
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
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterPredicateDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitPredicateDecl(this);
		}
	}

	public final PredicateDeclContext predicateDecl() throws RecognitionException {
		PredicateDeclContext _localctx = new PredicateDeclContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_predicateDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(486);
			switch (_input.LA(1)) {
			case STAR:
				{
				setState(484); closedWorldPredicate();
				}
				break;
			case VAR_ID:
			case CONST_ID:
				{
				setState(485); plainPredicate();
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
		public TerminalNode RP() { return getToken(rockitMLNGrammarParser.RP, 0); }
		public TerminalNode LP() { return getToken(rockitMLNGrammarParser.LP, 0); }
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
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterFunctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitFunctionDecl(this);
		}
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_functionDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(488); type();
			setState(489); function();
			setState(490); match(LP);
			setState(491); typeList();
			setState(492); match(RP);
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
		public TerminalNode RP() { return getToken(rockitMLNGrammarParser.RP, 0); }
		public QuantificationContext quantification() {
			return getRuleContext(QuantificationContext.class,0);
		}
		public TerminalNode LP() { return getToken(rockitMLNGrammarParser.LP, 0); }
		public TerminalNode RSP() { return getToken(rockitMLNGrammarParser.RSP, 0); }
		public TerminalNode EXCL() { return getToken(rockitMLNGrammarParser.EXCL, 0); }
		public OrContext or() {
			return getRuleContext(OrContext.class,0);
		}
		public List<PlainFormulaContext> plainFormula() {
			return getRuleContexts(PlainFormulaContext.class);
		}
		public TerminalNode LSP() { return getToken(rockitMLNGrammarParser.LSP, 0); }
		public TerminalNode EQ() { return getToken(rockitMLNGrammarParser.EQ, 0); }
		public FunctionApplicationContext functionApplication() {
			return getRuleContext(FunctionApplicationContext.class,0);
		}
		public PlainFormulaContext plainFormula(int i) {
			return getRuleContext(PlainFormulaContext.class,i);
		}
		public PredicateApplicationContext predicateApplication() {
			return getRuleContext(PredicateApplicationContext.class,0);
		}
		public PlainFormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plainFormula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterPlainFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitPlainFormula(this);
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
			setState(508);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				{
				setState(495); match(EXCL);
				setState(496); plainFormula(4);
				}
				break;

			case 2:
				{
				setState(497); predicateApplication();
				}
				break;

			case 3:
				{
				setState(498); functionApplication();
				}
				break;

			case 4:
				{
				setState(499); match(LSP);
				setState(500); plainFormula(0);
				setState(501); match(RSP);
				}
				break;

			case 5:
				{
				setState(503); match(LP);
				setState(504); plainFormula(0);
				setState(505); match(RP);
				}
				break;

			case 6:
				{
				setState(507); quantification();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(519);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(517);
					switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
					case 1:
						{
						_localctx = new PlainFormulaContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_plainFormula);
						setState(510);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(511); match(EQ);
						setState(512); plainFormula(4);
						}
						break;

					case 2:
						{
						_localctx = new PlainFormulaContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_plainFormula);
						setState(513);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(514); or();
						setState(515); plainFormula(3);
						}
						break;
					}
					} 
				}
				setState(521);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
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
		public TerminalNode INT() { return getToken(rockitMLNGrammarParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(rockitMLNGrammarParser.FLOAT, 0); }
		public ProbabilityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_probability; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterProbability(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitProbability(this);
		}
	}

	public final ProbabilityContext probability() throws RecognitionException {
		ProbabilityContext _localctx = new ProbabilityContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_probability);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(522);
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
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterProbabilityStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitProbabilityStatement(this);
		}
	}

	public final ProbabilityStatementContext probabilityStatement() throws RecognitionException {
		ProbabilityStatementContext _localctx = new ProbabilityStatementContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_probabilityStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(525);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				{
				setState(524); probability();
				}
				break;
			}
			setState(527); groundFormula();
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
		public TerminalNode COL() { return getToken(rockitMLNGrammarParser.COL, 0); }
		public TerminalNode INT() { return getToken(rockitMLNGrammarParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(rockitMLNGrammarParser.FLOAT, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public WeightContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_weight; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterWeight(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitWeight(this);
		}
	}

	public final WeightContext weight() throws RecognitionException {
		WeightContext _localctx = new WeightContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_weight);
		try {
			setState(534);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(529); match(INT);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(530); match(FLOAT);
				}
				break;
			case VAR_ID:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(531); variable();
				setState(532); match(COL);
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

	public static class WeightsContext extends ParserRuleContext {
		public WeightContext weight() {
			return getRuleContext(WeightContext.class,0);
		}
		public WeightsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_weights; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterWeights(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitWeights(this);
		}
	}

	public final WeightsContext weights() throws RecognitionException {
		WeightsContext _localctx = new WeightsContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_weights);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(536); weight();
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
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterWeightedFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitWeightedFormula(this);
		}
	}

	public final WeightedFormulaContext weightedFormula() throws RecognitionException {
		WeightedFormulaContext _localctx = new WeightedFormulaContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_weightedFormula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(538); weights();
			setState(539); plainFormula(0);
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
		public TerminalNode DOT() { return getToken(rockitMLNGrammarParser.DOT, 0); }
		public PlainFormulaContext plainFormula() {
			return getRuleContext(PlainFormulaContext.class,0);
		}
		public HardFormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hardFormula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterHardFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitHardFormula(this);
		}
	}

	public final HardFormulaContext hardFormula() throws RecognitionException {
		HardFormulaContext _localctx = new HardFormulaContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_hardFormula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(541); plainFormula(0);
			setState(542); match(DOT);
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
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitFormula(this);
		}
	}

	public final FormulaContext formula() throws RecognitionException {
		FormulaContext _localctx = new FormulaContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_formula);
		try {
			setState(547);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(544); plainFormula(0);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(545); weightedFormula();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(546); hardFormula();
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

	public static class QuantificationContext extends ParserRuleContext {
		public List<TerminalNode> BAR() { return getTokens(rockitMLNGrammarParser.BAR); }
		public TerminalNode GE() { return getToken(rockitMLNGrammarParser.GE, 0); }
		public CardinalityContext cardinality() {
			return getRuleContext(CardinalityContext.class,0);
		}
		public TerminalNode BAR(int i) {
			return getToken(rockitMLNGrammarParser.BAR, i);
		}
		public PlainFormulaContext plainFormula() {
			return getRuleContext(PlainFormulaContext.class,0);
		}
		public TerminalNode LE() { return getToken(rockitMLNGrammarParser.LE, 0); }
		public VariableListContext variableList() {
			return getRuleContext(VariableListContext.class,0);
		}
		public QuantificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterQuantification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitQuantification(this);
		}
	}

	public final QuantificationContext quantification() throws RecognitionException {
		QuantificationContext _localctx = new QuantificationContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_quantification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(549); match(BAR);
			setState(550); variableList();
			setState(551); match(BAR);
			setState(552); plainFormula(0);
			setState(553);
			_la = _input.LA(1);
			if ( !(_la==GE || _la==LE) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(554); cardinality();
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
		public List<TerminalNode> NL() { return getTokens(rockitMLNGrammarParser.NL); }
		public FunctionDefContext functionDef() {
			return getRuleContext(FunctionDefContext.class,0);
		}
		public GroundPredicateApplicationContext groundPredicateApplication() {
			return getRuleContext(GroundPredicateApplicationContext.class,0);
		}
		public TerminalNode NL(int i) {
			return getToken(rockitMLNGrammarParser.NL, i);
		}
		public GroundFormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groundFormula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).enterGroundFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rockitMLNGrammarListener ) ((rockitMLNGrammarListener)listener).exitGroundFormula(this);
		}
	}

	public final GroundFormulaContext groundFormula() throws RecognitionException {
		GroundFormulaContext _localctx = new GroundFormulaContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_groundFormula);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(559);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(556); match(NL);
				}
				}
				setState(561);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(564);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				{
				setState(562); groundPredicateApplication();
				}
				break;

			case 2:
				{
				setState(563); functionDef();
				}
				break;
			}
			setState(567);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				{
				setState(566); match(NL);
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
		case 29: return argument_sempred((ArgumentContext)_localctx, predIndex);

		case 32: return groundArgument_sempred((GroundArgumentContext)_localctx, predIndex);

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
		case 2: return precpred(_ctx, 3);

		case 3: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3(\u023c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\3\2\7\2"+
		"h\n\2\f\2\16\2k\13\2\3\2\3\2\7\2o\n\2\f\2\16\2r\13\2\7\2t\n\2\f\2\16\2"+
		"w\13\2\5\2y\n\2\3\2\3\2\5\2}\n\2\3\2\7\2\u0080\n\2\f\2\16\2\u0083\13\2"+
		"\7\2\u0085\n\2\f\2\16\2\u0088\13\2\5\2\u008a\n\2\3\2\3\2\7\2\u008e\n\2"+
		"\f\2\16\2\u0091\13\2\7\2\u0093\n\2\f\2\16\2\u0096\13\2\3\3\3\3\7\3\u009a"+
		"\n\3\f\3\16\3\u009d\13\3\7\3\u009f\n\3\f\3\16\3\u00a2\13\3\3\4\3\4\7\4"+
		"\u00a6\n\4\f\4\16\4\u00a9\13\4\7\4\u00ab\n\4\f\4\16\4\u00ae\13\4\3\5\3"+
		"\5\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\5\13\u00c0"+
		"\n\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\6\17\u00c9\n\17\r\17\16\17\u00ca"+
		"\3\20\3\20\7\20\u00cf\n\20\f\20\16\20\u00d2\13\20\3\20\3\20\7\20\u00d6"+
		"\n\20\f\20\16\20\u00d9\13\20\3\21\3\21\5\21\u00dd\n\21\3\21\3\21\3\21"+
		"\5\21\u00e2\n\21\7\21\u00e4\n\21\f\21\16\21\u00e7\13\21\3\22\3\22\3\22"+
		"\7\22\u00ec\n\22\f\22\16\22\u00ef\13\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\7\24\u00fa\n\24\f\24\16\24\u00fd\13\24\3\25\3\25\5\25"+
		"\u0101\n\25\3\26\3\26\7\26\u0105\n\26\f\26\16\26\u0108\13\26\3\27\3\27"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\35"+
		"\3\35\7\35\u011b\n\35\f\35\16\35\u011e\13\35\5\35\u0120\n\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\5\35\u0128\n\35\3\36\3\36\3\36\3\36\3\36\7\36\u012f"+
		"\n\36\f\36\16\36\u0132\13\36\5\36\u0134\n\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\5\36\u013f\n\36\3\37\3\37\3\37\3\37\3\37\3\37\5\37"+
		"\u0147\n\37\3\37\3\37\3\37\3\37\7\37\u014d\n\37\f\37\16\37\u0150\13\37"+
		"\5\37\u0152\n\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37"+
		"\u015e\n\37\3\37\3\37\3\37\5\37\u0163\n\37\3\37\3\37\7\37\u0167\n\37\f"+
		"\37\16\37\u016a\13\37\3 \5 \u016d\n \3 \3 \3 \3 \3 \7 \u0174\n \f \16"+
		" \u0177\13 \5 \u0179\n \3 \3 \3 \3 \3 \5 \u0180\n \3 \3 \5 \u0184\n \3"+
		" \3 \3 \5 \u0189\n \3!\3!\3!\3!\3!\7!\u0190\n!\f!\16!\u0193\13!\5!\u0195"+
		"\n!\3!\3!\3!\3!\3!\5!\u019c\n!\3!\3!\3!\3!\3!\5!\u01a3\n!\3\"\3\"\3\""+
		"\5\"\u01a8\n\"\3\"\3\"\3\"\3\"\7\"\u01ae\n\"\f\"\16\"\u01b1\13\"\5\"\u01b3"+
		"\n\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u01c0\n\"\3\"\3\""+
		"\3\"\5\"\u01c5\n\"\3\"\3\"\7\"\u01c9\n\"\f\"\16\"\u01cc\13\"\3#\3#\5#"+
		"\u01d0\n#\3$\3$\3$\3$\3%\3%\3%\3%\3%\5%\u01db\n%\3%\3%\3&\3&\3&\3&\3&"+
		"\3\'\3\'\3\'\3(\3(\5(\u01e9\n(\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*"+
		"\3*\3*\3*\3*\3*\3*\3*\5*\u01ff\n*\3*\3*\3*\3*\3*\3*\3*\7*\u0208\n*\f*"+
		"\16*\u020b\13*\3+\3+\3,\5,\u0210\n,\3,\3,\3-\3-\3-\3-\3-\5-\u0219\n-\3"+
		".\3.\3/\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\5\61\u0226\n\61\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\3\63\7\63\u0230\n\63\f\63\16\63\u0233\13\63"+
		"\3\63\3\63\5\63\u0237\n\63\3\63\5\63\u023a\n\63\3\63\2\5<BR\64\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVX"+
		"Z\\^`bd\2\b\3\2\'(\3\2&\'\3\2$%\5\2\23\23\32\33!#\4\2\31\31\34 \3\2\36"+
		"\37\u025a\2i\3\2\2\2\4\u00a0\3\2\2\2\6\u00ac\3\2\2\2\b\u00af\3\2\2\2\n"+
		"\u00b1\3\2\2\2\f\u00b4\3\2\2\2\16\u00b6\3\2\2\2\20\u00b8\3\2\2\2\22\u00ba"+
		"\3\2\2\2\24\u00bf\3\2\2\2\26\u00c1\3\2\2\2\30\u00c3\3\2\2\2\32\u00c5\3"+
		"\2\2\2\34\u00c8\3\2\2\2\36\u00cc\3\2\2\2 \u00dc\3\2\2\2\"\u00e8\3\2\2"+
		"\2$\u00f0\3\2\2\2&\u00f6\3\2\2\2(\u0100\3\2\2\2*\u0102\3\2\2\2,\u0109"+
		"\3\2\2\2.\u010b\3\2\2\2\60\u010d\3\2\2\2\62\u010f\3\2\2\2\64\u0111\3\2"+
		"\2\2\66\u0113\3\2\2\28\u0127\3\2\2\2:\u013e\3\2\2\2<\u015d\3\2\2\2>\u0188"+
		"\3\2\2\2@\u01a2\3\2\2\2B\u01bf\3\2\2\2D\u01cf\3\2\2\2F\u01d1\3\2\2\2H"+
		"\u01d5\3\2\2\2J\u01de\3\2\2\2L\u01e3\3\2\2\2N\u01e8\3\2\2\2P\u01ea\3\2"+
		"\2\2R\u01fe\3\2\2\2T\u020c\3\2\2\2V\u020f\3\2\2\2X\u0218\3\2\2\2Z\u021a"+
		"\3\2\2\2\\\u021c\3\2\2\2^\u021f\3\2\2\2`\u0225\3\2\2\2b\u0227\3\2\2\2"+
		"d\u0231\3\2\2\2fh\7\6\2\2gf\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2jx\3"+
		"\2\2\2ki\3\2\2\2lp\5H%\2mo\7\6\2\2nm\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2"+
		"\2\2qt\3\2\2\2rp\3\2\2\2sl\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2vy\3\2"+
		"\2\2wu\3\2\2\2xu\3\2\2\2xy\3\2\2\2y\u0089\3\2\2\2z}\5N(\2{}\5P)\2|z\3"+
		"\2\2\2|{\3\2\2\2}\u0081\3\2\2\2~\u0080\7\6\2\2\177~\3\2\2\2\u0080\u0083"+
		"\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0085\3\2\2\2\u0083"+
		"\u0081\3\2\2\2\u0084|\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2"+
		"\u0086\u0087\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u0086"+
		"\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u0094\3\2\2\2\u008b\u008f\5`\61\2\u008c"+
		"\u008e\7\6\2\2\u008d\u008c\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2"+
		"\2\2\u008f\u0090\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0092"+
		"\u008b\3\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2"+
		"\2\2\u0095\3\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u009b\5d\63\2\u0098\u009a"+
		"\7\6\2\2\u0099\u0098\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b"+
		"\u009c\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u0097\3\2"+
		"\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1"+
		"\5\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a7\5V,\2\u00a4\u00a6\7\6\2\2\u00a5"+
		"\u00a4\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2"+
		"\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00a3\3\2\2\2\u00ab"+
		"\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\7\3\2\2\2"+
		"\u00ae\u00ac\3\2\2\2\u00af\u00b0\t\2\2\2\u00b0\t\3\2\2\2\u00b1\u00b2\7"+
		"\32\2\2\u00b2\u00b3\5\16\b\2\u00b3\13\3\2\2\2\u00b4\u00b5\t\3\2\2\u00b5"+
		"\r\3\2\2\2\u00b6\u00b7\7&\2\2\u00b7\17\3\2\2\2\u00b8\u00b9\t\4\2\2\u00b9"+
		"\21\3\2\2\2\u00ba\u00bb\5\f\7\2\u00bb\u00bc\7\22\2\2\u00bc\23\3\2\2\2"+
		"\u00bd\u00c0\5\f\7\2\u00be\u00c0\5\22\n\2\u00bf\u00bd\3\2\2\2\u00bf\u00be"+
		"\3\2\2\2\u00c0\25\3\2\2\2\u00c1\u00c2\5\20\t\2\u00c2\27\3\2\2\2\u00c3"+
		"\u00c4\5\20\t\2\u00c4\31\3\2\2\2\u00c5\u00c6\7$\2\2\u00c6\33\3\2\2\2\u00c7"+
		"\u00c9\7\6\2\2\u00c8\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00c8\3\2"+
		"\2\2\u00ca\u00cb\3\2\2\2\u00cb\35\3\2\2\2\u00cc\u00d0\5\b\5\2\u00cd\u00cf"+
		"\7\6\2\2\u00ce\u00cd\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0"+
		"\u00d1\3\2\2\2\u00d1\u00d7\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00d4\7\21"+
		"\2\2\u00d4\u00d6\5\b\5\2\u00d5\u00d3\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7"+
		"\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\37\3\2\2\2\u00d9\u00d7\3\2\2"+
		"\2\u00da\u00dd\5\16\b\2\u00db\u00dd\5\n\6\2\u00dc\u00da\3\2\2\2\u00dc"+
		"\u00db\3\2\2\2\u00dd\u00e5\3\2\2\2\u00de\u00e1\7\21\2\2\u00df\u00e2\5"+
		"\16\b\2\u00e0\u00e2\5\n\6\2\u00e1\u00df\3\2\2\2\u00e1\u00e0\3\2\2\2\u00e2"+
		"\u00e4\3\2\2\2\u00e3\u00de\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5\u00e3\3\2"+
		"\2\2\u00e5\u00e6\3\2\2\2\u00e6!\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00ed"+
		"\5\24\13\2\u00e9\u00ea\7\21\2\2\u00ea\u00ec\5\24\13\2\u00eb\u00e9\3\2"+
		"\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee"+
		"#\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00f1\5\26\f\2\u00f1\u00f2\7\21\2"+
		"\2\u00f2\u00f3\7\r\2\2\u00f3\u00f4\7\21\2\2\u00f4\u00f5\5\30\r\2\u00f5"+
		"%\3\2\2\2\u00f6\u00fb\5\20\t\2\u00f7\u00f8\7\21\2\2\u00f8\u00fa\5\20\t"+
		"\2\u00f9\u00f7\3\2\2\2\u00fa\u00fd\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc"+
		"\3\2\2\2\u00fc\'\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fe\u0101\5$\23\2\u00ff"+
		"\u0101\5&\24\2\u0100\u00fe\3\2\2\2\u0100\u00ff\3\2\2\2\u0101)\3\2\2\2"+
		"\u0102\u0106\7\24\2\2\u0103\u0105\7\6\2\2\u0104\u0103\3\2\2\2\u0105\u0108"+
		"\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107+\3\2\2\2\u0108"+
		"\u0106\3\2\2\2\u0109\u010a\7\31\2\2\u010a-\3\2\2\2\u010b\u010c\5\f\7\2"+
		"\u010c/\3\2\2\2\u010d\u010e\t\5\2\2\u010e\61\3\2\2\2\u010f\u0110\7!\2"+
		"\2\u0110\63\3\2\2\2\u0111\u0112\5\f\7\2\u0112\65\3\2\2\2\u0113\u0114\t"+
		"\6\2\2\u0114\67\3\2\2\2\u0115\u0116\5\64\33\2\u0116\u011f\7\7\2\2\u0117"+
		"\u011c\5<\37\2\u0118\u0119\7\21\2\2\u0119\u011b\5<\37\2\u011a\u0118\3"+
		"\2\2\2\u011b\u011e\3\2\2\2\u011c\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d"+
		"\u0120\3\2\2\2\u011e\u011c\3\2\2\2\u011f\u0117\3\2\2\2\u011f\u0120\3\2"+
		"\2\2\u0120\u0121\3\2\2\2\u0121\u0122\7\b\2\2\u0122\u0128\3\2\2\2\u0123"+
		"\u0124\5<\37\2\u0124\u0125\5\66\34\2\u0125\u0126\5<\37\2\u0126\u0128\3"+
		"\2\2\2\u0127\u0115\3\2\2\2\u0127\u0123\3\2\2\2\u01289\3\2\2\2\u0129\u012a"+
		"\5.\30\2\u012a\u0133\7\7\2\2\u012b\u0130\5<\37\2\u012c\u012d\7\21\2\2"+
		"\u012d\u012f\5<\37\2\u012e\u012c\3\2\2\2\u012f\u0132\3\2\2\2\u0130\u012e"+
		"\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0134\3\2\2\2\u0132\u0130\3\2\2\2\u0133"+
		"\u012b\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0136\7\b"+
		"\2\2\u0136\u013f\3\2\2\2\u0137\u0138\5<\37\2\u0138\u0139\5\60\31\2\u0139"+
		"\u013a\5<\37\2\u013a\u013f\3\2\2\2\u013b\u013c\5\62\32\2\u013c\u013d\5"+
		"<\37\2\u013d\u013f\3\2\2\2\u013e\u0129\3\2\2\2\u013e\u0137\3\2\2\2\u013e"+
		"\u013b\3\2\2\2\u013f;\3\2\2\2\u0140\u0141\b\37\1\2\u0141\u0142\5\62\32"+
		"\2\u0142\u0143\5<\37\b\u0143\u015e\3\2\2\2\u0144\u0147\5\64\33\2\u0145"+
		"\u0147\5.\30\2\u0146\u0144\3\2\2\2\u0146\u0145\3\2\2\2\u0147\u0148\3\2"+
		"\2\2\u0148\u0151\7\7\2\2\u0149\u014e\5<\37\2\u014a\u014b\7\21\2\2\u014b"+
		"\u014d\5<\37\2\u014c\u014a\3\2\2\2\u014d\u0150\3\2\2\2\u014e\u014c\3\2"+
		"\2\2\u014e\u014f\3\2\2\2\u014f\u0152\3\2\2\2\u0150\u014e\3\2\2\2\u0151"+
		"\u0149\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0154\7\b"+
		"\2\2\u0154\u015e\3\2\2\2\u0155\u015e\5\16\b\2\u0156\u015e\5\n\6\2\u0157"+
		"\u015e\5\b\5\2\u0158\u015e\5\20\t\2\u0159\u015a\7\7\2\2\u015a\u015b\5"+
		"<\37\2\u015b\u015c\7\b\2\2\u015c\u015e\3\2\2\2\u015d\u0140\3\2\2\2\u015d"+
		"\u0146\3\2\2\2\u015d\u0155\3\2\2\2\u015d\u0156\3\2\2\2\u015d\u0157\3\2"+
		"\2\2\u015d\u0158\3\2\2\2\u015d\u0159\3\2\2\2\u015e\u0168\3\2\2\2\u015f"+
		"\u0162\f\t\2\2\u0160\u0163\5\66\34\2\u0161\u0163\5\60\31\2\u0162\u0160"+
		"\3\2\2\2\u0162\u0161\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0165\5<\37\n\u0165"+
		"\u0167\3\2\2\2\u0166\u015f\3\2\2\2\u0167\u016a\3\2\2\2\u0168\u0166\3\2"+
		"\2\2\u0168\u0169\3\2\2\2\u0169=\3\2\2\2\u016a\u0168\3\2\2\2\u016b\u016d"+
		"\7\22\2\2\u016c\u016b\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u0183\3\2\2\2"+
		"\u016e\u016f\5\64\33\2\u016f\u0178\7\7\2\2\u0170\u0175\5B\"\2\u0171\u0172"+
		"\7\21\2\2\u0172\u0174\5B\"\2\u0173\u0171\3\2\2\2\u0174\u0177\3\2\2\2\u0175"+
		"\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0179\3\2\2\2\u0177\u0175\3\2"+
		"\2\2\u0178\u0170\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017a\3\2\2\2\u017a"+
		"\u017b\7\b\2\2\u017b\u0184\3\2\2\2\u017c\u017f\5B\"\2\u017d\u0180\5\66"+
		"\34\2\u017e\u0180\5\60\31\2\u017f\u017d\3\2\2\2\u017f\u017e\3\2\2\2\u0180"+
		"\u0181\3\2\2\2\u0181\u0182\5B\"\2\u0182\u0184\3\2\2\2\u0183\u016e\3\2"+
		"\2\2\u0183\u017c\3\2\2\2\u0184\u0189\3\2\2\2\u0185\u0186\5\62\32\2\u0186"+
		"\u0187\5<\37\2\u0187\u0189\3\2\2\2\u0188\u016c\3\2\2\2\u0188\u0185\3\2"+
		"\2\2\u0189?\3\2\2\2\u018a\u018b\5.\30\2\u018b\u0194\7\7\2\2\u018c\u0191"+
		"\5B\"\2\u018d\u018e\7\21\2\2\u018e\u0190\5B\"\2\u018f\u018d\3\2\2\2\u0190"+
		"\u0193\3\2\2\2\u0191\u018f\3\2\2\2\u0191\u0192\3\2\2\2\u0192\u0195\3\2"+
		"\2\2\u0193\u0191\3\2\2\2\u0194\u018c\3\2\2\2\u0194\u0195\3\2\2\2\u0195"+
		"\u0196\3\2\2\2\u0196\u0197\7\b\2\2\u0197\u01a3\3\2\2\2\u0198\u019b\5B"+
		"\"\2\u0199\u019c\5\66\34\2\u019a\u019c\5\60\31\2\u019b\u0199\3\2\2\2\u019b"+
		"\u019a\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u019e\5B\"\2\u019e\u01a3\3\2"+
		"\2\2\u019f\u01a0\5\62\32\2\u01a0\u01a1\5<\37\2\u01a1\u01a3\3\2\2\2\u01a2"+
		"\u018a\3\2\2\2\u01a2\u0198\3\2\2\2\u01a2\u019f\3\2\2\2\u01a3A\3\2\2\2"+
		"\u01a4\u01a7\b\"\1\2\u01a5\u01a8\5\64\33\2\u01a6\u01a8\5.\30\2\u01a7\u01a5"+
		"\3\2\2\2\u01a7\u01a6\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01b2\7\7\2\2\u01aa"+
		"\u01af\5B\"\2\u01ab\u01ac\7\21\2\2\u01ac\u01ae\5B\"\2\u01ad\u01ab\3\2"+
		"\2\2\u01ae\u01b1\3\2\2\2\u01af\u01ad\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0"+
		"\u01b3\3\2\2\2\u01b1\u01af\3\2\2\2\u01b2\u01aa\3\2\2\2\u01b2\u01b3\3\2"+
		"\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01b5\7\b\2\2\u01b5\u01c0\3\2\2\2\u01b6"+
		"\u01b7\5\62\32\2\u01b7\u01b8\5<\37\2\u01b8\u01c0\3\2\2\2\u01b9\u01c0\5"+
		"\b\5\2\u01ba\u01c0\5\20\t\2\u01bb\u01bc\7\7\2\2\u01bc\u01bd\5B\"\2\u01bd"+
		"\u01be\7\b\2\2\u01be\u01c0\3\2\2\2\u01bf\u01a4\3\2\2\2\u01bf\u01b6\3\2"+
		"\2\2\u01bf\u01b9\3\2\2\2\u01bf\u01ba\3\2\2\2\u01bf\u01bb\3\2\2\2\u01c0"+
		"\u01ca\3\2\2\2\u01c1\u01c4\f\7\2\2\u01c2\u01c5\5\66\34\2\u01c3\u01c5\5"+
		"\60\31\2\u01c4\u01c2\3\2\2\2\u01c4\u01c3\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6"+
		"\u01c7\5B\"\b\u01c7\u01c9\3\2\2\2\u01c8\u01c1\3\2\2\2\u01c9\u01cc\3\2"+
		"\2\2\u01ca\u01c8\3\2\2\2\u01ca\u01cb\3\2\2\2\u01cbC\3\2\2\2\u01cc\u01ca"+
		"\3\2\2\2\u01cd\u01d0\5\b\5\2\u01ce\u01d0\5\20\t\2\u01cf\u01cd\3\2\2\2"+
		"\u01cf\u01ce\3\2\2\2\u01d0E\3\2\2\2\u01d1\u01d2\5D#\2\u01d2\u01d3\7\31"+
		"\2\2\u01d3\u01d4\5@!\2\u01d4G\3\2\2\2\u01d5\u01d6\5\24\13\2\u01d6\u01d7"+
		"\7\31\2\2\u01d7\u01da\7\t\2\2\u01d8\u01db\5\36\20\2\u01d9\u01db\5(\25"+
		"\2\u01da\u01d8\3\2\2\2\u01da\u01d9\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc\u01dd"+
		"\7\n\2\2\u01ddI\3\2\2\2\u01de\u01df\5\64\33\2\u01df\u01e0\7\7\2\2\u01e0"+
		"\u01e1\5\"\22\2\u01e1\u01e2\7\b\2\2\u01e2K\3\2\2\2\u01e3\u01e4\7\33\2"+
		"\2\u01e4\u01e5\5J&\2\u01e5M\3\2\2\2\u01e6\u01e9\5L\'\2\u01e7\u01e9\5J"+
		"&\2\u01e8\u01e6\3\2\2\2\u01e8\u01e7\3\2\2\2\u01e9O\3\2\2\2\u01ea\u01eb"+
		"\5\24\13\2\u01eb\u01ec\5.\30\2\u01ec\u01ed\7\7\2\2\u01ed\u01ee\5\"\22"+
		"\2\u01ee\u01ef\7\b\2\2\u01efQ\3\2\2\2\u01f0\u01f1\b*\1\2\u01f1\u01f2\7"+
		"\22\2\2\u01f2\u01ff\5R*\6\u01f3\u01ff\58\35\2\u01f4\u01ff\5:\36\2\u01f5"+
		"\u01f6\7\13\2\2\u01f6\u01f7\5R*\2\u01f7\u01f8\7\f\2\2\u01f8\u01ff\3\2"+
		"\2\2\u01f9\u01fa\7\7\2\2\u01fa\u01fb\5R*\2\u01fb\u01fc\7\b\2\2\u01fc\u01ff"+
		"\3\2\2\2\u01fd\u01ff\5b\62\2\u01fe\u01f0\3\2\2\2\u01fe\u01f3\3\2\2\2\u01fe"+
		"\u01f4\3\2\2\2\u01fe\u01f5\3\2\2\2\u01fe\u01f9\3\2\2\2\u01fe\u01fd\3\2"+
		"\2\2\u01ff\u0209\3\2\2\2\u0200\u0201\f\5\2\2\u0201\u0202\7\31\2\2\u0202"+
		"\u0208\5R*\6\u0203\u0204\f\4\2\2\u0204\u0205\5*\26\2\u0205\u0206\5R*\5"+
		"\u0206\u0208\3\2\2\2\u0207\u0200\3\2\2\2\u0207\u0203\3\2\2\2\u0208\u020b"+
		"\3\2\2\2\u0209\u0207\3\2\2\2\u0209\u020a\3\2\2\2\u020aS\3\2\2\2\u020b"+
		"\u0209\3\2\2\2\u020c\u020d\t\4\2\2\u020dU\3\2\2\2\u020e\u0210\5T+\2\u020f"+
		"\u020e\3\2\2\2\u020f\u0210\3\2\2\2\u0210\u0211\3\2\2\2\u0211\u0212\5d"+
		"\63\2\u0212W\3\2\2\2\u0213\u0219\7$\2\2\u0214\u0219\7%\2\2\u0215\u0216"+
		"\5\16\b\2\u0216\u0217\7\20\2\2\u0217\u0219\3\2\2\2\u0218\u0213\3\2\2\2"+
		"\u0218\u0214\3\2\2\2\u0218\u0215\3\2\2\2\u0219Y\3\2\2\2\u021a\u021b\5"+
		"X-\2\u021b[\3\2\2\2\u021c\u021d\5Z.\2\u021d\u021e\5R*\2\u021e]\3\2\2\2"+
		"\u021f\u0220\5R*\2\u0220\u0221\7\16\2\2\u0221_\3\2\2\2\u0222\u0226\5R"+
		"*\2\u0223\u0226\5\\/\2\u0224\u0226\5^\60\2\u0225\u0222\3\2\2\2\u0225\u0223"+
		"\3\2\2\2\u0225\u0224\3\2\2\2\u0226a\3\2\2\2\u0227\u0228\7\17\2\2\u0228"+
		"\u0229\5 \21\2\u0229\u022a\7\17\2\2\u022a\u022b\5R*\2\u022b\u022c\t\7"+
		"\2\2\u022c\u022d\5\32\16\2\u022dc\3\2\2\2\u022e\u0230\7\6\2\2\u022f\u022e"+
		"\3\2\2\2\u0230\u0233\3\2\2\2\u0231\u022f\3\2\2\2\u0231\u0232\3\2\2\2\u0232"+
		"\u0236\3\2\2\2\u0233\u0231\3\2\2\2\u0234\u0237\5> \2\u0235\u0237\5F$\2"+
		"\u0236\u0234\3\2\2\2\u0236\u0235\3\2\2\2\u0237\u0239\3\2\2\2\u0238\u023a"+
		"\7\6\2\2\u0239\u0238\3\2\2\2\u0239\u023a\3\2\2\2\u023ae\3\2\2\2Cipux|"+
		"\u0081\u0086\u0089\u008f\u0094\u009b\u00a0\u00a7\u00ac\u00bf\u00ca\u00d0"+
		"\u00d7\u00dc\u00e1\u00e5\u00ed\u00fb\u0100\u0106\u011c\u011f\u0127\u0130"+
		"\u0133\u013e\u0146\u014e\u0151\u015d\u0162\u0168\u016c\u0175\u0178\u017f"+
		"\u0183\u0188\u0191\u0194\u019b\u01a2\u01a7\u01af\u01b2\u01bf\u01c4\u01ca"+
		"\u01cf\u01da\u01e8\u01fe\u0207\u0209\u020f\u0218\u0225\u0231\u0236\u0239";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}