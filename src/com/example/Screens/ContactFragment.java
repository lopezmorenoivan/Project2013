package com.example.Screens;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project2013.R;

@SuppressLint("NewApi")
public class ContactFragment extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, 
			                 ViewGroup container, 
			                 Bundle savedInstanceState) {
		
		
		getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);

		return inflater.inflate(R.layout.fragment_contact, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle state) {
		super.onActivityCreated(state);
		
		setHasOptionsMenu(true);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		NavUtils.navigateUpFromSameTask(this.getActivity());
        return true;
	}
	
	public void printTitle (String title) {
		getActivity().getActionBar().setTitle(title);
	}
	
	public void printName(String text) {
		TextView message = (TextView)getView().findViewById(R.id.contact_name);

		message.setText(text);
	}

	public void printPosition(String text) {
		TextView message = (TextView)getView().findViewById(R.id.contact_position);

		message.setText(text);
	}

	public void printMail(String text) {
		TextView message = (TextView)getView().findViewById(R.id.contact_mail);

		message.setText(text);
	}

	public void printPhone(String text) {
		TextView message = (TextView)getView().findViewById(R.id.contact_phone);

		message.setText(text);
	}

	public void printOffice(String text) {
		TextView message = (TextView)getView().findViewById(R.id.contact_office);

		message.setText(text);
	}

	public void printPicture (Bitmap picture) {
		//ImageView image = (ImageView) getView().findViewById(R.id.ContactPicture);

		//image.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_menu_help));
	}

	public void printLocation (int location) {
		//query against the db


		//ImageView image = (ImageView) getView().findViewById(R.id.ContactLocation);

		//image.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_menu_help));
	}
}