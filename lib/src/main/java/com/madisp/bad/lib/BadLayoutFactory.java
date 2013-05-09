package com.madisp.bad.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import com.madisp.bad.decor.BadDecorator;
import com.madisp.bad.eval.ExecutionContext;
import com.madisp.bad.expr.ExpressionFactory;

import java.util.ArrayList;

public class BadLayoutFactory implements LayoutInflater.Factory {
	private LayoutInflater inflater;
	private LayoutInflater.Factory wrapped;

	private ExecutionContext exec;
	private Context context;
	private ExpressionFactory expressionFactory;

	private ArrayList<BadDecorator> decorators = new ArrayList<BadDecorator>(50);

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

	public void addDecorator(BadDecorator decor) {
		decorators.add(decor);
	}

	@Override @SuppressWarnings("unchecked")
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
		/* magic happens here */
		TypedValue out = new TypedValue();
		for (BadDecorator decor : decorators) {
			if (decor.clazz().isAssignableFrom(v.getClass())) {
				int[] attrKeys = decor.attrs();
				TypedArray arr = context.getResources().obtainAttributes(attrs, attrKeys);
				for (int i = 0; i < arr.length(); i++) {
					if (arr.hasValue(i)) {
						arr.getValue(i, out);
						decor.decorate(attrKeys[i], out, v);
					}
				}
				decor.apply(v, this);
			}
		}
		v.setTag(R.id.tagExecContext, exec);
		return v;
	}
}