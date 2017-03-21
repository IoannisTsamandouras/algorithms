package com.algorithms;

public class DoubleLinkedList {
	
	private Link first;
	private Link last;
	
	public DoubleLinkedList() {
		first=null;
		last=null;
	}
	
	private static final class Link{
		long data;
		Link previous;
		Link next;
		
		public Link(long data) {
			this.data=data;
		}
		
		public void displayLink(){
			System.out.println(data+" ");
		}		
	}
	
	public boolean isEmpty(){
		return first==null;
	}
	
	// insert at front of list
	public void insertFirst(long d){
		Link link = new Link(d);
		if(isEmpty()){
			last=link;
		}
		else{
			first.previous=link;
		}
		link.next=first;
		first=link;
	}
	
	// insert at end of list
	public void insertLast(long d){
		Link link = new Link(d);
		if(isEmpty()){
			first=link;
		}
		else{
			last.next=link;
			link.previous=last;
		}
		last=link;
	}
	
	// delete first link 
	public Link deleteFirst(){
		Link current = first;
		if(first.next==null){
			last=null;
		}
		else{
			first.next.previous=null;
		}
		first=first.next;
		return current;
	}
	
	// delete last link
	public Link deleteLast(){
		Link current=last;
		if(first.next==null){
			first=null;
		}
		else{
			last.previous.next=null;
		}
		last=last.previous;
		return current;
	}
	
	// insert data right after key
	public boolean insertAfter(long d, long k){
		Link current=first;
		while(current.data!=k){
			current=current.next;
			if(current==null){
				return false;
			}
		}		
		Link link = new Link(d);
		if(current==last){
			link.next=null;
			last=link;
		}
		else{
			link.next=current.next;
			current.next.previous=link;
		}
		link.previous=current;
		current.next=link;
		return true;
	}
	
	public Link deleteKey(long k){
		Link current=last;
		while(current.data!=k){
			current=current.next;
			if(current==null){
				return null;
			}
		}
		if(current==first){
			first=current.next;
		}
		else{
			current.previous.next=current.next;
		}
		if(current==last){
			last=current.previous;
		}
		else{
			current.next.previous=current.previous;
		}		
		return current;
	}
	
	public void displayForward(){
		Link current=first;
		if(current!=null){
			current.displayLink();
			current=current.next;
		}
		System.out.println(" ");
	}
	
	public void displayBackward(){
		Link current=last;
		if(current!=null){
			current.displayLink();
			current=current.previous;
		}
		System.out.println(" ");
	}
}
