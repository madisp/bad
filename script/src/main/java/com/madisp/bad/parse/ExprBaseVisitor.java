// Generated from Expr.g4 by ANTLR 4.0
package com.madisp.bad.parse;
import org.antlr.v4.runtime.tree.*;

public class ExprBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements ExprVisitor<T> {
	@Override public T visitCall(ExprParser.CallContext ctx) { return visitChildren(ctx); }

	@Override public T visitProg(ExprParser.ProgContext ctx) { return visitChildren(ctx); }

	@Override public T visitConstant(ExprParser.ConstantContext ctx) { return visitChildren(ctx); }

	@Override public T visitValue(ExprParser.ValueContext ctx) { return visitChildren(ctx); }

	@Override public T visitLine(ExprParser.LineContext ctx) { return visitChildren(ctx); }

	@Override public T visitExpr(ExprParser.ExprContext ctx) { return visitChildren(ctx); }

	@Override public T visitBool(ExprParser.BoolContext ctx) { return visitChildren(ctx); }

	@Override public T visitArgslist(ExprParser.ArgslistContext ctx) { return visitChildren(ctx); }

	@Override public T visitVariable(ExprParser.VariableContext ctx) { return visitChildren(ctx); }
}