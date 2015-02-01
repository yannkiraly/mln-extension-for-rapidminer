// Generated from ExampleSetMLNGrammar.g4 by ANTLR 4.2
package com.rapidminer.operator.modelling.converters.exampleset.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExampleSetMLNGrammarLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LINE_COMMENT=1, COMMENT=2, WS=3, NL=4, LP=5, RP=6, LCP=7, RCP=8, LSP=9, 
		RSP=10, DOTS=11, DOT=12, COL=13, COM=14, EXCL=15, BAR=16, AND=17, OR=18, 
		IMPLIES=19, IFF=20, U_QUANT=21, E_QUANT=22, EQ=23, PLUS=24, STAR=25, GT=26, 
		LT=27, GE=28, LE=29, NE=30, MINUS=31, SLASH=32, MOD=33, INT=34, FLOAT=35, 
		VAR_ID=36, CONST_ID=37, STRING=38;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"LINE_COMMENT", "COMMENT", "WS", "NL", "'('", "')'", "'{'", "'}'", "'['", 
		"']'", "'...'", "'.'", "':'", "','", "'!'", "'|'", "'^'", "'v'", "'=>'", 
		"'<=>'", "U_QUANT", "E_QUANT", "'='", "'+'", "'*'", "'>'", "'<'", "'>='", 
		"'<='", "'!='", "'-'", "'/'", "'%'", "INT", "FLOAT", "VAR_ID", "CONST_ID", 
		"STRING"
	};
	public static final String[] ruleNames = {
		"LINE_COMMENT", "COMMENT", "WS", "NL", "LP", "RP", "LCP", "RCP", "LSP", 
		"RSP", "DOTS", "DOT", "COL", "COM", "EXCL", "BAR", "AND", "OR", "IMPLIES", 
		"IFF", "U_QUANT", "E_QUANT", "EQ", "PLUS", "STAR", "GT", "LT", "GE", "LE", 
		"NE", "MINUS", "SLASH", "MOD", "INT", "FLOAT", "DIGIT", "ESC", "VAR_ID", 
		"CONST_ID", "ID", "STRING"
	};


	public ExampleSetMLNGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ExampleSetMLNGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2(\u011e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\3\2\3\2\7\2Z\n\2\f\2\16\2]\13\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3e\n\3\f\3"+
		"\16\3h\13\3\3\3\3\3\3\3\3\3\3\3\3\4\6\4p\n\4\r\4\16\4q\3\4\3\4\3\5\5\5"+
		"w\n\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3"+
		"\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u00b2"+
		"\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\5\27\u00c3\n\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34"+
		"\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3!\3!\3\"\3\""+
		"\3#\5#\u00df\n#\3#\6#\u00e2\n#\r#\16#\u00e3\3$\5$\u00e7\n$\3$\6$\u00ea"+
		"\n$\r$\16$\u00eb\3$\3$\6$\u00f0\n$\r$\16$\u00f1\3$\3$\6$\u00f6\n$\r$\16"+
		"$\u00f7\5$\u00fa\n$\3%\3%\3%\3%\3%\5%\u0101\n%\3&\3&\3&\3&\5&\u0107\n"+
		"&\3\'\3\'\3\'\3(\3(\3(\3)\7)\u0110\n)\f)\16)\u0113\13)\3*\3*\3*\7*\u0118"+
		"\n*\f*\16*\u011b\13*\3*\3*\4f\u0119\2+\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I\2K\2M&O\'Q\2S(\3\2"+
		"\b\4\2\f\f\17\17\5\2\13\13\"\"))\3\2\62;\5\2))aac|\3\2C\\\7\2))\62;C\\"+
		"aac|\u012f\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2S\3\2\2\2\3U\3\2\2\2\5`\3\2\2\2\7o"+
		"\3\2\2\2\tv\3\2\2\2\13z\3\2\2\2\r|\3\2\2\2\17~\3\2\2\2\21\u0080\3\2\2"+
		"\2\23\u0082\3\2\2\2\25\u0084\3\2\2\2\27\u0086\3\2\2\2\31\u008a\3\2\2\2"+
		"\33\u008c\3\2\2\2\35\u008e\3\2\2\2\37\u0090\3\2\2\2!\u0092\3\2\2\2#\u0094"+
		"\3\2\2\2%\u0096\3\2\2\2\'\u0098\3\2\2\2)\u009b\3\2\2\2+\u00b1\3\2\2\2"+
		"-\u00c2\3\2\2\2/\u00c4\3\2\2\2\61\u00c6\3\2\2\2\63\u00c8\3\2\2\2\65\u00ca"+
		"\3\2\2\2\67\u00cc\3\2\2\29\u00ce\3\2\2\2;\u00d1\3\2\2\2=\u00d4\3\2\2\2"+
		"?\u00d7\3\2\2\2A\u00d9\3\2\2\2C\u00db\3\2\2\2E\u00de\3\2\2\2G\u00f9\3"+
		"\2\2\2I\u0100\3\2\2\2K\u0106\3\2\2\2M\u0108\3\2\2\2O\u010b\3\2\2\2Q\u0111"+
		"\3\2\2\2S\u0114\3\2\2\2UV\7\61\2\2VW\7\61\2\2W[\3\2\2\2XZ\n\2\2\2YX\3"+
		"\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\^\3\2\2\2][\3\2\2\2^_\b\2\2\2_"+
		"\4\3\2\2\2`a\7\61\2\2ab\7,\2\2bf\3\2\2\2ce\13\2\2\2dc\3\2\2\2eh\3\2\2"+
		"\2fg\3\2\2\2fd\3\2\2\2gi\3\2\2\2hf\3\2\2\2ij\7,\2\2jk\7\61\2\2kl\3\2\2"+
		"\2lm\b\3\2\2m\6\3\2\2\2np\t\3\2\2on\3\2\2\2pq\3\2\2\2qo\3\2\2\2qr\3\2"+
		"\2\2rs\3\2\2\2st\b\4\2\2t\b\3\2\2\2uw\7\17\2\2vu\3\2\2\2vw\3\2\2\2wx\3"+
		"\2\2\2xy\7\f\2\2y\n\3\2\2\2z{\7*\2\2{\f\3\2\2\2|}\7+\2\2}\16\3\2\2\2~"+
		"\177\7}\2\2\177\20\3\2\2\2\u0080\u0081\7\177\2\2\u0081\22\3\2\2\2\u0082"+
		"\u0083\7]\2\2\u0083\24\3\2\2\2\u0084\u0085\7_\2\2\u0085\26\3\2\2\2\u0086"+
		"\u0087\7\60\2\2\u0087\u0088\7\60\2\2\u0088\u0089\7\60\2\2\u0089\30\3\2"+
		"\2\2\u008a\u008b\7\60\2\2\u008b\32\3\2\2\2\u008c\u008d\7<\2\2\u008d\34"+
		"\3\2\2\2\u008e\u008f\7.\2\2\u008f\36\3\2\2\2\u0090\u0091\7#\2\2\u0091"+
		" \3\2\2\2\u0092\u0093\7~\2\2\u0093\"\3\2\2\2\u0094\u0095\7`\2\2\u0095"+
		"$\3\2\2\2\u0096\u0097\7x\2\2\u0097&\3\2\2\2\u0098\u0099\7?\2\2\u0099\u009a"+
		"\7@\2\2\u009a(\3\2\2\2\u009b\u009c\7>\2\2\u009c\u009d\7?\2\2\u009d\u009e"+
		"\7@\2\2\u009e*\3\2\2\2\u009f\u00a0\7H\2\2\u00a0\u00a1\7Q\2\2\u00a1\u00a2"+
		"\7T\2\2\u00a2\u00a3\7C\2\2\u00a3\u00a4\7N\2\2\u00a4\u00b2\7N\2\2\u00a5"+
		"\u00a6\7h\2\2\u00a6\u00a7\7q\2\2\u00a7\u00a8\7t\2\2\u00a8\u00a9\7c\2\2"+
		"\u00a9\u00aa\7n\2\2\u00aa\u00b2\7n\2\2\u00ab\u00ac\7H\2\2\u00ac\u00ad"+
		"\7q\2\2\u00ad\u00ae\7t\2\2\u00ae\u00af\7c\2\2\u00af\u00b0\7n\2\2\u00b0"+
		"\u00b2\7n\2\2\u00b1\u009f\3\2\2\2\u00b1\u00a5\3\2\2\2\u00b1\u00ab\3\2"+
		"\2\2\u00b2,\3\2\2\2\u00b3\u00b4\7G\2\2\u00b4\u00b5\7Z\2\2\u00b5\u00b6"+
		"\7K\2\2\u00b6\u00b7\7U\2\2\u00b7\u00c3\7V\2\2\u00b8\u00b9\7g\2\2\u00b9"+
		"\u00ba\7z\2\2\u00ba\u00bb\7k\2\2\u00bb\u00bc\7u\2\2\u00bc\u00c3\7v\2\2"+
		"\u00bd\u00be\7G\2\2\u00be\u00bf\7z\2\2\u00bf\u00c0\7k\2\2\u00c0\u00c1"+
		"\7u\2\2\u00c1\u00c3\7v\2\2\u00c2\u00b3\3\2\2\2\u00c2\u00b8\3\2\2\2\u00c2"+
		"\u00bd\3\2\2\2\u00c3.\3\2\2\2\u00c4\u00c5\7?\2\2\u00c5\60\3\2\2\2\u00c6"+
		"\u00c7\7-\2\2\u00c7\62\3\2\2\2\u00c8\u00c9\7,\2\2\u00c9\64\3\2\2\2\u00ca"+
		"\u00cb\7@\2\2\u00cb\66\3\2\2\2\u00cc\u00cd\7>\2\2\u00cd8\3\2\2\2\u00ce"+
		"\u00cf\7@\2\2\u00cf\u00d0\7?\2\2\u00d0:\3\2\2\2\u00d1\u00d2\7>\2\2\u00d2"+
		"\u00d3\7?\2\2\u00d3<\3\2\2\2\u00d4\u00d5\7#\2\2\u00d5\u00d6\7?\2\2\u00d6"+
		">\3\2\2\2\u00d7\u00d8\7/\2\2\u00d8@\3\2\2\2\u00d9\u00da\7\61\2\2\u00da"+
		"B\3\2\2\2\u00db\u00dc\7\'\2\2\u00dcD\3\2\2\2\u00dd\u00df\7/\2\2\u00de"+
		"\u00dd\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e1\3\2\2\2\u00e0\u00e2\t\4"+
		"\2\2\u00e1\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3"+
		"\u00e4\3\2\2\2\u00e4F\3\2\2\2\u00e5\u00e7\7/\2\2\u00e6\u00e5\3\2\2\2\u00e6"+
		"\u00e7\3\2\2\2\u00e7\u00e9\3\2\2\2\u00e8\u00ea\5I%\2\u00e9\u00e8\3\2\2"+
		"\2\u00ea\u00eb\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ed"+
		"\3\2\2\2\u00ed\u00ef\7\60\2\2\u00ee\u00f0\5I%\2\u00ef\u00ee\3\2\2\2\u00f0"+
		"\u00f1\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00fa\3\2"+
		"\2\2\u00f3\u00f5\7\60\2\2\u00f4\u00f6\5I%\2\u00f5\u00f4\3\2\2\2\u00f6"+
		"\u00f7\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00fa\3\2"+
		"\2\2\u00f9\u00e6\3\2\2\2\u00f9\u00f3\3\2\2\2\u00faH\3\2\2\2\u00fb\u0101"+
		"\t\4\2\2\u00fc\u00fd\7g\2\2\u00fd\u0101\7/\2\2\u00fe\u00ff\7G\2\2\u00ff"+
		"\u0101\7/\2\2\u0100\u00fb\3\2\2\2\u0100\u00fc\3\2\2\2\u0100\u00fe\3\2"+
		"\2\2\u0101J\3\2\2\2\u0102\u0103\7^\2\2\u0103\u0107\7$\2\2\u0104\u0105"+
		"\7^\2\2\u0105\u0107\7^\2\2\u0106\u0102\3\2\2\2\u0106\u0104\3\2\2\2\u0107"+
		"L\3\2\2\2\u0108\u0109\t\5\2\2\u0109\u010a\5Q)\2\u010aN\3\2\2\2\u010b\u010c"+
		"\t\6\2\2\u010c\u010d\5Q)\2\u010dP\3\2\2\2\u010e\u0110\t\7\2\2\u010f\u010e"+
		"\3\2\2\2\u0110\u0113\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112"+
		"R\3\2\2\2\u0113\u0111\3\2\2\2\u0114\u0119\7$\2\2\u0115\u0118\5K&\2\u0116"+
		"\u0118\13\2\2\2\u0117\u0115\3\2\2\2\u0117\u0116\3\2\2\2\u0118\u011b\3"+
		"\2\2\2\u0119\u011a\3\2\2\2\u0119\u0117\3\2\2\2\u011a\u011c\3\2\2\2\u011b"+
		"\u0119\3\2\2\2\u011c\u011d\7$\2\2\u011dT\3\2\2\2\25\2[fqv\u00b1\u00c2"+
		"\u00de\u00e3\u00e6\u00eb\u00f1\u00f7\u00f9\u0100\u0106\u0111\u0117\u0119"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}