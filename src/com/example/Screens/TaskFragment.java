package com.example.Screens;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.Logic.Task;
import com.example.Model.AgendaInstance;
import com.example.project2013.R;

@SuppressLint("NewApi")

public class TaskFragment extends Fragment {
	Task past;
	
	ArrayList<Task> agenda = AgendaInstance.getInstance().getAgenda();
	
	@Override
	public View onCreateView(LayoutInflater inflater, 
			                 ViewGroup container, 
			                 Bundle savedInstanceState) {
		/*
		if (getActivity().getClass().equals(UpdateContactActivity.class)){
			past = (User) savedInstanceState.getSerializable("contact");
		}
		*/
		getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);

		return inflater.inflate(R.layout.fragment_task, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle state) {
		super.onActivityCreated(state);
		
		setHasOptionsMenu(true);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId()!=android.R.id.home) {
			if (past!=null) {
				Task future = getTask();
				//future.setID(past.getID());
				
				agenda.set(agenda.indexOf(past),future);
				AgendaInstance.setAgenda(agenda);
			} else {
				agenda.add(getTask());
			} 
		}
		
		NavUtils.navigateUpFromSameTask(this.getActivity());
		
        return true;
	}
	
	@SuppressLint("NewApi")
	public void printTitle (String title) {
		getActivity().getActionBar().setTitle(title);
	}
	
	public void printName(String text) {
		TextView agendaName = (TextView)getView().findViewById(R.id.task_name);
		agendaName.setText(text);
	}
	
	public void printDescription (String text) {
		TextView agendaDescription = (TextView)getView().findViewById(R.id.task_description);
		agendaDescription.setText(text);
	}
	
	public void printDate (GregorianCalendar date) {
		
	}
	
	public Task getTask () {
		TextView agendaName = (TextView)getView().findViewById(R.id.task_name);
		TextView agendaDescription = (TextView)getView().findViewById(R.id.task_description);
		
		return new Task (agendaName.getText().toString(), 
				agendaDescription.getText().toString(), 
				new GregorianCalendar(2005, Calendar.DECEMBER, 30));
	}
}