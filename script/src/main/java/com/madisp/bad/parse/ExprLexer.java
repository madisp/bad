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
		T__6=1, T__5=2, T__4=3, T__3=4, T__2=5, T__1=6, T__0=7, STRING=8, NOT=9, 
		AND=10, ASSIGN=11, OR=12, INT=13, TRUE=14, FALSE=15, NULL=16, IDENTIFIER=17, 
		ESCAPE=18, DOLLAR=19, WS=20, DOT=21;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"')'", "','", "'('", "'@'", "':'", "'/'", "';'", "STRING", "'!'", "'and'", 
		"'='", "'or'", "INT", "'true'", "'false'", "'null'", "IDENTIFIER", "ESCAPE", 
		"'$'", "WS", "'.'"
	};
	public static final String[] ruleNames = {
		"T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "STRING", "ESC", 
		"NOT", "AND", "ASSIGN", "OR", "INT", "TRUE", "FALSE", "NULL", "IDENTIFIER", 
		"ESCAPE", "DIGIT", "UPPERC", "LOWERC", "UNDERS", "ALPHA", "DOLLAR", "ALPHANUMERIC", 
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
		case 7: STRING_action((RuleContext)_localctx, actionIndex); break;

		case 26: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\2\4\27\u00a2\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\7\tM"+
		"\n\t\f\t\16\tP\13\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\3\r\3\r\3\16\3\16\3\16\3\17\6\17d\n\17\r\17\16\17e\3\20\3\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23"+
		"\5\23z\n\23\3\23\7\23}\n\23\f\23\16\23\u0080\13\23\3\24\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\5\31\u0090\n\31\3\32"+
		"\3\32\3\33\3\33\3\33\3\33\5\33\u0098\n\33\3\34\6\34\u009b\n\34\r\34\16"+
		"\34\u009c\3\34\3\34\3\35\3\35\2\36\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b"+
		"\1\17\t\1\21\n\2\23\2\1\25\13\1\27\f\1\31\r\1\33\16\1\35\17\1\37\20\1"+
		"!\21\1#\22\1%\23\1\'\24\1)\2\1+\2\1-\2\1/\2\1\61\2\1\63\25\1\65\2\1\67"+
		"\26\39\27\1\3\2\b\4$$^^\7$$^^ppttvv\4$$^^\3C\\\3c|\5\13\f\16\17\"\"\u00a5"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2\63\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\3;\3\2\2\2\5=\3\2"+
		"\2\2\7?\3\2\2\2\tA\3\2\2\2\13C\3\2\2\2\rE\3\2\2\2\17G\3\2\2\2\21I\3\2"+
		"\2\2\23T\3\2\2\2\25W\3\2\2\2\27Y\3\2\2\2\31]\3\2\2\2\33_\3\2\2\2\35c\3"+
		"\2\2\2\37g\3\2\2\2!l\3\2\2\2#r\3\2\2\2%y\3\2\2\2\'\u0081\3\2\2\2)\u0084"+
		"\3\2\2\2+\u0086\3\2\2\2-\u0088\3\2\2\2/\u008a\3\2\2\2\61\u008f\3\2\2\2"+
		"\63\u0091\3\2\2\2\65\u0097\3\2\2\2\67\u009a\3\2\2\29\u00a0\3\2\2\2;<\7"+
		"+\2\2<\4\3\2\2\2=>\7.\2\2>\6\3\2\2\2?@\7*\2\2@\b\3\2\2\2AB\7B\2\2B\n\3"+
		"\2\2\2CD\7<\2\2D\f\3\2\2\2EF\7\61\2\2F\16\3\2\2\2GH\7=\2\2H\20\3\2\2\2"+
		"IN\7$\2\2JM\5\23\n\2KM\n\2\2\2LJ\3\2\2\2LK\3\2\2\2MP\3\2\2\2NL\3\2\2\2"+
		"NO\3\2\2\2OQ\3\2\2\2PN\3\2\2\2QR\7$\2\2RS\b\t\2\2S\22\3\2\2\2TU\7^\2\2"+
		"UV\t\3\2\2V\24\3\2\2\2WX\7#\2\2X\26\3\2\2\2YZ\7c\2\2Z[\7p\2\2[\\\7f\2"+
		"\2\\\30\3\2\2\2]^\7?\2\2^\32\3\2\2\2_`\7q\2\2`a\7t\2\2a\34\3\2\2\2bd\5"+
		")\25\2cb\3\2\2\2de\3\2\2\2ec\3\2\2\2ef\3\2\2\2f\36\3\2\2\2gh\7v\2\2hi"+
		"\7t\2\2ij\7w\2\2jk\7g\2\2k \3\2\2\2lm\7h\2\2mn\7c\2\2no\7n\2\2op\7u\2"+
		"\2pq\7g\2\2q\"\3\2\2\2rs\7p\2\2st\7w\2\2tu\7n\2\2uv\7n\2\2v$\3\2\2\2w"+
		"z\5\61\31\2xz\5\63\32\2yw\3\2\2\2yx\3\2\2\2z~\3\2\2\2{}\5\65\33\2|{\3"+
		"\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177&\3\2\2\2\u0080~\3\2\2"+
		"\2\u0081\u0082\7^\2\2\u0082\u0083\t\4\2\2\u0083(\3\2\2\2\u0084\u0085\4"+
		"\62;\2\u0085*\3\2\2\2\u0086\u0087\t\5\2\2\u0087,\3\2\2\2\u0088\u0089\t"+
		"\6\2\2\u0089.\3\2\2\2\u008a\u008b\7a\2\2\u008b\60\3\2\2\2\u008c\u0090"+
		"\5+\26\2\u008d\u0090\5-\27\2\u008e\u0090\5/\30\2\u008f\u008c\3\2\2\2\u008f"+
		"\u008d\3\2\2\2\u008f\u008e\3\2\2\2\u0090\62\3\2\2\2\u0091\u0092\7&\2\2"+
		"\u0092\64\3\2\2\2\u0093\u0098\5+\26\2\u0094\u0098\5-\27\2\u0095\u0098"+
		"\5/\30\2\u0096\u0098\5)\25\2\u0097\u0093\3\2\2\2\u0097\u0094\3\2\2\2\u0097"+
		"\u0095\3\2\2\2\u0097\u0096\3\2\2\2\u0098\66\3\2\2\2\u0099\u009b\t\7\2"+
		"\2\u009a\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d"+
		"\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\b\34\3\2\u009f8\3\2\2\2\u00a0"+
		"\u00a1\7\60\2\2\u00a1:\3\2\2\2\13\2LNey~\u008f\u0097\u009c";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}