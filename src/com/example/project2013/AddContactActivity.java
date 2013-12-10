package com.example.project2013;

import com.example.Logic.Task;
import com.example.Screens.AddContactFragment;
import com.example.Screens.AgendaContentFragment;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

public class AddContactActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_contact);
		
		AddContactFragment fragment = (AddContactFragment)getSupportFragmentManager()
					.findFragmentById(R.id.fragment_add_contact);
	}
}
