package Model;

import java.util.ArrayList;
import android.app.Application;
import Logic.Room;

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