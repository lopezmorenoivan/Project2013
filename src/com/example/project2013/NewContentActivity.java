package com.example.project2013;

import Logic.New;
import Screens.NewContentFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class NewContentActivity extends FragmentActivity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_content);
		
		New noticia = (New) getIntent().getExtras().getSerializable("new");
		
		NewContentFragment content = (NewContentFragment)getSupportFragmentManager()
					.findFragmentById(R.id.fragment_new_content);
		
		content.printHead(noticia.getTitle());
		content.printContent(noticia.getContent());
		content.printPicture(noticia.getPicture());
	}
}
