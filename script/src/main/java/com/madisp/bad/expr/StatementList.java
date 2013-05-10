package com.madisp.bad.expr;

import com.madisp.bad.eval.Scope;
import com.madisp.bad.eval.Watcher;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/27/13
 * Time: 7:18 PM
 */
public class StatementList implements Expression {
	private final Expression[] expressions;

	public StatementList(Expression... expressions) {
		this.expressions = expressions;
	}

	@Override
	public Object value(Scope scope) {
		Object value = null;
		for (Expression e : expressions) {
			value = e.value(scope); // don't care about value
		}
		return value;
	}

	@Override
	public void addWatcher(Scope scope, Watcher w) {
		for (Expression e : expressions) {
			e.addWatcher(scope, w);
		}
	}
}
