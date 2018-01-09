/*
Filename: Agent.java
Author: Brandon Troisi
Date: 10/11/2016

*/

import java.awt. Graphics;
import java.awt.Color;

public class Agent{
	//Holds row and col index for an agent

	private int r;
	private int c;
	
	public Agent(int r, int c){
		//Constructor method sets row and column for agent
		
		this.c=c;
		this.r=r;
	}
	
	public int getRow(){
		//Returns row
		return this.r;
	
	}
	
	public int getCol(){
		//Returns column
		return this.c;
	
	}
	
	public void setRow(int newRow){
		//Sets row
		this.r=newRow;
	
	}
	
	public void setCol(int newCol){
		//Sets column
		this.c=newCol;
	
	}
	
	public String toString(){
		//Returns string that tells you row and column index of agent
		String s="Col/Row indicies: ("+this.getRow()+","+this.getCol()+")";
		return s;
	
	}
	
	
	
	
	public void draw(Graphics g){}
		//Does nothing, but needed to draw agents
	
	public static void main(String args[]){
		//Creates new agent at position (1,1)
		//Then sets row and col position of agent to (9,6)
	
		Agent a = new Agent(1,1);
		System.out.println(a.toString());
		a.setCol(6);
		a.setRow(9);
		System.out.println(a.toString());
	
	}
	
	
}
	
	
	



