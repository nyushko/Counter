package com.example.counter;

import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddCounterActivity extends Activity {

	public String counter_name;
	public EditText add_counter_name;
	public String hello;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_counter);
		//counter_name = add_counter_name.getText().toString();
		add_counter_name = (EditText) findViewById(R.id.add_counter_name);
		Button add_counter_button = (Button) findViewById(R.id.add_counter_button);
		add_counter_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Intent reset_counter_intent = new Intent(MainActivity.this, Reset_counter.class);
				counter_name = add_counter_name.getText().toString();
				Date counter_date = new Date(System.currentTimeMillis());
				Save_data add_data = new Save_data();
				add_data.saveInFile(counter_name, counter_date, getApplicationContext());
				add_data.saveResultsFile(counter_name, counter_date, getApplicationContext());
				Log.d("count_buton", "Clicked");
				if (counter_name != null){
					Log.d("count_buton is", counter_name);
				}
				//for (String i: add_data.loadFromFile(getApplicationContext())) {
					//Log.d("loadFromFile", i.toString());
				//startActivity(reset_counter_intent);
				finish();
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_counter, menu);
		return true;
	}

}
