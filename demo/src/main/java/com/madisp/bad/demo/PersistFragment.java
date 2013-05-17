package com.madisp.bad.demo;

import android.app.Activity;
import com.madisp.bad.Freezer;
import com.madisp.bad.Persist;
import com.madisp.bad.eval.BadVar;
import com.madisp.bad.lib.BadFragment;

public class PersistFragment extends BadFragment {
	@Persist(key = "woopwoop")
	public BadVar<String> var = new BadVar<String>(null);

	private Freezer freezer;

	public PersistFragment() {
		super(R.layout.persist);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		freezer = new Freezer(activity);
		freezer.start(getScope());
	}

	@Override
	public void onDetach() {
		super.onDetach();
		freezer.stop();
	}
}
