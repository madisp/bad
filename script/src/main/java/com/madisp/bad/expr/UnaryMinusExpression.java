package com.madisp.bad.expr;

import com.madisp.bad.eval.ExecutionContext;
import com.madisp.bad.eval.Watcher;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 5/6/13
 * Time: 2:32 PM
 */
public class UnaryMinusExpression implements Expression {
	private final Expression expr;

	public UnaryMinusExpression(Expression expr) {
		this.expr = expr;
	}

	@Override
	public Object value(ExecutionContext ctx) {
		return -ctx.converter().integer(expr.value(ctx));
	}

	@Override
	public void addWatcher(ExecutionContext ctx, Watcher w) {
		expr.addWatcher(ctx, w);
	}
}
