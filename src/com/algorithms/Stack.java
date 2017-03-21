package com.algorithms;

public class Stack {
	private int size;
	private long[] stackArray;
	private int top;
	
	public Stack(int size) {
		this.size = size;
		stackArray = new long[size];
		top = -1;
	}
	
	public boolean isEmpty(){
		return (top == -1);		
	}
	
	public boolean isFull(){
		return (top == size-1);
	}
	
	public void push(long value){
		// put value on top of stack
		stackArray[++top] = value;
	}
	
	public long pop(){
		// take value from top of stack
		return stackArray[top--];
	}
	
	public long peek(){
		// peek at top of stack
		return stackArray[top];
	}
}
