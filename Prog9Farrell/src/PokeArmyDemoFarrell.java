import java.io.*;
import java.util.*;
/**
 * Christian Farrell
 * @author Christian Farrell <br>
 * 
 * Prog 9 <br>
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
public class PokeArmyDemoFarrell {
	
	/**
	 * Keyboard Scanner to read in user inputs
	 */
	static Scanner keyboard = new Scanner(System.in);
	/**
	 * Empty Constructor to please JavaDoc
	 */
	public PokeArmyDemoFarrell() {
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
		PokemonFarrell newPoke;
		KeyedListFarrell myPokemonArmy = new KeyedListFarrell();
		char userInput = ' ';
		String addNewName = "";
		int addNewMultiplier = 0;
		double addNewPower = 0.0;
		boolean addSuccess = false;
		PokemonFarrell addNewPoke;
		String deletePokemon = "";
		boolean deleteResult = false;
		PokemonFarrell retrievedPokemon = null;
		double totalPower = 0.0;
		double totalBonusPower = 0.0;
		
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
		    for(int i = 0;i<numItems;i++)
		    {
		    	newName = input.next();
		    	newMultiplier = input.nextInt();
		    	newPower = input.nextDouble();
		    	newPoke = new PokemonFarrell(newName, newMultiplier, newPower);
		    	myPokemonArmy.add(newPoke);
		    }//for
	    }//try
	    
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
	  //Welcome user and print menu, looping the menu until quit is chosen
		do
		{
			System.out.println("Welcome to The Pokemon Army Builder, Please Select an Option Below!");
			System.out.println("1 : Add a Pokemon to the army");
			System.out.println("2 : Delete a Pokemon from the army");
			System.out.println("3 : Print each Pokemon in the army");
			System.out.println("4 : Search for a user-specified Pokemon in the army");
			System.out.println("5 : Get the total power of the Pokemon army");
			System.out.println("6 : Get the total bonus power of the Pokemon army");
			System.out.println("7 : Determine whether the army is empty");
			System.out.println("8 : Determine whether the army is full");
			System.out.println("9 : Clear the army");
			System.out.println("0 : Quit"); 
			userInput = keyboard.next().toUpperCase().charAt(0);
			
			switch(userInput)
			{
			//Add a Pokemon to the army
			case '1':
				//Ask and store information regarding the Pokemon
				System.out.println("Please Enter The Pokemon's Information");
				System.out.println("Name: ");
				addNewName = keyboard.next();
				do {
					System.out.println("Multiplier: ");
					addNewMultiplier = keyboard.nextInt();
				}//do
				while((addNewMultiplier < 0));
				do {
				System.out.println("Power: ");
				addNewPower = keyboard.nextDouble();
				}//do
				while(addNewPower < 0);
				//Create and attempt to add the New Pokemon
				addNewPoke = new PokemonFarrell(addNewName, addNewMultiplier, addNewPower);
				addSuccess = myPokemonArmy.add(addNewPoke);
				if(addSuccess == true)
					System.out.println("Pokemon Successfully Added");
				else
					System.out.println("Pokemon Failed to be Added");
				break;
			//Delete a Pokemon from the army
			case '2':
				System.out.println("What is the name of the Pokemon you wish to delete?");
				deletePokemon = keyboard.next();
				deleteResult = myPokemonArmy.remove(deletePokemon);
				if(deleteResult == true)
					System.out.println("Pokemon Successfully Deleted");
				else
					System.out.println("Pokemon Failed to be Deleted");
				break;
			//Print Pokemon in the Army
			case '3':
				myPokemonArmy.print();
				break;
			//Search for a user-specified Pokemon in the army
			case '4':
				System.out.println("What Program Would You Like to Retrieve?");
				retrievedPokemon = myPokemonArmy.retrieve(keyboard.next());
				if(retrievedPokemon != null) {
					System.out.println("Pokemon Found! \n");
					System.out.println(retrievedPokemon.toString());				
					}//if
				else
					System.out.println("Pokemon Not Found \n");
				break;
			//Get the total power of the Pokemon army	
			case '5':
				totalPower = myPokemonArmy.getTotalPower();
				System.out.println("The Total Army Power is " + totalPower + "\n");
				break;
			//Get the total bonus power of the Pokemon army
			case '6':
				totalBonusPower = myPokemonArmy.calcBonusPower();
				System.out.println("The Total Bonus Power is " + totalBonusPower + "\n");
				break;
			//Determine whether the army is empty
			case '7':
				if(myPokemonArmy.isEmpty() == true)
					System.out.println("The Army is Empty\n");
				else
					System.out.println("The Army is Not Empty\n");	
				break;
			//Determine whether the army is full
			case '8':
				if(myPokemonArmy.isFull() == true)
					System.out.println("The Army is Full\n");
				else
					System.out.println("The Army is Not Full\n");	
				break;
			//Clear the army
			case '9':
				myPokemonArmy.clear();
				System.out.println("Army Cleared \n");
				break;
			//Quit
			case '0':
				break;
			}//switch
		}//do
		while(userInput != '0');
		System.out.println("Thanks, Goodbye");
	}//main

}//PokeArmyDemoFarrell
