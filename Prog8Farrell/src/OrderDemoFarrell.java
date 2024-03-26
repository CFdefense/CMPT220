import java.io.*;
import java.util.*;
/**Christian Farrell
 * @author Christian Farrell <br>
 * 
 * Prog 7 <br>
 * Due Date and Time: 2/21/24 before 9:00 AM <br>
 * 
 * Purpose: This program will serve as a McDonalds ordering system, users will be able to add to, manipulate, and view various information about their orders. <br>
 * 
 * Input: userInput - Menu Choice, newItemName - Item to add to Order, newItemQuality - How Many Items to add, and newItemPrice - The Price of That Item <br>
 * 
 * Output: resultSucess, leastExpensiveItem, mostExpensiveItem, orderSize, totalCost, removedItemSuccess <br>
 * 
 *Certification of Authenticity: <br>
 *I certify that this lab is entirely my own work. <br>
 */
public class OrderDemoFarrell 
{
	/**
	 * Scanner Object Declared and Initialized
	 */
	static Scanner keyboard = new Scanner(System.in);
	
	/**
	 * Empty Default Constructor needed to make JavaDoc Happy
	 */
	public OrderDemoFarrell()
	{
		
	}//OrderDemoFarrell
		
	/**
	 * Main Method to print a menu to the user, then execute the input, and repeat until q is selected
	 * @param args	ConsoleLine Input
	 */
	public static void main(String[] args) 
	{
		//Initialize Variables
		char userInput = ' ';
		String newItemName = "";
		int newItemQuantity = 0;
		double newItemPrice = 0;
		OrderFarrell myOrder = new OrderFarrell();
		boolean resultSuccess = false;
		MenuItemFarrell removedMenuItem;
		MenuItemFarrell newItem;
		int totalItems = 0;
		String fileName = null;
		int numItems = 0;
		MenuItemFarrell theLeastExpensive = null;
		MenuItemFarrell theMostExpensive = null;
		double calculatedTotal = 0.0;
		
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
	    	newItemName = input.next();
	    	newItemQuantity = input.nextInt();
	    	newItemPrice = input.nextDouble();
	    	newItem = new MenuItemFarrell(newItemName, newItemQuantity, newItemPrice);
	    	myOrder.addToOrder(newItem);
	    	
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
		System.out.println("Welcome to McDonalds! Please Select an Option From the Below Menu!");
		System.out.println("A : Add a MenuItem to the Order");
		System.out.println("L : Find the Least Expensive MenuItem in the Order");
		System.out.println("M : Find the Most Expensive MenuItem in the Order");
		System.out.println("N : Find the number of MenuItems in the Order");
		System.out.println("T : Find the total cost of all MenuItems in the Order");
		System.out.println("P : Print out details about all MenuItems in the Order");
		System.out.println("D : Delete the Most Expensive MenuItem from the Order");
		System.out.println("Q : Quit"); 
		userInput = keyboard.next().toUpperCase().charAt(0);
		
		switch(userInput)
		{
		//Add a MenuItem to the Order
		case 'A':
			System.out.println("Enter the name of the Menu Item");
			newItemName = keyboard.next();
			
			//error check the price and the quantity and get response from user
			do
			{
				System.out.println("How Many Would You Like?");
				newItemQuantity = keyboard.nextInt();
			}//do
			while(newItemQuantity <= 0);
			
			do
			{
				System.out.println("What is the Menu Item's Price?");
				newItemPrice = keyboard.nextDouble();
			}//do
			while(newItemPrice <= 0);
			//create new menuItem and add to order
			newItem = new MenuItemFarrell(newItemName, newItemQuantity, newItemPrice); 
			resultSuccess = myOrder.addToOrder(newItem);
			
			//let user know result
			if(resultSuccess == true)
				System.out.println("Sucessfully Added the MenuItem \n");
			else
				System.out.println("Adding the MenuItem has Failed, Order is Full\n");
			break;
		//Find the Least Expensive MenuItem
		case 'L':
			theLeastExpensive = myOrder.findLeastExpensive();
			if(theLeastExpensive != null)
				System.out.println("The Least Expensive Item is the \n"+ theLeastExpensive.toString() + "\n");
			else
				System.out.println("Order is Empty \n");
			break;
		//Find the Most Expensive MenuItem
		case 'M':
			theMostExpensive = myOrder.findMostExpensive();
			if(theMostExpensive != null)
			System.out.println("The Most Expensive Item is the \n" + theMostExpensive.toString() + "\n");
			else
				System.out.println("Order is empty \n");
			break;
		//Find the number of MenuItems
		case 'N':
			totalItems = myOrder.findMyQuant();
			System.out.println("The Order has " + totalItems + " Menu Items\n");
			break;
		//Find the total cost of all MenuItems
		case 'T':
			calculatedTotal = myOrder.calcTotal();
			if(calculatedTotal != 0)
				System.out.printf("The total cost of all MenuItems is $%.2f\n\n", calculatedTotal);
			else
				System.out.printf("$%.2f\n\n", calculatedTotal);
			break;
		//Print out details about all MenuItems
		case 'P':
			myOrder.printList();
			break;
		//Delete the Most Expensive MenuItem
		case 'D':
			removedMenuItem = myOrder.removeItem();
			//let user know result
			if(removedMenuItem != null)
				{
				System.out.println("Sucessfully Removed the Following Menu Item\n");
				System.out.println(removedMenuItem.toString());
				}//if	
			else
				System.out.println("Removing the MenuItem has Failed Due to Order Being Empty \n");
			break;
		//Quit
		case 'Q':
			break;
		}//switch
	}//do
	while(userInput != 'Q');
	System.out.println("Thanks, Goodbye");
	}//main	
}//OrderDemoFarrell
