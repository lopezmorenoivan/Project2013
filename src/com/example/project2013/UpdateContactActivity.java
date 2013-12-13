package com.example.project2013;

import java.io.Serializable;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;

import com.example.Logic.User;
import com.example.Screens.ContactFragment;


public class UpdateContactActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update_contact);
		
		ContactFragment fragment = (ContactFragment)getSupportFragmentManager()
				.findFragmentById(R.id.fragment_contact);
		User contact = (User) getIntent().getExtras().getSerializable("contact");

		fragment.printMail(contact.getMail());
		fragment.printName(contact.getName());
		fragment.printOffice(contact.getOffice());
		fragment.printPhone(contact.getPhone());
		fragment.printPicture(contact.getPicture());
		fragment.printPosition(contact.getPosition());
		fragment.printPrivileges(contact.getPrivileges());
		fragment.printSurname(contact.getSurname());
		fragment.printTitle("Update Contact");
	}
	

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.add_update, menu);

		return true;
	}
}