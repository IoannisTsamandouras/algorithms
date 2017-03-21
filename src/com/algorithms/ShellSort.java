package com.algorithms;

public class ShellSort {
	private long[] array;
	private int size;
	
	public ShellSort(int maxSize) {
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
	
	public void shellSort(){
		int in, out;
		long temp;
		int val = 1;
		while(val <= size/3){
			val = 3*val + 1;
		}
		
		while(val > 0){
			for(out=val; out<size; out++){
				temp = array[out];
				in = out;
				
				while(in > val-1 && array[in-val] >= temp){
					array[in] = array[in - val];
					in -= val;										
				}
				array[in] = temp;
			}
			val = (val - 1)/3;
		}
	}
}
