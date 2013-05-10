package com.madisp.bad.decor;

import android.util.TypedValue;
import android.widget.TextView;
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
public class TextViewDecorator extends BaseDecorator<TextView> {
	public TextViewDecorator(ExpressionFactory expressionFactory) {
		super(expressionFactory);
	}

	@Override
	public int[] attrs() {
		return new int[] { R.attr.text };
	}

	@Override
	public void decorate(final Scope scope, final int attr, final TypedValue tv, final TextView view) {
		if (attr == R.attr.text) {
			final Expression expr = expressionFactory.buildExpression(tv.string.toString());
			expr.addWatcher(scope, new Watcher() {
				@Override
				public void fire(Scope scope) {
					view.setText(BadConverter.string(expr.value(scope)));
				}
			});
			view.setText(BadConverter.string(expr.value(scope)));
		}
	}

	@Override
	public Class<TextView> clazz() {
		return TextView.class;
	}
}
