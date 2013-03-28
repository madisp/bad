package com.madisp.bad.demo;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.madisp.bad.eval.ExecutionContext;
import com.madisp.bad.eval.Expression;
import com.madisp.bad.eval.ExpressionFactory;
import com.madisp.bad.lib.BadExecutionContext;
import com.madisp.bad.lib.BadFragment;
import com.madisp.bad.lib.BadVar;

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
	public ExecutionContext ctx = new BadExecutionContext(this);
	public BadVar<List<String>> log = new BadVar<List<String>>();

	protected ReplFragment() {
		super(R.layout.repl);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		log.set(new ArrayList<String>());
	}

	public void run(String script) {
		if (!TextUtils.isEmpty(script)) {
			Expression expr = factory.buildExpression(script);
			Log.d("BadDemo", expr.toString());
			log.get().add(ctx.string(expr.value(ctx)));
		}
	}
}
