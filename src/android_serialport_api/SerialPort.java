/*
 * Copyright 2009 Cedric Priscal
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */

package android_serialport_api;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


import android.util.Log;
import android_serialport_api.log.SLog;

public class SerialPort {

	private static final String TAG = "SerialPort";

	/*
	 * Do not remove or rename the field mFd: it is used by native method close();
	 */
	private FileDescriptor mFd;
	private FileInputStream mFileInputStream;
	private FileOutputStream mFileOutputStream;
	
//	public  class ReadTimeOutThread extends Thread {
//		public long timeOut; 
//		public long iniTime;
//		public String response;
//		
//		public ReadTimeOutThread(long time){
//			timeOut = time;
//			iniTime = System.currentTimeMillis();
//		}
//		
//		@Override
//		public void run() {
//			super.run();
//			while(!isInterrupted() && ((System.currentTimeMillis() - iniTime)) < timeOut ) {
//				Log.i(TAG, "ReadTimeOutThread:"+Long.toString(System.currentTimeMillis() - iniTime));
//				Log.i(TAG, "isInterrupted:"+isInterrupted());
//				Log.i(TAG, "mFileInputStream == null?"+(mFileInputStream == null));
//				int size;
//				try {
//					byte[] buffer = new byte[64];
//					if (mFileInputStream == null) return;
//					size = mFileInputStream.read(buffer);
//					if (size > 0) {
//						response = new String(buffer, 0, size);
//						Log.i(TAG, "received:"+response);
//						SLog.printToFile("Received:"+response);
//						return;
//					}
//				} catch (IOException e) {
//					Log.i(TAG, "exception:"+e.getMessage());
//					e.printStackTrace();
//					return;
//				}
//			}
//		}
//		
//		public String getResponse(){
//			return response;
//		}
//	}

	public SerialPort(File device, int baudrate, int flags) throws SecurityException, IOException {

		/* Check access permission */
		if (!device.canRead() || !device.canWrite()) {
			try {
				/* Missing read/write permission, trying to chmod the file */
				Process su;
				su = Runtime.getRuntime().exec("/system/xbin/su");
				String cmd = "chmod 777 " + device.getAbsolutePath() + "\n"
						+ "exit\n";
				su.getOutputStream().write(cmd.getBytes());
				if ((su.waitFor() != 0) || !device.canRead()
						|| !device.canWrite()) {
					throw new SecurityException();
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new SecurityException();
			}
		}

		mFd = open(device.getAbsolutePath(), baudrate, flags);
		if (mFd == null) {
			Log.e(TAG, "native open returns null");
			SLog.printToFile("native open returns null");
			throw new IOException();
		}
		SLog.printToFile("open "+device.getAbsolutePath()+" successfully");
		mFileInputStream = new FileInputStream(mFd);
		mFileOutputStream = new FileOutputStream(mFd);
	}

	// Getters and setters
	public InputStream getInputStream() {
		return mFileInputStream;
	}

	public OutputStream getOutputStream() {
		return mFileOutputStream;
	}
	
//	public boolean send(String cmd){
//		try {
//			SLog.printToFile("Send:"+cmd);
//			mFileOutputStream.write(cmd.getBytes());
//			mFileOutputStream.write('\n');
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		return true;
//	}
	
//	public String receive(long time){
//		
//		ReadTimeOutThread readThread = new ReadTimeOutThread(time);
//		readThread.start();
//		try {
//			readThread.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		return readThread.getResponse();
//	}

	// JNI
	private native static FileDescriptor open(String path, int baudrate, int flags);
	public native void close();
	static {
		System.loadLibrary("serial_port");
	}
}
