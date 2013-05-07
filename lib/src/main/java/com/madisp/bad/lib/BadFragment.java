package com.madisp.bad.lib;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.madisp.bad.eval.BadExecutionContext;
import com.madisp.bad.expr.Expression;
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
		// test our shiny grammar
		long start = System.nanoTime();
		Expression expr = exprFactory.buildExpression("true or false");
		long mid = System.nanoTime();
		boolean value = exec.converter().bool(expr.value(exec));
		long end = System.nanoTime();
		Log.d("BadLib", expr + " = " + value + ", parse bench: " + (mid - start) + "ns tree bench: " + (end - mid));
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		BadLayoutFactory factory = new BadLayoutFactory(getActivity(), inflater, exprFactory, exec);
		return factory.getInflater().inflate(layout, null);
	}
}
