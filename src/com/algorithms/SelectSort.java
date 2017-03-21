package com.algorithms;

public class SelectSort {
	private long[] array;
	private int size;
	
	public SelectSort(int maxSize) {
		array = new long[maxSize];
		size = 0;
	}
	
	public void insert(long value){
		array[size] = value;
		size++;
	}
	
	public void display(){
		for(int j=0; j<size; j++){
			System.out.println(array[j]+" ");
		}
	}
	
	public void swap(int a, int b){
		long temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	public void selectionSort(){
		int in, out, min;
		for(out=0; out<size-1; out++){
		// minimum value
			min = out;
			for(in=out+1; in<size; in++){
				if(array[in] < array[min]){
					min = in;
				}
			}
			swap(out, min);
		}
	}
}
