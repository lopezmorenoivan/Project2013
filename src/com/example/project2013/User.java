package com.example.project2013;

public class User {
	private int id;
	private String name;
	private String surname;
	private int privileges;
	private String phone;
	private String office;
	private int location;
	private String position;
	private String mail;
	
	public User(int id, String name, String surname, int privileges,
			String phone, String office, int location, String position,
			String mail) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.privileges = privileges;
		this.phone = phone;
		this.office = office;
		this.location = location;
		this.position = position;
		this.mail = mail;
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
	
	@Override
	public String toString() {
		return "User [ID=" + id + ", name=" + name + ", surname=" + surname
				+ ", privileges=" + privileges + ", phone=" + phone
				+ ", office=" + office + ", location=" + location
				+ ", position=" + position + ", mail=" + mail + "]";
	}
}
