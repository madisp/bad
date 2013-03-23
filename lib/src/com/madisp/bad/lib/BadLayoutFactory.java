package com.madisp.bad.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.madisp.bad.eval.ExecutionContext;
import com.madisp.bad.eval.Expression;
import com.madisp.bad.eval.ExpressionFactory;
import com.madisp.bad.eval.Watcher;
import com.madisp.bad.lib.ui.BadAdapter;
import com.madisp.bad.lib.ui.BadTextWatcher;

import java.util.List;

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
			int[] attrKeys = {R.attr.model, R.attr.error};
			TypedArray arr = context.getResources().obtainAttributes(attrs, attrKeys);
			for (int i = 0; i < arr.length(); i++) {
				if (arr.hasValue(i)) {
					arr.getValue(i, out);
					if (attrKeys[i] == R.attr.model) {
						((EditText) v).addTextChangedListener(new BadTextWatcher(exec.getBadVar(out.string.toString())));
					} else if (attrKeys[i] == R.attr.error) {
						final Expression expr = expressionFactory.buildExpression(out.string.toString());
						expr.addWatcher(exec, new Watcher() {
							@Override
							public void fire() {
								((EditText) fv).setError(exec.coerceToString(expr.value(exec)));
							}
						});
						((EditText) fv).setError(exec.coerceToString(expr.value(exec)));
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
							public void fire() {
								((TextView) fv).setText(exec.coerceToString(expr.value(exec)));
							}
						});
						((TextView) fv).setText(exec.coerceToString(expr.value(exec)));
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
							public void fire() {
								fv.setEnabled(exec.coerceToBool(expr.value(exec)));
							}
						});
						fv.setEnabled(exec.coerceToBool(expr.value(exec)));
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
						((ListView)fv).setOnItemClickListener(new AdapterView.OnItemClickListener() {
							@Override
							public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
								exec.getBadVar("item").set(parent.getItemAtPosition(position));
								expr.value(exec); // don't care about return
							}
						});
					}
				}
			}
			if (layout != -1 && !TextUtils.isEmpty(itemsExpr)) {
				final Expression expr = expressionFactory.buildExpression(itemsExpr);
				final BadAdapter adapter = new BadAdapter(layout, this, (List)expr.value(exec));
				((ListView)fv).setAdapter(adapter);
				expr.addWatcher(exec, new Watcher() {
					@Override
					public void fire() {
						adapter.notifyDataSetChanged();
					}
				});
			}
		}
		v.setTag(R.id.tagExecContext, exec);
		return v;
	}
}