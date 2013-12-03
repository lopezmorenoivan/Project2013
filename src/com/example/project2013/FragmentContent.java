package com.example.project2013;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentContent extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, 
			                 ViewGroup container, 
			                 Bundle savedInstanceState) {
		
		return inflater.inflate(R.layout.fragment_content, container, false);
	}
	
	public void printMessage(String text) {
		TextView message = (TextView)getView().findViewById(R.id.Content);
		
		message.setText(text);
	}
}