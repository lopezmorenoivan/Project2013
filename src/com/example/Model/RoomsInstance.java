package com.example.Model;

import java.util.ArrayList;

import com.example.Logic.Room;
import com.example.Logic.User;
import com.example.Tools.Database;

import android.app.Application;

public class RoomsInstance extends Application {
	private static RoomsInstance INSTANCE = null;
	private static ArrayList<Room> rooms = new ArrayList<Room>();

	public static ArrayList<Room> getRooms() {
		return rooms;
	}

	public static void setRooms(ArrayList<Room> newRooms) {
		rooms = newRooms;
	}

	private RoomsInstance() {
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new RoomsInstance();
		}
	}

	public static RoomsInstance getInstance() {
		createInstance();
		return INSTANCE;
	}

	public void create(String idRoom, String idCompany, byte map[],
			String name, int location) {
		String query = "INSERT INTO dbo.Room (" + idRoom + "," + idCompany
				+ "," + map + "," + location + "," + name + ");";
		Database.execute(query);
	}

	public ArrayList<Room> read(User currentUser) {
		return Database.readFromRoom(currentUser);
	}

	public void update(Room oldR, Room newR) {
		String query = "UPDATE dbo.Room " + " SET name=" + newR.getName()
				+ ",map=" + newR.getMap() + ",location=" + newR.getLocation()
				+ " WHERE name=" + oldR.getName() + ",map=" + oldR.getMap()
				+ ",location=" + oldR.getLocation() + ";";
		Database.execute(query);
	}

	public void delete(Room room) {
		String query = "DELETE FROM dbo.Room WHERE name=" + room.getName()
				+ ",map=" + room.getMap() + ",location=" + room.getLocation()
				+ ";";
		Database.execute(query);
	}
}