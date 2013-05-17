package com.madisp.bad;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 5/17/13
 * Time: 10:54 PM
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface Persist {
	String key() default "";
}
