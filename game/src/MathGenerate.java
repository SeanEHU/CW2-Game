public class MathGenerate {

	public static void main(String[] args) {
		mathAddition();
		mathMultiply();
		mathSubtract();
		mathDivide();
	}
	
	public static int[] mathAddition() {	// Method which finds two random numbers which is equal to or less than 30 when added together
		int min = 2;
		int max = 29;
		
		int firstNum = randomNum(min,max);	// Calls the random number class to find a random number between the min and max values inclusive
		max = 30 - firstNum;	// After the first number is created, this finds the new max to ensure the sum will be equal to or less than 30
		int lastNum = randomNum(min,max);	// Calls the random number class to find the second random number
		
		int[] numbers = {firstNum, lastNum};	// Adds both numbers to an array
		System.out.println(firstNum + " + " + lastNum);
		return numbers;
	}
	
	public static int[] mathMultiply() {	// This method finds two numbers which when multiplied is equal to or less than 30
		int min = 2;
		int max = 15;
		
		int firstNum = randomNum(min,max);
		max = 30 / firstNum;	// The integer divide will find the max value which will be equal to or less than 30
		int lastNum = randomNum(min,max);
		
		int[] numbers = {firstNum, lastNum};
		System.out.println(firstNum + " * " + lastNum);
		return numbers;
	}
	
	public static int[] mathSubtract() {	// This method finds two numbers that when subtracted is less than 30
		int min = 4;
		int max = 30;
		
		int firstNum = randomNum(min,max);
		max = firstNum - 1;	// Sets the max as one less than the first generated value
		min = 1;
		int lastNum = randomNum(min,max);
		
		int[] numbers = {firstNum, lastNum};
		System.out.println(firstNum + " - " + lastNum);
		return numbers;
	}
	
	public static int[] mathDivide() {
		int min = 2;
		int max = 15;
		
		int lastNum = randomNum(min,max);
		int secondNum = randomNum(min,max);
		
		int firstNum = lastNum * secondNum;
		System.out.println(firstNum + " / " + lastNum);
		int[] numbers = {firstNum, lastNum};
		
		return numbers;
		
	}
	
	public static int randomNum(int min, int max) {
		int rand = (int)Math.floor(Math.random()*(max-min+1)+min);	// This generates a random number between the min and max values
		
		return rand;
	}
}
