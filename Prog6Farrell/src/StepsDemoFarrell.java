//Christian Farrell
//Prog 6
//Due 02/29/24 before 9:00 AM
//
//Purpose: Draw steps of varying sizes and styles depending on a users interaction with a menu. The menu will have options to manipulate the steps
//and to display data about the steps
//
//Input: userInput, responseInputInteger, responseInputChar
//
//Output: calcArea,textDescription, drawSteps, drawThickSteps

//Certification of Authenticity: I certify that this lab is entirely my own work
import java.util.*;
public class StepsDemoFarrell 
{
	//Declare Keyboard
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		//Declare & Initialize Variables
		StepsFarrell defaultSteps = new StepsFarrell();
		char userInput = ' ';
		int responseInputInteger = 0;
		char responseInputChar = ' ';
		int calcArea = 0;
		String textDescription = "";
		
		//Print the menu to the user and get their input, 
			do
			{
				System.out.println("Welcome! Please Select an Option From the Below Menu!");
				System.out.println("W : Assign the Step Width");
				System.out.println("N : Assign the Number of Steps");
				System.out.println("F : Assign the Fill Style");
				System.out.println("A : Calculate the Area");
				System.out.println("T : Text Description of the Steps");
				System.out.println("D : Draw the Steps");
				System.out.println("X : Draw Thick Steps");
				System.out.println("Q : Quit");
				userInput = keyboard.next().toUpperCase().charAt(0);
				
				//Switch case to determine which action to take based on input
				switch(userInput)
				{
				//Assign the Step Width 	
				case 'W':
					System.out.println("What would you like to make the Step Width?");
					responseInputInteger = keyboard.nextInt();
					while(responseInputInteger<= 0)
					{
						System.out.println("Invalid Input, What would you like to make the Step Width?");
						responseInputInteger = keyboard.nextInt();
					}//while
					defaultSteps.setStepWidth(responseInputInteger);
					break;
					
				//Assign the Number of Steps
				case 'N':
					System.out.println("What would you like to make the Number of Steps?");
					responseInputInteger = keyboard.nextInt();
					while(responseInputInteger<= 0)
					{
						System.out.println("Invalid Input, What would you like to make the Number of Steps?");
						responseInputInteger = keyboard.nextInt();
					}//while
					defaultSteps.setNumSteps(responseInputInteger);
					break;
					
				//Assign the Fill Style
				case 'F':
					System.out.println("What would you like to make the Fill Style?");
					responseInputChar = keyboard.next().charAt(0);
					defaultSteps.setFillStyle(responseInputChar);
					break;
					
				//Calculate the Area
				case 'A':
					calcArea = defaultSteps.calcArea();
					System.out.println("The Calculated Area is " + calcArea);
					break;
					
				//Text Description of the Steps
				case 'T':
					textDescription = defaultSteps.toString();
					System.out.println(textDescription);
					break;
					
				//Draw the Steps
				case 'D':
					defaultSteps.drawSteps();
					break;
					
				//Draw Thick Steps
				case 'X':
					defaultSteps.drawThickSteps();
					break;
					
				//Quit
				case 'Q':
					break;
					
				//Error Catch Bad Input
				default:
					System.out.println("Invalid Menu Input - Please Try Again\n");
					break;
				}//switch
					
			}//do
			while(userInput != 'Q');
			
			//Say goodbye
			System.out.println("Goodbye");

	}//main

}//StepsDemoFarrell
