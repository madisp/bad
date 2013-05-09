package com.madisp.bad.decor;

import android.content.Context;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import com.madisp.bad.eval.BadVar;
import com.madisp.bad.eval.ExecutionContext;
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
	public EditTextDecorator(ExecutionContext exec, ExpressionFactory expressionFactory, Context context) {
		super(exec, expressionFactory, context);
	}

	@Override
	public int[] attrs() {
		return new int[] { R.attr.model, R.attr.error, R.attr.imeAction };
	}

	@Override
	public void decorate(final int attr, final TypedValue tv, final EditText view) {
		if (attr == R.attr.model) {
			Object var = exec.getVar(tv.string.toString());
			if (var instanceof BadVar) {
				view.addTextChangedListener(new BadTextWatcher((BadVar<String>) var));
				((BadVar) var).addWatcher(new BadVar.BadWatcher() {
					@Override
					public void fire(BadVar var, boolean selfChange) {
						if (!selfChange) {
							view.setText(var.get().toString());
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
						return exec.converter().bool(expr.value(exec));
					}
					return false;
				}
			});
		} else if (attr == R.attr.error) {
			final Expression expr = expressionFactory.buildExpression(tv.string.toString());
			expr.addWatcher(exec, new Watcher() {
				@Override
				public void fire(ExecutionContext exec) {
					view.setError(exec.converter().string(expr.value(exec)));
				}
			});
			view.setError(exec.converter().string(expr.value(exec)));
		}
	}

	@Override
	public Class<EditText> clazz() {
		return EditText.class;
	}
}
