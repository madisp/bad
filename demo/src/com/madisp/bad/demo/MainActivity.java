package com.madisp.bad.demo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created with IntelliJ IDEA.
 * User: madis
 * Date: 3/20/13
 * Time: 8:44 AM
 */
public class MainActivity extends FragmentActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		View v = new FrameLayout(this);
		v.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
		v.setId(R.id.mainContainer);
		setContentView(v);


		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.add(R.id.mainContainer, new ListFragment());
		ft.commit();
	}
}
