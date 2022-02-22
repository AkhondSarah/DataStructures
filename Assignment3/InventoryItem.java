import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Akhond Sarah Mesbah
 * @version 3.0
 * Student Number 041009466
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * Assignment 3
 * Due: Wednesday April 07 2021 at midnight
 * Modifications: New Class!!! This is now where we get item information plus we get new methods to play around with the items expire date. 
 */

public class InventoryItem implements Comparable<InventoryItem> {

	private int itemQuantityInStock;
	private FoodItem item;
	private ArrayList<LocalDate> expiries;


	//InventoryItem
	public InventoryItem() {
		
		itemQuantityInStock = 0;
		this.item = null;
		expiries = new ArrayList<LocalDate>();
		
	}//End inventoryItem

	//Beginning of addItem method
	public boolean addItem(Scanner input) {

		String choice = "";

		while (true) {
			System.out.print("Do You Wish To Add Fruit(f) Vegetable(v) Preserve(p) Or Sweetener(s): ");
			choice = input.nextLine();
			choice = choice.replace(" ", "");

			if (choice.equals("f") || choice.equals("v") || choice.equals("p") || choice.equals("s"))
				break;
			else
				System.out.println("Invalid");
		}//End while

		item = null;

		if (choice.equals("f"))
			item = new Fruit();

		else if (choice.equals("v"))
			item = new Vegetable();

		else if (choice.equals("p"))
			item = new Preserve();

		else if (choice.equals("s"))
			item = new Sweetener();


		item.inputCode(input, false);
		item.addItem(input, false);

		while (true){
			System.out.print("Enter Item Quantity: ");

			try{
				itemQuantityInStock = input.nextInt();
				input.nextLine();
			}catch (Exception e) {
				input.nextLine();
				System.out.println("Invalid");
				continue;
			}//End catch

			if (itemQuantityInStock < 1) {
				System.out.println("Invalid");
				continue;
			}//End if
			break;
		}//End while

		LocalDate date = null;

		while (true){

			try{
				System.out.print("Enter the expiry date of the item (yyyy-mm-dd or none): ");
				date = LocalDate.parse(input.nextLine());
			}catch (Exception e) {
				System.out.println("Invalid - Wrong Format");
				continue;
			}//End catch
			break;
		}//End while

		for (int i = 0; i < itemQuantityInStock; i++){
			expiries.add(date);
		}//End for

		return true;
	}//End addItem

	public FoodItem getFoodItem(){
		return item;
	}//End FoodItem

	public int getItemCode(){
		return item.getItemCode();
	}//End getItemCode

	public boolean inputCode(Scanner input){
		return item.inputCode(input, false);
	}//End input code

	

	public void printExpirySummary(LocalDate today){

		System.out.print(item);
		System.out.println("Quantity: " + itemQuantityInStock);
		System.out.println("Expiring Details:");

		ArrayList<LocalDate> dates = new ArrayList<>();
		ArrayList<Integer> nums = new ArrayList<>();

		for (int i = 0; i <= expiries.size() - 1; i++){

			if (dates.size() == 0){
				dates.add(expiries.get(i));
				nums.add(1);

			}else if (dates.get(dates.size() - 1).equals(expiries.get(i))){
				nums.set(nums.size() - 1, nums.get(nums.size() - 1) + 1);

			}else if ( !dates.get(dates.size() - 1).equals(expiries.get(i))){
				dates.add(expiries.get(i));
				nums.add(1);

			}//End else if
		}//End For

		for (int i = 0; i < dates.size(); i++){
			System.out.println(dates.get(i) + ": " + nums.get(i));
		}//End for
	}//End printExpirySummary method

	//Beginning of removeExpiredItems
	public void removeExpiredItems(LocalDate today){

		for (int i = expiries.size() - 1; i >= 0; i--){

			if (expiries.get(i).isBefore(today)){
				expiries.remove(i);
				itemQuantityInStock--;
			}//End if
		}//End for
	}//End removeExpiredItems

	//Beginning of updateQuantity
	public boolean updateQuantity(Scanner input, int quant){
		if (quant > 0) {
			LocalDate todaysDate = null;

			while (true){
				System.out.print("Enter The Expiring Date Of Item(YYYY/MM/DD):");

				try{
					todaysDate = LocalDate.parse(input.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("Invalid - Wrong Format");
					System.out.println(e.getMessage());
					continue;
				}//End catch
			}//End while

			itemQuantityInStock += quant;
			for (int i = 0; i < quant; i++)
				expiries.add(todaysDate);
			return true;

		}else{

			if (itemQuantityInStock + quant < 0)
				return false;

			itemQuantityInStock += quant;

			for (int i = 0; i < -quant; i++)
				expiries.remove(0);

			return true;
		}//End if else
	}//End of update Quantity 

	
	@Override
	public int compareTo(InventoryItem another){
		
		return item.compareTo(another.item);
	}//End of comapreTo
	
	//Beginning of toString
	public String toString(){
		return item.toString() + " Quantity: " + itemQuantityInStock;
	}//End of toString

	
}//End of class
