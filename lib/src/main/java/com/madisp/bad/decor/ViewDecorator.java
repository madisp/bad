package com.madisp.bad.decor;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import com.madisp.bad.eval.ExecutionContext;
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

	public ViewDecorator(ExecutionContext exec, ExpressionFactory expressionFactory, Context context) {
		super(exec, expressionFactory, context);
	}

	@Override
	public int[] attrs() {
		return new int[] { R.attr.enabled, R.attr.click };
	}

	@Override
	public void decorate(final int attr, final TypedValue tv, final View view) {
		if (attr == R.attr.click) {
			final Expression expr = expressionFactory.buildExpression(tv.string.toString());
			view.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					expr.value(exec);
				}
			});
		} else if (attr == R.attr.enabled) {
			final Expression expr = expressionFactory.buildExpression(tv.string.toString());
			expr.addWatcher(exec, new Watcher() {
				@Override
				public void fire(ExecutionContext exec) {
					view.setEnabled(exec.converter().bool(expr.value(exec)));
				}
			});
			view.setEnabled(exec.converter().bool(expr.value(exec)));
		}
	}

	@Override
	public Class<View> clazz() {
		return View.class;
	}
}
