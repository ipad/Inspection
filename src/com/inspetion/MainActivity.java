package com.inspetion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends Activity {
    private ImageButton introImageBtn;
    private ImageButton sepecimenImageBtn;
    private ImageButton preferImageBtn;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent deviceIntroIntent = new Intent(this,DeviceIntroDetailActivity.class);
        introImageBtn = (ImageButton)findViewById(R.id.intro_btn);
        introImageBtn.setOnClickListener(new ImageButton.OnClickListener(){
			@Override
			public void onClick(View view) {
				startActivity(deviceIntroIntent);				
			}
        	
        });
        
		{//this Intent is use to launch specimen Activity.
			final Intent specimenDetectIntent = new Intent(this,
					SpecimenDetectActivity.class);
			sepecimenImageBtn = (ImageButton)findViewById(R.id.demo_test_btn);
			sepecimenImageBtn.setOnClickListener(new ImageButton.OnClickListener(){

				@Override
				public void onClick(View v) {
					startActivity(specimenDetectIntent);
				}
			
			});
		}
		{//Launch Preferences activity
			final Intent preferencesIntent = new Intent(this,CategoryTestingActivity.class);
			preferImageBtn = (ImageButton)findViewById(R.id.parasetting_btn);
			preferImageBtn.setOnClickListener(new ImageButton.OnClickListener(){

				@Override
				public void onClick(View v) {
					startActivity(preferencesIntent);
				}
				
			});
		}
    }
    
}
