/*
Filename: Agent.java
Author: Brandon Troisi
Date: 11/29/2016

*/

import java.awt.Graphics; 
public class Agent{
	//Holds row and col index for an agent

	private int row;
	private int col;
	
	public Agent(int row, int col){
		//Constructor method sets row and column for agent
		
		this.col=col;
		this.row=row;
	}
	
	public int getRow(){
		//Returns row
		return this.row;
	
	}
	
	public int getCol(){
		//Returns column
		return this.col;
	
	}
	
	public void setRow(int newRow){
		//Sets row
		this.row=newRow;
	
	}
	
	public void setCol(int newCol){
		//Sets column
		this.col=newCol;
	
	}
	
	public String toString(){
		//Returns string that tells you row and column index of agent
		String s="Row/Col indicies: ("+this.getRow()+","+this.getCol()+")";
		return s;
	
	}
	
	
	
	
	public void draw(Graphics g, int gridScale){}
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
	
	
	