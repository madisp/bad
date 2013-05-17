package com.madisp.bad.expr;

import com.madisp.bad.eval.BadVar;
import com.madisp.bad.eval.Scope;
import com.madisp.bad.eval.Watcher;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/23/13
 * Time: 1:57 PM
 */
public class VarExpression extends BasableExpression {
	String var;
	public VarExpression(BasableExpression base, String var) {
		super(base);
		this.var = var;
	}

	@Override
	public Object value(Scope scope) {
		if (var == null) {
			return null;
		}
		if (!hasBase()) {
			return scope.getVar(null, var);
		}
		Object base = getBase(scope);
		if (base != null) {
			return scope.getVar(base, var);
		}
		return null;
	}

	public String getIdentifier() {
		return var;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addWatcher(final Scope scope, final Watcher w) {
		super.addWatcher(scope, w);
		Object o = value(scope);
		final BadVar.BadWatcher watcher = new BadVar.BadWatcher() {
			@Override
			public void fire(BadVar var) {
				w.fire(scope);
			}
		};
		if (o instanceof BadVar) {
			((BadVar)o).addWatcher(watcher);
		}
		scope.addOnRebasedListener(new Scope.OnScopeRebasedListener() {
			@Override
			public void onScopeDetached(Scope scope) {
				Object o = value(scope);
				if (o instanceof BadVar) {
					((BadVar)o).removeWatcher(watcher);
				}
			}
			@Override
			public void onScopeAttached(Scope scope) {
				Object o = value(scope);
				if (o instanceof BadVar) {
					((BadVar)o).addWatcher(watcher);
				}
				w.fire(scope);
			}
		});
	}
}
