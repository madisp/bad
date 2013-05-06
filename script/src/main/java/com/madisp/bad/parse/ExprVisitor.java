// Generated from /home/madis/cryptodev/git/bad/script/src/main/grammar/Expr.g4 by ANTLR 4.0
package com.madisp.bad.parse;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface ExprVisitor<T> extends ParseTreeVisitor<T> {
	T visitCall(ExprParser.CallContext ctx);

	T visitProg(ExprParser.ProgContext ctx);

	T visitConstant(ExprParser.ConstantContext ctx);

	T visitPckg(ExprParser.PckgContext ctx);

	T visitResource(ExprParser.ResourceContext ctx);

	T visitValue(ExprParser.ValueContext ctx);

	T visitLine(ExprParser.LineContext ctx);

	T visitExpr(ExprParser.ExprContext ctx);

	T visitBool(ExprParser.BoolContext ctx);

	T visitArgslist(ExprParser.ArgslistContext ctx);

	T visitVariable(ExprParser.VariableContext ctx);
}