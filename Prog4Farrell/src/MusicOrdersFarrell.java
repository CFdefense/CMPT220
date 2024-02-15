//Christian Farrell
//Prog 4
//Due 02/15/24 before 9:00 AM
//
//Purpose: Compute and Return Customer Bills for Music Orders of Varying Size, Then Compute and Return Summary Statistics for All Customers
//
//Input: Customer ID, Customer Name, Number of Songs, Song Length For Each Song, Genre For Each Song
//
//Output:Customer ID, Customer Name, Number of Songs Purchased, Total Song Costs, Service Charge, Total Amount Due,
//Total Amount of Serviced Customers, Highest Bill Amount, Customer ID for Highest Bill, Lowest Bill Amount, Customer ID for Lowest Bill,
//Total Cost of All Music Purchased, Average Customer Bill
//
//Certification of Authenticity: I certify that this lab is entirely my own work

import java.util.*;
public class MusicOrdersFarrell 
{
	//Declare Keyboard
		static Scanner keyboard = new Scanner(System.in);

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
			
			//Call chooseSongs
			totalCost = chooseSongs(numberOfsongs);
			//Call serviceCost
			serviceCost = calcServiceCharge(numberOfsongs,totalCost);
			//call totalDue
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
			
			//Call outputResults
			outputResults(customerName,customerID,numberOfsongs,totalCost,serviceCost,totalDue);
			
			//Ask for next ID
			System.out.println("\nWhat is Your Customer ID?");
			customerID = keyboard.nextInt();
		}//while
		
		//Compute overallAverage and Print Post-Loop Summary
		overallAverage = overallBill/numOfcustomers;
		System.out.println("\nIn Total There Were "+numOfcustomers+" Customer(s) Processed");
		System.out.printf("The Highest Bill Amount Was: $%.2f\n",(highestCharge/100));
		System.out.println("The Customer ID Associated With The Highest Bill Was Customer #"+customerIDhighest);
		System.out.printf("The Lowest Bill Amount Was: $%.2f\n",(lowestCharge/100));
		System.out.println("The Customer ID Associated With The Lowest Bill Was Customer #"+customerIDlowest);
		System.out.printf("The Total Cost of All Music Purchased Was: $%.2f\n",(overallBill/100));
		System.out.printf("The Average Bill of All Purchase Amounts Was: $%.2f\n",(overallAverage/100));
	}//main

	public static double chooseSongs(int numSongs)
	{
		//Declare Variables
		int songLength = 0;
		String genre = "";
		char genreChar = ' ';
		double songCost = 0.0;
		double totalCostcalculated = 0.0;
		boolean foundGenre = false;
		
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
				switch (genreChar)
				{
					case 'P':
						foundGenre = true;
						songCost = songLength * .35;
						break;
					case 'R':
						foundGenre = true;
						songCost = songLength * .54;
						break;
					case 'C':
						foundGenre = true;
						songCost = songLength * .25;
						break;
					case 'G':
						foundGenre = true;
						songCost = songLength * .40;
						break;
					case 'O':
						foundGenre = true;
						songCost = songLength * .30;
						break;
					
				}//switch
				
			}//do
			while(foundGenre == false);
			totalCostcalculated += songCost;
		}//for
		return totalCostcalculated;
	}//chooseSongs
	
	public static double calcServiceCharge(int numberOfsongs,double totalCost)
	{
		double result = 0.0;
		if (numberOfsongs <5) 
			result = .15* totalCost;
		else if(numberOfsongs < 10) 
			result = .12 * totalCost;
			else if(numberOfsongs < 15) 
				result = .09 * totalCost;
				else 
					result = .06 * totalCost;
		return result;
	}//calcServiceCharge
	
	public static double calcTotalDue(double totalCost, double serviceCost)
	{
		double tax = (totalCost + serviceCost)*.08;
		return (tax+totalCost+serviceCost);
	}//calcTotalDue
	
	public static void outputResults(String customerNameResult,int customerIDresult, int numSongs,double totalCostResult,double serviceChargeResult,double totalDueResult)
	{
		System.out.println("Results for Customer: "+customerNameResult);
		System.out.println("Customer ID Number: #"+customerIDresult);
		System.out.println("There were "+numSongs+" Songs Purchased");
		System.out.printf("The Total Cost of These Songs Is: $%.2f\n",(totalCostResult/100));
		System.out.printf("The Service Charge Amount Is: $%.2f\n",(serviceChargeResult/100));
		System.out.printf("The Total Amount Due Is $%.2f\n",(totalDueResult/100));
		
	}//outputResults
		
		 
}//MusicOrdersFarrell
