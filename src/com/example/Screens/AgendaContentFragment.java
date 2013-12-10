package com.example.Screens;

import java.util.GregorianCalendar;

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
public class AgendaContentFragment extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, 
			                 ViewGroup container, 
			                 Bundle savedInstanceState) {
	
		getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);

		return inflater.inflate(R.layout.fragment_agenda_content, container, false);
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
	
	public void printContent(String text) {
		TextView agendaContent = (TextView)getView().findViewById(R.id.AgendaContent);
		agendaContent.setText(text);
	}
	
	public void printHead (String text) {
		TextView agendaHead = (TextView)getView().findViewById(R.id.AgendaHead);
		agendaHead.setText(text);
	}
	
	public void printDate (GregorianCalendar date) {
		TextView agendaDate = (TextView)getView().findViewById(R.id.AgendaDate);
		
		agendaDate.setText("Day: " + date.DAY_OF_MONTH + "/" + date.MONTH + 
						   "/" + date.YEAR + " at " + date.HOUR + ":" + date.MINUTE);
	}
}