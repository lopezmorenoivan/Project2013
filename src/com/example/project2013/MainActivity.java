package com.example.project2013;

import Screens.AgendaContentFragment;
import Screens.AgendaFragment;
import Screens.ContactContentFragment;
import Screens.ContactsFragment;
import Screens.NewContentFragment;
import Screens.NewsFragment;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.Menu;
import android.widget.TabHost.OnTabChangeListener;


public class MainActivity extends FragmentActivity {
	private FragmentTabHost mTabHost;
	private int currentTab=0;
	private final String TAB1 = "fragment_contacts";
	private final String TAB2 = "fragment_agenda";
	private final String TAB3 = "fragment_news";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.v("what the fuck","1");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		setupTabs();
		
		setupSearch();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		Log.v("1","menu");
		getMenuInflater().inflate(R.menu.main, menu);

		return true;
	}
	
	private void setupSearch() {
		// Get the intent, verify the action and get the query
		Log.v("2","menu");
	    Intent intent = getIntent();
	    if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
	    
	      String query = intent.getStringExtra(SearchManager.QUERY);
	      doMySearch(query);
	    }
	}
	
	private void doMySearch(String query) {
		Log.v("search","pues es cierto que busca");
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
	    final boolean isTablet = getResources().getBoolean(R.bool.isTablet);
	    if (isTablet) {
	    	ContactContentFragment contact = new ContactContentFragment();
    		getSupportFragmentManager().beginTransaction()
    		.replace(R.id.tabletrealtabcontent, contact).commit();
	    }
		
	    
	    mTabHost.setOnTabChangedListener(new OnTabChangeListener(){
	    	@Override
	    	public void onTabChanged(String tabId) {
	    	    if(TAB1.equals(tabId)) {
	    	    	mTabHost.setCurrentTab(0);
	    	    	currentTab = 0;
	    	    	if (isTablet) {
	    	    		ContactContentFragment contact = new ContactContentFragment();
	    	    		getSupportFragmentManager().beginTransaction()
	    	    		.replace(R.id.tabletrealtabcontent, contact).commit();
	    	    	}
	    	    } else if(TAB2.equals(tabId)) {
	    	    	mTabHost.setCurrentTab(1);
	    	    	currentTab = 1;
	    	    	if (isTablet) {
	    	    		AgendaContentFragment contact = new AgendaContentFragment();
	    	    		getSupportFragmentManager().beginTransaction()
	    	    		.replace(R.id.tabletrealtabcontent, contact).commit();
	    	    	}
	    	    } else {
	    	    	mTabHost.setCurrentTab(2);
	    	    	currentTab = 2;
	    	    	if (isTablet) {
	    	    		NewContentFragment contact = new NewContentFragment();
	    	    		getSupportFragmentManager().beginTransaction()
	    	    		.replace(R.id.tabletrealtabcontent, contact).commit();
	    	    	}
	    	    }
	    	}
	    });
	}

}