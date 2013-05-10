package com.madisp.bad.expr;

import com.madisp.bad.eval.BadConverter;
import com.madisp.bad.eval.Scope;
import com.madisp.bad.eval.Watcher;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 5/6/13
 * Time: 2:36 PM
 */
public class MinusExpression implements Expression {

	private final Expression left;
	private final Expression right;

	public MinusExpression(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public Object value(Scope scope) {
		return BadConverter.integer(left.value(scope)) - BadConverter.integer(right.value(scope));
	}

	@Override
	public void addWatcher(Scope scope, Watcher w) {
		left.addWatcher(scope, w);
		right.addWatcher(scope, w);
	}
}
