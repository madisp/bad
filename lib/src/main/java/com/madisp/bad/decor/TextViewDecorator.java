package com.madisp.bad.decor;

import android.content.Context;
import android.util.TypedValue;
import android.widget.TextView;
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
public class TextViewDecorator extends BaseDecorator<TextView> {
	public TextViewDecorator(ExecutionContext exec, ExpressionFactory expressionFactory, Context context) {
		super(exec, expressionFactory, context);
	}

	@Override
	public int[] attrs() {
		return new int[] { R.attr.text };
	}

	@Override
	public void decorate(final int attr, final TypedValue tv, final TextView view) {
		if (attr == R.attr.text) {
			final Expression expr = expressionFactory.buildExpression(tv.string.toString());
			expr.addWatcher(exec, new Watcher() {
				@Override
				public void fire(ExecutionContext exec) {
					view.setText(exec.converter().string(expr.value(exec)));
				}
			});
			view.setText(exec.converter().string(expr.value(exec)));
		}
	}

	@Override
	public Class<TextView> clazz() {
		return TextView.class;
	}
}
