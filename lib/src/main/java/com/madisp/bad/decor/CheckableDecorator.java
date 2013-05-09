package com.madisp.bad.decor;

import android.content.Context;
import android.util.TypedValue;
import android.widget.Checkable;
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
public class CheckableDecorator extends BaseDecorator<Checkable> {
	public CheckableDecorator(ExecutionContext exec, ExpressionFactory expressionFactory, Context context) {
		super(exec, expressionFactory, context);
	}

	@Override
	public int[] attrs() {
		return new int[] { R.attr.checked };
	}

	@Override
	public void decorate(final int attr, final TypedValue tv, final Checkable view) {
		if (attr == R.attr.checked) {
			final Expression expr = expressionFactory.buildExpression(tv.string.toString());
			expr.addWatcher(exec, new Watcher() {
				@Override
				public void fire(ExecutionContext exec) {
					Object obj = expr.value(exec);
					boolean bol = exec.converter().bool(obj);
					view.setChecked(bol);
				}
			});
			view.setChecked(exec.converter().bool(expr.value(exec)));
		}
	}

	@Override
	public Class<Checkable> clazz() {
		return Checkable.class;
	}
}
