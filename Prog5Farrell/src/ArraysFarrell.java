/*Christian Farrell
Prog 5
Due 02/22/24 @ 9:00 PM

Purpose: To use a menu and various types of arrays to perform the following functions: grading a quiz, finding highest,lowest and average of 10 grades, and finding information about an array's minimums.

Input: userInput, gradesArray, inputArray, keyArray, arrayOfints, newSizearray, minCount

Output: highestGrade, lowestGrade, averageGrade, percentileGrade, letterGrade

Certification of Authenticity: I certify that this lab is entirely my own work
*/

import java.util.*;
public class ArraysFarrell 
{

	//Create Keyboard
	static Scanner keyboard = new Scanner(System.in);
	
	//This main method will act as a hub to call other methods, after their completion it will return to the main to print the menu again.
	public static void main(String[] args) 
	{
		//Initialize Variables
		int userInput = 0;
		
		//Print the menu to the user and get their input, then test their input in the switch to determine which method to run, quitting if input is 0
		do
		{
			System.out.println("Welcome! Please Select an Option From the Below Menu!");
			System.out.println("1) Handle Grades");
			System.out.println("2) Grade a Quiz");
			System.out.println("3) How Many Mins?");
			System.out.println("0) Quit");
			userInput = keyboard.nextInt();
			switch(userInput)
			{
			//Handle Grades 	
			case 1:
				handleGrades();
				break;
				
			//Grade A Quiz
			case 2:
				gradeQuiz();
				break;
				
			//How Many Minimums
			case 3:
				howManyMins();
				break;
				
			//Quit
			case 0:
				break;
			//Error Catch Bad Input
			default:
				System.out.println("Invalid Menu Input - Please Try Again\n");
				break;
			}//switch
			
		}//do
		while(userInput != 0);
		
	}//main
	
	//This Method will prompt for 10 double grades, one at a time, then place them into an array. 
	//Next this method will call 3 other helper methods, and print the results of the methods to the user.
	public static void handleGrades()
	{
		//Initialize Variables
		double[] gradesArray = new double[10];
		double highestGrade = 0;
		double lowestGrade = 0;
		double averageGrade = 0;
		
		//Prompt for and store 10 doubles
		System.out.println("Please Enter 10 Grades One By One");
		for (int i = 0;i <10;i++)
		{
		 System.out.println("Enter Grade # "+(i+1));
		 gradesArray[i] = keyboard.nextDouble();
		}//for
		//Call findHigh
		highestGrade = findHigh(gradesArray);
		//Call findLow
		lowestGrade = findLow(gradesArray);
		//Call findAverage
		averageGrade = findAverage(gradesArray);
		
		//Print Results of Methods
		System.out.println("The Highest Grade Found Was: "+highestGrade);
		System.out.println("The Lowest Grade Found Was: "+lowestGrade);
		System.out.println("The Average Grade Was: "+averageGrade+"\n");
		
	}//handleGrades
	
	//This method will find the highest value in an array of doubles and return it.
	public static double findHigh(double[] arrayOfdoubles)
	{
		//Initialize Variables
		double currentHigh = arrayOfdoubles[0];
		
		//find highest value in the array
		for(int i = 1;i<10;i++)
		{
			if (arrayOfdoubles[i]> currentHigh)
				currentHigh = arrayOfdoubles[i];
		}//for
		return currentHigh;
	}//findHigh
	
	//This method will find the lowest value in an array of doubles and return it.
	public static double findLow(double[] arrayOfdoubles)
	{
		//Initialize Variables
		double currentLow = arrayOfdoubles[0];
		
		//find minimum value in the array
		for(int i = 1;i<10;i++)
		{
			if (arrayOfdoubles[i] < currentLow)
				currentLow = arrayOfdoubles[i];
		}//for
		return currentLow;
	}//findLow
	
	//This method will calculate the average value of an array of doubles and return it.
	public static double findAverage(double[] arrayOfdoubles)
	{
		//Initialize Variables
		double average = 0;
		double runningCount = 0;
		
		//increment array values
		for(int i = 0;i<10;i++)
			runningCount += arrayOfdoubles[i];
		
		//calculate and return average
		average = runningCount / arrayOfdoubles.length;
		return average;
	}//findAverage
	
