package com.example.project2013;

import com.example.Screens.TaskFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;


public class UpdateTaskActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update_task);
		
		TaskFragment fragment = (TaskFragment)getSupportFragmentManager()
					.findFragmentById(R.id.fragment_task);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.add_update, menu);

		return true;
	}
}