package com.example.project2013;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

import com.example.project2013.MenuFragment.CharacterListener;

public class MainActivity extends FragmentActivity implements CharacterListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		MenuFragment menu
			=(MenuFragment)getSupportFragmentManager()
				.findFragmentById(R.id.fragment_menu);
		
		menu.setCharacterListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onCharacterSelected(Character character) {
		
		if((getSupportFragmentManager().findFragmentById(R.id.fragment_content) != null)) {
			((FragmentContent)getSupportFragmentManager()
				.findFragmentById(R.id.fragment_content)).printMessage(character.getDescription());
		}
		else {
			Intent i = new Intent(this, ContentActivity.class);
			i.putExtra("selected", character.getDescription());
			startActivity(i);
		}
	}
}
