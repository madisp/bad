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
		T__2=1, T__1=2, T__0=3, STRING=4, NOT=5, AND=6, OR=7, INT=8, TRUE=9, FALSE=10, 
		NULL=11, IDENTIFIER=12, ESCAPE=13, WS=14;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"')'", "','", "'('", "STRING", "'!'", "'and'", "'or'", "INT", "'true'", 
		"'false'", "'null'", "IDENTIFIER", "ESCAPE", "WS"
	};
	public static final String[] ruleNames = {
		"T__2", "T__1", "T__0", "STRING", "ESC", "NOT", "AND", "OR", "INT", "TRUE", 
		"FALSE", "NULL", "IDENTIFIER", "ESCAPE", "DIGIT", "UPPERC", "LOWERC", 
		"UNDERS", "ALPHA", "ALPHANUMERIC", "WS"
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
		case 3: STRING_action((RuleContext)_localctx, actionIndex); break;

		case 20: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\2\4\20\u0083\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\7\5\67\n\5\f\5\16\5:\13\5\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\6\nL\n\n\r\n\16\n"+
		"M\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r"+
		"\3\16\3\16\7\16b\n\16\f\16\16\16e\13\16\3\17\3\17\3\17\3\20\3\20\3\21"+
		"\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\5\24u\n\24\3\25\3\25\3\25\3\25"+
		"\5\25{\n\25\3\26\6\26~\n\26\r\26\16\26\177\3\26\3\26\2\27\3\3\1\5\4\1"+
		"\7\5\1\t\6\2\13\2\1\r\7\1\17\b\1\21\t\1\23\n\1\25\13\1\27\f\1\31\r\1\33"+
		"\16\1\35\17\1\37\2\1!\2\1#\2\1%\2\1\'\2\1)\2\1+\20\3\3\2\b\4$$^^\7$$^"+
		"^ppttvv\4$$^^\3C\\\3c|\5\13\f\16\17\"\"\u0085\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2+\3\2\2\2\3-\3\2\2\2\5/\3\2\2\2\7\61\3\2\2\2\t\63\3\2\2\2\13>\3\2"+
		"\2\2\rA\3\2\2\2\17C\3\2\2\2\21G\3\2\2\2\23K\3\2\2\2\25O\3\2\2\2\27T\3"+
		"\2\2\2\31Z\3\2\2\2\33_\3\2\2\2\35f\3\2\2\2\37i\3\2\2\2!k\3\2\2\2#m\3\2"+
		"\2\2%o\3\2\2\2\'t\3\2\2\2)z\3\2\2\2+}\3\2\2\2-.\7+\2\2.\4\3\2\2\2/\60"+
		"\7.\2\2\60\6\3\2\2\2\61\62\7*\2\2\62\b\3\2\2\2\638\7$\2\2\64\67\5\13\6"+
		"\2\65\67\n\2\2\2\66\64\3\2\2\2\66\65\3\2\2\2\67:\3\2\2\28\66\3\2\2\28"+
		"9\3\2\2\29;\3\2\2\2:8\3\2\2\2;<\7$\2\2<=\b\5\2\2=\n\3\2\2\2>?\7^\2\2?"+
		"@\t\3\2\2@\f\3\2\2\2AB\7#\2\2B\16\3\2\2\2CD\7c\2\2DE\7p\2\2EF\7f\2\2F"+
		"\20\3\2\2\2GH\7q\2\2HI\7t\2\2I\22\3\2\2\2JL\5\37\20\2KJ\3\2\2\2LM\3\2"+
		"\2\2MK\3\2\2\2MN\3\2\2\2N\24\3\2\2\2OP\7v\2\2PQ\7t\2\2QR\7w\2\2RS\7g\2"+
		"\2S\26\3\2\2\2TU\7h\2\2UV\7c\2\2VW\7n\2\2WX\7u\2\2XY\7g\2\2Y\30\3\2\2"+
		"\2Z[\7p\2\2[\\\7w\2\2\\]\7n\2\2]^\7n\2\2^\32\3\2\2\2_c\5\'\24\2`b\5)\25"+
		"\2a`\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2d\34\3\2\2\2ec\3\2\2\2fg\7^"+
		"\2\2gh\t\4\2\2h\36\3\2\2\2ij\4\62;\2j \3\2\2\2kl\t\5\2\2l\"\3\2\2\2mn"+
		"\t\6\2\2n$\3\2\2\2op\7a\2\2p&\3\2\2\2qu\5!\21\2ru\5#\22\2su\5%\23\2tq"+
		"\3\2\2\2tr\3\2\2\2ts\3\2\2\2u(\3\2\2\2v{\5!\21\2w{\5#\22\2x{\5%\23\2y"+
		"{\5\37\20\2zv\3\2\2\2zw\3\2\2\2zx\3\2\2\2zy\3\2\2\2{*\3\2\2\2|~\t\7\2"+
		"\2}|\3\2\2\2~\177\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\3"+
		"\2\2\2\u0081\u0082\b\26\3\2\u0082,\3\2\2\2\n\2\668Mctz\177";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}