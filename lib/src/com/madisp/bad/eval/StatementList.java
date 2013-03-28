package com.madisp.bad.eval;

import java.util.Arrays;

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
	public Object value(ExecutionContext ctx) {
		Object value = null;
		for (Expression e : expressions) {
			value = e.value(ctx); // don't care about value
		}
		return value;
	}

	@Override
	public String toString() {
		return "StatementList{" +
				"expressions=" + (expressions == null ? null : Arrays.asList(expressions)) +
				'}';
	}

	@Override
	public void addWatcher(ExecutionContext ctx, Watcher w) {
		for (Expression e : expressions) {
			e.addWatcher(ctx, w);
		}
	}
}
