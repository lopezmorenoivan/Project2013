package Screens;

import java.util.GregorianCalendar;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project2013.R;

public class AgendaContentFragment extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, 
			                 ViewGroup container, 
			                 Bundle savedInstanceState) {
		
		return inflater.inflate(R.layout.fragment_agenda_content, container, false);
	}
	
	public void printContent(String text) {
		TextView agendaContent = (TextView)getView().findViewById(R.id.AgendaContent);
		agendaContent.setText(text);
	}
	
	public void printHead (String text) {
		TextView agendaHead = (TextView)getView().findViewById(R.id.AgendaHead);
		agendaHead.setText(text);
	}
	
	public void printDate (GregorianCalendar date) {
		TextView agendaDate = (TextView)getView().findViewById(R.id.AgendaDate);
		
		agendaDate.setText("Day: " + date.DAY_OF_MONTH + "/" + date.MONTH + 
						   "/" + date.YEAR + " at " + date.HOUR + ":" + date.MINUTE);
	}
}