package com.madisp.bad.decor;

import android.content.Context;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.madisp.bad.eval.BadVar;
import com.madisp.bad.eval.ExecutionContext;
import com.madisp.bad.eval.Watcher;
import com.madisp.bad.expr.Expression;
import com.madisp.bad.expr.ExpressionFactory;
import com.madisp.bad.lib.BadLayoutFactory;
import com.madisp.bad.lib.R;
import com.madisp.bad.lib.ui.BadAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 5/9/13
 * Time: 2:03 PM
 */
public class ListViewDecorator extends BaseDecorator<ListView> {
	private int layout = -1;
	private String itemsExpr = "";

	public ListViewDecorator(ExecutionContext exec, ExpressionFactory expressionFactory, Context context) {
		super(exec, expressionFactory, context);
	}

	@Override
	public int[] attrs() {
		return new int[] { R.attr.items, R.attr.itemClick, R.attr.itemLayout };
	}

	@Override
	public void decorate(int attr, TypedValue tv, ListView view) {
		if (attr == R.attr.itemLayout) {
			layout = tv.resourceId;
		} else if (attr == R.attr.items) {
			itemsExpr = tv.string.toString();
		} else if (attr == R.attr.itemClick) {
			final Expression expr = expressionFactory.buildExpression(tv.string.toString());
			view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					((BadVar) exec.getVar("$item")).set(parent.getItemAtPosition(position));
					expr.value(exec); // don't care about return
				}
			});
		}
	}

	@Override
	public void apply(ListView view, BadLayoutFactory layoutFactory) {
		if (layout != -1 && !TextUtils.isEmpty(itemsExpr)) {
			final Expression expr = expressionFactory.buildExpression(itemsExpr);
			final BadAdapter adapter = new BadAdapter(layout, layoutFactory, exec.converter().list(expr.value(exec)));
			view.setAdapter(adapter);
			expr.addWatcher(exec, new Watcher() {
				@Override
				public void fire(ExecutionContext exec) {
					adapter.notifyDataSetChanged();
				}
			});
		}
	}

	@Override
	public Class<ListView> clazz() {
		return ListView.class;
	}
}
