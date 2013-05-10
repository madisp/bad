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
		/*
		Taken from http://www.jamieoliver.com/recipes/beef-recipes/good-old-chilli-con-carne
		*/
		add("2 medium onions");
		add("2 cloves garlic");
		add("2 medium carrots");
		add("2 sticks celery");
		add("2 red peppers");
		add("olive oil");
		add("chilli powder");
		add("cumin");
		add("cinnamon");
		add("sea salt");
		add("black pepper");
		add("400 g tinned chickpeas");
		add("400 g tinned red kidney beans");
		add("2 x 400 g tinned chopped tomatoes");
		add("500 g quality minced beef");
		add("1 small bunch fresh coriander");
		add("2 tablespoons balsamic vinegar");
		add("400 g basmati rice");
		add("500 g natural yoghurt");
		add("230 g guacamole");
		add("1 lime");
	}

	public void add(String name) {
		items.get().add(new Item(name));
	}
}
