package com.example.counter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ResultsActivity extends Activity {

	HashMap<String, Integer> month_map = new HashMap<String, Integer>();
	HashMap<String, Integer> year_map = new HashMap<String, Integer>();
	HashMap<String, Integer> hour_map = new HashMap<String, Integer>();
	HashMap<String, Integer> day_map = new HashMap<String, Integer>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_results_table);
		Intent intent = getIntent();
		String counter_name = (intent.getStringExtra("counter_name")).replaceAll(" ", "");
		TextView main_counter_name = (TextView) findViewById(R.id.counter_name);
		main_counter_name.setText(counter_name);
		Save_data counter_data = new Save_data();
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(counter_data
				.loadResultsFile(getApplicationContext())));
		Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
		Log.d("Counter Name", counter_name);
		for (String entry : list){
			String[] search_term = entry.split("\\|+");
			if((search_term[0].replace(" ", "")).equals(counter_name)){
				Log.d("Entry", entry);
				try {
					SimpleDateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
					Date date =  df.parse(search_term[1].trim());
					//SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy");
			        //Date resultdate = new Date(date.getTime());
					Log.d("Date", new SimpleDateFormat("MMM dd yyyy").format(date));
					if(!Integer.toString(date.getMonth()).isEmpty()){
						String month = new SimpleDateFormat("MMM").format(date);
						if(month_map.containsKey(month)){
							int count_now = month_map.get(month) + 1;
							month_map.put(month, count_now);
						}else{
							month_map.put(month, 1);
						}
					}
					
					if(!Integer.toString(date.getYear()).isEmpty()){
						String year = new SimpleDateFormat("yyyy").format(date);
						if(year_map.containsKey(year)){
							int count_now = year_map.get(year) + 1;
							year_map.put(year, count_now);
						}else{
							year_map.put(year, 1);
						}
					}
					
					if(!Integer.toString(date.getHours()).isEmpty()){
						String hour = new SimpleDateFormat("hh a").format(date);
						if(hour_map.containsKey(hour)){
							int count_now = hour_map.get(hour) + 1;
							hour_map.put(hour, count_now);
						}else{
							hour_map.put(hour, 1);
						}
					}
					
					if(!Long.toString(date.getTime()).isEmpty()){
						String day = new SimpleDateFormat("MMM dd yyyy").format(date);
						if(day_map.containsKey(day)){
							int count_now = day_map.get(day) + 1;
							day_map.put(day, count_now);
						}else{
							day_map.put(day, 1);
						}
					}
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		System.out.println("Month: "+ month_map);
		System.out.println("Year: "+ year_map);
		System.out.println("Hour: "+ hour_map);
		System.out.println("Day: "+ day_map);
		LinearLayout month_layout = (LinearLayout) findViewById(R.id.month_layout);
		LinearLayout day_layout = (LinearLayout) findViewById(R.id.day_layout);
		LinearLayout year_layout = (LinearLayout) findViewById(R.id.year_layout);
		LinearLayout hour_layout = (LinearLayout) findViewById(R.id.hour_layout);
		for (String entry : month_map.keySet()){
			TextView month = new TextView(this);
			month.setGravity(Gravity.CENTER);
			month.setTypeface(null, Typeface.ITALIC);
			month.setText(entry + "<--------->" + month_map.get(entry));
			month_layout.addView(month);
		}
		for (String entry : day_map.keySet()){
			TextView day = new TextView(this);
			day.setGravity(Gravity.CENTER);
			day.setTypeface(null, Typeface.ITALIC);
			day.setText(entry + "<--------->" + day_map.get(entry));
			day_layout.addView(day);
		}
		for (String entry : year_map.keySet()){
			TextView year = new TextView(this);
			year.setGravity(Gravity.CENTER);
			year.setTypeface(null, Typeface.ITALIC);
			year.setText(entry + "<--------->" + year_map.get(entry));
			year_layout.addView(year);
		}
		for (String entry : hour_map.keySet()){
			TextView hour = new TextView(this);
			hour.setGravity(Gravity.CENTER);
			hour.setTypeface(null, Typeface.ITALIC);
			hour.setText(entry + "<--------->" + hour_map.get(entry));
			hour_layout.addView(hour);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.results, menu);
		return true;
	}

}
