package com.madisp.bad.lib;

import android.content.Context;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 5/10/13
 * Time: 11:14 AM
 */
public class BadStdLib {
	private final Context context;

	public BadStdLib(Context context) {
		this.context = context;
	}

	public int getResourceId(String name) {
		return context.getResources().getIdentifier(name, null, context.getPackageName());
	}
}
