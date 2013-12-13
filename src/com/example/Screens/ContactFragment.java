package com.example.Screens;

import java.util.ArrayList;

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

import com.example.Logic.Task;
import com.example.Logic.User;
import com.example.Model.UsersInstance;
import com.example.project2013.R;
import com.example.project2013.UpdateContactActivity;

@SuppressLint("NewApi")
public class ContactFragment extends Fragment {
	private ArrayList<User> users = UsersInstance.getInstance().getUsers();
	private User past; 
	
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
		if(item.getItemId()!=android.R.id.home) {
				users.add(getUser());
		}
		
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
	
	public void printSurname(String text) {
		TextView message = (TextView)getView().findViewById(R.id.contact_surname);

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
	
	public void printPrivileges(int number) {
		TextView message = (TextView)getView().findViewById(R.id.contact_privileges);

		message.setText(String.valueOf(number));
	}

	public void printPicture (Bitmap picture) {
		ImageView image = (ImageView) getView().findViewById(R.id.contact_picture);

		image.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_menu_help));
	}

	public void printLocation (int location) {
		//query against the db


		//ImageView image = (ImageView) getView().findViewById(R.id.ContactLocation);

		//image.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_menu_help));
	}
	
	public User getUser () {
		TextView name = (TextView)getView().findViewById(R.id.contact_name);
		TextView surname = (TextView)getView().findViewById(R.id.contact_surname);
		TextView position = (TextView)getView().findViewById(R.id.contact_position);
		TextView mail = (TextView)getView().findViewById(R.id.contact_mail);
		TextView phone = (TextView)getView().findViewById(R.id.contact_phone);
		TextView office = (TextView)getView().findViewById(R.id.contact_office);
		TextView privileges = (TextView)getView().findViewById(R.id.contact_privileges);
		ImageView image = (ImageView) getView().findViewById(R.id.contact_picture);

		
		return new User (name.getText().toString(), surname.getText().toString(),
				image.getDrawingCache(), Integer.valueOf(privileges.getText().toString()), 
				phone.getText().toString(), office.getText().toString(),0,
				position.getText().toString(), mail.getText().toString(),"");
		
	}
}