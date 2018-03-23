import static org.junit.Assert.assertEquals;




import java.util.Scanner;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.io.File;
import java.io.FileNotFoundException;


// Times are in milliseconds.
/*							| Insert		| Quick  		| Merge 		| Shell	 	   	| Selection 	    	| Bubble		    |
 * 10 Random				|0.88712	 	|0.006943		|0.008452		|0.004226		|0.00483		        |0.003019			|
 * 100 Random				|0.166029		|0.023244		|0.033206		|0.015697		|0.08724			    |0.097807	     	|
 * 1000 Random				|5.691199		|0.156068		|0.0387604		|0.181425		|2.500106			    |2.465391			|
 * 1000 few unique			|1.186057		|0.147314		|0.114712	`	|0.362247		|1.824516				|1.801876		    |
 * 1000 nearly ordered		|3.26834		|0.045885		|0.077581		|0.1811728		|1.081004			    |1.855911			|
 * 1000 reverse order		|0.501711		|0.029282		|0.08090		|0.366247		|1.964283			    |0.1612				|
 * 1000 sorted				|0.18535		|0.0298584		|0.076676		|0.181728		|0.148219			    |0.160294			|
 * 
 * 1. Which of the sorting algorithms does the order of input have an impact on? Why?
 *= All methods are effected when the array is nearly ordered, however they are affected in slightly different ways. For example, Insertion sort
 * deals very poorly with larger input.
2. Which algorithm has the biggest difference between the best and worst performance, based
  on the type of input, for the input of size 1000? Why?
  =Insertion sort, as insertion sort worst case is O(n^2), as there are far more swaps(read and writes) when the array is not sorted 
3. Which algorithm has the best/worst scalability, ie, the difference in performance time based
	
on the input size? Please consider only input files with random order for this answer.
=Quick sort and merge sort have the best scalibility, as their average case is O(nlogn).  Insertion sort has the worst scalibility as its average case is O(N^2)
4. Which algorithm is the fastest for each of the 7 input files? 
 * 10random - bubble
 * 100random - shell
 * 1000random - merge
 * 1000nearlyordered - quick
 * 1000reverse -quick
 * 1000sorted -  quick
 * 
 */



