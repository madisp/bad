package com.madisp.bad.demo;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import com.madisp.bad.eval.BadVar;
import com.madisp.bad.lib.BadFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListFragment extends BadFragment {
	public BadVar<List<DemoItem>> items = new BadVar<List<DemoItem>>();

	public static class DemoItem {
		public String fragment;
		public String name;
		public String description;

		public DemoItem(String fragment, String name, String description) {
			this.fragment = fragment;
			this.name = name;
			this.description = description;
		}
	}

	public ListFragment() {
		super(R.layout.list);
		items.set(new ArrayList<DemoItem>());
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		String[] frags = getResources().getStringArray(R.array.demoFragments);
		String[] names = getResources().getStringArray(R.array.demoNames);
		String[] descs = getResources().getStringArray(R.array.demoDescs);
		DemoItem[] demoItems = new DemoItem[frags.length];
		for (int i = 0; i < demoItems.length; i++) {
			demoItems[i] = new DemoItem(frags[i], names[i], descs[i]);
		}
		items.set(Arrays.asList(demoItems));
	}

	public void navigate(DemoItem item) {
		try {
			Fragment fragment = (Fragment) (Class.forName("com.madisp.bad.demo." + item.fragment).newInstance());
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			ft.replace(R.id.mainContainer, fragment, item.fragment);
			ft.addToBackStack(null);
			ft.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
