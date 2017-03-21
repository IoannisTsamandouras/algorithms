package com.algorithms;

public class HashTable {
	private int size;
	private DataItem[] hashArray;	// holds hash table
	private DataItem noItem;		// deleted item
	
	public HashTable(int size) {
		this.size=size;
		hashArray = new DataItem[size];
		// deleted item key is -1
		noItem = new DataItem(-1);
		}
	
	private static final class DataItem{
		int key;
		
		 public DataItem(int data) {
			 key=data;		
		}
		 
		 public int getKey(){
			 return key;
		 }
	}
	
	public void displayHashTable(){
		for(int j=0; j<size; j++){
			if(hashArray[j]!=null){
				System.out.println(hashArray[j].getKey()+ " ");
			}			
			else{
				System.out.println("** ");
			}
		}
		System.out.println("");
	}
	
	// hash function
	public int hashFunc(int key){
		return key % size; 
	}
	
	public DataItem findItem(int key){
		int value = hashFunc(key);
		while(hashArray[value]!=null){
			if(hashArray[value].getKey()==key){
				return hashArray[value];
			}
			// get to next cell
			++value;
			// wrap around if necessary
			value %=size;			
		}
		// can't find it
		return null;
	}
		
	public void insertItem(DataItem item){
		// extract key
		int key = item.getKey();
		int value = hashFunc(key);
		// hash the key until cell is empty or -1
		while(hashArray[value]!=null && hashArray[value].getKey()!=-1){
			// go to next cell
			++value;
			// wrap around if necessary
			value %= size;			
		}
		//insert item
		hashArray[value]=item;
	}
	
	public DataItem deleteItem(int key){
		int value = hashFunc(key);
		
		while(hashArray[value]!=null){
			if(hashArray[value].getKey()==key){
				// save item
				DataItem item = hashArray[value];
				hashArray[value]=noItem;
				return item;				
			}
			// go to next cell
			++value;
			// wrap around if necessary
			value %= size;			
		}
		// can't find item
		return null;
	}	
}