package com.example.Screens;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.Logic.User;
import com.example.Model.UsersInstance;
import com.example.Tools.BitmapUtil;
import com.example.project2013.R;

@SuppressLint("NewApi")
public class ContactFragment extends Fragment {
	private static final int RESULT_LOAD_IMAGE = 2;
	private ArrayList<User> users = UsersInstance.getInstance().getUsers();
	private byte picture []=null;
	
	@Override
	public View onCreateView(LayoutInflater inflater, 
			                 ViewGroup container, 
			                 Bundle savedInstanceState) {
		getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);

		return inflater.inflate(R.layout.fragment_contact, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle state) {
		super.onActivityCreated(state);
		
		setHasOptionsMenu(true);

		ImageView image = (ImageView) getView().findViewById(R.id.contact_picture);
		image.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            	Intent i = new Intent(
            	Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            	startActivityForResult(i, RESULT_LOAD_IMAGE);

            }
        });

	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
	     super.onActivityResult(requestCode, resultCode, data);
	      
	     if (requestCode == RESULT_LOAD_IMAGE && null != data) {
	         Uri selectedImage = data.getData();
	         String[] filePathColumn = { MediaStore.Images.Media.DATA };
	 
	         Cursor cursor = getActivity().getContentResolver().query(selectedImage,
	                 filePathColumn, null, null, null);
	         cursor.moveToFirst();
	 
	         int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
	         String picturePath = cursor.getString(columnIndex);
	         cursor.close();
	         
	         ImageView image = (ImageView) getView().findViewById(R.id.contact_picture);
	         image.setImageBitmap(BitmapFactory.decodeFile(picturePath));
	         
	         this.picture = BitmapUtil.bitmapToByteArray(BitmapFactory.decodeFile(picturePath));
	     }
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId()!=android.R.id.home) {
				users.add(getUser());
		}
		
		NavUtils.navigateUpFromSameTask(this.getActivity());
		
        return true;
	}
	
	public void printTitle (String title) {
		getActivity().getActionBar().setTitle(title);
	}
	
	public void printName(String text) {
		TextView message = (TextView)getView().findViewById(R.id.contact_name);

		message.setText(text);
	}
	
	public void printSurname(String text) {
		TextView message = (TextView)getView().findViewById(R.id.contact_surname);

		message.setText(text);
	}

	public void printPosition(String text) {
		TextView message = (TextView)getView().findViewById(R.id.contact_position);

		message.setText(text);
	}

	public void printMail(String text) {
		TextView message = (TextView)getView().findViewById(R.id.contact_mail);

		message.setText(text);
	}

	public void printPhone(String text) {
		TextView message = (TextView)getView().findViewById(R.id.contact_phone);

		message.setText(text);
	}

	public void printOffice(String text) {
		TextView message = (TextView)getView().findViewById(R.id.contact_office);

		message.setText(text);
	}
	
	public void printPrivileges(int number) {
		TextView message = (TextView)getView().findViewById(R.id.contact_privileges);

		message.setText(String.valueOf(number));
	}

	public void printPicture (byte picture []) {
		ImageView image = (ImageView) getView().findViewById(R.id.contact_picture);

		this.picture = picture;
		
		if (picture != null) {
			image.setImageBitmap(BitmapUtil.byteArrayToBitmap(picture));
		}
	}
	
	public User getUser () {
		TextView name = (TextView)getView().findViewById(R.id.contact_name);
		TextView surname = (TextView)getView().findViewById(R.id.contact_surname);
		TextView position = (TextView)getView().findViewById(R.id.contact_position);
		TextView mail = (TextView)getView().findViewById(R.id.contact_mail);
		TextView phone = (TextView)getView().findViewById(R.id.contact_phone);
		TextView office = (TextView)getView().findViewById(R.id.contact_office);
		TextView privileges = (TextView)getView().findViewById(R.id.contact_privileges);

		if (privileges.getText().toString().equals("")) {
			return new User (name.getText().toString(), surname.getText().toString(),
					picture, 0,phone.getText().toString(), office.getText().toString(),0,
					position.getText().toString(), mail.getText().toString(),"");
		} else {
			return new User (name.getText().toString(), surname.getText().toString(),
					picture, Integer.valueOf(privileges.getText().toString()), 
					phone.getText().toString(), office.getText().toString(),0,
					position.getText().toString(), mail.getText().toString(),"");
		}
		
		
		
	}
}