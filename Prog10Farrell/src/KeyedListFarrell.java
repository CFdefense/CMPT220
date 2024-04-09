/**
 * KeyedList Class to Create and Modify Ordered Army of Pokemon
 */
public class KeyedListFarrell {
	//Declare Variables
	/**
	 * Head Node of LinkedList 
	 */
	private NodeFarrell myHead;
	/**
	 * Null Constructor for KeyedList
	 */
	public KeyedListFarrell() {
		//Initialize Variables
		myHead = null;
	}//KeyedListFarrell
	
	/**
	 * getHead Method to return the Head Node of the Army
	 * @return myHead	The Head Node of the Army
	 */
	public NodeFarrell getHead() 
	{return(myHead);}//getHead
	
	/**
	 * setHead Method to update the Head Node of the Army
	 * @param newHead	The New Head Node of the Army
	 */
	public void setHead(NodeFarrell newHead)
	{myHead = newHead;}//setHead
	
	/**
	 * Clear Method to 'Reset' Pokemon Army
	 */
	public void clear() {
		//By setting the head to null, the entire list is lost essentially clearing the list
		myHead = null;
	}//clear
	
	/**
	 * add Method to accept a new Pokemon Object and add it to the correct place in the Linked List
	 * @param newPoke	The New Pokemon Object to be added
	 * @return found	Boolean to indicate the success or failure of the method
	 */
	public boolean add(PokemonFarrell newPoke) {
		//Instance Variables
		boolean found = false;
		boolean success = false;
		NodeFarrell curr = myHead;
		NodeFarrell prev = null;
		NodeFarrell newGuy = null;
		PokemonFarrell notHere = null;
		
		//Check for Duplicates
		notHere = retrieve(newPoke.getName());
		//If No Duplicates Find It's Spot
		if(notHere == null) {
			success = true;
			newGuy = new NodeFarrell(newPoke);
			while(found == false && curr != null) {
				//if the one being indexed comes after the new pokemon
				if(curr.getData().getName().compareToIgnoreCase(newPoke.getName()) > 0) {
					found = true;
				}//if
				else {
					prev = curr;
					curr = curr.getNext();
					}//else
			}//while
			
		//Update References
		newGuy.setNext(curr); //No Matter Where NewGuy is Going, its Next Will Always Be Curr
		if(prev == null) //Check if were looking at an empty or 1st index
			myHead = newGuy;
		else
			prev.setNext(newGuy); //If Not Empty or 1st, its Middle or Last
		}//if
		return success;
	}//add
	
	/**
	 * remove Method to find, remove and adjust the Linked List accordingly
	 * @param keyValue	The name of the Pokemon to be removed
	 * @return deleted	Boolean to represent the success or failure of the method
	 */
	public boolean remove(String keyValue) {
		//Instance variables
		boolean deleted = false;
		NodeFarrell curr = myHead;
		NodeFarrell prev = null;
		
		//Find Target
		while(curr!= null && deleted == false) {
			//Check if current Pokemon equals key
			if(curr.getData().getName().equalsIgnoreCase(keyValue)) {
				deleted = true;
			}//if'
			else {
				prev = curr;
				curr = curr.getNext();
			}//else
		}//while
		//update references
		if(deleted == true) {
			if(prev == null)
				myHead = curr.getNext();
			else
				prev.setNext(curr.getNext());
		}//if
		return deleted;
		}//remove
	/**
	 * Retrieve Method to search for a specified Pokemon in the Linked List
	 * @param keyValue	the name of the Pokemon to be retrieved
	 * @return retrieved	the found object corresponding to the name
	 */
	public PokemonFarrell retrieve(String keyValue) {
		//Instance Variables
		PokemonFarrell retrieved = null;
		NodeFarrell curr = myHead;
		//Traverse Linked List to find Pokemon
		while((retrieved == null) && (curr != null))
		{
			if(curr.getData().getName().equalsIgnoreCase(keyValue))
				retrieved = curr.getData();
			else 
				curr = curr.getNext();
		}//while
		return retrieved;
	}//retrieve
	
	/**
	 * isEmpty Method to determine if the Linked List is empty
	 * @return result	returns true if List is empty, false otherwise
	 */
	public boolean isEmpty() {
		//Instance Variable
		boolean result = false;
		//check if head is null
		if(myHead == null)
			result = true;
		return result;
	}//isEmpty
	
	/**
	 * Method isFull to determine if the list is full
	 * @return result	returns false always because linked list wont be full unless RAM full
	 */
	public boolean isFull() {
		//Instance Variable
		boolean result = false;
		return result;
	}//isFull
	
	/**
	 * print Method to Print Out each Pokemon's toString information in the Linked List
	 */
	public void print() {
		//Instance Variable
		NodeFarrell curr = myHead;
		
		//Go until we reach null and print the Pokemon's toString
		while(curr != null) {
			System.out.println(curr.getData().toString());
			curr = curr.getNext();
			}//while
	}//print
	
	/**
	 * getTotalPower Method to calculate the total power of the army
	 * @return totalPower	the calculated total power amount
	 */
	public double getTotalPower() {
		//Instance Variables
		double totalPower = 0;
		NodeFarrell curr = myHead;
		//Sum the power
		while(curr != null) {
			totalPower += curr.getData().getPower();
			curr = curr.getNext();
		}//while
		return totalPower;
	}//getTotalPower
	
	/**
	 * calcBonusPower Method to calculate the total bonus power of the army
	 * @return totalBonusPower	the total bonus power of the army
	 */
	public double calcBonusPower() {
		//Instance Variables
			double totalBonusPower = 0;
			NodeFarrell curr = myHead;
			//Sum the power
			while(curr != null) {
				totalBonusPower += (curr.getData().getPower() * curr.getData().getMultiplier());
				curr = curr.getNext();
			}//while
			return totalBonusPower;
	}//getBonusPower
}//KeyedListFarrell
