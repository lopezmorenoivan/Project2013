package Screens;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

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

	Task first = new Task ("first","do the first thing", 
			new GregorianCalendar(2005, Calendar.DECEMBER, 25));
	Task second = new Task ("second","do the second thing",
			new GregorianCalendar(2005, Calendar.DECEMBER, 25));
	Task third = new Task ("third","do the third thing",
			new GregorianCalendar(2005, Calendar.DECEMBER, 25));
	Task fourth = new Task ("fourth","do the fourth thing",
			new GregorianCalendar(2005, Calendar.DECEMBER, 25));
	Task fifth = new Task ("fifth","do the fifth thing",
			new GregorianCalendar(2005, Calendar.DECEMBER, 25));
	
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
				Task task = (Task) list.getAdapter().getItem(pos);
				AgendaContentFragment fragment = ((AgendaContentFragment)getFragmentManager()
						.findFragmentById(R.id.fragment_agenda_content));
				
				if(getResources().getBoolean(R.bool.isTablet)) {
					fragment.printHead(task.getName());
					fragment.printContent(task.getDescription());
					fragment.printDate(task.getDate());
				}
				else {
					Intent i = new Intent(getActivity().getApplicationContext(), AgendaContentActivity.class);
					Bundle bundle = new Bundle();  
					bundle.putSerializable("task", (Serializable) task);
					i.putExtras(bundle);
					startActivity(i);
				}
			}
		});
	}
	
	class AdapterTasks extends ArrayAdapter<Task> {
    	
    	Activity context;
    	
    	AdapterTasks(Fragment context) {
    		super(context.getActivity(), R.layout.list_view, tasks);
    		this.context = context.getActivity();
    	}
    	
    	public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = context.getLayoutInflater();
			View item = inflater.inflate(R.layout.list_view, null);
			
			TextView name = (TextView)item.findViewById(R.id.FirstLabel);
			name.setText(tasks[position].getName());
			
			TextView kindship = (TextView)item.findViewById(R.id.SecondLabel);
			kindship.setText("");
			
			return(item);
		}
    }
}
