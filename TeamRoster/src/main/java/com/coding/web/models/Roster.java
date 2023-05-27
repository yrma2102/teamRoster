package com.coding.web.models;

import java.util.ArrayList;

public class Roster {
	private ArrayList<Team> teamsList;

	public Roster() {
		this.teamsList = new ArrayList<Team>();
	}
	public ArrayList<Team> getTeamsList() {
		return teamsList;
	}

	public void addTeam(Team t) {
	     this.teamsList.add(t);
	}
}
