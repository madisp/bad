package com.madisp.bad;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.madisp.bad.eval.BadVar;
import com.madisp.bad.eval.Scope;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 5/17/13
 * Time: 10:55 PM
 */
public class Freezer {
	private SharedPreferences prefs;

	public Freezer(Context context) {
		prefs = context.getSharedPreferences("bad_freezer", Context.MODE_PRIVATE);
	}

	private List<FrozenStringWatcher> watchers = new LinkedList<FrozenStringWatcher>();

	@SuppressWarnings("unchecked")
	public void start(Scope scope) {
		for (Field f : scope.getBase().getClass().getFields()) {
			if (f.getType().equals(BadVar.class) && f.isAnnotationPresent(Persist.class)) {
				for (Annotation a : f.getAnnotations()) {
					if (a instanceof Persist) {
						String key = ((Persist)a).key();
						if (TextUtils.isEmpty(key)) {
							key = f.getName();
							//TODO warn that we are defaulting to field name
						}
						final String fkey = key;
						try {
							BadVar bv = (BadVar) f.get(scope.getBase());
							bv.set(prefs.getString(key, ""));
							prefs.registerOnSharedPreferenceChangeListener(new FrozenStringWatcher(bv, key));
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						}
						break;
					}
				}
			}
		}
	}

	public void stop() {
		for (FrozenStringWatcher w : watchers) {
			prefs.unregisterOnSharedPreferenceChangeListener(w);
		}
	}

	private boolean isPersistable(Type type) {
		return (type.equals(Integer.class)) || (type.equals(Boolean.class)) || (type.equals(String.class));
	}

	public class FrozenStringWatcher implements SharedPreferences.OnSharedPreferenceChangeListener, BadVar.BadWatcher<String> {
		private final BadVar<String> var;
		private final String key;

		public FrozenStringWatcher(BadVar<String> bv, String key) {
			this.key = key;
			this.var = bv;
			bv.addWatcher(this);
		}

		@Override
		public void fire(BadVar<String> var) {
			prefs.edit().putString(key, (String)var.get()).apply();
		}

		@Override
		public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
			var.set(prefs.getString(key, ""), this);
		}
	}
}
