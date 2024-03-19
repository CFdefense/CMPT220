
import java.util.*;
/**
 * This Class will control the creation and modification of Menu item Elements
 */
public class MenuItemFarrell 
{
	//Initialize Variables 
	/**
	 *String for Name of Menu Item
	 */
	private String myName;
	/**
	 * Integer for Quantity of Menu Item
	 */
	private int myQuant;
	/**
	 * Double for Price of Menu Item
	 */
	private double myPrice;
	
	/**
	 * Null Constructor for MenuItemFarrell Object to accept no parameters and create a Menu Item with Blank Information
	 */
	public MenuItemFarrell()
	{
		myName = "";
		myQuant = 0;
		myPrice = 0.0;
	}//MenuItemFarrell
	
	/**
	 * Full Constructor to accept 3 parameters and create an instance of the MenuItemFarrell Object using 3 parameters<br>
	 * @param newName	String to declare Name 
	 * @param newQuant	Integer to declare Quantity
	 * @param newPrice	double to declare Price
	 */
	public MenuItemFarrell(String newName, int newQuant, double newPrice)
	{
		myName = newName;
		myQuant = newQuant;
		myPrice = newPrice;
	}//MenuItemFarrell
	
	/**
	 * Set Name Method Will Set the Name of a Menu Item to a New Name <br>
	 * @param newName	User Input for New Name to be Set
	 */
	public void setName(String newName)
		{myName = newName;}//setName
	/**
	 * Set Quant Method Will set the Quantity of a Menu Item to a New Quantity <br>
	 * @param newQuant	User Input for New Quantity to be Set
	 */
	public void setQuant(int newQuant)
		{myQuant = newQuant;}//setQuant
	/**
	 * Set Price Method Will set the Price of a Menu Item to a New Price <br>
	 * @param newPrice	User Input for New Price to be Set
	 */
	public void setPrice(double newPrice)
		{myPrice = newPrice;}//setPrice
	
	/**
	 * Get Name Method Will Return the Name of the Menu Item <br>
	 * @return myName	Current Name of Menu Item
	 */
	public String getName()
		{return myName;}//getName
	/**
	 * Get Quant Method Will Return the Quantity of the Menu Item <br>
	 * @return myQuant	Current Quantity of Menu Item
	 */
	public int getQuant()
		{return myQuant;}//getQuant
	/**
	 * Get Price Method Will Return the Price of the Menu Item <br>
	 * @return myPrice	Current Price of Menu Item
	 */
	public double getPrice()
		{return myPrice;} //getPrice
	
	/**toString Method Will Display the Name, Quantity, and Price of a Menu Item to the Console <br>
	 * @return ans	Multi-Lined String Containing Information about Name, Quantity and Price
	 */
	public String toString()
	{
		String ans = "My Name is "+ myName + "\n";
		ans+= "My Quantity is "+ myQuant + "\n";
		ans+= "My Price is " + myPrice + "\n";
		return ans;
	}//toString

}//MenuItemFarrell