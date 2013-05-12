package com.madisp.bad.eval;

import com.madisp.bad.expr.BlockExpression;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 5/12/13
 * Time: 3:17 PM
 */
public class BlockTest extends ExpressionTestCase {
	@Test
	public void testNoArgs() throws Exception {
		Object asdf = BadConverter.object(build("{'asdf'}").value(scope));
		assertTrue("Not an block expression", asdf instanceof BlockExpression);
		assertEquals("asdf", ((BlockExpression) asdf).yield(scope));
	}

	@Test
	public void testOneArg() throws Exception {
		Object sqr = BadConverter.object(build("{|x| x*x}").value(scope));
		assertTrue("Not an block expression", sqr instanceof BlockExpression);
		assertEquals(4, ((BlockExpression) sqr).yield(scope, 2));
		assertEquals(9, ((BlockExpression) sqr).yield(scope, 3));
		assertEquals(16, ((BlockExpression) sqr).yield(scope, 4));
		assertEquals(25, ((BlockExpression) sqr).yield(scope, -5));
	}

	@Test
	public void testTwoArgs() throws Exception {
		Object add = BadConverter.object(build("{|x,y| x+y}").value(scope));
		assertTrue("Not an block expression", add instanceof BlockExpression);
		assertEquals(5, ((BlockExpression) add).yield(scope, 2, 3));
		assertEquals(-1, ((BlockExpression) add).yield(scope, 2, -3));
	}
}
