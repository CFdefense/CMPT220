
public class NodeFarrell {
	private PokemonFarrell myData;
	private NodeFarrell myNext;
	
	//Default Constructor
	public NodeFarrell() {
		myData = new PokemonFarrell();
		myNext = null;
	}//NodeFarrell
	
	//Semi-Full Constructor
	public NodeFarrell(PokemonFarrell newData) {
		myData = newData;
		myNext = null;
	}//Node
	
	//Full Constructor
	public NodeFarrell(PokemonFarrell newData, NodeFarrell newNext) {
		myData = newData;
		myNext = newNext;
	}//NodeFarrell
	
	public PokemonFarrell getData() {
		return myData;
	}//getPokemon
	
	public NodeFarrell getNext() {
		return myNext;
	}//getNext
	
	public void setData(PokemonFarrell newPoke) {
		myData = newPoke;
	}//setPokemon
	
	public void setNext(NodeFarrell newNext) {
		myNext = newNext;
	}//setNext}
	
	//is toString needed?
	
}//NodeFarrell
