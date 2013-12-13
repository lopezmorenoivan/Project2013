package com.example.Screens;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.Tools.BitmapUtil;
import com.example.project2013.R;

@SuppressLint("NewApi")
public class NewContentFragment extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, 
			                 ViewGroup container, 
			                 Bundle savedInstanceState) {

		getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);

		return inflater.inflate(R.layout.fragment_new_content, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle state) {
		super.onActivityCreated(state);
		
		setHasOptionsMenu(true);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		NavUtils.navigateUpFromSameTask(this.getActivity());
        return true;
	}
	
	public void printTitle (String title) {
		getActivity().getActionBar().setTitle(title);
	}
	
	public void printContent(String text) {
		TextView newContent = (TextView)getView().findViewById(R.id.NewContent);
		newContent.setText(text);
	}
	
	public void printHead (String text) {
		TextView newHead = (TextView)getView().findViewById(R.id.NewHead);
		newHead.setText(text);
	}
	
	public void printPicture (byte picture []) {
		ImageView image = (ImageView) getView().findViewById(R.id.NewImage);
		if (picture == null) {
			image.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_menu_help));
		} else {
			image.setImageBitmap(BitmapUtil.byteArrayToBitmap(picture));
		}

	}
}