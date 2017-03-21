package com.algorithms;

import java.util.ArrayList;
import java.util.List;

public class DijkstraShortestPath{
	
	class Edge{
		private int fromNodeIndex;
		private int toNodeIndex;
		private int length;
		
		public Edge(int fromNodeIndex, int toNodeIndex, int length) {
			this.fromNodeIndex = fromNodeIndex;
			this.toNodeIndex = toNodeIndex;
			this.length = length;
		}
		
		public int getFromNodeIndex() {
			return fromNodeIndex;
		}
		
		public void setFromNodeIndex(int fromNodeIndex) {
			this.fromNodeIndex = fromNodeIndex;
		}
		
		public int getToNodeIndex() {
			return toNodeIndex;
		}
		
		public void setToNodeIndex(int toNodeIndex) {
			this.toNodeIndex = toNodeIndex;
		}
		
		public int getLength() {
			return length;
		}
		
		public void setLength(int length) {
			this.length = length;
		}
		
		// get index of neighboring node
		public int getNeighbourIndex(int index) {
			if (this.fromNodeIndex == index) {
				return this.toNodeIndex;
			} 
			else {
				return this.fromNodeIndex;
			}
		}
	}
	
	class Node{
		public int dist = Integer.MAX_VALUE;
		public boolean visited = false;
		private List<Edge> edges = new ArrayList<Edge>(); 
		
		public int getDist() {
			return dist;
		}
		
		public void setDist(int dist) {
			this.dist = dist;
		}
		
		public boolean isVisited() {
			return visited;
		}
		
		public void setVisited(boolean visited) {
			this.visited = visited;
		}
		
		public List<Edge> getEdges() {
			return edges;
		}
		
		public void setEdges(List<Edge> edges) {
			this.edges = edges;
		}
	}
	
	class Graph{
		private Node[] nodes;
		private int numNodes;
		private Edge[] edges;
		private int numEdges;		
		
		public Graph(Edge[] edges) {
			this.edges = edges;
			this.numNodes = calculateNodes(edges); 
			this.nodes = new Node[this.numNodes];
			for(int j=0; j<numNodes; j++){
				this.nodes[j] = new Node();
			}
			
			this.numEdges = edges.length;
			for(int edge=0; edge < this.numEdges; edge++){
				this.nodes[edges[edge].getFromNodeIndex()].getEdges().add(edges[edge]);
				this.nodes[edges[edge].getToNodeIndex()].getEdges().add(edges[edge]);
			}
		}
		
		public Node[] getNodes() {
			return nodes;
		}
		
		public int getNumEdges() {
			return numEdges;
		}
		
		public Edge[] getEdges() {
			return edges;
		}
		
		public int getNumNodes() {
			return numNodes;
		}
		
		// calculate number of nodes in array of edges
		public int calculateNodes(Edge[] edges){
			int nodes = 0;
			for (Edge edge : edges) {
				if(edge.getToNodeIndex() > nodes){
					nodes = edge.getToNodeIndex(); 
				}
				if(edge.getFromNodeIndex() > nodes){
					nodes = edge.getFromNodeIndex();
				}				
			}
			nodes++;
			return nodes;
		}
		
		// Dijkstra's algorithm to calculate shortest distance from source to all nodes
		public void calculateShortestDistance(){
			// node 0 is source
			this.nodes[0].setDist(0);
			int next = 0;
			
			for(int j=0; j<this.nodes.length; j++){
				// edges joined to current node
				List<Edge> currentEdges = this.nodes[next].getEdges();
				for(int joinedEdge=0; joinedEdge< currentEdges.size(); joinedEdge++){
					// get joined edge neighbor of current node
					int neighborIndex = currentEdges.get(joinedEdge).getNeighbourIndex(next);
					// for unvisited neighbor
					if(!this.nodes[neighborIndex].isVisited()){
						// get tentative distance for neighbor
						int dist = this.nodes[next].getDist() + currentEdges.get(joinedEdge).getLength();
						// if tentative distance is less than stored distance then overwrite
						if(dist < nodes[neighborIndex].getDist()){
							nodes[neighborIndex].setDist(dist);
						}						
					}
				}
				// all neighbors are checked  
				nodes[next].setVisited(true);
				// next node to visit must be the one with shortest distance
				next = getShortestDistance();
			}		
		}
		
		private int getShortestDistance(){
			int storedIndex = 0;
			int storedDist = Integer.MAX_VALUE;
			for(int j = 0; j < this.nodes.length; j++){
				int currentDist = this.nodes[j].getDist();
				if(this.nodes[j].isVisited() && currentDist < storedDist){
					storedDist = currentDist;
					storedIndex = j;
				}				
			}			
			return storedIndex;
		}		
		
		public void displayGraph(){
			for(int j = 0; j < this.nodes.length; j++){
				System.out.println("Number of nodes = " + this.numNodes +"\nNumber of edges = " 
			+ this.numEdges+"\nThe shortest distance from node 0 to node " + j + " is " 
			+ nodes[j].getDist()+" ");
			}
		}
	}
}
