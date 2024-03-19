/**
 * @author Christian Farrell <br>
 * 
 * Prog 7 <br>
 * Due Date and Time: 2/21/24 before 9:00 AM <br>
 * 
 * Purpose: This program will serve as a Mcdonalds ordering system, users will be able to add to, manipulate, and view various information about their orders. <br>
 * 
 * Input: userInput - Menu Choice, newItemName - Item to add to Order, newItemQuality - How Many Items to add, and newItemPrice - The Price of That Item <br>
 * 
 * Output: resultSucess, leastExpensiveItem, mostExpensiveItem, orderSize, totalCost, removedItemSuccess <br>
 * 
 *Certification of Authenticity: <br>
 *I certify that this lab is entirely my own work. <br>
 */





import java.util.*;
public class OrderDemoFarrell 
{
	//Declare and Initialize Scanner 
	static Scanner keyboard = new Scanner(System.in);
		
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
			System.out.println("What is the Menu Item's Price?");
			newItemPrice = keyboard.nextDouble();
			System.out.println("How Many Would You Like?");
			newItemQuantity = keyboard.nextInt();
			
			//create new menuItem and add to order
			newItem = new MenuItemFarrell(newItemName, newItemQuantity, newItemPrice); 
			resultSuccess = myOrder.addToOrder(newItem);
			
			//let user know result
			if(resultSuccess == true)
				System.out.println("Sucessfully Added the MenuItem \n");
			else
				System.out.println("Adding the MenuItem has Failed \n");
			break;
		//Find the Least Expensive MenuItem
		case 'L':
			if(myOrder.findLeastExpensive() != null)
				System.out.println("The Least Expensive Item is the "+ myOrder.findLeastExpensive().getName() + "\n");
			else
				System.out.println("Order is Empty \n");
			break;
		//Find the Most Expensive MenuItem
		case 'M':
			if(myOrder.findLeastExpensive() != null)
			System.out.println("The Most Expensive Item is the "+myOrder.findMostExpensive().getName() + "\n");
			else
				System.out.println("Order is empty \n");
			break;
		//Find the number of MenuItems
		case 'N':
			System.out.println("The Order has " + myOrder.getSize() + " Menu Items\n");
			break;
		//Find the total cost of all MenuItems
		case 'T':
			if(myOrder.calcTotal() != 0)
				System.out.printf("The total cost of all MenuItems is %.2f\n\n", myOrder.calcTotal());
			else
				System.out.println("Order is empty\n");
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
				System.out.println("Sucessfully Removed the MenuItem \n");
			else
				System.out.println("Removing the MenuItem has Failed \n");
			break;
		//Quit
		case 'Q':
			break;
		}//switch
	}//do
	while(userInput != 'Q');
	System.out.println("Thanks,Goodbye");
	}//main	
}//OrderDemoFarrell
