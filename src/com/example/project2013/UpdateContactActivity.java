package com.example.project2013;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.example.Logic.User;
import com.example.Screens.ContactFragment;


public class UpdateContactActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
Log.v("onCreate","-1");
		setContentView(R.layout.activity_update_contact);
Log.v("onCreate","0");
		ContactFragment fragment = (ContactFragment)getSupportFragmentManager()
					.findFragmentById(R.id.fragment_contact);
		
		User contact = (User) getIntent().getExtras().getSerializable("contact");
Log.v("onCreate","1");		
		fragment.printMail(contact.getMail());
		fragment.printName(contact.getName());
		fragment.printOffice(contact.getOffice());
		fragment.printPhone(contact.getPhone());
		fragment.printPicture(contact.getPicture());
		fragment.printPosition(contact.getPosition());
		fragment.printPrivileges(contact.getPrivileges());
		fragment.printSurname(contact.getSurname());
		fragment.printLocation(contact.getLocation());
		fragment.printTitle("Update Contact");
	}
}