	//This method will prompt for and read 12 characters one at a time to an array, then prompt and read 12 more as the answer key.
	//Then it will pass both arrays into helper method to grade the quiz and print results
	public static void gradeQuiz()
	{
		//Initialize Variables
		char[] inputArray = new char[12];
		char[] keyArray = new char[12];
		int totalCorrect = 0;
		double percentileGrade = 0.0;
		String letterGrade = "";
		char userAnswer = ' ';
		
		//Create the answers array by getting user input and convert it into a single upper-case character and check to make sure the input is valid.
		for(int i = 0;i<inputArray.length;i++)
		{
			do
			{
				System.out.println("Enter Answer #"+(i+1)+" (A,B,C or D)");
				userAnswer = keyboard.next().toUpperCase().charAt(0);
			}//do
			while(userAnswer != 'A' && userAnswer != 'B' && userAnswer != 'C' && userAnswer != 'D');
			inputArray[i]=userAnswer;
		}//for
		
		//Create the key array array by getting user input and convert it into a single upper-case character and check to make sure the input is valid.
		for(int i = 0;i<keyArray.length;i++)
		{
			do
			{
			System.out.println("Enter Correct Answer For #"+(i+1)+" (A,B,C, or D");
			userAnswer = keyboard.next().toUpperCase().charAt(0);
			}//do
			while(userAnswer != 'A' && userAnswer != 'B' && userAnswer != 'C' && userAnswer != 'D');
			keyArray[i] = userAnswer;
		}//for
		
		//Call gradeAquiz and convert total correct into a score out of 100 
		totalCorrect = gradeAQuiz(inputArray,keyArray);
		percentileGrade = (totalCorrect*100)/12;
		
		//Determine Letter Grade on Schwartz's 10 Point Scale -switch cannot be used for doubles:( 
		if (percentileGrade >= 90)
			letterGrade = "A";
		else if (percentileGrade >=88)
			letterGrade = "A-";
		else if (percentileGrade >=85)
			letterGrade = "B+";
		else if (percentileGrade >= 80)
			letterGrade = "B";
		else if (percentileGrade >= 78)
			letterGrade = "B-";
		else if (percentileGrade >= 75)
			letterGrade = "C+";
		else if (percentileGrade >= 70)
			letterGrade = "C";
		else if (percentileGrade >= 68)
			letterGrade = "C-";
		else if (percentileGrade >= 65)
			letterGrade = "D+";
		else if (percentileGrade >= 60)
			letterGrade = "D";
		else
			letterGrade = "F";
		
		//Print Results to User
		System.out.printf("The Quiz Score is %.2f%% \n",percentileGrade);
		System.out.println("The Quiz Letter Grade is "+letterGrade+"\n");
		
	}//gradeQuiz
	
	//This method will receive two arrays and compare them to return the total amount of correct answers.
	public static int gradeAQuiz(char[] userAnswers, char[] answerKey)
	{
		//Initialize Variables
		int correctCount = 0;
		
		//Compare key and answers and increment correctCount.
		for(int i = 0;i<userAnswers.length;i++)
		{
			if(userAnswers[i] == answerKey[i])
				correctCount++;
		}//for
		return correctCount;
	}//gradeAquiz
	
	//This method will prompt and read up to 10 non negatives into array, -1 to indicate that the user is done. 
	//Then Calls helper method to display the array , the minimum value in the array, and the number of times that minimum is in the array
	public static void howManyMins()
	{
		//Initialize Variables
		int[] arrayOfints = new int[10];
		int counter = 0;
		boolean isNegative = false;
		int userAnswer = 0;
		
		//Create the array and check if conditions to stop have been met
		while(counter<arrayOfints.length && isNegative != true)
		{
			System.out.println("Enter number #"+(counter+1)+"(Enter a negative number to Stop)");
			userAnswer = keyboard.nextInt();
			if (userAnswer <0)
				isNegative = true;
			else
				arrayOfints[counter] = userAnswer;
			counter++;
			
		}//while
		
		//Call Helper method
		minsInArray(arrayOfints,counter);
		
	}//howManymins
	
	
	//This method will resize an array based on value size, then find the minimum and how many times that minimum is in the array, then it will print those results nicely.
	public static void minsInArray(int[] inputArray, int size)
	{
		//Initialize variables
		int[] newSizearray = new int[size];
		int minFound = Integer.MAX_VALUE;
		int minCount = 0;
		int count = 0;
		
		//Create the new array for the new size
		for(int i = 0;i<(size);i++)
			newSizearray[i] = inputArray[i];
		
		//Find the minimum in the array
		for(int i = 0;i<newSizearray.length;i++)
		{
			if(newSizearray[i]<minFound)
				minFound = newSizearray[i];
		}//for
		
		//count how many times the minimum occurs
		for(int i = 0;i<newSizearray.length;i++)
		{
			if(newSizearray[i] == minFound)
				minCount++;
		}//for
	
		//Print results to user using for loop to simulate the look of an actual array. Stop one before the end of the array to ensure the array looks nice
		System.out.print("Array contents: [");
		for (count = 0;count<(newSizearray.length-1);count++)
			System.out.print(newSizearray[count]+", ");
		System.out.print(newSizearray[count]+"]\n");
		System.out.println("The minimum value in the array is "+minFound);
		System.out.println("The minimum value in the array was found "+minCount+" times \n");
		
	}//minsInArray
	
}//Prog0Farrell

