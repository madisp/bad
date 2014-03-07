// Generated from /Users/madis/Code/github/bad/script/src/main/grammar/Expr.g4 by ANTLR 4.0
package com.madisp.bad.parse;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__8=1, T__7=2, T__6=3, T__5=4, T__4=5, T__3=6, T__2=7, T__1=8, T__0=9, 
		STRING=10, DOUBLE=11, NOT=12, AND=13, ASSIGN=14, OR=15, INT=16, TRUE=17, 
		FALSE=18, NULL=19, PLUS=20, MINUS=21, SLASH=22, STAR=23, IDENTIFIER=24, 
		ESCAPE=25, DOLLAR=26, WS=27, DOT=28;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'{'", "')'", "','", "'('", "'@'", "':'", "'}'", "';'", "'|'", "STRING", 
		"DOUBLE", "'!'", "'and'", "'='", "'or'", "INT", "'true'", "'false'", "'null'", 
		"'+'", "'-'", "'/'", "'*'", "IDENTIFIER", "ESCAPE", "'$'", "WS", "'.'"
	};
	public static final String[] ruleNames = {
		"T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", 
		"STRING", "DOUBLE", "ESC", "NOT", "AND", "ASSIGN", "OR", "INT", "TRUE", 
		"FALSE", "NULL", "PLUS", "MINUS", "SLASH", "STAR", "IDENTIFIER", "ESCAPE", 
		"DIGIT", "UPPERC", "LOWERC", "UNDERS", "ALPHA", "DOLLAR", "ALPHANUMERIC", 
		"WS", "DOT"
	};


	public ExprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Expr.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 9: STRING_action((RuleContext)_localctx, actionIndex); break;

		case 33: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip();  break;
		}
	}
	private void STRING_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:  setText(getText().substring(1, getText().length() - 1));  break;
		}
	}

	public static final String _serializedATN =
		"\2\4\36\u00c7\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\3\3\3\3\4\3"+
		"\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\7\13"+
		"_\n\13\f\13\16\13b\13\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5"+
		"\fn\n\f\5\fp\n\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3"+
		"\21\3\21\3\21\3\22\6\22\u0081\n\22\r\22\16\22\u0082\3\23\3\23\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\5\32\u009f\n\32\3\32\7\32\u00a2"+
		"\n\32\f\32\16\32\u00a5\13\32\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3"+
		"\36\3\37\3\37\3 \3 \3 \5 \u00b5\n \3!\3!\3\"\3\"\3\"\3\"\5\"\u00bd\n\""+
		"\3#\6#\u00c0\n#\r#\16#\u00c1\3#\3#\3$\3$\2%\3\3\1\5\4\1\7\5\1\t\6\1\13"+
		"\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\2\27\r\1\31\2\1\33\16\1\35\17\1"+
		"\37\20\1!\21\1#\22\1%\23\1\'\24\1)\25\1+\26\1-\27\1/\30\1\61\31\1\63\32"+
		"\1\65\33\1\67\2\19\2\1;\2\1=\2\1?\2\1A\34\1C\2\1E\35\3G\36\1\3\2\n\4)"+
		")^^\4ffhh\4ffhh\7))^^ppttvv\4$$^^\3C\\\3c|\5\13\f\16\17\"\"\u00cc\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2"+
		"\63\3\2\2\2\2\65\3\2\2\2\2A\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\3I\3\2\2\2\5"+
		"K\3\2\2\2\7M\3\2\2\2\tO\3\2\2\2\13Q\3\2\2\2\rS\3\2\2\2\17U\3\2\2\2\21"+
		"W\3\2\2\2\23Y\3\2\2\2\25[\3\2\2\2\27o\3\2\2\2\31q\3\2\2\2\33t\3\2\2\2"+
		"\35v\3\2\2\2\37z\3\2\2\2!|\3\2\2\2#\u0080\3\2\2\2%\u0084\3\2\2\2\'\u0089"+
		"\3\2\2\2)\u008f\3\2\2\2+\u0094\3\2\2\2-\u0096\3\2\2\2/\u0098\3\2\2\2\61"+
		"\u009a\3\2\2\2\63\u009e\3\2\2\2\65\u00a6\3\2\2\2\67\u00a9\3\2\2\29\u00ab"+
		"\3\2\2\2;\u00ad\3\2\2\2=\u00af\3\2\2\2?\u00b4\3\2\2\2A\u00b6\3\2\2\2C"+
		"\u00bc\3\2\2\2E\u00bf\3\2\2\2G\u00c5\3\2\2\2IJ\7}\2\2J\4\3\2\2\2KL\7+"+
		"\2\2L\6\3\2\2\2MN\7.\2\2N\b\3\2\2\2OP\7*\2\2P\n\3\2\2\2QR\7B\2\2R\f\3"+
		"\2\2\2ST\7<\2\2T\16\3\2\2\2UV\7\177\2\2V\20\3\2\2\2WX\7=\2\2X\22\3\2\2"+
		"\2YZ\7~\2\2Z\24\3\2\2\2[`\7)\2\2\\_\5\31\r\2]_\n\2\2\2^\\\3\2\2\2^]\3"+
		"\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2ac\3\2\2\2b`\3\2\2\2cd\7)\2\2de\b"+
		"\13\2\2e\26\3\2\2\2fg\5#\22\2gh\t\3\2\2hp\3\2\2\2ij\5#\22\2jk\7\60\2\2"+
		"km\5#\22\2ln\t\4\2\2ml\3\2\2\2mn\3\2\2\2np\3\2\2\2of\3\2\2\2oi\3\2\2\2"+
		"p\30\3\2\2\2qr\7^\2\2rs\t\5\2\2s\32\3\2\2\2tu\7#\2\2u\34\3\2\2\2vw\7c"+
		"\2\2wx\7p\2\2xy\7f\2\2y\36\3\2\2\2z{\7?\2\2{ \3\2\2\2|}\7q\2\2}~\7t\2"+
		"\2~\"\3\2\2\2\177\u0081\5\67\34\2\u0080\177\3\2\2\2\u0081\u0082\3\2\2"+
		"\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083$\3\2\2\2\u0084\u0085"+
		"\7v\2\2\u0085\u0086\7t\2\2\u0086\u0087\7w\2\2\u0087\u0088\7g\2\2\u0088"+
		"&\3\2\2\2\u0089\u008a\7h\2\2\u008a\u008b\7c\2\2\u008b\u008c\7n\2\2\u008c"+
		"\u008d\7u\2\2\u008d\u008e\7g\2\2\u008e(\3\2\2\2\u008f\u0090\7p\2\2\u0090"+
		"\u0091\7w\2\2\u0091\u0092\7n\2\2\u0092\u0093\7n\2\2\u0093*\3\2\2\2\u0094"+
		"\u0095\7-\2\2\u0095,\3\2\2\2\u0096\u0097\7/\2\2\u0097.\3\2\2\2\u0098\u0099"+
		"\7\61\2\2\u0099\60\3\2\2\2\u009a\u009b\7,\2\2\u009b\62\3\2\2\2\u009c\u009f"+
		"\5? \2\u009d\u009f\5A!\2\u009e\u009c\3\2\2\2\u009e\u009d\3\2\2\2\u009f"+
		"\u00a3\3\2\2\2\u00a0\u00a2\5C\"\2\u00a1\u00a0\3\2\2\2\u00a2\u00a5\3\2"+
		"\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\64\3\2\2\2\u00a5\u00a3"+
		"\3\2\2\2\u00a6\u00a7\7^\2\2\u00a7\u00a8\t\6\2\2\u00a8\66\3\2\2\2\u00a9"+
		"\u00aa\4\62;\2\u00aa8\3\2\2\2\u00ab\u00ac\t\7\2\2\u00ac:\3\2\2\2\u00ad"+
		"\u00ae\t\b\2\2\u00ae<\3\2\2\2\u00af\u00b0\7a\2\2\u00b0>\3\2\2\2\u00b1"+
		"\u00b5\59\35\2\u00b2\u00b5\5;\36\2\u00b3\u00b5\5=\37\2\u00b4\u00b1\3\2"+
		"\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b3\3\2\2\2\u00b5@\3\2\2\2\u00b6\u00b7"+
		"\7&\2\2\u00b7B\3\2\2\2\u00b8\u00bd\59\35\2\u00b9\u00bd\5;\36\2\u00ba\u00bd"+
		"\5=\37\2\u00bb\u00bd\5\67\34\2\u00bc\u00b8\3\2\2\2\u00bc\u00b9\3\2\2\2"+
		"\u00bc\u00ba\3\2\2\2\u00bc\u00bb\3\2\2\2\u00bdD\3\2\2\2\u00be\u00c0\t"+
		"\t\2\2\u00bf\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1"+
		"\u00c2\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\b#\3\2\u00c4F\3\2\2\2\u00c5"+
		"\u00c6\7\60\2\2\u00c6H\3\2\2\2\r\2^`mo\u0082\u009e\u00a3\u00b4\u00bc\u00c1";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}