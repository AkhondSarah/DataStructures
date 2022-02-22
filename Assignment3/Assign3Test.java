import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Akhond Sarah Mesbah
 * @version 3.0
 * Student Number 041009466
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * Assignment 3
 * Due: Wednesday April 07 2021 at midnight
 * Modifications: Added 3 more options concerning the current date and the date some items expire 
 */
public class Assign3Test {

	//Created the add object from inventory class
	static Inventory add = new Inventory();
	static FoodItem print = new FoodItem();
	static Scanner input = new Scanner(System.in);

	//Beginning of displayMainMenu method
	public static void displayMainMenu() {
		System.out.println("\nPlease Select One Of The Following: \n");
		System.out.println("1: Add Item To Inventory\n2: Display Current Inventory\n3: Buy Item(s)\n4: Sell Item(s)\n5: Search For Items\n6: Remove Expired Items\n7: Print Expiry \n8: Change Todays Date\n9: Exit\n");
		System.out.println("\n> ");

	}//End of displayMainMenu method



	public static void main(String[] args){

		LocalDate today = LocalDate.now();
		Scanner input = new Scanner(System.in);
		Inventory merch = new Inventory();

		try {

			//While loop
			while(true){

				displayMainMenu();
				int choice = input.nextInt();


				//If statement
				//Choice 1 will add items to inventory
				if(choice == 1){
					add.addItem(input);

					//Choice 2 will display inventory
				}else if(choice == 2){
					System.out.println("**************************************************************************");
					System.out.println("                                Inventory                                 ");
					System.out.println("**************************************************************************"+"\n");
					System.out.print(add.toString());
					System.out.print(print.toString());


					//Choice 3 will buy items
				}else if(choice == 3){

					if(add.updateQuantity(input, true)) {

						System.out.print("Purchased Item Successfully\n");
					}//End if

					//Choice 4 will sell items
				}else if(choice == 4){

					if(add.updateQuantity(input, false)) {
						System.out.print("Sold Item Successfully\n");
					}//End if

					//Choice 5 Will Search For items	
				}else if(choice == 5) {

					merch.searchForItem(input);

					//Choice 6 will remove all expired items	
				}else if(choice == 6) {

					merch.removeExpiry(today);

					//Choice 7 will print The Expiring date	
				}else if(choice == 7){

					merch.DisplayExpDate(input, today);

					//Choice 8 will change todays date
				}else if(choice == 8){

					today = changeDate(input);

					//Choice 9 will quit
				}else if(choice == 9) {
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

	//Beginning of LocalDate method
		private static LocalDate changeDate(Scanner input) {

			LocalDate date = null;

			while (true){

				System.out.print("Enter The Expiring Date Of Item(YYYY/MM/DD): ");

				try {
					date = LocalDate.parse(input.nextLine());
					break;

				}catch (Exception e) {
					System.out.println("Invalid - Wrong Format");
					continue;
				}//End of catch
			}//End of while

			return date;
		}//End of method

}//End of class
