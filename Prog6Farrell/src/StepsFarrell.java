import java.util.*;
public class StepsFarrell 
{
	//Declare Instance Variables
	private int myStepWidth;
	private int myNumSteps;
	private char myFillStyle;
	
	//Constructor
	public StepsFarrell(int newStepWidth, int newNumSteps, char newFillStyle)
	{
		//Initialize Instance Variables
		myStepWidth = newStepWidth;
		myNumSteps = newNumSteps;
		myFillStyle = newFillStyle;
	}//StepsFarrell
	
	//Null Constructor
	public StepsFarrell()
	{
		//Initialize Instance Variables
		myStepWidth = 2;
		myNumSteps = 5;
		myFillStyle = '*';
	}//StepsFarrell
	
	//Method will calculate and return the number of fillStyle characters needed for the steps
	public int calcArea()
	{
		int area = 0;
		for(int step = 0; step < myNumSteps; step++)
			area += area+ myStepWidth;	
		return area;
	}//calcArea
	
	//Method will draw the steps to the console
	public void drawSteps()
	{
		//Instance Variable
		int currentStep = 0;
		
		//loop for each step and print the corresponding row
		for(int step = 0; step < myNumSteps; step++)
		{
			currentStep += myStepWidth;
			System.out.println(myFillStyle * currentStep);
		}//for
	}//drawSteps
	
	//Method will draw thick steps to the console
	public void drawThickSteps()
	{
		//Instance Variable
		int currentStep = 0;
		
		//loop for each step and print the corresponding row
		for(int step = 0; step<myNumSteps; step++)
		{
			currentStep += myStepWidth;
			for(int i = 0; i<3; i++)
				System.out.println(myFillStyle * currentStep);
		}//for
	}//drawThickSteps
	
	 
	//Instance Variable Getters, Setters and toString
	
	//myStepWidth Getter
	public int getStepWidth()
	{return myStepWidth;}//getStepWidth
	
	//myStepWidth Setter
	public void setStepWidth(int newStepWidth)
	{myStepWidth = newStepWidth;}//setStepWidth

	//myNumSteps Getter
	public int getNumSteps()
	{return myNumSteps;}//getNumSteps
	
	//myNumSteps Setter
	public void setNumSteps(int newNumSteps)
	{myNumSteps = newNumSteps;}//setNumSteps
	
	//myFillStyle Getter
	public char getFillStyle()
	{return myFillStyle;}//getFillStyle
	
	//myFillStyle Setter
	public void setFillStyle(char newFillStyle)
	{myFillStyle = newFillStyle;}//setFillStyle
	
	//toString
	public String toString()
	{
		String summaryString = "My Step Width is " + myStepWidth + "\n";
		summaryString += "My Number of Steps is " + myNumSteps + "\n";
		summaryString += "My Fill Style is '" + myFillStyle + "' \n";
		return summaryString;
	}//toString
	
}//StepsFarrell
