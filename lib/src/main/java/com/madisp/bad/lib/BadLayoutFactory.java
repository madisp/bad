package com.madisp.bad.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import com.madisp.bad.decor.BadDecorator;
import com.madisp.bad.eval.BadScope;
import com.madisp.bad.eval.Scope;

import java.util.ArrayList;

public class BadLayoutFactory implements LayoutInflater.Factory {
	private LayoutInflater inflater;
	private LayoutInflater.Factory wrapped;

	private Scope scope;

	private ArrayList<BadDecorator> decorators = new ArrayList<BadDecorator>(50);

	public BadLayoutFactory(LayoutInflater inflater, Scope rootScope) {
		this.wrapped = inflater.getFactory();
		this.inflater = inflater.cloneInContext(inflater.getContext());
		this.scope = rootScope;
		this.inflater.setFactory(this);
	}

	public LayoutInflater getInflater() {
		return inflater;
	}

	public void addDecorator(BadDecorator decor) {
		decorators.add(decor);
	}

	public void pushScope(Object base) {
		scope = new BadScope(scope, base);
	}

	public void popScope() {
		if (scope != null) {
			scope = scope.getParent();
		}
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
					if ("WebView".equals(name)) {
						name = "android.webkit.WebView";
					} else {
						name = "android.widget." + name;
					}
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
						decor.decorate(curScope(), attrKeys[i], out, v);
					}
				}
				decor.apply(curScope(), v, this);
			}
		}
		v.setTag(R.id.tagScope, curScope());
		return v;
	}

	private Scope curScope() {
		return scope;
	}
}