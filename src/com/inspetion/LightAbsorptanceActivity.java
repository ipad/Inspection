package com.inspetion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LightAbsorptanceActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.light_absorptance_testing);
	}
	
	
	public void back(View v) {
		final Intent backIntent = new Intent(this,CategoryTestingActivity.class);
		startActivity(backIntent);
	}
}
