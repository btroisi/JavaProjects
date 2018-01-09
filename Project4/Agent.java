/*
Filename: Agent.java
Author: Brandon Troisi
Date: 10/4/2016

*/

import java.awt. Graphics;
import java.awt.Color;

public class Agent{
	//Holds x and y position for an agent

	private double x0;
	private double y0;
	
	public Agent(double x0, double y0){
		//Constructor method sets x and y position for agent
		
		this.x0=x0;
		this.y0=y0;
	}
	
	public double getX(){
		//Returns x position
		return this.x0;
	
	}
	
	public double getY(){
		//Returns y position
		return this.y0;
	
	}
	
	public void setX(double newX){
		//Sets x position
		this.x0=newX;
	
	}
	
	public void setY(double newY){
		//Sets y position
		this.y0=newY;
	
	}
	
	public String toString(){
		//Returns string that tells you x and y position of agent
		String s="Agent Position: ("+this.getX()+","+this.getY()+")";
		return s;
	
	}
	
	public int getCategory(){
		//Returns category of agent
		return 0;
	}
	
	public Color getColor(){
		//Returns color of agent 
		return Color.black;
	}
	
	public boolean getFilled(){
		//Returns if agent is filled or not
		return false;
	}
	
	public void updateState(Landscape scape){}
		//Does nothing, but needed to update the state of agent
	
	public void draw(Graphics g){}
		//Does nothing, but needed to draw agents
	
	public static void main(String args[]){
		//Creates new agent at position (1.0,1,0)
		//Then sets x and y position of agent to (5.9,6.9)
	
		Agent a = new Agent(1.0,1.0);
		System.out.println(a.toString());
		a.setX(5.9);
		a.setY(6.9);
		System.out.println(a.toString());
	
	}
	
	
}
	
	
	



