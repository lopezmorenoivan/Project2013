package com.example.project2013;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.Screens.NewFragment;

public class AddNewActivity extends FragmentActivity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_new);
		
		NewFragment fragment = (NewFragment)getSupportFragmentManager()
					.findFragmentById(R.id.fragment_new);
	}

}
