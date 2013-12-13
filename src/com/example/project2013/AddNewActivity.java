package com.example.project2013;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

public class AddNewActivity extends FragmentActivity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_new);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.add_update, menu);

		return true;
	}

}
