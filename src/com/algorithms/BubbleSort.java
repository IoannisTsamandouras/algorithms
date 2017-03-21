package com.algorithms;

public class BubbleSort {
	private long[] array;
	private int size;
	
	public BubbleSort(int size) {
			this.size = size;
			array = new long[size];
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
	
	public void bubble(){
		for(int out=size-1; out>1; out--){
			for(int in=0; in<out; in++){
				if(array[in] > array[in+1]){
					swap(in, in+1);
				}
			}
		}
	}
	
	public void swap(int a, int b){
		long temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
