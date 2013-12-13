package com.example.project2013;

import com.example.Logic.User;
import com.example.Screens.ContactContentFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

@SuppressLint("NewApi")
public class ContactContentActivity extends FragmentActivity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_content);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		User contact = (User) getIntent().getExtras().getSerializable("contact");
		
		ContactContentFragment fragment = (ContactContentFragment)getSupportFragmentManager()
					.findFragmentById(R.id.fragment_contact_content);

		
		fragment.printTitle(contact.getName() + " " + contact.getSurname());
		fragment.printName(contact.getName()+" "+contact.getSurname());
		fragment.printPosition(contact.getPosition());
		fragment.printPicture(contact.getPicture());
		fragment.printMail(contact.getMail());
		fragment.printPhone(contact.getPhone());
		fragment.printOffice(contact.getOffice());
		fragment.printLocation(contact.getLocation());
	}
}
