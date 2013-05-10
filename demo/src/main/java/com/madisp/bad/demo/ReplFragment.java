package com.madisp.bad.demo;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.madisp.bad.eval.BadConverter;
import com.madisp.bad.eval.BadVar;
import com.madisp.bad.expr.Expression;
import com.madisp.bad.expr.ExpressionFactory;
import com.madisp.bad.lib.BadFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/24/13
 * Time: 11:43 AM
 */
public class ReplFragment extends BadFragment {
	private ExpressionFactory factory = new ExpressionFactory();
	public BadVar<List<String>> log = new BadVar<List<String>>();

	protected ReplFragment() {
		super(R.layout.repl);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		log.set(new ArrayList<String>());
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}

	public void run(String script) {
		if (!TextUtils.isEmpty(script)) {
			Expression expr = factory.buildExpression(script);
			Object value = expr.value(getScope());
			log.get().add(BadConverter.string(value));
		}
	}
}
