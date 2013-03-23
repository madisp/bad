package com.madisp.bad.demo;

import android.widget.Toast;
import com.madisp.bad.lib.BadFragment;
import com.madisp.bad.lib.BadVar;

public class LoginFragment extends BadFragment {
	public BadVar<String> usernameError = new BadVar<String>();

	public LoginFragment() {
		super(R.layout.login);
	}

	public boolean validateUser(String username) {
		if (!"madis.pink".equals(username)) {
			usernameError.set(getString(R.string.user_error));
			return false;
		}
		return true;
	}

	public void signIn(String username, String password) {
		Toast.makeText(getActivity(), String.format("Logged in as %s", username), Toast.LENGTH_SHORT).show();
		getFragmentManager().popBackStack();
	}
}
