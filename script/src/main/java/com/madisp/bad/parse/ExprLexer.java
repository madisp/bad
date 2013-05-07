// Generated from /home/madis/cryptodev/git/bad/script/src/main/grammar/Expr.g4 by ANTLR 4.0
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
		T__5=1, T__4=2, T__3=3, T__2=4, T__1=5, T__0=6, STRING=7, DOUBLE=8, NOT=9, 
		AND=10, ASSIGN=11, OR=12, INT=13, TRUE=14, FALSE=15, NULL=16, PLUS=17, 
		MINUS=18, SLASH=19, STAR=20, IDENTIFIER=21, ESCAPE=22, DOLLAR=23, WS=24, 
		DOT=25;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"')'", "','", "'('", "'@'", "':'", "';'", "STRING", "DOUBLE", "'!'", "'and'", 
		"'='", "'or'", "INT", "'true'", "'false'", "'null'", "'+'", "'-'", "'/'", 
		"'*'", "IDENTIFIER", "ESCAPE", "'$'", "WS", "'.'"
	};
	public static final String[] ruleNames = {
		"T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "STRING", "DOUBLE", "ESC", 
		"NOT", "AND", "ASSIGN", "OR", "INT", "TRUE", "FALSE", "NULL", "PLUS", 
		"MINUS", "SLASH", "STAR", "IDENTIFIER", "ESCAPE", "DIGIT", "UPPERC", "LOWERC", 
		"UNDERS", "ALPHA", "DOLLAR", "ALPHANUMERIC", "WS", "DOT"
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
		case 6: STRING_action((RuleContext)_localctx, actionIndex); break;

		case 30: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\2\4\33\u00b9\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\4\37\t\37\4 \t \4!\t!\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3"+
		"\7\3\7\3\b\3\b\3\b\7\bS\n\b\f\b\16\bV\13\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\5\tb\n\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3"+
		"\16\3\16\3\16\3\17\6\17s\n\17\r\17\16\17t\3\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\24\3\24"+
		"\3\25\3\25\3\26\3\26\3\27\3\27\5\27\u0091\n\27\3\27\7\27\u0094\n\27\f"+
		"\27\16\27\u0097\13\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34"+
		"\3\34\3\35\3\35\3\35\5\35\u00a7\n\35\3\36\3\36\3\37\3\37\3\37\3\37\5\37"+
		"\u00af\n\37\3 \6 \u00b2\n \r \16 \u00b3\3 \3 \3!\3!\2\"\3\3\1\5\4\1\7"+
		"\5\1\t\6\1\13\7\1\r\b\1\17\t\2\21\n\1\23\2\1\25\13\1\27\f\1\31\r\1\33"+
		"\16\1\35\17\1\37\20\1!\21\1#\22\1%\23\1\'\24\1)\25\1+\26\1-\27\1/\30\1"+
		"\61\2\1\63\2\1\65\2\1\67\2\19\2\1;\31\1=\2\1?\32\3A\33\1\3\2\b\4$$^^\7"+
		"$$^^ppttvv\4$$^^\3C\\\3c|\5\13\f\16\17\"\"\u00bd\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2;\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2"+
		"\3C\3\2\2\2\5E\3\2\2\2\7G\3\2\2\2\tI\3\2\2\2\13K\3\2\2\2\rM\3\2\2\2\17"+
		"O\3\2\2\2\21a\3\2\2\2\23c\3\2\2\2\25f\3\2\2\2\27h\3\2\2\2\31l\3\2\2\2"+
		"\33n\3\2\2\2\35r\3\2\2\2\37v\3\2\2\2!{\3\2\2\2#\u0081\3\2\2\2%\u0086\3"+
		"\2\2\2\'\u0088\3\2\2\2)\u008a\3\2\2\2+\u008c\3\2\2\2-\u0090\3\2\2\2/\u0098"+
		"\3\2\2\2\61\u009b\3\2\2\2\63\u009d\3\2\2\2\65\u009f\3\2\2\2\67\u00a1\3"+
		"\2\2\29\u00a6\3\2\2\2;\u00a8\3\2\2\2=\u00ae\3\2\2\2?\u00b1\3\2\2\2A\u00b7"+
		"\3\2\2\2CD\7+\2\2D\4\3\2\2\2EF\7.\2\2F\6\3\2\2\2GH\7*\2\2H\b\3\2\2\2I"+
		"J\7B\2\2J\n\3\2\2\2KL\7<\2\2L\f\3\2\2\2MN\7=\2\2N\16\3\2\2\2OT\7$\2\2"+
		"PS\5\23\n\2QS\n\2\2\2RP\3\2\2\2RQ\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2"+
		"\2UW\3\2\2\2VT\3\2\2\2WX\7$\2\2XY\b\b\2\2Y\20\3\2\2\2Z[\5\35\17\2[\\\7"+
		"f\2\2\\b\3\2\2\2]^\5\35\17\2^_\7\60\2\2_`\5\35\17\2`b\3\2\2\2aZ\3\2\2"+
		"\2a]\3\2\2\2b\22\3\2\2\2cd\7^\2\2de\t\3\2\2e\24\3\2\2\2fg\7#\2\2g\26\3"+
		"\2\2\2hi\7c\2\2ij\7p\2\2jk\7f\2\2k\30\3\2\2\2lm\7?\2\2m\32\3\2\2\2no\7"+
		"q\2\2op\7t\2\2p\34\3\2\2\2qs\5\61\31\2rq\3\2\2\2st\3\2\2\2tr\3\2\2\2t"+
		"u\3\2\2\2u\36\3\2\2\2vw\7v\2\2wx\7t\2\2xy\7w\2\2yz\7g\2\2z \3\2\2\2{|"+
		"\7h\2\2|}\7c\2\2}~\7n\2\2~\177\7u\2\2\177\u0080\7g\2\2\u0080\"\3\2\2\2"+
		"\u0081\u0082\7p\2\2\u0082\u0083\7w\2\2\u0083\u0084\7n\2\2\u0084\u0085"+
		"\7n\2\2\u0085$\3\2\2\2\u0086\u0087\7-\2\2\u0087&\3\2\2\2\u0088\u0089\7"+
		"/\2\2\u0089(\3\2\2\2\u008a\u008b\7\61\2\2\u008b*\3\2\2\2\u008c\u008d\7"+
		",\2\2\u008d,\3\2\2\2\u008e\u0091\59\35\2\u008f\u0091\5;\36\2\u0090\u008e"+
		"\3\2\2\2\u0090\u008f\3\2\2\2\u0091\u0095\3\2\2\2\u0092\u0094\5=\37\2\u0093"+
		"\u0092\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2"+
		"\2\2\u0096.\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u0099\7^\2\2\u0099\u009a"+
		"\t\4\2\2\u009a\60\3\2\2\2\u009b\u009c\4\62;\2\u009c\62\3\2\2\2\u009d\u009e"+
		"\t\5\2\2\u009e\64\3\2\2\2\u009f\u00a0\t\6\2\2\u00a0\66\3\2\2\2\u00a1\u00a2"+
		"\7a\2\2\u00a28\3\2\2\2\u00a3\u00a7\5\63\32\2\u00a4\u00a7\5\65\33\2\u00a5"+
		"\u00a7\5\67\34\2\u00a6\u00a3\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a5\3"+
		"\2\2\2\u00a7:\3\2\2\2\u00a8\u00a9\7&\2\2\u00a9<\3\2\2\2\u00aa\u00af\5"+
		"\63\32\2\u00ab\u00af\5\65\33\2\u00ac\u00af\5\67\34\2\u00ad\u00af\5\61"+
		"\31\2\u00ae\u00aa\3\2\2\2\u00ae\u00ab\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae"+
		"\u00ad\3\2\2\2\u00af>\3\2\2\2\u00b0\u00b2\t\7\2\2\u00b1\u00b0\3\2\2\2"+
		"\u00b2\u00b3\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5"+
		"\3\2\2\2\u00b5\u00b6\b \3\2\u00b6@\3\2\2\2\u00b7\u00b8\7\60\2\2\u00b8"+
		"B\3\2\2\2\f\2RTat\u0090\u0095\u00a6\u00ae\u00b3";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}