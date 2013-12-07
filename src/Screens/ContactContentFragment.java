package Screens;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        
        public void printName(String text) {
                TextView message = (TextView)getView().findViewById(R.id.ContactName);
                
                message.setText(text);
        }
        
        public void printPosition(String text) {
            TextView message = (TextView)getView().findViewById(R.id.ContactPosition);
            
            message.setText(text);
        }
        
        public void printMail(String text) {
            TextView message = (TextView)getView().findViewById(R.id.ContactMail);
            
            message.setText(text);
        }
        
        public void printPhone(String text) {
            TextView message = (TextView)getView().findViewById(R.id.ContactPhone);
            
            message.setText(text);
        }
        
        public void printOffice(String text) {
            TextView message = (TextView)getView().findViewById(R.id.ContactOffice);
            
            message.setText(text);
        }
        
        public void printPicture (Bitmap picture) {
    		ImageView image = (ImageView) getView().findViewById(R.id.ContactPicture);
    		
    		image.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_menu_help));
    	}
        
        public void printLocation (int location) {
        	//query against the db
        	
        	
    		ImageView image = (ImageView) getView().findViewById(R.id.ContactLocation);
    		
    		image.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_menu_help));
    	}
}