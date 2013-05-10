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
public class NotExpression implements Expression {
	Expression expr;
	public NotExpression(Expression expr) {
		this.expr = expr;
	}

	@Override
	public Object value(Scope scope) {
		return !BadConverter.bool(expr.value(scope));
	}

	@Override
	public void addWatcher(Scope scope, Watcher w) {
		expr.addWatcher(scope, w);
	}
}
