package com.example.counter;

import android.app.Activity;
import java.io.BufferedReader;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	protected static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldCounters;

	/** Called when the activity is first created. */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//getApplicationContext().deleteFile("nadineisawesome.sav");
		/** When click on COUNTER  button, go into the counter activity*/
		Button increment_counter = (Button) findViewById(R.id.increment_counter);
		increment_counter.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent increment_counter_intent = new Intent(MainActivity.this, All_counters.class);
				startActivity(increment_counter_intent);
			}
		});
		
		/** When click on ADD_COUNTER button, go into add_counter activity*/
		Button add_counter = (Button) findViewById(R.id.add_counter);
		add_counter.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent add_counter_intent = new Intent(MainActivity.this, AddCounterActivity.class);
				startActivity(add_counter_intent);
			}
		});
		
		/** When click on REMOVE_COUNTER button, go into remove_counter activity*/
		Button remove_counter = (Button) findViewById(R.id.remove_counter);
		remove_counter.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent remove_counter_intent = new Intent(MainActivity.this, Remove_counter.class);
				startActivity(remove_counter_intent);
			}
		});
		
		/** When click on EDIT_COUNTER button, go into edit_counter activity*/
		Button edit_counter = (Button) findViewById(R.id.edit_counter);
		edit_counter.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent edit_counter_intent = new Intent(MainActivity.this, Edit_counter.class);
				startActivity(edit_counter_intent);
			}
		});
		
		/** When click on RESET_COUNTER button, go into reset_counter activity*/
		Button reset_counter = (Button) findViewById(R.id.reset_counter);
		reset_counter.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent reset_counter_intent = new Intent(MainActivity.this, Reset_counter.class);
				startActivity(reset_counter_intent);
			}
		});
		
		/** When click on RESULTS button, go into results activity*/
		Button results = (Button) findViewById(R.id.results);
		results.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent results_intent = new Intent(MainActivity.this, Results.class);
				startActivity(results_intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
