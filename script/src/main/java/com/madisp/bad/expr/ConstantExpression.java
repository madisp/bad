package com.madisp.bad.expr;

import com.madisp.bad.eval.Scope;
import com.madisp.bad.eval.Watcher;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/23/13
 * Time: 1:57 PM
 */
public class ConstantExpression implements Expression {
	private Object value;
	public ConstantExpression(Object value) {
		this.value = value;
	}

	@Override
	public Object value(Scope scope) {
		return value;
	}

	@Override
	public void addWatcher(Scope scope, Watcher w) {
	}
}
