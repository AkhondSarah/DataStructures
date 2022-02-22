

import java.util.Scanner;

public class Preserve extends FoodItem{
	/**
	 * 
	 */
	private int jarSize;

	/**
	 * Default Constructor
	 */
	public Preserve() {
		super();
		jarSize = 0;
	}

	@Override
	public boolean addItem(Scanner scan) {
		boolean valid = false;
		if (super.addItem(scan)) {
			
			while (!valid) {
				System.out.print("Enter the size of the jar in millilitres: ");
				if (scan.hasNextInt()) {
					jarSize = scan.nextInt();
					if (jarSize < 0) {
						valid = false;
						System.out.println("Invalid input");
						jarSize = 0;
					} else
						valid = true;
				} else {
					System.out.println("Invalid input");
					scan.next();
					valid = false;
				}
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + " size: " + jarSize + "mL";
	}
}
