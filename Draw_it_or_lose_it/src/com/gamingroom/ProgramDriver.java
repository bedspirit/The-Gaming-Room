package com.gamingroom;

/**
 * Application start-up program
 * 
 * @author coce@snhu.edu
 */
public class ProgramDriver {
	
	/**
	 * The one-and-only main() method
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		// FIXME: obtain reference to the singleton instance
		GameService service = GameService.getInstance(); // replace null with ???
//
		GameService.getInstance();
		System.out.println("\nAbout to test initializing game data...");
		/*
		 * Testing creating multiple games
		 */
		Game game1 = service.addGame("Game #1");
		System.out.println(game1);
		
		Game game2 = service.addGame("Game #2"); 
		System.out.println(game2);
		
		Game game3 = service.addGame("Game #3");
		System.out.println(game3);
	
		// Test running second instance of Game 3
		// It should return same game rather than new one
		Game game4 = service.addGame("Game #3");
		System.out.println(game4);
		
		
		// Print out all the existing games
		// use another class to prove there is only one instance
		SingletonTester tester = new SingletonTester();
		tester.testSingleton();
		
		System.out.println("\n\n");
		
		/*
		 * Testing creating multiple teams
		 */
		System.out.println("\nAbout to test initializing team data...");
		System.out.println(service.getGame(0).addTeam("TeamFortress"));
		System.out.println(service.getGame(0).addTeam("TeamFortressTwo"));
		System.out.println(service.getGame(0).addTeam("HalfLIfeThree"));
		//Attempting to create a team that already exists with the same name
		// it will just return the already existing team
		System.out.println(service.getGame(0).addTeam("HalfLIfeThree"));
		
		
		System.out.println("\n\n");
		
		/*
		 * Test creating multiple players
		 */
			
		System.out.println("\nAbout to test initializing player data...");
		System.out.println(service.getGame(0).addTeam("TeamFortress").addPlayer("Scout").toString());
		System.out.println(service.getGame(0).addTeam("TeamFortressTwo").addPlayer("Pyro").toString());
		System.out.println(service.getGame(0).addTeam("HalfLifeThree").addPlayer("Gordan").toString());
		
		//add new team and player
		System.out.println(service.getGame(0).addTeam("HalfLife").addPlayer("Alyx").toString());

		//test adding duplicate player on same team
		System.out.println(service.getGame(0).addTeam("HalfLife").addPlayer("Alyx").toString()); 
		
		//test adding duplicate player on different team
		System.out.println(service.getGame(0).addTeam("HalfLifeTwo").addPlayer("Alyx").toString()); 
		


		
	}
}
