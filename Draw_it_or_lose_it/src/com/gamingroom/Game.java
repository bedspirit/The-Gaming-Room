package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity {
	
	private static List<Team> teams = new ArrayList<Team>();//list of teams
	

	/**
	 * Constructor with an identifier and name
	 */
	
	public Game(long id, String name) {  //constructor for Game by id and name
		super(id, name); //this calls the Entity method class
	}

	public Team addTeam(String name) {
			
		// local player instance
		Team team = null;	

		Iterator<Team> myIterator = teams.iterator();
			
		//I use the iterator to loop through the teams
		//comparing the names to the user entered name.   
		//If it finds a match, it breaks out of the loop
		
		while(myIterator.hasNext()) {
			team = myIterator.next();
			if(team.getName().equals(name)) {
				break;
			}
				
			team = null;
		}
			
		// if no team is found, add new team instance to teams list
		if(team == null) {
			team = new Team(teams.size()+1,name);
			teams.add(team);
		}
			
		// return team
		return team;
			
		}

	@Override
	public String toString() {
		
		return "Game [id=" + this.getId() + ", name=" + this.getName() + "]";
	}

}
