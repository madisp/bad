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
		bec.rebase(this);
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
