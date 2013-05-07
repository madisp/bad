package com.madisp.bad.eval;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.madisp.bad.eval.BadConverter.areAssignableFrom;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/23/13
 * Time: 5:47 PM
 */
// TODO reflection cache
public class BadExecutionContext implements ExecutionContext {
	private Object base;
	private Converter converter = new BadConverter();

	private Map<VarKey, BadVar> internalVars = new HashMap<VarKey, BadVar>();
	private LinkedList<Watcher> watchmen = new LinkedList<Watcher>();

	public BadExecutionContext(Object base) {
		this.base = base;
	}

	public void rebase(Object newBase) {
		base = newBase;
		// refire
		for (Watcher w : watchmen) {
			w.fire(this);
		}
	}

	public void addWatcher(Watcher w) {
		this.watchmen.add(w);
	}

	@Override
	public int getResourceId(String name) {
		return 0;
	}

//	public BadVar getBadVar(String identifier) {
//		BadVar bv;
//		if ((bv = internalVars.get(identifier)) != null) {
//			return bv;
//		}
//		for (Field f : base.getClass().getDeclaredFields()) {
//			if (f.getName().equals(identifier)) {
//				try {
//					Object o = f.get(base);
//					if (o instanceof BadVar) {
//						// automatically box out of badvars
//						internalVars.put(identifier, (BadVar)o);
//						return ((BadVar)o);
//					}
//					// warn that obj isn't badvar
//				} catch (Exception e) {
//					// warn that obj isn't accessible
//					e.printStackTrace();
//				}
//				break;
//			}
//		}
//		// create a new badvar
//		bv = new BadVar();
//		internalVars.put(identifier, bv);
//		return bv;
//	}

	private BadVar getBadVar(Object base, String identifier) {
		BadVar bv;
		VarKey key = new VarKey(base, identifier);
		if ((bv = internalVars.get(key)) == null) {
			bv = new BadVar();
			internalVars.put(key, bv);
		}
		return bv;
	}

	@Override
	public void setVar(Object base, String identifier, Object value) {
		if (base == null) {
			base = this.base;
		}
		Field f = getField(base, identifier);
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
		BadVar var = getBadVar(base, identifier);
		if (var != null) {
			var.set(value);
			return;
		}
	}

	@Override
	public Object getVar(Object base, String identifier) {
		if ("this".equals(identifier)) {
			return base;
		}
		if (base == null) {
			base = this.base;
		}

		BadVar bv;
		// check if we have a field instead of the autoboxed var
		if ((bv = getBadVar(base, identifier)) != null && bv.get() != null) {
			return bv;
		}
		for (Field f : base.getClass().getDeclaredFields()) {
			if (f.getName().equals(identifier)) {
				try {
					Object o = f.get(base);
					if (o instanceof BadVar) {
						// automatically box out of badvars
						// maybe do this in coercion instead?
						internalVars.put(new VarKey(base, identifier), (BadVar)o);
					}
					return o;
				} catch (Exception e) {
					// warn
					e.printStackTrace();
				}
				break;
			}
		}
		return getBadVar(base, identifier); // creates a new var in context
	}

	@Override
	public Object callMethod(Object base, String name, Object... args) {
		Class[] paramClasses = new Class[args.length];
		for (int i = 0; i < paramClasses.length; i++) {
			paramClasses[i] = args[i] == null ? null : args[i].getClass();
		}
		try {
			for (Method m : base.getClass().getMethods()) {
				if (m.getName().equals(name)) {
					if (areAssignableFrom(m.getParameterTypes(), paramClasses)) {
						// signature matches
						return m.invoke(base, args);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Warn: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	// converters

	@Override
	public Converter converter() {
		return converter;
	}

	// convenience methods

	@Override
	public Object callMethod(String name, Object... args) {
		return callMethod(base, name, args);
	}

	@Override
	public Object getVar(String identifier) {
		return getVar(base, identifier);
	}

	@Override
	public void setVar(String identifier, Object newValue) {
		setVar(base, identifier, newValue);
	}

	// implementation helpers

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
