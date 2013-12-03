package com.example.project2013;

public class Character {
	
	private String name;
	private String description;
	private String kindship;
	
	public Character(String name, String description, String kindship) {
		super();
		this.name = name;
		this.description = description;
		this.setKindship(kindship);
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

	public String getKindship() {
		return kindship;
	}

	public void setKindship(String kindship) {
		this.kindship = kindship;
	}
	
	@Override
	public String toString() {
		return "Character [name=" + name + ", description=" + description + 
				", kindship=" + kindship + "]";
	}
}
