package com.madisp.bad.eval;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 5/10/13
 * Time: 11:50 AM
 */
public class ScopeTest extends ExpressionTestCase {
	@Test
	public void testSubScopedThis() throws Exception {
		String a = "asdf";
		scope = new BadScope(scope, a);
		assertEquals("asdf", eval("this"));
	}

	@Test
	public void testMethodFallback() throws Exception {
		scope = new BadScope(new BadScope(null, this), new Object());
		assertEquals("asdf", eval("field"));
	}

	@Test
	public void testFieldFallback() throws Exception {
		scope = new BadScope(new BadScope(null, this), new Object());
		assertEquals("bsdf", eval("method()"));
	}

	public String field = "asdf";
	public String method() {
		return "bsdf";
	}
}
