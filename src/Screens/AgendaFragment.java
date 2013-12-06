package Screens;

import Logic.Task;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.project2013.AgendaContentActivity;
import com.example.project2013.R;

public class AgendaFragment extends Fragment {
	
	private ListView list;

	Task first = new Task ("first","do the first thing", null);
	Task second = new Task ("second","do the second thing",null);
	Task third = new Task ("third","do the third thing",null);
	Task fourth = new Task ("fourth","do the fourth thing",null);
	Task fifth = new Task ("fifth","do the fifth thing",null);
	
	Task tasks [] = {first, second, third, fourth, fifth};
	
	@Override
	public View onCreateView(LayoutInflater inflater, 
			                 ViewGroup container, 
			                 Bundle savedInstanceState) {
		
		return inflater.inflate(R.layout.fragment_agenda, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle state) {
		super.onActivityCreated(state);
		
		list = (ListView)getView().findViewById(R.id.AgendaList);
		list.setAdapter(new AdapterTasks(this));
		list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> list, View view, int pos, long id) {
				if((getFragmentManager().findFragmentById(R.id.fragment_agenda_content) != null)) {
					((AgendaContentFragment)getFragmentManager()
							.findFragmentById(R.id.fragment_agenda_content)).
							printMessage(list.getAdapter().getItem(pos).toString());
				}
				else {
					Intent i = new Intent(getActivity().getApplicationContext(), AgendaContentActivity.class);
					i.putExtra("selected", list.getAdapter().getItem(pos).toString());
					startActivity(i);
				}
			}
		});
	}
	
	class AdapterTasks extends ArrayAdapter<Task> {
    	
    	Activity context;
    	
    	AdapterTasks(Fragment context) {
    		super(context.getActivity(), R.layout.activity_main_twopane, tasks);
    		this.context = context.getActivity();
    	}
    	
    	public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = context.getLayoutInflater();
			View item = inflater.inflate(R.layout.activity_main_twopane, null);
			
			TextView name = (TextView)item.findViewById(R.id.Name);
			name.setText(tasks[position].getName());
			
			TextView kindship = (TextView)item.findViewById(R.id.Kindship);
			kindship.setText("");
			
			return(item);
		}
    }
}
