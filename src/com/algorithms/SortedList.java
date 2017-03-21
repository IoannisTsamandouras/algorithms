package com.algorithms;

public class SortedList {
	private Link first;
	
	public SortedList() {
		first =null;
	}
	
	class Link{
		public long value;
		public Link next;
		
		public Link(long value) {
			this.value = value;
		}
		
		public void displayLink(){
			System.out.println(value+" ");
		}
	}
	
	public boolean isEmpty(){
		return first ==null;  
	}
	
	public void insert(long value){
		Link link = new Link(value);
		Link previous = null;
		Link current = first;
		while(current != null && value > current.value){
			previous = current;
			current = current.next;
		}			
		if(previous == null){
			first = link;
		}		
		else{
			previous.next = link;
		}
		link.next = current;
	}
	
	public Link remove(){
		Link temp = first;
		first = first.next;
		return temp;
	}
	
	public void displayList(){
		Link current = first;
		while(current!=null){
			current.displayLink();
			current = current.next;
		}
	}
}
