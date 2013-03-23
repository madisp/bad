package com.madisp.bad.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.madisp.bad.eval.Expression;
import com.madisp.bad.eval.ExpressionFactory;
import com.madisp.bad.lib.ui.BadTextWatcher;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/20/13
 * Time: 9:04 AM
 */
public abstract class BadFragment extends Fragment {
	private final BadFactory factory = new BadFactory();
	private final int layout;

	private ExpressionFactory exprFactory = new ExpressionFactory();
	private BadExecutionContext exec = new BadExecutionContext(this);

	protected BadFragment(int layoutRes) {
		this.layout = layoutRes;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// test our shiny grammar
		long start = System.nanoTime();
		Expression expr = exprFactory.buildExpression("true or false");
		long mid = System.nanoTime();
		boolean value = exec.coerceToBool(expr.value(exec));
		long end = System.nanoTime();
		Log.d("BadLib", expr + " = " + value + ", parse bench: " + (mid-start) + "ns tree bench: " + (end-mid));
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		try {
			return factory.attach(inflater).inflate(layout, null);
		} finally {
			factory.detach();
		}
	}

	private class BadFactory implements LayoutInflater.Factory {
		private LayoutInflater inflater;
		private LayoutInflater.Factory wrapped;

		private LayoutInflater attach(LayoutInflater inflater) {
			this.wrapped = inflater.getFactory();
			this.inflater = inflater.cloneInContext(getActivity());
			this.inflater.setFactory(this);
			return this.inflater;
		}

		@Override
		public View onCreateView(String name, Context context, AttributeSet attrs) {
			View v = null;
			if (wrapped != null) {
				v = wrapped.onCreateView(name, context, attrs);
			}

			if (v == null) {
				// default inflater
				try {
					if (!name.contains(".")) {
						name = "android.widget." + name;
					}
					v = inflater.createView(name, null, attrs);
				} catch (ClassNotFoundException cnfe) {
					return null;
				}
			}
			Log.d("BadLib", "Inflated " + v.getClass().getName());
			Log.d("BadLib", "--- attrs ---");
			for (int i = 0; i < attrs.getAttributeCount(); i++) {
				Log.d("BadLib", attrs.getAttributeNameResource(i) + "/" + attrs.getAttributeName(i) + " = " + attrs.getAttributeValue(i));
			}
			final View fv = v;
			/* magic happens here */
			TypedValue out = new TypedValue();
			if (fv instanceof EditText) {
				int[] attrKeys = {R.attr.model, R.attr.error};
				TypedArray arr = getResources().obtainAttributes(attrs, attrKeys);
				for (int i = 0; i < arr.length(); i++) {
					if (arr.hasValue(i)) {
						arr.getValue(i, out);
						if (attrKeys[i] == R.attr.model) {
							((EditText) v).addTextChangedListener(new BadTextWatcher(exec.getBadVar(out.string.toString())));
						} else if (attrKeys[i] == R.attr.error) {
							final Expression expr = exprFactory.buildExpression(out.string.toString());
							expr.addWatcher(exec, new Expression.Watcher() {
								@Override
								public void fire() {
									((EditText) fv).setError(expr.value(exec).toString());
								}
							});
							((EditText) fv).setError(exec.coerceToString(expr.value(exec)));
						}
					}
				}
				arr.recycle();
			} else if (fv instanceof Button) {
				int[] attrKeys = {R.attr.enabled, R.attr.click};
				TypedArray arr = getResources().obtainAttributes(attrs, attrKeys);
				for (int i = 0; i < arr.length(); i++) {
					if (arr.hasValue(i)) {
						arr.getValue(i, out);
						if (attrKeys[i] == R.attr.click) {
							final Expression expr = exprFactory.buildExpression(out.string.toString());
							v.setOnClickListener(new View.OnClickListener() {
								@Override
								public void onClick(View v) {
									expr.value(exec);
								}
							});
						} else if (attrKeys[i] == R.attr.enabled) {
							final Expression expr = exprFactory.buildExpression(out.string.toString());
							expr.addWatcher(exec, new Expression.Watcher() {
								@Override
								public void fire() {
									fv.setEnabled(exec.coerceToBool(expr.value(exec)));
								}
							});
							fv.setEnabled(exec.coerceToBool(expr.value(exec)));
						}
					}
				}
			}
			return v;
		}

		private void detach() {
			inflater = null;
			wrapped = null;
		}
	}
}
