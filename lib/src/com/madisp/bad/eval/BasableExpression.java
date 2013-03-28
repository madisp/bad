package com.madisp.bad.eval;

import com.madisp.bad.lib.BadVar;

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
	public void addWatcher(ExecutionContext ctx, Watcher w) {
		if (hasBase()) {
			base.addWatcher(ctx, w);
		}
	}

	protected boolean hasBase() {
		return base != null;
	}

	protected Object getBase(ExecutionContext ctx) {
		if (base != null) {
			Object obj = base.value(ctx);
			if (obj instanceof BadVar) {
				return ((BadVar)obj).get();
			}
			return obj;
		}
		return null;
	}

	protected Expression getBaseExpr() {
		return base;
	}
}
