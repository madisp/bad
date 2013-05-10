package com.madisp.bad.expr;

import com.madisp.bad.eval.BadConverter;
import com.madisp.bad.eval.Scope;
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
	public Object value(Scope scope) {
		return BadConverter.bool(left.value(scope)) && BadConverter.bool(right.value(scope));
	}

	@Override
	public void addWatcher(Scope scope, Watcher w) {
		left.addWatcher(scope, w);
		right.addWatcher(scope, w);
	}
}
