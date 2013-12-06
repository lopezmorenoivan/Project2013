package com.example.project2013;

import Screens.AgendaContentFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.project2013.R;

public class AgendaContentActivity extends FragmentActivity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_agenda_content);
		
		AgendaContentFragment content = (AgendaContentFragment)getSupportFragmentManager()
					.findFragmentById(R.id.fragment_agenda_content);
		
		content.printMessage(getIntent().getStringExtra("selected"));
	}
}
