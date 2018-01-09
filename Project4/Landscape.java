/*
Filename: Landscape.java
Author: Brandon Troisi
Date: 10/4/2016

*/

import java.util.ArrayList;
import java.lang.Math;
import java.awt.Graphics; 
import java.util.Collections;

public class Landscape{
	//Provides landscape to draw agents on

	private int w;
	private int h;
	private LinkedList <Agent> alist; 
	
	
	public Landscape(int w, int h){
		//Constructor method initializes landscape with width w and height h
		//Creates new linked list of agents
		this.w=w;
		this.h=h;
		alist = new LinkedList <Agent>();
	}
	
	public int getHeight(){
		//Returns height of landscape
		return this.h;
	
	}
	
	public int getWidth(){
		//Returns width of landscape
		return this.w;
	
	}
	
	public void addAgent(Agent a){
		//Adds agent to list of agents
		this.alist.add(a);
	
	}
	
	public String toString(){
		//Returns list that indicates how many agents are in list of agents
		String s = "There are " + alist.size() + " agents in the landscape";
		return s;
		
		
	}
	
	public ArrayList<Agent> getNeighbors(double x0, double y0, double radius){
		//Returns list of Agents within radius distance of location (x0,y0)
		ArrayList<Agent> neighbors = new ArrayList<Agent>(); 
		for(Agent a: this.alist){
			if(radius*radius>=Math.pow((a.getX()-x0),2)-Math.pow((a.getY()-y0),2)){
				neighbors.add(a);
			}
		
		}
	
		return neighbors;
	}
	
	void draw(Graphics g){
		//draws all the agents
		for(Agent a: this.alist){
			a.draw(g);
		}
	}
	
	public void updateAgents(){
		//Updates state of each agent in random order
	
		ArrayList<Agent> list = this.alist.toArrayList();
		Collections.shuffle(list);
		for(int i=0; i<list.size(); i++){
			list.get(i).updateState(this);
		
		}
	
	
	}
	
	public static void main(String args[]){
	
		//Creates new agents at (2,3) and (3,2) on a landscape with height and width 5
		//Returns neighbors of the agents within the radius of 3
	
		Landscape scape = new Landscape(5,5);
		Agent a = new Agent(2,3);
		Agent b = new Agent(3,2);
		scape.addAgent(a);
		scape.addAgent(b);
		System.out.println(scape.toString());
		System.out.println(scape.getNeighbors(3.0,3.0,4.0));
			
		
	
	}
}