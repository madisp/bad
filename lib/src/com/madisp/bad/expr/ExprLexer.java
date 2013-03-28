// Generated from Expr.g4 by ANTLR 4.0
package com.madisp.bad.expr;
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
		T__3=1, T__2=2, T__1=3, T__0=4, STRING=5, NOT=6, AND=7, ASSIGN=8, OR=9, 
		INT=10, TRUE=11, FALSE=12, NULL=13, IDENTIFIER=14, ESCAPE=15, WS=16, DOT=17;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"')'", "','", "'('", "';'", "STRING", "'!'", "'and'", "'='", "'or'", "INT", 
		"'true'", "'false'", "'null'", "IDENTIFIER", "ESCAPE", "WS", "'.'"
	};
	public static final String[] ruleNames = {
		"T__3", "T__2", "T__1", "T__0", "STRING", "ESC", "NOT", "AND", "ASSIGN", 
		"OR", "INT", "TRUE", "FALSE", "NULL", "IDENTIFIER", "ESCAPE", "DIGIT", 
		"UPPERC", "LOWERC", "UNDERS", "ALPHA", "ALPHANUMERIC", "WS", "DOT"
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

		case 22: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\2\4\23\u008f\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6"+
		"\7\6?\n\6\f\6\16\6B\13\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\3\n\3\n\3\13\3\13\3\13\3\f\6\fV\n\f\r\f\16\fW\3\r\3\r\3\r\3\r\3\r\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\7\20l"+
		"\n\20\f\20\16\20o\13\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3"+
		"\25\3\25\3\26\3\26\3\26\5\26\177\n\26\3\27\3\27\3\27\3\27\5\27\u0085\n"+
		"\27\3\30\6\30\u0088\n\30\r\30\16\30\u0089\3\30\3\30\3\31\3\31\2\32\3\3"+
		"\1\5\4\1\7\5\1\t\6\1\13\7\2\r\2\1\17\b\1\21\t\1\23\n\1\25\13\1\27\f\1"+
		"\31\r\1\33\16\1\35\17\1\37\20\1!\21\1#\2\1%\2\1\'\2\1)\2\1+\2\1-\2\1/"+
		"\22\3\61\23\1\3\2\b\4$$^^\7$$^^ppttvv\4$$^^\3C\\\3c|\5\13\f\16\17\"\""+
		"\u0091\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\3\63\3\2\2\2\5\65\3\2\2\2\7\67\3\2\2\2\t9\3\2\2\2\13;\3\2"+
		"\2\2\rF\3\2\2\2\17I\3\2\2\2\21K\3\2\2\2\23O\3\2\2\2\25Q\3\2\2\2\27U\3"+
		"\2\2\2\31Y\3\2\2\2\33^\3\2\2\2\35d\3\2\2\2\37i\3\2\2\2!p\3\2\2\2#s\3\2"+
		"\2\2%u\3\2\2\2\'w\3\2\2\2)y\3\2\2\2+~\3\2\2\2-\u0084\3\2\2\2/\u0087\3"+
		"\2\2\2\61\u008d\3\2\2\2\63\64\7+\2\2\64\4\3\2\2\2\65\66\7.\2\2\66\6\3"+
		"\2\2\2\678\7*\2\28\b\3\2\2\29:\7=\2\2:\n\3\2\2\2;@\7$\2\2<?\5\r\7\2=?"+
		"\n\2\2\2><\3\2\2\2>=\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2AC\3\2\2\2B"+
		"@\3\2\2\2CD\7$\2\2DE\b\6\2\2E\f\3\2\2\2FG\7^\2\2GH\t\3\2\2H\16\3\2\2\2"+
		"IJ\7#\2\2J\20\3\2\2\2KL\7c\2\2LM\7p\2\2MN\7f\2\2N\22\3\2\2\2OP\7?\2\2"+
		"P\24\3\2\2\2QR\7q\2\2RS\7t\2\2S\26\3\2\2\2TV\5#\22\2UT\3\2\2\2VW\3\2\2"+
		"\2WU\3\2\2\2WX\3\2\2\2X\30\3\2\2\2YZ\7v\2\2Z[\7t\2\2[\\\7w\2\2\\]\7g\2"+
		"\2]\32\3\2\2\2^_\7h\2\2_`\7c\2\2`a\7n\2\2ab\7u\2\2bc\7g\2\2c\34\3\2\2"+
		"\2de\7p\2\2ef\7w\2\2fg\7n\2\2gh\7n\2\2h\36\3\2\2\2im\5+\26\2jl\5-\27\2"+
		"kj\3\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2n \3\2\2\2om\3\2\2\2pq\7^\2\2"+
		"qr\t\4\2\2r\"\3\2\2\2st\4\62;\2t$\3\2\2\2uv\t\5\2\2v&\3\2\2\2wx\t\6\2"+
		"\2x(\3\2\2\2yz\7a\2\2z*\3\2\2\2{\177\5%\23\2|\177\5\'\24\2}\177\5)\25"+
		"\2~{\3\2\2\2~|\3\2\2\2~}\3\2\2\2\177,\3\2\2\2\u0080\u0085\5%\23\2\u0081"+
		"\u0085\5\'\24\2\u0082\u0085\5)\25\2\u0083\u0085\5#\22\2\u0084\u0080\3"+
		"\2\2\2\u0084\u0081\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0083\3\2\2\2\u0085"+
		".\3\2\2\2\u0086\u0088\t\7\2\2\u0087\u0086\3\2\2\2\u0088\u0089\3\2\2\2"+
		"\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c"+
		"\b\30\3\2\u008c\60\3\2\2\2\u008d\u008e\7\60\2\2\u008e\62\3\2\2\2\n\2>"+
		"@Wm~\u0084\u0089";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}