package com.example.project2013;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;

import com.example.Logic.New;
import com.example.Logic.User;
import com.example.Screens.ContactFragment;
import com.example.Screens.NewFragment;


public class UpdateNewActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		/*
		Bundle bundle=new Bundle();
		bundle.putSerializable("noticia",(Serializable)noticia);
		fragment.setArguments(bundle);
		*/
		setContentView(R.layout.activity_update_new);

		NewFragment fragment = (NewFragment)getSupportFragmentManager()
				.findFragmentById(R.id.fragment_new);
	
		New noticia = (New) getIntent().getExtras().getSerializable("noticia");

		fragment.printHead(noticia.getTitle());
		fragment.printDescription(noticia.getDescription());
		fragment.printContent(noticia.getContent());
		fragment.printPicture(noticia.getPicture());
		fragment.printTitle("Update New");
	}
	

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.add_update, menu);

		return true;
	}
}