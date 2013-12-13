package com.example.Model;

import java.util.ArrayList;

import com.example.Logic.User;
import com.example.Tools.Database;

import android.app.Application;

public class UsersInstance extends Application {
	private static UsersInstance INSTANCE = null;
	private static ArrayList<User> users = new ArrayList<User>();
	private static User currentUser;

	public static User getCurrentUser() {
		return currentUser;
	}

	public static void setCurrentUser(User currentUser) {
		UsersInstance.currentUser = currentUser;
	}

	public static ArrayList<User> getUsers() {
		return users;
	}

	public static void setUsers(ArrayList<User> newUsers) {
		users = newUsers;
	}

	private UsersInstance() {
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsersInstance();
		}
	}

	public static UsersInstance getInstance() {
		createInstance();
		return INSTANCE;
	}

	public void create(int idCompany, String name, String surname,
			byte picture[], int privileges, String phone, String office,
			int location, String position, String mail, String password) {
		String query = "INSERT INTO dbo.Employee (" + idCompany + "," + name
				+ "," + surname + "," + privileges + "," + phone + "," + office
				+ "," + location + "," + position + "," + mail + "," + password
				+ "," + picture + ");";
		Database.execute(query);
	}

	public ArrayList<User> read() {
		return Database.readFromUsers(currentUser);
	}

	public void update(User oldU, User newU) {
		String query = "UPDATE dbo.Employee " + " SET name=" + newU.getName()
				+ "surname=" + newU.getSurname() + "privileges="
				+ newU.getPrivileges() + "phone=" + newU.getPhone() + "office="
				+ newU.getOffice() + "location=" + newU.getLocation()
				+ "position=" + newU.getPosition() + "mail=" + newU.getMail()
				+ "password=" + newU.getPassword() + "picture="
				+ newU.getPicture() +

				" WHERE idEmployee=" + oldU.getId() + ";";
		Database.execute(query);
	}

	public void delete(User u) {
		String query = "DELETE FROM dbo.Employee WHERE idEmployee=" + u.getId()
				+ ";";
		Database.execute(query);
	}
}