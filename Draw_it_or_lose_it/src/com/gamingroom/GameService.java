package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();//list of active games
	
	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;
	/*
	 * Holds the next player identifier
	 */
	private static long nextPlayerId = 1;
	/*
	 * Holds the next team identifier
	 */
	private static long nextTeamId = 1; 



	//creates new instance of GameService
	private static GameService service = new GameService();

	
	// private constructor so this class cannot be instantiated
	private GameService(){}
	
	//Returns the only object available
	public static GameService getInstance() {
		
		// check if instance already exists
		if(service == null)
			service = new GameService();
		
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

		Iterator<Game> myIterator = games.iterator();

		//I use the iterater to loop through the games
		//comparing the names to the user entered name.   
		//If it finds a match, it breaks out of the loop
		while(myIterator.hasNext()) {
			game = myIterator.next();
			if(game.getName().equals(name)) {
				break;
			}
			game = null;
		}
		
		
		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
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

		Iterator<Game> myIterator = games.iterator();
		
		//I use the iterater to loop through the games
		//comparing the ID to the user entered ID.   
		//If it finds a match, it breaks out of the loop
		
		while(myIterator.hasNext()) {
			game = myIterator.next();
			if(game.getId() == id) {
				break;
			}
			game = null;
		}
		

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

		
		Iterator<Game> myIterator = games.iterator();
		
		//I use the iterater to loop through the games
		//comparing the ID to the user entered ID.   
		//If it finds a match, it breaks out of the loop
		
		while(myIterator.hasNext()) {
			game = myIterator.next();
			if(game.getName().equals(name)) {
				break;
			}
			game = null;
		}

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
	

	public long getNextPlayerId() { //gets next player
		return nextPlayerId++;
	}

	public long getNextTeamId() { //gets next team
		return nextTeamId++;
	}
}
