
public class PokemonFarrell {
	//Initialize Variables
	private String myName;
	private int myMultiplier;
	private double myPower;
	
	//Null constructor
	public PokemonFarrell() {
		myName = "";
		myMultiplier = 0;
		myPower = 0.0;
	}//PokemonFarrell
	
	//Full Constructor
	public PokemonFarrell(String newName, int newMultiplier, double newPower) {
		myName = newName;
		myMultiplier = newMultiplier;
		myPower = newPower;
	}//PokemonFarrell
	
	//getter function for Name
	public String getName() {
		return myName;}//getName
	//getter function for Multiplier
	public int getMultiplier() {
		return myMultiplier;}//getMultiplier
	//getter function for Power
	public double getPower() {
		return myPower;}//getPower
	//setter function for Name
	public void setName(String newName) {
		myName = newName;}//setName
	//setter function for Multiplier
	public void setMultiplier(int newMultiplier) {
		myMultiplier = newMultiplier;}//setMultiplier
	//setter function for Power
	public void setPower(double newPower) {
		myPower = newPower;}//setPower
	//toString function
	public String toString() {
		String ans = "Name : " + myName + "\n";
		ans += "Multiplier : "+ myMultiplier + "\n";
		ans += "Power : " + myPower + "\n";
		return ans;
	}
}//PokemonFarrell
