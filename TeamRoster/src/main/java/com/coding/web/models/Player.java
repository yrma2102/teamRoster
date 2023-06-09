package com.coding.web.models;

public class Player {
	private int id;
	
	private static int count = 0; 
	private String first_name;
	private String last_name;
	private int age;
	
	public Player(String first_name, String last_name, int age) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
		this.id = ++count; 
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
