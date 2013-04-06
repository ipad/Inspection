package com.inspetion;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
*
* @author ihzj 样本监测 Activity
*
*/
public class SpecimenDetectActivity extends Activity {

	private Button updateItemBtn;
	private TextView itemNameTV;
	private Button backBtn;
	private Button blankBtn;
	private Button specimenBtn;
	private Button deleteBtn;
	
	private LinearLayout linearLayout2; 
	private LinearLayout linearLayout3; 
	private LinearLayout linearLayout4; 
	private LinearLayout linearLayout5; 
	private LinearLayout linearLayout6; 
	private LinearLayout linearLayout7; 
	private LinearLayout linearLayout8; 
	
	private SpecimenDetectActivity currentObj = this;
	
	public static final String TAG = "SpecimenDetectActivity";
	
	public static Drawable DEFAULT_COLOR;
	
	public static int indexOfspecimen = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.specimen);
        
        updateItemBtn =  (Button)findViewById(R.id.update_item_button);
        itemNameTV    =  (TextView)findViewById(R.id.item_name);
        backBtn =  (Button)findViewById(R.id.back_button);
        blankBtn =  (Button)findViewById(R.id.blank_button);
        specimenBtn = (Button)findViewById(R.id.sepecimen_button);
        deleteBtn = (Button)findViewById(R.id.delete_button);
        DEFAULT_COLOR = backBtn.getBackground();
        
        initFistCol();
                
        whenClickUpdateItemBtn();
    }
    
    public void whenClickBackBtn(View v){
    	AlertDialog.Builder builder = new Builder(this);
    	builder.setMessage("确定要返回主程序界面吗?");
    	builder.setTitle("提示");
    	builder.setPositiveButton("确认", new OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int arg1) {
                 dialog.dismiss();
 				final Intent intent = new Intent(currentObj,MainActivity.class);
 				startActivity(intent);
			}
    		
    	});
    	builder.setNegativeButton("取消", new OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
    		
    	});
    	builder.create().show();
    }
    
    public void whenClickClearBtn(View v){
    	AlertDialog.Builder builder = new Builder(this);
    	builder.setMessage("确定要清楚所有数据吗?");
    	builder.setTitle("提示");
    	builder.setPositiveButton("确认", new OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int arg1) {
                 clearData();	
                 dialog.dismiss();
			}
    		
    	});
    	builder.setNegativeButton("取消", new OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
    		
    	});
    	builder.create().show();
    }
    
	public void whenClickDeleteBtn(View v) {
		deleteBtn.setClickable(false);
		deleteBtn.setTextColor(Color.BLUE);		
		
		specimenBtn.setClickable(true);
		specimenBtn.setTextColor(Color.BLACK);
		
		blankBtn.setClickable(true);
		blankBtn.setTextColor(Color.BLACK);
		
		// add click listeners for all buttons
		LinearLayout parent = (LinearLayout)findViewById(R.id.specimen_table);
		LinearLayout child = null;
		Button btn = null;
		for ( int i=1;i<parent.getChildCount();i++){
			child = (LinearLayout)parent.getChildAt(i);
			for ( int j=1;j<child.getChildCount();j++ ){
				btn = (Button)child.getChildAt(j);
				btn.setOnClickListener(new ClickDeleteButtonListener());
			}
		}
	}

	public void whenClickBlankBtn(View v) {
		blankBtn.setClickable(false);
        blankBtn.setTextColor(Color.BLUE);		
        clearData();
		specimenBtn.setClickable(true);
		specimenBtn.setTextColor(Color.BLACK);
		
		deleteBtn.setClickable(true);
		deleteBtn.setTextColor(Color.BLACK);	
		// add click listeners for all buttons
		LinearLayout parent = (LinearLayout)findViewById(R.id.specimen_table);
		LinearLayout child = null;
		Button btn = null;
		for ( int i=1;i<parent.getChildCount();i++){
			child = (LinearLayout)parent.getChildAt(i);
			for ( int j=1;j<child.getChildCount();j++ ){
				btn = (Button)child.getChildAt(j);
				btn.setOnClickListener(new ClickButtonListener());
			}
		}
	}

	public void whenClickSpicemenBtn(View v) {
		specimenBtn.setClickable(false);
		specimenBtn.setTextColor(Color.BLUE);
		
		blankBtn.setClickable(true);
        blankBtn.setTextColor(Color.BLACK);	
        
		deleteBtn.setClickable(true);
		deleteBtn.setTextColor(Color.BLACK);	
		
		indexOfspecimen=1;
		clearData();
		
		// add click listeners for all buttons
		LinearLayout parent = (LinearLayout)findViewById(R.id.specimen_table);
		LinearLayout child = null;
		Button btn = null;
		for ( int i=1;i<parent.getChildCount();i++){
			child = (LinearLayout)parent.getChildAt(i);
			for ( int j=1;j<child.getChildCount();j++ ){
				btn = (Button)child.getChildAt(j);
				btn.setOnClickListener(new ClickSpecimenButtonListener());
			}
		}
	}
	
	private void initFistCol() {
		linearLayout2 = (LinearLayout)findViewById(R.id.tableRow2);
		TextView text2= (TextView)linearLayout2.getChildAt(0);
		text2.setText(R.string.kb_char_B);
		
		linearLayout3 = (LinearLayout)findViewById(R.id.tableRow3);
		TextView text3= (TextView)linearLayout3.getChildAt(0);
		text3.setText(R.string.kb_char_C);
		
		linearLayout4 = (LinearLayout)findViewById(R.id.tableRow4);
		TextView text4= (TextView)linearLayout4.getChildAt(0);
		text4.setText(R.string.kb_char_D);
		
		linearLayout5 = (LinearLayout)findViewById(R.id.tableRow5);
		TextView text5= (TextView)linearLayout5.getChildAt(0);
		text5.setText(R.string.kb_char_E);
		
		linearLayout6 = (LinearLayout)findViewById(R.id.tableRow6);
		TextView text6= (TextView)linearLayout6.getChildAt(0);
		text6.setText(R.string.kb_char_F);
		
		linearLayout7 = (LinearLayout)findViewById(R.id.tableRow7);
		TextView text7= (TextView)linearLayout7.getChildAt(0);
		text7.setText(R.string.kb_char_G);
		
		linearLayout8 = (LinearLayout)findViewById(R.id.tableRow8);
		TextView text8= (TextView)linearLayout8.getChildAt(0);
		text8.setText(R.string.kb_char_H);
	}

	private void whenClickUpdateItemBtn() {
		updateItemBtn.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View v) {
				showDialog(0);
			}
			
		});
	}
	
    @Override
    protected Dialog onCreateDialog(int id) {
        Dialog dialog=null;
        switch (id) {
        case 0:
            Builder builder=new android.app.AlertDialog.Builder(this);
            //设置对话框的图标
            builder.setIcon(R.drawable.ic_launcher);
            //设置对话框的标题
            builder.setTitle("更新项目");
            //0: 默认第一个单选按钮被选中
            builder.setSingleChoiceItems(R.array.items, 0, new OnClickListener(){
                public void onClick(DialogInterface dialog, int which) {
                    String item=getResources().getStringArray(R.array.items)[which];
                    itemNameTV.setText(item);
                }
            });            
            //添加一个确定按钮
            builder.setPositiveButton(" 确 定 ", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which) {
                    
                }
            });
            //创建一个单选按钮对话框
            dialog=builder.create();
            break;
        }
        return dialog;
    }
    
    private class ClickButtonListener implements Button.OnClickListener{

		@Override
		public void onClick(View v) {
			Button btn = (Button)v;
			if ( btn.getText()!=null && btn.getText().equals("B") ){
				btn.setText("");
			}
			else{
				btn.setText("B");
			}
		}
    	
    }

    private class ClickSpecimenButtonListener implements Button.OnClickListener{

		@Override
		public void onClick(View v) {
			Button btn = (Button)v;
				btn.setText(""+(indexOfspecimen++));
		}
    	
    }
    
    private class ClickDeleteButtonListener implements Button.OnClickListener{

		@Override
		public void onClick(View v) {
			Button btn = (Button)v;
				btn.setText("");
		}
    	
    }
    

    public void clearData(){
		LinearLayout parent = (LinearLayout)findViewById(R.id.specimen_table);
		LinearLayout child = null;
		Button btn = null;
		for ( int i=1;i<parent.getChildCount();i++){
			child = (LinearLayout)parent.getChildAt(i);
			for ( int j=1;j<child.getChildCount();j++ ){
				btn = (Button)child.getChildAt(j);
				btn.setText("");
			}
		}
    }
}