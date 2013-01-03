package com.inspetion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StandardTestingActivity extends SpecimenDetectActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	public void back(View v) {
		
		final Intent backIntent = new Intent(this,CategoryTestingActivity.class);
		startActivity(backIntent);
	}
}
