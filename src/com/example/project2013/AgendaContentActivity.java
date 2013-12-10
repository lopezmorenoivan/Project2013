package com.example.project2013;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.Logic.Task;
import com.example.Screens.AgendaContentFragment;
import com.example.project2013.R;

public class AgendaContentActivity extends FragmentActivity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_agenda_content);
		
		AgendaContentFragment fragment = (AgendaContentFragment)getSupportFragmentManager()
					.findFragmentById(R.id.fragment_agenda_content);
		Task task = (Task) getIntent().getExtras().getSerializable("task");
		
		fragment.printHead(task.getName());
		fragment.printContent(task.getDescription());
		fragment.printDate(task.getDate());
	}
}
