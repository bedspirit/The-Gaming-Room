package com.gamingroom;

public class Entity {

	private long id;
	private String name;
	
	public Entity() {} //default constructor
		
	public Entity(long id, String name) { //constructor id and name
		this.id = id;
		this.name = name;
	}
	
	public long getId() { //accessor id
		return id;
	}
	
	public String getName() {//accessor Name
		return name;
	}
	
	@Override
	public String toString() {//returns a string to console with id and name
		
		return "Entity [id=" + id + ", name=" + name + "]";
	}
	
	

}
