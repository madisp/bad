package com.madisp.bad.expr;

import com.madisp.bad.eval.ExecutionContext;
import com.madisp.bad.eval.Watcher;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 5/6/13
 * Time: 2:33 PM
 */
public class PlusExpression implements Expression {
	private final Expression left;
	private final Expression right;

	public PlusExpression(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public Object value(ExecutionContext ctx) {
		Object leftVal = ctx.converter().object(left.value(ctx));
		Object rightVal = ctx.converter().object(right.value(ctx));
		if (leftVal instanceof Integer && rightVal instanceof Integer) {
			return (Integer)leftVal + (Integer)rightVal;
		} else {
			return ctx.converter().string(leftVal) + ctx.converter().string(rightVal);
		}
	}

	@Override
	public void addWatcher(ExecutionContext ctx, Watcher w) {
		left.addWatcher(ctx, w);
		right.addWatcher(ctx, w);
	}
}
