package com.example.Model;

import java.util.ArrayList;

import com.example.Logic.New;

import android.app.Application;

public class NewsInstance extends Application {
	private static NewsInstance INSTANCE = null;
	private static ArrayList<New> news= new ArrayList<New> ();
	 
	public static ArrayList<New> getNews() {
		return news;
	}

	public static void setNews(ArrayList<New> newNews) {
		news = newNews;
	}

	private NewsInstance(){}
	 
	private synchronized static void createInstance() {
		if (INSTANCE == null) { 
			INSTANCE = new NewsInstance();
	    }
	}
	 
	public static NewsInstance getInstance() {
	    createInstance();
	    return INSTANCE;
	}
}