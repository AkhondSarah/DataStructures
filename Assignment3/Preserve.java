import java.util.Formatter;
import java.util.Scanner;

/**
 * @author Akhond saarh Mesbah
 * @version 3.0
 * Student Number 041009466
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * Assignment 3
 * Due: Wednesday April 07 2021 at midnight
 * Modifications: Constructor changed to adapt to other classes
 */

public class Preserve extends FoodItem{
	
	private int jarSize;
	
	//no-args constructor
	public Preserve(){}
	



	/**
	 * @param writer 
	 */
	public void outputItem(Formatter writer){
		writer.format("p\n");
		super.outputItem(writer);
		writer.format("%d\n", jarSize);
	}//End of output

	/**
	 * @param input
	 * @param fromFile : Reads File
	 * @return True or false
	 */
	public boolean addItem(Scanner input, boolean fromFile){

		super.addItem(input, fromFile);

		while (true){

			if(!fromFile) System.out.print("Enter Jar Size In Ml: ");
				this.jarSize = input.nextInt();
				input.nextLine();

		

			if (this.jarSize < 1){
				System.out.println("Invalid");
				continue;
				
			}//End if 
			break;
		}//End while
		return true;
	}//End addItem

	//Beginning of ToString
	public String toString(){
		return super.toString() + "Jar Size: " + jarSize + "mL";
	}//End of toString

}//End of class