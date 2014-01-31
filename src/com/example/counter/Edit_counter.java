package com.example.counter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Edit_counter extends Activity {

	LinearLayout counter_edit_view;
	int i;
	ArrayList<String> counterList;
	EditText edit_text;
	LinearLayout edit_counters_view;
	Save_data add_data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_counter);
		add_data = new Save_data();
		edit_counters_view = (LinearLayout) findViewById(R.id.edit_counters_view);
		i = 0;
		counterList = new ArrayList<String>(Arrays.asList(add_data
				.loadFromFile(getApplicationContext())));
		for (String entry : counterList) {
			// for (String j : i.split("\\W+")){
			// String j = (i.replaceAll("\\s","").split("\\|"))[1];
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			params.weight = 1.0f;
			LinearLayout single_counter_view = new LinearLayout(this);
			single_counter_view.setOrientation(LinearLayout.VERTICAL);
			counter_edit_view = new LinearLayout(this);
			// single_counter_view.setId('fff');
			// current_count = 0;
			final String[] counter_name = entry.split("\\|+");
			Button new_button = new Button(this);
			// new_button.setLayoutParams(params);
			new_button.setText(counter_name[1].trim());
			new_button.setTag(counter_name[0]);
			// new_button.setId(i);
			// new_text = new TextView(this);
			// new_text.setText(Integer.toString(current_count));
			single_counter_view.addView(new_button);
			edit_text = new EditText(getApplicationContext());
			edit_text.setText(new_button.getText());
			edit_text.setLayoutParams(params);
			edit_text.setTextColor(getResources().getColor(android.R.color.black));
			edit_text.setId(i);
			counter_edit_view.addView(edit_text);
			Button save_button = new Button(this);
			save_button
					.setId(Integer.parseInt(counter_name[2].replace(" ", "")));
			save_button.setTag(counter_name[0]);
			save_button.setText("Save");
			counter_edit_view.addView(save_button);
			// single_counter_view.addView(new_text);
			single_counter_view.addView(counter_edit_view);
			edit_counters_view.addView(single_counter_view);
			i = i + 1;
			new_button.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Button current_button = (Button) v;

					/*
					 * LinearLayout button_Layout = (LinearLayout)
					 * ((LinearLayout) v .getParent()).getChildAt(1); EditText
					 * counter_name_edit = (EditText) button_Layout
					 * .getChildAt(0); Log.d("Counter Entry",
					 * counterList.get(current_button.getId()).toString());
					 * Log.d("Counter List Before", counterList.toString());
					 * counterList.set(current_button.getId(), current_button
					 * .getTag().toString() + " | " +
					 * counter_name_edit.getText().toString());
					 * Log.d("Counter List After", counterList.toString());
					 */

					// new_text = (TextView) current_button.getChildAt(1);
					// current_count =
					// Integer.parseInt(new_text.getText().toString()) + 1;
					// new_text.setText(Integer.toString(current_count));
					// Log.d("ID", new_text.getText().toString());
					// getApplicationContext().deleteFile("nadineisawesome.sav");

				}
			});

			save_button.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					LinearLayout edit_layout = (LinearLayout) v.getParent();
					EditText counter_name_edit = (EditText) edit_layout
							.getChildAt(0);
					Button current_save_button = (Button) v;
					counterList.set(
							counter_name_edit.getId(),
							current_save_button.getTag().toString()
									+ " | "
									+ counter_name_edit.getText().toString()
									+ " | "
									+ Integer.toString(current_save_button
											.getId()));
					add_data.saveResultsFile(counter_name_edit.getText().toString(), 
							new Date(System.currentTimeMillis()), getApplicationContext());
					// edit_counters_view.removeAllViews();
					getApplicationContext().deleteFile("nadineisawesome.sav");
					for (String counter : counterList) {
						add_data.saveInFile(counter, getApplicationContext());
					}
					finish();

				}
			});
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_counter, menu);
		return true;
	}

}
