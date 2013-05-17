package com.madisp.bad.decor;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.TypedValue;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.madisp.bad.eval.BadConverter;
import com.madisp.bad.eval.BadVar;
import com.madisp.bad.eval.Scope;
import com.madisp.bad.expr.Expression;
import com.madisp.bad.expr.ExpressionFactory;
import com.madisp.bad.lib.R;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 5/12/13
 * Time: 11:39 AM
 */
public class WebViewDecorator extends BaseDecorator<WebView> {
	public WebViewDecorator(ExpressionFactory expressionFactory) {
		super(expressionFactory);
	}

	@Override
	public int[] attrs() {
		return new int[] { R.attr.model, R.attr.jsEnabled };
	}

	@Override
	public void decorate(Scope scope, int attr, TypedValue tv, final WebView view) {
		if (attr == R.attr.model) {
			Object var = scope.getVar(null, tv.string.toString());
			if (var instanceof BadVar) {
				final BadVar<String> urlVar = (BadVar<String>)var;
				urlVar.addWatcher(new BadVar.BadWatcher<String>() {
					@Override
					public void fire(BadVar<String> var) {
						if (!TextUtils.isEmpty(var.get())) {
							view.loadUrl(var.get());
						}
					}
				});
				view.setWebViewClient(new WebViewClient() {
					@Override
					public void onPageStarted(WebView view, String url, Bitmap favicon) {
						urlVar.set(url);
					}
				});
			}
		} else if (attr == R.attr.jsEnabled) {
			final Expression expr = buildExpr(tv);
			view.getSettings().setJavaScriptEnabled(BadConverter.bool(expr.value(scope)));
		}
	}

	@Override
	public Class<WebView> clazz() {
		return WebView.class;
	}
}
