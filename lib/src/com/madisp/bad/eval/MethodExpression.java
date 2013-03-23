package com.madisp.bad.eval;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/23/13
 * Time: 1:57 PM
 */
public class MethodExpression implements Expression {
	String m;
	Expression[] args;
	;
	public MethodExpression(String m, Expression... args) {
		this.m = m;
		this.args = args;
	}

	@Override
	public Object value(ExecutionContext ctx) {
		Object[] argvalues = new Object[args.length];
		for (int i = 0; i < argvalues.length; i++) {
			argvalues[i] = args[i].value(ctx);
		}
		return ctx.callMethod(m, argvalues);
	}

	@Override
	public String toString() {
		return "MethodExpression{" +
				"m=" + m +
				", args=" + (args == null ? null : Arrays.asList(args)) +
				'}';
	}

	@Override
	public void addWatcher(ExecutionContext ctx, Watcher w) {
		for (Expression arg : args) {
			arg.addWatcher(ctx, w);
		}
	}
}
