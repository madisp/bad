package com.madisp.bad.expr;

import com.madisp.bad.eval.BadConverter;
import com.madisp.bad.eval.Scope;
import com.madisp.bad.eval.Watcher;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/27/13
 * Time: 8:36 PM
 */
public abstract class BasableExpression implements Expression {
	private BasableExpression base;

	protected BasableExpression(BasableExpression base) {
		this.base = base;
	}

	public void setBase(BasableExpression base) {
		this.base = base;
	}

	@Override
	public void addWatcher(Scope scope, Watcher w) {
		if (hasBase()) {
			base.addWatcher(scope, w);
		}
	}

	protected boolean hasBase() {
		return base != null;
	}

	protected Object getBase(Scope scope) {
		if (base != null) {
			return BadConverter.object(base.value(scope));
		}
		return null;
	}

	protected Expression getBaseExpr() {
		return base;
	}
}
