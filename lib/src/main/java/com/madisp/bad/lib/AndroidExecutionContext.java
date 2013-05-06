package com.madisp.bad.lib;

import android.content.Context;
import com.madisp.bad.eval.BadExecutionContext;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 5/6/13
 * Time: 1:06 PM
 */
public class AndroidExecutionContext extends BadExecutionContext {
	private Context context;

	public AndroidExecutionContext(Context context, Object base) {
		super(base);
		this.context = context;
	}

	@Override
	public int getResourceId(String name) {
		return context.getResources().getIdentifier(name, null, context.getPackageName());
	}
}
