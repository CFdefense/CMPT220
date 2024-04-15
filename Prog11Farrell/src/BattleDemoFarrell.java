import java.io.*;
import java.util.*;
/**
 * Christian Farrell
 * @author Christian Farrell <br>
 * 
 * Prog 11 <br>
 * Due Date and Time: 2/25/24 before 9:00 AM <br>
 * 
 * Purpose: This program will serve as a Pokemon Army Builder, users will be able to read in, manipulate and get data about the Pokemon army. <br>
 * 
 * Input: userInput, addNewName, addNewMultiplier, addNewPower, deletePokemon, retrievedPokemon, <br>
 * 
 * Output: addSuccess, deleteResult, retrievedPokemon, totalPower, totalBonusPower, isFull, isEmpty, PokemonList<br>
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
	 * Empty Constructor to please JavaDoc
	 */
	public BattleDemoFarrell() {
	}//PokeArmyDemoFarrell
	
	/**
	 * Main Method to Take in File Input, Then Print and Run Menu 
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
		
		//ask the user for the path and name to the file
	    System.out.print("Enter a filename: ");
	    fileName = keyboard.next();
	    numItems = deal(fileName,playerOnePlay,playerTwoPlay);
	    
	    //Game Loop
		while(((!playerOnePlay.isEmpty() || !playerOneDiscard.isEmpty()) && (!playerTwoPlay.isEmpty() || !playerTwoDiscard.isEmpty())) && turnCounter < 1000) {
			
			//Check Deck Status
			//if Play is empty we copy the discard
			if(playerOnePlay.isEmpty()) 
				copy(playerOnePlay, playerOneDiscard);
			if(playerTwoPlay.isEmpty())
				copy(playerTwoPlay, playerTwoDiscard);
			//Draw Cards
			playerOneCard = play(playerOnePlay);
			playerTwoCard = play(playerTwoPlay);
			//Compare Cards
			win = compare(playerOneCard,playerTwoCard);
			//Draw Results
			winPlay(playerOneCard,playerTwoCard,playerOnePlay,playerTwoPlay,win);
			turnCounter++;
			
		}//while
		
		//Determine Winner
		winner = determineWinner(playerOnePlay, playerOneDiscard);
		
		
		//update card holdings
		playerOneCount = count(playerOnePlay) + count(playerOneDiscard);
		playerTwoCount = count(playerTwoPlay) + count(playerTwoDiscard);
		
		//print results
		System.out.println("\nThe Game Started with " + numItems + " Cards");
		System.out.println("There were " + turnCounter + " plays in the game");
		if(turnCounter < 1000)
			System.out.println("The game ended with a clear winner");
		else
			System.out.println("The game took too long");
		System.out.println("Player 1 ended with " + playerOneCount + " Cards");
		System.out.println("Player 2 ended with " + playerTwoCount + " Cards");
		System.out.println("The Winner was " + winner);
	    
	}//main
	
	public static int deal(String fileName, StackFarrell p1Play, StackFarrell p2Play) {
    	
		//instance variables
		File inputFile = new File(fileName);
		int numPokes = 0;
		String newName = "";
		int newMultiplier = 0;
		double newPower = 0.0;
		int drawCount = 0;
		PokemonCardFarrell newPoke;
	    try { 
		    //Create a second Scanner object, this one for reading from the file
		    Scanner input = new Scanner(inputFile);
		    
		    //Read first line of the file to find out how many numbers will follow.
		    numPokes = input.nextInt();
		    
		    //loop through items determined from first line of file
		    while(drawCount < numPokes)
		    {
		    	//read in data and create the Card
		    	newName = input.next();
		    	newMultiplier = input.nextInt();
		    	newPower = input.nextDouble();
		    	newPoke = new PokemonCardFarrell(newName, newMultiplier, newPower);
		    	
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
	
	public static PokemonCardFarrell play(StackFarrell playStack) {return playStack.pop();}//play
	
	public static int compare(PokemonCardFarrell cardOne, PokemonCardFarrell cardTwo) {
		//instance variables
		int result = 0;
		double playerOnePower = cardOne.getPower();
		double playerTwoPower = cardTwo.getPower();
		int playerOneMultiplier = cardOne.getMultiplier();
		int playerTwoMultiplier = cardTwo.getMultiplier();
		
		if(playerOnePower == playerTwoPower) {
			//Battle
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
	public static void winPlay(PokemonCardFarrell CardOne, PokemonCardFarrell CardTwo, StackFarrell p1Stack, StackFarrell p2Stack, int winStatus) {
		//Determine Winner, Push Accordingly and Update String
		switch(winStatus) {
		case 0: //tie
			p1Stack.push(CardOne);
			p2Stack.push(CardTwo);
			break;
		case 1: //p1 wins
			p1Stack.push(CardOne);
			p1Stack.push(CardTwo);
			break;
		case 2: //p2 wins
			p2Stack.push(CardTwo);
			p2Stack.push(CardOne);
			break;
		}//switch
	}//winPlay
	
	public static String determineWinner(StackFarrell p1Play, StackFarrell p1Discard) {
		//Instance Varables
		String winner = "No One";
		//determine winner from only P1 Hand
		if(p1Play.isEmpty() && p1Discard.isEmpty()) {
			winner = "Player 2";
		}//if
		else {
			winner = "Player 1";
		}//else
		return winner;
	}//determineWinner
	
	//copy Method
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
		
		//count Method
		public static int count(StackFarrell thisStack) {
			//Instance Variables
			int size = 0;
			StackFarrell tempStack = new StackFarrell();
			//Count and Store Each From original Stack
			while(!thisStack.isEmpty()) {
				tempStack.push(thisStack.pop());
				size++;
			}//while
			//Push back to the original Stack
			while(!tempStack.isEmpty())
				thisStack.push(tempStack.pop());
			return size;
		}//count
		
}//PokeArmyDemoFarrell

