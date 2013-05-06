// Generated from /home/madis/cryptodev/git/bad/script/src/main/grammar/Expr.g4 by ANTLR 4.0
package com.madisp.bad.parse;
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
		T__6=1, T__5=2, T__4=3, T__3=4, T__2=5, T__1=6, T__0=7, STRING=8, NOT=9, 
		AND=10, ASSIGN=11, OR=12, INT=13, TRUE=14, FALSE=15, NULL=16, IDENTIFIER=17, 
		ESCAPE=18, DOLLAR=19, WS=20, DOT=21;
	public static final String[] tokenNames = {
		"<INVALID>", "')'", "','", "'('", "'@'", "':'", "'/'", "';'", "STRING", 
		"'!'", "'and'", "'='", "'or'", "INT", "'true'", "'false'", "'null'", "IDENTIFIER", 
		"ESCAPE", "'$'", "WS", "'.'"
	};
	public static final int
		RULE_line = 0, RULE_prog = 1, RULE_expr = 2, RULE_value = 3, RULE_constant = 4, 
		RULE_resource = 5, RULE_pckg = 6, RULE_variable = 7, RULE_call = 8, RULE_argslist = 9, 
		RULE_bool = 10;
	public static final String[] ruleNames = {
		"line", "prog", "expr", "value", "constant", "resource", "pckg", "variable", 
		"call", "argslist", "bool"
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
		public ProgContext prog() {
			return getRuleContext(ProgContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ExprParser.EOF, 0); }
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
			setState(22); prog();
			setState(23); match(EOF);
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

	public static class ProgContext extends ParserRuleContext {
		public ProgContext prog() {
			return getRuleContext(ProgContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_prog);
		try {
			setState(30);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(25); expr(0);
				setState(26); match(7);
				setState(27); prog();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(29); expr(0);
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

	public static class ExprContext extends ParserRuleContext {
		public int _p;
		public ExprContext left;
		public ExprContext center;
		public ValueContext leftVar;
		public ExprContext right;
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
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
		public TerminalNode ASSIGN() { return getToken(ExprParser.ASSIGN, 0); }
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
		int _startState = 4;
		enterRecursionRule(_localctx, RULE_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(33); match(NOT);
				setState(34); ((ExprContext)_localctx).center = expr(7);
				}
				break;

			case 2:
				{
				setState(35); ((ExprContext)_localctx).leftVar = value(0);
				setState(36); match(ASSIGN);
				setState(37); ((ExprContext)_localctx).right = expr(4);
				}
				break;

			case 3:
				{
				setState(39); match(3);
				setState(40); ((ExprContext)_localctx).center = expr(0);
				setState(41); match(1);
				}
				break;

			case 4:
				{
				setState(43); value(0);
				}
				break;

			case 5:
				{
				setState(44); constant();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(55);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(53);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(47);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(48); match(AND);
						setState(49); ((ExprContext)_localctx).right = expr(7);
						}
						break;

					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(50);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(51); match(OR);
						setState(52); ((ExprContext)_localctx).right = expr(6);
						}
						break;
					}
					} 
				}
				setState(57);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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
		public int _p;
		public ValueContext left;
		public ValueContext right;
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public TerminalNode DOT() { return getToken(ExprParser.DOT, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ValueContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ValueContext _localctx = new ValueContext(_ctx, _parentState, _p);
		ValueContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, RULE_value);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(59); call();
				}
				break;

			case 2:
				{
				setState(60); variable();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(68);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ValueContext(_parentctx, _parentState, _p);
					_localctx.left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_value);
					setState(63);
					if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
					setState(64); match(DOT);
					setState(65); ((ValueContext)_localctx).right = value(4);
					}
					} 
				}
				setState(70);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	public static class ConstantContext extends ParserRuleContext {
		public ResourceContext resource() {
			return getRuleContext(ResourceContext.class,0);
		}
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public TerminalNode STRING() { return getToken(ExprParser.STRING, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_constant);
		try {
			setState(74);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(71); bool();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(72); match(STRING);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 3);
				{
				setState(73); resource();
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

	public static class ResourceContext extends ParserRuleContext {
		public Token type;
		public Token name;
		public PckgContext pckg() {
			return getRuleContext(PckgContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(ExprParser.IDENTIFIER, 0); }
		public TerminalNode NULL() { return getToken(ExprParser.NULL, 0); }
		public ResourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resource; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitResource(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResourceContext resource() throws RecognitionException {
		ResourceContext _localctx = new ResourceContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_resource);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76); match(4);
			setState(86);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(80);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(77); pckg();
					setState(78); match(5);
					}
					break;
				}
				setState(82); ((ResourceContext)_localctx).type = match(IDENTIFIER);
				setState(83); match(6);
				setState(84); ((ResourceContext)_localctx).name = match(IDENTIFIER);
				}
				break;
			case NULL:
				{
				setState(85); match(NULL);
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

	public static class PckgContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER(int i) {
			return getToken(ExprParser.IDENTIFIER, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(ExprParser.IDENTIFIER); }
		public PckgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pckg; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitPckg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PckgContext pckg() throws RecognitionException {
		PckgContext _localctx = new PckgContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_pckg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88); match(IDENTIFIER);
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(89); match(DOT);
				setState(90); match(IDENTIFIER);
				}
				}
				setState(95);
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
		enterRule(_localctx, 14, RULE_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
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
		enterRule(_localctx, 16, RULE_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98); match(IDENTIFIER);
			setState(99); match(3);
			setState(100); argslist();
			setState(101); match(1);
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
		enterRule(_localctx, 18, RULE_argslist);
		try {
			setState(109);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(103); expr(0);
				setState(104); match(2);
				setState(105); argslist();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(107); expr(0);
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
		enterRule(_localctx, 20, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
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
		case 2: return expr_sempred((ExprContext)_localctx, predIndex);

		case 3: return value_sempred((ValueContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean value_sempred(ValueContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return 3 >= _localctx._p;
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 6 >= _localctx._p;

		case 1: return 5 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\2\3\27t\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t"+
		"\t\4\n\t\n\4\13\t\13\4\f\t\f\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3!\n\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\60\n\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\7\48\n\4\f\4\16\4;\13\4\3\5\3\5\3\5\5\5@\n\5\3\5\3"+
		"\5\3\5\7\5E\n\5\f\5\16\5H\13\5\3\6\3\6\3\6\5\6M\n\6\3\7\3\7\3\7\3\7\5"+
		"\7S\n\7\3\7\3\7\3\7\3\7\5\7Y\n\7\3\b\3\b\3\b\7\b^\n\b\f\b\16\ba\13\b\3"+
		"\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\5\13p\n\13\3"+
		"\f\3\f\3\f\2\r\2\4\6\b\n\f\16\20\22\24\26\2\4\3\22\23\3\20\21x\2\30\3"+
		"\2\2\2\4 \3\2\2\2\6/\3\2\2\2\b?\3\2\2\2\nL\3\2\2\2\fN\3\2\2\2\16Z\3\2"+
		"\2\2\20b\3\2\2\2\22d\3\2\2\2\24o\3\2\2\2\26q\3\2\2\2\30\31\5\4\3\2\31"+
		"\32\7\1\2\2\32\3\3\2\2\2\33\34\5\6\4\2\34\35\7\t\2\2\35\36\5\4\3\2\36"+
		"!\3\2\2\2\37!\5\6\4\2 \33\3\2\2\2 \37\3\2\2\2!\5\3\2\2\2\"#\b\4\1\2#$"+
		"\7\13\2\2$\60\5\6\4\2%&\5\b\5\2&\'\7\r\2\2\'(\5\6\4\2(\60\3\2\2\2)*\7"+
		"\5\2\2*+\5\6\4\2+,\7\3\2\2,\60\3\2\2\2-\60\5\b\5\2.\60\5\n\6\2/\"\3\2"+
		"\2\2/%\3\2\2\2/)\3\2\2\2/-\3\2\2\2/.\3\2\2\2\609\3\2\2\2\61\62\6\4\2\3"+
		"\62\63\7\f\2\2\638\5\6\4\2\64\65\6\4\3\3\65\66\7\16\2\2\668\5\6\4\2\67"+
		"\61\3\2\2\2\67\64\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:\7\3\2\2\2;"+
		"9\3\2\2\2<=\b\5\1\2=@\5\22\n\2>@\5\20\t\2?<\3\2\2\2?>\3\2\2\2@F\3\2\2"+
		"\2AB\6\5\4\3BC\7\27\2\2CE\5\b\5\2DA\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2"+
		"\2\2G\t\3\2\2\2HF\3\2\2\2IM\5\26\f\2JM\7\n\2\2KM\5\f\7\2LI\3\2\2\2LJ\3"+
		"\2\2\2LK\3\2\2\2M\13\3\2\2\2NX\7\6\2\2OP\5\16\b\2PQ\7\7\2\2QS\3\2\2\2"+
		"RO\3\2\2\2RS\3\2\2\2ST\3\2\2\2TU\7\23\2\2UV\7\b\2\2VY\7\23\2\2WY\7\22"+
		"\2\2XR\3\2\2\2XW\3\2\2\2Y\r\3\2\2\2Z_\7\23\2\2[\\\7\27\2\2\\^\7\23\2\2"+
		"][\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`\17\3\2\2\2a_\3\2\2\2bc\t\2\2"+
		"\2c\21\3\2\2\2de\7\23\2\2ef\7\5\2\2fg\5\24\13\2gh\7\3\2\2h\23\3\2\2\2"+
		"ij\5\6\4\2jk\7\4\2\2kl\5\24\13\2lp\3\2\2\2mp\5\6\4\2np\3\2\2\2oi\3\2\2"+
		"\2om\3\2\2\2on\3\2\2\2p\25\3\2\2\2qr\t\3\2\2r\27\3\2\2\2\r /\679?FLRX"+
		"_o";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}