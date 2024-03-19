import java.util.*;
public class MenuItemFarrell 
{
	private String myName; //a String, representing the name of the MenuItem
	private int myQuant; //an integer, representing the quantity of this MenuItem
	private double myPrice; //a double, representing the price of one of these MenuItems.
	
	//Null Constructor
	public MenuItemFarrell()
	{
		myName = "";
		myQuant = 0;
		myPrice = 0.0;
	}//MenuItemFarrell
	
	//Full Constructor
	public MenuItemFarrell(String newName, int newQuant, double newPrice)
	{
		myName = newName;
		myQuant = newQuant;
		myPrice = newPrice;
	}//MenuItemFarrell
	
	
	//myName Setter
	public void setName(String newName)
		{myName = newName;}//setName
	//myQuant Setter
	public void setQuant(int newQuant)
		{myQuant = newQuant;}//setQuant
	//myPrice Setter
	public void setPrice(double newPrice)
		{myPrice = newPrice;}//setPrice
	
	//myName Getter
	public String getName()
		{return myName;}//getName
	//myQuant Getter
	public int getQuant()
		{return myQuant;}//getQuant
	//myPrice Getter
	public double getPrice()
		{return myPrice;} //getPrice
	
	//toString Method
	public String toString()
	{
		String ans = "My Name is "+ myName + "\n";
		ans+= "My Quantity is "+ myQuant + "\n";
		ans+= "My Price is " + myPrice + "\n";
		return ans;
	}//toString

}//MenuItemFarrell