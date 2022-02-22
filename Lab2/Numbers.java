import java.util.Random;
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
public class Numbers {

	/**
	 * Stores integer values.
	 */
	private Integer [] numbers;
	/**
	 * to hold the size of the array
	 */
	private int numberofItems;
	/**
	 * No-arg Constructor
	 */
	public Numbers() {
		numbers= null;
		numberofItems=0;
	}
	/**
	 * Parameterized Constructor which initializes the numbers array
	 * @param size - sets the size of th enumbers array
	 */

	public Numbers(int size) {
		this.numberofItems=size;
		numbers= new Integer [numberofItems];
	}


	/**
	 * method which uses the Random class to fill the array with random numbers between 1 and 50
	 */
	public void generateNumbers() {
		Random a=new Random();

		for (int i=0; i<numberofItems; i++) {
			numbers[i]=a.nextInt(50)+1;
		}

	}
	/**
	 * method which returns an int which is the number of occurrences of a numberin the array
	 * @param num-number which is entered to find from the array
	 * @return
	 */
	public int findCount(int num) {
		int count=0;

		for (int i=0;i<numberofItems; i++) {
			if (numbers[i]==num) {
				count++;
			}
		}

		return count;
	}
	/**
	 * method which returns -1 if array is not created with a given size. Returns 0 otherwise.
	 * @return
	 */
	public int isArrayCreated() {

		if (numbers==null) {
			return -1;
		}
		return 0;
	}

	/**
	 * method  that returns -1 if the array is not created with an integer size greater than 0. Returns 0 otherwise.
	 * @return
	 */
	public int isEmpty() {

		if (numberofItems<=0) {
			return -1;
		}
		return 0;
	}
	/**
	 * method which returns a String of the values in the array
	 */
	@Override
	public String toString() {
		String str="";


		for (int i=0; i<numberofItems; i++) {

			str+=numbers[i]+" ";

		}	
		return str;
	}	

}

