import java.util.Scanner;
/**
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Akhond Sarah mesbah
 * Student Number:041009466  
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * @author/Professor James Mwangi PhD. 
 * @author Linda Crane
 * @author Melissa Sienkiewicz
 */
public class Numbers {

	/**
	 * Stores Float values.
	 */
	private Float [] numbers;
	
	/**
	 * Store the number of items currently in the array.
	 */
	private int numberofItems;

	/**
	 * Default Constructor
	 */
	public Numbers() {
		// TODO Write code here to initialize a "default" array since this is the default constructor
	numbers= new Float [1000];
	
	}

	/**
	 * Constructor that initializes the numbers array.
	 * @param size - Max size of the numbers array
	 */
	public Numbers(int size) {
		// TODO Write code here to initialize the numbers array of max 'size'
	numbers =new Float [size];
	
	}
	
	/**
	 * Adds a value in the array
	 * @param keyboard - Scanner object to use for input
	 */
	public void addValue(Scanner keyboard) {
	
	try {
		if (numberofItems < numbers.length) {
			System.out.print("Enter value: ");
			numbers[numberofItems]= keyboard.nextFloat();
			numberofItems++;
		}else {
			System.out.println("the array is full");
		};
	}catch (Exception e) {
		System.out.println("You can only input number !!");
	}
	
	}
	
	/**
	 * Calculates the average of all the values in the numbers array.
	 * @return float value that represents the average
	 */
	public float calcAverage() {
		// TODO Write code to return the average of the values in the array
		float avg=0;
		for (int i=0; i<numberofItems; i++) {
			avg+= (numbers [i])/numberofItems;
			
		}
		
		return  (float) avg;
	}
/**
 * toString method to display the numbers in array
 */
	@Override
	public String toString() {
		// TODO Write code for an appropriate toString method
		String a= "";
		System.out.println("Numbers are: ");
		for (int i=0; i<numberofItems; i++) {
			a=a.concat (numbers[i].toString().concat("\n"));
		}
		return a;
	}
	
}
