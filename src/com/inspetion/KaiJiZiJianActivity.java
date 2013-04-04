package com.inspetion;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.widget.ProgressBar;
import android_serialport_api.log.SLog;
import android_serialport_api.sample.SerialPortActivity;

public class KaiJiZiJianActivity extends SerialPortActivity {
	private boolean sucess;
    private int mProgressStatus = 0;
    private Handler mHandler = new Handler();
    public Intent intent;

	@Override
	 protected void onCreate(Bundle savedInstanceState) {
	   super.onCreate(savedInstanceState);	  
	   requestWindowFeature(Window.FEATURE_PROGRESS);
	   setContentView(R.layout.activity_kaijizijian);
	   setProgressBarVisibility(true);
	   final ProgressBar progressHorizontal = (ProgressBar) findViewById(R.id.progress_horizontal);	  
	   progressHorizontal.setProgress(0);
	  
	   
	   // Start lengthy operation in a background thread
	   
	   //will be back(open notation.)
	   //send cmd
	   send("7E 01 00 00 01 7E");  
	   receive();	     
	   
       Thread progressThread = new Thread(new Runnable() {
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
               
        	   if (sucess){
        		     SLog.printToFile("kaijizijian successfully");
        		     intent = new Intent(KaiJiZiJianActivity.this,MainActivity.class);
        		     startActivity(intent);
        	   }
        	   else{
        		     SLog.printToFile("kaijizijian failed");
        		     intent = new Intent(KaiJiZiJianActivity.this,KaiJiZiJianErrorActivity.class);
        		     startActivity(intent);		   
        	   }
               
               }

       });
       progressThread.start();
    
       
       

	 }
	
	private void doWork() {

	       try {
	   		Thread.sleep(1000);
	   	} catch (InterruptedException e) {
	   		e.printStackTrace();
	   	}
			mProgressStatus+= 10;
		
	}
	
	@Override
	protected void onDataReceived(byte[] buffer, int size) {
		String response;
		
		response = new String(buffer, 0, size);
		
		if (response == null || !response.contains("7E 02 01 01 01 7E")){
			//KaiJiZiJian Ê§°Ü
			sucess = false;
		}
		else{
			sucess = true;
		}
	}
	
}
