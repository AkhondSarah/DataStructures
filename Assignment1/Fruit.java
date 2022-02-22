import java.util.Scanner;

public class Fruit extends FoodItem{
	/**
	 * Name of the orchard the fruit is from
	 */
	private String orchardName;

	/**
	 * Default Constructor
	 */
	public Fruit() {
		super();
		orchardName = "";
	}
	
	public Fruit(int itemCode, String itemName, float itemPrice, int itemQuantityinStock, float itemCost, String orchardName) {
		super( itemCode,  itemName,  itemPrice,  itemQuantityinStock, itemCost);
		this.orchardName=orchardName;
	}

	@Override
	public boolean addItem(Scanner scan) {
		boolean isValid=false;
		if (super.addItem(scan)) {
			if (!isValid)
				System.out.print("Enter the name of the orchard supplier: ");
			orchardName = scan.next();
			scan.nextLine();
			
		}
		return true;
	}

	

	@Override
	public String toString() {
		return super.toString() + " orchard supplier: " + this.orchardName;
	}
}
