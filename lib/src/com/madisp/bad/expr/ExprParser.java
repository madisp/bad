// Generated from Expr.g4 by ANTLR 4.0
package com.madisp.bad.expr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__2=1, T__1=2, T__0=3, STRING=4, NOT=5, AND=6, OR=7, INT=8, TRUE=9, FALSE=10, 
		NULL=11, IDENTIFIER=12, ESCAPE=13, WS=14;
	public static final String[] tokenNames = {
		"<INVALID>", "')'", "','", "'('", "STRING", "'!'", "'and'", "'or'", "INT", 
		"'true'", "'false'", "'null'", "IDENTIFIER", "ESCAPE", "WS"
	};
	public static final int
		RULE_line = 0, RULE_expr = 1, RULE_value = 2, RULE_variable = 3, RULE_call = 4, 
		RULE_argslist = 5, RULE_bool = 6;
	public static final String[] ruleNames = {
		"line", "expr", "value", "variable", "call", "argslist", "bool"
	};

	@Override
	public String getGrammarFileName() { return "Expr.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class LineContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ExprParser.EOF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14); expr(0);
			setState(15); match(EOF);
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

	public static class ExprContext extends ParserRuleContext {
		public int _p;
		public ExprContext left;
		public ExprContext center;
		public ExprContext right;
		public TerminalNode NOT() { return getToken(ExprParser.NOT, 0); }
		public TerminalNode AND() { return getToken(ExprParser.AND, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode OR() { return getToken(ExprParser.OR, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExprContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState, _p);
		ExprContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, RULE_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			switch (_input.LA(1)) {
			case NOT:
				{
				setState(18); match(NOT);
				setState(19); ((ExprContext)_localctx).center = expr(5);
				}
				break;
			case 3:
				{
				setState(20); match(3);
				setState(21); ((ExprContext)_localctx).center = expr(0);
				setState(22); match(1);
				}
				break;
			case STRING:
			case TRUE:
			case FALSE:
			case NULL:
			case IDENTIFIER:
				{
				setState(24); value();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(35);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(33);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(27);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(28); match(AND);
						setState(29); ((ExprContext)_localctx).right = expr(5);
						}
						break;

					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(30);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(31); match(OR);
						setState(32); ((ExprContext)_localctx).right = expr(4);
						}
						break;
					}
					} 
				}
				setState(37);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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

	public static class ValueContext extends ParserRuleContext {
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode STRING() { return getToken(ExprParser.STRING, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_value);
		try {
			setState(42);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(38); variable();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(39); call();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(40); bool();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(41); match(STRING);
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

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ExprParser.IDENTIFIER, 0); }
		public TerminalNode NULL() { return getToken(ExprParser.NULL, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			_la = _input.LA(1);
			if ( !(_la==NULL || _la==IDENTIFIER) ) {
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

	public static class CallContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ExprParser.IDENTIFIER, 0); }
		public ArgslistContext argslist() {
			return getRuleContext(ArgslistContext.class,0);
		}
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46); match(IDENTIFIER);
			setState(47); match(3);
			setState(48); argslist();
			setState(49); match(1);
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

	public static class ArgslistContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArgslistContext argslist() {
			return getRuleContext(ArgslistContext.class,0);
		}
		public ArgslistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argslist; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitArgslist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgslistContext argslist() throws RecognitionException {
		ArgslistContext _localctx = new ArgslistContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_argslist);
		try {
			setState(57);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(51); expr(0);
				setState(52); match(2);
				setState(53); argslist();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(55); expr(0);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
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

	public static class BoolContext extends ParserRuleContext {
		public TerminalNode FALSE() { return getToken(ExprParser.FALSE, 0); }
		public TerminalNode TRUE() { return getToken(ExprParser.TRUE, 0); }
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 4 >= _localctx._p;

		case 1: return 3 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\2\3\20@\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\34\n\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\7\3$\n\3\f\3\16\3\'\13\3\3\4\3\4\3\4\3\4\5\4-\n\4\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7<\n\7\3\b\3\b\3\b\2\t\2\4\6\b"+
		"\n\f\16\2\4\3\r\16\3\13\fA\2\20\3\2\2\2\4\33\3\2\2\2\6,\3\2\2\2\b.\3\2"+
		"\2\2\n\60\3\2\2\2\f;\3\2\2\2\16=\3\2\2\2\20\21\5\4\3\2\21\22\7\1\2\2\22"+
		"\3\3\2\2\2\23\24\b\3\1\2\24\25\7\7\2\2\25\34\5\4\3\2\26\27\7\5\2\2\27"+
		"\30\5\4\3\2\30\31\7\3\2\2\31\34\3\2\2\2\32\34\5\6\4\2\33\23\3\2\2\2\33"+
		"\26\3\2\2\2\33\32\3\2\2\2\34%\3\2\2\2\35\36\6\3\2\3\36\37\7\b\2\2\37$"+
		"\5\4\3\2 !\6\3\3\3!\"\7\t\2\2\"$\5\4\3\2#\35\3\2\2\2# \3\2\2\2$\'\3\2"+
		"\2\2%#\3\2\2\2%&\3\2\2\2&\5\3\2\2\2\'%\3\2\2\2(-\5\b\5\2)-\5\n\6\2*-\5"+
		"\16\b\2+-\7\6\2\2,(\3\2\2\2,)\3\2\2\2,*\3\2\2\2,+\3\2\2\2-\7\3\2\2\2."+
		"/\t\2\2\2/\t\3\2\2\2\60\61\7\16\2\2\61\62\7\5\2\2\62\63\5\f\7\2\63\64"+
		"\7\3\2\2\64\13\3\2\2\2\65\66\5\4\3\2\66\67\7\4\2\2\678\5\f\7\28<\3\2\2"+
		"\29<\5\4\3\2:<\3\2\2\2;\65\3\2\2\2;9\3\2\2\2;:\3\2\2\2<\r\3\2\2\2=>\t"+
		"\3\2\2>\17\3\2\2\2\7\33#%,;";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}