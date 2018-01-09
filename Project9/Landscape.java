/*
Filename: Landscape.java
Author: Brandon Troisi
Date: 10/11/2016

*/

import java.util.Random;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Landscape{
	//Represents landscape that holds stuff for HuntTheWumpus game

	private int rows;
	private int cols;
	private Vertex[][] grid;  
	private Hunter hunter; 
	private Wumpus wumpus; 
	private ArrayList<Agent> foreground;
	private ArrayList<Agent> background;
	
	
	public Landscape(int rows, int cols){
		//Constructor
		
		this.rows=rows;
		this.cols=cols;
		this.grid = new Vertex[this.rows][this.cols];
		this.hunter = new Hunter(0,0);
		this.wumpus = new Wumpus(4,4);
		this.foreground = new ArrayList<Agent>();
		this.background = new ArrayList<Agent>(); 
		
		
	}
	
	public int getRows(){
		//Returns rows of landscape
		return this.rows;
	
	}
	
	public int getCols(){
		//Returns cols of landscape
		return this.cols;
	
	}
	
	public Hunter getHunter(){
		//Returns reference to hunter in Landscape
		return this.hunter;
	}
	
	public Wumpus getWumpus(){
		//Returns reference to wumpus in Landscape
		return this.wumpus; 
	}
	
	
	public void addForegroundAgent(Agent f){
		//Adds foreground agents to landscape (represented by hunter and wumpus)
 		this.foreground.add(f);
 	}
 	
 	public void addBackGroundAgent(Agent b){
 		//Adds background agents to landscape (represented by Vertex objects)
 		this.background.add(b); 
 	}
 		
	
	public String toString(){
		//Returns string indicates rows and cols of landscape
		String s = "Dimensions of landscape: " + this.rows + " rows and "+ this.cols + " columns ";
		return s; 
	
	}
	
	
	public void draw(Graphics g, int gridScale){
 		//Draws all foreground and background agents
 		
 		for(Agent b: this.background){
 			b.draw(g, gridScale);
 		}
 		
 		for(Agent f: this.foreground){
 			f.draw(g,gridScale); 
 		}
 	}
 	
 	
 	
	public static void main(String args[]){
		//Creates new Landscape with 7 rows and 7 columns
		//Tests toString method
		//Prints reference to hunter
		
		Landscape scape = new Landscape(7,7);
		System.out.println(scape.toString());
		System.out.println(scape.getHunter());
		System.out.println(scape.getWumpus()); 
	
	}
	
}