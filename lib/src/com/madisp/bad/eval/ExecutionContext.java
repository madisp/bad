package com.madisp.bad.eval;

import com.madisp.bad.lib.BadVar;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/23/13
 * Time: 2:40 PM
 */
public interface ExecutionContext {
	Object callMethod(String name, Object... args);
	boolean coerceToBool(Object var);
	String coerceToString(Object var);

	// convenience methods
	Object getVar(String identifier);
	void setVar(String var, Object newValue);
	BadVar getBadVar(String identifier);

	Object getVar(Object base, String identifier);
	Object callMethod(Object base, String m, Object[] argvalues);

	void addWatcher(Watcher w);
}
