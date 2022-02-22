import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * /**
 * CET - CS Academic Level 3
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Akhond Sarah Mesbah
 * Student Number:041009466  
 * Course: CST8130 - Data Structures
 * @author/Professor James Mwangi PhD. 
 * @author Linda Crane
 * @author Melissa Sienkiewicz
 */
 
public class Lab1 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Numbers a= new Numbers();
int sizeofarray;
int option =0;

do {
	Scanner input=new Scanner (System.in);
	displayMainMenu();
	
	try {
		System.out.print("> ");
		option = input.nextInt();
	}catch (Exception e) {
		System.out.println("You can only input numbers!!");
		input.next();
	}
	
	switch (option) {
	
	case 1:
		a=new Numbers();
		break;
		
	case 2:
		try {
		System.out.printf("Enter new size of array: ");
		sizeofarray=input.nextInt();
		a= new Numbers (sizeofarray);
		}catch (InputMismatchException ime) {
			System.out.println("Only numbers can be input");
		}
		break;
	
	case 3:
		
a.addValue(input);
		break;
		
	case 4:
		System.out.println(a.toString());
		
		break;
		
	case 5:
		System.out.println("Average is: "+a.calcAverage());
		break;
		
	case 6:
		System.out.println("Exiting....");
		break;
		
	default:
		System.out.println("Please select a valid selection");
		
	}
	
}while (option!=6);
	}
	/**
	 * method which displays menu
	 */
	public static void displayMainMenu() {
		System.out.println("Please select one of the following:\r\n" +
				"1: Initialize a default array\r\n" +
				"2: To specify the max size of the array\r\n"+
				"3: Add value to the array\r\n"+
				"4: Display values in the array\r\n"+
				"5: Display the average of the values\r\n"+
				"6: To exit");
		
	}

}

