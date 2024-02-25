//Christian Farrell
//Prog 6
//Due 02/29/24 before 9:00 AM
//
//Purpose: 
//
//Input:
//
//Output:

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
		
		//Print the menu to the user and get their input, then test their input in the switch to determine which method to run, quitting if input is 'Q'
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
				
				switch(userInput)
				{
				//Assign the Step Width 	
				case 'W':
				case 'w':
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
				case 'n':
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
				case 'f':
					System.out.println("What would you like to make the Fill Style?");
					responseInputChar = keyboard.next().toUpperCase().charAt(0);
					while(responseInputChar == ' ')
					{
						System.out.println("Invalid Input, What would you like to make the Fill Style?");
						responseInputChar = keyboard.next().toUpperCase().charAt(0);
					}//while
					defaultSteps.setFillStyle(responseInputChar);
					break;
					
				//Calculate the Area
				case 'A':
				case 'a':
					calcArea = defaultSteps.calcArea();
					System.out.println("The Calculated Area is " + calcArea);
					break;
					
				//Text Description of the Steps
				case 'T':
				case 't':
					textDescription = defaultSteps.toString();
					System.out.println(textDescription);
					break;
					
				//Draw the Steps
				case 'D':
				case 'd':
					defaultSteps.drawSteps();
					break;
					
				//Draw Thick Steps
				case 'X':
				case 'x':
					defaultSteps.drawThickSteps();
					break;
					
				//Quit
				case 'Q':
				case 'q':
					break;
					
				//Error Catch Bad Input
				default:
					System.out.println("Invalid Menu Input - Please Try Again\n");
					break;
				}//switch
					
			}//do
			while(userInput != 0);

	}//main

}//StepsDemoFarrell
