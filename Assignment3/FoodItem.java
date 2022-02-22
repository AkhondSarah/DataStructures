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

public class FoodItem implements Comparable<FoodItem> {

	private int itemCode;
	private String itemName;
	private float itemPrice;
	private int itemQuantityInStock;
	private float itemCost;

	//No-Args constructor
	public FoodItem() {}

	/**
	 * @return item code
	 */
	public int getItemCode() {
		return itemCode;
	}//End of getItemCode

	/**
	 * @param writer 
	 */
	public void outputItem(Formatter writer) {
		writer.format("%d\n%s\n%d\n%f\n%f\n", itemCode, itemName, itemQuantityInStock, itemCost, itemPrice);
	}//End outputItem


	/**
	 * @param code : The item code
	 */
	public FoodItem(int code) {
		itemCode = code;
	}//End of foodItem



	/**
	 * @param quant : Item Quantity 
	 * @return      : false
	 */
	public boolean updateItem(int quant) {

		if (itemQuantityInStock + quant < 0) {
			return false;
		}//End of if

		itemQuantityInStock += quant;
		return true;
	}//End of updateItem

	/**
	 * @param item 
	 * @return True or false
	 */
	public boolean isEqual(FoodItem item) {
		if (itemCode == item.itemCode)
			return true;
		else
			return false;
	}//End of isEqual

	/**
	 * @param input  : Scans
	 * @param fromFile : Reads File
	 * @return True or false
	 */
	public boolean addItem(Scanner input, boolean fromFile) {

		if (!fromFile)
			System.out.print("Enter Item Name: ");
		    this.itemName = input.nextLine();


		while (true){

			if (!fromFile)
				System.out.print("Enter Item Price: ");

			try{

				this.itemCost = input.nextFloat();
				input.nextLine();

			} catch (Exception e){
				input.nextLine();
				System.out.println("Invalid");
				continue;
			}
			//End of catch

			if (this.itemCost <= 0){
				System.out.println("Invalid");
				continue;
			}//End of if
			break;
		}//End of while

		while (true){

			if (!fromFile)
				System.out.print("Enter Sales Price Of Item: ");

			try {
				this.itemPrice = input.nextFloat();
				input.nextLine();
			} catch (Exception e){
				input.nextLine();
				System.out.println("Invalid");
				continue;
			}//End of catch

			if (this.itemPrice <= 0){
				System.out.println("Invalid");
				continue;
			}//End of if 
			break;
		}//End of while
		return true;
	}//End of addItem

	/**
	 * @param input  : Scans
	 * @param fromFile : Reads File
	 * @return True or false
	 */
	public boolean inputCode(Scanner input, boolean fromFile){
		
		while (true) {
			if (!fromFile)
				System.out.print("Enter Item Code: ");
			try {
				itemCode = input.nextInt();
				input.nextLine();
			} catch (Exception e) {
				input.nextLine();
				System.out.println("Invalid");
				continue;
			}//End catch
			break;
		}//End while
		return true;
	}//End inputCode

	@Override
	public int compareTo(FoodItem o){
		return itemCode - o.itemCode;
	}//CompareTo

	//Beginning of toString
	public String toString() {
		String s = "Item: " + itemCode + " " + itemName + " price: $" + String.format("%.2f", itemPrice) + " cost: $"
				+ String.format("%.2f", itemCost) + " ";
		return s;
	}//End of toString
}//End of class
