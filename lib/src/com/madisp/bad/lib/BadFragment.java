package com.madisp.bad.lib;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.madisp.bad.eval.Expression;
import com.madisp.bad.eval.ExpressionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/20/13
 * Time: 9:04 AM
 */
public abstract class BadFragment extends Fragment {
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
		boolean value = exec.bool(expr.value(exec));
		long end = System.nanoTime();
		Log.d("BadLib", expr + " = " + value + ", parse bench: " + (mid-start) + "ns tree bench: " + (end-mid));
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		BadLayoutFactory factory = new BadLayoutFactory(getActivity(), inflater, exprFactory, exec);
		return factory.getInflater().inflate(layout, null);
	}
}
