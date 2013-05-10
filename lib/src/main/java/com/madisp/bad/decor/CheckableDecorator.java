package com.madisp.bad.decor;

import android.util.TypedValue;
import android.widget.Checkable;
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
public class CheckableDecorator extends BaseDecorator<Checkable> {
	public CheckableDecorator(ExpressionFactory expressionFactory) {
		super(expressionFactory);
	}

	@Override
	public int[] attrs() {
		return new int[] { R.attr.checked };
	}

	@Override
	public void decorate(Scope scope, final int attr, final TypedValue tv, final Checkable view) {
		if (attr == R.attr.checked) {
			final Expression expr = expressionFactory.buildExpression(tv.string.toString());
			expr.addWatcher(scope, new Watcher() {
				@Override
				public void fire(Scope scope) {
					Object obj = expr.value(scope);
					boolean bol = BadConverter.bool(obj);
					view.setChecked(bol);
				}
			});
			view.setChecked(BadConverter.bool(expr.value(scope)));
		}
	}

	@Override
	public Class<Checkable> clazz() {
		return Checkable.class;
	}
}
