package com.example.Screens;

import java.io.Serializable;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.Logic.New;
import com.example.Model.NewsInstance;
import com.example.project2013.AddNewActivity;
import com.example.project2013.NewContentActivity;
import com.example.project2013.R;
import com.example.project2013.UpdateNewActivity;

public class NewsFragment extends Fragment {
	
	private ListView list;
	private Menu menu;
	private New newSelected;
	
	private NewsInstance newsInstance = NewsInstance.getInstance();
	private ArrayList<New> news = newsInstance.getNews();
	
	@Override
	public View onCreateView(LayoutInflater inflater, 
			                 ViewGroup container, 
			                 Bundle savedInstanceState) {
		setHasOptionsMenu(true); 
		
		return inflater.inflate(R.layout.fragment_news, container, false);
	}
	
	@Override 
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {	
		inflater.inflate(R.menu.main, menu); 
		
		this.menu = menu;
	    
	    menu.findItem(R.id.remove).setVisible(false);
	    menu.findItem(R.id.update).setVisible(false);
	}
	
	@Override
	public void onActivityCreated(Bundle state) {
		super.onActivityCreated(state);
		
		setupListView();
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			//case R.id.search: break;
			case R.id.add: add(); break;
			case R.id.remove: news.remove(newSelected); break;
			case R.id.update: update(); break;
			default: break;
		}
		
		//update
		news = newsInstance.getNews();
		fromParticularToGeneral();
		list.invalidateViews();
		
		newSelected = null;
		
	    return true;
	}
	
	private void add() {
		Intent i = new Intent (getActivity().getApplicationContext(), AddNewActivity.class);
		startActivity(i);
	}
	
	private void update () {
		Intent i = new Intent (getActivity().getApplicationContext(), UpdateNewActivity.class);
		Bundle bundle = new Bundle();  
		bundle.putSerializable("noticia", (Serializable) newSelected);
		i.putExtras(bundle);
		
		news.remove(newSelected);
	
		startActivity(i);
	}
	
	private void fromGeneralToParticular () {
		menu.findItem(R.id.remove).setVisible(true);
	    menu.findItem(R.id.update).setVisible(true);
	    
	    menu.findItem(R.id.add).setVisible(false);
	    //menu.findItem(R.id.search).setVisible(false);
	    menu.findItem(R.id.refresh).setVisible(false);
	}
	
	private void fromParticularToGeneral () {
		menu.findItem(R.id.remove).setVisible(false);
	    menu.findItem(R.id.update).setVisible(false);
	    
	    menu.findItem(R.id.add).setVisible(true);
	    //menu.findItem(R.id.search).setVisible(true);
	    menu.findItem(R.id.refresh).setVisible(true);
	}
	
	public void setupListView() {
		list = (ListView)getView().findViewById(R.id.NewsList);
		list.setAdapter(new AdapterNews(this));
		
		Log.v("why","why");
		
		list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> list, View view,
					int pos, long id) {
				fromGeneralToParticular();
				
			    newSelected=(New)news.get(pos);
				
				return true;
			}
		});
		list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> list, View view, int pos, long id) {
				New noticia = (New) list.getAdapter().getItem(pos);
				
				if(getResources().getBoolean(R.bool.isTablet)) {
					NewContentFragment fragment = ((NewContentFragment)getFragmentManager()
							.findFragmentById(R.id.fragment_new_content));
					fragment.printHead(noticia.getTitle());
					fragment.printContent(noticia.getContent());
					fragment.printPicture(noticia.getPicture());
				}
				else {
					Intent i = new Intent(getActivity().getApplicationContext(), NewContentActivity.class);
					Bundle bundle = new Bundle();  
					bundle.putSerializable("noticia", (Serializable) noticia);
					i.putExtras(bundle);
					startActivity(i);
				}
			}
		});
	}
	
	class AdapterNews extends ArrayAdapter<New> {
    	
    	Activity context;
    	
    	AdapterNews(Fragment context) {
    		super(context.getActivity(), R.layout.list_view, news);
    		this.context = context.getActivity();
    	}
    	
    	public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = context.getLayoutInflater();
			View item = inflater.inflate(R.layout.list_view, null);
			
			TextView name = (TextView)item.findViewById(R.id.FirstLabel);
			name.setText(news.get(position).getTitle());
			
			TextView kindship = (TextView)item.findViewById(R.id.SecondLabel);
			kindship.setText(news.get(position).getDescription());
			
			return(item);
		}
    }
}
