package com.example.Model;

import java.util.ArrayList;

import com.example.Logic.Room;

import android.app.Application;

public class RoomsInstance extends Application {
	private static RoomsInstance INSTANCE = null;
	private static ArrayList<Room> rooms= new ArrayList<Room> ();
	 
	public static ArrayList<Room> getRooms() {
		return rooms;
	}

	public static void setRooms(ArrayList<Room> newRooms) {
		rooms = newRooms;
	}

	private RoomsInstance(){}
	 
	private synchronized static void createInstance() {
		if (INSTANCE == null) { 
			INSTANCE = new RoomsInstance();
	    }
	}
	 
	public static RoomsInstance getInstance() {
	    createInstance();
	    return INSTANCE;
	}
}