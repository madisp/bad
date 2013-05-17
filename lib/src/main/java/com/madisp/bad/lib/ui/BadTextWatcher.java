package com.madisp.bad.lib.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.madisp.bad.eval.BadConverter;
import com.madisp.bad.eval.BadVar;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/23/13
 * Time: 6:45 PM
 */
public class BadTextWatcher implements TextWatcher, BadVar.BadWatcher<String> {
	private BadVar<String> var;
	private TextView tv;

	public BadTextWatcher(TextView tv, BadVar<String> var) {
		this.var = var;
		this.tv = tv;
		var.addWatcher(this);
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
	}

	@Override
	public void afterTextChanged(Editable s) {
		if (!s.toString().equals(var.get())) {
			var.set(s.toString(), this);
		}
	}

	@Override
	public void fire(BadVar<String> var) {
		String newValue = BadConverter.string(var);
		if (!tv.getText().toString().equals(newValue)) {
			tv.setText(newValue);
		}
	}
}
