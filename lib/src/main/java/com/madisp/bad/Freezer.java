package com.madisp.bad;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.madisp.bad.eval.BadVar;
import com.madisp.bad.eval.Scope;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
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
						Class type = (Class) ((ParameterizedType) f.getGenericType()).getActualTypeArguments()[0];
						if (!isPersistable(type)) {
							continue;
						}
						String key = ((Persist)a).key();
						if (TextUtils.isEmpty(key)) {
							key = f.getName();
							//TODO warn that we are defaulting to field name
						}
						final String fkey = key;
						try {
							BadVar bv = (BadVar) f.get(scope.getBase());
							bv.set(retrieve(prefs, key, type));
							prefs.registerOnSharedPreferenceChangeListener(new FrozenStringWatcher(bv, key, type));
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

	private boolean isPersistable(Class type) {
		return (type.equals(Integer.class)) || (type.equals(Boolean.class)) || (type.equals(String.class));
	}

	public class FrozenStringWatcher implements SharedPreferences.OnSharedPreferenceChangeListener, BadVar.BadWatcher<String> {
		private final BadVar var;
		private final String key;
		private final Class type;

		public FrozenStringWatcher(BadVar<String> bv, String key, Class type) {
			this.key = key;
			this.var = bv;
			this.type = type;
			bv.addWatcher(this);
		}

		@Override
		public void fire(BadVar<String> var) {
			store(prefs, key, var.get());
		}

		@Override
		public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
			if (this.key.equals(key)) {
				var.set(retrieve(sharedPreferences, key, type), this);
			}
		}
	}

	private static void store(SharedPreferences prefs, String key, Object value) {
		SharedPreferences.Editor editor = prefs.edit();
		if (value == null) {
			editor.remove(key);
		} else if (value instanceof String) {
			editor.putString(key, (String)value);
		} else if (value instanceof Integer) {
			editor.putInt(key, (Integer) value);
		} else if (value instanceof Boolean) {
			editor.putBoolean(key, (Boolean) value);
		}
		editor.apply();
	}

	private static Object retrieve(SharedPreferences prefs, String key, Class type) {
		if (type.equals(String.class)) {
			return prefs.getString(key, "");
		} else if (type.equals(Integer.class)) {
			return prefs.getInt(key, 0);
		} else if (type.equals(Boolean.class)) {
			return prefs.getBoolean(key, false);
		}
		return null;
	}
}
