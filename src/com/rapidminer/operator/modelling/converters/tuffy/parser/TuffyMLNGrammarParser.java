// Generated from TuffyMLNGrammar.g4 by ANTLR 4.2
package com.rapidminer.operator.modelling.converters.tuffy.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TuffyMLNGrammarParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WEIGHT_OF_LAST=1, LINE_COMMENT=2, COMMENT=3, WS=4, NL=5, LP=6, RP=7, LCP=8, 
		RCP=9, LSP=10, RSP=11, DOTS=12, DOT=13, BAR=14, COL=15, COM=16, EXCL=17, 
		AND=18, OR=19, IMPLIES=20, IFF=21, U_QUANT=22, E_QUANT=23, EQ=24, PLUS=25, 
		STAR=26, GT=27, LT=28, GE=29, LE=30, NE=31, MINUS=32, SLASH=33, MOD=34, 
		INT=35, FLOAT=36, VAR_ID=37, CONST_ID=38, STRING=39;
	public static final String[] tokenNames = {
		"<INVALID>", "WEIGHT_OF_LAST", "LINE_COMMENT", "COMMENT", "WS", "NL", 
		"'('", "')'", "'{'", "'}'", "'['", "']'", "'...'", "'.'", "'|'", "':'", 
		"','", "'!'", "'^'", "'v'", "'=>'", "'<=>'", "U_QUANT", "E_QUANT", "'='", 
		"'+'", "'*'", "'>'", "'<'", "'>='", "'<='", "'!='", "'-'", "'/'", "'%'", 
		"INT", "FLOAT", "VAR_ID", "CONST_ID", "STRING"
	};
	public static final int
		RULE_ruleFile = 0, RULE_dbFile = 1, RULE_infFile = 2, RULE_queryFile = 3, 
		RULE_constant = 4, RULE_expVariable = 5, RULE_variableLabel = 6, RULE_variable = 7, 
		RULE_number = 8, RULE_exclType = 9, RULE_type = 10, RULE_startNum = 11, 
		RULE_endNum = 12, RULE_cardinality = 13, RULE_constantList = 14, RULE_variableList = 15, 
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
		RULE_quantifier = 48, RULE_quantification = 49, RULE_groundFormula = 50;
	public static final String[] ruleNames = {
		"ruleFile", "dbFile", "infFile", "queryFile", "constant", "expVariable", 
		"variableLabel", "variable", "number", "exclType", "type", "startNum", 
		"endNum", "cardinality", "constantList", "variableList", "typeList", "exNumList", 
		"plainNumList", "numList", "or", "eq", "function", "builtinFunctionSymbol", 
		"builtinPrefixFunctionSymbol", "predicate", "builtinPredicateSymbol", 
		"predicateApplication", "functionApplication", "argument", "groundPredicateApplication", 
		"groundFunctionApplication", "groundArgument", "returnValue", "functionDef", 
		"typeDecl", "plainPredicate", "closedWorldPredicate", "predicateDecl", 
		"functionDecl", "plainFormula", "probability", "probabilityStatement", 
		"weight", "weights", "weightedFormula", "hardFormula", "formula", "quantifier", 
		"quantification", "groundFormula"
	};

	@Override
	public String getGrammarFileName() { return "TuffyMLNGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TuffyMLNGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RuleFileContext extends ParserRuleContext {
		public List<TerminalNode> NL() { return getTokens(TuffyMLNGrammarParser.NL); }
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
			return getToken(TuffyMLNGrammarParser.NL, i);
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
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterRuleFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitRuleFile(this);
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
			setState(148);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
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
							switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
							case 1:
								{
								setState(121); predicateDecl();
								}
								break;

							case 2:
								{
								setState(122); functionDecl();
								}
								break;
							}
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
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << LSP) | (1L << EXCL) | (1L << U_QUANT) | (1L << E_QUANT) | (1L << PLUS) | (1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << VAR_ID) | (1L << CONST_ID) | (1L << STRING))) != 0)) {
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

	public static class DbFileContext extends ParserRuleContext {
		public List<TerminalNode> NL() { return getTokens(TuffyMLNGrammarParser.NL); }
		public GroundFormulaContext groundFormula(int i) {
			return getRuleContext(GroundFormulaContext.class,i);
		}
		public List<GroundFormulaContext> groundFormula() {
			return getRuleContexts(GroundFormulaContext.class);
		}
		public TerminalNode NL(int i) {
			return getToken(TuffyMLNGrammarParser.NL, i);
		}
		public DbFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dbFile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterDbFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitDbFile(this);
		}
	}

	public final DbFileContext dbFile() throws RecognitionException {
		DbFileContext _localctx = new DbFileContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dbFile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << EXCL) | (1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << VAR_ID) | (1L << CONST_ID) | (1L << STRING))) != 0)) {
				{
				{
				setState(150); groundFormula();
				setState(152); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(151); match(NL);
					}
					}
					setState(154); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NL );
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
		public List<TerminalNode> NL() { return getTokens(TuffyMLNGrammarParser.NL); }
		public ProbabilityStatementContext probabilityStatement(int i) {
			return getRuleContext(ProbabilityStatementContext.class,i);
		}
		public TerminalNode NL(int i) {
			return getToken(TuffyMLNGrammarParser.NL, i);
		}
		public InfFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_infFile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterInfFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitInfFile(this);
		}
	}

	public final InfFileContext infFile() throws RecognitionException {
		InfFileContext _localctx = new InfFileContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_infFile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << EXCL) | (1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << VAR_ID) | (1L << CONST_ID) | (1L << STRING))) != 0)) {
				{
				{
				setState(161); probabilityStatement();
				setState(163); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(162); match(NL);
					}
					}
					setState(165); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NL );
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

	public static class QueryFileContext extends ParserRuleContext {
		public List<TerminalNode> NL() { return getTokens(TuffyMLNGrammarParser.NL); }
		public List<PredicateDeclContext> predicateDecl() {
			return getRuleContexts(PredicateDeclContext.class);
		}
		public TerminalNode NL(int i) {
			return getToken(TuffyMLNGrammarParser.NL, i);
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
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterQueryFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitQueryFile(this);
		}
	}

	public final QueryFileContext queryFile() throws RecognitionException {
		QueryFileContext _localctx = new QueryFileContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_queryFile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STAR) | (1L << VAR_ID) | (1L << CONST_ID))) != 0)) {
				{
				{
				setState(172); predicateDecl();
				setState(174); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(173); match(NL);
					}
					}
					setState(176); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NL );
				}
				}
				setState(182);
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
		public TerminalNode STRING() { return getToken(TuffyMLNGrammarParser.STRING, 0); }
		public TerminalNode CONST_ID() { return getToken(TuffyMLNGrammarParser.CONST_ID, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
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
		public TerminalNode PLUS() { return getToken(TuffyMLNGrammarParser.PLUS, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ExpVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterExpVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitExpVariable(this);
		}
	}

	public final ExpVariableContext expVariable() throws RecognitionException {
		ExpVariableContext _localctx = new ExpVariableContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185); match(PLUS);
			setState(186); variable();
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
		public TerminalNode VAR_ID() { return getToken(TuffyMLNGrammarParser.VAR_ID, 0); }
		public TerminalNode CONST_ID() { return getToken(TuffyMLNGrammarParser.CONST_ID, 0); }
		public VariableLabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableLabel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterVariableLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitVariableLabel(this);
		}
	}

	public final VariableLabelContext variableLabel() throws RecognitionException {
		VariableLabelContext _localctx = new VariableLabelContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_variableLabel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
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
		public TerminalNode VAR_ID() { return getToken(TuffyMLNGrammarParser.VAR_ID, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitVariable(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190); match(VAR_ID);
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
		public TerminalNode INT() { return getToken(TuffyMLNGrammarParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(TuffyMLNGrammarParser.FLOAT, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitNumber(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
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
		public TerminalNode EXCL() { return getToken(TuffyMLNGrammarParser.EXCL, 0); }
		public ExclTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exclType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterExclType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitExclType(this);
		}
	}

	public final ExclTypeContext exclType() throws RecognitionException {
		ExclTypeContext _localctx = new ExclTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_exclType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194); variableLabel();
			setState(195); match(EXCL);
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
		public TerminalNode VAR_ID() { return getToken(TuffyMLNGrammarParser.VAR_ID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_type);
		try {
			setState(199);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(197); match(VAR_ID);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(198); exclType();
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
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterStartNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitStartNum(this);
		}
	}

	public final StartNumContext startNum() throws RecognitionException {
		StartNumContext _localctx = new StartNumContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_startNum);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201); number();
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
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterEndNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitEndNum(this);
		}
	}

	public final EndNumContext endNum() throws RecognitionException {
		EndNumContext _localctx = new EndNumContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_endNum);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203); number();
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
		public TerminalNode INT() { return getToken(TuffyMLNGrammarParser.INT, 0); }
		public CardinalityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cardinality; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterCardinality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitCardinality(this);
		}
	}

	public final CardinalityContext cardinality() throws RecognitionException {
		CardinalityContext _localctx = new CardinalityContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_cardinality);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205); match(INT);
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
		public List<ConstantContext> constant() {
			return getRuleContexts(ConstantContext.class);
		}
		public List<TerminalNode> COM() { return getTokens(TuffyMLNGrammarParser.COM); }
		public TerminalNode COM(int i) {
			return getToken(TuffyMLNGrammarParser.COM, i);
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
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterConstantList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitConstantList(this);
		}
	}

	public final ConstantListContext constantList() throws RecognitionException {
		ConstantListContext _localctx = new ConstantListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_constantList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207); constant();
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COM) {
				{
				{
				setState(208); match(COM);
				setState(209); constant();
				}
				}
				setState(214);
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
		public List<TerminalNode> COM() { return getTokens(TuffyMLNGrammarParser.COM); }
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
			return getToken(TuffyMLNGrammarParser.COM, i);
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
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterVariableList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitVariableList(this);
		}
	}

	public final VariableListContext variableList() throws RecognitionException {
		VariableListContext _localctx = new VariableListContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_variableList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			switch (_input.LA(1)) {
			case VAR_ID:
				{
				setState(215); variable();
				}
				break;
			case PLUS:
				{
				setState(216); expVariable();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COM) {
				{
				{
				setState(219); match(COM);
				setState(222);
				switch (_input.LA(1)) {
				case VAR_ID:
					{
					setState(220); variable();
					}
					break;
				case PLUS:
					{
					setState(221); expVariable();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(228);
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
		public List<TerminalNode> COM() { return getTokens(TuffyMLNGrammarParser.COM); }
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TerminalNode COM(int i) {
			return getToken(TuffyMLNGrammarParser.COM, i);
		}
		public TypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitTypeList(this);
		}
	}

	public final TypeListContext typeList() throws RecognitionException {
		TypeListContext _localctx = new TypeListContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_typeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229); type();
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COM) {
				{
				{
				setState(230); match(COM);
				setState(231); type();
				}
				}
				setState(236);
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
		public List<TerminalNode> COM() { return getTokens(TuffyMLNGrammarParser.COM); }
		public TerminalNode DOTS() { return getToken(TuffyMLNGrammarParser.DOTS, 0); }
		public EndNumContext endNum() {
			return getRuleContext(EndNumContext.class,0);
		}
		public TerminalNode COM(int i) {
			return getToken(TuffyMLNGrammarParser.COM, i);
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
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterExNumList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitExNumList(this);
		}
	}

	public final ExNumListContext exNumList() throws RecognitionException {
		ExNumListContext _localctx = new ExNumListContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_exNumList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237); startNum();
			setState(238); match(COM);
			setState(239); match(DOTS);
			setState(240); match(COM);
			setState(241); endNum();
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
		public List<TerminalNode> COM() { return getTokens(TuffyMLNGrammarParser.COM); }
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
		}
		public TerminalNode COM(int i) {
			return getToken(TuffyMLNGrammarParser.COM, i);
		}
		public PlainNumListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plainNumList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterPlainNumList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitPlainNumList(this);
		}
	}

	public final PlainNumListContext plainNumList() throws RecognitionException {
		PlainNumListContext _localctx = new PlainNumListContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_plainNumList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243); number();
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COM) {
				{
				{
				setState(244); match(COM);
				setState(245); number();
				}
				}
				setState(250);
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
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterNumList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitNumList(this);
		}
	}

	public final NumListContext numList() throws RecognitionException {
		NumListContext _localctx = new NumListContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_numList);
		try {
			setState(253);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(251); exNumList();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(252); plainNumList();
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
		public TerminalNode OR() { return getToken(TuffyMLNGrammarParser.OR, 0); }
		public OrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitOr(this);
		}
	}

	public final OrContext or() throws RecognitionException {
		OrContext _localctx = new OrContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255); match(OR);
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
		public TerminalNode EQ() { return getToken(TuffyMLNGrammarParser.EQ, 0); }
		public EqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitEq(this);
		}
	}

	public final EqContext eq() throws RecognitionException {
		EqContext _localctx = new EqContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_eq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257); match(EQ);
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
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259); variableLabel();
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
		public TerminalNode SLASH() { return getToken(TuffyMLNGrammarParser.SLASH, 0); }
		public TerminalNode AND() { return getToken(TuffyMLNGrammarParser.AND, 0); }
		public TerminalNode PLUS() { return getToken(TuffyMLNGrammarParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(TuffyMLNGrammarParser.MINUS, 0); }
		public TerminalNode STAR() { return getToken(TuffyMLNGrammarParser.STAR, 0); }
		public TerminalNode MOD() { return getToken(TuffyMLNGrammarParser.MOD, 0); }
		public BuiltinFunctionSymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtinFunctionSymbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterBuiltinFunctionSymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitBuiltinFunctionSymbol(this);
		}
	}

	public final BuiltinFunctionSymbolContext builtinFunctionSymbol() throws RecognitionException {
		BuiltinFunctionSymbolContext _localctx = new BuiltinFunctionSymbolContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_builtinFunctionSymbol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
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
		public TerminalNode MINUS() { return getToken(TuffyMLNGrammarParser.MINUS, 0); }
		public BuiltinPrefixFunctionSymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtinPrefixFunctionSymbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterBuiltinPrefixFunctionSymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitBuiltinPrefixFunctionSymbol(this);
		}
	}

	public final BuiltinPrefixFunctionSymbolContext builtinPrefixFunctionSymbol() throws RecognitionException {
		BuiltinPrefixFunctionSymbolContext _localctx = new BuiltinPrefixFunctionSymbolContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_builtinPrefixFunctionSymbol);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263); match(MINUS);
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
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitPredicate(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_predicate);
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

	public static class BuiltinPredicateSymbolContext extends ParserRuleContext {
		public TerminalNode GE() { return getToken(TuffyMLNGrammarParser.GE, 0); }
		public TerminalNode LT() { return getToken(TuffyMLNGrammarParser.LT, 0); }
		public TerminalNode GT() { return getToken(TuffyMLNGrammarParser.GT, 0); }
		public TerminalNode LE() { return getToken(TuffyMLNGrammarParser.LE, 0); }
		public TerminalNode EQ() { return getToken(TuffyMLNGrammarParser.EQ, 0); }
		public TerminalNode NE() { return getToken(TuffyMLNGrammarParser.NE, 0); }
		public BuiltinPredicateSymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtinPredicateSymbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterBuiltinPredicateSymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitBuiltinPredicateSymbol(this);
		}
	}

	public final BuiltinPredicateSymbolContext builtinPredicateSymbol() throws RecognitionException {
		BuiltinPredicateSymbolContext _localctx = new BuiltinPredicateSymbolContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_builtinPredicateSymbol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
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
		public TerminalNode RP() { return getToken(TuffyMLNGrammarParser.RP, 0); }
		public BuiltinPredicateSymbolContext builtinPredicateSymbol() {
			return getRuleContext(BuiltinPredicateSymbolContext.class,0);
		}
		public List<TerminalNode> COM() { return getTokens(TuffyMLNGrammarParser.COM); }
		public TerminalNode LP() { return getToken(TuffyMLNGrammarParser.LP, 0); }
		public TerminalNode COM(int i) {
			return getToken(TuffyMLNGrammarParser.COM, i);
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
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterPredicateApplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitPredicateApplication(this);
		}
	}

	public final PredicateApplicationContext predicateApplication() throws RecognitionException {
		PredicateApplicationContext _localctx = new PredicateApplicationContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_predicateApplication);
		int _la;
		try {
			setState(287);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(269); predicate();
				setState(270); match(LP);
				setState(279);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << PLUS) | (1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << VAR_ID) | (1L << CONST_ID) | (1L << STRING))) != 0)) {
					{
					setState(271); argument(0);
					setState(276);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COM) {
						{
						{
						setState(272); match(COM);
						setState(273); argument(0);
						}
						}
						setState(278);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(281); match(RP);
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(283); argument(0);
				setState(284); builtinPredicateSymbol();
				setState(285); argument(0);
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
		public TerminalNode RP() { return getToken(TuffyMLNGrammarParser.RP, 0); }
		public BuiltinPrefixFunctionSymbolContext builtinPrefixFunctionSymbol() {
			return getRuleContext(BuiltinPrefixFunctionSymbolContext.class,0);
		}
		public List<TerminalNode> COM() { return getTokens(TuffyMLNGrammarParser.COM); }
		public TerminalNode LP() { return getToken(TuffyMLNGrammarParser.LP, 0); }
		public TerminalNode COM(int i) {
			return getToken(TuffyMLNGrammarParser.COM, i);
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
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterFunctionApplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitFunctionApplication(this);
		}
	}

	public final FunctionApplicationContext functionApplication() throws RecognitionException {
		FunctionApplicationContext _localctx = new FunctionApplicationContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_functionApplication);
		int _la;
		try {
			setState(310);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(289); function();
				setState(290); match(LP);
				setState(299);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << PLUS) | (1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << VAR_ID) | (1L << CONST_ID) | (1L << STRING))) != 0)) {
					{
					setState(291); argument(0);
					setState(296);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COM) {
						{
						{
						setState(292); match(COM);
						setState(293); argument(0);
						}
						}
						setState(298);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(301); match(RP);
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(303); argument(0);
				setState(304); builtinFunctionSymbol();
				setState(305); argument(0);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(307); builtinPrefixFunctionSymbol();
				setState(308); argument(0);
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
		public TerminalNode RP() { return getToken(TuffyMLNGrammarParser.RP, 0); }
		public List<TerminalNode> COM() { return getTokens(TuffyMLNGrammarParser.COM); }
		public ExpVariableContext expVariable() {
			return getRuleContext(ExpVariableContext.class,0);
		}
		public TerminalNode COM(int i) {
			return getToken(TuffyMLNGrammarParser.COM, i);
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
		public TerminalNode LP() { return getToken(TuffyMLNGrammarParser.LP, 0); }
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
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitArgument(this);
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
			setState(341);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(313); builtinPrefixFunctionSymbol();
				setState(314); argument(6);
				}
				break;

			case 2:
				{
				{
				setState(318);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(316); predicate();
					}
					break;

				case 2:
					{
					setState(317); function();
					}
					break;
				}
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

			case 3:
				{
				setState(333); variable();
				}
				break;

			case 4:
				{
				setState(334); expVariable();
				}
				break;

			case 5:
				{
				setState(335); constant();
				}
				break;

			case 6:
				{
				setState(336); number();
				}
				break;

			case 7:
				{
				setState(337); match(LP);
				setState(338); argument(0);
				setState(339); match(RP);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(352);
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
					setState(343);
					if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
					setState(346);
					switch (_input.LA(1)) {
					case EQ:
					case GT:
					case LT:
					case GE:
					case LE:
					case NE:
						{
						setState(344); builtinPredicateSymbol();
						}
						break;
					case AND:
					case PLUS:
					case STAR:
					case MINUS:
					case SLASH:
					case MOD:
						{
						setState(345); builtinFunctionSymbol();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(348); argument(8);
					}
					} 
				}
				setState(354);
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
		public BuiltinPrefixFunctionSymbolContext builtinPrefixFunctionSymbol() {
			return getRuleContext(BuiltinPrefixFunctionSymbolContext.class,0);
		}
		public TerminalNode RP() { return getToken(TuffyMLNGrammarParser.RP, 0); }
		public GroundArgumentContext groundArgument(int i) {
			return getRuleContext(GroundArgumentContext.class,i);
		}
		public BuiltinPredicateSymbolContext builtinPredicateSymbol() {
			return getRuleContext(BuiltinPredicateSymbolContext.class,0);
		}
		public List<TerminalNode> COM() { return getTokens(TuffyMLNGrammarParser.COM); }
		public TerminalNode LP() { return getToken(TuffyMLNGrammarParser.LP, 0); }
		public TerminalNode EXCL() { return getToken(TuffyMLNGrammarParser.EXCL, 0); }
		public List<GroundArgumentContext> groundArgument() {
			return getRuleContexts(GroundArgumentContext.class);
		}
		public BuiltinFunctionSymbolContext builtinFunctionSymbol() {
			return getRuleContext(BuiltinFunctionSymbolContext.class,0);
		}
		public TerminalNode COM(int i) {
			return getToken(TuffyMLNGrammarParser.COM, i);
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
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterGroundPredicateApplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitGroundPredicateApplication(this);
		}
	}

	public final GroundPredicateApplicationContext groundPredicateApplication() throws RecognitionException {
		GroundPredicateApplicationContext _localctx = new GroundPredicateApplicationContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_groundPredicateApplication);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			_la = _input.LA(1);
			if (_la==EXCL) {
				{
				setState(355); match(EXCL);
				}
			}

			setState(384);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				{
				setState(379);
				switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
				case 1:
					{
					{
					setState(358); predicate();
					setState(359); match(LP);
					setState(368);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << VAR_ID) | (1L << CONST_ID) | (1L << STRING))) != 0)) {
						{
						setState(360); groundArgument(0);
						setState(365);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COM) {
							{
							{
							setState(361); match(COM);
							setState(362); groundArgument(0);
							}
							}
							setState(367);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(370); match(RP);
					}
					}
					break;

				case 2:
					{
					setState(372); groundArgument(0);
					setState(375);
					switch (_input.LA(1)) {
					case EQ:
					case GT:
					case LT:
					case GE:
					case LE:
					case NE:
						{
						setState(373); builtinPredicateSymbol();
						}
						break;
					case AND:
					case PLUS:
					case STAR:
					case MINUS:
					case SLASH:
					case MOD:
						{
						setState(374); builtinFunctionSymbol();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(377); groundArgument(0);
					}
					break;
				}
				}
				break;

			case 2:
				{
				setState(381); builtinPrefixFunctionSymbol();
				setState(382); argument(0);
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
		public TerminalNode RP() { return getToken(TuffyMLNGrammarParser.RP, 0); }
		public BuiltinPrefixFunctionSymbolContext builtinPrefixFunctionSymbol() {
			return getRuleContext(BuiltinPrefixFunctionSymbolContext.class,0);
		}
		public GroundArgumentContext groundArgument(int i) {
			return getRuleContext(GroundArgumentContext.class,i);
		}
		public BuiltinPredicateSymbolContext builtinPredicateSymbol() {
			return getRuleContext(BuiltinPredicateSymbolContext.class,0);
		}
		public List<TerminalNode> COM() { return getTokens(TuffyMLNGrammarParser.COM); }
		public TerminalNode LP() { return getToken(TuffyMLNGrammarParser.LP, 0); }
		public List<GroundArgumentContext> groundArgument() {
			return getRuleContexts(GroundArgumentContext.class);
		}
		public TerminalNode COM(int i) {
			return getToken(TuffyMLNGrammarParser.COM, i);
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
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterGroundFunctionApplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitGroundFunctionApplication(this);
		}
	}

	public final GroundFunctionApplicationContext groundFunctionApplication() throws RecognitionException {
		GroundFunctionApplicationContext _localctx = new GroundFunctionApplicationContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_groundFunctionApplication);
		int _la;
		try {
			setState(410);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(386); function();
				setState(387); match(LP);
				setState(396);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << VAR_ID) | (1L << CONST_ID) | (1L << STRING))) != 0)) {
					{
					setState(388); groundArgument(0);
					setState(393);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COM) {
						{
						{
						setState(389); match(COM);
						setState(390); groundArgument(0);
						}
						}
						setState(395);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(398); match(RP);
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(400); groundArgument(0);
				setState(403);
				switch (_input.LA(1)) {
				case EQ:
				case GT:
				case LT:
				case GE:
				case LE:
				case NE:
					{
					setState(401); builtinPredicateSymbol();
					}
					break;
				case AND:
				case PLUS:
				case STAR:
				case MINUS:
				case SLASH:
				case MOD:
					{
					setState(402); builtinFunctionSymbol();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(405); groundArgument(0);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(407); builtinPrefixFunctionSymbol();
				setState(408); argument(0);
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
		public TerminalNode RP() { return getToken(TuffyMLNGrammarParser.RP, 0); }
		public BuiltinPrefixFunctionSymbolContext builtinPrefixFunctionSymbol() {
			return getRuleContext(BuiltinPrefixFunctionSymbolContext.class,0);
		}
		public GroundArgumentContext groundArgument(int i) {
			return getRuleContext(GroundArgumentContext.class,i);
		}
		public List<TerminalNode> COM() { return getTokens(TuffyMLNGrammarParser.COM); }
		public List<GroundArgumentContext> groundArgument() {
			return getRuleContexts(GroundArgumentContext.class);
		}
		public TerminalNode COM(int i) {
			return getToken(TuffyMLNGrammarParser.COM, i);
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
		public TerminalNode LP() { return getToken(TuffyMLNGrammarParser.LP, 0); }
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
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterGroundArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitGroundArgument(this);
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
			setState(439);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				{
				{
				setState(415);
				switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
				case 1:
					{
					setState(413); predicate();
					}
					break;

				case 2:
					{
					setState(414); function();
					}
					break;
				}
				setState(417); match(LP);
				setState(426);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << MINUS) | (1L << INT) | (1L << FLOAT) | (1L << VAR_ID) | (1L << CONST_ID) | (1L << STRING))) != 0)) {
					{
					setState(418); groundArgument(0);
					setState(423);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COM) {
						{
						{
						setState(419); match(COM);
						setState(420); groundArgument(0);
						}
						}
						setState(425);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(428); match(RP);
				}
				}
				break;

			case 2:
				{
				setState(430); builtinPrefixFunctionSymbol();
				setState(431); argument(0);
				}
				break;

			case 3:
				{
				setState(433); constant();
				}
				break;

			case 4:
				{
				setState(434); number();
				}
				break;

			case 5:
				{
				setState(435); match(LP);
				setState(436); groundArgument(0);
				setState(437); match(RP);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(450);
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
					setState(441);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(444);
					switch (_input.LA(1)) {
					case EQ:
					case GT:
					case LT:
					case GE:
					case LE:
					case NE:
						{
						setState(442); builtinPredicateSymbol();
						}
						break;
					case AND:
					case PLUS:
					case STAR:
					case MINUS:
					case SLASH:
					case MOD:
						{
						setState(443); builtinFunctionSymbol();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(446); groundArgument(6);
					}
					} 
				}
				setState(452);
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
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterReturnValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitReturnValue(this);
		}
	}

	public final ReturnValueContext returnValue() throws RecognitionException {
		ReturnValueContext _localctx = new ReturnValueContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_returnValue);
		try {
			setState(455);
			switch (_input.LA(1)) {
			case CONST_ID:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(453); constant();
				}
				break;
			case INT:
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(454); number();
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
		public TerminalNode EQ() { return getToken(TuffyMLNGrammarParser.EQ, 0); }
		public FunctionDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterFunctionDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitFunctionDef(this);
		}
	}

	public final FunctionDefContext functionDef() throws RecognitionException {
		FunctionDefContext _localctx = new FunctionDefContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_functionDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457); returnValue();
			setState(458); match(EQ);
			setState(459); groundFunctionApplication();
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
		public TerminalNode RCP() { return getToken(TuffyMLNGrammarParser.RCP, 0); }
		public ConstantListContext constantList() {
			return getRuleContext(ConstantListContext.class,0);
		}
		public TerminalNode LCP() { return getToken(TuffyMLNGrammarParser.LCP, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode EQ() { return getToken(TuffyMLNGrammarParser.EQ, 0); }
		public NumListContext numList() {
			return getRuleContext(NumListContext.class,0);
		}
		public TypeDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterTypeDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitTypeDecl(this);
		}
	}

	public final TypeDeclContext typeDecl() throws RecognitionException {
		TypeDeclContext _localctx = new TypeDeclContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_typeDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(461); type();
			setState(462); match(EQ);
			setState(463); match(LCP);
			setState(466);
			switch (_input.LA(1)) {
			case CONST_ID:
			case STRING:
				{
				setState(464); constantList();
				}
				break;
			case INT:
			case FLOAT:
				{
				setState(465); numList();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(468); match(RCP);
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
		public TerminalNode RP() { return getToken(TuffyMLNGrammarParser.RP, 0); }
		public TerminalNode LP() { return getToken(TuffyMLNGrammarParser.LP, 0); }
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
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterPlainPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitPlainPredicate(this);
		}
	}

	public final PlainPredicateContext plainPredicate() throws RecognitionException {
		PlainPredicateContext _localctx = new PlainPredicateContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_plainPredicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(470); predicate();
			setState(471); match(LP);
			setState(472); typeList();
			setState(473); match(RP);
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
		public TerminalNode STAR() { return getToken(TuffyMLNGrammarParser.STAR, 0); }
		public ClosedWorldPredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closedWorldPredicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterClosedWorldPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitClosedWorldPredicate(this);
		}
	}

	public final ClosedWorldPredicateContext closedWorldPredicate() throws RecognitionException {
		ClosedWorldPredicateContext _localctx = new ClosedWorldPredicateContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_closedWorldPredicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(475); match(STAR);
			setState(476); plainPredicate();
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
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterPredicateDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitPredicateDecl(this);
		}
	}

	public final PredicateDeclContext predicateDecl() throws RecognitionException {
		PredicateDeclContext _localctx = new PredicateDeclContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_predicateDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(480);
			switch (_input.LA(1)) {
			case STAR:
				{
				setState(478); closedWorldPredicate();
				}
				break;
			case VAR_ID:
			case CONST_ID:
				{
				setState(479); plainPredicate();
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
		public TerminalNode RP() { return getToken(TuffyMLNGrammarParser.RP, 0); }
		public TerminalNode LP() { return getToken(TuffyMLNGrammarParser.LP, 0); }
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
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterFunctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitFunctionDecl(this);
		}
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_functionDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(482); type();
			setState(483); function();
			setState(484); match(LP);
			setState(485); typeList();
			setState(486); match(RP);
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
		public TerminalNode RP() { return getToken(TuffyMLNGrammarParser.RP, 0); }
		public QuantificationContext quantification() {
			return getRuleContext(QuantificationContext.class,0);
		}
		public TerminalNode LP() { return getToken(TuffyMLNGrammarParser.LP, 0); }
		public TerminalNode RSP() { return getToken(TuffyMLNGrammarParser.RSP, 0); }
		public TerminalNode EXCL() { return getToken(TuffyMLNGrammarParser.EXCL, 0); }
		public OrContext or() {
			return getRuleContext(OrContext.class,0);
		}
		public List<PlainFormulaContext> plainFormula() {
			return getRuleContexts(PlainFormulaContext.class);
		}
		public TerminalNode LSP() { return getToken(TuffyMLNGrammarParser.LSP, 0); }
		public TerminalNode EQ() { return getToken(TuffyMLNGrammarParser.EQ, 0); }
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
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterPlainFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitPlainFormula(this);
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
			setState(502);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				{
				setState(489); match(EXCL);
				setState(490); plainFormula(4);
				}
				break;

			case 2:
				{
				setState(491); predicateApplication();
				}
				break;

			case 3:
				{
				setState(492); functionApplication();
				}
				break;

			case 4:
				{
				setState(493); match(LSP);
				setState(494); plainFormula(0);
				setState(495); match(RSP);
				}
				break;

			case 5:
				{
				setState(497); match(LP);
				setState(498); plainFormula(0);
				setState(499); match(RP);
				}
				break;

			case 6:
				{
				setState(501); quantification();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(513);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(511);
					switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
					case 1:
						{
						_localctx = new PlainFormulaContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_plainFormula);
						setState(504);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(505); match(EQ);
						setState(506); plainFormula(4);
						}
						break;

					case 2:
						{
						_localctx = new PlainFormulaContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_plainFormula);
						setState(507);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(508); or();
						setState(509); plainFormula(3);
						}
						break;
					}
					} 
				}
				setState(515);
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
		public TerminalNode INT() { return getToken(TuffyMLNGrammarParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(TuffyMLNGrammarParser.FLOAT, 0); }
		public ProbabilityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_probability; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterProbability(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitProbability(this);
		}
	}

	public final ProbabilityContext probability() throws RecognitionException {
		ProbabilityContext _localctx = new ProbabilityContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_probability);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(516);
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
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterProbabilityStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitProbabilityStatement(this);
		}
	}

	public final ProbabilityStatementContext probabilityStatement() throws RecognitionException {
		ProbabilityStatementContext _localctx = new ProbabilityStatementContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_probabilityStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(519);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				{
				setState(518); probability();
				}
				break;
			}
			setState(521); groundFormula();
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
		public TerminalNode COL() { return getToken(TuffyMLNGrammarParser.COL, 0); }
		public TerminalNode INT() { return getToken(TuffyMLNGrammarParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(TuffyMLNGrammarParser.FLOAT, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public WeightContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_weight; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterWeight(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitWeight(this);
		}
	}

	public final WeightContext weight() throws RecognitionException {
		WeightContext _localctx = new WeightContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_weight);
		try {
			setState(528);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(523); match(INT);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(524); match(FLOAT);
				}
				break;
			case VAR_ID:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(525); variable();
				setState(526); match(COL);
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
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterWeights(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitWeights(this);
		}
	}

	public final WeightsContext weights() throws RecognitionException {
		WeightsContext _localctx = new WeightsContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_weights);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(530); weight();
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
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterWeightedFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitWeightedFormula(this);
		}
	}

	public final WeightedFormulaContext weightedFormula() throws RecognitionException {
		WeightedFormulaContext _localctx = new WeightedFormulaContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_weightedFormula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(532); weights();
			setState(533); plainFormula(0);
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
		public TerminalNode DOT() { return getToken(TuffyMLNGrammarParser.DOT, 0); }
		public PlainFormulaContext plainFormula() {
			return getRuleContext(PlainFormulaContext.class,0);
		}
		public HardFormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hardFormula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterHardFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitHardFormula(this);
		}
	}

	public final HardFormulaContext hardFormula() throws RecognitionException {
		HardFormulaContext _localctx = new HardFormulaContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_hardFormula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(535); plainFormula(0);
			setState(536); match(DOT);
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
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitFormula(this);
		}
	}

	public final FormulaContext formula() throws RecognitionException {
		FormulaContext _localctx = new FormulaContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_formula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(541);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				{
				setState(538); plainFormula(0);
				}
				break;

			case 2:
				{
				setState(539); weightedFormula();
				}
				break;

			case 3:
				{
				setState(540); hardFormula();
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

	public static class QuantifierContext extends ParserRuleContext {
		public TerminalNode U_QUANT() { return getToken(TuffyMLNGrammarParser.U_QUANT, 0); }
		public TerminalNode E_QUANT() { return getToken(TuffyMLNGrammarParser.E_QUANT, 0); }
		public QuantifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterQuantifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitQuantifier(this);
		}
	}

	public final QuantifierContext quantifier() throws RecognitionException {
		QuantifierContext _localctx = new QuantifierContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_quantifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(543);
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

	public static class QuantificationContext extends ParserRuleContext {
		public PlainFormulaContext plainFormula() {
			return getRuleContext(PlainFormulaContext.class,0);
		}
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
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterQuantification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitQuantification(this);
		}
	}

	public final QuantificationContext quantification() throws RecognitionException {
		QuantificationContext _localctx = new QuantificationContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_quantification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(545); quantifier();
			setState(546); variableList();
			setState(547); plainFormula(0);
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
		public FunctionDefContext functionDef() {
			return getRuleContext(FunctionDefContext.class,0);
		}
		public GroundPredicateApplicationContext groundPredicateApplication() {
			return getRuleContext(GroundPredicateApplicationContext.class,0);
		}
		public GroundFormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groundFormula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).enterGroundFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuffyMLNGrammarListener ) ((TuffyMLNGrammarListener)listener).exitGroundFormula(this);
		}
	}

	public final GroundFormulaContext groundFormula() throws RecognitionException {
		GroundFormulaContext _localctx = new GroundFormulaContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_groundFormula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(551);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				{
				setState(549); groundPredicateApplication();
				}
				break;

			case 2:
				{
				setState(550); functionDef();
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3)\u022c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\3\2\7\2j\n\2\f\2\16\2m\13\2\3\2\3\2\6\2q\n\2\r\2\16\2r\7\2u\n\2\f"+
		"\2\16\2x\13\2\5\2z\n\2\3\2\3\2\5\2~\n\2\3\2\6\2\u0081\n\2\r\2\16\2\u0082"+
		"\7\2\u0085\n\2\f\2\16\2\u0088\13\2\5\2\u008a\n\2\3\2\3\2\6\2\u008e\n\2"+
		"\r\2\16\2\u008f\7\2\u0092\n\2\f\2\16\2\u0095\13\2\5\2\u0097\n\2\3\3\3"+
		"\3\6\3\u009b\n\3\r\3\16\3\u009c\7\3\u009f\n\3\f\3\16\3\u00a2\13\3\3\4"+
		"\3\4\6\4\u00a6\n\4\r\4\16\4\u00a7\7\4\u00aa\n\4\f\4\16\4\u00ad\13\4\3"+
		"\5\3\5\6\5\u00b1\n\5\r\5\16\5\u00b2\7\5\u00b5\n\5\f\5\16\5\u00b8\13\5"+
		"\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\5"+
		"\f\u00ca\n\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\7\20\u00d5\n\20"+
		"\f\20\16\20\u00d8\13\20\3\21\3\21\5\21\u00dc\n\21\3\21\3\21\3\21\5\21"+
		"\u00e1\n\21\7\21\u00e3\n\21\f\21\16\21\u00e6\13\21\3\22\3\22\3\22\7\22"+
		"\u00eb\n\22\f\22\16\22\u00ee\13\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24"+
		"\3\24\3\24\7\24\u00f9\n\24\f\24\16\24\u00fc\13\24\3\25\3\25\5\25\u0100"+
		"\n\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34"+
		"\3\34\3\35\3\35\3\35\3\35\3\35\7\35\u0115\n\35\f\35\16\35\u0118\13\35"+
		"\5\35\u011a\n\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u0122\n\35\3\36\3"+
		"\36\3\36\3\36\3\36\7\36\u0129\n\36\f\36\16\36\u012c\13\36\5\36\u012e\n"+
		"\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u0139\n\36\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\5\37\u0141\n\37\3\37\3\37\3\37\3\37\7\37\u0147"+
		"\n\37\f\37\16\37\u014a\13\37\5\37\u014c\n\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\5\37\u0158\n\37\3\37\3\37\3\37\5\37\u015d\n"+
		"\37\3\37\3\37\7\37\u0161\n\37\f\37\16\37\u0164\13\37\3 \5 \u0167\n \3"+
		" \3 \3 \3 \3 \7 \u016e\n \f \16 \u0171\13 \5 \u0173\n \3 \3 \3 \3 \3 "+
		"\5 \u017a\n \3 \3 \5 \u017e\n \3 \3 \3 \5 \u0183\n \3!\3!\3!\3!\3!\7!"+
		"\u018a\n!\f!\16!\u018d\13!\5!\u018f\n!\3!\3!\3!\3!\3!\5!\u0196\n!\3!\3"+
		"!\3!\3!\3!\5!\u019d\n!\3\"\3\"\3\"\5\"\u01a2\n\"\3\"\3\"\3\"\3\"\7\"\u01a8"+
		"\n\"\f\"\16\"\u01ab\13\"\5\"\u01ad\n\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\5\"\u01ba\n\"\3\"\3\"\3\"\5\"\u01bf\n\"\3\"\3\"\7\"\u01c3"+
		"\n\"\f\"\16\"\u01c6\13\"\3#\3#\5#\u01ca\n#\3$\3$\3$\3$\3%\3%\3%\3%\3%"+
		"\5%\u01d5\n%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3(\3(\5(\u01e3\n(\3)\3)"+
		"\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\5*\u01f9\n*\3*"+
		"\3*\3*\3*\3*\3*\3*\7*\u0202\n*\f*\16*\u0205\13*\3+\3+\3,\5,\u020a\n,\3"+
		",\3,\3-\3-\3-\3-\3-\5-\u0213\n-\3.\3.\3/\3/\3/\3\60\3\60\3\60\3\61\3\61"+
		"\3\61\5\61\u0220\n\61\3\62\3\62\3\63\3\63\3\63\3\63\3\64\3\64\5\64\u022a"+
		"\n\64\3\64\2\5<BR\65\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdf\2\b\3\2()\3\2\'(\3\2%&\5\2\24\24\33"+
		"\34\"$\4\2\32\32\35!\3\2\30\31\u0247\2\u0096\3\2\2\2\4\u00a0\3\2\2\2\6"+
		"\u00ab\3\2\2\2\b\u00b6\3\2\2\2\n\u00b9\3\2\2\2\f\u00bb\3\2\2\2\16\u00be"+
		"\3\2\2\2\20\u00c0\3\2\2\2\22\u00c2\3\2\2\2\24\u00c4\3\2\2\2\26\u00c9\3"+
		"\2\2\2\30\u00cb\3\2\2\2\32\u00cd\3\2\2\2\34\u00cf\3\2\2\2\36\u00d1\3\2"+
		"\2\2 \u00db\3\2\2\2\"\u00e7\3\2\2\2$\u00ef\3\2\2\2&\u00f5\3\2\2\2(\u00ff"+
		"\3\2\2\2*\u0101\3\2\2\2,\u0103\3\2\2\2.\u0105\3\2\2\2\60\u0107\3\2\2\2"+
		"\62\u0109\3\2\2\2\64\u010b\3\2\2\2\66\u010d\3\2\2\28\u0121\3\2\2\2:\u0138"+
		"\3\2\2\2<\u0157\3\2\2\2>\u0166\3\2\2\2@\u019c\3\2\2\2B\u01b9\3\2\2\2D"+
		"\u01c9\3\2\2\2F\u01cb\3\2\2\2H\u01cf\3\2\2\2J\u01d8\3\2\2\2L\u01dd\3\2"+
		"\2\2N\u01e2\3\2\2\2P\u01e4\3\2\2\2R\u01f8\3\2\2\2T\u0206\3\2\2\2V\u0209"+
		"\3\2\2\2X\u0212\3\2\2\2Z\u0214\3\2\2\2\\\u0216\3\2\2\2^\u0219\3\2\2\2"+
		"`\u021f\3\2\2\2b\u0221\3\2\2\2d\u0223\3\2\2\2f\u0229\3\2\2\2hj\7\7\2\2"+
		"ih\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2ly\3\2\2\2mk\3\2\2\2np\5H%\2o"+
		"q\7\7\2\2po\3\2\2\2qr\3\2\2\2rp\3\2\2\2rs\3\2\2\2su\3\2\2\2tn\3\2\2\2"+
		"ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2wz\3\2\2\2xv\3\2\2\2yv\3\2\2\2yz\3\2\2\2"+
		"z\u0089\3\2\2\2{~\5N(\2|~\5P)\2}{\3\2\2\2}|\3\2\2\2~\u0080\3\2\2\2\177"+
		"\u0081\7\7\2\2\u0080\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0080\3\2\2"+
		"\2\u0082\u0083\3\2\2\2\u0083\u0085\3\2\2\2\u0084}\3\2\2\2\u0085\u0088"+
		"\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u008a\3\2\2\2\u0088"+
		"\u0086\3\2\2\2\u0089\u0086\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u0093\3\2"+
		"\2\2\u008b\u008d\5`\61\2\u008c\u008e\7\7\2\2\u008d\u008c\3\2\2\2\u008e"+
		"\u008f\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092\3\2"+
		"\2\2\u0091\u008b\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093"+
		"\u0094\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0096k\3\2\2\2"+
		"\u0096\u0097\3\2\2\2\u0097\3\3\2\2\2\u0098\u009a\5f\64\2\u0099\u009b\7"+
		"\7\2\2\u009a\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009a\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\u009f\3\2\2\2\u009e\u0098\3\2\2\2\u009f\u00a2\3\2"+
		"\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\5\3\2\2\2\u00a2\u00a0"+
		"\3\2\2\2\u00a3\u00a5\5V,\2\u00a4\u00a6\7\7\2\2\u00a5\u00a4\3\2\2\2\u00a6"+
		"\u00a7\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00aa\3\2"+
		"\2\2\u00a9\u00a3\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab"+
		"\u00ac\3\2\2\2\u00ac\7\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00b0\5N(\2\u00af"+
		"\u00b1\7\7\2\2\u00b0\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b0\3\2"+
		"\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b5\3\2\2\2\u00b4\u00ae\3\2\2\2\u00b5"+
		"\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\t\3\2\2\2"+
		"\u00b8\u00b6\3\2\2\2\u00b9\u00ba\t\2\2\2\u00ba\13\3\2\2\2\u00bb\u00bc"+
		"\7\33\2\2\u00bc\u00bd\5\20\t\2\u00bd\r\3\2\2\2\u00be\u00bf\t\3\2\2\u00bf"+
		"\17\3\2\2\2\u00c0\u00c1\7\'\2\2\u00c1\21\3\2\2\2\u00c2\u00c3\t\4\2\2\u00c3"+
		"\23\3\2\2\2\u00c4\u00c5\5\16\b\2\u00c5\u00c6\7\23\2\2\u00c6\25\3\2\2\2"+
		"\u00c7\u00ca\7\'\2\2\u00c8\u00ca\5\24\13\2\u00c9\u00c7\3\2\2\2\u00c9\u00c8"+
		"\3\2\2\2\u00ca\27\3\2\2\2\u00cb\u00cc\5\22\n\2\u00cc\31\3\2\2\2\u00cd"+
		"\u00ce\5\22\n\2\u00ce\33\3\2\2\2\u00cf\u00d0\7%\2\2\u00d0\35\3\2\2\2\u00d1"+
		"\u00d6\5\n\6\2\u00d2\u00d3\7\22\2\2\u00d3\u00d5\5\n\6\2\u00d4\u00d2\3"+
		"\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7"+
		"\37\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d9\u00dc\5\20\t\2\u00da\u00dc\5\f\7"+
		"\2\u00db\u00d9\3\2\2\2\u00db\u00da\3\2\2\2\u00dc\u00e4\3\2\2\2\u00dd\u00e0"+
		"\7\22\2\2\u00de\u00e1\5\20\t\2\u00df\u00e1\5\f\7\2\u00e0\u00de\3\2\2\2"+
		"\u00e0\u00df\3\2\2\2\u00e1\u00e3\3\2\2\2\u00e2\u00dd\3\2\2\2\u00e3\u00e6"+
		"\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5!\3\2\2\2\u00e6"+
		"\u00e4\3\2\2\2\u00e7\u00ec\5\26\f\2\u00e8\u00e9\7\22\2\2\u00e9\u00eb\5"+
		"\26\f\2\u00ea\u00e8\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec"+
		"\u00ed\3\2\2\2\u00ed#\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f0\5\30\r\2"+
		"\u00f0\u00f1\7\22\2\2\u00f1\u00f2\7\16\2\2\u00f2\u00f3\7\22\2\2\u00f3"+
		"\u00f4\5\32\16\2\u00f4%\3\2\2\2\u00f5\u00fa\5\22\n\2\u00f6\u00f7\7\22"+
		"\2\2\u00f7\u00f9\5\22\n\2\u00f8\u00f6\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa"+
		"\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\'\3\2\2\2\u00fc\u00fa\3\2\2\2"+
		"\u00fd\u0100\5$\23\2\u00fe\u0100\5&\24\2\u00ff\u00fd\3\2\2\2\u00ff\u00fe"+
		"\3\2\2\2\u0100)\3\2\2\2\u0101\u0102\7\25\2\2\u0102+\3\2\2\2\u0103\u0104"+
		"\7\32\2\2\u0104-\3\2\2\2\u0105\u0106\5\16\b\2\u0106/\3\2\2\2\u0107\u0108"+
		"\t\5\2\2\u0108\61\3\2\2\2\u0109\u010a\7\"\2\2\u010a\63\3\2\2\2\u010b\u010c"+
		"\5\16\b\2\u010c\65\3\2\2\2\u010d\u010e\t\6\2\2\u010e\67\3\2\2\2\u010f"+
		"\u0110\5\64\33\2\u0110\u0119\7\b\2\2\u0111\u0116\5<\37\2\u0112\u0113\7"+
		"\22\2\2\u0113\u0115\5<\37\2\u0114\u0112\3\2\2\2\u0115\u0118\3\2\2\2\u0116"+
		"\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u011a\3\2\2\2\u0118\u0116\3\2"+
		"\2\2\u0119\u0111\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011b\3\2\2\2\u011b"+
		"\u011c\7\t\2\2\u011c\u0122\3\2\2\2\u011d\u011e\5<\37\2\u011e\u011f\5\66"+
		"\34\2\u011f\u0120\5<\37\2\u0120\u0122\3\2\2\2\u0121\u010f\3\2\2\2\u0121"+
		"\u011d\3\2\2\2\u01229\3\2\2\2\u0123\u0124\5.\30\2\u0124\u012d\7\b\2\2"+
		"\u0125\u012a\5<\37\2\u0126\u0127\7\22\2\2\u0127\u0129\5<\37\2\u0128\u0126"+
		"\3\2\2\2\u0129\u012c\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b"+
		"\u012e\3\2\2\2\u012c\u012a\3\2\2\2\u012d\u0125\3\2\2\2\u012d\u012e\3\2"+
		"\2\2\u012e\u012f\3\2\2\2\u012f\u0130\7\t\2\2\u0130\u0139\3\2\2\2\u0131"+
		"\u0132\5<\37\2\u0132\u0133\5\60\31\2\u0133\u0134\5<\37\2\u0134\u0139\3"+
		"\2\2\2\u0135\u0136\5\62\32\2\u0136\u0137\5<\37\2\u0137\u0139\3\2\2\2\u0138"+
		"\u0123\3\2\2\2\u0138\u0131\3\2\2\2\u0138\u0135\3\2\2\2\u0139;\3\2\2\2"+
		"\u013a\u013b\b\37\1\2\u013b\u013c\5\62\32\2\u013c\u013d\5<\37\b\u013d"+
		"\u0158\3\2\2\2\u013e\u0141\5\64\33\2\u013f\u0141\5.\30\2\u0140\u013e\3"+
		"\2\2\2\u0140\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u014b\7\b\2\2\u0143"+
		"\u0148\5<\37\2\u0144\u0145\7\22\2\2\u0145\u0147\5<\37\2\u0146\u0144\3"+
		"\2\2\2\u0147\u014a\3\2\2\2\u0148\u0146\3\2\2\2\u0148\u0149\3\2\2\2\u0149"+
		"\u014c\3\2\2\2\u014a\u0148\3\2\2\2\u014b\u0143\3\2\2\2\u014b\u014c\3\2"+
		"\2\2\u014c\u014d\3\2\2\2\u014d\u014e\7\t\2\2\u014e\u0158\3\2\2\2\u014f"+
		"\u0158\5\20\t\2\u0150\u0158\5\f\7\2\u0151\u0158\5\n\6\2\u0152\u0158\5"+
		"\22\n\2\u0153\u0154\7\b\2\2\u0154\u0155\5<\37\2\u0155\u0156\7\t\2\2\u0156"+
		"\u0158\3\2\2\2\u0157\u013a\3\2\2\2\u0157\u0140\3\2\2\2\u0157\u014f\3\2"+
		"\2\2\u0157\u0150\3\2\2\2\u0157\u0151\3\2\2\2\u0157\u0152\3\2\2\2\u0157"+
		"\u0153\3\2\2\2\u0158\u0162\3\2\2\2\u0159\u015c\f\t\2\2\u015a\u015d\5\66"+
		"\34\2\u015b\u015d\5\60\31\2\u015c\u015a\3\2\2\2\u015c\u015b\3\2\2\2\u015d"+
		"\u015e\3\2\2\2\u015e\u015f\5<\37\n\u015f\u0161\3\2\2\2\u0160\u0159\3\2"+
		"\2\2\u0161\u0164\3\2\2\2\u0162\u0160\3\2\2\2\u0162\u0163\3\2\2\2\u0163"+
		"=\3\2\2\2\u0164\u0162\3\2\2\2\u0165\u0167\7\23\2\2\u0166\u0165\3\2\2\2"+
		"\u0166\u0167\3\2\2\2\u0167\u0182\3\2\2\2\u0168\u0169\5\64\33\2\u0169\u0172"+
		"\7\b\2\2\u016a\u016f\5B\"\2\u016b\u016c\7\22\2\2\u016c\u016e\5B\"\2\u016d"+
		"\u016b\3\2\2\2\u016e\u0171\3\2\2\2\u016f\u016d\3\2\2\2\u016f\u0170\3\2"+
		"\2\2\u0170\u0173\3\2\2\2\u0171\u016f\3\2\2\2\u0172\u016a\3\2\2\2\u0172"+
		"\u0173\3\2\2\2\u0173\u0174\3\2\2\2\u0174\u0175\7\t\2\2\u0175\u017e\3\2"+
		"\2\2\u0176\u0179\5B\"\2\u0177\u017a\5\66\34\2\u0178\u017a\5\60\31\2\u0179"+
		"\u0177\3\2\2\2\u0179\u0178\3\2\2\2\u017a\u017b\3\2\2\2\u017b\u017c\5B"+
		"\"\2\u017c\u017e\3\2\2\2\u017d\u0168\3\2\2\2\u017d\u0176\3\2\2\2\u017e"+
		"\u0183\3\2\2\2\u017f\u0180\5\62\32\2\u0180\u0181\5<\37\2\u0181\u0183\3"+
		"\2\2\2\u0182\u017d\3\2\2\2\u0182\u017f\3\2\2\2\u0183?\3\2\2\2\u0184\u0185"+
		"\5.\30\2\u0185\u018e\7\b\2\2\u0186\u018b\5B\"\2\u0187\u0188\7\22\2\2\u0188"+
		"\u018a\5B\"\2\u0189\u0187\3\2\2\2\u018a\u018d\3\2\2\2\u018b\u0189\3\2"+
		"\2\2\u018b\u018c\3\2\2\2\u018c\u018f\3\2\2\2\u018d\u018b\3\2\2\2\u018e"+
		"\u0186\3\2\2\2\u018e\u018f\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0191\7\t"+
		"\2\2\u0191\u019d\3\2\2\2\u0192\u0195\5B\"\2\u0193\u0196\5\66\34\2\u0194"+
		"\u0196\5\60\31\2\u0195\u0193\3\2\2\2\u0195\u0194\3\2\2\2\u0196\u0197\3"+
		"\2\2\2\u0197\u0198\5B\"\2\u0198\u019d\3\2\2\2\u0199\u019a\5\62\32\2\u019a"+
		"\u019b\5<\37\2\u019b\u019d\3\2\2\2\u019c\u0184\3\2\2\2\u019c\u0192\3\2"+
		"\2\2\u019c\u0199\3\2\2\2\u019dA\3\2\2\2\u019e\u01a1\b\"\1\2\u019f\u01a2"+
		"\5\64\33\2\u01a0\u01a2\5.\30\2\u01a1\u019f\3\2\2\2\u01a1\u01a0\3\2\2\2"+
		"\u01a2\u01a3\3\2\2\2\u01a3\u01ac\7\b\2\2\u01a4\u01a9\5B\"\2\u01a5\u01a6"+
		"\7\22\2\2\u01a6\u01a8\5B\"\2\u01a7\u01a5\3\2\2\2\u01a8\u01ab\3\2\2\2\u01a9"+
		"\u01a7\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01ad\3\2\2\2\u01ab\u01a9\3\2"+
		"\2\2\u01ac\u01a4\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae"+
		"\u01af\7\t\2\2\u01af\u01ba\3\2\2\2\u01b0\u01b1\5\62\32\2\u01b1\u01b2\5"+
		"<\37\2\u01b2\u01ba\3\2\2\2\u01b3\u01ba\5\n\6\2\u01b4\u01ba\5\22\n\2\u01b5"+
		"\u01b6\7\b\2\2\u01b6\u01b7\5B\"\2\u01b7\u01b8\7\t\2\2\u01b8\u01ba\3\2"+
		"\2\2\u01b9\u019e\3\2\2\2\u01b9\u01b0\3\2\2\2\u01b9\u01b3\3\2\2\2\u01b9"+
		"\u01b4\3\2\2\2\u01b9\u01b5\3\2\2\2\u01ba\u01c4\3\2\2\2\u01bb\u01be\f\7"+
		"\2\2\u01bc\u01bf\5\66\34\2\u01bd\u01bf\5\60\31\2\u01be\u01bc\3\2\2\2\u01be"+
		"\u01bd\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01c1\5B\"\b\u01c1\u01c3\3\2"+
		"\2\2\u01c2\u01bb\3\2\2\2\u01c3\u01c6\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c4"+
		"\u01c5\3\2\2\2\u01c5C\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c7\u01ca\5\n\6\2"+
		"\u01c8\u01ca\5\22\n\2\u01c9\u01c7\3\2\2\2\u01c9\u01c8\3\2\2\2\u01caE\3"+
		"\2\2\2\u01cb\u01cc\5D#\2\u01cc\u01cd\7\32\2\2\u01cd\u01ce\5@!\2\u01ce"+
		"G\3\2\2\2\u01cf\u01d0\5\26\f\2\u01d0\u01d1\7\32\2\2\u01d1\u01d4\7\n\2"+
		"\2\u01d2\u01d5\5\36\20\2\u01d3\u01d5\5(\25\2\u01d4\u01d2\3\2\2\2\u01d4"+
		"\u01d3\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6\u01d7\7\13\2\2\u01d7I\3\2\2\2"+
		"\u01d8\u01d9\5\64\33\2\u01d9\u01da\7\b\2\2\u01da\u01db\5\"\22\2\u01db"+
		"\u01dc\7\t\2\2\u01dcK\3\2\2\2\u01dd\u01de\7\34\2\2\u01de\u01df\5J&\2\u01df"+
		"M\3\2\2\2\u01e0\u01e3\5L\'\2\u01e1\u01e3\5J&\2\u01e2\u01e0\3\2\2\2\u01e2"+
		"\u01e1\3\2\2\2\u01e3O\3\2\2\2\u01e4\u01e5\5\26\f\2\u01e5\u01e6\5.\30\2"+
		"\u01e6\u01e7\7\b\2\2\u01e7\u01e8\5\"\22\2\u01e8\u01e9\7\t\2\2\u01e9Q\3"+
		"\2\2\2\u01ea\u01eb\b*\1\2\u01eb\u01ec\7\23\2\2\u01ec\u01f9\5R*\6\u01ed"+
		"\u01f9\58\35\2\u01ee\u01f9\5:\36\2\u01ef\u01f0\7\f\2\2\u01f0\u01f1\5R"+
		"*\2\u01f1\u01f2\7\r\2\2\u01f2\u01f9\3\2\2\2\u01f3\u01f4\7\b\2\2\u01f4"+
		"\u01f5\5R*\2\u01f5\u01f6\7\t\2\2\u01f6\u01f9\3\2\2\2\u01f7\u01f9\5d\63"+
		"\2\u01f8\u01ea\3\2\2\2\u01f8\u01ed\3\2\2\2\u01f8\u01ee\3\2\2\2\u01f8\u01ef"+
		"\3\2\2\2\u01f8\u01f3\3\2\2\2\u01f8\u01f7\3\2\2\2\u01f9\u0203\3\2\2\2\u01fa"+
		"\u01fb\f\5\2\2\u01fb\u01fc\7\32\2\2\u01fc\u0202\5R*\6\u01fd\u01fe\f\4"+
		"\2\2\u01fe\u01ff\5*\26\2\u01ff\u0200\5R*\5\u0200\u0202\3\2\2\2\u0201\u01fa"+
		"\3\2\2\2\u0201\u01fd\3\2\2\2\u0202\u0205\3\2\2\2\u0203\u0201\3\2\2\2\u0203"+
		"\u0204\3\2\2\2\u0204S\3\2\2\2\u0205\u0203\3\2\2\2\u0206\u0207\t\4\2\2"+
		"\u0207U\3\2\2\2\u0208\u020a\5T+\2\u0209\u0208\3\2\2\2\u0209\u020a\3\2"+
		"\2\2\u020a\u020b\3\2\2\2\u020b\u020c\5f\64\2\u020cW\3\2\2\2\u020d\u0213"+
		"\7%\2\2\u020e\u0213\7&\2\2\u020f\u0210\5\20\t\2\u0210\u0211\7\21\2\2\u0211"+
		"\u0213\3\2\2\2\u0212\u020d\3\2\2\2\u0212\u020e\3\2\2\2\u0212\u020f\3\2"+
		"\2\2\u0213Y\3\2\2\2\u0214\u0215\5X-\2\u0215[\3\2\2\2\u0216\u0217\5Z.\2"+
		"\u0217\u0218\5R*\2\u0218]\3\2\2\2\u0219\u021a\5R*\2\u021a\u021b\7\17\2"+
		"\2\u021b_\3\2\2\2\u021c\u0220\5R*\2\u021d\u0220\5\\/\2\u021e\u0220\5^"+
		"\60\2\u021f\u021c\3\2\2\2\u021f\u021d\3\2\2\2\u021f\u021e\3\2\2\2\u0220"+
		"a\3\2\2\2\u0221\u0222\t\7\2\2\u0222c\3\2\2\2\u0223\u0224\5b\62\2\u0224"+
		"\u0225\5 \21\2\u0225\u0226\5R*\2\u0226e\3\2\2\2\u0227\u022a\5> \2\u0228"+
		"\u022a\5F$\2\u0229\u0227\3\2\2\2\u0229\u0228\3\2\2\2\u022ag\3\2\2\2Ak"+
		"rvy}\u0082\u0086\u0089\u008f\u0093\u0096\u009c\u00a0\u00a7\u00ab\u00b2"+
		"\u00b6\u00c9\u00d6\u00db\u00e0\u00e4\u00ec\u00fa\u00ff\u0116\u0119\u0121"+
		"\u012a\u012d\u0138\u0140\u0148\u014b\u0157\u015c\u0162\u0166\u016f\u0172"+
		"\u0179\u017d\u0182\u018b\u018e\u0195\u019c\u01a1\u01a9\u01ac\u01b9\u01be"+
		"\u01c4\u01c9\u01d4\u01e2\u01f8\u0201\u0203\u0209\u0212\u021f\u0229";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}