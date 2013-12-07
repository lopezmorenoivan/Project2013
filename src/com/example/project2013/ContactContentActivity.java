package com.example.project2013;

import Logic.User;
import Screens.ContactContentFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class ContactContentActivity extends FragmentActivity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_content);
		
		User contact = (User) getIntent().getExtras().getSerializable("contact");
		
		ContactContentFragment fragment = (ContactContentFragment)getSupportFragmentManager()
					.findFragmentById(R.id.fragment_contact_content);
		
		fragment.printName(contact.getName()+" "+contact.getSurname());
		fragment.printPosition(contact.getPosition());
		fragment.printPicture(contact.getPicture());
		fragment.printMail(contact.getMail());
		fragment.printPhone(contact.getPhone());
		fragment.printOffice(contact.getOffice());
		fragment.printLocation(contact.getLocation());
	}
}
