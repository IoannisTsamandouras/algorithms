package com.algorithms;

public class InsertSort {
	private long[] array;
	private int size;
	
	public InsertSort(int maxSize) {
		array = new long[maxSize];
		size=0;
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
	
	public void insertSort(){
		int in, out;
		long temp;
		for(out=1; out<size; out++){
			temp= array[out];
			// start shift at out
			in = out;
			while(in>0 && array[in-1]>=temp){
			// shift to right
				array[in] = array[in-1];
			// go left one position
				--in;
			}
			// insert value
			array[in] = temp;
		}		
	}
}
