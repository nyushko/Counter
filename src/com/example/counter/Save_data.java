package com.example.counter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;

public class Save_data {
	
	protected static final String FILENAME = "nadineisawesome.sav";
	protected static final String FILENAME_FULL = "alldata.sav";

	protected String[] loadFromFile(Context context) {
		Log.d("loadFromFile", "loadFromFile");
		ArrayList<String> count_name = new ArrayList<String>();
		try {
			FileInputStream fis = context.openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			String line = in.readLine();
			while (line != null) {
				count_name.add(line);
				line = in.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count_name.toArray(new String[count_name.size()]);
	}
	
	protected String[] loadResultsFile(Context context) {
		ArrayList<String> count_name = new ArrayList<String>();
		try {
			FileInputStream fis = context.openFileInput(FILENAME_FULL);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			String line = in.readLine();
			while (line != null) {
				count_name.add(line);
				line = in.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count_name.toArray(new String[count_name.size()]);
	}
	
	protected void saveInFile(String text, Date date, Context context) {
		Log.d("saveInFile", "saveInFile");
		try {
			FileOutputStream fos = context.openFileOutput(FILENAME,
					Context.MODE_APPEND);
			int counter = 0;
			fos.write(new String(date.toString() + " | " + text + " | " + counter + "\n")
					.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void saveInFile(String text, Context context) {
		Log.d("saveInFile", "saveInFile");
		try {
			FileOutputStream fos = context.openFileOutput(FILENAME,
					Context.MODE_APPEND);
			fos.write(new String(text + "\n").getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void saveResultsFile(String text, Date date, Context context) {
		try {
			FileOutputStream fos = context.openFileOutput(FILENAME_FULL,
					Context.MODE_APPEND);
			fos.write(new String(text + " | " + date.toString() + "\n").getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}