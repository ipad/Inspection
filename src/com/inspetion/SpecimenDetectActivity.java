package com.inspetion;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TableLayout;

/**
 * 
 * @author ihzj 样本监测 Activity
 * 
 */
public class SpecimenDetectActivity extends Activity {

	private TableLayout specimenTable;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.specimen);
		this.specimenTable = (TableLayout) findViewById(R.id.specimen_table);
	}

}
