package Screens;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.project2013.R;
import com.example.project2013.R.id;
import com.example.project2013.R.layout;

public class ContactContentFragment extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, 
			                 ViewGroup container, 
			                 Bundle savedInstanceState) {
		
		return inflater.inflate(R.layout.fragment_contact_content, container, false);
	}
	
	public void printMessage(String text) {
		TextView message = (TextView)getView().findViewById(R.id.Content);
		
		message.setText(text);
	}
}