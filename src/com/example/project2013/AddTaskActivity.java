package com.example.project2013;

import com.example.Screens.TaskFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;


public class AddTaskActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_task);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.add_update, menu);

		return true;
	}
}