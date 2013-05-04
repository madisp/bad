// Generated from Expr.g4 by ANTLR 4.0
package com.madisp.bad.parse;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__3=1, T__2=2, T__1=3, T__0=4, STRING=5, NOT=6, AND=7, ASSIGN=8, OR=9, 
		INT=10, TRUE=11, FALSE=12, NULL=13, IDENTIFIER=14, ESCAPE=15, DOLLAR=16, 
		WS=17, DOT=18;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"')'", "','", "'('", "';'", "STRING", "'!'", "'and'", "'='", "'or'", "INT", 
		"'true'", "'false'", "'null'", "IDENTIFIER", "ESCAPE", "'$'", "WS", "'.'"
	};
	public static final String[] ruleNames = {
		"T__3", "T__2", "T__1", "T__0", "STRING", "ESC", "NOT", "AND", "ASSIGN", 
		"OR", "INT", "TRUE", "FALSE", "NULL", "IDENTIFIER", "ESCAPE", "DIGIT", 
		"UPPERC", "LOWERC", "UNDERS", "ALPHA", "DOLLAR", "ALPHANUMERIC", "WS", 
		"DOT"
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
		case 4: STRING_action((RuleContext)_localctx, actionIndex); break;

		case 23: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\2\4\24\u0096\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\6\7\6A\n\6\f\6\16\6D\13\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\6\fX\n\f\r\f\16\fY\3\r\3\r\3\r"+
		"\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3"+
		"\20\5\20n\n\20\3\20\7\20q\n\20\f\20\16\20t\13\20\3\21\3\21\3\21\3\22\3"+
		"\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\5\26\u0084\n\26\3\27"+
		"\3\27\3\30\3\30\3\30\3\30\5\30\u008c\n\30\3\31\6\31\u008f\n\31\r\31\16"+
		"\31\u0090\3\31\3\31\3\32\3\32\2\33\3\3\1\5\4\1\7\5\1\t\6\1\13\7\2\r\2"+
		"\1\17\b\1\21\t\1\23\n\1\25\13\1\27\f\1\31\r\1\33\16\1\35\17\1\37\20\1"+
		"!\21\1#\2\1%\2\1\'\2\1)\2\1+\2\1-\22\1/\2\1\61\23\3\63\24\1\3\2\b\4$$"+
		"^^\7$$^^ppttvv\4$$^^\3C\\\3c|\5\13\f\16\17\"\"\u0099\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2-\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\3\65\3\2\2\2\5\67\3\2\2\2\79\3\2\2\2\t;\3\2\2\2\13=\3\2\2\2\rH\3\2\2"+
		"\2\17K\3\2\2\2\21M\3\2\2\2\23Q\3\2\2\2\25S\3\2\2\2\27W\3\2\2\2\31[\3\2"+
		"\2\2\33`\3\2\2\2\35f\3\2\2\2\37m\3\2\2\2!u\3\2\2\2#x\3\2\2\2%z\3\2\2\2"+
		"\'|\3\2\2\2)~\3\2\2\2+\u0083\3\2\2\2-\u0085\3\2\2\2/\u008b\3\2\2\2\61"+
		"\u008e\3\2\2\2\63\u0094\3\2\2\2\65\66\7+\2\2\66\4\3\2\2\2\678\7.\2\28"+
		"\6\3\2\2\29:\7*\2\2:\b\3\2\2\2;<\7=\2\2<\n\3\2\2\2=B\7$\2\2>A\5\r\7\2"+
		"?A\n\2\2\2@>\3\2\2\2@?\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2CE\3\2\2\2"+
		"DB\3\2\2\2EF\7$\2\2FG\b\6\2\2G\f\3\2\2\2HI\7^\2\2IJ\t\3\2\2J\16\3\2\2"+
		"\2KL\7#\2\2L\20\3\2\2\2MN\7c\2\2NO\7p\2\2OP\7f\2\2P\22\3\2\2\2QR\7?\2"+
		"\2R\24\3\2\2\2ST\7q\2\2TU\7t\2\2U\26\3\2\2\2VX\5#\22\2WV\3\2\2\2XY\3\2"+
		"\2\2YW\3\2\2\2YZ\3\2\2\2Z\30\3\2\2\2[\\\7v\2\2\\]\7t\2\2]^\7w\2\2^_\7"+
		"g\2\2_\32\3\2\2\2`a\7h\2\2ab\7c\2\2bc\7n\2\2cd\7u\2\2de\7g\2\2e\34\3\2"+
		"\2\2fg\7p\2\2gh\7w\2\2hi\7n\2\2ij\7n\2\2j\36\3\2\2\2kn\5+\26\2ln\5-\27"+
		"\2mk\3\2\2\2ml\3\2\2\2nr\3\2\2\2oq\5/\30\2po\3\2\2\2qt\3\2\2\2rp\3\2\2"+
		"\2rs\3\2\2\2s \3\2\2\2tr\3\2\2\2uv\7^\2\2vw\t\4\2\2w\"\3\2\2\2xy\4\62"+
		";\2y$\3\2\2\2z{\t\5\2\2{&\3\2\2\2|}\t\6\2\2}(\3\2\2\2~\177\7a\2\2\177"+
		"*\3\2\2\2\u0080\u0084\5%\23\2\u0081\u0084\5\'\24\2\u0082\u0084\5)\25\2"+
		"\u0083\u0080\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0082\3\2\2\2\u0084,\3"+
		"\2\2\2\u0085\u0086\7&\2\2\u0086.\3\2\2\2\u0087\u008c\5%\23\2\u0088\u008c"+
		"\5\'\24\2\u0089\u008c\5)\25\2\u008a\u008c\5#\22\2\u008b\u0087\3\2\2\2"+
		"\u008b\u0088\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008a\3\2\2\2\u008c\60"+
		"\3\2\2\2\u008d\u008f\t\7\2\2\u008e\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090"+
		"\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\b\31"+
		"\3\2\u0093\62\3\2\2\2\u0094\u0095\7\60\2\2\u0095\64\3\2\2\2\13\2@BYmr"+
		"\u0083\u008b\u0090";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}