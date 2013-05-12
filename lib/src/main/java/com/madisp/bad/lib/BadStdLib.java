package com.madisp.bad.lib;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;
import com.madisp.bad.expr.BlockExpression;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 5/10/13
 * Time: 11:14 AM
 */
public class BadStdLib {
	public final Context context;

	public final int gone = View.GONE;
	public final int visible = View.VISIBLE;
	public final int invisible = View.INVISIBLE;

	public BadStdLib(Context context) {
		this.context = context;
	}

	public Uri uri(String s) {
		return Uri.parse(s);
	}

	public int getResourceId(String name) {
		return context.getResources().getIdentifier(name, null, context.getPackageName());
	}

	public void toast(String text) {
		Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
	}

	public void toast(int resId) {
		Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
	}
}
