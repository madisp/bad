package com.madisp.bad.lib.eval;

import android.test.AndroidTestCase;
import com.madisp.bad.eval.Expression;
import com.madisp.bad.eval.ExpressionFactory;
import com.madisp.bad.lib.BadExecutionContext;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/27/13
 * Time: 6:56 PM
 */
public abstract class ExpressionTestCase extends AndroidTestCase {
	protected ExpressionFactory exprFactory = new ExpressionFactory();
	protected BadExecutionContext bec;

	@Override
	public void setUp() throws Exception {
		bec = new BadExecutionContext(new Object()); // empty base
	}

	protected Object eval(String expr) throws Exception {
		return build(expr).value(bec);
	}

	protected Expression build(String expr) throws Exception {
		return exprFactory.buildExpression(expr);
	}

	@Override
	public void tearDown() throws Exception {
		//TODO clear bec
	}
}
