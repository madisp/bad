package com.madisp.bad.lib.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.madisp.bad.eval.BadExecutionContext;
import com.madisp.bad.lib.BadLayoutFactory;
import com.madisp.bad.lib.R;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/23/13
 * Time: 11:41 PM
 */
public class BadAdapter extends BaseAdapter {
	List data;
	BadLayoutFactory fact;
	int layout;

	public BadAdapter(int layout, BadLayoutFactory fact, List data) {
		this.data = data;
		this.layout = layout;
		this.fact = fact;
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Object o = getItem(position);
		if (convertView == null) {
			BadExecutionContext ctx = new BadExecutionContext(o);
			convertView = fact.cloneInExecutionContext(ctx).getInflater().inflate(layout, null);
			convertView.setTag(R.id.tagExecContext, ctx);
		} else {
			((BadExecutionContext) convertView.getTag(R.id.tagExecContext)).rebase(o);
		}
		return convertView;
	}
}
