import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Akhond Sarah mesbah
 * Student Number:041009466  
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * @author/Professor James Mwangi PhD. 
 * 
 * 
 */

public class lab2 {
	/**
	 * @param args-main method
	 */
	public static void main(String[] args) {
		//Enabling the scanner to read  input
		Scanner input=new Scanner (System.in);
		Numbers array= new Numbers();
		int option =0;
		//Start of the do loop
		do {	
			System.out.println(	
					"1: Create array with new size\r\n" +
							"2: Generate random numbers and store it in the array\r\n"+
							"3: Search a number and display its number\r\n"+
							"4: Display array\r\n"+
					"5: Quit\r\n");
			try {
				//Stores the user input into an integer variable called 'option'
				System.out.println("Enter your option: ");
				option = input.nextInt();

			}catch (Exception e) {
				System.err.flush();
				System.err.println("Please input a valid number only");
				System.err.flush();
				input.next();
			}

			switch (option) {
			//this case creates the the array with a new size
			case 1:

				try {
					System.out.println("Enter required size: ");
					int	a=input.nextInt();
					array= new Numbers (a);
				}catch (InputMismatchException ime) {
					System.err.println("Please enter number only");
					input.next();
				}	

				break;
				//this case generates random numbers and stores it i an array	
			case 2:

				if (array.isArrayCreated()==-1) {
					System.err.println("Array is not created... please create the array first");	
					System.err.flush();
				}else {
					array.generateNumbers();	

				}	
				break;

			case 3:
				//this case searchs for a numbers and displays the numbers	
				if (array.isArrayCreated()==-1) {
					System.err.println("Array is not created... please create array first");
					System.err.flush();
				}else if (array.isEmpty()==-1) {
					System.err.println("Array is empty");
					System.err.flush();
				}else {
					try {
						System.out.println("Enter the number");
						int num=input.nextInt();
						System.out.printf("Number %d occurred %d times in the array\n", num, array.findCount(num));
					}catch (InputMismatchException ime) {
						System.err.println("Please enter number only");
						System.err.flush();
						input.next();
					}

				}

				break;
				//This case displays the array
			case 4:

				if (array.isArrayCreated()==-1) { 
					System.err.println("Array is not created.... please create array first");
					System.err.flush();
				}

				else if (array.isEmpty()==-1) {
					System.err.println("Array is empty");
					System.err.flush();}
				else {
					System.out.println(array.toString());
				}
				break;

			case 5:
				System.out.println("Bye.... have a nice day!");
				break;

			default:
				System.out.println("Please select a valid choice");


			}
		}while (option!=5);
		//scanner closed
		input.close();
	}

}



