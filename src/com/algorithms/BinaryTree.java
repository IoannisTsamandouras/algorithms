package com.algorithms;

public class BinaryTree {
	private Node root;
	
	public BinaryTree() {
	// no nodes yet
		root = null;	
	}	

	private static class Node{
		int data;
		Node right, left;
		
		public Node() {
			data=0;
			right=null;
			left=null;
		}
		
		Node(int data){
			this.data=data;
			right=null;
			left=null;
		}
		
		public int getData() {
			return data;
		}
		
		public void setData(int data) {
			this.data = data;
		}
		
		public Node getLeft() {
			return left;
		}
		
		public void setLeft(Node left) {
			this.left = left;
		}
		
		public Node getRight() {
			return right;
		}
		
		public void setRight(Node right) {
			this.right = right;
		}
	}
	
	// check if tree is empty
	public boolean isEmpty(){
		return root==null;
	}
	
	// insert data
	public void insert(int data){
		root = insert(data,root);
	}
	
	// recursive function to insert data
	private Node insert(int data, Node node){
		if(node ==null){
			node = new Node();
		}
		else{
			if(node.getRight()==null){
				node.right=insert(data, node.right);
			}
			else{
				node.left = insert(data, node.left);
			}
		}
		return node;
	}
	
	// count number of nodes
	public int numOfNodes(){
		return numOfNodes(root);
	} 
	
	// recursive function to count number of nodes
	private int numOfNodes(Node node){
		if(node==null){
			return 0;
		}
		else{
			int number =1;
			number += numOfNodes(node.left);
			number += numOfNodes(node.right);
			return number;
		}
	}
	
	// search for a value
	public boolean search(int value){
		return search(value, root);
	}
	
	// recursive function to search for a value
	private boolean search(int value, Node node){
		if(node.getData()==value){
			return true;
		}
		while(node.getLeft()!=null){
			if(search(value, node.getLeft())){
				return true;
			}			
		}
		while(node.getRight()!=null){
			if(search(value, node.getRight())){
				return true;
			}
		}
		return false;
	}
	
	// inorder traversal	
	public void inorder(){
		inorder(root);
	}
	
	private void inorder(Node node){
		if(node!=null){
			inorder(node.getLeft());
			System.out.println(node.getData()+ " ");
			inorder(node.getRight());
		}
	}
	
	// preorder traversal
	public void preorder(){
		preorder(root);
	} 
	
	private void preorder(Node node){
		if(node!=null){
		System.out.println(node.getData()+ " ");
		preorder(node.getLeft());
		preorder(node.getRight());
		}
	}
	
	// postorder traversal
	public void postorder(){
		postorder(root);
	}
	
	private void postorder(Node node){
		if(node!=null){
			postorder(node.getLeft());
			postorder(node.getRight());
			System.out.println(node.getData()+" ");
		}		
	}		
}