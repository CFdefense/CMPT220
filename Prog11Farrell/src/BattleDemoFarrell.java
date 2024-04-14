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
		int numItems = 0;
		String newName = "";
		int newMultiplier = 0;
		double newPower = 0.0;
		int drawCount = 0;
		PokemonCardFarrell newPoke;
		StackFarrell playerOnePlay = new StackFarrell();
		StackFarrell playerOneDiscard = new StackFarrell();
		StackFarrell playerTwoPlay = new StackFarrell();
		StackFarrell playerTwoDiscard = new StackFarrell();
		PokemonCardFarrell playerOneCard;
		PokemonCardFarrell playerTwoCard;
		double playerOnePower = 0;
		double playerTwoPower = 0;
		int playerOneMultiplier;
		int playerTwoMultiplier;
		int turnCounter = 0;
		String winner = "no one";
		
		//ask the user for the path and name to the file
	    System.out.print("Enter a filename: ");
	    fileName = keyboard.next();
	    
	    //create the reference to the file, declared up here because of the "catch"
	    File inputFile = new File(fileName);
	    
	    try { 
		    //Create a second Scanner object, this one for reading from the file
		    Scanner input = new Scanner(inputFile);
		    
		    //Read first line of the file to find out how many numbers will follow.
		    numItems = input.nextInt();
		    
		    //loop through items determined from first line of file
		    while(drawCount < numItems)
		    {
		    	//read in data and create the Card
		    	newName = input.next();
		    	newMultiplier = input.nextInt();
		    	newPower = input.nextDouble();
		    	newPoke = new PokemonCardFarrell(newName, newMultiplier, newPower);
		    	
		    	//Give to player 1
		    	if(drawCount % 2 == 0) 
		    		playerOnePlay.push(newPoke);
		    	//Give to player 2
		    	else
		    		playerTwoPlay.push(newPoke);
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
	    
	    //Game Loop
		while(((!playerOnePlay.isEmpty() || !playerOneDiscard.isEmpty()) && (!playerTwoPlay.isEmpty() || !playerTwoDiscard.isEmpty())) && turnCounter < 1000) {
			
			//Check Deck Status
			//if Play is empty we copy the discard
			if(playerOnePlay.isEmpty()) 
				playerOnePlay.copy(playerOnePlay, playerOneDiscard);
			else if(playerTwoPlay.isEmpty())
				playerTwoPlay.copy(playerTwoPlay, playerTwoDiscard);
			//continue with turn
			playerOneCard = playerOnePlay.pop();
			playerTwoCard = playerTwoPlay.pop();
			playerOnePower = playerOneCard.getPower();
			playerTwoPower = playerTwoCard.getPower();
			playerOneMultiplier = playerOneCard.getMultiplier();
			playerTwoMultiplier = playerOneCard.getMultiplier();
			//Compare Cards
			
			//if equal
			if(playerOnePower == playerTwoPower) {
				//Battle
				if(playerOneMultiplier == playerTwoMultiplier) {
					//Equal So Both Players Save Their Card
					playerOneDiscard.push(playerOneCard);
					playerTwoDiscard.push(playerTwoCard);
				}//if
				else if(playerOneMultiplier > playerTwoMultiplier) {
					//Player One Wins Both Cards
					playerOneDiscard.push(playerOneCard);
					playerOneDiscard.push(playerTwoCard);
				}//if
				else {
					//Player Two Wins Both Cards
					playerTwoDiscard.push(playerTwoCard);
					playerTwoDiscard.push(playerOneCard);
				}//else
			}//if
			//Player One's Card is Stronger
			else if (playerOnePower > playerTwoPower) {
				//push cards to winners discard
				playerOneDiscard.push(playerOneCard);
				playerOneDiscard.push(playerTwoCard);
			}//if
			//Player Two's Card is Stronger
				else {
					playerTwoDiscard.push(playerTwoCard);
					playerTwoDiscard.push(playerOneCard);
				}//else
			turnCounter++;	
		}//while
		
		//Check who won
		
		//Player Two Won
		if(playerOnePlay.isEmpty() && playerOneDiscard.isEmpty()) {
			winner = "Player Two";
		}//if
		
		//Player One Won
		else {
			winner = "Player One";
		}//else
		
		//print results
		System.out.println("The Game Started with " + numItems + " Cards");
		System.out.println("There were " + turnCounter + " plays in the game");
		if(turnCounter < 1000)
			System.out.println("The game ended with a clear winner");
		else
			System.out.println("The game took too long");
		//System.out.println("Player 1 ended with " + playerOneCount + " Cards");
		//System.out.println("Player 2 ended with " + playerTwoCount + " Cards");
		System.out.println("The Winner was " + winner);
	    
	}//main

}//PokeArmyDemoFarrell
