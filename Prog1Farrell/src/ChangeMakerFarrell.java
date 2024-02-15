import java.util.*;

public class ChangeMakerFarrell {
	
	//Declare Keyboard for Project
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		//Declare and initialize variables
		int amount = 0;
		int originalAmount = 0;
		int quarters = 0;
		int dimes = 0;
		int nickels = 0;
		int pennies = 0;
		int oneBill = 0;
		int fiveBill = 0;
		int tenBill = 0;
		int twentyBill = 0;
		int totalBills = 0;
		int totalCoins = 0;
		
		//Greet user
		System.out.println("Welcome to the Change Maker System");
		System.out.println("Enter a whole number");
		System.out.println("I will output a combination of bills and coins");
		System.out.println("that equals that amount of change");
		
		//get input
		System.out.print("\nEnter Amount to be changed: ");
		amount = keyboard.nextInt();
		
		//calculate results
		originalAmount = amount;
		
		twentyBill = amount/2000;
		amount %=2000;
		
		tenBill = amount/1000;
		amount %=1000;
		
		fiveBill = amount/500;
		amount %= 500;
		
		oneBill = amount/100;
		amount %= 100;
		
		quarters = amount / 25;
		amount %= 25;
		
		dimes = amount / 10;
		amount %= 10;
		
		nickels = amount / 5;
		amount %= 5;
		
		pennies = amount;
		
		totalBills = twentyBill + tenBill + fiveBill + oneBill;
		totalCoins = quarters + dimes + nickels + pennies;
		
		//output results
		System.out.println(originalAmount + " cents can be given as:");
		System.out.println(twentyBill+" twenty dollar bills");
		System.out.println(tenBill+" ten dollar bills");
		System.out.println(fiveBill+" five dollar bills");
		System.out.println(oneBill+" one dollar bills");
		System.out.println(quarters+" quarters");
		System.out.println(dimes+" dimes");
		System.out.println(nickels+" nickels");
		System.out.println(pennies+" pennies");
		System.out.println("The total there were "+totalBills+" bill(s) and "+totalCoins+" coin(s)");
		
		//Thank user and close keyboard
		System.out.println("\nThanks! Goodbye");
		keyboard.close();
	}//main
}//ChangeMakerFarrell
