package com.madisp.bad.lib;

import android.os.Handler;
import android.os.Looper;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/20/13
 * Time: 9:04 AM
 */
public class BadVar<T> {
	private T var;
	private Handler uiHandler;

	private Set<BadWatcher> watchers = new HashSet<BadWatcher>();

	public BadVar() {
		this.uiHandler = new Handler(Looper.getMainLooper());
	}

	public T get() {
		return var;
	}

	public void set(T value) {
		set(value, false);
	}

	public void set(T value, boolean selfChange) {
		if (value instanceof List) {
			value = (T)BadCollections.wrapList(this, (List)value);
		} else if (value instanceof Collection) {
			value = (T)BadCollections.wrapCollection(this, (Collection)value);
		}
		this.var = value;
		dispatchFire(selfChange);
	}

	public void dispatchFire(boolean selfChange) {
		for (BadWatcher w : watchers) {
			w.fire(BadVar.this, selfChange);
		}
	}

	public void addWatcher(BadWatcher<T> watcher) {
		watchers.add(watcher);
	}

	public void removeWatcher(BadWatcher<T> watcher) {
		watchers.remove(watcher);
	}

	public interface BadWatcher<T> {
		void fire(BadVar<T> var, boolean selfChange);
	}
}
