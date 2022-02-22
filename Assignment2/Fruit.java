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
public class Fruit extends FoodItem{


	//Instance variables
	private String orchardName;

	//No-Args constructor
	public Fruit() {

	}//End of no-Args

	/**
	 * @param input Scanner 
	 */
	//Beginning of addItem method
	public void addItem(Scanner input) {
		
		super.addItem(input);
		
		System.out.print("Enter Name Of Orchard Supplier: ");
		
		try {
			orchardName = input.next();
		} catch (InputMismatchException e) {
			System.err.flush();
			System.err.println("INVALID");
			System.err.flush();
			input.next();
		}//End of catch

	}//End of add item method

	//Beginning of toString
	public String toString() {
		super.toString();
		System.out.printf("%6s %s\n"," Orchard Supplier: ", orchardName);
		return "";

	}//End of to string

}//End of class

