package com.madisp.bad.eval;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/27/13
 * Time: 6:47 PM
 */
public class VarTest extends ExpressionTestCase {
	@Test
	public void testAssignment() throws Exception {
		// test assignment
		eval("a = 'asd'");
		assertEquals("asd", eval("a"));

		// test multiassignment
		eval("a = b = c = 'bsd'");
		assertEquals("bsd", eval("a"));
		assertEquals("bsd", eval("b"));
		assertEquals("bsd", eval("c"));

		// test multistatement scripts
		eval("d = 'csd'; e = 'dsd'");
		assertEquals("csd", eval("d"));
		assertEquals("dsd", eval("e"));
	}
}
