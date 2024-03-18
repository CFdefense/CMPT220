import java.util.*;
public class OrderFarrell
{
	private MenuItemFarrell[] myMenuItems;
	private int mySize;
	
	//Null Constructor
	public OrderFarrell()
	{
		myMenuItems = new MenuItemFarrell[8];
		mySize = 0;
	}//OrderFarrell
	
	//mySize Getter
	public int getSize()
		{return mySize;}//getSize
	
	//addToOrder - (DESC)
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
		System.out.println("This Order Contains the following...");
		//for loop to print the details of the name, quant and price for each menu item in the list
		for(int i = 0; i<mySize;i++)
			System.out.printf("%s - ct: %d - $%.2f\n", myMenuItems[i].getName(), myMenuItems[i].getQuant(), myMenuItems[i].getPrice());
	}//printList
	
	//removeItem - (DESC)
	public boolean removeItem(String toBeRemoved)
	{
		//Instance variables
		MenuItemFarrell remove = null;
		boolean result = false;
		int i = 0;
		//find where the item to be removed is
		while (remove == null && i<mySize)
		{
			if(myMenuItems[i].getName() == toBeRemoved)
				result = true;
			else
				i++;
		}//while
		if(result == true)
			myMenuItems[i] = myMenuItems[--mySize];
		
		return result;
		
	}//removeItem
}//OrderFarrell

