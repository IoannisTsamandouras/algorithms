package com.algorithms;

public class HashDouble {
	private int size;
	private DataItem[] hashArray;
	private DataItem noitem;
	
	public HashDouble(int size) {
		this.size=size;
		hashArray = new DataItem[size];
		noitem= new DataItem(-1);
	}
	
	private static class DataItem{
		int key;
		
		public DataItem(int key) {
			this.key = key;
		}
		
		public int getKey(){
			return key;
		}
	}
	
	public void displayTable(){
		for(int j=0; j<size; j++){
			if(hashArray[j]!=null){
			System.out.println(hashArray[j].getKey()+" ");
			}
			else{
				System.out.println("** ");
			}
		}
	}
	
	// hash function
	public int hashFunc1(int key){
		return key % size;
	}
	
	// must be non-zero, less than array size, different from hashFunc1()
    // and array size relatively prime to 5, 4, 3, and 2
	public int hashFunc2(int key ){
		return 5 - key % 5;
	}
	
	public DataItem find(int key){
		// hash the key
		int value = hashFunc1(key);
		// get step size
		int step = hashFunc2(key);
		while(hashArray[value]!=null){
			if(hashArray[value].getKey()==key){
				return hashArray[value];
			}
			// add the step
			value+=step;
			//wrap around
			value%=size;
		}
		return null;
	}
	
	public void insert(int key, DataItem item){
		int value = hashFunc1(key);
		int step = hashFunc2(key);
		while(hashArray[value]!=null && hashArray[value].getKey()!=-1){
			// add the step
			value += step;
			// wrap around
			value %= size;
			}
		// insert item
			hashArray[value]=item;
		}
	
	public DataItem delete(int key){
		int value = hashFunc1(key);
		int step = hashFunc2(key);
		while(hashArray[value]!=null){
			if(hashArray[value].getKey()==key){
				DataItem item = hashArray[value];
				hashArray[value]= noitem;
				return item;
			}
			value += step;
			value %= size;
		}
		return null;
	}	
}




















