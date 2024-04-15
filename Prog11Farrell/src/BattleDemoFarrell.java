import java.io.*;
import java.util.*;
/**
 * Christian Farrell
 * @author Christian Farrell <br>
 * 
 * Prog 11 <br>
 * Due Date and Time: 4/22/24 before 9:00 AM <br>
 * 
 * Purpose: This Program is a Pokemon Card Battle Game in which players are drawn cards from a deck and fight until one player has no cards left<br>
 * 
 * Input: fileName <br>
 * 
 * Output: numCards, numTurns, player1Count, player2Count, Winner <br>
 * 
 * Certification of Authenticity: <br>
 * I certify that this lab is entirely my own work. <br>
 */
public class BattleDemoFarrell {
	
	/**
	 * Keyboard Scanner to read in user inputs
	 */
	static Scanner keyboard = new Scanner(System.in);
	/**
	 * boolean to toggle Debug Mode
	 */
	public static final boolean DEBUG = true;
	
	/**
	 * Empty Constructor to please JavaDoc
	 */
	public BattleDemoFarrell() {
	}//PokeArmyDemoFarrell
	
	/**
	 * Main Method to Run our Battle Simulation
	 * @param args	ConsoleLineInput
	 */
	public static void main(String[] args) {
		
		//Initialize Variables
		String fileName = null;
		StackFarrell playerOnePlay = new StackFarrell();
		StackFarrell playerOneDiscard = new StackFarrell();
		StackFarrell playerTwoPlay = new StackFarrell();
		StackFarrell playerTwoDiscard = new StackFarrell();
		PokemonCardFarrell playerOneCard;
		PokemonCardFarrell playerTwoCard;
		int turnCounter = 0;
		String winner = "";
		int playerOneCount = 0;
		int playerTwoCount = 0;
		int numItems = 0;
		int win = 0;
	
		//Error check for File Reading and Prompt if Invalid
	    do {
	    	//ask the user for the path and name to the file
		    System.out.print("Enter a valid filename: ");
		    fileName = keyboard.next();
		    numItems = deal(fileName,playerOnePlay,playerTwoPlay);
	    }//do
	    while(numItems < 1);
	    
	    //Game Loop checks if one player has both their decks as empty or if there has been more than 1000 turns
		while(((!playerOnePlay.isEmpty() || !playerOneDiscard.isEmpty()) && (!playerTwoPlay.isEmpty() || !playerTwoDiscard.isEmpty())) && turnCounter < 1000) {
			
			//Check Deck Status
			//if Play is empty we copy the discard
			if(playerOnePlay.isEmpty()) {
				copy(playerOnePlay, playerOneDiscard);
				if(DEBUG)
					System.out.println("Copied Player 1 Discard Cards");
			}//if
			if(playerTwoPlay.isEmpty()) {
				copy(playerTwoPlay, playerTwoDiscard);
				if(DEBUG)
					System.out.println("Copied Player 2 Discard Cards");
			}//if
			
			//Draw Cards from top of Play Stack
			playerOneCard = play(playerOnePlay);
			playerTwoCard = play(playerTwoPlay);
			if(DEBUG)
				System.out.println("Player 1 Draws \n" + playerOneCard + "\nPlayer 2 Draws \n" + playerTwoCard);
			
			//Compare Cards to Determine Winner
			win = compare(playerOneCard,playerTwoCard);
			if(DEBUG)
				System.out.println("The Turn Result is " + win);
			
			//Dish out the Cards to the Winning Party
			winPlay(playerOneCard,playerTwoCard,playerOneDiscard,playerTwoDiscard,win);
			
			//Increment Turn Counter
			turnCounter++;
		}//while
		
		//Determine Winner
		winner = determineWinner(playerOnePlay, playerOneDiscard, turnCounter);
		
		//update players total card holdings by counting both decks
		playerOneCount = count(playerOnePlay) + count(playerOneDiscard);
		playerTwoCount = count(playerTwoPlay) + count(playerTwoDiscard);
		
		//print game results to the console
		printResults(numItems, turnCounter, playerOneCount, playerTwoCount, winner);
	    
	}//main
	
