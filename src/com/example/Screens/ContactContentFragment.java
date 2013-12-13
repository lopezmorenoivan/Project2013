package com.example.Screens;

import android.annotation.SuppressLint;
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

import com.example.Tools.BitmapUtil;
import com.example.project2013.R;

@SuppressLint("NewApi")
public class ContactContentFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, 
			ViewGroup container, 
			Bundle savedInstanceState) {
		
		getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);

		return inflater.inflate(R.layout.fragment_contact_content, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle state) {
		super.onActivityCreated(state);
		
		setHasOptionsMenu(true);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Log.v("contactContentFragment","2");
		NavUtils.navigateUpFromSameTask(this.getActivity());
        return true;
	}
	
	public void printTitle (String title) {
		getActivity().getActionBar().setTitle(title);
	}

	public void printName(String text) {
		TextView message = (TextView)getView().findViewById(R.id.ContactName);

		message.setText(text);
	}

	public void printPosition(String text) {
		TextView message = (TextView)getView().findViewById(R.id.ContactPosition);

		message.setText(text);
	}

	public void printMail(String text) {
		TextView message = (TextView)getView().findViewById(R.id.ContactMail);

		message.setText(text);
	}

	public void printPhone(String text) {
		TextView message = (TextView)getView().findViewById(R.id.ContactPhone);

		message.setText(text);
	}

	public void printOffice(String text) {
		TextView message = (TextView)getView().findViewById(R.id.ContactOffice);

		message.setText(text);
	}

	public void printPicture (byte picture []) {
		ImageView image = (ImageView) getView().findViewById(R.id.ContactPicture);

		if (picture != null) {
			image.setImageBitmap(BitmapUtil.byteArrayToBitmap(picture));
		}
	}

	public void printLocation (int location) {
		//query against the db


		ImageView image = (ImageView) getView().findViewById(R.id.ContactLocation);

		image.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_menu_help));
	}
}