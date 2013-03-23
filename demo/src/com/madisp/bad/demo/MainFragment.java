package com.madisp.bad.demo;

import com.madisp.bad.lib.BadFragment;
import com.madisp.bad.lib.BadVar;

public class MainFragment extends BadFragment {
	public BadVar<String> usernameError = new BadVar<String>();

	public MainFragment() {
		super(R.layout.main);
	}

	public boolean validateUser(String username) {
		if (!"madis.pink".equals(username)) {
			usernameError.set(getString(R.string.user_error));
			return false;
		}
		return true;
	}

	public void signIn(String username, String password) {
		getActivity().finish();
	}
}
