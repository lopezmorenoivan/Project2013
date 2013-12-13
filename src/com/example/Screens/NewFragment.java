package com.example.Screens;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
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

import com.example.Logic.New;
import com.example.Model.NewsInstance;
import com.example.Tools.BitmapUtil;
import com.example.project2013.R;

@SuppressLint("NewApi")
public class NewFragment extends Fragment {
	protected static final int RESULT_LOAD_IMAGE = 1;
	ArrayList<New> news = NewsInstance.getInstance().getNews();
	private byte picture [];
	
	@Override
	public View onCreateView(LayoutInflater inflater, 
			                 ViewGroup container, 
			                 Bundle savedInstanceState) {
		
		getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);

		return inflater.inflate(R.layout.fragment_new, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle state) {
		super.onActivityCreated(state);
		
		setHasOptionsMenu(true);
		
		ImageView image = (ImageView) getView().findViewById(R.id.new_image);

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
	         
	         ImageView image = (ImageView) getView().findViewById(R.id.new_image);
	         image.setImageBitmap(BitmapFactory.decodeFile(picturePath));
	         
	         this.picture = BitmapUtil.bitmapToByteArray(BitmapFactory.decodeFile(picturePath));
	     }
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId()!=android.R.id.home) {
				news.add(getNew());
		}
		
		NavUtils.navigateUpFromSameTask(this.getActivity());
		
        return true;
	}
	public void printTitle (String title) {
		getActivity().getActionBar().setTitle(title);
	}
	
	public void printContent(String text) {
		TextView newContent = (TextView)getView().findViewById(R.id.new_content);
		newContent.setText(text);
	}
	
	public void printHead (String text) {
		TextView newHead = (TextView)getView().findViewById(R.id.new_title);
		newHead.setText(text);
	}
	
	public void printPicture (byte picture []) {
		ImageView image = (ImageView) getView().findViewById(R.id.new_image);
		
		this.picture = picture;
		
		if (picture != null) {
			image.setImageBitmap(BitmapUtil.byteArrayToBitmap(picture));
		}
			//image.setImageBitmap(BitmapUtil.getBitMapFromString(BitmapUtil.convertBitmapToString(BitmapUtil.drawableToBitmap(getResources().
			//		getDrawable(android.R.drawable.ic_menu_help)))));
		//}
		
	}
	
	public void printDescription(String text) {
		TextView newDescription = (TextView)getView().findViewById(R.id.new_description);
		newDescription.setText(text);
	}
	
	public New getNew () {
		TextView newContent = (TextView)getView().findViewById(R.id.new_content);
		TextView newHead = (TextView)getView().findViewById(R.id.new_title);
		TextView newDescription = (TextView)getView().findViewById(R.id.new_description);
		
		return new New(newHead.getText().toString(), newContent.getText().toString(),
				newDescription.getText().toString(), picture);
	}
}