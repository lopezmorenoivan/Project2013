package com.example.project2013;

import Screens.AgendaFragment;
import Screens.ContactsFragment;
import Screens.NewsFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.Menu;
import android.widget.TabHost.OnTabChangeListener;


public class MainActivity extends FragmentActivity {
	private FragmentTabHost mTabHost;
	private final String TAB1 = "fragment_contacts";
	private final String TAB2 = "fragment_agenda";
	private final String TAB3 = "fragment_news";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		setupTabs();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);

		return true;
	}
	
	private void setupTabs() {
		mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
		
	    mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
	    
	    mTabHost.addTab(mTabHost.newTabSpec(TAB1).setIndicator("Contacts"),
	            ContactsFragment.class, null);
	    mTabHost.addTab(mTabHost.newTabSpec(TAB2).setIndicator("Agenda"),
	            AgendaFragment.class, null);
	    mTabHost.addTab(mTabHost.newTabSpec(TAB3).setIndicator("News"),
	            NewsFragment.class, null);
	    
	    mTabHost.setCurrentTab(0);
	    
	    mTabHost.setOnTabChangedListener(new OnTabChangeListener(){
	    	@Override
	    	public void onTabChanged(String tabId) {
	    	    if(TAB1.equals(tabId)) {
	    	    	mTabHost.setCurrentTab(0);
	    	    } else if(TAB2.equals(tabId)) {
	    	    	mTabHost.setCurrentTab(1);
	    	    } else {
	    	    	mTabHost.setCurrentTab(2);
	    	    }
	    	}
	    });
	}

}