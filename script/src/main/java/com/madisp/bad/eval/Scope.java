package com.madisp.bad.eval;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 5/9/13
 * Time: 5:09 PM
 */
public interface Scope {
	void setVar(Object base, String var, Object newValue);
	Object getVar(Object base, String identifier);
	boolean hasVar(Object base, String identifier);
	Object callMethod(Object base, String name, Object... args);
	Scope getParent();
	void digest();
}
