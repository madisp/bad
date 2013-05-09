package com.madisp.bad.decor;

import android.util.TypedValue;
import com.madisp.bad.lib.BadLayoutFactory;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 5/9/13
 * Time: 1:42 PM
 */
public interface BadDecorator<T> {
	int[] attrs();
	void decorate(int attr, TypedValue tv, T view);
	void apply(T view, BadLayoutFactory layoutFactory);
	Class<T> clazz();
}
