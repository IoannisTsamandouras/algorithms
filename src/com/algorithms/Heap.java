package com.algorithms;

public class Heap {
	private Node[] heapArray;
	// size of array
	private int size;
	// number of nodes in array
	private int num;
	
	public Heap(int size) {
		this.size = size;
		num=0;
		heapArray = new Node[size];
	}
	
	private static class Node{		
		private int key;
		
		public Node(int key) {
			this.key=key;
		}
		
		public int getKey() {
			return key;
		}
		
		public void setKey(int key) {
			this.key = key;
		}
	}
	
	//check if heap is empty
	public boolean isEmpty(){
		return num==0;		
	}
	
	public boolean insert(int key){
		if(num==size){
			return false;
		}
		else{
			Node node = new Node(key);
			heapArray[num]=node;
			crawlUp(num++);
			return true;
		}
	}
	
	public void crawlUp(int index){
		int parent = (index-1)/2;
		Node bottom = heapArray[index];
		
		while(index>0 && heapArray[parent].getKey() < bottom.getKey()){
			// move it down
			heapArray[index]=heapArray[parent];
			index=parent;
			parent =(parent-1)/2;
		}
		heapArray[index]=bottom;
	}
	
	// delete item with maximum key
	public Node delete(){
		Node root = heapArray[0];
		heapArray[0]=heapArray[--size];
		crawlDown(0);		
		return root;
	}
	
	public void crawlDown(int index){
		int child;
		// save root
		Node top = heapArray[index];
		// while node has at least one child
		while(index<num/2){
			int leftChild = 2*index + 1;
			int rightChild = leftChild + 1;
			// find larger child
			if(rightChild < num && heapArray[leftChild].getKey()<heapArray[rightChild].getKey()){
				child = rightChild;				
			}
			else{
				child = leftChild;
			}			
			if(top.getKey() >= heapArray[child].getKey()){
				break;				
			}			
			// shift child up
			heapArray[index] = heapArray[child];
			// go down
			index = child;
		}
		// root to index
		heapArray[index] = top;	
	}
	
	public boolean change(int index, int value){
		if(index < 0 || index > num){
			return false;
		}
		// get old value
		int val = heapArray[index].getKey();
		// change to new value
		heapArray[index].setKey(value);
		if(val<value){
			crawlUp(index);
		}
		else{
			crawlDown(index);
		}			
		return true;		
	}
		
}

