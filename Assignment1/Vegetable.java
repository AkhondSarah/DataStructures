

import java.util.Scanner;

public class Vegetable extends FoodItem {
	
	
	
	protected String farmName; 
	
	
	public Vegetable() {

		super();
		farmName = "";
		
		
		
	}
	
	public String toString() {
		return super.toString() + " farm name: " + farmName;
	}
	
	
	public boolean addItem( Scanner scan) {
		 boolean isvalid = false;
			if (super.addItem(scan)) {
				if (!isvalid)
					System.out.print("Enter the name of the farm supplier: ");
				farmName = scan.next();
				scan.nextLine();
			}
			return true;
		

}
}
