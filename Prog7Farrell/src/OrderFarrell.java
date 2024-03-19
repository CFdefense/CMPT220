import java.util.*;
public class OrderFarrell
{
	//Initialize Variables
	private MenuItemFarrell[] myMenuItems;
	private int mySize;
	
	//Null Constructor
	public OrderFarrell()
	{
		myMenuItems = new MenuItemFarrell[8];
		mySize = 0;
	}//OrderFarrell
	
	/**
	 * Get Size Method to return the current size of the Order <br>
	 * @return mySize	Integer representing the amount of items in the order
	 */
	public int getSize()
		{return mySize;}//getSize
	
	/**
	 * addToOrder Method accepts a menu item parameter, then checks if the order has space, adding it to the order if there is space <br>
	 * @param menuItem	MenuItemFarrell Object created by the user to be added to the order
	 * @return success	Boolean representing the success or failure of the attempt to add the MenuItem to the order
	 */
	public boolean addToOrder(MenuItemFarrell menuItem)
	{
		//instance variable
		boolean success = false;
		
		if(mySize < myMenuItems.length) //Check if space
		{
			myMenuItems[mySize++] = menuItem; //add and increment mySize
			success = true;
		}//if
		return success;
	}//addToOrder
	
	//findMostExpensive - (DESC)
	public MenuItemFarrell findMostExpensive()
	{
		//instance variables
		double mostExpensive = 0;
		MenuItemFarrell mostExpensiveItem = null;
		
		//for total the cost of the order
		for(int i = 0; i < mySize;i++)
		{
			if(myMenuItems[0].getPrice() > mostExpensive)
				{
					mostExpensiveItem = myMenuItems[i];
					mostExpensive = myMenuItems[0].getPrice();
				}//if
		}//for
		return mostExpensiveItem;
	}//findMostExpensive
	
	//findLeastExpensive - (DESC)
	public MenuItemFarrell findLeastExpensive()
	{
		//instance variables
		double leastExpensive = Double.MAX_VALUE;
		MenuItemFarrell leastExpensiveItem = null;
		
		//for total the cost of the order
		for(int i = 0; i < mySize;i++)
		{
			if(myMenuItems[0].getPrice() < leastExpensive)
				{
					leastExpensiveItem = myMenuItems[i];
					leastExpensive = myMenuItems[0].getPrice();
				}//if
		}//for
		return leastExpensiveItem;
	}//findLeastExpensive
	
	//calcTotal - (DESC)
	public double calcTotal()
	{
		//instance variables
		double totalCost = 0.0;
		
		//loop through all menu items and multiply the amount order by the price and then add that to the total cost
		for(int i = 0;i<mySize;i++)
		{
			totalCost += myMenuItems[i].getQuant() * myMenuItems[i].getPrice();
		}//for
		return totalCost;
	}//calcTotal
	
	//printList - (DESC)
	public void printList()
	{
		if(mySize != 0)
		{
		System.out.println("This Order Contains the following...");
		//for loop to print the details of the name, quant and price for each menu item in the list
		for(int i = 0; i<mySize;i++)
			System.out.printf("%s - ct: %d - $%.2f ea\n", myMenuItems[i].getName(), myMenuItems[i].getQuant(), myMenuItems[i].getPrice());
		System.out.println();
		}//if
		else
			System.out.println("Order is Empty \n");
	}//printList
	
	//removeItem - (DESC)
	public MenuItemFarrell removeItem()
	{
		//Instance variables
		MenuItemFarrell result = null;
		int positionToRemove = 0;
		int i = 0;
		int j = 0;
		double mostCostly = 0.0;
		
		//remove largest
		for(i = 0;i<mySize;i++)
		{
			//find the highest
			if(myMenuItems[i].getPrice() > mostCostly) //should this find the cost*quan or just cost
				{
				mostCostly = myMenuItems[i].getPrice();
				positionToRemove = i;
				result = myMenuItems[i];
				}//if
		}//for
		
		//set remove to last in array and decrement size
		if(result != null)
		{
			myMenuItems[positionToRemove] = myMenuItems[mySize-1];
			mySize--;
		}//if
		return result;
		
	}//removeItem
}//OrderFarrell

