package com.example.counter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class ResultsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_results_table);
		Intent intent = getIntent();
		String counter_name = (intent.getStringExtra("counter_name")).replaceAll(" ", "");
		Save_data counter_data = new Save_data();
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(counter_data
				.loadResultsFile(getApplicationContext())));
		Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
		Log.d("Counter Name", list.toString());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.results, menu);
		return true;
	}

}
