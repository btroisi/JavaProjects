/*
Author: Brandon Troisi
Date: 11/29/16
File: Graph.java
*/

import java.util.ArrayList;



public class Graph{
	//Represents a graph

	private ArrayList<Vertex> verticies;
	
	public Graph(){
		//Constructor
		this.verticies = new ArrayList<Vertex>();
	}
	
	public int vertexCount(){
		//Returns size of array list of verticies in graph
		return this.verticies.size();
	}
	
	
	public void addEdge(Vertex v1,Vertex.Direction dir, Vertex v2){
		//Adds v1 and v2 to graph if not already in the graph
		//Connects v1 to v2 via direction dir
		if(verticies.contains(v1)==false){
			verticies.add(v1);
		}
		if(verticies.contains(v2)==false){
			verticies.add(v2);
		}
		v1.connect(v2,dir);
		v2.connect(v1,Vertex.opposite(dir)); 

	}
	
	public ArrayList<Vertex> getVerticies(){
		//Returns arraylist of vertex objects in graph
		return this.verticies; 
	}
	
	
	public void shortestPath(Vertex v0){
		//Uses Dijkstra's algorithm to find shortest distance from vertex v0
		//to all other vertex objects in the graph
		for(int i=0; i<this.verticies.size();i++){
			this.verticies.get(i).setMarked(false); 
			this.verticies.get(i).setCost(Integer.MAX_VALUE); 
			
		}
		
		PQHeap<Vertex> q = new PQHeap<Vertex>(new VertexComparator());
		v0.setCost(0);
		q.add(v0);
		
		while(q.size()!=0){
		
			Vertex v = q.remove(); 
			v.setMarked(true); 
			for(Vertex w: v.getNeighbors()){
				if(w.getMarked()== false && v.getCost()+1< w.getCost()){
					w.setCost(v.getCost() + 1);
					q.add(w);
				
				}
			
			}
		}
	
	}
	
	public static void main(String[] args){
		//Creates new graph and executes Dijkstra's algorithm for vertex v1 on graph
	
		Graph g = new Graph();
		Vertex v1 = new Vertex(0,0);
		Vertex v2= new Vertex(0,1);
		Vertex v3 = new Vertex(1,0);
		Vertex v4 = new Vertex(1,1);
		Vertex v5 = new Vertex(2,1);
		Vertex v6 = new Vertex(2,0);
		g.addEdge(v1, Vertex.Direction.NORTH, v2);
		g.addEdge(v1, Vertex.Direction.EAST, v3);
		g.addEdge(v3, Vertex.Direction.NORTH, v4);
		g.addEdge(v2, Vertex.Direction.EAST, v4);
		g.addEdge(v4, Vertex.Direction.EAST, v6);
		g.addEdge(v3, Vertex.Direction.EAST, v5);
		g.addEdge(v5, Vertex.Direction.NORTH, v6);
		
		v1.setCost(1);
		v2.setCost(5);
		v3.setCost(6);
		v4.setCost(7);
		v5.setCost(3);
		v6.setCost(9); 
		System.out.println("Before Dijkstra: ");
		for(Vertex v: g.verticies){
			System.out.println(v.getCost()); 	
		}	
		g.shortestPath(v1);
		System.out.println("After Dijkstra: ");
		for(Vertex v: g.verticies){
			System.out.println(v.getCost()); 
		}
		
		
	
	
	
	}
	
	

}