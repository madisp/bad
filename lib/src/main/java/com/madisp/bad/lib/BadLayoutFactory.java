package com.madisp.bad.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.madisp.bad.eval.BadVar;
import com.madisp.bad.eval.ExecutionContext;
import com.madisp.bad.eval.Watcher;
import com.madisp.bad.expr.Expression;
import com.madisp.bad.expr.ExpressionFactory;
import com.madisp.bad.lib.ui.BadAdapter;
import com.madisp.bad.lib.ui.BadTextWatcher;

public class BadLayoutFactory implements LayoutInflater.Factory {
	private LayoutInflater inflater;
	private LayoutInflater.Factory wrapped;

	private ExecutionContext exec;
	private Context context;
	private ExpressionFactory expressionFactory;

	public BadLayoutFactory(Context context, LayoutInflater inflater, ExpressionFactory exprFactory, ExecutionContext exec) {
		this.context = context;
		this.wrapped = inflater.getFactory();
		this.inflater = inflater.cloneInContext(context);
		this.expressionFactory = exprFactory;
		this.exec = exec;
		this.inflater.setFactory(this);
	}

	public BadLayoutFactory cloneInExecutionContext(ExecutionContext newExec) {
		return new BadLayoutFactory(context, (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE), expressionFactory, newExec);
	}

	public LayoutInflater getInflater() {
		return inflater;
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
			final EditText et = (EditText) fv;
			int[] attrKeys = {R.attr.model, R.attr.error, R.attr.imeAction};
			TypedArray arr = context.getResources().obtainAttributes(attrs, attrKeys);
			for (int i = 0; i < arr.length(); i++) {
				if (arr.hasValue(i)) {
					arr.getValue(i, out);
					if (attrKeys[i] == R.attr.imeAction) {
						final Expression expr = expressionFactory.buildExpression(out.string.toString());
						((EditText) fv).setOnEditorActionListener(new TextView.OnEditorActionListener() {
							@Override
							public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
								if (actionId == EditorInfo.IME_NULL && KeyEvent.ACTION_DOWN == event.getAction()) {
									return exec.converter().bool(expr.value(exec));
								}
								return false;
							}
						});
//						v.setOnClickListener(new View.OnClickListener() {
//							@Override
//							public void onClick(View v) {
//								script.value(exec);
//							}
//						});
					} else if (attrKeys[i] == R.attr.model) {
						Object var = exec.getVar(out.string.toString());
						if (var instanceof BadVar) {
							((EditText) v).addTextChangedListener(new BadTextWatcher((BadVar) var));
							((BadVar) var).addWatcher(new BadVar.BadWatcher() {
								@Override
								public void fire(BadVar var, boolean selfChange) {
									if (!selfChange) {
										((EditText) fv).setText(var.get().toString());
									}
								}
							});
						}
					} else if (attrKeys[i] == R.attr.error) {
						final Expression expr = expressionFactory.buildExpression(out.string.toString());
						expr.addWatcher(exec, new Watcher() {
							@Override
							public void fire(ExecutionContext exec) {
								((EditText) fv).setError(exec.converter().string(expr.value(exec)));
							}
						});
						((EditText) fv).setError(exec.converter().string(expr.value(exec)));
					}
				}
			}
			arr.recycle();
		}
		if (fv instanceof TextView) {
			int[] attrKeys = {R.attr.text};
			TypedArray arr = context.getResources().obtainAttributes(attrs, attrKeys);
			for (int i = 0; i < arr.length(); i++) {
				if (arr.hasValue(i)) {
					arr.getValue(i, out);
					if (attrKeys[i] == R.attr.text) {
						final Expression expr = expressionFactory.buildExpression(out.string.toString());
						expr.addWatcher(exec, new Watcher() {
							@Override
							public void fire(ExecutionContext exec) {
								((TextView) fv).setText(exec.converter().string(expr.value(exec)));
							}
						});
						((TextView) fv).setText(exec.converter().string(expr.value(exec)));
					}
				}
			}
		}
		if (fv instanceof Button) {
			int[] attrKeys = {R.attr.enabled, R.attr.click};
			TypedArray arr = context.getResources().obtainAttributes(attrs, attrKeys);
			for (int i = 0; i < arr.length(); i++) {
				if (arr.hasValue(i)) {
					arr.getValue(i, out);
					if (attrKeys[i] == R.attr.click) {
						final Expression expr = expressionFactory.buildExpression(out.string.toString());
						v.setOnClickListener(new View.OnClickListener() {
							@Override
							public void onClick(View v) {
								expr.value(exec);
							}
						});
					} else if (attrKeys[i] == R.attr.enabled) {
						final Expression expr = expressionFactory.buildExpression(out.string.toString());
						expr.addWatcher(exec, new Watcher() {
							@Override
							public void fire(ExecutionContext exec) {
								fv.setEnabled(exec.converter().bool(expr.value(exec)));
							}
						});
						fv.setEnabled(exec.converter().bool(expr.value(exec)));
					}
				}
			}
		}
		if (fv instanceof ListView) {
			int[] attrKeys = {R.attr.items, R.attr.itemClick, R.attr.itemLayout};
			TypedArray arr = context.getResources().obtainAttributes(attrs, attrKeys);

			int layout = -1;
			String itemsExpr = null;

			for (int i = 0; i < arr.length(); i++) {
				if (arr.hasValue(i)) {
					arr.getValue(i, out);
					if (attrKeys[i] == R.attr.itemLayout) {
						layout = out.resourceId;
					} else if (attrKeys[i] == R.attr.items) {
						itemsExpr = out.string.toString();
					} else if (attrKeys[i] == R.attr.itemClick) {
						final Expression expr = expressionFactory.buildExpression(out.string.toString());
						((ListView) fv).setOnItemClickListener(new AdapterView.OnItemClickListener() {
							@Override
							public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
								((BadVar) exec.getVar("$item")).set(parent.getItemAtPosition(position));
								expr.value(exec); // don't care about return
							}
						});
					}
				}
			}
			if (layout != -1 && !TextUtils.isEmpty(itemsExpr)) {
				final Expression expr = expressionFactory.buildExpression(itemsExpr);
				final BadAdapter adapter = new BadAdapter(layout, this, exec.converter().list(expr.value(exec)));
				((ListView) fv).setAdapter(adapter);
				expr.addWatcher(exec, new Watcher() {
					@Override
					public void fire(ExecutionContext exec) {
						adapter.notifyDataSetChanged();
					}
				});
			}
		}
		if (fv instanceof Checkable) {
			int[] attrKeys = {R.attr.checked};
			TypedArray arr = context.getResources().obtainAttributes(attrs, attrKeys);
			for (int i = 0; i < arr.length(); i++) {
				if (arr.hasValue(i)) {
					arr.getValue(i, out);
					if (attrKeys[i] == R.attr.checked) {
						final Expression expr = expressionFactory.buildExpression(out.string.toString());
						expr.addWatcher(exec, new Watcher() {
							@Override
							public void fire(ExecutionContext exec) {
								Object obj = expr.value(exec);
								boolean bol = exec.converter().bool(obj);
								((Checkable) fv).setChecked(bol);

							}
						});
						((Checkable) fv).setChecked(exec.converter().bool(expr.value(exec)));
					}
				}
			}
		}
		v.setTag(R.id.tagExecContext, exec);
		return v;
	}
}