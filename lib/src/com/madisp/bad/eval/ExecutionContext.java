package com.madisp.bad.eval;

import com.madisp.bad.lib.BadVar;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/23/13
 * Time: 2:40 PM
 */
public interface ExecutionContext {
	boolean bool(Object var);
	String string(Object var);
	Object object(Object var);
	List list(Object var);

	void setVar(Object base, String var, Object newValue);
	Object getVar(Object base, String identifier);
	Object callMethod(Object base, String m, Object[] argvalues);

	// convenience methods
	void setVar(String var, Object newValue);
	Object getVar(String identifier);
	Object callMethod(String name, Object... args);

	void addWatcher(Watcher w);
}
