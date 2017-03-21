package com.algorithms;

public class Tree234 {
	
	Node root;
	
	public Tree234() {
		root = new Node();	
	}
	
	private static final class Dataitem{
		long data;
		
		public Dataitem(long data) {
			this.data=data;		
		}
		
		public void display(){
			System.out.println("/"+data);
		}
	}
	
	private static class Node{
		
		private static final int ORDER=4;
		private Node parent;
		private int num;
		private Node[] childArray = new Node[ORDER];
		private Dataitem[] itemArray = new Dataitem[ORDER-1];
		
		// connect child to this node
		public void connect(int n, Node child){
			childArray[n]=child;
			if(child!=null){
				child.parent=this;
			}
		}
		
		// disconnect child from this node
		public Node disconnect(int n){
			Node temp = childArray[n];
			childArray[n]=null;
			return temp;
		}
		
		public int getNum(){
			return num;
		}
		
		public Node getParent(){
			return parent;
		}
		
		public Node getChild(int n){
			return childArray[n];
		}
		
		// get item at index n
		public Dataitem getItem(int n){
			return itemArray[n];
		}
		
		public boolean isFull(){
			return (num==ORDER-1)?true:false;			
		}
		
		public boolean isLeaf(){
			return (childArray[0]==null)?true:false;
		}

		public int findItem(long key){
			for(int j=0; j<ORDER-1; j++){
				if(itemArray[j]==null){
					break;
				}
				else if(itemArray[j].data==key){
					return j;										
				}
			}
			return -1; 
		}
		
		public int insertItem(Dataitem item){
			// add new item
			num++;
			// key of new item
			long key1 = item.data;
			// start from the right
			for(int j=ORDER-2; j>=0; j--){
			// if item is null go left one cell
				if(itemArray[j]==null){
					continue;
				}
				else{
			// get item's key
					long key2= itemArray[j].data;
			// if item's key is bigger shift it to the right
					if(key1<key2){
						itemArray[j+1]=itemArray[j];
					}
					else{
			// insert new item and return index to the new item 
						itemArray[j+1]=item;
						return j+1;
					}
				}
			}
			// insert item
			itemArray[0]=item;
			return 0;
		}
		
		// remove largest item
		public Dataitem removeItem(){
			// save item
			Dataitem item = itemArray[num-1];
			// disconnect item
			itemArray[num-1]=null;
			// one less item
			num--;
			return item;
		}
		
		public void displayItem(){
			for(int j=0; j<num; j++){
				itemArray[j].display();
				System.out.println("/");
			}
		}
	}
		
	public int find(long key){
		Node current=root;
		int number;
		// found it
		while(true){
			if((number=current.findItem(key))!=-1){
				return number;
			}
			// can't find it
			else if(current.isLeaf()){
				return -1;
			}
			// search deeper in the tree 
			else{
				current=getNetChild(current, key);						
			}
		}
	}
	
	// insert an item
	public void insert(long value){
		Node current=root;
		Dataitem item = new Dataitem(value);
		while(true){
			// if the node is full
			if(current.isFull()){
				split(current);
			// back up
				current=current.getParent();
				current=getNetChild(current, value);
			}
			else if(current.isLeaf()) {
				break;
			}
			// go to the lower level
			else{
				current = getNetChild(current, value);
			}
		}
		/// insert new item
		current.insertItem(item);
	}
	
	public void split(Node thisNode){
		int index;
		Dataitem itemB, itemC;
		Node parent, child2, child3;
		// remove items from this node
		itemB=thisNode.removeItem();
		itemC=thisNode.removeItem();
		// remove children from this node
		child2=thisNode.disconnect(2);
		child3=thisNode.disconnect(3);
		// make new node
		Node right = new Node();
		
		// if this node is the root 
		if(thisNode==root){			
			root = new Node();
			// root is parent
			parent=root;
			// connect to parent
			root.connect(0, thisNode);
		}
		else{
			parent=thisNode.getParent();			
		}
		// itemB to parent
		index = parent.insertItem(itemB);
		// get total number of items
		int n = parent.getNum();
		// move parent's connections one child to the right
		for(int j=n-1; j>index; j--){
			Node temp = parent.disconnect(j);
			parent.connect(j+1, temp);			
		}
		
		// connect new right to parent
		parent.connect(index+1, right);
		// itemC to new right
		right.insertItem(itemC);
		// connect to 0 and 1 to new right 
		right.connect(0, child2);		
		right.connect(1, child3);
	}
	
	// get appropriate child of node during the search of value 
	public Node getNetChild(Node node, long value){
		int j;
		int n = node.getNum();
		for(j=0; j<n; j++){
			if(value<node.getItem(j).data){
				// return left child
				return node.getChild(j); 
			}
		}
		// return right child
		return node.getChild(j);
	}
	
	public void displayTree(){
		recursiveTree(root, 0, 0);
	}
	
	public void recursiveTree(Node node, int level, int number){
		// display the node
		System.out.println("Level: "+level+" Child number: "+number+" ");
		node.displayItem();
		int n = node.getNum();
		
		for(int j=0; j<n+1; j++){
			Node nextNode = node.getChild(j);
		// recursive function to display all nodes
			if(nextNode!=null){
				recursiveTree(nextNode, level+1, j);
			}
			else{
				return ;
			}
		}
	}
}


