package com.algorithms;

public class QuickSort {
	private long[] array;
	private int size;
	
	public QuickSort(int maxSize) {
		array = new long[maxSize];
		size = 0;
	}
	
	public void insert(long value){
		array[size]=value;
		size++;
	}
	
	public void display(){
		for(int j=0; j<size; j++){
		System.out.println(array[j] +" ");
		}
	}
	
	public void quickSort(){
		recursiveSort(0, size-1);
	}
	
	public void recursiveSort(int left, int right){
		if(right-left <= 0){
			return;                     
		}
		else{
			// rightmost value
	        long pivot = array[right];
	        // partition range
	        int partition = partitioned(left, right, pivot);
	        // sort left side
	        recursiveSort(left, partition-1);   
	        // sort right side
	        recursiveSort(partition+1, right);
	        }
		}
	
	public int partitioned(int left, int right, long pivot){
		int leftMrk = left-1;
		int rightMrk = right;
        while(true){
        	// find bigger value
        	while( array[++leftMrk] < pivot );
            // find smaller value
        	while(rightMrk > 0 && array[--rightMrk] > pivot);
        	// if markers cross then partition is done
        	if(leftMrk >= rightMrk){
        		break;                    
        	}
        	// if not crossed swap values 
        	else{
        		swap(leftMrk, rightMrk);  
        	}
        }
        	// restore pivot
        swap(leftMrk, right);
        	// return pivot location
        return leftMrk;
    } 
	
	// swap two values
	public void swap(int a, int b){
		long temp = array[a];
		array[a] = array [b];
		array[b] = temp;
	}

}
