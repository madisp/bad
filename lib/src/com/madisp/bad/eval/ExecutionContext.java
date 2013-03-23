package com.madisp.bad.eval;

import com.madisp.bad.lib.BadVar;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/23/13
 * Time: 2:40 PM
 */
public interface ExecutionContext {
	Object getVar(String identifier);
	Object callMethod(String name, Object... args);
	boolean coerceToBool(Object var);
	String coerceToString(Object var);
	BadVar getBadVar(String identifier);
	void addWatcher(Watcher w);
}
