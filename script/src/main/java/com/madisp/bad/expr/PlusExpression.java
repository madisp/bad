package com.madisp.bad.expr;

import com.madisp.bad.eval.BadConverter;
import com.madisp.bad.eval.Scope;
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
	public Object value(Scope scope) {
		Object leftVal = BadConverter.object(left.value(scope));
		Object rightVal = BadConverter.object(right.value(scope));
		if (leftVal instanceof Integer && rightVal instanceof Integer) {
			return (Integer)leftVal + (Integer)rightVal;
		} else {
			return BadConverter.string(leftVal) + BadConverter.string(rightVal);
		}
	}

	@Override
	public void addWatcher(Scope scope, Watcher w) {
		left.addWatcher(scope, w);
		right.addWatcher(scope, w);
	}
}
