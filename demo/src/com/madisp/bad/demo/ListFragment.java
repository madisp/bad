package com.madisp.bad.demo;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
		items.set(Arrays.asList(getResources().getStringArray(R.array.demoFragments)));
	}

	public void navigate(String fragName) {
		try {
			Fragment fragment = (Fragment) (Class.forName("com.madisp.bad.demo." + fragName).newInstance());
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			ft.replace(R.id.mainContainer, fragment, fragName);
			ft.addToBackStack(null);
			ft.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
