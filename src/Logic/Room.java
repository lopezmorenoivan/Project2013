package Logic;

import android.graphics.Bitmap;

public class Room {
	private String name;
	private Bitmap map;
	private int location;
	
	public Room(String name, Bitmap map, int location) {
		super();
		this.name = name;
		this.map = map;
		this.location = location;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Bitmap getMap() {
		return map;
	}
	public void setMap(Bitmap map) {
		this.map = map;
	}
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "Room [name=" + name + ", map=" + map + ", location=" + location
				+ "]";
	}
}
