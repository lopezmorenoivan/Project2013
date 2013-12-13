package com.example.Screens;

import java.io.Serializable;
import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.Logic.User;
import com.example.Model.UsersInstance;
import com.example.project2013.AddContactActivity;
import com.example.project2013.ContactContentActivity;
import com.example.project2013.R;
import com.example.project2013.UpdateContactActivity;

@SuppressLint("NewApi")
public class ContactsFragment extends Fragment {
	
	private ListView list;
	private Menu menu;
	private User userSelected;

	User julien = new User ("Julien", "Polizzi", null, 1,"+4511111111", "140E", 1,
			"pos1" ,"julien.polizzi@gmail.com","");
	User matthieu = new User ("Matthieu", "Patin", null, 2, "+4522222222", "140E", 2, 
			"pos2", "matthieu.patin@gmail.com","");
	User daniel = new User ("Daniel", "Gutierrez", null, 3, "+4533333333", "140E", 3, 
			"pos3", "daniel.gutierrez@gmail.com","");
	User ivan = new User ("Ivan", "Lopez", null, 4, "+4544444444", "140E", 4, 
			"pos4", "ivan.lopez@gmail.com","");
	
	private UsersInstance usersInstance = UsersInstance.getInstance();
	private ArrayList<User> users = usersInstance.getUsers();
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, 
			                 ViewGroup container, 
			                 Bundle savedInstanceState) {
		setHasOptionsMenu(true); 
		
		return inflater.inflate(R.layout.fragment_contacts, container, false);
	}

	
	@Override 
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {	
		inflater.inflate(R.menu.main, menu); 
		
		this.menu = menu;

	    //setupSearchView(menu);
	    
	    menu.findItem(R.id.remove).setVisible(false);
	    menu.findItem(R.id.update).setVisible(false);
	    
	    Log.v("4","4");
	}
	
	@Override
	public void onActivityCreated(Bundle state) {
		super.onActivityCreated(state);
		setupListView();
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			//case R.id.search: break;
			case R.id.add: add(); break;
			case R.id.remove: users.remove(userSelected); break;
			case R.id.update: update(); break;
			default: break;
		}
		
		//update
		users = usersInstance.getUsers();
		fromParticularToGeneral();
		list.invalidateViews();
		
		userSelected = null;
		
        return true;
	}
	
	private void add() {
		users.add(julien);
		Intent i = new Intent (getActivity().getApplicationContext(), AddContactActivity.class);
		startActivity(i);
	}
	
	private void update () {
		Intent i = new Intent (getActivity().getApplicationContext(), UpdateContactActivity.class);
		Bundle bundle = new Bundle();  
		bundle.putSerializable("contact", (Serializable) userSelected);
		i.putExtras(bundle);
		
		users.remove(userSelected);

		startActivity(i);
	}
	
	private void fromGeneralToParticular () {
		menu.findItem(R.id.remove).setVisible(true);
	    menu.findItem(R.id.update).setVisible(true);
	    
	    menu.findItem(R.id.add).setVisible(false);
	    //menu.findItem(R.id.search).setVisible(false);
	    menu.findItem(R.id.refresh).setVisible(false);
	}
	
	private void fromParticularToGeneral () {
		menu.findItem(R.id.remove).setVisible(false);
	    menu.findItem(R.id.update).setVisible(false);
	    
	    menu.findItem(R.id.add).setVisible(true);
	    //menu.findItem(R.id.search).setVisible(true);
	    menu.findItem(R.id.refresh).setVisible(true);
	}
	
	private void setupListView() {
		list = (ListView)getView().findViewById(R.id.ContactsList);
		list.setAdapter(new AdapterUsers(this));
		list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> list, View view,
					int pos, long id) {
				fromGeneralToParticular();
				
			    userSelected=(User)users.get(pos);
				
				return true;
			}
		});
		list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> list, View view, int pos, long id) {
				User contact = (User) list.getAdapter().getItem(pos);
				ContactContentFragment fragment = new ContactContentFragment();
				if(getResources().getBoolean(R.bool.isTablet)) {
					fragment.printName(contact.getName()+" "+contact.getSurname());
					fragment.printPosition(contact.getPosition());
					fragment.printPicture(contact.getPicture());
					fragment.printMail(contact.getMail());
					fragment.printPhone(contact.getPhone());
					fragment.printOffice(contact.getOffice());
					fragment.printLocation(contact.getLocation());
				} else {
					Intent i = new Intent(getActivity().getApplicationContext(), ContactContentActivity.class);
					Bundle bundle = new Bundle();  
					bundle.putSerializable("contact", (Serializable) contact);
					i.putExtras(bundle);
					startActivity(i);
				}
			}
		});
	}
	
	private void setupSearchView(Menu menu) {
		Log.v("5","5");
		/*android.support.v7.widget.SearchView searchView = 
				(android.support.v7.widget.SearchView) menu.findItem(R.id.search).getActionView();
		Log.v("6","6");
	    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {       
		    @Override
		    public boolean onQueryTextChange(String newText) {
		        Log.v("search","the search is near");
		        return false;
		    }

		    @Override
		    public boolean onQueryTextSubmit(String query) {            
		        Log.v("search","dunno");
		        return false;
		    }
		});*/
	}
	
	class AdapterUsers extends ArrayAdapter<User> {
    	
    	Activity context;
    	
    	AdapterUsers(Fragment context) {
    		super(context.getActivity(), R.layout.list_view, users);
    		this.context = context.getActivity();
    	}
    	
    	public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = context.getLayoutInflater();
			View item = inflater.inflate(R.layout.list_view, null);
			
			TextView name = (TextView)item.findViewById(R.id.FirstLabel);
			name.setText(users.get(position).getName() + " " + users.get(position).getSurname());
			
			TextView kindship = (TextView)item.findViewById(R.id.SecondLabel);
			kindship.setText(users.get(position).getPosition());
			
			return(item);
		}
    }
}
