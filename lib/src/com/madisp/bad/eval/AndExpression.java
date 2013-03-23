package com.madisp.bad.eval;

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
		return ctx.coerceToBool(left.value(ctx)) && ctx.coerceToBool(right.value(ctx));
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
