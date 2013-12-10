package com.example.project2013;

import com.example.Screens.TaskFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;


public class UpdateTaskActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update_task);
		
		Log.v("task","a");
		
		TaskFragment fragment = (TaskFragment)getSupportFragmentManager()
					.findFragmentById(R.id.fragment_task);
	}
}