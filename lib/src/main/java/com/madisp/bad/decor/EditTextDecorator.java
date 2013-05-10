package com.madisp.bad.decor;

import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import com.madisp.bad.eval.BadConverter;
import com.madisp.bad.eval.BadVar;
import com.madisp.bad.eval.Scope;
import com.madisp.bad.eval.Watcher;
import com.madisp.bad.expr.Expression;
import com.madisp.bad.expr.ExpressionFactory;
import com.madisp.bad.lib.R;
import com.madisp.bad.lib.ui.BadTextWatcher;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 5/9/13
 * Time: 1:50 PM
 */
public class EditTextDecorator extends BaseDecorator<EditText> {
	public EditTextDecorator(ExpressionFactory expressionFactory) {
		super(expressionFactory);
	}

	@Override
	public int[] attrs() {
		return new int[] { R.attr.model, R.attr.error, R.attr.imeAction };
	}

	@Override
	public void decorate(final Scope scope, final int attr, final TypedValue tv, final EditText view) {
		if (attr == R.attr.model) {
			Object var = scope.getVar(null, tv.string.toString());
			if (var instanceof BadVar) {
				view.addTextChangedListener(new BadTextWatcher((BadVar<String>) var));
				((BadVar) var).addWatcher(new BadVar.BadWatcher() {
					@Override
					public void fire(BadVar var, boolean selfChange) {
						if (!selfChange) {
							view.setText(BadConverter.string(var));
						}
					}
				});
			}
		} else if (attr == R.attr.imeAction) {
			final Expression expr = expressionFactory.buildExpression(tv.string.toString());
			view.setOnEditorActionListener(new TextView.OnEditorActionListener() {
				@Override
				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
					if (actionId == EditorInfo.IME_NULL && KeyEvent.ACTION_DOWN == event.getAction()) {
						return BadConverter.bool(expr.value(scope));
					}
					return false;
				}
			});
		} else if (attr == R.attr.error) {
			final Expression expr = expressionFactory.buildExpression(tv.string.toString());
			expr.addWatcher(scope, new Watcher() {
				@Override
				public void fire(Scope scope) {
					view.setError(BadConverter.string(expr.value(scope)));
				}
			});
			view.setError(BadConverter.string(expr.value(scope)));
		}
	}

	@Override
	public Class<EditText> clazz() {
		return EditText.class;
	}
}
