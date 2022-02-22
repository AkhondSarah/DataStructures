

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Inventory {
	protected  int numItems=0;
	protected ArrayList<FoodItem> inventory;
	int index;
	
	private FoodItem food= new FoodItem();

	   public Inventory() {
	       inventory=new ArrayList<FoodItem>(20);
		   
	       
	       food=null;
	       
	       
	   }
	   @Override
	   public String toString() {
	String print=" ";
			for (int i=0; i<inventory.size(); i++) {
				
				print+=inventory.get(i).toString()+"\n";
			}
			return "Inventory:\n"+print;
			
		}

	   public int alreadyExists(FoodItem item) {
	       for (int i = 0; i < inventory.size(); i++) {
	    	  
	    	   

	           if (inventory.get(index).itemCode == food.itemCode) {

	               index = i;
	               break;
	           }
	       }

	       return index;
	   }

	   public boolean addItem(Scanner scan) {

	       String choice=null;
	       do {
	    	   try {
	    		   
	    		   
	    		  
	    		 
	       System.out.print("Do you wish to add a fruit(f), vegetable(v), sweetener (s) or a preserve(p)?:  ");
	         choice = scan.next();		
				  switch (choice.toLowerCase()) { 
				  case "f": 
				food = new Fruit(); 
				  break; 
				  case "v": 
					  food = new Vegetable();
					  break; 
				  case "s":
					  food=new Sweetener();
					  break;
					  case "p": 
						  food = new Preserve(); 
						  break; 
						  default: // Should not get here. 
							  System.out.print("Invalid entry\n");
				  }
				  
			
				    food.inputCode(scan);
				       boolean flag=false;
				  
				  
				    for (FoodItem foodItem : inventory) {
				    	if (foodItem.itemCode==food.itemCode) {
				    		food=foodItem;
				    		flag=true;
				    	}
				    }
				    
				    if (flag==true) {
				    	System.out.print("Item already exist\n");
				    }else {
				    	inventory.add(food); 
				    	food.addItem(scan);
				    }	
				
				
				     
				
					  
					
					  
break;
					 
	    	   }catch (InputMismatchException ime ) {
					System.err.flush();
					System.err.println("*****Input Mismatch Exception while reading number of employees*****\n");
	    	   }catch (NullPointerException npe) {
	    		   
	    	   }catch (IndexOutOfBoundsException iob) {
	    		   
	    	   }
	    	 
	       
	       }while(choice!="f"&&choice!="v"&&choice!="p"&&choice!="s");   
		return true;

	   }
	  
	public boolean updateQuantity(Scanner scan, boolean buyOrSell) {		
		try {
		
		food.inputCode(scan);
	     
	       int flag = 0;
	      
	       int index=alreadyExists(food);
	      binarySearch(food.itemCode,  index, flag);
	       for (FoodItem foodItem : inventory) {

	           if (foodItem.itemCode == food.itemCode) {
	        	   
	              food = foodItem;
	               flag = 1;
	           }
	           
	           if (foodItem.itemCode!=food.itemCode) {
	           food=foodItem;
	        	  flag=0;
	           }
	       }
	       if (flag==0) {
	    	   
	    	   if (inventory.isEmpty()) 
	    	   System.out.println("Code not found in inventory....");
	      }
	       if (index != -1) {
	    	   String buySell = buyOrSell ? "buy" : "sell";
	           System.out.print("Enter valid quantity to"+buySell+":");
	           int quantity = scan.nextInt();
	           if (quantity > 0) {
	    
						return inventory.get(index).updateItem(buyOrSell ? quantity : quantity * -1);
					} else if (quantity<0||quantity==0) {
						System.out.println("Invalid quantity...");
						System.out.println("Error...could not buy item");
					}
	         
	           return true;
	       } else {
	    	  
	           
	        }}catch (NullPointerException npe) {
	    	   
	       }
	        return false;
	     
	}
	private int binarySearch(int itemCode, int start, int end) {
		int middle = (start + end) / 2;
		if (start > end)
			return -1;
		if (inventory.isEmpty())
			return -1;
		if (inventory.get(middle).itemCode == itemCode)
			return middle;
		if (inventory.get(middle).itemCode > itemCode)
			return binarySearch(itemCode, start, middle - 1);
		if (inventory.get(middle).itemCode < itemCode)
			return binarySearch(itemCode, middle + 1, end);
		return -1;
	}
	

	}


