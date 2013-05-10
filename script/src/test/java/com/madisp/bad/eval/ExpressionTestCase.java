package com.madisp.bad.eval;

import com.madisp.bad.expr.Expression;
import com.madisp.bad.expr.ExpressionFactory;
import org.junit.Before;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/27/13
 * Time: 6:56 PM
 */
public abstract class ExpressionTestCase {
	protected ExpressionFactory exprFactory = new ExpressionFactory();
	protected Scope scope;

	@Before
	public void setUp() throws Exception {
		scope = new BadScope(null, new Object()); // empty base
	}

	protected Object eval(String expr) throws Exception {
		return BadConverter.object(build(expr).value(scope));
	}

	protected Expression build(String expr) throws Exception {
		return exprFactory.buildExpression(expr);
	}
}
