package com.example.project2013;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class ContentActivity extends FragmentActivity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_content);
		
		FragmentContent content = (FragmentContent)getSupportFragmentManager()
					.findFragmentById(R.id.fragment_content);
		
		content.printMessage(getIntent().getStringExtra("selected"));
	}
}
