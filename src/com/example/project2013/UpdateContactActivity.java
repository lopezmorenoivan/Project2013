package com.example.project2013;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.Screens.ContactFragment;


public class UpdateContactActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update_contact);
		
		ContactFragment fragment = (ContactFragment)getSupportFragmentManager()
					.findFragmentById(R.id.fragment_contact);
	}
}