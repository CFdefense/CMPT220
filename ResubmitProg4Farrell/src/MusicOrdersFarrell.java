import java.util.*;
/**
 * Christian Farrell
 * Prog 4 Resubmit
 * Due 04/29/24 before 9:00 AM
 * 
 * Purpose: Compute and Return Customer Bills for Music Orders of Varying Size, Then Compute and Return Summary Statistics for All Customers
 * 
 * Input: Customer ID, Customer Name, Number of Songs, Song Length For Each Song, Genre For Each Song
 * 
 * Output: Customer ID, Customer Name, Number of Songs Purchased, Total Song Costs, Service Charge, Total Amount Due,
 * Total Amount of Serviced Customers, Highest Bill Amount, Customer ID for Highest Bill, Lowest Bill Amount, Customer ID for Lowest Bill,
 * Total Cost of All Music Purchased, Average Customer Bill
 *
 * Certification of Authenticity: I certify that this lab is entirely my own work
 * 
 * 
 * //IMPORTANT!!!!!!!! CHANGES MADE TO THE FOLLOWING LINES (93-99) (101-107) (135-165) (168-191) (193-207) (212-217)
 */
public class MusicOrdersFarrell 
{
	/**
	 * Keyboard Scanner to read in user inputs
	 */
	static Scanner keyboard = new Scanner(System.in);

	/**
	 * default constructor for JavaDoc
	 */
	public MusicOrdersFarrell() {}//MusicOrdersFarell
	
	/**
	 * main Method to run our program sequence
	 * @param args	Console Line Inputs
	 */
	public static void main(String[] args) 
	{
		//Declare variables
		int customerID = 0;
		String customerName = "";
		int numberOfsongs = 0;
		double totalCost = 0;
		double serviceCost = 0;
		double totalDue = 0;
		int numOfcustomers = 0;
		double highestCharge = 0.0;
		int customerIDhighest = 0;
		double lowestCharge = Double.MAX_VALUE;
		int customerIDlowest = 0;
		double overallBill = 0.0;
		double overallAverage = 0.0;
		
		//Get User Inputs & Validate Those Which Require It
		System.out.println("What is Your Customer ID?");
		customerID = keyboard.nextInt();
		while (customerID != 0)
		{
			//increment numOfcustomers
			numOfcustomers++;
		
			System.out.println("What is Your Name?");
			customerName = keyboard.next();
			do
			{
				System.out.println("How Many Songs Would You Like to Order?");
				numberOfsongs = keyboard.nextInt();
			}//do
			while(numberOfsongs<=0);
			
			//Call chooseSongs method
			totalCost = chooseSongs(numberOfsongs);
			//Call serviceCost method
			serviceCost = calcServiceCharge(numberOfsongs,totalCost);
			//call totalDue method
			totalDue = calcTotalDue(totalCost,serviceCost);
			
			//Add Bill to totalBill and check if Bill is smallest or Largest
			overallBill +=totalDue;
			if (totalDue > highestCharge)
			{
				highestCharge = totalDue;
				customerIDhighest = customerID;
				
			}//if
			if(totalDue < lowestCharge)
			{
				lowestCharge = totalDue;
				customerIDlowest = customerID;
			}//if
			
			//Call outputResults method
			outputResults(customerName,customerID,numberOfsongs,totalCost,serviceCost,totalDue);
			
			//Ask for next ID
			System.out.println("\nWhat is Your Customer ID?");
			customerID = keyboard.nextInt();
		}//while
		
		//Compute/error check overallAverage and lowest charge
		//NEWCHANGE FIXED ERROR CHECKING FOR overallAverage and lowestCharge
		if(numOfcustomers != 0)
		overallAverage = (overallBill/numOfcustomers);
		if(lowestCharge == Double.MAX_VALUE)
			lowestCharge = 0;
		
		//Print Post-Loop Summary
		System.out.println("\nIn Total There Were "+numOfcustomers+" Customer(s) Processed");
		System.out.printf("The Highest Bill Amount Was: $%.2f\n",(highestCharge));
		System.out.println("The Customer ID Associated With The Highest Bill Was Customer ID #"+customerIDhighest);
		System.out.printf("The Lowest Bill Amount Was: $%.2f\n",(lowestCharge));
		System.out.println("The Customer ID Associated With The Lowest Bill Was Customer ID #"+customerIDlowest);
		System.out.printf("The Total Cost of All Music Purchased Was: $%.2f\n",(overallBill));
		System.out.printf("The Average Bill of All Purchase Amounts Was: $%.2f\n",(overallAverage));
		
	}//main

