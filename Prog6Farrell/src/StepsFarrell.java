public class StepsFarrell 
{
	//Declare Instance Variables
	private int myStepWidth;
	private int myNumSteps;
	private char myFillStyle;
	
	//Constructor will create a StepsFarrell object with inputted variables
	public StepsFarrell(int newStepWidth, int newNumSteps, char newFillStyle)
	{
		//Initialize Instance Variables
		myStepWidth = newStepWidth;
		myNumSteps = newNumSteps;
		myFillStyle = newFillStyle;
	}//StepsFarrell
	
	//Null Constructor will create a StepsFarrell Object with default variables
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
		//Initialize Instance Variable
		int area = 0;
		int currentStep = 0;
		
		//Loop through the 'drawing' of the steps but instead of drawing one well append the count
		for(int step = 0; step < myNumSteps; step++)
		{
			currentStep += myStepWidth;
			for(int i = 0;i<currentStep;i++)
				area++;
		}//for
		return area;
	}//calcArea
	
	//Method will draw the steps to the console
	public void drawSteps()
	{
		//Instance Variable
		int currentStep = 0;
		
		//loop for each step and then loop again for how long the currentstep is
		for(int step = 0; step < myNumSteps; step++)
		{
			currentStep += myStepWidth;
			System.out.println();
			for(int i = 0;i<currentStep;i++)
				System.out.print(myFillStyle);
			
		}//for
		System.out.println();
		System.out.println();
	}//drawSteps
	
	//Method will draw thick steps to the console
	public void drawThickSteps()
	{
		//Instance Variable
		int currentStep = 0;
		
		//loop for each step 3 times, printing for length of current step 
		System.out.println();
		for(int step = 0; step<myNumSteps; step++)
		{
			currentStep += myStepWidth;
			
			for(int i =0; i<3;i++)
			{
				System.out.println();
				for(int j = 0;j<currentStep;j++)
				System.out.print(myFillStyle);
			}
		}//for
		System.out.println();
		System.out.println();
	}//drawThickSteps
	
	 
	//Instance Variable Getters, Setters and toString
	
	//myStepWidth Getter
	public int getStepWidth()
	{return myStepWidth;}//getStepWidth
	
	//myStepWidth Setter updates stepWidth
	public void setStepWidth(int newStepWidth)
	{myStepWidth = newStepWidth;}//setStepWidth

	//myNumSteps Getter
	public int getNumSteps()
	{return myNumSteps;}//getNumSteps
	
	//myNumSteps Setter updates numSteps
	public void setNumSteps(int newNumSteps)
	{myNumSteps = newNumSteps;}//setNumSteps
	
	//myFillStyle Getter
	public char getFillStyle()
	{return myFillStyle;}//getFillStyle
	
	//myFillStyle Setter updates fillStyle
	public void setFillStyle(char newFillStyle)
	{myFillStyle = newFillStyle;}//setFillStyle
	
	//toString creates a string of the information of the object
	public String toString()
	{
		String summaryString = "My Step Width is " + myStepWidth + "\n";
		summaryString += "My Number of Steps is " + myNumSteps + "\n";
		summaryString += "My Fill Style is '" + myFillStyle + "' \n";
		return summaryString;
	}//toString
	
}//StepsFarrell
