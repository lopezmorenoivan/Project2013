package com.example.project2013;

import Screens.ContactContentFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.project2013.R;

public class ContactContentActivity extends FragmentActivity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_content);
		
		ContactContentFragment content = (ContactContentFragment)getSupportFragmentManager()
					.findFragmentById(R.id.fragment_content);
		
		content.printMessage(getIntent().getStringExtra("selected"));
	}
}
