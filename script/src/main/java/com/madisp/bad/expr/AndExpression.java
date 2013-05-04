package com.madisp.bad.expr;

import com.madisp.bad.eval.ExecutionContext;
import com.madisp.bad.eval.Watcher;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/23/13
 * Time: 1:57 PM
 */
public class AndExpression implements Expression {
	Expression left;
	Expression right;
	public AndExpression(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public Object value(ExecutionContext ctx) {
		return ctx.bool(left.value(ctx)) && ctx.bool(right.value(ctx));
	}

	@Override
	public String toString() {
		return "AndExpression{" +
				"left=" + left +
				", right=" + right +
				'}';
	}

	@Override
	public void addWatcher(ExecutionContext ctx, Watcher w) {
		left.addWatcher(ctx, w);
		right.addWatcher(ctx, w);
	}
}
