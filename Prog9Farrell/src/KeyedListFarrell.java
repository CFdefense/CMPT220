/**
 * KeyedList Class to Create and Modify Ordered Army of Pokemon
 */
public class KeyedListFarrell {
	//Declare Variables
	/**
	 * PokemonFarrell array myArmy to contain the PokemonFarrell Objects
	 */
	private PokemonFarrell[] myArmy;
	/**
	 * int mySize to represent the size of the array which is full
	 */
	private int mySize;
	
	/**
	 * Null Constructor for KeyedList
	 */
	public KeyedListFarrell() {
		//Initialize Variables
		mySize = 0;
		myArmy = new PokemonFarrell[10];
		//Initialize all Pokemon with Null Constructor
		for(int i = 0 ; i < myArmy.length ; i++)
			myArmy[i] = new PokemonFarrell(); 
		
	}//KeyedListFarrell
	
	/**
	 * getSize Method to return the Size of the Army
	 * @return mySize	The Size of the Army
	 */
	public int getSize() 
	{return(mySize);}//getSize
	
	/**
	 * Clear Method to 'Reset' Pokemon Army
	 */
	public void clear() {
		for(int i = 0 ; i < mySize ; i++)
			myArmy[i] = new PokemonFarrell();
		mySize = 0;
	}//clear
	
	/**
	 * findIndex Method to find the location in the Keyed List
	 * @param keyValue	The Name of the Pokemon Whose Index is to be Found
	 * @return index	The Index of the Pokemon
	 */
	private int findIndex(String keyValue) {
		//Instance Variables
		int index = -1;
		int i = 0;
		String comparedName = "";
		while((index == -1) && (i < mySize))
		{
			comparedName = myArmy[i].getName();
			if((comparedName.equalsIgnoreCase(keyValue)))
				index = i;
			i++;
		}//if
		return index;
	}//findIndex
	
	/**
	 * add Method to accept a new Pokemon Object and add it to the correct place in the list
	 * @param newPoke	The New Pokemon Object to be added
	 * @return found	Boolean to indicate the success or failure of the method
	 */
	public boolean add(PokemonFarrell newPoke) {
		//Instance Variables
		int i = 0;
		int j = 0;
		boolean found = false;
		//check if there is room and make sure the Pokemon has no Duplicates
		if((mySize < myArmy.length)&&(findIndex(newPoke.getName()) == -1)){
			//loop while the pokemon name is greater than the one at i
			while((newPoke.getName().compareToIgnoreCase(myArmy[i].getName()) > 0) && (i<mySize))
				i++;
			//Scooch
			for(j = mySize - 1 ; j >= i ; j--)
				myArmy[j+1] = myArmy[j];
			//add new Pokemon
			myArmy[i] = newPoke;
			//update Result, Increment Size
			found = true;
			mySize++;
		}//if
		return found;
	}//add
	
	/**
	 * remove Method to find, remove and adjust the list accordingly
	 * @param keyValue	The name of the Pokemon to be removed
	 * @return deleted	Boolean to represent the success or failure of the method
	 */
	public boolean remove(String keyValue) {
		//Instance variables
		int i = 0;
		boolean deleted = false;
		int deleteLoc = (findIndex(keyValue));
		//Check if populated and if it has an index
		if((mySize != 0) && deleteLoc != -1) {
			//Scooch
			for(i = deleteLoc ; i < mySize - 1 ; i++)
				myArmy[i] = myArmy[i+1];
			mySize--;
			deleted = true;
		}//if
		return deleted;
	}//remove
	
	/**
	 * Retrieve Method to search for a specified Pokemon
	 * @param keyValue	the name of the Pokemon to be retrieved
	 * @return retrieved	the found object corresponding to the name
	 */
	public PokemonFarrell retrieve(String keyValue) {
		//Instance Variables
		PokemonFarrell retrieved = null;
		int i = 0;
		while((retrieved == null) && (i < mySize))
		{
			if((myArmy[i].getName().equalsIgnoreCase(keyValue)))
				retrieved = myArmy[i];
			i++;
		}//if
		return retrieved;
	}//retrieve
	
	/**
	 * isEmpty Method to determine if the list is empty
	 * @return result	returns true if list is empty, false otherwise
	 */
	public boolean isEmpty() {
		//Instance Variable
		boolean result = false;
		//
		if(mySize == 0)
			result = true;
		
		return result;
	}//isEmpty
	
	/**
	 * Method isFull to determine if the list is full
	 * @return result	returns true if list full, false otherwise
	 */
	public boolean isFull() {
		//Instance Variable
		boolean result = true;
		
		if(mySize < myArmy.length)
			result = false;
		
		return result;
	}//isFull
	
	/**
	 * print Method to Print Out each Objects toString information in the List
	 */
	public void print() {
		//List should already be in order so we just go through and toString
		if (mySize != 0)
		{
		for(int i = 0 ; i < mySize ; i++)
			System.out.println(myArmy[i].toString());
		}
		else
			System.out.println("Army Is Empty");
	}//print
	
	/**
	 * getTotalPower Method to calculate the total power of the army
	 * @return totalPower	the calculated total power amount
	 */
	public double getTotalPower() {
		//Instance Variables
		double totalPower = 0;
		//Sum the power
		for(int i = 0 ; i < mySize ; i++)
			totalPower += myArmy[i].getPower();
		return totalPower;
	}//getTotalPower
	
	/**
	 * calcBonusPower Method to calculate the total bonus power of the army
	 * @return totalBonusPower	the total bonus power of the army
	 */
	public double calcBonusPower() {
		//Instance Variables
		double totalBonusPower = 0;
		//Sum the Power
		for(int i = 0 ; i < mySize ; i++)
			totalBonusPower += (myArmy[i].getPower() * myArmy[i].getMultiplier());
		return totalBonusPower;
	}//getBonusPower
}//KeyedListFarrell
