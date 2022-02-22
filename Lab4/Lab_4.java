
/**-InputMismatchException class*/
import java.util.InputMismatchException;
/**Scanner class*/
import java.util.Scanner;
/**
 * This class contains the dynamically allocated array and it's processing with secure random numbers
 * and it displays sorted array with its sorted algorithm
 * Student Name: Ahmed Fouad Ahmed
 * Student Number:  040952342
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * @author/Professor James Mwangi PhD. 
 * 
 */	


public class Lab_4 {
	
	public static void main(String[] args) {
	
			/**creating instance of Scanner class */
			 Scanner input=new Scanner(System.in);
			 /**creating object called bs of Binarysearch class */
		       Binarysearch bs=new Binarysearch();
		       //initializing default array
		       int array[] =null;
		  
		       
		
		       
		       /**initializing instance variable choice*/
		       int choice=0;
		       String option=null;
		      
		       /**do while statement for the different choice*/
		       do
		       {
		    	   //main menu
		           System.out.println("\nSelect your option int the menu below:\n"
		                        + "1.Initialize and populate an array of 20 random integers\n"
		                        + "2.Perform a recursive binary search\n"
		                        + "3.Perfrom a non-recursive binary search\n"
		                        + "4.Sort the array\n"
		                        + "5.Quit");
		           
		           try {//try statement
		        	   System.out.print("> ");  
		           choice=input.nextInt();
		           
		           switch (choice) {//switch statement
		           case 1:
		        	   try {
							array=bs.generateRandomInts();
							System.out.println("Array of randomly generated integers:");
							bs.remainingElements(array, 0, array.length-1);
						}catch (InputMismatchException ime) {
							System.err.println("Please enter number only");
							input.next();
						}	

						break;
		        	   
		           
		           case 2:
		        	   try {
							System.out.print("Please enter an integer value to search: ");
							int a=input.nextInt();
							bs.recursiveBinarySearch(array, 0, array.length-1, a);
							bs.time1(array, a);
						}catch (InputMismatchException ime) {
							System.err.println("Please enter number only");
							input.next();
						}	

						break;
		           case 3:
		        	   try {
							System.out.print("Please enter an integer value to search: ");
							int b=input.nextInt();
							bs.nonRecursiveBinarySearch(array, b);
							bs.time2(array, b);
						}catch (InputMismatchException ime) {
							System.err.println("Please enter number only");
							input.next();
						}	

						break;
		           case 4:
		        	   /**submenu label*/
		        	  hey:{
		        	  do {
		        		  //submenu
		        	   System.out.println("Select a sorting algorithm to sort the data array:\n"
		                        + "B. Bubble Sort\n"
		                        + "I. Insertion Sort\n"
		                        + "S. Selection Sort\n"
		                        + "M. Merge Sort\n"
		                        + "Q. Quick Sort\n"
		                        + "R. Return to Main Menu");
		        	  
		        	   
		        	
		        	 
		        	   System.out.print("> ");
		        	    option=input.next();
		        	   
		        	   
		        	   long start=System.nanoTime();  
		        	   
		        	   switch (option.toUpperCase()) {
		        	   case "B":
		        		   //creating bubble array
		        		int[] bubble=new int[array.length];
		        		
		        		 //copying bubble to arr
		        		   System.arraycopy(array, 0, bubble, 0, array.length);
		        		 //printing array before sorting
		        		   bs.remainingElements(bubble, 0, bubble.length-1);
		        		   //sorting array
		        		   bs.bubbleSort(bubble);
		        		   System.out.println("Bubble Sort: Simple Sorting Algorithm - O(n^2) Complexity");
		        		   //printing sorted array
		        		   bs.remainingElements(bubble, 0, bubble.length-1);
		        		   long time=System.nanoTime()-start;
		   		        
			        	   System.out.println("Time taken in nanonseconds: "+time);
			        	   System.out.println("Time taken in milliseconds: "+time/1000000);
		        	   break;
		        	   case "I": 
		        		   //creating insert array
		        		   int[] insert=new int[array.length];
		        		   //copying insert to arr
		        			  System.arraycopy(array, 0, insert, 0, array.length);
		        			  //printing array before sorting
		        		   bs.remainingElements(insert, 0, insert.length-1);
		        		   //sorting array
		        		   bs.insertionSort(insert);
		        		   System.out.println("Insertion Sort: Simple Sorting Algorithm - O(n^2) Complexity");
		        		   //printing sorted array
		        		   bs.remainingElements(insert, 0, insert.length-1);
		        		    time=System.nanoTime()-start;
		   		        
			        	   System.out.println("Time taken in nanonseconds: "+time);
			        	   System.out.println("Time taken in milliseconds: "+time/1000000);
		        	   break;
		        	   case "S": 
		        		   //creating select array
		        		   int[] select=new int[array.length];
		        		   //copying select to arr
		        		   System.arraycopy(array, 0, select, 0, array.length);
		        		   //printing array before sorting
		        		   bs.remainingElements(select, 0, select.length-1);
		        		   //sorting array
		        		   bs.selectionSort(select);
		        		   System.out.println("Selection Sort: Simple Sorting Algorithm - O(n^2) Complexity");
		        		  //printing sorted array
		        		   bs.remainingElements(select, 0, select.length-1);
		        		    time=System.nanoTime()-start;
		   		        
			        	   System.out.println("Time taken in nanonseconds: "+time);
			        	   System.out.println("Time taken in milliseconds: "+time/1000000);
		        	   break;
		        	   case "M":
		        		   //creating merge array
		        		   int[] merge=new int[array.length];
		        		   //copying merge to arr
		        		   System.arraycopy(array, 0, merge, 0, array.length);
		        		   //printing array before sorting
		        		   bs.remainingElements(merge, 0, merge.length-1);
		        		   //sorting array
		        		   bs.mergeSort(merge, 0,merge.length-1);
		        		   System.out.println("Merge Sort: Recursive Divide-and-Conquer Algorithm - O( n log(n)) Complexity");
		        		  //printing sorted array
		        		   bs.remainingElements(merge, 0, merge.length-1);
		        		    time=System.nanoTime()-start;
		   		        
			        	   System.out.println("Time taken in nanonseconds: "+time);
			        	   System.out.println("Time taken in milliseconds: "+time/1000000);
		        	   break;
		        	  
		        	   case "Q": 
		        		   //creating quick array
		        		   int[] quick=new int [array.length];
		        		   //copying quick to arr
		        		   System.arraycopy(array, 0, quick, 0, array.length);
		        		   //printing array before sorting
		        		   bs.remainingElements(quick, 0, quick.length-1);
		        		   //sorting array
		        		   bs.quickSort(quick, 0, quick.length-1);
		        		   System.out.println("Quick Sort: Recursive Divide-and-Conquer Algorithm - O( n log(n)) Complexity");
		        		   //printing sorted array
		        		   bs.remainingElements(quick, 0, quick.length-1);
		        		   time=System.nanoTime()-start;
		   		        
			        	   System.out.println("Time taken in nanonseconds: "+time);
			        	   System.out.println("Time taken in milliseconds: "+time/1000000);
		        	   break;
		        	   
		        	   case "R":
		        		   System.out.println("Returning to main menu.....");
		        		 //  System.exit(choice);
		        		   
		        		  break hey;
		        	   
		        	     
		        	   default:
		        		   System.out.println("Enter a valid choice"); 
		        		 
		        		   
		        	   
		        	   
		        	   }
		        	  }while(option!="R");
		           }
		        	  break ;
		        	
		        	   case 5:

			        	   System.out.println("Exiting.....");
			        	   break;
		        		   
		        	   
		        	   default:
		        		   System.out.println("Enter a valid choice between 1 to 5");  
		           }
		           }catch (InputMismatchException ime) {
		        	   System.err.println("Please enter number only");
		        	   System.err.flush();
		   			input.next();
		           }catch (NullPointerException npe) {
		        	   System.err.println("Please initialize and populate the array first");
		        	   System.err.flush();
		        	   
		           }
		        	   
		           
		           
		       }while (choice!=5);
		           
		           input.close();	              

	}//end of main method

}//END OF CLASS
