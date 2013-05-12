package com.madisp.bad.decor;

import android.content.Context;
import android.util.TypedValue;
import com.madisp.bad.eval.Scope;
import com.madisp.bad.expr.Expression;
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

	protected final Expression buildExpr(final TypedValue tv) {
		return expressionFactory.buildExpression(tv.string.toString());
	}

	@Override
	public void apply(Scope scope, T view, BadLayoutFactory layoutFactory) {}
}
