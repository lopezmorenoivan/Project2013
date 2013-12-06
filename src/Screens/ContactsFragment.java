package Screens;

import Logic.User;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.project2013.ContactContentActivity;
import com.example.project2013.MainActivity;
import com.example.project2013.R;
import com.example.project2013.R.id;
import com.example.project2013.R.layout;

public class ContactsFragment extends Fragment {
	
	private ListView list;
	
	private UserListener listener;

	User julien = new User (1, "Julien", "Polizzi", 1, "+4511111111", "140E", 1,"pos1" ,"julien.polizzi@gmail.com");
	User matthieu = new User (2, "Matthieu", "Patin", 2, "+4522222222", "140E", 2, "pos2", "matthieu.patin@gmail.com");
	User daniel = new User (3, "Daniel", "Gutierrez", 3, "+4533333333", "140E", 3, "pos3", "daniel.gutierrez@gmail.com");
	User ivan = new User (4, "Ivan", "Lopez", 4, "+4544444444", "140E", 4, "pos4", "ivan.lopez@gmail.com");
	User users [] = {julien, matthieu, daniel, ivan};
	
	@Override
	public View onCreateView(LayoutInflater inflater, 
			                 ViewGroup container, 
			                 Bundle savedInstanceState) {
		
		return inflater.inflate(R.layout.fragment_contacts, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle state) {
		super.onActivityCreated(state);
		Log.v("fragment","1");
		list = (ListView)getView().findViewById(R.id.list);
		Log.v("fragment","2");
		list.setAdapter(new AdapterUsers(this));
		Log.v("fragment","3");
		list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> list, View view, int pos, long id) {
				Log.v("fragment","4");
				if((getFragmentManager().findFragmentById(R.id.fragment_contact_content) != null)) {
					Log.v("fragment","5");
					((ContactContentFragment)getFragmentManager()
							.findFragmentById(R.id.fragment_contact_content)).
							printMessage(list.getAdapter().getItem(pos).toString());
				}
				else {
					Log.v("fragment","6");
					Intent i = new Intent(getActivity().getApplicationContext(), ContactContentActivity.class);
					i.putExtra("selected", list.getAdapter().getItem(pos).toString());
					startActivity(i);
				}
			}
		});
	}
	
	class AdapterUsers extends ArrayAdapter<User> {
    	
    	Activity context;
    	
    	AdapterUsers(Fragment context) {
    		super(context.getActivity(), R.layout.activity_main_twopane, users);
    		this.context = context.getActivity();
    	}
    	
    	public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = context.getLayoutInflater();
			View item = inflater.inflate(R.layout.activity_main_twopane, null);
			
			TextView name = (TextView)item.findViewById(R.id.Name);
			name.setText(users[position].getName());
			
			TextView kindship = (TextView)item.findViewById(R.id.Kindship);
			kindship.setText(users[position].getPosition());
			
			return(item);
		}
    }
	
	public interface UserListener {
		void onUserSelected(User user);
	}
	
	public void setUserListener(UserListener listener) {
		this.listener=listener;
	}
}
