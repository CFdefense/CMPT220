//Christian Farrell
//Due 2/1/24 before 5:00 PM
//
//Purpose: This program computes a hospital bill using factors such as insurance plan and household income and prints it to the user.
//
//Input: Patient ID, Household Income, Insurance Plan, Number of Days
//
//Output: Patient ID, Household Income, Insurance Plan, Number of Days, Admittance Fee, Per Diem Rate, Service Fee, Discount and Total Bill
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
		
		//Get Inputs From User
		System.out.print("Enter Your Patient ID: ");
			patientID = keyboard.nextInt();
		System.out.print("Enter Your Household Income: ");
			householdIncome = keyboard.nextDouble();
		System.out.println("Enter The Character That Matches Your Insurance Plan Below\nR: Red Cross \nM: Med-Hudson \nA: ACA \nN: No Insurance");
			insurancePlan = keyboard.next();
		System.out.print("Please Enter The Length of Your Stay In Days: ");
			numOfdays = keyboard.nextInt();
		
		//Switch Statement to Identify Insurance Plan and if-else Statements to Assign the Corresponding Per Diem Rate
		firstChar = insurancePlan.charAt(0);
		switch (firstChar)
		{
		case 'R':
		case 'r':
			//RedCross
			insurancePrint = "RedCross";
			if (householdIncome < 15000)
				perDiemrate = 50;
			else if ((householdIncome == 15000 || householdIncome > 15000) && householdIncome <37500)
				perDiemrate = 70;
			else if (householdIncome > 37500)
				perDiemrate = 150;
			break;
		case 'M':
		case 'm':
			//Med-Hudson
			insurancePrint = "Med-Hudson";
			if (householdIncome < 20000)
				perDiemrate = 40;
			else if ((householdIncome == 20000 || householdIncome > 20000) && householdIncome <45000)
				perDiemrate = 75;
			else if (householdIncome > 45000)
				perDiemrate = 110;
			break;
		case 'A':
		case 'a':
			//ACA
			insurancePrint = "ACA";
			if (householdIncome < 12500)
				perDiemrate = 60;
			else if ((householdIncome == 12500 || householdIncome > 12500) && householdIncome <53000)
				perDiemrate = 75;
			else if (householdIncome > 53000)
				perDiemrate = 140;
			break;
		case 'N':
		case 'n':
			//No Insurance
			insurancePrint = "No Insurance";
			perDiemrate = 350;
			break;
		default: 
			//Unrecognized Input
			System.out.print("Unrecognized Insurance - Error");
			
		}//switch
		
		//Calculate Discount and Service Fee
		serviceFee = perDiemrate * numOfdays;
		if (numOfdays > 23)
		{
			discount = 250 * (numOfdays/7);
		}//if
		
		//Calculate Total Bill
		totalBill = admittanceFee + serviceFee - discount;
		
		//Print Output
		System.out.println("Summary for Patient #"+patientID+":");
		System.out.printf("Household Income - $%.2f\n",householdIncome);
		System.out.println("Insurance Plan - "+insurancePrint);
		System.out.println("Number of Days - "+numOfdays);
		System.out.printf("Admittance Fee - $%.2f\n",admittanceFee);
		System.out.printf("Per Diem Rate - $%.2f\n",perDiemrate);
		System.out.printf("Service Fee $%.2f\n",serviceFee);
		System.out.printf("Discount - $%.2f\n",discount);
		System.out.printf("Total Bill is $%.2f\n",totalBill);
		System.out.println("\nGoodbye!");
		
	}//main
		
	
}//HospitalFarrell
