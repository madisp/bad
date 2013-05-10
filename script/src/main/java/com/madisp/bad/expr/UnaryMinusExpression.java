package com.madisp.bad.expr;

import com.madisp.bad.eval.BadConverter;
import com.madisp.bad.eval.Scope;
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
	public Object value(Scope scope) {
		return -BadConverter.integer(expr.value(scope));
	}

	@Override
	public void addWatcher(Scope scope, Watcher w) {
		expr.addWatcher(scope, w);
	}
}
