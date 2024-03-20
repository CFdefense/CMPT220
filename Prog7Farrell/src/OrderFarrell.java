import java.util.*;
/**
 * Class OrderFarrell contains the order list and methods to manipulate the contents of that order
 */
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
	
	/**
	 * findMostExpensive Method accepts no parameters and sifts through the order looking for the most expensive item then returns it <br>
	 * @return mostExpensiveItem	returns the object that has the highest price
	 */
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
	
	/**
	 * findLeastExpensive Method accepts no parameters and sifts through the order looking for the least expensive item then returns it <br>
	 * @return leastExpensiveItem	returns the object that has the lowest price
	 */
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
	
	/**
	 * calcTotal Method accepts no parameters and sifts through the list, tallies up the total price the order will cost <br>
	 * @return totalCost	value of all Object's price * quantity in the order
	 */
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
	
	/**
	 * printList Method accepts no parameters and prints the name, quantity, and price of each item in the order<br>
	 */
	public void printList()
	{
		if(mySize != 0)
		{
		System.out.println("This Order Contains the following...");
		//for each item of type MenuItemFarrell in myMenuItems we print its name, quantity and price
		for(MenuItemFarrell item : myMenuItems)
			if(item != null)
				System.out.printf("Item: %s - Quantity: %d - Price: $%.2f ea\n", item.getName(), item.getQuant(), item.getPrice());
		System.out.println();
		}//if
		else
			System.out.println("Order is Empty \n");
	}//printList
	
	/**
	 * removeItem Method accepts no parameters, the method removes the most expensive item from the order <br>
	 * @return result	returns the most expensive item that was removed
	 */
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

