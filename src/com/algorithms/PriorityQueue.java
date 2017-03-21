package com.algorithms;

public class PriorityQueue {
	private int maxSize;
	private long[] queueArray;
	private int size;
	
	public PriorityQueue(int maxSize) {
		this.maxSize = maxSize;
		queueArray = new long[size];
		size = 0;
	}
	
	public boolean isEmpty(){
		return (size == 0);
	}
	
	public boolean isFull(){
		return (size == maxSize);
	}
	
	public long peekMin(){
		return queueArray[size-1];
	}
	
	public void insert(long value){
		int j;
		// if no values in queue add one 
		// at the first position 
		if(size == 0){
			queueArray[size++] = value;
		}
		else{
			for(j = size-1; j>=0; j--){
				if(value > queueArray[j]){
					queueArray[j+1] = queueArray[j];
				}
				else{
					break;
				}
			}
			queueArray[j+1] = value;
			size++;
		}
	}
	
	public long delete(){
		// remove minimum value in queue
		return queueArray[--size];		
	}
}
