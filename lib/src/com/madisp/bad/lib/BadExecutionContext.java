package com.madisp.bad.lib;

import android.text.TextUtils;
import com.madisp.bad.eval.ExecutionContext;
import com.madisp.bad.eval.Expression;
import com.madisp.bad.eval.Watcher;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/23/13
 * Time: 5:47 PM
 */
// TODO reflection cache
public class BadExecutionContext implements ExecutionContext {
	private Object base;

	private Map<String, BadVar> internalVars = new HashMap<String, BadVar>();
	private LinkedList<Watcher> watchmen = new LinkedList<Watcher>();

	public BadExecutionContext(Object base) {
		this.base = base;
	}

	public void rebase(Object newBase) {
		base = newBase;
		// refire
		for (Watcher w : watchmen) {
			w.fire();
		}
	}

	public void addWatcher(Watcher w) {
		this.watchmen.add(w);
	}

	public BadVar getBadVar(String identifier) {
		BadVar bv;
		if ((bv = internalVars.get(identifier)) != null) {
			return bv;
		}
		for (Field f : base.getClass().getDeclaredFields()) {
			if (f.getName().equals(identifier)) {
				try {
					Object o = f.get(base);
					if (o instanceof BadVar) {
						// automatically box out of badvars
						internalVars.put(identifier, (BadVar)o);
						return ((BadVar)o);
					}
					// warn that obj isn't badvar
				} catch (Exception e) {
					// warn that obj isn't accessible
				}
				break;
			}
		}
		// create a new badvar
		bv = new BadVar();
		internalVars.put(identifier, bv);
		return bv;
	}

	@Override
	public Object getVar(String identifier) {
		if ("this".equals(identifier)) {
			return base;
		}
		BadVar bv;
		// check if we have a field instead of the autoboxed var
		if ((bv = internalVars.get(identifier)) != null && bv.get() != null) {
			return bv.get();
		}
		for (Field f : base.getClass().getDeclaredFields()) {
			if (f.getName().equals(identifier)) {
				try {
					Object o = f.get(base);
					if (o instanceof BadVar) {
						// automatically box out of badvars
						internalVars.put(identifier, (BadVar)o);
						return ((BadVar)o).get();
					}
					return o; // warn
				} catch (Exception e) {
					// warn
				}
				break;
			}
		}
		return getBadVar(identifier).get(); // creates a new var in context
	}

	@Override
	public Object callMethod(String name, Object... args) {
		Class[] paramClasses = new Class[args.length];
		for (int i = 0; i < paramClasses.length; i++) {
			paramClasses[i] = args[i] == null ? null : args[i].getClass();
		}
		try {
			out: for (Method m : base.getClass().getMethods()) {
				if (m.getName().equals(name)) {
					for (int i = 0; i < m.getParameterTypes().length; i++) {
						if (paramClasses[i] != null && !m.getParameterTypes()[i].isAssignableFrom(paramClasses[i])) {
							continue out; // noooo
						}
					}
					return m.invoke(base, args);
				}
			}
		} catch (Exception e) {
			System.out.println("Warn: " + e.getMessage());
		}
		return null;
	}

	@Override
	public boolean coerceToBool(Object var) {
		if (var == null) {
			return false;
		}
		if (var instanceof Boolean) {
			return (Boolean)var;
		}
		if (var instanceof CharSequence) {
			return !TextUtils.isEmpty((CharSequence)var);
		}
		return true;
	}

	@Override
	public String coerceToString(Object var) {
		return var == null ? null : var.toString();
	}
}
