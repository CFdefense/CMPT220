/**
 * StackFarrell Class Describes a Stack LIFO Data Structure Comprised of Nodes  
 */
public class StackFarrell {
	/**
	 * Node to show the top Node in the Stack
	 */
	private NodeFarrell myTop;
	
	/**
	 * Default Constructor
	 */
	public StackFarrell() {
		myTop = null;
	}//StackFarrell
	
	/**
	 * isFull Method to Determine if the Stack is Full
	 * @return false	Will always be false
	 */
	public boolean isFull() {return false;}//isFull 
	
	/**
	 * isEmpty Method to Determine if the Stack is Empty
	 * @return myTop's value	If there is null return true else false
	 */
	public boolean isEmpty() {return myTop == null;}//isEmpty
	
	/**
	 * push Method to Add a New Node to the top of the Stack
	 * @param newPoke	The Data of the Node to be added to the Stack
	 * @return result	The Success or Failure of the push
	 */
	public boolean push(PokemonCardFarrell newPoke) {
		//instance variables
		boolean result = false;
		NodeFarrell newGuy = null;
		
		//check if linked list is full
		if(!isFull()) {
			//update result and create new Node
			result = true;
			newGuy = new NodeFarrell(newPoke);
			//update references
			newGuy.setNext(myTop);
			myTop = newGuy;
		}//if
		return result;
	}//push
	
	/**
	 * pop Method to remove and return the top Node's Data in the Stack
	 * @return result	Pokemon Card at the Top of the Stack
	 */
	public PokemonCardFarrell pop() {
		//Instance Variables
		PokemonCardFarrell result = null;
		
		//Check if Empty
		if(!isEmpty()) {
			//update result
			result = myTop.getData();
			//update references
			myTop = myTop.getNext();
		}//if
		return result;
	}//pop
	
}//StackFarrell
