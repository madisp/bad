package com.madisp.bad.eval;

import com.madisp.bad.lib.BadVar;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/23/13
 * Time: 1:57 PM
 */
public class VarExpression extends BasableExpression {
	String var;
	public VarExpression(BasableExpression base, String var) {
		super(base);
		this.var = var;
	}

	@Override
	public Object value(ExecutionContext ctx) {
		if (var == null) {
			return null;
		}
		if (!hasBase()) {
			return ctx.getVar(var);
		}
		Object base = getBase(ctx);
		if (base != null) {
			return ctx.getVar(base, var);
		}
		return null;
	}

	public String getIdentifier() {
		return var;
	}

	@Override
	public String toString() {
		return "VarExpression{" +
				"base=" + getBaseExpr() +
				", var=" + var +
				'}';
	}

	@Override
	public void addWatcher(final ExecutionContext ctx, final Watcher w) {
		super.addWatcher(ctx, w);
		ctx.addWatcher(w); // watch for context rebase ops
		Object o = value(ctx);
		if (o instanceof BadVar) {
			((BadVar)o).addWatcher(new BadVar.BadWatcher() {
				@Override
				public void fire(BadVar var) {
					w.fire(ctx);
				}
			});
		}
	}
}
