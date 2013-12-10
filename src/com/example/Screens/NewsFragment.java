package com.example.Screens;

import java.io.File;
import java.io.Serializable;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.Logic.New;
import com.example.Screens.ContactsFragment.AdapterUsers;
import com.example.project2013.ContactContentActivity;
import com.example.project2013.NewContentActivity;
import com.example.project2013.R;

public class NewsFragment extends Fragment {
	
	private ListView list;
	
	File file= new File(android.os.Environment.getRootDirectory(),"Your folder");
	Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
	
	New first = new New ("first", "this is the first new", "this is the first description", null);
	New second = new New ("second", "this is the second new", "this is the second description", null);
	New third = new New ("third", "this is the third new", "this is the third description", null);
	New fourth = new New ("fourth", "this is the fourth new", "this is the fourth description", null);
	New fifth = new New ("fifth", "this is the fifth new", "this is the fifth description", null);
	
	New news [] = {first, second, third, fourth, fifth};
	
	@Override
	public View onCreateView(LayoutInflater inflater, 
			                 ViewGroup container, 
			                 Bundle savedInstanceState) {
		
		return inflater.inflate(R.layout.fragment_news, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle state) {
		super.onActivityCreated(state);
		
		list = (ListView)getView().findViewById(R.id.NewsList);
		list.setAdapter(new AdapterNews(this));
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
					bundle.putSerializable("new", (Serializable) noticia);
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
			name.setText(news[position].getTitle());
			
			TextView kindship = (TextView)item.findViewById(R.id.SecondLabel);
			kindship.setText(news[position].getDescription());
			
			return(item);
		}
    }
}