	//NEW CHANGE - ADDED METHOD HEADER AND UPDATED RESULT
	/**
	 * chooseSongs Method to Prompt and log the user inputs, and calculate the cost
	 * @param numSongs	the Number of songs the user wishes to order
	 * @return totalCostcalculated	Total Cost of Songs Desired
	 */
	public static double chooseSongs(int numSongs)
	{
		//Declare Variables
		int songLength = 0;
		String genre = "";
		char genreChar = ' ';
		double songCost = 0.0;
		double totalCostcalculated = 0.0;
		boolean foundGenre = false;
		double multiplier = 0.0;
		
		//Ask about each song length and genre then calculate cost
		for (int i = 1;i<=numSongs;i++)
		{
			do
			{
				System.out.println("What is The Song Length For Song Number #"+i+"?");
				songLength = keyboard.nextInt();
			}//do
			while(songLength<1 || songLength>600);
			
			do
			{
				System.out.println("What is The Genre For Song #"+i+"?");
				genre = keyboard.next().toUpperCase();
				genreChar = genre.charAt(0);
				foundGenre = false;
				//NEW CHANGE - Calculated songCost after the switch instead of inside each case
				switch (genreChar)
				{
					case 'P':
						foundGenre = true;
						multiplier = .35;
						break;
					case 'R':
						foundGenre = true;
						multiplier = .54;
						break;
					case 'C':
						foundGenre = true;
						multiplier = .25;
						break;
					case 'G':
						foundGenre = true;
						multiplier = .40;
						break;
					case 'O':
						foundGenre = true;
						multiplier = .30;
						break;
				}//switch
				songCost = songLength * multiplier;
			}//do
			while(foundGenre == false);
			totalCostcalculated += songCost;
		}//for
		//NEW CHANGE - Divide by 100 to convert to proper units
		return totalCostcalculated / 100;
	}//chooseSongs
	
	//NEW CHANGE - ADDED HEADER COMMENT AND FIXED DULPICATE PARAM NAMES
	/**
	 * calcServiceCharge Method calculates the service charge
	 * @param numSongs Number of Songs Purchased
	 * @param totCost	The Total Cost of the Songs
	 * @return result	The Service Charge for the order
	 */
	public static double calcServiceCharge(int numSongs,double totCost)
	{
		//NEW CHANGE - Updated to only update result once at the end
		//instance variable
		double result = 0.0;
		double multiplier = 0.0;
		if (numSongs <5) 
			multiplier = .15;
		else if(numSongs < 10) 
			multiplier = .12;
			else if(numSongs < 15) 
				multiplier = .09;
				else
					multiplier = .06;
		result = multiplier * totCost;
		return result;
	}//calcServiceCharge
	
	//NEW CHANGE - ADDED HEADER COMMENT AND FIXED DUPLICATE PARAM NAMES
	/**
	 * calcTotalDue Method Calculates the total cost of the order
	 * @param totCost	The Total Calculated Cost of the Order
	 * @param servCost	The Service Charge of the Order
	 * @return result	The Sum of the calculated tax, total cost and service cost
	 */
	public static double calcTotalDue(double totCost, double servCost)
	{
		return (((totCost+servCost) * .08) + (totCost + servCost));
	}//calcTotalDue
	
	//NEW CHANGE - ADDED HEADER
	/**
	 * outputResults Method to format and print the results of the customers order
	 * @param customerNameResult	The Name of the Customer
	 * @param customerIDresult	The Customer's ID
	 * @param numSongs	The number of Songs purchased
	 * @param totalCostResult	The Total Cost
	 * @param serviceChargeResult	The Service Charge
	 * @param totalDueResult	The Total Amount Due
	 */
	public static void outputResults(String customerNameResult, int customerIDresult, int numSongs, double totalCostResult, double serviceChargeResult, double totalDueResult)
	{
		System.out.println("Results for Customer: "+customerNameResult);
		System.out.println("Customer ID Number: #"+customerIDresult);
		System.out.println("There were "+numSongs+" Songs Purchased");
		//NEW CHANGE - Moved dividing by 100 to its respective methods
		System.out.printf("The Total Cost of These Songs Is: $%.2f\n",(totalCostResult));
		System.out.printf("The Service Charge Amount Is: $%.2f\n",(serviceChargeResult));
		System.out.printf("The Total Amount Due Is $%.2f\n",(totalDueResult));
		
	}//outputResults 
}//MusicOrdersFarrell
