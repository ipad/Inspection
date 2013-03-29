package com.inspetion.broadcast;

import com.inspetion.IntroduceActivity;
import com.inspetion.MainActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class StartupReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
         Intent activityIntent = new Intent(context,IntroduceActivity.class);
         activityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
         context.startActivity(activityIntent);
	}

}
