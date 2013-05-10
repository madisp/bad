package com.madisp.bad.decor;

import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.madisp.bad.eval.BadConverter;
import com.madisp.bad.eval.BadVar;
import com.madisp.bad.eval.Scope;
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

	public ListViewDecorator(ExpressionFactory expressionFactory) {
		super(expressionFactory);
	}

	@Override
	public int[] attrs() {
		return new int[] { R.attr.items, R.attr.itemClick, R.attr.itemLayout };
	}

	@Override
	public void decorate(final Scope scope, final int attr, final TypedValue tv, final ListView view) {
		if (attr == R.attr.itemLayout) {
			layout = tv.resourceId;
		} else if (attr == R.attr.items) {
			itemsExpr = tv.string.toString();
		} else if (attr == R.attr.itemClick) {
			final Expression expr = expressionFactory.buildExpression(tv.string.toString());
			view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					Scope scope = (Scope) view.getTag(R.id.tagExecContext);
					expr.value(scope); // don't care about return
				}
			});
		}
	}

	@Override
	public void apply(final Scope scope, final ListView view, final BadLayoutFactory layoutFactory) {
		if (layout != -1 && !TextUtils.isEmpty(itemsExpr)) {
			final Expression expr = expressionFactory.buildExpression(itemsExpr);
			final BadAdapter adapter = new BadAdapter(layout, layoutFactory, BadConverter.list(expr.value(scope)));
			view.setAdapter(adapter);
			expr.addWatcher(scope, new Watcher() {
				@Override
				public void fire(Scope scope) {
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
