package com.algorithms;

public class LinkedList {
	private Link first;
		
	public LinkedList() {
		first=null;
	}
	
	private class Link{
		public int key;
		public double value;
		public Link next;
		
		public Link(int key, double value) {
			this.key = key;
			this.value = value;
		}
		
		public void displayLink(){
			System.out.println("{"+ key + ","+ value +"}");
		}
	}
	
	public void insertFirst(int key, double value){
		Link link = new Link(key, value);
		link.next = first;
		first = link;
	}
	
	public Link find(int k){
		Link current = first;
		while(current.key != k){
			// couldn't find it
			if(current.next == null){
				return null;
			}
			// go to next link
			else{
				current = current.next;
			}
		}
		return current; 
	}
	
	public Link delete(int k){
		Link current = first;
		Link previous = first;
		while(current.key != k){
			// couldn't find it
			if(current.next == null){
				return null;
			}
			// go to next link
			else{
				previous = current;
				current = current.next;
			}				
		}
		// if first link
		if(current == first){
			first = first.next;
		}
		// otherwise bypass it
		else{
			previous.next = current.next;
		}
		return current;
	}
	
	public void displayList(){
		Link current = first;
		while(current!=null){
			current.displayLink();
			current = current.next;
		}
		System.out.println("");
	}
}
