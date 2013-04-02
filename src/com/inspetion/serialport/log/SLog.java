package com.inspetion.serialport.log;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.TimeZone;

import android.os.Environment;
import android.util.Log;

public class SLog {
	
	public static String logPath="/sdcard/";

	public static void printToFile(String content){
		Log.i("serialport", "Enter printToFile");
		
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));  
        int year = cal.get(Calendar.YEAR);  
        int month = cal.get(Calendar.MONTH) + 1;  
        int day = cal.get(Calendar.DAY_OF_MONTH);  
        int hour = cal.get(Calendar.HOUR_OF_DAY);  
        int minute = cal.get(Calendar.MINUTE);  
        int second = cal.get(Calendar.SECOND);  
        int millisecond = cal.get(Calendar.MILLISECOND);  
  
        String timeString = String.format("%d-%d-%d %d:%d:%d.%d:", year, month,day, hour, minute, second, millisecond);    
        String fileName = String.format("SLog%d%02d%02d.%s", year, month, day, "log");  
  
        FileOutputStream fo = null;  
        try {  
            File file = new File(Environment.getExternalStorageDirectory(),fileName);  
            fo = new FileOutputStream(file, true);  
            fo.write(timeString.getBytes());  
            fo.write(content.getBytes()); 
            fo.write("\r\n".getBytes());
        } catch (Throwable tr) {  
            Log.e("SerialPort", tr.getMessage());
        } finally {  
            if (fo != null) {  
                try {  
                    fo.close();  
                } catch (Throwable tr) {  
                }  
            }  
        }  
	}
}
