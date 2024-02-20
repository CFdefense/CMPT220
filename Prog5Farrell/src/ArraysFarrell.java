/*Christian Farrell
Prog 5
Due 02/22/24 @ 9:00 PM

Purpose: 

Input: 

Output:

Certification of Authenticity: I certify that this lab is entirely my own work
*/


import java.util.*;
public class ArraysFarrell 
{

	//Create Keyboard
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		//Initialize Variables
		int userInput = 0;
		
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
			//Grade a Quiz
			case 2:
				gradeQuiz();
				break;
			//How Many Mins - prompt and read up to 10 non negatives into array, -1 to indicate done. Then Calls helper method to display stats
			case 3:
				break;
				//Quit
			case 0:
				break;
			default:
				System.out.println("Invalid Menu Input - Please Try Again");
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
		double high = 0;
		double low = 0;
		double average = 0;
		
		//Prompt for and store 10 doubles
		System.out.println("Please Enter 10 Grades One By One");
		for (int i = 0;i <10;i++)
		{
		 System.out.println("Enter Grade # "+(i+1));
		 gradesArray[i] = keyboard.nextDouble();
		}//for
		//Call findHigh
		high = findHigh(gradesArray);
		//Call findLow
		low = findLow(gradesArray);
		//Call findAverage
		average = findAverage(gradesArray);
		
		//Print Results of Methods
		System.out.println("The Highest Grade Found Was: "+high);
		System.out.println("The Lowest Grade Found Was: "+low);
		System.out.println("The Average Grade Was: "+average+"\n");
		
	}//handleGrades
	
	//This method will find the highest value in an array of doubles and return it.
	public static double findHigh(double[] arrayOfdoubles)
	{
		//Initialize Variables
		double currentHigh = arrayOfdoubles[0];
		
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
		
		for(int i = 0;i<10;i++)
			runningCount += arrayOfdoubles[i];
		
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
		char letterGrade = ' ';
		
		for(int i = 0;i<inputArray.length;i++)
		{
			System.out.println("Enter Answer #"+(i+1));
			inputArray[i] = keyboard.next().toUpperCase().charAt(0);
		}//for
		for(int i = 0;i<keyArray.length;i++)
		{
			System.out.println("Enter Correct Answer For #"+(i+1));
			keyArray[i] = keyboard.next().toUpperCase().charAt(0);
		}//for
		totalCorrect = gradeAquiz(inputArray,keyArray);
		percentileGrade = totalCorrect/12;
		if percentileGrade //continue HEREEEE
		
	}//gradeQuiz
	
	//This method will receive two arrays and compare them to return the total amount of correct answers.
	public static int gradeAquiz(char[] userAnswers, char[] answerKey)
	{
		//Initialize Variables
		int correctCount = 0;
		
		for(int i = 0;i<userAnswers.length;i++)
		{
			if(userAnswers[i] == answerKey[i])
				correctCount++;
		}//for
		return correctCount;
	}//gradeAquiz
	
}//Prog0Farrell
