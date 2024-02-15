//Christian Farrell
//Prog 3
//Due 02/08/24 @ 9:00 AM
//
//Purpose: This program computes and prints a hospital bill for patients
//After each patient's bill is processed it outputs a summary of the patient's bill.
//When 0 is entered into patient ID, it prints the summary statistics for all patients processed.
//
//Input: Patient ID, Household Income, Insurance Plan, and Length of Stay in Days
//
//Output: Household Income, Insurance Plan, Number of Days, Admittance Fee, Per Diem Rate
//Service Fee, Discount, Total Bill, Total Patients Processed, Highest Bill Paid, Patient ID with the highest bill
//Total Sum of Processed Bills, and Average Bill Amount
//
//Certification of Authenticity: I certify that this lab is entirely my own work

import java.util.*;
public class HospitalFarrell {
	
	//Declare Keyboard
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		
		//Declare and Initialize Variables
		int patientID = 0;
		int numOfpatients = 0;
		double highestBill = 0;
		int highestBillpatient = 0;
		double totalBillsum = 0;
		double averageBill = 0;
		
		System.out.print("Enter Your Patient ID: ");
		patientID = keyboard.nextInt();
		while(patientID != 0)
		{
			//New patient
			numOfpatients++;
		
			//Declare and Initialize Variables
			
			double householdIncome = 0;
			String insurancePlan = "";
			String insurancePrint = "";
			char firstChar;
			int numOfdays = 0;
			double admittanceFee = 300;
			double perDiemrate = 0;
			double serviceFee = 0;
			double discount = 0;
			double totalBill = 0;
			boolean validInsurance = false;
			
			//Get Inputs From User and check for bad inputs
				do
				{
			System.out.print("Enter Your Household Income (Cannot be Negative): ");
				householdIncome = keyboard.nextDouble();
				}//do
				while (householdIncome < 0);
				
				do
				{
				System.out.println("Enter The Character That Matches Your Insurance Plan Below\nR: Red Cross \nM: Med-Hudson \nA: ACA \nN: No Insurance");
				insurancePlan = keyboard.next();
				firstChar = insurancePlan.charAt(0);
					switch (firstChar)
					{
					case 'R':
					case 'r':
						//RedCross
						validInsurance = true;
						insurancePrint = "RedCross";
						if (householdIncome < 15000)
							perDiemrate = 50;
						else if (householdIncome < 37500 || householdIncome == 37500)
							perDiemrate = 70;
						else 
							perDiemrate = 150;
						break;
					case 'M':
					case 'm':
						//Med-Hudson
						validInsurance = true;
						insurancePrint = "Med-Hudson";
						if (householdIncome < 20000)
							perDiemrate = 40;
						else if (householdIncome <45000 || householdIncome == 45000)
							perDiemrate = 75;
						else
							perDiemrate = 110;
						break;
					case 'A':
					case 'a':
						//ACA
						validInsurance = true;
						insurancePrint = "ACA";
						if (householdIncome < 12500)
							perDiemrate = 60;
						else if (householdIncome <53000 || householdIncome == 53000)
							perDiemrate = 75;
						else
							perDiemrate = 140;
						break;
					case 'N':
					case 'n':
						//No Insurance
						validInsurance = true;
						insurancePrint = "No Insurance";
						perDiemrate = 350;
						break;
					}//switch
				}//do
				while(validInsurance == false);
				do
				{
			System.out.print("Please Enter The Length of Your Stay In Days (1-365): ");
				numOfdays = keyboard.nextInt();
				}//do
				while(numOfdays <1 || numOfdays >365);
			
			//Switch Statement to Identify Insurance Plan and if-else Statements to Assign the Corresponding Per Diem Rate
			
			
			//Calculate Discount and Service Fee
			serviceFee = perDiemrate * numOfdays;
			if (numOfdays > 23)
			{
				discount = 250 * (numOfdays/7);
			}//if
			
			//Calculate Total Bill & Update Summary Statistics
			totalBill = admittanceFee + serviceFee - discount;
			totalBillsum += totalBill;
			averageBill = totalBillsum/numOfpatients;
			if (totalBill > highestBill) 
				{
				highestBill = totalBill;
				highestBillpatient = patientID;
				}//if
			
			//Print Output
			System.out.println("Summary for Patient: #"+patientID+":");
			System.out.printf("Household Income - $%.2f\n",householdIncome);
			System.out.println("Insurance Plan - "+insurancePrint);
			System.out.println("Number of Days - "+numOfdays);
			System.out.printf("Admittance Fee - $%.2f\n",admittanceFee);
			System.out.printf("Per Diem Rate - $%.2f\n",perDiemrate);
			System.out.printf("Service Fee $%.2f\n",serviceFee);
			System.out.printf("Discount - $%.2f\n",discount);
			System.out.printf("Total Bill is $%.2f\n",totalBill);
			
			System.out.print("\nEnter Your Patient ID:");
			patientID = keyboard.nextInt();
		}//while
		
		//Print out Summary Data
		System.out.println("Total Patients Processed: "+numOfpatients);
		System.out.printf("Highest Bill Paid Was: $%.2f\n", highestBill);
		System.out.println("The Highest Bill Was Paid by Patient ID: #"+highestBillpatient);
		System.out.printf("Total Sum of Processed Bills Was : $%.2f\n",totalBillsum);
		System.out.printf("The Average Bill Amount Was: $%.2f\n",(averageBill));
		System.out.println("Thank You!");
		
	}//main
		
	
}//HospitalFarrell
