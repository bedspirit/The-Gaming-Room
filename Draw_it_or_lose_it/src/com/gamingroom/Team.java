package com.gamingroom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity {
	

	private static List<Player> players = new ArrayList<Player>();//list of players

	public Team(long id, String name) {//constructor with id and name
		super(id, name);//this call the Entity class method
	}
	
	public Player addPlayer(String name) {//mutator player by name
		
		// local player instance
		Player player = null;

		Iterator<Player> myIterator = players.iterator();
		
		//I use the iterater to loop through the players
		//comparing the names to the user entered name.   
		//If it finds a match, it breaks out of the loop
		
		while(myIterator.hasNext()) {
			player = myIterator.next();
			if(player.getName().equals(name)) {
				break;
			}
			
			player = null;
		}
		
		// if no player is found, add new player instance to player list
		if(player == null) {
			player = new Player(players.size()+1,name);//sets id to plus one
			players.add(player);
		}
		
		// return player
		return player;
		
	}


	@Override
	public String toString() {
		return "Team [id=" + this.getId() + ", name=" + this.getName() + "]";
	}
}
