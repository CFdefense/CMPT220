import java.io.*;
import java.util.*;

public class PokeArmyDemoFarrell {
	
	static Scanner keyboard = new Scanner(System.in);

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
				System.out.println("Multiplier: ");
				addNewMultiplier = keyboard.nextInt();
				System.out.println("Power: ");
				addNewPower = keyboard.nextDouble();
				//Create and attempt to add the New Pokemon
				addNewPoke = new PokemonFarrell(addNewName, addNewMultiplier, addNewPower);
				addSuccess = myPokemonArmy.add(addNewPoke);
				if(addSuccess == true)
					System.out.println("Pokemon Successfully Added");
				else
					System.out.println("Pokemon Failed to be Added");
				break;
			case '2':
				break;
				//Print Pokemon in the Army
			case '3':
				myPokemonArmy.print();
				break;
			case '4':
				break;
			case '5':
				break;
			case '6':
				break;
			case '7':
				break;
			case '8':
				break;
			case '9':
				break;
			case '0':
				break;
			}//switch
		}//do
		while(userInput != '0');
		System.out.println("Thanks, Goodbye");
	}//main

}//PokeArmyDemoFarrell
