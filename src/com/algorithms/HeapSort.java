package com.algorithms;

public class HeapSort {
	private static int size;
	
	// build a heap	
	public static void heap(int[] heapArray){
		size = heapArray.length-1;
		for(int j = size/2; j>=0; j--){
			maxSwap(heapArray, j);
		}
	}
	
	// sort heap
		public static void sort(int[] heapArray){
			heap(heapArray);
			for(int j=size; j>0; j--){
				swap(heapArray, 0, j);
				size = size-1;
				maxSwap(heapArray, 0);
			}			
		}
	
	// swap largest element in heap
	public static void maxSwap(int[] array, int m){
		int left = 2*m;
		int right = 2*m + 1; 		
		int max = m;
		
		if(left <= size && array[left] > array[m]){
			max=left;
		}
		
		if(right <= size && array[right] > array[max]){
			max=right;
		}
		
		if(max != m){
			swap(array, m, max);
			maxSwap(array, max);
		}
	}
	
	// swap two numbers in an array
	public static void swap(int[] array, int x, int y){
		int temp = array[x];
		array[x]= array[y];
		array[y] = temp;
	}

}
