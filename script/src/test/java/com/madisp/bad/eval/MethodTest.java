package com.madisp.bad.eval;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 5/4/13
 * Time: 6:15 PM
 */
public class MethodTest extends ExpressionTestCase{

	@Override
	public void setUp() throws Exception {
		super.setUp();
		scope = new BadScope(scope, this);
	}

	@Test
	public void testIdentities() throws Exception {
		assertEquals("test", eval("'test'"));
		assertEquals("test", eval("stringIdentity('test')"));
	}

	@Test
	public void testBoxing() throws Exception {
		assertEquals(5, eval("addTwo(integer('3'))"));
	}

	@Test
	public void testVarArgs() throws Exception {
		assertEquals("2", eval("fmt('%d', 2)"));
	}

	public String fmt(String formatString, Object... args) {
		return String.format(formatString, args);
	}

	// methods for tests
	public int addTwo(int num) {
		return 2 + num;
	}

	public Integer integer(String integer) {
		return Integer.valueOf(integer);
	}

	public String stringIdentity(String s) {
		return s;
	}
}
