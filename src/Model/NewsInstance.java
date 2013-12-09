package Model;

import java.util.ArrayList;
import android.app.Application;
import Logic.New;

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