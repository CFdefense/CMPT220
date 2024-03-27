
public class KeyedListFarrell {
	//Declare Variables
	private PokemonFarrell[] myArmy;
	private int mySize;
	
	//Null Constructor
	public KeyedListFarrell() {
		//Initialize Variables
		mySize = 0;
		myArmy = new PokemonFarrell[10];
		//Initialize all Pokemon with Null Constructor
		for(int i = 0 ; i < myArmy.length ; i++)
			myArmy[i] = new PokemonFarrell(); 
		
	}//KeyedListFarrell
	
	//mySize Getter
	public int getSize() 
	{return(mySize);}//getSize
	
	public void clear() {
		
	}//clear
	
	//findIndex of target keyValue using Binary Search
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
	
	//add a Pokemon to the list, no duplicates
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
	
	//
	public PokemonFarrell retrieve(String keyValue) {
		//Instance Variables
		PokemonFarrell found = null;
		int head = myArmy.length;
		int tail = 0;
		int mid = 0;			
		while((found == null) && (head != tail)) {
			mid = (head + tail) / 2;
			if(myArmy[mid].getName().equalsIgnoreCase(keyValue)) 
			found = myArmy[mid];
			else if(myArmy[mid].getName().compareToIgnoreCase(keyValue) > 0)
				tail = mid;
				else
					head = mid;
				}//while
				return found;
	}//retrieve
	
	//Check if the list is empty
	public boolean isEmpty() {
		//Instance Variable
		boolean result = false;
		//
		if(mySize == 0)
			result = true;
		
		return result;
	}//isEmpty
	
	//check if the list is full
	public boolean isFull() {
		//Instance Variable
		boolean result = true;
		
		if(mySize < myArmy.length)
			result = false;
		
		return result;
	}//isFull
	
	//Print the list in order
	public void print() {
		//List should already be in order so we just go through and toString
		for(int i = 0 ; i < mySize ; i++)
			System.out.println(myArmy[i].toString());
	}//print
	
	//sum total power of the army
	public double getTotalPower() {
		//Instance Variables
		double totalPower = 0;
		//Sum the power
		for(int i = 0 ; i < mySize ; i++)
			totalPower += myArmy[i].getPower();
		return totalPower;
	}//getTotalPower
	
	public double calcBonusPower() {
		//Instance Variables
		double totalBonusPower = 0;
		//Sum the Power
		for(int i = 0 ; i < mySize ; i++)
			totalBonusPower += (myArmy[i].getPower() * myArmy[i].getMultiplier());
		return totalBonusPower;
	}//getBonusPower
	
}//KeyedListFarrell
