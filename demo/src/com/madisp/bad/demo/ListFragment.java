package com.madisp.bad.demo;

import android.app.Activity;
import android.widget.Toast;
import com.madisp.bad.lib.BadFragment;
import com.madisp.bad.lib.BadVar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListFragment extends BadFragment {
	public BadVar<List<String>> items = new BadVar<List<String>>();

	public ListFragment() {
		super(R.layout.list);
		items.set(new ArrayList<String>());
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
//		items.set(Arrays.asList(getResources().getStringArray(R.array.demoFragments)));
		List<String> strings = new ArrayList<String>();
		for (int i = 0; i < 200; i++) {
			strings.add("Item " + (i+1));
		}
		items.set(strings);
	}

	public void navigate(String frag) {
		Toast.makeText(getActivity(), String.format("Clicked on frag %s", frag), Toast.LENGTH_SHORT).show();
	}
}
