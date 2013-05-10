package com.madisp.bad.expr;

import com.madisp.bad.eval.Scope;
import com.madisp.bad.eval.Watcher;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/23/13
 * Time: 1:57 PM
 */
public interface Expression {
	Object value(Scope scope);
	String toString();
	void addWatcher(Scope scope, Watcher w);
}
