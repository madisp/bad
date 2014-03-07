// Generated from /Users/madis/Code/github/bad/script/src/main/grammar/Expr.g4 by ANTLR 4.0
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
		T__8=1, T__7=2, T__6=3, T__5=4, T__4=5, T__3=6, T__2=7, T__1=8, T__0=9, 
		STRING=10, DOUBLE=11, NOT=12, AND=13, ASSIGN=14, OR=15, INT=16, TRUE=17, 
		FALSE=18, NULL=19, PLUS=20, MINUS=21, SLASH=22, STAR=23, IDENTIFIER=24, 
		ESCAPE=25, DOLLAR=26, WS=27, DOT=28;
	public static final String[] tokenNames = {
		"<INVALID>", "'{'", "')'", "','", "'('", "'@'", "':'", "'}'", "';'", "'|'", 
		"STRING", "DOUBLE", "'!'", "'and'", "'='", "'or'", "INT", "'true'", "'false'", 
		"'null'", "'+'", "'-'", "'/'", "'*'", "IDENTIFIER", "ESCAPE", "'$'", "WS", 
		"'.'"
	};
	public static final int
		RULE_line = 0, RULE_prog = 1, RULE_expr = 2, RULE_value = 3, RULE_constant = 4, 
		RULE_resource = 5, RULE_pckg = 6, RULE_variable = 7, RULE_call = 8, RULE_varlist = 9, 
		RULE_argslist = 10, RULE_bool = 11;
	public static final String[] ruleNames = {
		"line", "prog", "expr", "value", "constant", "resource", "pckg", "variable", 
		"call", "varlist", "argslist", "bool"
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
			setState(24); prog();
			setState(25); match(EOF);
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
			setState(32);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(27); expr(0);
				setState(28); match(8);
				setState(29); prog();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(31); expr(0);
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
		public VarlistContext varlist() {
			return getRuleContext(VarlistContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public TerminalNode STAR() { return getToken(ExprParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(ExprParser.SLASH, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode OR() { return getToken(ExprParser.OR, 0); }
		public TerminalNode ASSIGN() { return getToken(ExprParser.ASSIGN, 0); }
		public ProgContext prog() {
			return getRuleContext(ProgContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(ExprParser.PLUS, 0); }
		public TerminalNode NOT() { return getToken(ExprParser.NOT, 0); }
		public TerminalNode MINUS() { return getToken(ExprParser.MINUS, 0); }
		public TerminalNode AND() { return getToken(ExprParser.AND, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
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
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(35); match(NOT);
				setState(36); ((ExprContext)_localctx).center = expr(13);
				}
				break;

			case 2:
				{
				setState(37); match(MINUS);
				setState(38); ((ExprContext)_localctx).center = expr(12);
				}
				break;

			case 3:
				{
				setState(39); ((ExprContext)_localctx).leftVar = value(0);
				setState(40); match(ASSIGN);
				setState(41); ((ExprContext)_localctx).right = expr(3);
				}
				break;

			case 4:
				{
				setState(43); match(4);
				setState(44); ((ExprContext)_localctx).center = expr(0);
				setState(45); match(2);
				}
				break;

			case 5:
				{
				setState(47); match(1);
				setState(52);
				_la = _input.LA(1);
				if (_la==9) {
					{
					setState(48); match(9);
					setState(49); varlist();
					setState(50); match(9);
					}
				}

				setState(54); prog();
				setState(55); match(7);
				}
				break;

			case 6:
				{
				setState(57); value(0);
				}
				break;

			case 7:
				{
				setState(58); constant();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(81);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(79);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(61);
						if (!(11 >= _localctx._p)) throw new FailedPredicateException(this, "11 >= $_p");
						setState(62); match(STAR);
						setState(63); ((ExprContext)_localctx).right = expr(12);
						}
						break;

					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(64);
						if (!(10 >= _localctx._p)) throw new FailedPredicateException(this, "10 >= $_p");
						setState(65); match(SLASH);
						setState(66); ((ExprContext)_localctx).right = expr(11);
						}
						break;

					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(67);
						if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
						setState(68); match(PLUS);
						setState(69); ((ExprContext)_localctx).right = expr(10);
						}
						break;

					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(70);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(71); match(MINUS);
						setState(72); ((ExprContext)_localctx).right = expr(9);
						}
						break;

					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(73);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(74); match(AND);
						setState(75); ((ExprContext)_localctx).right = expr(8);
						}
						break;

					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState, _p);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(76);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(77); match(OR);
						setState(78); ((ExprContext)_localctx).right = expr(7);
						}
						break;
					}
					} 
				}
				setState(83);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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
			setState(87);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(85); call();
				}
				break;

			case 2:
				{
				setState(86); variable();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(94);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ValueContext(_parentctx, _parentState, _p);
					_localctx.left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_value);
					setState(89);
					if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
					setState(90); match(DOT);
					setState(91); ((ValueContext)_localctx).right = value(4);
					}
					} 
				}
				setState(96);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
		public TerminalNode DOUBLE() { return getToken(ExprParser.DOUBLE, 0); }
		public TerminalNode INT() { return getToken(ExprParser.INT, 0); }
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
			setState(102);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(97); bool();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(98); match(STRING);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 3);
				{
				setState(99); resource();
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 4);
				{
				setState(100); match(DOUBLE);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 5);
				{
				setState(101); match(INT);
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
			setState(104); match(5);
			setState(114);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(108);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(105); pckg();
					setState(106); match(6);
					}
					break;
				}
				setState(110); ((ResourceContext)_localctx).type = match(IDENTIFIER);
				setState(111); match(SLASH);
				setState(112); ((ResourceContext)_localctx).name = match(IDENTIFIER);
				}
				break;
			case NULL:
				{
				setState(113); match(NULL);
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
			setState(116); match(IDENTIFIER);
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(117); match(DOT);
				setState(118); match(IDENTIFIER);
				}
				}
				setState(123);
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
			setState(124);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126); match(IDENTIFIER);
			setState(127); match(4);
			setState(129);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 4) | (1L << 5) | (1L << STRING) | (1L << DOUBLE) | (1L << NOT) | (1L << INT) | (1L << TRUE) | (1L << FALSE) | (1L << NULL) | (1L << MINUS) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(128); argslist();
				}
			}

			setState(131); match(2);
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

	public static class VarlistContext extends ParserRuleContext {
		public VarlistContext varlist() {
			return getRuleContext(VarlistContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(ExprParser.IDENTIFIER, 0); }
		public VarlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varlist; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitVarlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarlistContext varlist() throws RecognitionException {
		VarlistContext _localctx = new VarlistContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_varlist);
		try {
			setState(137);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(133); match(IDENTIFIER);
				setState(134); match(3);
				setState(135); varlist();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(136); match(IDENTIFIER);
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
		enterRule(_localctx, 20, RULE_argslist);
		try {
			setState(144);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(139); expr(0);
				setState(140); match(3);
				setState(141); argslist();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(143); expr(0);
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
		enterRule(_localctx, 22, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
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
		case 6: return 3 >= _localctx._p;
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 11 >= _localctx._p;

		case 1: return 10 >= _localctx._p;

		case 2: return 9 >= _localctx._p;

		case 3: return 8 >= _localctx._p;

		case 4: return 7 >= _localctx._p;

		case 5: return 6 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\2\3\36\u0097\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b"+
		"\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\5\3#\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\5\4\67\n\4\3\4\3\4\3\4\3\4\3\4\5\4>\n\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4R\n\4\f"+
		"\4\16\4U\13\4\3\5\3\5\3\5\5\5Z\n\5\3\5\3\5\3\5\7\5_\n\5\f\5\16\5b\13\5"+
		"\3\6\3\6\3\6\3\6\3\6\5\6i\n\6\3\7\3\7\3\7\3\7\5\7o\n\7\3\7\3\7\3\7\3\7"+
		"\5\7u\n\7\3\b\3\b\3\b\7\bz\n\b\f\b\16\b}\13\b\3\t\3\t\3\n\3\n\3\n\5\n"+
		"\u0084\n\n\3\n\3\n\3\13\3\13\3\13\3\13\5\13\u008c\n\13\3\f\3\f\3\f\3\f"+
		"\3\f\5\f\u0093\n\f\3\r\3\r\3\r\2\16\2\4\6\b\n\f\16\20\22\24\26\30\2\4"+
		"\4\25\25\32\32\3\23\24\u00a4\2\32\3\2\2\2\4\"\3\2\2\2\6=\3\2\2\2\bY\3"+
		"\2\2\2\nh\3\2\2\2\fj\3\2\2\2\16v\3\2\2\2\20~\3\2\2\2\22\u0080\3\2\2\2"+
		"\24\u008b\3\2\2\2\26\u0092\3\2\2\2\30\u0094\3\2\2\2\32\33\5\4\3\2\33\34"+
		"\7\1\2\2\34\3\3\2\2\2\35\36\5\6\4\2\36\37\7\n\2\2\37 \5\4\3\2 #\3\2\2"+
		"\2!#\5\6\4\2\"\35\3\2\2\2\"!\3\2\2\2#\5\3\2\2\2$%\b\4\1\2%&\7\16\2\2&"+
		">\5\6\4\2\'(\7\27\2\2(>\5\6\4\2)*\5\b\5\2*+\7\20\2\2+,\5\6\4\2,>\3\2\2"+
		"\2-.\7\6\2\2./\5\6\4\2/\60\7\4\2\2\60>\3\2\2\2\61\66\7\3\2\2\62\63\7\13"+
		"\2\2\63\64\5\24\13\2\64\65\7\13\2\2\65\67\3\2\2\2\66\62\3\2\2\2\66\67"+
		"\3\2\2\2\678\3\2\2\289\5\4\3\29:\7\t\2\2:>\3\2\2\2;>\5\b\5\2<>\5\n\6\2"+
		"=$\3\2\2\2=\'\3\2\2\2=)\3\2\2\2=-\3\2\2\2=\61\3\2\2\2=;\3\2\2\2=<\3\2"+
		"\2\2>S\3\2\2\2?@\6\4\2\3@A\7\31\2\2AR\5\6\4\2BC\6\4\3\3CD\7\30\2\2DR\5"+
		"\6\4\2EF\6\4\4\3FG\7\26\2\2GR\5\6\4\2HI\6\4\5\3IJ\7\27\2\2JR\5\6\4\2K"+
		"L\6\4\6\3LM\7\17\2\2MR\5\6\4\2NO\6\4\7\3OP\7\21\2\2PR\5\6\4\2Q?\3\2\2"+
		"\2QB\3\2\2\2QE\3\2\2\2QH\3\2\2\2QK\3\2\2\2QN\3\2\2\2RU\3\2\2\2SQ\3\2\2"+
		"\2ST\3\2\2\2T\7\3\2\2\2US\3\2\2\2VW\b\5\1\2WZ\5\22\n\2XZ\5\20\t\2YV\3"+
		"\2\2\2YX\3\2\2\2Z`\3\2\2\2[\\\6\5\b\3\\]\7\36\2\2]_\5\b\5\2^[\3\2\2\2"+
		"_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2a\t\3\2\2\2b`\3\2\2\2ci\5\30\r\2di\7\f\2"+
		"\2ei\5\f\7\2fi\7\r\2\2gi\7\22\2\2hc\3\2\2\2hd\3\2\2\2he\3\2\2\2hf\3\2"+
		"\2\2hg\3\2\2\2i\13\3\2\2\2jt\7\7\2\2kl\5\16\b\2lm\7\b\2\2mo\3\2\2\2nk"+
		"\3\2\2\2no\3\2\2\2op\3\2\2\2pq\7\32\2\2qr\7\30\2\2ru\7\32\2\2su\7\25\2"+
		"\2tn\3\2\2\2ts\3\2\2\2u\r\3\2\2\2v{\7\32\2\2wx\7\36\2\2xz\7\32\2\2yw\3"+
		"\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|\17\3\2\2\2}{\3\2\2\2~\177\t\2\2"+
		"\2\177\21\3\2\2\2\u0080\u0081\7\32\2\2\u0081\u0083\7\6\2\2\u0082\u0084"+
		"\5\26\f\2\u0083\u0082\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\3\2\2\2"+
		"\u0085\u0086\7\4\2\2\u0086\23\3\2\2\2\u0087\u0088\7\32\2\2\u0088\u0089"+
		"\7\5\2\2\u0089\u008c\5\24\13\2\u008a\u008c\7\32\2\2\u008b\u0087\3\2\2"+
		"\2\u008b\u008a\3\2\2\2\u008c\25\3\2\2\2\u008d\u008e\5\6\4\2\u008e\u008f"+
		"\7\5\2\2\u008f\u0090\5\26\f\2\u0090\u0093\3\2\2\2\u0091\u0093\5\6\4\2"+
		"\u0092\u008d\3\2\2\2\u0092\u0091\3\2\2\2\u0093\27\3\2\2\2\u0094\u0095"+
		"\t\3\2\2\u0095\31\3\2\2\2\20\"\66=QSY`hnt{\u0083\u008b\u0092";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}