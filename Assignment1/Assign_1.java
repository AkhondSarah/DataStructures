

import java.util.InputMismatchException;
import java.util.Scanner;

public class Assign_1 {

	public static void main(String[] args) {
		
		Inventory test=new Inventory();
		
		int option=0;
		Scanner scan=new Scanner (System.in);
		do {
			try {
				
			
	
		System.out.println(	
				"1: Add item to Inventory\r\n" +
				"2: Display current inventory\r\n"+
				"3: Buy item(s)\r\n"+
				"4: Sell items(s)\r\n"+
				"5: To exit\r\n");
		
	
			System.out.print("> ");
			option = scan.nextInt();

		/**switch statement for the different option*/
		switch (option) {
		
		case 1:
	
			if (!test.addItem(scan))
				System.out.print("Item already exist");
			
			break;
			
		case 2:
			
			System.out.println(test);
			break;
		
		case 3:
			
			if(!test.updateQuantity(scan,true))
				System.out.print("Error...could not buy item\n");
			break;
			
		case 4:
			if(!test.updateQuantity(scan,false))
				System.out.print("Error...could not sell item\n");
			
			break;
			
		case 5:
			System.out.println("Exiting....");
			System.exit(0);
			break;
			
		
			
		default:
			System.out.println("Please select a valid selection between 1 - 5");
			
		}
		}catch (InputMismatchException ime) {
			
			  System.err.println("Invalid input"); 
			  System.err.flush(); 
			  scan.nextLine(); 
			  }catch (Exception e) {
					System.out.println("Please input number only");
					scan.next();
				}
		
	}while (option!=5);
		}//end of main 

}//end of class

	
	
	
	
	
	
