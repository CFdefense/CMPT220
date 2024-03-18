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
		
		if(mySize < 8) //Should be hard-coded???
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
		for(int i = 0; i < myMenuItems.length;i++)
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
		for(int i = 0; i < myMenuItems.length;i++)
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
		
		return totalCost;
	}//calcTotal
}//OrderFarrell

