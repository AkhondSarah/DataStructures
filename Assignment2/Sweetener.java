import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Akhond Sarah Mesbah
 * @version 2.0 : I have a no args parameter now
 * Student Number 041009466
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * Assignment 2
 * Due: Sunday March 21 2021 at midnight
 * This class extends the food item class, it will ask all the common question but will also add a question on where they got the product, add it to the array then return the print.
 */
public class Sweetener extends FoodItem{



	//Instance variables
	private String sweetenerType;

	//Beginning of no args
	public Sweetener() {

	}//End of no args

	/**
	 * @param input Scanner 
	 */
	//Beginning of addItem
	public void addItem(Scanner input){
		
		super.addItem(input);
		
		System.out.print("Enter Sweetener Type: ");
		
		try {
			sweetenerType = input.next();
			
		} catch (InputMismatchException e) {
			System.err.flush();
			System.err.println("INVALID");
			System.err.flush();
			input.next();
		}//End of catch

	}//End of addItem

	//Beginning of toString
	public String toString() {
		super.toString();
		System.out.printf("%6s %s\n"," Sweetener Type: ", sweetenerType);
		return null;
	}//End of toString
}//End of class
