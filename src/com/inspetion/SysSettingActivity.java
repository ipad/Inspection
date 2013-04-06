package com.inspetion;

import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class SysSettingActivity extends Activity {
	private DatePicker datePicker;
	private TimePicker timePicker;
	private RadioGroup bubanRG;
	private RadioGroup jinbanRG;
	private RadioButton landscapeRB;
	private RadioButton vertcapeRB;
	private RadioButton lxRB;
	private RadioButton bjRB;
	private Spinner zbSpeedSpinner;
	private Spinner zbTimeSpinner;
	private Button returnBtn;
	private SysSettingActivity currentObj = this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sys_setting_layout);
		
		datePicker = (DatePicker)findViewById(R.id.dp1);
		timePicker = (TimePicker)findViewById(R.id.tp1);
		bubanRG    = (RadioGroup)findViewById(R.id.buban);
		jinbanRG    = (RadioGroup)findViewById(R.id.jinban);
		landscapeRB = (RadioButton)findViewById(R.id.landscape);
		vertcapeRB = (RadioButton)findViewById(R.id.vert);
		lxRB = (RadioButton)findViewById(R.id.lx);
		bjRB = (RadioButton)findViewById(R.id.bj);
		zbSpeedSpinner = (Spinner)findViewById(R.id.znSpeed);
		zbTimeSpinner = (Spinner)findViewById(R.id.znTime);
		returnBtn = (Button)findViewById(R.id.sysSettingReturnBtn);
		
		whenDateChanged();
		whenTimeChanged();
		whenBubanGroupChanged();
		whenJinbanGroupChanged();
		whenZbSpeedSpinnerChanged();
		whenZbTimeSpinnerChanged();
		
		whenRetunClicked();
	}
	
	private void whenRetunClicked() {
        returnBtn.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View v) {
				//save data
            	save("sys_setting","year",datePicker.getYear());
            	save("sys_setting","month",(datePicker.getMonth()+1));
            	save("sys_setting","day",datePicker.getDayOfMonth());
            	
            	save("sys_setting","hour",timePicker.getCurrentHour());
            	save("sys_setting","min",timePicker.getCurrentMinute());
            	
            	if (bubanRG.getCheckedRadioButtonId() == landscapeRB.getId())
            	   save("sys_setting","buban",1);
            	else if (bubanRG.getCheckedRadioButtonId() == vertcapeRB.getId())
            	   save("sys_setting","buban",2);
            	
            	if (jinbanRG.getCheckedRadioButtonId() == lxRB.getId())
             	   save("sys_setting","jinban",1);
             	else if (bubanRG.getCheckedRadioButtonId() == vertcapeRB.getId())
             	   save("sys_setting","jinban",2);
            	
            	save("sys_setting","zb_speed",zbSpeedSpinner.getSelectedItemPosition()+1);
            	save("sys_setting","zb_time",zbTimeSpinner.getSelectedItemPosition()+1);
				
				final Intent intent = new Intent(currentObj,MainActivity.class);
				startActivity(intent);
			}
        	
        });		
	}

	private void whenZbTimeSpinnerChanged() {
		zbTimeSpinner.setOnItemSelectedListener(new ZbTimeListener());
	}

	private void whenZbSpeedSpinnerChanged() {
		zbSpeedSpinner.setOnItemSelectedListener(new ZbSpeedListener());
	}

	private void whenJinbanGroupChanged() {
		jinbanRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { 
            @Override 
            public void onCheckedChanged(RadioGroup group, int checkedId) { 
                if(checkedId==lxRB.getId()){ 
                	save("sys_setting","jinban",1);
                }else if(checkedId==bjRB.getId()){ 
                	save("sys_setting","jinban",2);
                } 
            } 
        }); 	
		
	}

	private void whenBubanGroupChanged() {
		bubanRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { 
	            @Override 
	            public void onCheckedChanged(RadioGroup group, int checkedId) { 
	                if(checkedId==landscapeRB.getId()){ 
	                	save("sys_setting","buban",1);
	                }else if(checkedId==vertcapeRB.getId()){ 
	                	save("sys_setting","buban",2);
	                } 
	            } 
	        }); 		
	}

	private void whenTimeChanged() {
        timePicker.setOnTimeChangedListener(new OnTimeChangedListener(){
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                timePicker.setOnTimeChangedListener(new OnTimeChangedListener(){
                    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                    	save("sys_setting","hour",hourOfDay);
                    	save("sys_setting","min",minute);
                    }
                    
                });
            }
            
        }); 		
	}

	private void whenDateChanged(){
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int monthOfYear=calendar.get(Calendar.MONTH);
        int dayOfMonth=calendar.get(Calendar.DAY_OF_MONTH);
        
        datePicker.init(year, monthOfYear, dayOfMonth, new OnDateChangedListener(){
            public void onDateChanged(DatePicker view, int year,int monthOfYear, int dayOfMonth) {
            	save("sys_setting","year",year);
            	save("sys_setting","month",(monthOfYear+1));
            	save("sys_setting","day",dayOfMonth);
            }            
        });
	}
	
	public void save(String prefName,String key,int value){
        SharedPreferences userInfo = getSharedPreferences(prefName, 0);  
        userInfo.edit().putInt(key,value ).commit(); 
	}
	
	
	private class ZbSpeedListener implements OnItemSelectedListener{

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
			save("sys_setting","zb_speed",(arg2+1));		
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			
		}
		
	}
	
	
	private class ZbTimeListener implements OnItemSelectedListener{

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
			save("sys_setting","zb_time",(arg2+1));		
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			
		}
		
	}

}
