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
public class MethodExpression extends BasableExpression {
	String m;
	Expression[] args;
	public MethodExpression(String m, Expression... args) {
		super(null);
		this.m = m;
		this.args = args;
	}

	@Override
	public Object value(Scope scope) {
		Object[] argvalues = new Object[args.length];
		for (int i = 0; i < argvalues.length; i++) {
			argvalues[i] = BadConverter.object(args[i].value(scope));
		}
		if (!hasBase()) {
			return scope.callMethod(null, m, argvalues);
		}
		Object base = getBase(scope);
		if (base != null) {
			return scope.callMethod(base, m, argvalues);
		}
		return null;
	}

	@Override
	public void addWatcher(Scope scope, Watcher w) {
		super.addWatcher(scope, w);
		for (Expression arg : args) {
			arg.addWatcher(scope, w);
		}
	}
}
