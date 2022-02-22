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
 * 
 */

public class Sweetener extends FoodItem {

	private String sweetenerType;

	//no-args constructor
	public Sweetener() {}


	/** 
	 * @param writer 
	 */
	public void outputItem(Formatter writer) {
		writer.format("f\n");
		super.outputItem(writer);
		writer.format("%s\n", sweetenerType);
	}//End outputItem

	/**
	 * @param input  : Scans
	 * @param fromFile : reads file
	 * @return True or false
	 */
	public boolean addItem(Scanner input, boolean fromFile) {
		super.addItem(input, fromFile);
		if (!fromFile)

			System.out.print("Enter Sweetner Type: ");
		sweetenerType = input.nextLine();
		return true;
	}//End additems

	//Beginning of toString
	public String toString(){
		return super.toString() + "Sweetner Type: " + sweetenerType;
	}//End of toString
}//End of class