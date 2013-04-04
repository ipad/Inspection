package com.inspetion.util;

public class Tools {
	
	public static void sleep(long time){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
