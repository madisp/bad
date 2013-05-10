package com.madisp.bad.decor;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import com.madisp.bad.eval.BadConverter;
import com.madisp.bad.eval.Scope;
import com.madisp.bad.eval.Watcher;
import com.madisp.bad.expr.Expression;
import com.madisp.bad.expr.ExpressionFactory;
import com.madisp.bad.lib.R;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 5/9/13
 * Time: 2:03 PM
 */
public class ViewDecorator extends BaseDecorator<View> {

	public ViewDecorator(ExpressionFactory expressionFactory) {
		super(expressionFactory);
	}

	@Override
	public int[] attrs() {
		return new int[] { R.attr.enabled, R.attr.click };
	}

	@Override
	public void decorate(final Scope scope, final int attr, final TypedValue tv, final View view) {
		if (attr == R.attr.click) {
			final Expression expr = expressionFactory.buildExpression(tv.string.toString());
			view.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					expr.value(scope);
				}
			});
		} else if (attr == R.attr.enabled) {
			final Expression expr = expressionFactory.buildExpression(tv.string.toString());
			expr.addWatcher(scope, new Watcher() {
				@Override
				public void fire(Scope scope) {
					view.setEnabled(BadConverter.bool(expr.value(scope)));
				}
			});
			view.setEnabled(BadConverter.bool(expr.value(scope)));
		}
	}

	@Override
	public Class<View> clazz() {
		return View.class;
	}
}
