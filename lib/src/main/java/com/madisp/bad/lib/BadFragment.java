package com.madisp.bad.lib;

import android.app.Fragment;
import android.os.*;
import android.os.Process;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.madisp.bad.decor.CheckableDecorator;
import com.madisp.bad.decor.EditTextDecorator;
import com.madisp.bad.decor.ListViewDecorator;
import com.madisp.bad.decor.TextViewDecorator;
import com.madisp.bad.decor.ViewDecorator;
import com.madisp.bad.decor.WebViewDecorator;
import com.madisp.bad.eval.BadScope;
import com.madisp.bad.eval.Scope;
import com.madisp.bad.eval.ScopeWrapper;
import com.madisp.bad.expr.BlockExpression;
import com.madisp.bad.expr.ExpressionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/20/13
 * Time: 9:04 AM
 */
public abstract class BadFragment extends Fragment {
	private final int layout;
	private Scope scope;
	protected final Handler fg, bg;
	private final HandlerThread bgThread;

	private ExpressionFactory exprFactory = new ExpressionFactory();

	protected BadFragment(int layoutRes) {
		this.layout = layoutRes;
		fg = new Handler(Looper.getMainLooper());
		bgThread = new HandlerThread("badBgThread", Process.THREAD_PRIORITY_BACKGROUND);
		bgThread.start();
		bg = new Handler(bgThread.getLooper());
	}

	protected final Scope getScope() {
		return scope == null ? (scope = createScope()) : scope;
	}

	protected Scope createScope() {
		return new BadScope(new BadScope(null, new BadStdLib(getActivity())), this);
	}

	public void bg(final BlockExpression bgExpr) {
		bg(bgExpr, null);
	}

	public void bg(final BlockExpression bgExpr, final BlockExpression fgExpr) {
		// it's a possible leak
		bg.post(new Runnable() {
			@Override
			public void run() {
				bgExpr.yield(new ScopeWrapper(getScope()) {
					@Override
					public void setVar(final Object base, final String var, final Object newValue) {
						fg.post(new Runnable() {
							@Override
							public void run() {
								scope.setVar(base, var, newValue);
							}
						});
					}
				});
				if (fgExpr != null) {
					fg.post(new Runnable() {
						@Override
						public void run() {
							fgExpr.yield(getScope());
						}
					});
				}
			}
		});
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		long start = System.nanoTime();
		BadLayoutFactory factory = new BadLayoutFactory(inflater, getScope());
		// register standard decorators
		factory.addDecorator(new CheckableDecorator(exprFactory));
		factory.addDecorator(new EditTextDecorator(exprFactory));
		factory.addDecorator(new TextViewDecorator(exprFactory));
		factory.addDecorator(new ViewDecorator(exprFactory));
		factory.addDecorator(new ListViewDecorator(exprFactory));
		factory.addDecorator(new WebViewDecorator(exprFactory));
		// hook to add more decorators before inflation
		beforeInflate(factory);
		View v = factory.getInflater().inflate(layout, null);
		long end = System.nanoTime();
		Log.d("BadLib", "inflation took " + (end-start) + "ns");
		return v;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		bgThread.quit();
	}

	protected void beforeInflate(BadLayoutFactory factory) {}
}
