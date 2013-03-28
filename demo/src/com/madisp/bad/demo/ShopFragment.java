package com.madisp.bad.demo;

import android.os.Bundle;
import com.madisp.bad.lib.BadFragment;
import com.madisp.bad.lib.BadVar;

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
	public BadVar<String> newItem = new BadVar<String>();

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
//
//	public void toggle(Item item) {
//		item.checked = !item.checked;
//		items.dispatchFire(); // can I get around this?
//	}

	public void add(String name) {
		items.get().add(new Item(name));
	}
}
