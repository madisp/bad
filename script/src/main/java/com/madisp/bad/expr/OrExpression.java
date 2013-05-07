package com.madisp.bad.expr;

import com.madisp.bad.eval.ExecutionContext;
import com.madisp.bad.eval.Watcher;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/23/13
 * Time: 1:57 PM
 */
public class OrExpression implements Expression {
	Expression left;
	Expression right;
	public OrExpression(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public Object value(ExecutionContext ctx) {
		Object leftVal = left.value(ctx);
		if (ctx.converter().bool(leftVal)) {
			return leftVal;
		} else {
			return right.value(ctx);
		}
	}

	@Override
	public String toString() {
		return "OrExpression{" +
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
