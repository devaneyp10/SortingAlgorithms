// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author Paul Devaney
 *  @version HT 2018
 */

 class SortComparison {
	 static double[] aux;
    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[])
    {
    	double temp;
        for (int i=1; i<a.length; i++)
        {
            for(int j=i; j>0; j--)
            {
                if(a[j]<a[j-1])
                {
                	//swap the two elements
                    temp=a[j];
                    a[j]=a[j-1];
                    a[j-1]=temp;
                }
            }
        }
        return a;
    }

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){
        quickSort(0, a.length - 1, a);
        return a;
    }

    private static void quickSort(int low, int high, double[] a) {
        int i = low, j = high;
        double pivot = a[low+(high-low)/2];

        while(i<=j)
        {
            while(a[i]<pivot)
                i++;
                       
            while(a[j]>pivot) 
                j--;

            if (i<=j) 
            {
            	double temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(low, j, a);
        if (i < high)
            quickSort(i, high, a);
    }

    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] mergeSort (double a[])
    {
    	int hi = a.length-1;
    	int lo = 0;
    	aux = new double[a.length];

    	mergeSort(a, lo, hi);
    	return a;
    }
    	
    	
    
    private static void mergeSort(double[] a, int lo, int hi)
    {
    	if(lo<hi)
    	{
    		int mid = lo+(hi-lo)/2;
    		mergeSort(a, lo, mid);
    		mergeSort(a, mid+1, hi);
    		merge(a, lo, mid, hi);
    		
    	}
    }
    
    private static void merge(double[] a, int lo, int mid, int hi)
    {	
    	//copy elements into auxiliary array
    	for(int i=lo; i<=hi; i++)
    		aux[i] = a[i];
    	
    	//copy smallest elements back into array
    	int i = lo, j = mid+1, k=lo;
    	while(i<=mid && j <= hi)
    	{
    		if(aux[i]<=aux[j])
    		{
    			a[k] = aux[i];
    			i++;
    		}
    		else
    		{
    			a[k] = aux[j]; 
    			j++;
    		}
    		k++;
    	}
    	
    	while(i<=mid)
    	{
    		a[k]=aux[i];
    		k++;
    		i++;
    	}
    }
    
  
    /**
     * Sorts an array of doubles using Shell Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] shellSort (double[] a)
    {
		int i, j;
		double temp;

		int h=1;
		while(h<=a.length/3) 
		{
			h=h*3+1;
		}
		while (h>0) 
		{
			for (i=h; i<a.length; i++) 
			{
				temp = a[i];
				j=i;

				while (j>h-1 && a[j-h]>=temp) 
				{
					a[j]=a[j-h];
					j-=h;
				}
				a[j]=temp;
			}
			h=(h-1)/3;
		}
		return a;
    }
    
    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[])
    {
    	for(int i=0; i< a.length; i++)
    	{
    		int min=i;
    		for(int j=i+1; j<a.length; j++)
    		{
    			if(a[j] < a[min])
    				min=j;
    		}
    		
    		double temp=a[min];
    		a[min]=a[i];
    		a[i]=temp;
    	}
    	return a;

    }
    /**
     * Sorts an array of doubles using Bubble Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] bubbleSort (double a[])
    {
    	  int n = a.length;  
          double temp = 0;  
           for(int i=0; i < n; i++){  
                   for(int j=1; j < (n-i); j++){  
                            if(a[j-1] > a[j]){  
                                   //swap elements  
                                   temp = a[j-1];  
                                   a[j-1] = a[j];  
                                   a[j] = temp;  
                           }  
                            
                   }  
           }  
           return a;
    		
	}

//testing each method works
//    public static void main(String[] args) 
//    {
//    	double[] a = {3, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
//    	a = shellSort(a);
//    	for(int i=0;i<a.length;i++)
//    		System.out.print(""+a[i]+", ");
//    }

 }