//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2018
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
	//these are the array we will be using for tests
	double[] random = {2, 43, 12, 43, 23, 45, 343, 232, 4345, 2, 354, 2, 445, 342, 54, 3324, 3, 435, 546};
	double[] randomDone = {2, 2, 2, 3, 12, 23, 43, 43, 45, 54, 232, 342, 343, 354, 435, 445, 546, 3324, 4345};
	double[] duplicates = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
	double[] duplicatesDone = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
	double[] nearlyOrdered = {1, 2, 4, 3, 5, 6, 8, 7, 9, 10, 11, 14, 15, 16, 12};
	double[] nearlyOrderedDone = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15, 16};
	double[] reversed = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
	double[] reversedDone = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	double[] sorted = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	double[] sortedDone = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	
	
	
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    	double[] a = {};
    	assertEquals("Testing an empty array.", a.length, 0);
    	
    }
    
    @Test
    public void testInsertionSort()
    {
    	double[] randomCopy = new double[random.length];
    	System.arraycopy(random, 0, randomCopy, 0, random.length);
    	double[] duplicatesCopy = new double[duplicates.length];
    	System.arraycopy(duplicates, 0, duplicatesCopy, 0, duplicates.length);
    	double[] nearlyOrderedCopy = new double[nearlyOrdered.length];
    	System.arraycopy(nearlyOrdered, 0, nearlyOrderedCopy, 0, nearlyOrdered.length);
    	double[] reversedCopy = new double[reversed.length];
    	System.arraycopy(reversed, 0, reversedCopy, 0, reversed.length);
    	double[] sortedCopy = new double[sorted.length];
    	System.arraycopy(sorted, 0, sortedCopy, 0, sorted.length);
    	
    	SortComparison.insertionSort(randomCopy);
    	assertArrayEquals("Checking insertion sort on a randomly ordered array.", randomCopy, randomDone, 0);
    	
    	SortComparison.insertionSort(duplicatesCopy);
    	assertArrayEquals("Checking insertion sort on an array of duplicates.", duplicatesCopy, duplicatesDone, 0);
    	
    	SortComparison.insertionSort(nearlyOrderedCopy);
    	assertArrayEquals("Checking insertion sort on an array of nearly ordered elements.", nearlyOrderedCopy, nearlyOrderedDone, 0);
    	
    	SortComparison.insertionSort(reversedCopy);
    	assertArrayEquals("Checking insertion sort on an array of reersed elements.", reversedCopy, reversedDone, 0);
    	
    	SortComparison.insertionSort(sortedCopy);
    	assertArrayEquals("Checking insertion sort on an array of duplicates", sortedCopy, sortedDone, 0);
    	
    }
    @Test
    public void testQuickSort()
    {
    	  
    	    	double[] randomCopy = new double[random.length];
    	    	System.arraycopy(random, 0, randomCopy, 0, random.length);
    	    	double[] duplicatesCopy = new double[duplicates.length];
    	    	System.arraycopy(duplicates, 0, duplicatesCopy, 0, duplicates.length);
    	    	double[] nearlyOrderedCopy = new double[nearlyOrdered.length];
    	    	System.arraycopy(nearlyOrdered, 0, nearlyOrderedCopy, 0, nearlyOrdered.length);
    	    	double[] reversedCopy = new double[reversed.length];
    	    	System.arraycopy(reversed, 0, reversedCopy, 0, reversed.length);
    	    	double[] sortedCopy = new double[sorted.length];
    	    	System.arraycopy(sorted, 0, sortedCopy, 0, sorted.length);
    	    	
    	    	SortComparison.quickSort(randomCopy);
    	    	assertArrayEquals("Checking quick sort on a randomly ordered array.", randomCopy, randomDone, 0);
    	    	
    	    	SortComparison.quickSort(duplicatesCopy);
    	    	assertArrayEquals("Checking quickl sort on an array of duplicates.", duplicatesCopy, duplicatesDone, 0);
    	    	
    	    	SortComparison.quickSort(nearlyOrderedCopy);
    	    	assertArrayEquals("Checking quick sort on an array of nearly ordered elements.", nearlyOrderedCopy, nearlyOrderedDone, 0);
    	    	
    	    	SortComparison.quickSort(reversedCopy);
    	    	assertArrayEquals("Checking  quick sort on an array of reersed elements.", reversedCopy, reversedDone, 0);
    	    	
    	    	SortComparison.quickSort(sortedCopy);
    	    	assertArrayEquals("Checking quick sort on an array of duplicates", sortedCopy, sortedDone, 0);
    }
    @Test
    public void testMergeSort()
    {
    	double[] randomCopy = new double[random.length];
    	System.arraycopy(random, 0, randomCopy, 0, random.length);
    	double[] duplicatesCopy = new double[duplicates.length];
    	System.arraycopy(duplicates, 0, duplicatesCopy, 0, duplicates.length);
    	double[] nearlyOrderedCopy = new double[nearlyOrdered.length];
    	System.arraycopy(nearlyOrdered, 0, nearlyOrderedCopy, 0, nearlyOrdered.length);
    	double[] reversedCopy = new double[reversed.length];
    	System.arraycopy(reversed, 0, reversedCopy, 0, reversed.length);
    	double[] sortedCopy = new double[sorted.length];
    	System.arraycopy(sorted, 0, sortedCopy, 0, sorted.length);
    	
    	SortComparison.mergeSort(randomCopy);
    	assertArrayEquals("Checking merge sort on a randomly ordered array.", randomCopy, randomDone, 0);
    	
    	SortComparison.mergeSort(duplicatesCopy);
    	assertArrayEquals("Checking merge sort on an array of duplicates.", duplicatesCopy, duplicatesDone, 0);
    	
    	SortComparison.mergeSort(nearlyOrderedCopy);
    	assertArrayEquals("Checking merge sort on an array of nearly ordered elements.", nearlyOrderedCopy, nearlyOrderedDone, 0);
    	
    	SortComparison.mergeSort(reversedCopy);
    	assertArrayEquals("Checking merge sort on an array of reersed elements.", reversedCopy, reversedDone, 0);
    	
    	SortComparison.mergeSort(sortedCopy);
    	assertArrayEquals("Checking merge sort on an array of duplicates", sortedCopy, sortedDone, 0);
    }
    
    @Test
    public void testShellSort()
    {
    	double[] randomCopy = new double[random.length];
    	System.arraycopy(random, 0, randomCopy, 0, random.length);
    	double[] duplicatesCopy = new double[duplicates.length];
    	System.arraycopy(duplicates, 0, duplicatesCopy, 0, duplicates.length);
    	double[] nearlyOrderedCopy = new double[nearlyOrdered.length];
    	System.arraycopy(nearlyOrdered, 0, nearlyOrderedCopy, 0, nearlyOrdered.length);
    	double[] reversedCopy = new double[reversed.length];
    	System.arraycopy(reversed, 0, reversedCopy, 0, reversed.length);
    	double[] sortedCopy = new double[sorted.length];
    	System.arraycopy(sorted, 0, sortedCopy, 0, sorted.length);
    	
    	SortComparison.shellSort(randomCopy);
    	assertArrayEquals("Checking shell sort on a randomly ordered array.", randomCopy, randomDone, 0);
    	
    	SortComparison.shellSort(duplicatesCopy);
    	assertArrayEquals("Checking shell sort on an array of duplicates.", duplicatesCopy, duplicatesDone, 0);
    	
    	SortComparison.shellSort(nearlyOrderedCopy);
    	assertArrayEquals("Checking shell sort on an array of nearly ordered elements.", nearlyOrderedCopy, nearlyOrderedDone, 0);
    	
    	SortComparison.shellSort(reversedCopy);
    	assertArrayEquals("Checking shell sort on an array of reersed elements.", reversedCopy, reversedDone, 0);
    	
    	SortComparison.shellSort(sortedCopy);
    	assertArrayEquals("Checking shell sort on an array of duplicates", sortedCopy, sortedDone, 0);
    }
    
    @Test 
    public void testSelectionSort()
    {
    	double[] randomCopy = new double[random.length];
    	System.arraycopy(random, 0, randomCopy, 0, random.length);
    	double[] duplicatesCopy = new double[duplicates.length];
    	System.arraycopy(duplicates, 0, duplicatesCopy, 0, duplicates.length);
    	double[] nearlyOrderedCopy = new double[nearlyOrdered.length];
    	System.arraycopy(nearlyOrdered, 0, nearlyOrderedCopy, 0, nearlyOrdered.length);
    	double[] reversedCopy = new double[reversed.length];
    	System.arraycopy(reversed, 0, reversedCopy, 0, reversed.length);
    	double[] sortedCopy = new double[sorted.length];
    	System.arraycopy(sorted, 0, sortedCopy, 0, sorted.length);
    	
    	SortComparison.selectionSort(randomCopy);
    	assertArrayEquals("Checking selection sort on a randomly ordered array.", randomCopy, randomDone, 0);
    	
    	SortComparison.selectionSort(duplicatesCopy);
    	assertArrayEquals("Checking selection sort on an array of duplicates.", duplicatesCopy, duplicatesDone, 0);
    	
    	SortComparison.selectionSort(nearlyOrderedCopy);
    	assertArrayEquals("Checking selection sort on an array of nearly ordered elements.", nearlyOrderedCopy, nearlyOrderedDone, 0);
    	
    	SortComparison.selectionSort(reversedCopy);
    	assertArrayEquals("Checking selection sort on an array of reersed elements.", reversedCopy, reversedDone, 0);
    	
    	SortComparison.selectionSort(sortedCopy);
    	assertArrayEquals("Checking selection sort on an array of duplicates", sortedCopy, sortedDone, 0);
    }
    
    @Test 
    public void testBubbleSort()
    {
    	double[] randomCopy = new double[random.length];
    	System.arraycopy(random, 0, randomCopy, 0, random.length);
    	double[] duplicatesCopy = new double[duplicates.length];
    	System.arraycopy(duplicates, 0, duplicatesCopy, 0, duplicates.length);
    	double[] nearlyOrderedCopy = new double[nearlyOrdered.length];
    	System.arraycopy(nearlyOrdered, 0, nearlyOrderedCopy, 0, nearlyOrdered.length);
    	double[] reversedCopy = new double[reversed.length];
    	System.arraycopy(reversed, 0, reversedCopy, 0, reversed.length);
    	double[] sortedCopy = new double[sorted.length];
    	System.arraycopy(sorted, 0, sortedCopy, 0, sorted.length);
    	
    	SortComparison.bubbleSort(randomCopy);
    	assertArrayEquals("Checking bubble sort on a randomly ordered array.", randomCopy, randomDone, 0);
    	
    	SortComparison.bubbleSort(duplicatesCopy);
    	assertArrayEquals("Checking bubble sort on an array of duplicates.", duplicatesCopy, duplicatesDone, 0);
    	
    	SortComparison.bubbleSort(nearlyOrderedCopy);
    	assertArrayEquals("Checking bubble sort on an array of nearly ordered elements.", nearlyOrderedCopy, nearlyOrderedDone, 0);
    	
    	SortComparison.bubbleSort(reversedCopy);
    	assertArrayEquals("Checking bubble sort on an array of reersed elements.", reversedCopy, reversedDone, 0);
    	
    	SortComparison.bubbleSort(sortedCopy);
    	assertArrayEquals("Checking bubble sort on an array of duplicates", sortedCopy, sortedDone, 0);
    }



    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     * @throws FileNotFoundException 
     *
