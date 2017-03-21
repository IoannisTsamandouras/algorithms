package com.algorithms;

public class QueueAsList {
	private TheList aList;
		
	public QueueAsList() {
		aList = new TheList();
	}	
	
	class Link{
		public long data;
		public Link next;
		
		public Link(long data) {
			this.data=data;
		}
		
		public void displayLink(){
			System.out.println(data+" ");
		}
	}
	
	class TheList{
		private Link first;
		private Link last;
		
		public TheList() {
			first=null;
			last=null;
		}
		
		public boolean isEmpty(){
			return first==null;
		}
		
		public void insert(long value){
		// insert at end of list
			Link link = new Link(value);
			if(isEmpty()){
				first = link;
			}
			else{
				last.next = link;
			}
			last = link;
		}
		
		public long delete(){
		// delete first link
			long temp = first.data;
			if(first.next==null){
				last = null;
			}
			first= first.next;
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
	
	public boolean isQueueEmpty(){
		return aList.isEmpty();
	}
	
	public void insertQueue(long value){
		aList.insert(value);
	}
	
	public long deleteQueue(){
		return aList.delete();
	}
	
	public void displayQueue(){
		aList.displayList();
	}
}
