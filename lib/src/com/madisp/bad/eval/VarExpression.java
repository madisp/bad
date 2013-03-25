package com.madisp.bad.eval;

import com.madisp.bad.lib.BadVar;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/23/13
 * Time: 1:57 PM
 */
public class VarExpression implements Expression {
	String var;
	public VarExpression(String var) {
		this.var = var;
	}

	@Override
	public Object value(ExecutionContext ctx) {
		return var == null ? null : ctx.getVar(var);
	}

	@Override
	public String toString() {
		return "VarExpression{" +
				"var=" + var +
				'}';
	}

	@Override
	public void addWatcher(final ExecutionContext ctx, final Watcher w) {
		BadVar bv = ctx.getBadVar(var);
		if (bv != null) {
			bv.addWatcher(new BadVar.BadWatcher() {
				@Override
				public void fire(BadVar var) {
					w.fire(ctx);
				}
			});
		}
		ctx.addWatcher(w); // watch for context rebase ops
	}
}
