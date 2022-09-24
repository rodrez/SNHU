package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires an id and name to be passed
 * when creating. Also note that no mutators (setters) defined so these values
 * cannot be changed once a game is created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
// Create a Game class that inherit from superclass Entity.
// The Game class should hold information about the game's name,

public class Game extends Entity {
	long id;
	String name;

	// A list of active teams
	private List<Team> teams = new ArrayList<Team>();

	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		super(id, name);
	}

	/**
	 * 
	 * @param id
	 * @param name
	 */

	// Construct a new team
	public Team addTeam(String name) {
		// a local team instance
		Team team = null;

		// create a new team with the given name
		team = new Team(id, name);

		for (int i = 0; i < teams.size(); ++i) {
			if (name.equalsIgnoreCase(teams.get(i).getName())) {
				team = teams.get(i);
			}
		}
		// if not found, make a new team instance and add to list of teams
		if (team == null) {
			team = new Team((long) teams.size(), name);
			teams.add(team);
		}
		// return the team
		return team;
	}

	@Override
	public String toString() {

		return "Game [id=" + id + ", name=" + name + "]";
	}

}
