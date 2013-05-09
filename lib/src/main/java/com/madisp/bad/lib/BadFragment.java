package com.madisp.bad.lib;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.madisp.bad.decor.CheckableDecorator;
import com.madisp.bad.decor.EditTextDecorator;
import com.madisp.bad.decor.ListViewDecorator;
import com.madisp.bad.decor.TextViewDecorator;
import com.madisp.bad.decor.ViewDecorator;
import com.madisp.bad.expr.ExpressionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/20/13
 * Time: 9:04 AM
 */
public abstract class BadFragment extends Fragment {
	private final int layout;

	private ExpressionFactory exprFactory = new ExpressionFactory();
	private AndroidExecutionContext exec;

	protected BadFragment(int layoutRes) {
		this.layout = layoutRes;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		exec = new AndroidExecutionContext(activity, this);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		BadLayoutFactory factory = new BadLayoutFactory(getActivity(), inflater, exprFactory, exec);
		// register standard decorators
		factory.addDecorator(new CheckableDecorator(exec, exprFactory, getActivity()));
		factory.addDecorator(new EditTextDecorator(exec, exprFactory, getActivity()));
		factory.addDecorator(new TextViewDecorator(exec, exprFactory, getActivity()));
		factory.addDecorator(new ViewDecorator(exec, exprFactory, getActivity()));
		factory.addDecorator(new ListViewDecorator(exec, exprFactory, getActivity()));
		return factory.getInflater().inflate(layout, null);
	}
}
