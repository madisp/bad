package com.madisp.bad.decor;

import android.content.Context;
import com.madisp.bad.eval.Scope;
import com.madisp.bad.expr.ExpressionFactory;
import com.madisp.bad.lib.BadLayoutFactory;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 5/9/13
 * Time: 1:55 PM
 */
public abstract class BaseDecorator<T> implements BadDecorator<T> {
	protected final ExpressionFactory expressionFactory;

	protected BaseDecorator(final ExpressionFactory expressionFactory) {
		this.expressionFactory = expressionFactory;
	}

	@Override
	public void apply(Scope scope, T view, BadLayoutFactory layoutFactory) {}
}
