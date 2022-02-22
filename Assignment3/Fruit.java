import java.util.Formatter;
import java.util.Scanner;

/**
 * @author Akhond Sarah Mesbah
 * @version 3.0
 * Student Number 041009466
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * Assignment 3
 * Due: Wednesday April 07 2021 at midnight
 * Modifications: Constructor changed to adapt to other classes
 */

public class Fruit extends FoodItem {

	private String orchardName;

	//no-args constructor
	public Fruit() {}


	/** 
	 * @param writer 
	 */
	public void outputItem(Formatter writer) {
		writer.format("f\n");
		super.outputItem(writer);
		writer.format("%s\n", orchardName);
	}//End outputItem

	/**
	 * @param input  : Scans
	 * @param fromFile : reads file
	 * @return True or false
	 */
	public boolean addItem(Scanner input, boolean fromFile) {
		super.addItem(input, fromFile);
		if (!fromFile)

			System.out.print("Enter Name Of Orchard Supplier: ");
		orchardName = input.nextLine();
		return true;
	}//End additems

	//Beginning of toString
	public String toString(){
		return super.toString() + "orchard supplier: " + orchardName;
	}//End of toString
}//End of class