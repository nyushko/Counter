package com.example.counter;

import java.util.ArrayList;
import java.util.Arrays;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class Remove_counter extends Activity {

	LinearLayout counter_remove_view;
	int i;
	ArrayList<String> counterList;
	EditText remove_text;
	LinearLayout remove_counters_view;
	Save_data add_data;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_remove_counter);
		add_data = new Save_data();
		remove_counters_view = (LinearLayout) findViewById(R.id.remove_counters_view);
		i = 0;
		counterList = new ArrayList<String>(Arrays.asList(add_data
				.loadFromFile(getApplicationContext())));
		for (String entry : counterList) {
			final String[] counter_name = entry.split("\\|+");
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			LinearLayout single_counter_view = new LinearLayout(this);
			single_counter_view.setOrientation(LinearLayout.VERTICAL);
			single_counter_view.setId(Integer.parseInt(counter_name[2].replace(" ", "")));
			counter_remove_view = new LinearLayout(this);
			Button new_button = new Button(this);
			new_button.setId(i);
			new_button.setText(counter_name[1]);
			new_button.setTag(counter_name[0]);
			single_counter_view.addView(new_button);
			remove_counters_view.addView(single_counter_view);
			i = i + 1;
			new_button.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					LinearLayout current_layout = (LinearLayout) v.getParent();
					Button current_button = (Button) v; 
					counterList.remove(current_button.getId());
					getApplicationContext().deleteFile("nadineisawesome.sav");
					for(String counter : counterList){
						add_data.saveInFile(counter, getApplicationContext());
					}
					finish();
					
				}
			});

		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.remove_counter, menu);
		return true;
	}

}
