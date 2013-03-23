package com.madisp.bad.lib.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.madisp.bad.lib.BadVar;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/23/13
 * Time: 6:45 PM
 */
public class BadTextWatcher implements TextWatcher {
	private BadVar<String> var;

	public BadTextWatcher(BadVar<String> var) {
		this.var = var;
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
	}

	@Override
	public void afterTextChanged(Editable s) {
		var.set(s.toString());
	}
}
