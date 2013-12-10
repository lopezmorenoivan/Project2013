package com.example.Logic;

import java.io.Serializable;

import android.graphics.Bitmap;

public class User implements Serializable {
	private int id;
	private String name;
	private String surname;
	private Bitmap picture;
	private int privileges;
	private String phone;
	private String office;
	private int location;
	private String position;
	private String mail;
	
	//this field is hear due to the DB necessities :(
	private String password;
	
	public User(String name, String surname, Bitmap picture,
			int privileges, String phone, String office, int location,
			String position, String mail, String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.picture = picture;
		this.privileges = privileges;
		this.phone = phone;
		this.office = office;
		this.location = location;
		this.position = position;
		this.mail = mail;
		this.password = password;
	}
	
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Bitmap getPicture() {
		return picture;
	}
	public void setPicture(Bitmap picture) {
		this.picture = picture;
	}
	public int getPrivileges() {
		return privileges;
	}
	public void setPrivileges(int privileges) {
		this.privileges = privileges;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [ID=" + id + ", name=" + name + ", surname=" + surname
				+ ", privileges=" + privileges + ", phone=" + phone
				+ ", office=" + office + ", location=" + location
				+ ", position=" + position + ", mail=" + mail +
				", password=" + password + "]";
	}
}
