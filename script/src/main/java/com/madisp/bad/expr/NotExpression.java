package com.madisp.bad.expr;

import com.madisp.bad.eval.ExecutionContext;
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
	public Object value(ExecutionContext ctx) {
		return !ctx.converter().bool(expr.value(ctx));
	}

	@Override
	public String toString() {
		return "NotExpression{" +
				"script=" + expr +
				'}';
	}

	@Override
	public void addWatcher(ExecutionContext ctx, Watcher w) {
		expr.addWatcher(ctx, w);
	}
}
