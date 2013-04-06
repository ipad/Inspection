package com.inspetion;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListView;

public class ReportActivity extends Activity {

	final static String Tag = "ReportActivity";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		super.onCreate(savedInstanceState);

		setContentView(R.layout.report);

		HorizontalScrollView body = (HorizontalScrollView) findViewById(R.id.report_body);
		ListView reportList = (ListView) body.findViewById(R.id.report_list);

		LinearLayout bodyHeaderLayout = (LinearLayout)body.findViewById(R.id.report_body_head);
		
		Log.e(Tag, "----");
	}
}
