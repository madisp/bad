package com.madisp.bad.eval;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/23/13
 * Time: 1:57 PM
 */
public class ConstantExpression implements Expression {
	private Object value;
	public ConstantExpression(Object value) {
		this.value = value;
	}

	@Override
	public Object value(ExecutionContext ctx) {
		return value;
	}

	@Override
	public String toString() {
		return "ConstantExpression{" +
				"value=" + value +
				'}';
	}

	@Override
	public void addWatcher(ExecutionContext ctx, Watcher w) {
	}
}
