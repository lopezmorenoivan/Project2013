package com.example.project2013;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.Menu;

import com.example.project2013.MenuFragment.UserListener;

public class MainActivity extends FragmentActivity implements UserListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		FragmentTabHost mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
	    mTabHost.setup(this, getSupportFragmentManager(), R.id.fragment_menu);
	    mTabHost.addTab(mTabHost.newTabSpec("tab1").setIndicator("Tab1"),
	            MenuFragment.class, null);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		MenuFragment menuFragment = (MenuFragment) getSupportFragmentManager().
				findFragmentById(R.id.fragment_menu);
	    menuFragment.setUserListener(this);
	    
		return true;
	}

	public void onUserSelected(User user) {
		
		if((getSupportFragmentManager().findFragmentById(R.id.fragment_content) != null)) {
			((FragmentContent)getSupportFragmentManager()
				.findFragmentById(R.id.fragment_content)).printMessage(user.toString());
		}
		else {
			Intent i = new Intent(this, ContentActivity.class);
			i.putExtra("selected", user.toString());
			startActivity(i);
		}
	}
}
