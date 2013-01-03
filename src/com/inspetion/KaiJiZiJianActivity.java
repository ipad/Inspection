package com.inspetion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.widget.ProgressBar;

public class KaiJiZiJianActivity extends Activity {
    private int mProgressStatus = 0;
    private Handler mHandler = new Handler();

	@Override
	 protected void onCreate(Bundle savedInstanceState) {
	   super.onCreate(savedInstanceState);	  
	   requestWindowFeature(Window.FEATURE_PROGRESS);
	   setContentView(R.layout.activity_kaijizijian);
	   setProgressBarVisibility(true);
	   final ProgressBar progressHorizontal = (ProgressBar) findViewById(R.id.progress_horizontal);
	   final Intent intent = new Intent(this,MainActivity.class);
	   
	// Start lengthy operation in a background thread
	   
	   //will be back(open notation.)
	   startActivity(intent);
	   /*
       new Thread(new Runnable() {
           public void run() {
               while (mProgressStatus < 100) {
                   // Update the progress bar
                   mHandler.post(new Runnable() {
                       public void run() {
                    	   progressHorizontal.setProgress(mProgressStatus);
                       }
                   });
                   doWork();
               }
               
               startActivity(intent);
               }

       }).start();
	 }
	
	private void doWork() {
		try {
			Thread.sleep(1000);
			mProgressStatus+= 20;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		*/
	}
	
}
