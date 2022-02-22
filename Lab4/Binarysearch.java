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
		//Arrays.sort(array);
		return array;
	}
/**
 * This method is used to find out the time taken to serach for the int t in the recursive or non recursive mthods
 * @param array-array to be searched from
 * @param t-number to be searched from the array
 */
	public void time1(int array[],int t)
	{
		// using the  recusive method for nanoseconds
		 // for recusive 
        long start=System.nanoTime();
        //recursiveBinarySearch(array,0,array.length-1,t);
        long time=System.nanoTime()-start;
        System.out.println("Time taken in  "+time+"ns");
        
    start=System.currentTimeMillis();
        //recursiveBinarySearch(array,0,array.length-1,t);
        time=System.currentTimeMillis()-start;
        System.out.println("Time taken in "+time+"ms");
        

		

		
	}


	public void time2(int array[],int t)
	{
		// using the  non-recusive method for nanoseconds
		 long start=System.nanoTime();
         //nonRecursiveBinarySearch(array,t);
          long time=System.nanoTime()-start;
         System.out.println("Time taken in nanseconds  "+time+"ns");
         
     start=System.currentTimeMillis();
         //nonRecursiveBinarySearch(array,t);
         time=System.currentTimeMillis()-start;
         System.out.println("time taken in milisecons "+time+"ms");
	}
	/**
	 * Sorting method using bubbleSort
	 * for unsorted array
	 * @param arr for array to sort
	 * 
	 */
    public void bubbleSort(int[] arr) {
    	boolean sorted = false;
    	
    	int temp;
    	
    	while(!sorted) {
    	sorted = true;
    	for (int i = 0; i < arr.length - 1&&sorted; i++) {
    		sorted=true;
    		for (int j=0; j<arr.length-i-1; j++) {
    	if (arr[j] > arr[j+1]) {
    	temp = arr[j];
    	arr[j] = arr[j+1];
    	arr[j+1] = temp;
    	sorted = false;
    	}//end of if statement
    	}//end of inner loop
    	}//end of outer loop
    	}//end of while loop
    	}//end of bubbleSort method
    
    /**
	 * Sorting method using selection
	 * for unsorted array
	 * @param arr for array to sort
	 * 
	 */
    public void selectionSort(int[] arr) {
    	
    	for (int i = 0; i < arr.length-1; i++) {
    	int min = i;
    	
    	for (int j = i+1; j < arr.length; j++) {
    	if (arr[j] < arr[min]) {
    	min = j;
   
    	}
    	}//end of inner for loop
    	// swapping
    	int temp = arr[min];
    	arr[min] =arr [i];
    	arr[i] = temp;
    	}//end of outer for loop
    }//end of selectionSort method
    /**
	 * Sorting method using insertion
	 * for unsorted array
	 * @param arr for array to sort
	 * 
	 */
    public void insertionSort(int[] arr) {
    	for (int j = 1; j < arr.length; j++) {
    	int current = arr[j];
    	int i = j - 1;
    	while((i >= 0) && (current < arr[i])) {
    	arr[i+1] = arr[i];
    	i--;
    	}//end of while loop
    	arr[i+1] = current;
    	}//end of outer loop
    	}//end of method
    /**
	 * Sorting method using merge
	 * for unsorted array
	 * @param arr for array to sort
	 * @param left for left index
	 * @param right for right index
	 * 
	 */
    public void mergeSort(int[] arr, int left, int right) {
    	
    	if (left<right) {
    		int middle= left +(right-left)/2;
    		// Below step sorts the left side of the array
    		mergeSort(arr, left, middle);
    		//Below step sorts the right side of the array
    		mergeSort(arr, middle+1, right);
    		
    		//Now merge both sides
    		merge (arr, left, middle, right);
    	}//end of for loop
    	
    }//end of mergeSort method
    /**
	 * private method to be called in merge 
	 * for unsorted array
	 * @param arr for array to sort
	 * @parm left for left index
	 * @param right for right index
	 * @param middle for index middle
	 * 
	 */
    	private void merge(int[] arr, int left, int middle, int right) {
    		
    	//array= new int [numItems];
    		for (int i= left; i<=right; i++) {
    			arr[i]=arr[i];
    		}
    		
    		int i= left;
    		int j= middle+1;
    		int k= left;
    		while (i<=middle&&j<=right) {
    			if (arr[i]<=arr[j]) {
    				arr[k]=arr[i];
    				i++;
    			}else {
    				arr[k]=arr[j];
    				j++;
    			}
    			while (i<=middle) {
    				arr[k]=arr[i];
    				k++;
    				i++;
    			}//end of inner while loop
    		}//end of while loop
    		
    	}//end of private merge method
	/**
	 * Sorting method using quick sort
	 * for unsorted array
	 * @param arr for array to sort
	 * @param start for index 0
	 * @param end for last index
	 * 
	 */
	public void quickSort(int[] arr, int start, int end) {
		  if (start >= end) 
			    return;
			  int pivot = start, left = start+1, right=end;
			  while (left < right) {		// partition
			    while (arr[left] < arr[pivot] && left <right)  left ++;	
			    while (arr[right] > arr[pivot] && left < right) right --;
			    int temp = arr [left];	// swap
			    arr[left] = arr[right];
			    arr[right] = temp;
			    if (left < right) {
			      left++; right --;
			    } //end of if statement	
			  }//end of while loop
			  if (arr[left] > arr[pivot])
			  { // move pivot and call recursively 
			    int temp = arr[pivot];
			    arr[pivot] = arr[left-1];
			    arr[left-1] = temp;
			    quickSort (arr, start, left-2);
			    quickSort (arr, left, end);
			  } else {
			    int temp = arr[pivot];
			    arr[pivot] = arr[left];
			    arr[left] = temp;
			    quickSort (arr, start, left-1);
			    quickSort (arr, left+1, end);
			}//end of else block

		}//end of quickSort method
}

