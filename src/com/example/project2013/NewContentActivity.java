package com.example.project2013;

import com.example.Logic.New;
import com.example.Screens.NewContentFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class NewContentActivity extends FragmentActivity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_content);
		
		New noticia = (New) getIntent().getExtras().getSerializable("new");
		
		NewContentFragment fragment = (NewContentFragment)getSupportFragmentManager()
					.findFragmentById(R.id.fragment_new_content);
		
		fragment.printTitle(noticia.getTitle());
		fragment.printHead(noticia.getTitle());
		fragment.printContent(noticia.getContent());
		fragment.printPicture(noticia.getPicture());
	}
}
