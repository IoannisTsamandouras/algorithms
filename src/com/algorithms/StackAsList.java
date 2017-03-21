package com.algorithms;

public class StackAsList {
	private TheList aList;
	
	public StackAsList() {
		aList = new TheList();
	}
	
	class Link{
		public long data;
		public Link next;
		
		public Link(long data) {
			this.data = data;
		}
		
		public void displayLink(){
			System.out.println(data+" ");
		}
	}
	
	class TheList{
		private Link first;
		
		public TheList() {
			first = null;		
		}
		
		public boolean isEmpty(){
			return first == null;
		}
		
		public void insert(long value){
		// insert at start of list
			Link link = new Link(value);
			link.next = first;
			first = link;
		}
		
		public long dalete(){
			Link temp = first;
			first = first.next;
			return temp.data;
		}
		
		public void displayList(){
			Link current = first;
			while(current!=null){
				current.displayLink();
				current = current.next;
			}
		}
		
		public boolean isStackEmpty(){
			return aList.isEmpty();
		}
		
		public void pushStack(long value){
			aList.insert(value);
		}
		
		public long popStack(){
			return aList.dalete();
		}
		
		public void displayStack(){
			aList.displayList();
		}
	}
}
