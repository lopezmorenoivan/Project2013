package com.example.Screens;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.Logic.New;
import com.example.Logic.User;
import com.example.Model.NewsInstance;
import com.example.Model.UsersInstance;
import com.example.project2013.R;

@SuppressLint("NewApi")
public class NewFragment extends Fragment {
	New past;
	ArrayList<New> news = NewsInstance.getInstance().getNews();
	
	@Override
	public View onCreateView(LayoutInflater inflater, 
			                 ViewGroup container, 
			                 Bundle savedInstanceState) {
		
		getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);

		return inflater.inflate(R.layout.fragment_new, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle state) {
		super.onActivityCreated(state);
		
		setHasOptionsMenu(true);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId()!=android.R.id.home) {
				news.add(getNew());
		}
		
		NavUtils.navigateUpFromSameTask(this.getActivity());
		
        return true;
	}
	public void printTitle (String title) {
		getActivity().getActionBar().setTitle(title);
	}
	
	public void printContent(String text) {
		TextView newContent = (TextView)getView().findViewById(R.id.new_content);
		newContent.setText(text);
	}
	
	public void printHead (String text) {
		TextView newHead = (TextView)getView().findViewById(R.id.new_title);
		newHead.setText(text);
	}
	
	public void printPicture (Bitmap picture) {
		ImageView image = (ImageView) getView().findViewById(R.id.new_image);
		
		image.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_menu_help));
	}
	
	public void printDescription(String text) {
		TextView newDescription = (TextView)getView().findViewById(R.id.new_description);
		newDescription.setText(text);
	}
	
	public New getNew () {
		TextView newContent = (TextView)getView().findViewById(R.id.new_content);
		TextView newHead = (TextView)getView().findViewById(R.id.new_title);
		ImageView image = (ImageView) getView().findViewById(R.id.new_image);
		TextView newDescription = (TextView)getView().findViewById(R.id.new_description);
		
		return new New(newHead.getText().toString(), newContent.getText().toString(),
				newDescription.getText().toString(), image.getDrawingCache());
	}
}