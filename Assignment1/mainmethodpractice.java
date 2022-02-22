import java.util.InputMismatchException;
import java.util.Scanner;

public class mainmethodpractice {

	public static void main(String[] args) {
		int itemCode;
		String itemName;
		float itemPrice;
		int itemQuantityStock;
		float itemCost;
		boolean p = true;
		Scanner scanner=new Scanner (System.in);
		do {
		try {
			System.out.print("Enter the code for the item:");
			itemCode = scanner.nextInt();
		}catch (Exception e) {
		
			
			System.out.println("Invalid code");
			scanner.next();
			
		}
		}while(p==false);
		
		
		System.out.print("Enter the name for the item: \n") ;
		itemName = scanner.next();
	    System.out.print("Enter the quantity for the item: \n"); 
	    itemQuantityStock = scanner.nextInt();
	    if (itemQuantityStock<0) {
	    	System.out.print("Invalid code \n");
	    	System.out.print("Enter the quantity for the item: \n"); 
		    itemQuantityStock = scanner.nextInt();
	    }
	   System.out.print("Enter the cost of the item: \n") ;
	   System.out.print("Enter the sales price of the item:\n");
		
		
		
	}

}
