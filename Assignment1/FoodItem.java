
import java.util.InputMismatchException;
import java.util.Scanner;

public class FoodItem {
	   /** The item code. */
	   protected int itemCode;

	   /** The item name. */
	   protected String itemName;

	   /** The item price. */
	   protected float itemPrice;

	   /** The item quantity. */
	   protected int itemQuantityinStock;

	   /** The item cost. */
	   protected float itemCost;

	   /**
	   * Instantiates a new food item.
	   */
	   public FoodItem() {

	       this.itemCode = 0;
	       this.itemName = "";
	       this.itemPrice = 0.00f;
	       this.itemQuantityinStock = 0;
	       this.itemCost = 0.00f;
	   }

	   /**
	   * Instantiates a new food item.
	   *
	   * @param itemCode the item code
	   * @param itemName the item name
	   * @param itemPrice the item price
	   * @param itemQuantity the item quantity
	   * @param itemCost the item cost
	   */
	   public FoodItem(int itemCode, String itemName, float itemPrice, int itemQuantityinStock, float itemCost) {
	       super();
	       this.itemCode = itemCode;
	       this.itemName = itemName;
	       this.itemPrice = itemPrice;
	       this.itemQuantityinStock = itemQuantityinStock;
	       this.itemCost = itemCost;
	   }

	   /**
	   * Checks if is equal.
	   *
	   * @param item the item
	   * @return true, if is equal
	   */
	   public boolean isEqual(FoodItem item) {

	       if (this.itemCode == item.itemCode) {

	           return true;
	       } else {

	           return false;
	       }
	   }
	   
	   public boolean updateItem(int amount) {
			
			
			if ((amount < 0 || amount > 0 || amount == 0) && itemQuantityinStock < (amount*-1)) {
				return false;
			}
			else {
			itemQuantityinStock = itemQuantityinStock + amount;
			return true;
			}
			
		}

	   /**
	   * Input code.
	   *
	   * @param scanner the scanner
	   * @return true, if successful
	   */
	   public boolean inputCode(Scanner scan) {
		   do {
    		   try {
           System.out.print("Enter the code for the item: ");
            itemCode = scan.nextInt();
            if (itemCode==0)
            	System.out.print("Invalid entry\n"); 
    		   
    	   } catch (InputMismatchException e) {
	    	   System.out.print("Invalid entry\n");
	    	   scan.nextLine();
    	   } }while(itemCode==0);
		   return true;
			
			

	   }
	   /**
	    * 
	    * @param scan-scans the input
	    * @return - returns true, if successfull
	    */

	   public boolean addItem(Scanner scan) {
		   scan.nextLine();
	           System.out.print("Enter the name of the item: ");
	            itemName = scan.nextLine();
	            do {
		    		   try {
	           System.out.print("Enter the quantity of the item: ");
	            itemQuantityinStock = scan.nextInt();
		    		   } catch (InputMismatchException e) {
				    	   System.out.print("Invalid entry\n");
				    	   scan.nextLine();
			    	   } 
		    		   if (itemQuantityinStock<0) {
		    			   System.out.print("Invalid entry\n");
		    		   }
		    		   } while(itemQuantityinStock<=0);
	           scan.nextLine();
	           do {
	    		   try {
	           System.out.print("Enter the cost of the item: ");
	            itemCost = scan.nextFloat();
	    		   } catch (InputMismatchException e) {
			    	   System.out.print("Invalid entry\n");
			    	   scan.nextLine();
		    	   } if (itemCost<0) {
	    			   System.out.print("Invalid entry\n");
	    		   }
	    		   } while(itemCost<=0);
	           scan.nextLine();
	           do {
	    		   try {
	           System.out.print("Enter the sales price of the item: ");
	            itemPrice = scan.nextFloat();
	       } catch (InputMismatchException e) {
	    	   System.out.print("Invalid entry\n");
	    	   scan.nextLine();
    	   } if (itemPrice<0) {
			   System.out.print("Invalid entry\n");
		   }
	    		   } while(itemPrice<=0);
	           return true;
	   
	   }

	   @Override
	   public String toString() {
		   
		 
	       return "Item:" + this.itemCode + "  " + this.itemName + " " + this.itemQuantityinStock  +" price: $"+ this.itemPrice + " cost: $"+ this.itemCost ;
		   
		 
	   }
	  
	  

	
}
