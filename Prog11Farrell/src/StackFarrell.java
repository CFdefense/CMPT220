//Stack Class

public class StackFarrell {
	//Instance Variables
	private NodeFarrell myTop;
	
	//Default Constructor
	public StackFarrell() {
		myTop = null;
	}//StackFarrell
	
	//isFull Method
	public boolean isFull() {return false;}//isFull
	
	//isEmpty Method
	public boolean isEmpty() {return myTop == null;}//isEmpty
	
	//push Method
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
	
	//pop Method
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
	
	//copy Method
	public void copy(StackFarrell firstStack, StackFarrell secondStack) {
		//instance variables
		StackFarrell tempStack = new StackFarrell();
		
		//Copy First Stack to Temp
		while(!firstStack.isEmpty()) 
			tempStack.push(firstStack.pop());
		  
		//Copy Temp to Second Stack
		while(!tempStack.isEmpty()) 
			secondStack.push(tempStack.pop());
	}//copy
	
}//StackFarrell
