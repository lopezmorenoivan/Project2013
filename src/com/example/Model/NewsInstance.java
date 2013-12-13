package com.example.Model;

import java.util.ArrayList;

import com.example.Logic.New;
import com.example.Logic.User;
import com.example.Tools.Database;

import android.app.Application;

public class NewsInstance extends Application {
	private static NewsInstance INSTANCE = null;
	private static ArrayList<New> news = new ArrayList<New>();

	public static ArrayList<New> getNews() {
		return news;
	}

	public static void setNews(ArrayList<New> newNews) {
		news = newNews;
	}

	private NewsInstance() {
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new NewsInstance();
		}
	}

	public static NewsInstance getInstance() {
		createInstance();
		return INSTANCE;
	}

	// @matt
	// same for news id, much better for update/delete
	// BTW, news takes an S even at the singular form, (e.g. a news story) ;)
	public void create(String title, String content, String description,
			byte picture[], User user) {
		String query = "INSERT INTO dbo.News ((SELECT idCompany FROM dbo.Employee WHERE idEmployee="
				+ user.getId()
				+ "),"
				+ title
				+ ","
				+ content
				+ ","
				+ description + "," + picture + ");";
		Database.execute(query);
	}

	public ArrayList<New> read(User currentUser) {
		return Database.readFromNews(currentUser);
	}

	// same conditions for old and new elts
	public void update(New oldN, New newN, User u) {
		String query = "UPDATE dbo.News "
				+ " SET title="
				+ newN.getTitle()
				+ ",content="
				+ newN.getContent()
				+ ",description="
				+ newN.getDescription()
				+ ",picture="
				+ newN.getPicture()
				+ " WHERE idCompany=(SELECT idCompany FROM dbo.Employee WHERE idEmployee="
				+ u.getId() + "), title=" + oldN.getTitle() + ",content="
				+ oldN.getContent() + ",description=" + oldN.getDescription()
				+ ",picture=" + oldN.getPicture() + ";";
		Database.execute(query);
	}

	public void delete(New news, User u) {
		String query = "DELETE FROM dbo.News WHERE idCompany=(SELECT idCompany FROM dbo.Employee WHERE idEmployee="
				+ u.getId()
				+ "), title="
				+ news.getTitle()
				+ ",content="
				+ news.getContent()
				+ ",description="
				+ news.getDescription()
				+ ",picture=" + news.getPicture() + ";";
		Database.execute(query);
	}
}