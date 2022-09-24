package com.gamingroom;

import java.util.ArrayList;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires an id and name to be passed
 * when creating. Also note that no mutators (setters) defined so these values
 * cannot be changed once a team is created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity {

	// A list of active players on the team
	private static ArrayList<Player> players = new ArrayList<Player>();
	// The team's id

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param name
	 */
	public Team(long id, String name) {
		super(id, name);
	}

	/**
	 * Construct a new team instance with
	 * 
	 * @param id
	 * @param name
	 */
	public Player addPlayer(long id, String name) {
		// Local variable to store the new player
		Player newPlayer = null;

		// search through the teams if the team name exist return it.
		for (Player player : players) {
			if (player.getName().equals(name)) {
				return player;
			}
		}

		// If does not exist, create a new team and add it to the
		// team list
		if (newPlayer == null) {
			newPlayer = new Player((long) players.size(), name);
			players.add(newPlayer);
			}
		return newPlayer;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + "]";
	}
}
