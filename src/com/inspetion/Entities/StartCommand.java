package com.inspetion.Entities;

import android.app.Activity;

public class StartCommand extends Command {
	
	public StartCommand(Activity activity){
	}
	
	public StartCommand(){		
	}


	@Override
	public void calulateCheckSum() {
		int sum1,sum2,sum3,sum4,sum5,sum6;
		
		sum1 = Integer.parseInt(id);
		sum2 = Integer.parseInt(length);
		sum3 = Integer.parseInt(data.split(" ")[0]);
		sum4 = Integer.parseInt(data.split(" ")[1]);
		sum5 = Integer.parseInt(data.split(" ")[2]);
		sum6 = Integer.parseInt(data.split(" ")[3]);
		
		String hex = Integer.toHexString(sum1+sum2+sum3+sum4+sum5+sum6);
	    if (hex.length() == 1) {
		        hex = "0" + hex;
		}
	    
	    checkSum =hex;
	}
}
