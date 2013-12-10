package com.example.Screens;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project2013.R;

public class NewContentFragment extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, 
			                 ViewGroup container, 
			                 Bundle savedInstanceState) {
		
		return inflater.inflate(R.layout.fragment_new_content, container, false);
	}
	
	public void printContent(String text) {
		TextView newContent = (TextView)getView().findViewById(R.id.NewContent);
		newContent.setText(text);
	}
	
	public void printHead (String text) {
		TextView newHead = (TextView)getView().findViewById(R.id.NewHead);
		newHead.setText(text);
	}
	
	public void printPicture (Bitmap picture) {
		ImageView image = (ImageView) getView().findViewById(R.id.NewImage);
		
		image.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_menu_help));
	}
}