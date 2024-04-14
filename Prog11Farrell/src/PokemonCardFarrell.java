/**
 * PokemonFarrell Class to describe and Modify a PokemonFarrell Object
 */
public class PokemonCardFarrell {
	//Initialize Variables
	/**
	 * String myName depicts the Pokemon Object's Name
	 */
	private String myName;
	/**
	 * int myMultiplier depicts the Pokemon Object's Multiplier
	 */
	private int myMultiplier;
	/**
	 * double myPower depicts the Pokemon Object's Power
	 */
	private double myPower;
	
	/**
	 * PokemonFarrell Default Constructor
	 */
	public PokemonCardFarrell() {
		myName = "";
		myMultiplier = 0;
		myPower = 0.0;
	}//PokemonFarrell
	
	/**
	 * PokemonFarrell Full Constructor
	 * @param newName	New Name to be Applied to the Pokemon Object
	 * @param newMultiplier	New Multiplier to be Applied to the Pokemon Object
	 * @param newPower	New Power to be Applied to the Pokemon Object
	 */
	public PokemonCardFarrell(String newName, int newMultiplier, double newPower) {
		myName = newName;
		myMultiplier = newMultiplier;
		myPower = newPower;
	}//PokemonFarrell
	
	/**
	 * getName Method to return the current Name
	 * @return myName	The Current Name of the Pokemon
	 */
	public String getName() {
		return myName;}//getName
	/**
	 * getMultiplier Method to return the current Multiplier
	 * @return myMultiplier	The Current Multiplier of the Pokemon
	 */
	public int getMultiplier() {
		return myMultiplier;}//getMultiplier
	/**
	 * getPower Method to return the current Power
	 * @return myPower	The Current Power of the Pokemon
	 */
	public double getPower() {
		return myPower;}//getPower
	/**
	 * setName Method to update the name of the Pokemon
	 * @param newName	the new name to be implemented
	 */
	public void setName(String newName) {
		myName = newName;}//setName
	/**
	 * setMultiplier Method to update the multiplier of the Pokemon
	 * @param newMultiplier	the new multiplier to be implemented
	 */
	public void setMultiplier(int newMultiplier) {
		myMultiplier = newMultiplier;}//setMultiplier
	/**
	 * setPower Method to update the power of the Pokemon
	 * @param newPower the new power to be implemented
	 */
	public void setPower(double newPower) {
		myPower = newPower;}//setPower
	/**
	 * toString Method to convert the current name, multipler and power of the pokemon into a well formatted string
	 */
	public String toString() {
		String ans = "Name : " + myName + "\n";
		ans += "Multiplier : "+ myMultiplier + "\n";
		ans += "Power : " + myPower + "\n";
		return ans;
	}
}//PokemonFarrell
