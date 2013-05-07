package com.madisp.bad.eval;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 5/6/13
 * Time: 2:24 PM
 */
public interface Converter {
	boolean bool(Object var);
	String string(Object var);
	Object object(Object var);
	List list(Object var);
	int integer(Object var);
}
