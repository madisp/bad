package com.madisp.bad.eval;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 5/12/13
 * Time: 9:12 PM
 */
public class ScopeWrapper implements Scope {
	protected Scope scope;

	public ScopeWrapper(Scope scope) {
		this.scope = scope;
	}

	@Override
	public void setVar(Object base, String var, Object newValue) {
		scope.setVar(base, var, newValue);
	}

	@Override
	public Object getVar(Object base, String identifier) {
		return scope.getVar(base, identifier);
	}

	@Override
	public boolean hasVar(Object base, String identifier) {
		return scope.hasVar(base, identifier);
	}

	@Override
	public Object callMethod(Object base, String name, Object... args) {
		return scope.callMethod(base, name, args);
	}

	@Override
	public Scope getParent() {
		return scope.getParent();
	}

	@Override
	public void rebase(Object newBase) {
		scope.rebase(newBase);
	}

	@Override
	public void addOnRebasedListener(OnScopeRebasedListener listener) {
		scope.addOnRebasedListener(listener);
	}
}
