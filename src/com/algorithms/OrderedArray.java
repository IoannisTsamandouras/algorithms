package com.algorithms;

public class OrderedArray {
	private long[] array;
	private int size;
	
	public OrderedArray(int s) {
		array = new long[s];
		size=0;
	}
	
	public int getSize(){
		return size;
	}
	
	public int find(long key){
		int upper = size - 1; 
		int lower = 0;
		int current;
		while(true){
			current = (lower + upper) / 2;
			if(array[current] == key){
				return current; 
			}
			else if(lower > upper){
				return size;
			}
			else{
				if(array[current] < key){
				// upper half
					lower = current + 1;
				}
				// lower half
				else{
					upper = current - 1;
				}
			}
		}
	}
	
	public void insert(long value){
		int j;
		for(j=0; j<size; j++){
			if(array[j]>value){
				break;
			}
		}
		for(int k=size; k>j; k--){
		// move bigger values up
			array[k] = array[k-1];
		}
		// insert value
		array[j]=value;
		size++;
	}
	
	public boolean delete(long value){
		int num = find(value);
		// can't find it
		if(num == size){
			return false;
		}
		// found it
		else{
			for(int j=num; j<size; j++){
				array[j]=array[j+1];
				num--;
			}
			return true;
		}
	}
	
	public void display(){
		for(int j=0; j<size; j++){
			System.out.println(array[j]+" ");
		}		
	}
}
