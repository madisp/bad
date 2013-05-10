package com.madisp.bad.lib;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.madisp.bad.decor.CheckableDecorator;
import com.madisp.bad.decor.EditTextDecorator;
import com.madisp.bad.decor.ListViewDecorator;
import com.madisp.bad.decor.TextViewDecorator;
import com.madisp.bad.decor.ViewDecorator;
import com.madisp.bad.eval.BadScope;
import com.madisp.bad.eval.Scope;
import com.madisp.bad.expr.ExpressionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/20/13
 * Time: 9:04 AM
 */
public abstract class BadFragment extends Fragment {
	private final int layout;
	private Scope scope;

	private ExpressionFactory exprFactory = new ExpressionFactory();

	protected BadFragment(int layoutRes) {
		this.layout = layoutRes;
	}

	protected final Scope getScope() {
		return scope == null ? (scope = createScope()) : scope;
	}

	protected Scope createScope() {
		return new BadScope(new BadScope(null, new BadStdLib(getActivity())), this);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		BadLayoutFactory factory = new BadLayoutFactory(inflater, getScope());
		// register standard decorators
		factory.addDecorator(new CheckableDecorator(exprFactory));
		factory.addDecorator(new EditTextDecorator(exprFactory));
		factory.addDecorator(new TextViewDecorator(exprFactory));
		factory.addDecorator(new ViewDecorator(exprFactory));
		factory.addDecorator(new ListViewDecorator(exprFactory));
		// hook to add more decorators before inflation
		beforeInflate(factory);
		return factory.getInflater().inflate(layout, null);
	}

	protected void beforeInflate(BadLayoutFactory factory) {}
}
