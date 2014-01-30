package com.example.counter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class All_counters extends Activity {

	Button new_button;
	int current_count;
	TextView new_text;
	Save_data add_data;
	ArrayList<String> counterList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_all_counters);
		add_data = new Save_data();
		LinearLayout all_counters_view = (LinearLayout) findViewById(R.id.all_counters_view);
		int i = 0;
		counterList = new ArrayList<String>(Arrays.asList(add_data
				.loadFromFile(getApplicationContext())));
		for (String entry : counterList) {
			// for (String j : i.split("\\W+")){
			// String j = (i.replaceAll("\\s","").split("\\|"))[1];
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			params.weight = 1.0f;
			LinearLayout single_counter_view = new LinearLayout(this);
			// single_counter_view.setId('fff');
			final String[] counter_name = (entry.split("\\|+"));
			//Log.d(counter_name[1], counter_name[2]);
			//Log.d(counter_name[1] + counter_name[0], counter_name[2].replace("\\W+", ""));
			current_count = Integer.parseInt(counter_name[2].replace(" ", ""));
			new_button = new Button(this);
			new_button.setLayoutParams(params);
			new_button.setId(current_count);
			new_button.setText(counter_name[1]);
			new_button.setTag(counter_name[0]);
			// new_button.setTag(current_count);
			// new_button.setId(i);
			new_text = new TextView(this);
			new_text.setId(i);
			new_text.setText(Integer.toString(current_count));
			single_counter_view.addView(new_button);
			single_counter_view.addView(new_text);
			all_counters_view.addView(single_counter_view);
			i= i +1;
			new_button.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					LinearLayout current_button = (LinearLayout) v.getParent();
					Button counter_button = (Button) v;
					new_text = (TextView) current_button.getChildAt(1);
					current_count = Integer.parseInt(new_text.getText()
							.toString()) + 1;
					new_text.setText(Integer.toString(current_count));
					counter_button.setId(current_count);
					Log.d("ID", new_text.getText().toString());
					counterList.set(new_text.getId(), counter_button.getText().toString()
									+ " | " + counter_button.getText().toString()
									+ " | " + Integer.toString(counter_button.getId()));
					getApplicationContext().deleteFile("nadineisawesome.sav");
					add_data.saveResultsFile(counter_button.getText().toString(), 
							new Date(System.currentTimeMillis()), getApplicationContext());
					for (String counter : counterList) {
						add_data.saveInFile(counter, getApplicationContext());
					}
				}
			});
			// }
			// Button new_button = new Button(getApplicationContext());
			// new_button.setText((i.split("|"))[1]);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.all_counters, menu);
		return true;
	}

}
