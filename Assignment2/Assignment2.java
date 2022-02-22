import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Akhond Sarah Mesbah
 * @version 2.0: Added linked lisst as an option
 * Student Number 040994144
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * Assignment 2
 * Due: Sunday March 21 2021 at midnight
 * This class will print out the main menu and then the user will get to type a number 1-5 (if its not 1-5 an exception handler will take care of it) 1 will add an item to the inventory,
 * 2 will display the inventory, 3 will allow you to purchase items, 4 will allow you to sell previously purchased items, 5 will display array list into a linked list and 6 will quit the program.
 */
public class Assignment2 {

	//Created the add object from inventory class
	static Inventory test = new Inventory();
	static FoodItem food = new FoodItem();

	static Scanner input = new Scanner(System.in);

	//Beginning of displayMainMenu method
	public static void displayMainMenu() {
		System.out.println("\nPlease Select One Of The Following: \n");
		System.out.println("1: Add Item To Inventory\n2: Display Current Inventory\n3: Buy Item(s)\n4: Sell Item(s)\n5: Convert ArrayList To LinkList And Print It\n6: To Exit");
		System.out.println("\n> ");

	}//End of displayMainMenu method



	public static void main(String[] args){
		try {
			
			//While loop
			while(true){

				displayMainMenu();
				int choice = input.nextInt();


				//If statement
				//Choice 1 will add items to inventory
				if(choice == 1){
					test.addItem(input);

					//Choice 2 will display inventory
				}else if(choice == 2){
					
					System.out.println("Inventory   ");
					
					System.out.print(test.toString());
					System.out.print(food.toString());


					//Choice 3 will buy items
				}else if(choice == 3){

					if(test.updateQuantity(input, true)) {

						System.out.print("Purchased Item Successfully\n");
					}

					//Choice 4 will sell items
				}else if(choice == 4){

					if(test.updateQuantity(input, false)) {
						System.out.print("Sold Item Successfully\n");
					}

					//Choice 5 will convert our array list into a linked list
				}else if(choice == 5) {

					test.arrToLink();

					//Choice 6 will quit
				}else if(choice == 6) {
					System.out.println("Exiting...");
					System.exit(0);

					//Else will print if its invalid	
				}else
					System.out.println("Incorrect Value Entered");

			}//End of if else
		} catch (InputMismatchException e) {
			System.err.print("Error");	
		} catch (Exception e) {
			System.err.print("Invalid Option");
		}//End of catches


	}//End of main method

}//End of class
