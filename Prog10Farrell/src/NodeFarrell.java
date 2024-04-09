/**
 * NodeFarrell Class describes the creation and manipulation of a node to be used in a Linked List
 */
public class NodeFarrell {
	/**
	 * myData represents the Pokemon Object stored in the Node
	 */
	private PokemonFarrell myData;
	/**
	 * myNext represents the next Node in the Linked List
	 */
	private NodeFarrell myNext;
	
	/**
	 * Default Constructor to construct a null Node
	 */
	public NodeFarrell() {
		myData = new PokemonFarrell();
		myNext = null;
	}//NodeFarrell
	
	/**
	 * Semi-Full Constructor to construct a Node with data but no next Node
	 * @param newData	The Pokemon to be Stored in the Node
	 */
	public NodeFarrell(PokemonFarrell newData) {
		myData = newData;
		myNext = null;
	}//Node
	
	/**
	 * Full Node Constructor to Construct a Node with Data and Next Node
	 * @param newData	The Pokemon to be Stored in the Node
	 * @param newNext	The Next Node in the linked list
	 */
	public NodeFarrell(PokemonFarrell newData, NodeFarrell newNext) {
		myData = newData;
		myNext = newNext;
	}//NodeFarrell
	
	/**
	 * Method to return current Node data
	 * @return myData	The Pokemon Object stored in the Node
	 */
	public PokemonFarrell getData() {
		return myData;
	}//getPokemon
	
	/**
	 * Method to return the Next Node in the Linked List
	 * @return myNext	The Next Node Object
	 */
	public NodeFarrell getNext() {
		return myNext;
	}//getNext
	
	/**
	 * Method to update the Pokemon Object Data in the Node
	 * @param newPoke	The New Pokemon Objct
	 */
	public void setData(PokemonFarrell newPoke) {
		myData = newPoke;
	}//setPokemon
	
	/**
	 * Method to update the Next Node in the Linked List
	 * @param newNext	The New Next Node 
	 */
	public void setNext(NodeFarrell newNext) {
		myNext = newNext;
	}//setNext
	
}//NodeFarrell
