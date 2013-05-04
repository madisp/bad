package com.madisp.bad.eval;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 5/4/13
 * Time: 6:41 PM
 */
public class Converter {
	public static int integer(Object o) {
		return 0;
	}

	public static Object object(Object o, Class target) {
		if (o == null) {
			return null;
		}
		if (target.isAssignableFrom(o.getClass())) {
			return o;
		}
		return null;
	}

	public static boolean areAssignableFrom(Class[] a, Class[] b) {
		if (a == null || b == null || a.length != b.length) {
			return false;
		}
		for (int i = 0; i < a.length; i++) {
			if (!isAssignableFrom(a[i], b[i])) {
				return false;
			}
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public static boolean isAssignableFrom(Class a, Class b) {
		// same class
		if (a.equals(b)) {
			return true;
		}
		// byte
		if (a.equals(byte.class) && b.equals(Byte.class)) {
			return true;
		}
		if (b.equals(byte.class) && a.equals(Byte.class)) {
			return true;
		}
		// short
		if (a.equals(short.class) && b.equals(Short.class)) {
			return true;
		}
		if (b.equals(short.class) && a.equals(Short.class)) {
			return true;
		}
		// int
		if (a.equals(int.class) && b.equals(Integer.class)) {
			return true;
		}
		if (b.equals(int.class) && a.equals(Integer.class)) {
			return true;
		}
		// long
		if (a.equals(long.class) && b.equals(Long.class)) {
			return true;
		}
		if (b.equals(long.class) && a.equals(Long.class)) {
			return true;
		}
		// float
		if (a.equals(float.class) && b.equals(Float.class)) {
			return true;
		}
		if (b.equals(float.class) && a.equals(Float.class)) {
			return true;
		}
		// double
		if (a.equals(double.class) && b.equals(Double.class)) {
			return true;
		}
		if (b.equals(double.class) && a.equals(Double.class)) {
			return true;
		}
		// boolean
		if (a.equals(boolean.class) && b.equals(Boolean.class)) {
			return true;
		}
		if (b.equals(boolean.class) && a.equals(Boolean.class)) {
			return true;
		}
		// char
		if (a.equals(char.class) && b.equals(Character.class)) {
			return true;
		}
		if (b.equals(char.class) && a.equals(Character.class)) {
			return true;
		}
		// other, inheritance, etc
		return a.isAssignableFrom(b);
	}
}
