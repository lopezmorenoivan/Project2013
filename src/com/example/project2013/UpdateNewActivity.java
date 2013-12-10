package com.example.project2013;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

import com.example.Screens.NewFragment;


public class UpdateNewActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update_new);
		
		NewFragment fragment = (NewFragment)getSupportFragmentManager()
					.findFragmentById(R.id.fragment_new);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.add_update, menu);

		return true;
	}
}
