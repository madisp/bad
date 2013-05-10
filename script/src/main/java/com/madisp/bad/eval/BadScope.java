package com.madisp.bad.eval;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.madisp.bad.eval.BadConverter.areAssignableFrom;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 5/9/13
 * Time: 5:12 PM
 */
public class BadScope implements Scope {
	private Scope parent;
	private Object base;

	private List<Watcher> watchmen = new LinkedList<Watcher>();
	private Map<VarKey, BadVar> internalVars = new HashMap<VarKey, BadVar>();

	public BadScope(Scope parent, Object base) {
		this.parent = parent;
		this.base = base;
	}

	@Override
	public void setVar(Object base, String var, Object newValue) {
		if (hasVar(base, var)) {
			setVarImpl(base, var, newValue);
		}
		Scope scope = walkUp(base, var);
		if (scope != null) {
			scope.setVar(base, var, newValue);
		} else {
			createVarImpl(base, var, newValue);
		}
	}

	@Override
	public Object getVar(Object base, String var) {
		if (hasVar(base, var)) {
			return getVarImpl(base, var);
		}
		Scope scope = walkUp(base, var);
		if (scope != null) {
			return scope.getVar(base, var);
		}
		return createVarImpl(base, var, null);
	}

	@Override
	public boolean hasVar(Object base, String identifier) {
		if ("this".equals(identifier)) {
			return true;
		}
		return getBadVar(base, identifier) != null || getField(base, identifier) != null;
	}

	@Override
	public Object callMethod(Object base, String name, Object... args) {
		Object mBase = base;
		if (mBase == null) {
			mBase = this.base;
		}
		Method m = getMethodBySignature(mBase, name, args);
		if (m == null && parent != null) {
			return parent.callMethod(base, name, args);
		} else if (m != null) {
			try {
				return m.invoke(mBase, args);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Scope getParent() {
		return parent;
	}

	@Override
	public void rebase(Object newBase) {
		base = newBase;
		for (Watcher w : watchmen) {
			w.fire(this);
		}
	}

	@Override
	public void addWatcher(Watcher w) {
		this.watchmen.add(w);
	}

	private Scope walkUp(Object base, String var) {
		Scope scope = this.getParent();
		while (scope != null && !scope.hasVar(base, var)) {
			scope = scope.getParent();
		}
		return scope;
	}

	private void setVarImpl(Object base, String var, Object value) {
		if (base == null) {
			base = this.base;
		}
		BadVar bv = getBadVar(base, var);
		if (bv != null) {
			bv.set(value);
			return;
		}
		Field f = getField(base, var);
		if (f != null) {
			try {
				Object o = f.get(base);
				if (o != null && o instanceof BadVar) {
					((BadVar)o).set(value);
					return;
				}
				f.set(base, value);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	private Object getVarImpl(Object base, String var) {
		if (base == null) {
			base = this.base;
		}
		if ("this".equals(var)) {
			return base;
		}
		BadVar bv = getBadVar(base, var);
		if (bv != null) {
			return bv;
		}

		Field f = getField(base, var);
		if (f != null) {
			try {
				return f.get(base);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	private BadVar getBadVar(Object base, String var) {
		if (base == null) {
			base = this.base;
		}
		return internalVars.get(new VarKey(base, var));
	}

	private BadVar createVarImpl(Object base, String var, Object value) {
		if (base == null) {
			base = this.base;
		}
		BadVar bv;
		VarKey key = new VarKey(base, var);
		if ((bv = internalVars.get(key)) == null) {
			bv = new BadVar();
			internalVars.put(key, bv);
		}
		bv.set(value);
		return bv;
	}

	private Method getMethodBySignature(Object base, String name, Object... args) {
		if (base == null) {
			base = this.base;
		}
		Class[] paramClasses = new Class[args.length];
		for (int i = 0; i < paramClasses.length; i++) {
			paramClasses[i] = args[i] == null ? null : args[i].getClass();
		}
		for (Method m : base.getClass().getMethods()) {
			if (m.getName().equals(name)) {
				if (areAssignableFrom(m.getParameterTypes(), paramClasses)) {
					// signature matches
					return m;
				}
			}
		}
		return null;
	}

	private Field getField(Object base, String identifier) {
		if (base == null) {
			base = this.base;
		}
		if (base == null) {
			return null;
		}
		for (Field f : base.getClass().getDeclaredFields()) {
			if (f.getName().equals(identifier)) {
				return f;
			}
		}
		return null;
	}

	private static class VarKey {
		Object base;
		String identifier;

		private VarKey(Object base, String identifier) {
			this.base = base;
			this.identifier = identifier;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			VarKey varKey = (VarKey) o;

			if (base != null ? base.hashCode() != varKey.base.hashCode() : varKey.base != null) return false;
			if (!identifier.equals(varKey.identifier)) return false;

			return true;
		}

		@Override
		public int hashCode() {
			int result = base != null ? base.hashCode() : 0;
			result = 31 * result + identifier.hashCode();
			return result;
		}
	}
}
