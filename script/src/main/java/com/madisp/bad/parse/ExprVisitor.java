// Generated from Expr.g4 by ANTLR 4.0
package com.madisp.bad.parse;
import org.antlr.v4.runtime.tree.*;

public interface ExprVisitor<T> extends ParseTreeVisitor<T> {
	T visitCall(ExprParser.CallContext ctx);

	T visitProg(ExprParser.ProgContext ctx);

	T visitConstant(ExprParser.ConstantContext ctx);

	T visitValue(ExprParser.ValueContext ctx);

	T visitLine(ExprParser.LineContext ctx);

	T visitExpr(ExprParser.ExprContext ctx);

	T visitBool(ExprParser.BoolContext ctx);

	T visitArgslist(ExprParser.ArgslistContext ctx);

	T visitVariable(ExprParser.VariableContext ctx);
}