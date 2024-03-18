import java.util.*;
public class OrderDemoFarrell 
{
	//Declare Keyboard
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
		String badItem = "";
		boolean removalSuccess = false;
	//Welcome user and print menu
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
			System.out.println("What Menu Item Would You Like?");
			newItemName = keyboard.next();
			System.out.println("What is the Menu Item's Price?");
			newItemPrice = keyboard.nextDouble();
			System.out.println("How Many Would You Like?");
			newItemQuantity = keyboard.nextInt();
			
			//create new menuItem and add to order
			MenuItemFarrell newItem = new MenuItemFarrell(newItemName, newItemQuantity, newItemPrice); //should be done here?
			resultSuccess = myOrder.addToOrder(newItem);
			
			//let user know
			if(resultSuccess == true)
				System.out.println("Sucessfully Added the MenuItem");
			else
				System.out.println("Adding the MenuItem has Failed");
			break;
		//Find the Least Expensive MenuItem
		case 'L':
			System.out.println("The Least Expensive Item is "+myOrder.findLeastExpensive());
			break;
		//Find the Most Expensive MenuItem
		case 'M':
			System.out.println("The Most Expensive Item is "+myOrder.findMostExpensive());
			break;
		//Find the number of MenuItems
		case 'N':
			System.out.println("The Order has " + myOrder.getSize() + " Menu Items");
			break;
		//Find the total cost of all MenuItems
		case 'T':
			System.out.println("The total cost of all MenuItems is "+ myOrder.calcTotal());
			break;
		//Print out details about all MenuItems
		case 'P':
			myOrder.printList();
			break;
		//Delete the Most Expensive MenuItem
		case 'D':
			System.out.println("Enter the Name of the Item you Wish to Remove");
			badItem = keyboard.next();
			myOrder.removeItem(badItem);
			//let user know
			if(removalSuccess == true)
				System.out.println("Sucessfully Removed the MenuItem");
			else
				System.out.println("Removing the MenuItem has Failed");
			break;
		//Quit
		case 'Q':
			break;
		}//switch
	}//do
	while(userInput != 'Q');
	}//main


}//OrderDemoFarrell
