import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
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
 * Modifications: Code works more clearly changed entire version since I found an easier way to do a lot of the methods 
 */

public class Inventory {

	private ArrayList<InventoryItem> foodItem = new ArrayList<>();

	//No args constructor
	public Inventory() {}
	
	//Variable
	int Itemcode;


	/**
	 * @param input  : Scans 
	 * @param fromFile : Reads file
	 * @return True or false
	 */
	public boolean addItem(Scanner input) {

		InventoryItem item = new InventoryItem();
		item.addItem(input);

		if (alreadyExists(item) > -1) {
			System.out.println("Item code already exists");
			return false;
		}//End if 

		foodItem.add(item);

		Collections.sort(foodItem);
		return true;
	}//End addItem



	/**
	 * @param item 
	 * @return -1 or index
	 */
	public int alreadyExists(InventoryItem item) {

		for (int i = 0; i < foodItem.size(); i++) {
			if (foodItem.get(i).getItemCode() == item.getItemCode())
				return i;
		}//End for loop
		return -1;
	}//End Already Exists1

	public int alreadyExists(int itemCode) {

		for (int i = 0; i < foodItem.size(); i++) {
			if (foodItem.get(i).getItemCode() == itemCode)
				return i;
		}//End for loop
		return -1;
	}//End alreadyExists2

	/**
	 * @param input : Scans
	 */
	public void searchForItem(Scanner input) {

		System.out.print("Enter Item Code: ");
		Itemcode = input.nextInt();
		input.nextLine();

		for (int i = 0; i < foodItem.size(); i++){

			if (foodItem.get(i).getItemCode() == Itemcode) {

				System.out.println(foodItem.get(i));
				return;
			}//End if
		}//End for

		System.out.println("Code Not Found");
	}//End method



	/**
	 * @param input   : Scans
	 * @param buyOrSell : Buy or Sells
	 * @return True or false
	 */
	//Beginning of updateQuantity method
		public boolean updateQuantity(Scanner input, boolean buyORsell) {

			//Local variable
			boolean buy = true;
			boolean sell = false;
			int itemCode;
			int itemQuantityInStock;
			int amount;


			if (true) {

				System.out.print("Enter Valid Item Code: ");
				itemCode = input.nextInt();


				System.out.print("Enter Valid Quantity To Buy: ");
				itemQuantityInStock = input.nextInt();

				if (itemQuantityInStock > 0) {
					System.out.println("How Many Would You Like To Buy? ");
					amount = input.nextInt();
					
					if (amount > itemQuantityInStock) {
						System.out.println("Error...Could Not Buy/Sell The Item");
					}else if (amount < itemQuantityInStock) {
						System.out.println("Items Purchased");
					}
				}//End of if
			}//End of True if



			else if (false){

				System.out.print("Enter Valid Item Code: ");
				itemCode = input.nextInt();


				System.out.print("Enter Valid Quantity To Sell: ");
				itemQuantityInStock = input.nextInt();

				if (itemQuantityInStock > 0) {
					System.out.println("How Many Would You Like To Sell? ");
					amount = input.nextInt();
					
					if (amount > itemQuantityInStock) {
						System.out.println("Error...Could Not Buy/Sell The Item");
					}else if (amount < itemQuantityInStock) {
						System.out.println("Items Sold");
					}
					
				}else 
					System.out.println("Could Not Buy Or Sell The Item");
				

			}//End of false if 
		
			
			return false;
		}//End of updateQuantity method
		
	//Beginning of DisplayExpDate
	public void DisplayExpDate(Scanner input, LocalDate today) {

		int itemCode = 0;

		while (true) {
			System.out.print("Enter the code for the item: ");

			try {
				itemCode = input.nextInt();
				input.nextLine();
			}catch (Exception e) {
				input.nextLine();
				System.out.println("Invalid");
				continue;
			}//End catch
			break;
		}//End while

		int i = alreadyExists(itemCode);

		if (i == -1) {
			System.out.println("Not Found");
			return;
		}
		foodItem.get(i).printExpirySummary(today);
		System.out.println();
	}//End of method

	//Beginning of removeEpiry
	public void removeExpiry(LocalDate today) {

		for (int i = 0; i < foodItem.size(); i++) {
			foodItem.get(i).removeExpiredItems(today);
		}//End for 
	}//End removeExpiry

	//Beginning of toString
	public String toString() {

		String inv = "Inventory: \n";

		for (int i = 0; i < foodItem.size(); i++) {
			inv = inv + foodItem.get(i);
		}//End for
		return inv;
	}//End toString
}//End class
