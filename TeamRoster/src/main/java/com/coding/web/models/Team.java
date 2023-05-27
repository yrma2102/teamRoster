package com.coding.web.models;

import java.util.ArrayList;

public class Team {
	private int id;
	private static int count = 0; 
	private String name;
	private ArrayList<Player> playersList;


	public Team(String name) {
		this.name = name;
		this.id = ++count; 
		this.playersList = new ArrayList<Player>();
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

	public ArrayList<Player> getPlayersList() {
		return playersList;
	}

	public void addPlayer(Player p) {
	     this.playersList.add(p);
	}

	
}
