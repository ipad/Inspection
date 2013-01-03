package com.inspetion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CategoryTestingActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.category_menu);
	}

	public void startAbsorptanceTesting(View v) {

		final Intent lightIntent = new Intent(this,
				LightAbsorptanceActivity.class);
		startActivity(lightIntent);
	}

	public void startStandardTesting(View v) {

		final Intent standardIntent = new Intent(this,
				StandardTestingActivity.class);
		startActivity(standardIntent);
	}
}
