import java.util.Scanner;

public class Sweetener extends FoodItem {
Inventory inv = new Inventory();
	
	
	protected String farmName; // Input [Name of supplier]
	
	
	public Sweetener() {

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