//     */
//    public static void main(String[] args) throws FileNotFoundException
//    {
//    	//read in text files
//        File ten = new File("numbers10.txt");
//        File hundred = new File("numbers100.txt");
//        File thousand = new File("numbers1000.txt");
//        File duplicatesFile = new File("numbers1000Duplicates.txt");
//        File nearlyOrderedFile = new File("numbersNearlyOrdered1000.txt");
//        File reversedFile = new File("numbersReverse1000.txt");
//        File sortedFile = new File("numbersSorted1000.txt");
//        
//        
//        int i=10,j=100,k=1000;
//        
//        //convert each file to a double array
//        double[] file10 = toDoubleArray(ten, i);
//        double[] file100 = toDoubleArray(hundred, j);
//        double[] file1000 = toDoubleArray(thousand, k);
//        double[] duplicates = toDoubleArray(duplicatesFile, k);
//        double[] nearlyOrdered = toDoubleArray(nearlyOrderedFile, k);     
//        double[] reversed = toDoubleArray(reversedFile, k);
//        double[] sorted = toDoubleArray(sortedFile, k);
//        
//        //print average times for each method for each file
//        System.out.print("Average time for insertion sort for numbers10.txt: " + insertionTimer(file10) + "ms\n");
//        System.out.print("Average time for insertion sort for numbers100.txt: " + insertionTimer(file100)+ "ms\n");
//        System.out.print("Average time for insertion sort for numbers1000.txt: " + insertionTimer(file1000)+ "ms\n");
//        System.out.print("Average time for insertion sort for numbers1000Duplicates.txt: " + insertionTimer(duplicates)+ "ms\n");
//        System.out.print("Average time for insertion sort for numbersNearlyOrdered1000.txt: " + insertionTimer(nearlyOrdered)+ "ms\n");
//        System.out.print("Average time for insertion sort for numbersReverse1000.txt: " + insertionTimer(reversed)+ "ms\n");
//        System.out.print("Average time for insertion sort for numbersSorted1000.txt: " + insertionTimer(sorted)+ "ms\n");
//        
//        System.out.print("\n\n");
//        
//        System.out.print("Average time for quick sort for numbers10.txt: " + quickTimer(file10)+ "ms\n");
//        System.out.print("Average time for quick sort for numbers100.txt: " + quickTimer(file100)+ "ms\n");
//        System.out.print("Average time for quick sort for numbers1000.txt: " + quickTimer(file1000)+ "ms\n");
//        System.out.print("Average time for quick sort for numbers1000Duplicates.txt: " + quickTimer(duplicates)+ "ms\n");
//        System.out.print("Average time for quick sort for numbersNearlyOrdered1000.txt: " + quickTimer(nearlyOrdered)+ "ms\n");
//        System.out.print("Average time for quick sort for numbersReverse1000.txt: " + quickTimer(reversed)+ "ms\n");
//        System.out.print("Average time for quick sort for numbersSorted1000.txt: " + quickTimer(sorted)+ "ms\n");
//        
//        System.out.print("\n\n");
//        
//        System.out.print("Average time for merge sort for numbers10.txt: " + mergeTimer(file10)+ "ms\n");
//        System.out.print("Average time for merge sort for numbers100.txt: " + mergeTimer(file100)+ "ms\n");
//        System.out.print("Average time for merge sort for numbers1000.txt: " + mergeTimer(file1000)+ "ms\n");
//        System.out.print("Average time for merge sort for numbers1000Duplicates.txt: " + mergeTimer(duplicates)+ "ms\n");
//        System.out.print("Average time for merge sort for numbersNearlyOrdered1000.txt: " + mergeTimer(nearlyOrdered)+ "ms\n");
//        System.out.print("Average time for merge sort for numbersReverse1000.txt: " + mergeTimer(reversed)+ "ms\n");
//        System.out.print("Average time for merge sort for numbersSorted1000.txt: " + mergeTimer(sorted)+ "ms\n");
//        
//        System.out.print("\n\n");
//
//        System.out.print("Average time for shell sort for numbers10.txt: " + shellTimer(file10)+ "ms\n");
//        System.out.print("Average time for shell sort for numbers100.txt: " + shellTimer(file100)+ "ms\n");
//        System.out.print("Average time for shell sort for numbers1000.txt: " + shellTimer(file1000)+ "ns\n");
//        System.out.print("Average time for shell sort for numbers1000Duplicates.txt: " + shellTimer(duplicates)+ "ms\n");
//        System.out.print("Average time for shell sort for numbersNearlyOrdered1000.txt: " + shellTimer(nearlyOrdered)+ "ms\n");
//        System.out.print("Average time for shell sort for numbersReverse1000.txt: " + shellTimer(reversed)+ "ms\n");
//        System.out.print("Average time for shell sort for numbersSorted1000.txt: " + shellTimer(sorted)+ "ms\n");
//        
//        System.out.print("\n\n");
//        
//        System.out.print("Average time for selection sort for numbers10.txt: " + selectionTimer(file10)+ "ms\n");
//        System.out.print("Average time for selection sort for numbers100.txt: " + selectionTimer(file100)+ "ms\n");
//        System.out.print("Average time for selection sort for numbers1000.txt: " + selectionTimer(file1000)+ "ms\n");
//        System.out.print("Average time for selection sort for numbers1000Duplicates.txt: " + selectionTimer(duplicates)+ "ms\n");
//        System.out.print("Average time for selection sort for numbersNearlyOrdered1000.txt: " + selectionTimer(nearlyOrdered)+ "ms\n");
//        System.out.print("Average time for selection sort for numbersReverse1000.txt: " + selectionTimer(reversed)+ "ms\n");
//        System.out.print("Average time for selection sort for numbersSorted1000.txt: " + selectionTimer(sorted)+ "ms\n");
//        
//        System.out.print("\n\n");
//
//        System.out.print("Average time for bubble sort for numbers10.txt: " + bubbleTimer(file10)+ "ms\n");
//        System.out.print("Average time for bubble sort for numbers100.txt: " + bubbleTimer(file100)+ "ms\n");
//        System.out.print("Average time for bubble sort for numbers1000.txt: " + bubbleTimer(file1000)+ "ms\n");
//        System.out.print("Average time for bubble sort for numbers1000Duplicates.txt: " + bubbleTimer(duplicates)+ "ms\n");
//        System.out.print("Average time for bubble sort for numbersNearlyOrdered1000.txt: " + bubbleTimer(nearlyOrdered)+ "ms\n");
//        System.out.print("Average time for bubble sort for numbersReverse1000.txt: " + bubbleTimer(reversed)+ "ms\n");
//        System.out.print("Average time for bubble sort for numbersSorted1000.txt: " + bubbleTimer(sorted)+ "ms\n");
//        
//        System.out.print("\n\n");
//
//        
//
//
//        
//    }
//
//    private static double[] toDoubleArray(File file, int i) throws FileNotFoundException
//    {
//    	double[] a=new double[i];
//    	Scanner scan = new Scanner(file);
//    	int j = 0;
//    	while(scan.hasNextDouble())
//    	{
//    		a[j] = scan.nextDouble();
//    		j++;
//    	}
//    	return a;
//    }
//    
//    public static double insertionTimer(double[] a)
//    {
//    	double start, end;
//		double[] copy = new double[a.length];
//		System.arraycopy(a, 0, copy, 0, a.length);
//		start = System.nanoTime();
//		SortComparison.insertionSort(a);
//		end = System.nanoTime()-start;
//		return end/1000000;
//    }
//    
//    public static double quickTimer(double[] a)
//    {
//    	double start, end;
//		double[] copy = new double[a.length];
//		System.arraycopy(a, 0, copy, 0, a.length);
//		start = System.nanoTime();
//		SortComparison.quickSort(a);
//		end = System.nanoTime()-start;
//		return end/1000000;
//    }
//    
//    public static double mergeTimer(double[] a)
//    {
//    	double start, end;
//		double[] copy = new double[a.length];
//		System.arraycopy(a, 0, copy, 0, a.length);
//		start = System.nanoTime();
//		SortComparison.mergeSort(a);
//		end = System.nanoTime()-start;
//		return end/1000000;
//    }
//    
//    public static double shellTimer(double[] a)
//    {
//    	double start, end;
//		double[] copy = new double[a.length];
//		System.arraycopy(a, 0, copy, 0, a.length);
//		start = System.nanoTime();
//		copy = SortComparison.shellSort(a);
//		end = System.nanoTime()-start;
//		return end/1000000;
//    }
//    
//    public static double selectionTimer(double[] a)
//    {
//    	double start, end;
//		double[] copy = new double[a.length];
//		System.arraycopy(a, 0, copy, 0, a.length);
//		start = System.nanoTime();
//		copy = SortComparison.selectionSort(a);
//		end = System.nanoTime()-start;
//		return end/1000000;
//    }
//    
//    public static double bubbleTimer(double[] a)
//    {
//    	double start, end;
//		double[] copy = new double[a.length];
//		System.arraycopy(a, 0, copy, 0, a.length);
//		start = System.nanoTime();
//		copy = SortComparison.bubbleSort(a);
//		end = System.nanoTime()-start;
//		return end/1000000;
//    }
    
    
    
    
    
}
