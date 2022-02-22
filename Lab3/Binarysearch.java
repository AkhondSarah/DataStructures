import java.util.Arrays;
import java.util.Random;

/**
 * This class contains recursion and non-recursion binary serach
 * Student Name: Akhond Sarah mesbah
 * Student Number:041009466  
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * @author/Professor James Mwangi PhD.
 *
 */
public class Binarysearch {
/**
 * This method does a nonRecursive Binary Search for the interger t and that receives an array of randomly generated integers,
 * @param array-array that was allocated
 * @param t-the integer that was supposed to be found
 * @return a -1 is retuned
 */
	
	public int nonRecursiveBinarySearch(int array[],int t)
	{
		int l=0,h=array.length-1;
		while(l<=h)
		{
			remainingElements(array,l,h);
			int a=(l+h)/2;
			if(array[a]==t)
			{
				System.out.println("Number "+t +" is found at index "+a+" :Non recursive binary search");
				return a;
			}
			else if(array[a]<t)
				l=a+1;
			else
				h=a-1;
		}
		System.out.println("Number "+t+" was not found   :Non recursive binary search");
		return -1;
	}
/**
 * A method that receives an array of randomly generated integers and does recursive binary search
 * @param array-array allocated
 * @param f-first index of array
 * @param l-last index of array
 * @param t-the number to serach
 * @return a -1 is retuned
 */
	// recursive binarySearch
	public int recursiveBinarySearch(int array[],int f,int l,int t)
	{
		if(f<=l)
		{
			remainingElements(array,f,l);
			int mid=(f+l)/2;
			if(array[mid]==t)
			{
				System.out.println("Number "+t +" is found at index "+mid+"  : recursive binary search");
				return mid;
			}
			else if(array[mid]<t)
				return recursiveBinarySearch(array,mid+1,l,t);
			else
				return recursiveBinarySearch(array,f,mid-1,t);
		}
		// if not found
		System.out.println("Number "+t +" is not found : recursive binary search");
		return -1;

	}
	/**
	 * This method displays elements remaining each time a half of the array is dropped.
	 *  @param array-array allocated
     * 
     * @param l-last index of array
     * @param r- index of an array
	 */

	// display method will the array content between two index
	public void remainingElements(int array[],int l,int r)
	{
		for(int i=l;i<=r;i++)
			System.out.print(array[i]+" ");
		System.out.println();
	}
/**
 * allocates an array with 20 reandomly generated integeres
 * @return array allocated is returned
 */
	int[] generateRandomInts()
	{
		int array[]=new int[20];
		Random random=new Random();
		for(int i=0;i<20;i++)
			array[i]=random.nextInt(89)+11; // generate between 11 to 99
		// sort the array
		Arrays.sort(array);
		return array;
	}
/**
 * This method is used to find out the time taken to serach for the int t in the recursive or non recursive mthods
 * @param array-array to be searched from
 * @param t-number to be searched from the array
 */
	public void time(int array[],int t)
	{
		// using the  recusive method for nanoseconds
		long s=System.nanoTime();
		recursiveBinarySearch(array,0,array.length-1,t);
		long time=System.nanoTime()-s;
		System.out.println("Recursive method will take "+time+"ns");
		
		// using the  recusive method for miliseconds
		s=System.currentTimeMillis();
		recursiveBinarySearch(array,0,array.length-1,t);
		time=System.currentTimeMillis()-s;
		System.out.println("Recursive method will take "+time+"ms");


		// using the  non-recusive method for nanoseconds
		s=System.nanoTime();
		nonRecursiveBinarySearch(array,t);
		time=System.nanoTime()-s;
		System.out.println("Non Recursive method will take "+time+"ns");
        
		// using the  non-recusive method for milliseconds
		s=System.currentTimeMillis();
		nonRecursiveBinarySearch(array,t);
		time=System.currentTimeMillis()-s;
		System.out.println("Non Recursive method will take "+time+"ms");



	}





}

