// Generated from Expr.g4 by ANTLR 4.0
package com.madisp.bad.expr;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface ExprVisitor<T> extends ParseTreeVisitor<T> {
	T visitCall(ExprParser.CallContext ctx);

	T visitValue(ExprParser.ValueContext ctx);

	T visitLine(ExprParser.LineContext ctx);

	T visitExpr(ExprParser.ExprContext ctx);

	T visitBool(ExprParser.BoolContext ctx);

	T visitArgslist(ExprParser.ArgslistContext ctx);

	T visitVariable(ExprParser.VariableContext ctx);
}