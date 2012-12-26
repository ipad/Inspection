package com.inspetion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DeviceIntroDetailActivity extends Activity {
	private Button returnBtn;
	private DeviceIntroDetailActivity currentObj = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.device_intro_detail_layout);
        
        returnBtn = (Button)findViewById(R.id.returnBtn1);
        returnBtn.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View v) {
				final Intent intent = new Intent(currentObj,MainActivity.class);
				startActivity(intent);
			}
        	
        });
    }
}
