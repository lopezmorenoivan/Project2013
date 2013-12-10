package com.example.Logic;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Task implements Serializable{
	private String name;
	private String description;
	private GregorianCalendar date;

	public Task(String name, String description, GregorianCalendar date) {
		super();
		this.name = name;
		this.description = description;
		this.date = date;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public GregorianCalendar getDate() {
		return date;
	}
	public void setDate(GregorianCalendar date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Task [name=" + name + ", description=" + description
				+ ", date=" + date + "]";
	}
}
