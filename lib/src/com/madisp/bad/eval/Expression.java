package com.madisp.bad.eval;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/23/13
 * Time: 1:57 PM
 */
public interface Expression {
	Object value(ExecutionContext ctx);
	String toString();
	void addWatcher(ExecutionContext ctx, Watcher w);

}
