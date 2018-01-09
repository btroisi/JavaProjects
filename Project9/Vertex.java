/*
Author: Brandon Troisi
Date: 11/29/16
File: Vertex.java
*/

import java.util.HashMap;
import java.util.Comparator;
import java.util.ArrayList; 
import java.util.HashMap;
import java.util.Collection; 
import java.awt.Color;
import java.awt.Graphics;
 
public class Vertex extends Agent{
	//Represents a vertex in a graph

	public enum Direction{NORTH, SOUTH, EAST, WEST, NONE}//Enumerated type represents direction
	private HashMap<Direction,Vertex> edges; 
	private int cost;
	private boolean marked; 
	private Comparator comp; 
	private boolean visible; 

	public Vertex(int row, int col){
		//Constructor
		super(row,col);
		this.comp = new VertexComparator();
		this.edges = new HashMap<Direction, Vertex>();
		this.cost=0;
		this.marked=false;
		this.visible = false; 
	}
	
	public boolean getVisible(){
		//Returns if vertex is visible
		return this.visible;
	}
	
	public void setVisible(boolean v){
		//Sets vertex's visible state to v
		this.visible = v; 
	}
	
	public int getCost(){
		//Returns cost
		return this.cost;
	}
	
	public void setCost(int c){
		//Sets cost to c
		this.cost = c;
	}
	
	public boolean getMarked(){
		//Returns if vertex has been marked
		return this.marked; 
	}
	
	public void setMarked(boolean mark){
		//Sets marked to mark
		this.marked = mark; 
	}
	
	
	public static Direction opposite(Direction d){
		//Returns opposite direction as d
		if(d == Direction.NORTH){
			return Direction.SOUTH;
		}
		else if(d == Direction.SOUTH){
			return Direction.NORTH;
		}
		
		else if(d == Direction.EAST){
			return Direction.WEST; 
		}
		
		else{
			return Direction.EAST; 
		}
	
	}
	
	public void connect(Vertex other, Direction dir){
		//Connects vertex to vertex other in direction dir
		this.edges.put(dir,other);
	}
	
	public Vertex getNeighbor(Direction dir){
		//Returns adjacent vertex in direction dir
		return this.edges.get(dir);
	}
	
	public Collection<Vertex> getNeighbors(){
		//Returns collection of all of the neighbors of a vertex
		return this.edges.values();
	}
	
	public String toString(){
		//Returns string indicates number of neighbors vertex has, cost of vertex
		//and if vertex has been marked
		String s = "Number of neighbors: " + this.getNeighbors().size();
		s+= " Cost: " + this.cost;
		s+= " Marked: " + this.marked; 
		return s; 
	
	}
	
	public void draw(Graphics g, int gridScale){
		//Draws a vertex
		if(!this.visible){
			return;
		}
		int xpos = this.getCol()*gridScale;
		int ypos = this.getRow()*gridScale;
		int border = 2;
		int half = gridScale/2;
		int eighth = gridScale/8;
		int sixteenth = gridScale/16;
		
		//draw rectangle for walls of cave
		
		if(this.cost<=2){ 
			//Wumpus is nearby 
			g.setColor(Color.red);
		}
		else{
			//Wumpus is not nearby
			g.setColor(Color.blue);
		}
		
		g.drawRect(xpos + border, ypos + border, gridScale-2*border, gridScale-2*border);
		
		//draw doorways as boxes
		
		g.setColor(Color.black);
		if (this.edges.containsKey(Direction.NORTH)){
            g.fillRect(xpos + half - sixteenth, ypos, eighth, eighth + sixteenth);
        }
        if (this.edges.containsKey(Direction.SOUTH)){
            g.fillRect(xpos + half - sixteenth, ypos + gridScale - (eighth + sixteenth), eighth, eighth + sixteenth);
        }
        if (this.edges.containsKey(Direction.WEST)){
            g.fillRect(xpos, ypos + half - sixteenth, eighth + sixteenth, eighth);
        }
        if (this.edges.containsKey(Direction.EAST)){
            g.fillRect(xpos + gridScale - (eighth + sixteenth), ypos + half - sixteenth, eighth + sixteenth, eighth);
		}
	
	}
	
	public static void main(String args[]){
		//Creates two vertex objects, connects them in the NORTH direction
		//Sets cost of v1 to 9 and v2 to 5
		//Prints opposite method 
		//Prints toString method of v1 and v2
		Vertex v1 = new Vertex(1,1);
		Vertex v2 = new Vertex(2,1);
		v1.connect(v2,Direction.NORTH);
		v1.setCost(9);
		v2.setCost(5);
		System.out.println("Opposite of WEST is: " + v1.opposite(Direction.WEST));
		System.out.println(v1.toString());
		System.out.println(v2.toString());  
		
		
	
	}
}

class VertexComparator implements Comparator<Vertex>{
	//Compares costs of 2 vertex objects
	public int compare(Vertex v1, Vertex v2){
		//Returns difference between cost of Vertex v1 and Vertex v2
		return v1.getCost()-v2.getCost();
	}
}
