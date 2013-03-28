package com.madisp.bad.lib.eval;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/27/13
 * Time: 6:47 PM
 */
public class ScriptTest extends ExpressionTestCase {
	public void testAssignment() throws Exception {
		// test assignment
		eval("a = \"asd\"");
		assertEquals("asd", eval("a"));

		// test multiassignment
		eval("a = b = c = \"bsd\"");
		assertEquals("bsd", eval("a"));
		assertEquals("bsd", eval("b"));
		assertEquals("bsd", eval("c"));

		// test multistatement scripts
		eval("d = \"csd\"; e = \"dsd\"");
		assertEquals("csd", eval("d"));
		assertEquals("dsd", eval("e"));
	}

	public void testDeepIdentifiers() throws Exception {
		System.out.println(build("getObject().field.Method().otherField"));
		bec.rebase(new BaseA());

		// test deep vars
		assertEquals("asd", eval("a"));
		assertEquals("bsd", eval("b.c"));

		// test deep methods
		assertEquals("is bad for you", eval("b.meth()"));
		assertEquals("is bad for you", eval("b.a().b.a().b.meth()"));
		assertEquals(null, eval("b.b().lol")); // b() doesn't exist, should return null

		// test deep assignment
		eval("b.c = \"lol\"");
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
