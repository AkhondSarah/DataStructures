import java.util.Formatter;
import java.util.Scanner;

/**
 * @author Akhond sarah Mesbah
 * @version 3.0
 * Student Number 041009466
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * Assignment 3
 * Due: Wednesday April 07 2021 at midnight
 * Modifications: Constructor changed to adapt to other classes
 */

public class Vegetable extends FoodItem {

	private String FarmName;

	//no-args constructor
	public Vegetable() {}


	/** 
	 * @param writer 
	 */
	public void outputItem(Formatter writer) {
		writer.format("f\n");
		super.outputItem(writer);
		writer.format("%s\n", FarmName);
	}//End outputItem

	/**
	 * @param input  : Scans
	 * @param fromFile : reads file
	 * @return True or false
	 */
	public boolean addItem(Scanner input, boolean fromFile) {
		
		super.addItem(input, fromFile);
		if (!fromFile)

			System.out.print("Enter Farm Name: ");
		FarmName = input.nextLine();
		return true;
	}//End additems

	//Beginning of toString
	public String toString(){
		return super.toString() + "Farm Name: " + FarmName;
	}//End of toString
}//End of class