	/**
	 * Deal Method to accept a fileName and then read in its contents, creating and dealing Pokemon Cards to Both Players
	 * @param fileName	The fileName to be Read in
	 * @param p1Play	Player One's Playing Deck
	 * @param p2Play	Player Two's Playing Deck
	 * @return numPokes	The Number of Pokemon Cards in Rotation
	 */
	public static int deal(String fileName, StackFarrell p1Play, StackFarrell p2Play) {
    	
		//instance variables
		File inputFile = new File(fileName);
		int numPokes = 0;
		String newName = "";
		int newMultiplier = 0;
		double newPower = 0.0;
		int drawCount = 0;
		PokemonCardFarrell newPoke;
		
		//Attempt to read in the string and catch any errors if unsuccessful
	    try { 
		    //Create a second Scanner object, this one for reading from the file
		    Scanner input = new Scanner(inputFile);
		    
		    //Read first line of the file to find out how many Cards will follow.
		    numPokes = input.nextInt();
		    
		    //loop through items determined from first line of file
		    while(drawCount < numPokes)
		    {
		    	//read in data and create the Card
		    	newName = input.next();
		    	newMultiplier = input.nextInt();
		    	newPower = input.nextDouble();
		    	newPoke = new PokemonCardFarrell(newName, newMultiplier, newPower);
		    	
		    	//Deal the Cards to Both Players Evenly
		    	
		    	//Give to player 1
		    	if(drawCount % 2 == 0) 
		    		p1Play.push(newPoke);
		    	//Give to player 2
		    	else
		    		p2Play.push(newPoke);
		    	
		    	//Increment Draw Count
		    	drawCount++;
		    }//while
	    }//try
	    
	    //Catch Errors in Reading in File
	    catch(FileNotFoundException ex)
	    {
	      System.out.println("Failed to find file: " + inputFile.getAbsolutePath()); 
	    }//catch
	    catch(InputMismatchException ex)
	    {
	    	System.out.println("Type mismatch for the number I just tried to read.");
	        System.out.println(ex.getMessage());
	    }//catch
	    catch(NumberFormatException ex)
	    {
	      System.out.println("Failed to convert String text into an integer value.");
	      System.out.println(ex.getMessage());
	    }//catch
	    catch(NullPointerException ex)
	    {
	      System.out.println("Null pointer exception.");
	      System.out.println(ex.getMessage());
	    }//catch
	    catch(Exception ex)
	    {
	      // Like an "else" catch(Exception should come last as the catchall.
	    	System.out.println("Something went wrong");
	      ex.printStackTrace();
	    }//catch
	    
	    return numPokes;
    }//deal
	
	/**
	 * play Method to pop the top card of the stack to be played
	 * @param playStack	The Stack to Draw a Card From
	 * @return	PokemonCardFarrell	The Card That Was at the Top of the Stack
	 */
	public static PokemonCardFarrell play(StackFarrell playStack) {return playStack.pop();}//play
	
	/**
	 * compare Method to compare two PokemonCardFarrell Objects and determine which is stronger or if they're equal
	 * @param cardOne	Player 1's Card
	 * @param cardTwo	Player 2's Card
	 * @return result	The Result of the Comparison; 0->tie, 1->p1wins, 2->p2wins
	 */
	public static int compare(PokemonCardFarrell cardOne, PokemonCardFarrell cardTwo) {
		//instance variables
		int result = 0;
		double playerOnePower = cardOne.getPower();
		double playerTwoPower = cardTwo.getPower();
		int playerOneMultiplier = cardOne.getMultiplier();
		int playerTwoMultiplier = cardTwo.getMultiplier();
		
		//Check if equal
		if(playerOnePower == playerTwoPower) {
			//Battle is determined by the multiplier values
			if(playerOneMultiplier == playerTwoMultiplier) 
				result = 0;
			else if(playerOneMultiplier > playerTwoMultiplier)
				result = 1;
			else
				result = 2;
		}//if
		else if(playerOnePower > playerTwoPower) 
			result = 1;
		else 
			result = 2;
		
		//returns 1 -> Player One Wins; 2 -> Player Two Wins; 0 -> Tie 
		return result;
	}//compare
	
