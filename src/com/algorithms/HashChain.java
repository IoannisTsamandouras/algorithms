package com.algorithms;

public class HashChain {
	private int size;
	private SortedList[] hashArray;
		
	public HashChain(int size) {
		this.size=size;
		// hash table
		hashArray = new SortedList[size];		
		for(int j=0; j<size; j++){
		// fill array with lists
			hashArray[j]=new SortedList();
		}
	}
	
	private static class Link{
		int key;
		Link next;
		public Link(int key) {
			this.key =key;		
		}
		
		public int getKey(){
			return key;
		}
		
		public void display(){
			System.out.println(key+" ");
		}
	}
	
	private static class SortedList{
		// first list item
		Link first;
		
		public SortedList() {
			first=null;		
		}
		
		public void displayList(){
			Link current=first;
			while(current!=null){
				current.display();
			// go to next link
				current=current.next;
			}
			System.out.println(" ");
		} 
		
		public Link findList(int key){
			Link current=first;
			while(current!=null && current.getKey()<=key){
				if(current.getKey()==key){
					return current;					
				}
			// go to next link 
				current=current.next;
			}
			// can't find it
			return null;			
		}
		
		public void insertList(Link link){
			int key = link.getKey();
			// start at first
			Link previous= null;
			Link current=first;
			while(current!=null && key>current.getKey()){
				previous = current;
				current=current.next;
			}
			// if beginning of list
			if(previous!=null){
				first=link;				
			}
			else{
				previous.next=link;
				link.next=current;
			}
		}
		
		public void deleteList(int key){
			Link previous=null;
			Link current=first;
			while(current!=null && key!=current.getKey()){
				previous=current;
			// go to next link
				current=current.next;
			}
			if(previous!=null){
			// if at beginning delete first link
				first=first.next;				
			}			
			else{
			// delete current link
				previous.next=current.next;
			}
		}
	}	
	
	public int hashFunc(int key){
		return key%size;
	}
	
	public void displayTable(){
		for(int j=0; j<size; j++){
			hashArray[j].displayList();
		}
	}
	
	public Link find(int key){
		int value = hashFunc(key);
		Link link = hashArray[value].findList(key);
		return link; 		
	}
	
	public void insert(Link link){
		int key = link.getKey();
		int value = hashFunc(key);
		hashArray[value].insertList(link);
	}
	
	public void delete(int key){
		int value = hashFunc(key);
		hashArray[value].deleteList(key);
	}
}











