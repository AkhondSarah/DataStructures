import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Akhond Sarah Mesbah 
 * @version 2.0 : I changed my switch case to an if else statement so it would stop bugging plus there's much more exception handling
 * Student Number 041009466
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * Assignment 2
 * Due: Sunday March 21 2021 at midnight
 *
 */
public class Inventory {

	//Instance variables
	private int amount = 0;
	private FoodItem[] item;
	private int index = 0;
	private LinkedList <FoodItem> inventory;

	//Constructor
	public Inventory() {
		item = new FoodItem[20];
		inventory = new LinkedList<FoodItem>(); 
	}//End of constructor

	//Beginning of toString
	public String toString() {

		System.out.printf("%5s %10s %10s %10s\n", "Item: ", "Item Code: ", "Item Name: ", "Quantity: ");

		for (int i = 0; i < index; i++) {
			item[i].toString();
		}//End of for
		return "";
	}//End of toString


	/**
	 * @param input Scanner 
	 */
	//Beginning of addItem method
	public void addItem(Scanner input) {

		System.out.print("Do You Wish To Add Fruit (f), Vegetable(v), Sweetener(s), or a Preserve(p)? ");
		char choice=' ';

		try {

			choice = input.next().charAt(0);

		}catch (InputMismatchException e){
			System.err.flush();
			System.err.println("Invalid.");
			System.err.flush();
			choice = ' ';
			input.next();

		}catch (Exception e){
			System.err.flush();
			System.err.println("Invalid");
			System.err.flush();
			choice = ' ';
			input.next();
		}//End of exception handling 

		if (choice == ' '){
			System.out.print("\n");

		}else if (choice == 'f'){

			item[amount] = new Fruit();
			item[index].inputCode(input);

			if (alreadyExists(item[index].itemCode)==-1){
				item[index].addItem(input);
				amount++;

			}else{
				System.out.printf("Item Already Exists\n");
				index--;
			}//End of if else for Fruits

		}else if (choice == 'v'){


			item[amount] = new Vegetable();
			item[index].inputCode(input);

			if (alreadyExists(item[index].itemCode) ==-1){
				item[index].addItem(input);
				amount++;

			}else{
				System.out.printf("Item Already Exists\n");
				index--;
			}//End of if else for veggies

		}else if (choice == 's'){

			item[amount] = new Sweetener();
			item[index].inputCode(input);

			if (alreadyExists(item[index].itemCode) ==-1){
				item[index].addItem(input);
				amount++;

			}else{
				System.out.printf("Item Already Exists\n");
				index--;
			}//End of if else for the sweets

		}else if (choice == 'p'){

			item[amount] = new Preserve();
			item[index].inputCode(input);

			if (alreadyExists(item[index].itemCode) ==-1){
				item[index].addItem(input);
				amount++;
			}else{

				System.out.printf("Item Already Exists\n");
				index--;
			}//End of if else for the preserves

		}else {
			System.out.print("Invalid\n");
			index--;
		}//End of large if else
		index++;
	}//End of addItem method

	/**
	 * @param : item created a new name to pull from FoodItem class
	 * @return : returns true or false depending on the statement
	 */
	//Beginning of alreadyExists method
	public int alreadyExists(int num){

		//Local variable
		int count = -1;

		if (amount <= 0){
			return -1;

		}else {

			for (int i = 0; i < amount; i++){

				if (item[i].isEqual(num)){
					count=i;
				}//End of if
			}//End of for

			if (count >= 0){
				return count;

			}else{
				return -1;
			}//End of if else2
		}//End of if else1
	}//End if alreadyExists method


	/**
	 * @param input Scanner
	 * @param : buyORsell will print true or false in Assign1 3 is true (to buy) and 4 is false (to sell)
	 * @return : returns true or false depending on the statement
	 */
	//Beginning of update quantity method
	public boolean updateQuantity (Scanner input, boolean buyORsell) { 

		//Local variable
		int itemCode=-1;
		int itemQuantityInStock;

		do {
			System.out.print("Enter Valid Item Code: ");

			try{
				itemCode = input.nextInt();
			}catch (InputMismatchException e) {
				System.err.flush();
				System.err.println("Invalid");
				System.err.flush();
				input.next();
			}//End of error checking

		}while (itemCode < 0);
		itemCode = alreadyExists(itemCode);

		if(itemCode == -1) {
			System.out.print("Error...Could Not Buy/Sell The Item");
			return false;

		}else if (itemCode >= 0){

			System.out.printf("Found Item");

			if (buyORsell) {

				//--------------To buy ----------

				itemQuantityInStock = -1;

				do{
					System.out.printf("Enter Valid Quantity to buy: ");

					try{
						itemQuantityInStock = input.nextInt();

					}catch (InputMismatchException e) {
						System.err.flush();
						System.err.println("Input mismatch.");
						System.err.flush();
						input.next();
					}//End of exception handling

				}while (itemQuantityInStock < 0);

				if (itemQuantityInStock > 0){
					if(item[itemCode].updateItem(itemQuantityInStock)){  
						return true;

					}else {
						System.out.print("Error...Could Not Buy The Item");
						return false;
					}//End of if else2
				}//End of if1

			}else if (!buyORsell){

				//-----------------To sell ---------

				itemQuantityInStock = 1;

				do{
					System.out.printf("\nEnter Valid Quantity To Sell: ");

					try{
						itemQuantityInStock = input.nextInt();

					}catch (InputMismatchException e){
						System.err.flush();
						System.err.println("Invalid");
						System.err.flush();
						input.next();
					}//End of exception handling

				}while (itemQuantityInStock > 0);

				if (itemQuantityInStock < 0){

					if(item[itemCode].updateItem(itemQuantityInStock)){ 
						return true;

					}else{
						System.out.print("Error...Could Not Sell The Item");
						return false;
					}//End of if else2
				}//End of if else1
			}//End of if else buy n sell
		}//End of else if item code

		return false;

	}//End of method

	//---------------------------------------This is where I convert to link list-------------------------------------------

	//Beginning of arrToLink method
	public void arrToLink(){
		if (amount > 0){

			inventory.clear();

			for (int i = 0; i <  amount; i++){
				inventory.add(item[i]);
				System.out.println(inventory.get(i).toString());
			}//End of for

		}else{
			System.out.println("Array Is Empty ");
		}//End of arrToLink method

	}//End of method
}//End of class

