package com.madisp.bad.decor;

import android.content.Context;
import com.madisp.bad.eval.ExecutionContext;
import com.madisp.bad.expr.ExpressionFactory;
import com.madisp.bad.lib.BadLayoutFactory;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 5/9/13
 * Time: 1:55 PM
 */
public abstract class BaseDecorator<T> implements BadDecorator<T> {
	protected final ExecutionContext exec;
	protected final ExpressionFactory expressionFactory;
	protected final Context context;

	protected BaseDecorator(final ExecutionContext exec, final ExpressionFactory expressionFactory, final Context context) {
		this.exec = exec;
		this.expressionFactory = expressionFactory;
		this.context = context;
	}

	@Override
	public void apply(T view, BadLayoutFactory layoutFactory) {}
}
