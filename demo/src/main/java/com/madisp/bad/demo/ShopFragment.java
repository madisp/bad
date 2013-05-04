package com.madisp.bad.demo;

import android.os.Bundle;
import com.madisp.bad.eval.BadVar;
import com.madisp.bad.lib.BadFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/24/13
 * Time: 11:43 AM
 */
public class ShopFragment extends BadFragment {
	public BadVar<List<Item>> items = new BadVar<List<Item>>();

	public class Item {
		public String name;
		public BadVar<Boolean> checked = new BadVar<Boolean>();

		public Item(String name) {
			this.name = name;
		}
	}

	protected ShopFragment() {
		super(R.layout.shop);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		items.set(new ArrayList<Item>());
	}

	public void add(String name) {
		items.get().add(new Item(name));
	}
}
