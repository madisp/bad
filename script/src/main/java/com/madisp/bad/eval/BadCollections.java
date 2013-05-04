package com.madisp.bad.eval;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/23/13
 * Time: 10:19 PM
 */
@SuppressWarnings("unchecked")
public class BadCollections {

	private static final String[] COLLECTION_MUTATORS = {"add", "addAll", "clear", "remove", "removeAll"};
	private static final String[] LIST_MUTATORS = {"set"};

	private static Set<String> collectionMutators = new HashSet<String>();
	private static Set<String> listMutators = new HashSet<String>();

	static {
		for (String s : COLLECTION_MUTATORS) {
			collectionMutators.add(s);
			listMutators.add(s);
		}
		for (String s : LIST_MUTATORS) {
			listMutators.add(s);
		}
	}

	public static Object wrapCollection(final BadVar var, final Collection collection) {
		return Proxy.newProxyInstance(BadCollections.class.getClassLoader(), new Class[] {Collection.class}, new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Object ret = method.invoke(collection, args);
				if (collectionMutators.contains(method.getName())) {
					var.dispatchFire(false);
				}
				return ret;
			}
		});
	}

	public static Object wrapList(final BadVar var, final List list) {
		return Proxy.newProxyInstance(BadCollections.class.getClassLoader(), new Class[] {List.class}, new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Object ret = method.invoke(list, args);
				if (listMutators.contains(method.getName())) {
					var.dispatchFire(false);
				}
				return ret;
			}
		});
	}
}