	/**
	 * winPlay Method to Process the Comparison Result and Distribute the Cards Accordingly
	 * @param CardOne	Player 1's Card
	 * @param CardTwo	Player 2's Card
	 * @param p1Stack	Player 1's Discard Stack
	 * @param p2Stack	Player 2's Discard Stack
	 * @param winStatus	The Result of the Comparison
	 */
	public static void winPlay(PokemonCardFarrell CardOne, PokemonCardFarrell CardTwo, StackFarrell p1Stack, StackFarrell p2Stack, int winStatus) {
		//Push According to winStatus result
		switch(winStatus) {
		case 0: //tie
			p1Stack.push(CardOne);
			p2Stack.push(CardTwo);
			if(DEBUG)
				System.out.println("It was a tie, both players are returned their cards \n");
			break;
		case 1: //p1 wins
			p1Stack.push(CardOne);
			p1Stack.push(CardTwo);
			if(DEBUG)
				System.out.println("Player 1 Wins Both Cards \n");
			break;
		case 2: //p2 wins
			p2Stack.push(CardTwo);
			p2Stack.push(CardOne);
			if(DEBUG)
				System.out.println("Player 2 Wins Both Cards \n");
			break;
		}//switch
	}//winPlay
	
	/**
	 * determineWinner method to Determine the Overall Game Winner Once Game Cycle has Concluded
	 * @param p1Play	Player 1's Play Deck
	 * @param p1Discard	Player 1's Discard Deck
	 * @param turns	The Total Turns the Game Too
	 * @return winner	A String Representing the Winner of the Game	
	 */
	public static String determineWinner(StackFarrell p1Play, StackFarrell p1Discard, int turns) {
		//Instance Variables
		String winner = "No One";
		//determine if the turns exceeded the alloted amount
		if(turns != 1000)
		{
			//Using only player 1's decks we can deduce the Winner of the Game
			if(p1Play.isEmpty() && p1Discard.isEmpty()) {
				winner = "Player 2";
			}//if
			else {
				winner = "Player 1";
			}//else
		}//if
		return winner;
	}//determineWinner
	
	/**
	 * copy Method to copy the contents of one Stack into another Stack
	 * @param paste	the Stack to be pasted into
	 * @param copy	the Stack to be copied
	 */
		public static void copy(StackFarrell paste, StackFarrell copy) {
			//instance variables
			StackFarrell tempStack = new StackFarrell();
			
			//Copy First Stack to Temp
			while(!copy.isEmpty()) 
				tempStack.push(copy.pop());
			  
			//Copy Temp to Second Stack
			while(!tempStack.isEmpty()) 
				paste.push(tempStack.pop());
		}//copy
		
		/**
		 * count Method to count the amount of Pokemon Cards in a Stack
		 * @param thisStack	The Stack to be Counted
		 * @return size	The amount of Cards in the Stack
		 */
		public static int count(StackFarrell thisStack) {
			//Instance Variables
			int size = 0;
			StackFarrell tempStack = new StackFarrell();
			
			//Count and Store Each From original Stack, for each transferred we increment size
			while(!thisStack.isEmpty()) {
				tempStack.push(thisStack.pop());
				size++;
			}//while
			
			//Push back to the original Stack to that it is unchanged
			while(!tempStack.isEmpty())
				thisStack.push(tempStack.pop());
			return size;
		}//count
		
		/**
		 * printResults Method to accept all the statistics about the Game and print the results of the game to the user
		 * @param items	The Amount of Cards in Play
		 * @param turns	The Amount of Turns The Game Took
		 * @param onesCount	The Amount of Cards in Player 1's Decks
		 * @param twosCount	The Amount of Cards in Player 2's Decks
		 * @param winnerType	The String of The Winner
		 */
		public static void printResults(int items, int turns, int onesCount, int twosCount, String winnerType) {
			//Print Results Of Game
			System.out.println("The Game Started with " + items + " Cards");
			System.out.println("There were " + turns + " plays in the game");
			//Determine the if there was a clear winner
			if(turns < 1000)
				System.out.println("The game ended with a clear winner");
			else
				System.out.println("The game took too long");
			System.out.println("Player 1 ended with " + onesCount + " Cards");
			System.out.println("Player 2 ended with " + twosCount + " Cards");
			System.out.println("The Winner was " + winnerType);
		}//printResults
		
}//PokeArmyDemoFarrell

