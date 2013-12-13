package com.example.Logic;

import java.util.Arrays;

public class Room {
	private int id;
	private String name;
	private byte map [];
	private int location;
	
	public Room(String name, byte map [], int location) {
		super();
		this.name = name;
		this.map = map;
		this.location = location;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte [] getMap() {
		return map;
	}
	public void setMap(byte map []) {
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
		return "Room [id=" + id + ", name=" + name + ", map="
				+ Arrays.toString(map) + ", location=" + location + "]";
	}
}
