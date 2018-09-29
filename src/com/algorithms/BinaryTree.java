package com.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/* 
  Binary Tree is a recursive data structure where each node can have two children at most.
  Every node has a value that is greater than or equal to the node values in the left sub-tree, and less than or 
  equal to the node values in the right sub-tree.
*/

public class BinaryTree {
  Node root;

  private Node addRecursive(Node current, int value) {
    // we’ve reached a leaf node and we can insert the new node in that position
    if(current == null) {
      return new Node(value);
    }
    
    // if the new node’s value is lower than the current node’s, we go to the left child
    if(value < current.value) {
      current.left = addRecursive(current.left, value);
    }
    // if the new node’s value is greater than the current node’s, we go to the right child
    else if(value > current.value){
      current.right = addRecursive(current.right, value);
    }   
    else {
      return  current;
    }
    return current;
  }

  public boolean isEmpty() { 
    return root == null;
  }

  public int getSize() {
    return getSizeRecursive(root);
  }

  private int getSizeRecursive(Node current) {
    return current == null ? 0: getSizeRecursive(current.left) + 1 + getSizeRecursive(current.right);
  }

  public void add(int value) {
    root = addRecursive(root, value);
  }

  public BinaryTree createBinaryTree() {
    BinaryTree binaryTree = new BinaryTree();
    binaryTree.add(5);
    binaryTree.add(9);
    binaryTree.add(2);
    binaryTree.add(6);
    binaryTree.add(1);
    binaryTree.add(7);
    binaryTree.add(4);

    return binaryTree;
  }

  private boolean containsNodeRecursive(Node current, int value) {
    if(current == null) {
      return false;
    }

    if(value == current.value) {
      return true;
    }

    return value < current.value ? 
    containsNodeRecursive(current.left, value) : 
    containsNodeRecursive(current.right, value);
  }

  public boolean containsNode(int value) {
    return containsNodeRecursive(root, value);
  }
/*
  // verify that the tree really contains the inserted elements
  @Test
  public void BinaryTree_WhenAddingElements_ContainsThoseElements() {
    BinaryTree binaryTree = new BinaryTree();
    assertTrue(binaryTree.containsNode(5));
    assertTrue(binaryTree.containsNode(6));  
    assertFalse(binaryTree.containsNode(1));
  }
*/
  public void delete(int value) {
    root = deleteRecursive(root, value);
  }

  private Node deleteRecursive(Node current, int value) {
    if(current == null) {
      return null;
    }

    if(value == current.value) {
      // case 1: a node has no children
      if(current.right == null && current.left == null) {
        return null;
      }
    
      // case 2: a node has exactly one child
      if(current.left == null) {
        return current.right;
      }

      if(current.right == null) {
        return current.left;
      }
    
      // case 3: a node has two children
      // we assign the smallest value to the node to delete and after that, we’ll delete it from the right subtree
      int smallestValue = findSmallestValue(current.right);
      current.value = smallestValue;
      current.right = deleteRecursive(current.right, smallestValue);
      return current;      
    }
    current.right = deleteRecursive(current.right, value);
    return current;
  }

  // we find the smallest node of the node to be deleted’s right sub-tree
  private int findSmallestValue(Node root) {
    return root.left == null ? root.value: findSmallestValue(root.left);
  }
/*
  @Test
  public void BinaryTree_WhenDeleteElements_NotContainsThoseElements() {
    BinaryTree binaryTree = new BinaryTree();

    assertTrue(binaryTree.containsNode(9));
    binaryTree.delete(9);
    assertFalse(binaryTree.contains(9));
  }
*/
  /* 
  * Depth-first search is a type of traversal that goes deep as much as possible in every child before exploring the 
  * next sibling
  */
  
  // in-order traversal consists of first visiting the left sub-tree, then the root node, and finally the right sub-tree
  public void traverseInOrder(Node node) {
    if(node != null) {
      traverseInOrder(node.left);
      System.out.print(" " + node.value);
      traverseInOrder(node.right);
    }
  }

  // pre-order traversal visits first the root node, then the left subtree, and finally the right subtree
  public void traversePreOrder(Node node) {
    if(node !=null) {
      System.out.print(" " + node.value);
      traversePreOrder(node.left);
      traversePreOrder(node.right);
    }
  }

  // post-order traversal visits the left subtree, the right subtree, and the root node at the end
  public void traversePostOrder(Node node) {
    if(node != null) {
      traversePostOrder(node.left);
      traversePostOrder(node.right);
      System.out.print(" " + node.value);
    }
  }

  /* 
   * Breadth-first search is a type of traversal that visits all the nodes of a level before going to the next level.
   * we visit all the levels of the tree starting from the root, and from left to right.
   */

  public void traverseLevelOrder() {
    if(root == null) {
      return ;
    }

    Queue<Node> nodes = new LinkedList<>();
    nodes.add(root);

    while(!nodes.isEmpty()) {
      Node node = nodes.remove();
      System.out.println(" " + node.value);

      if(node.left != null) {
        nodes.add(node.left);
      }

      if(node.right != null) {
        nodes.add(node.right);
      }
    }
  }
}

class Node {
  int value;
  Node right, left;

  Node(int value) {
    this.value = value;
    right = null;
    left = null;
  }    
}
