package Model;

import java.util.ArrayList;
import android.app.Application;
import Logic.User;

public class UsersInstance extends Application {
	private static UsersInstance INSTANCE = null;
	private static ArrayList<User> users= new ArrayList<User> ();
	 
	public static ArrayList<User> getUsers() {
		return users;
	}

	public static void setUsers(ArrayList<User> newUsers) {
		users = newUsers;
	}

	private UsersInstance(){}
	 
	private synchronized static void createInstance() {
		if (INSTANCE == null) { 
			INSTANCE = new UsersInstance();
	    }
	}
	 
	public static UsersInstance getInstance() {
	    createInstance();
	    return INSTANCE;
	}
}