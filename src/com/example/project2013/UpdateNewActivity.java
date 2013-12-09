package com.example.project2013;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class UpdateNewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update_new);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.update_new, menu);
		return true;
	}

}
