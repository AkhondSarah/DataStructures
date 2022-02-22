import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Akhond Sarah Mesbah
 * @version 2.0 : Added exception handling, a no args constructor and an updating food option 
 * Student Number 041009466
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * Assignment 2
 * Due: Sunday March 21 2021 at midnight
 * The foodItem class will just ask the same basic questions about the order taking place. It is the parent class to many other classes in this project so it cant flop.
 * It is also organized with comments because I kept getting confused on what I was doing
 */

public class FoodItem {

	//Instance variables
	protected String itemName;
	protected int itemCode;
	protected int itemQuantityInStock;
	private float itemPrice;
	protected float itemCost;
	private int itemQuantityStock;


	//No args
	public FoodItem() {

	}//End of no args



	/**
	 *@param : Can change amount to positive or negative
	 *@return : If successful
	 */
	//Beginnign of updateItem method
	public boolean updateItem(int amount){

		//Local variable
		int quant = itemQuantityStock - amount;

		if (quant >= 0){

			itemQuantityStock = quant;

			System.out.printf("Item: %d Has Been Updated %d New Update Holds %d Of Item\n", itemCode, amount, itemQuantityStock);
			return true;

		}else{

			System.out.print("Invalid\n");
			return false;
		}//End of if else

	}//End of updateItem method

	/**
	 * @param : selection will make sure that the item code is equal to the inputed item code
	 * @return : returns true or false depending on the statement
	 */
	//Beginning of isEqual method
	public boolean isEqual(int num){

		if (num == itemCode){

			return true;
			
		}else{

			return false;
		}//End of if else
	}//End of isEqual method

	/**
	 * @param input Scanner 
	 */
	//Beginning of addItem
	public void addItem(Scanner input){

		System.out.print("Enter The Name For The Item:  ");
		input.next();
		itemName = input.nextLine();

		do{

			itemQuantityStock = -1;

			System.out.print("Enter The Quantity Of The Item: ");

			try{

				itemQuantityStock = input.nextInt();

			}catch (InputMismatchException e){
				System.err.flush();
				System.err.println("Invalid");
				System.err.flush();
				input.next();
			}//End of error checking

		}while (itemQuantityStock < 0);
		itemCost = -1;

		do{
			System.out.print("Enter The Cost Of The Item: ");

			try{

				itemCost = input.nextFloat();

			}catch (InputMismatchException e){
				System.err.flush();
				System.err.println("Invalid");
				System.err.flush();
				input.next();
			}//End of error checking

		}while (itemCost < 0);

		itemPrice = -1;

		do{
			System.out.print("Enter Item Price: ");

			try{
				itemPrice = input.nextFloat();

			}catch (InputMismatchException e){
				System.err.flush();
				System.err.println("Invalid");
				System.err.flush();
				input.next();
			}//End of exception handling

		}while (itemPrice < 0);

	}//End of method

	/**
	 * @param input Scanner
	 * @return returns true or false depending on the statement 
	 */
	//Beginning of inputCode
	public boolean inputCode(Scanner input){

		itemCode = -1;

		do{
			System.out.print("Enter The Code For The Item: ");

			try{

				itemCode = input.nextInt();

			}catch (InputMismatchException e){
				System.err.flush();
				System.err.println("Invalid");
				System.err.flush();
				input.next();
			}//End of exception handling 
		}while (itemCode < 0);
		
		return true;
	}//End of inputCode method

	//Beginning of toString
	public String toString() {
		System.out.printf("%6s %6s %6s %6s %6s %7s %4.2f %7s %4.2f ", "Item Num: ", itemCode, itemName,"Item Quantity: ", itemQuantityStock, " Price: $", itemPrice, " Item cost: $", itemCost);
		return "";
	}//End of toString
}//End of class
