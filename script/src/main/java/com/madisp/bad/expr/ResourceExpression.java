package com.madisp.bad.expr;

import com.madisp.bad.eval.ExecutionContext;
import com.madisp.bad.eval.Watcher;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 5/6/13
 * Time: 12:59 PM
 */
public class ResourceExpression implements Expression {
	private int cachedValue = -1;
	private String name;

	public ResourceExpression() {
		cachedValue = 0;
	}

	public ResourceExpression(String name) {
		this.name = name;
	}

	@Override
	public Object value(ExecutionContext ctx) {
		if (cachedValue < 0) {
			cachedValue = ctx.getResourceId(name);
		}
		return cachedValue;
	}

	@Override
	public void addWatcher(ExecutionContext ctx, Watcher w) {
		return; // how do you watch a resource constant?
	}
}
