package com.algorithms;

public class Queue {
	private int maxSize;
	private int size;
	private long[] queueArray;
	private int front;
	private int rear;
	
	public Queue(int maxSize) {
		this.maxSize = maxSize;
		size = 0;
		queueArray = new long[maxSize];
		front = 0;
		rear = -1;
		size = 0;
	}
	
	public int getSize(){
		return size;
	}
	
	public boolean isEmpty(){
		return (size == 0);
	}
	
	public boolean isFull(){
		return (size == maxSize);
	}
	
	public long peekFront(){
		return queueArray[front];
	}
	
	public void insert(long value){		
		// wrap around
		if(rear == maxSize-1){
			rear = -1;
		}
		// increment rear and insert value
		queueArray[++rear] = value;
		size++;
	}
	
	public long delete(){
		// get value and increment front
		long temp = queueArray[front++];
		// wrap around
		if(front == maxSize){
			front =0;
		}
		size--;
		return temp;
	}
}
