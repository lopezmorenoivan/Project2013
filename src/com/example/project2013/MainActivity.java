package com.example.project2013;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.Menu;
import android.widget.TabHost.OnTabChangeListener;

import com.example.Screens.AgendaContentFragment;
import com.example.Screens.AgendaFragment;
import com.example.Screens.ContactContentFragment;
import com.example.Screens.ContactsFragment;
import com.example.Screens.NewContentFragment;
import com.example.Screens.NewsFragment;


public class MainActivity extends FragmentActivity {
	private FragmentTabHost mTabHost;
	private int currentTab=0;
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
		getMenuInflater().inflate(R.menu.main, menu);
		
		menu.findItem(R.id.remove).setVisible(false);
	    menu.findItem(R.id.update).setVisible(false);
	    
	    menu.findItem(R.id.add).setVisible(true);
	    //menu.findItem(R.id.search).setVisible(true);
	    menu.findItem(R.id.refresh).setVisible(true);

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
	    
	    mTabHost.setCurrentTab(currentTab);
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