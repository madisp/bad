package com.madisp.bad.lib;

import android.test.AndroidTestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/23/13
 * Time: 10:59 PM
 */
public class CollectionTest extends AndroidTestCase {
	public void testWrapper() throws Exception {
		final int[] fires = new int[] { 0 };
		BadVar<List<String>> var = new BadVar<List<String>>();
		var.addWatcher(new BadVar.BadWatcher<List<String>>() {
			@Override
			public void fire(BadVar<List<String>> var, boolean selfChange) {
				fires[0]++;
			}
		});
		var.set(new ArrayList<String>());
		assertEquals(1, fires[0]);
		var.get().add("TEST");
		assertEquals(2, fires[0]);
		assertEquals(1, var.get().size());
	}
}
