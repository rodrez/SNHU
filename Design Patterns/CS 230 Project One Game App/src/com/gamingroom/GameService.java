package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */

public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	// Holds the next game identifier
	private static int nextGameId = 0;	
	
	// Holds the next team identifier
	private static int nextTeamId = 0;

	// Holds the next player identifier
	private static int nextPlayerId = 0;


	
	// FIXME: Add missing pieces to turn this class a singleton 
	private static GameService service = new GameService();
	

	/*
	* The private constructor is normal for a Singleton to avoid
	* additional instances outside of the class.
	* */
	private GameService(){

	}

	// Public accessor. Allows classes to access the singleton class from outside.
	public static GameService getInstance() {
		return service;
	}

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		// FIXME: Use iterator to look for existing game with same name FIXED
		// if found, simply return the existing instance
		for (Game g : games) {
			if (g.getName().equals(name)) {
				game = g;
				break;
			}
		}
		// if not found, create a new game instance
		if (game == null) {
			game = new Game(getNextGameId(), name);
			games.add(game);
		}
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		// FIXME: Use iterator to look for existing game with same id
		// if found, simply assign that instance to the local variable
		for (Game g : games) {
			if (g.getId() == id) {
				game = g;
				break;
			}
		}
		// if not found, return null
		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// FIXME: Use iterator to look for existing game with same name
		// if found, simply assign that instance to the local variable
		for (Game g : games) {
			if (g.getName().equals(name)) {
				game = g;
				break;
			}
		}
		// if not found, return null
		return game;
	}
	
	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}

	/**
	 * 	Get the next game identifier
	 * 	@return the next game identifier
	 */
	public static int getNextGameId() {
		return nextGameId++;
	}

	/**
	 * 	Get the next team identifier
	 * 	@return the next team identifier
	 */
	public static int getNextTeamId() {
		return nextTeamId++;
	}
	
	/**
	 * 	Get the next player identifier
	 * 	@return the next player identifier
	 */
	public static int getNextPlayerId() {
		return nextPlayerId++;
	}

}