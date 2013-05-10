package com.madisp.bad.eval;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/27/13
 * Time: 6:47 PM
 */
public class DotOperatorTest extends ExpressionTestCase {
	@Test
	public void testDeepIdentifiers() throws Exception {
		scope = new BadScope(scope, new BaseA());

		// test deep vars
		assertEquals("asd", eval("a"));
		assertEquals("bsd", eval("b.c"));

		// test deep methods
		assertEquals("is bad for you", eval("b.meth()"));
		assertEquals("is bad for you", eval("b.a().b.a().b.meth()"));
		assertEquals(null, eval("b.b().lol")); // b() doesn't exist, should return null

		// test deep assignment
		eval("b.c = 'lol'");
		assertEquals("lol", eval("b.c"));
	}

	private static class BaseA {
		public String a = "asd";
		public BaseB b = new BaseB();
	}

	private static class BaseB {
		public String c = "bsd";
		public String meth() {
			return "is bad for you";
		}
		public BaseA a() {
			return new BaseA();
		}
	}
}
