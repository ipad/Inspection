package com.inspetion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class LightAbsorptanceActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		// hide titlebar of application
		// must be before setting the layout
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		// hide statusbar of Android
		// could also be done later
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.light_absorptance_testing);
	}

	public void back(View v) {
		final Intent backIntent = new Intent(this,
				CategoryTestingActivity.class);
		startActivity(backIntent);
	}
}
