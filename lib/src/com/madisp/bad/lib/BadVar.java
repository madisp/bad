package com.madisp.bad.lib;

import android.os.Handler;
import android.os.Looper;

import java.util.HashSet;
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
		this.var = value;
		final BadVar me = this;
		uiHandler.post(new Runnable() {
			@Override
			public void run() {
				for (BadWatcher w : watchers) {
					w.fire(me);
				}
			}
		});
	}

	public void addWatcher(BadWatcher<T> watcher) {
		watchers.add(watcher);
	}

	public void removeWatcher(BadWatcher<T> watcher) {
		watchers.remove(watcher);
	}

	public interface BadWatcher<T> {
		void fire(BadVar<T> var);
	}
}
