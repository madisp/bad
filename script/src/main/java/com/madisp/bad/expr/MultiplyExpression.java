package com.madisp.bad.expr;

import com.madisp.bad.eval.ExecutionContext;
import com.madisp.bad.eval.Watcher;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 5/6/13
 * Time: 3:09 PM
 */
public class MultiplyExpression implements Expression {
	private final Expression left;
	private final Expression right;

	public MultiplyExpression(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}


	@Override
	public Object value(ExecutionContext ctx) {
		return ctx.converter().integer(left.value(ctx)) * ctx.converter().integer(right.value(ctx));
	}

	@Override
	public void addWatcher(ExecutionContext ctx, Watcher w) {
		left.addWatcher(ctx, w);
		right.addWatcher(ctx, w);
	}
}
