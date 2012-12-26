package com.inspetion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends Activity {
    private ImageButton introImageBtn;
	
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
    }
    
}
