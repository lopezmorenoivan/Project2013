package com.example.project2013;

import com.example.Logic.Task;
import com.example.Screens.TaskFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;


public class UpdateTaskActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_update_task);

		TaskFragment fragment = (TaskFragment)getSupportFragmentManager()
				.findFragmentById(R.id.fragment_task);
	
		Task noticia = (Task) getIntent().getExtras().getSerializable("task");

		fragment.printName(noticia.getName());
		fragment.printDescription(noticia.getDescription());
		fragment.printDate(noticia.getDate());
		fragment.printTitle("Update Task");
	}
	

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.add_update, menu);

		return true;
	}
}