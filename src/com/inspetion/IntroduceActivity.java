package com.inspetion;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class IntroduceActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce);
        
        final Intent intent = new Intent(this,KaiJiZiJianActivity.class);
        
        Timer timer = new Timer();
        TimerTask task = new TimerTask(){
			@Override
			public void run() {
				startActivity(intent);
				//test commit.
			}
    };
    timer.schedule(task, 3000);
    } 
}
