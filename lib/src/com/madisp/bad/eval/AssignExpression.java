package com.madisp.bad.eval;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/27/13
 * Time: 7:02 PM
 */
public class AssignExpression implements Expression {
	private final Expression expr;
	private final VarExpression var;

	public AssignExpression(VarExpression var, Expression expr) {
		this.var = var;
		this.expr = expr;
	}


	@Override
	public Object value(ExecutionContext ctx) {
		Object newValue = expr.value(ctx);
		ctx.setVar(var.getIdentifier(), newValue);
		return newValue;
	}

	@Override
	public void addWatcher(ExecutionContext ctx, Watcher w) {
		expr.addWatcher(ctx, w);
		var.addWatcher(ctx, w);
	}
}
