import java.util.Scanner;
/**
 * This class contains the main mehtod for the recursion and non-recursion binary serach
 * Student Name: Akhond Sarah mesbah
 * Student Number:041009466  
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * @author/Professor James Mwangi PhD.
 *
 */
public class lab3 {
	
	/**
	 * @param args-main method
	 */
	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		Binarysearch bs=new Binarysearch();
		int array[] = null;
		
		while(true)
		{
			System.out.println("Select your option int the menu below:\n"
					+ "1.Initialize and populate an array of 20 random integers\n"
					+ "2.Perform a recursive binary search\n"
					+ "3.Perfrom a non-recursive binary search\n"
					+ "4.Exit");
			int choice=input.nextInt();
			//numbers are randomly generated to form an array
			if(choice==1)
			{
				array=bs.generateRandomInts();
				System.out.println("Array of randomly generated integers:");
				bs.remainingElements(array, 0, array.length-1);

			}
			//Recursive binary search
			else if(choice==2)
			{
				System.out.print("Please enter an integer value to search: ");
				int a=input.nextInt();
				bs.recursiveBinarySearch(array, 0, array.length-1, a);
			}
			//non-recursive binary search
			else if(choice==3)
			{
				System.out.print("Please enter an integer value to search: ");
				int b=input.nextInt();
				bs.nonRecursiveBinarySearch(array, b);
			}
			//exit the program
			else if(choice==4)
				System.exit(0);
			//if the input isnt valid
			else
				System.out.println("Enter a valid choice");
			
		}
		
		
	}
	
}
