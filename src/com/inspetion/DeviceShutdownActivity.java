package com.inspetion;

import android.app.Activity;
import android.os.Bundle;

public class DeviceShutdownActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
//		try {
//			/* Missing read/write permission, trying to chmod the file */
//			Process su;
//			su = Runtime.getRuntime().exec("/system/xbin/su");
//			String cmd = "chmod 777 " + device.getAbsolutePath() + "\n"
//					+ "exit\n";
//			su.getOutputStream().write(cmd.getBytes());
//			if ((su.waitFor() != 0) || !device.canRead()
//					|| !device.canWrite()) {
//				throw new SecurityException();
//			}
//		} catch (Exception e) {
//			s
//			e.printStackTrace();
//			throw new SecurityException();
//		}
	}
	
}
