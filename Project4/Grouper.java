/*
Filename: Grouper.java
Author: Brandon Troisi
Date: 10/4/2016

*/

import java.awt.Graphics;
import java.util.Random;
import java.awt.Color;

public class Grouper extends Agent{
	//Creates groups of agents

	public Grouper(double x0, double y0){
		//Sets x and y position for groups of agents
		super(x0,y0);
	
	}
	
	public void draw(Graphics g){
		//draws agents as filled in circles of radius 5
		
		g.fillOval((int)this.getX()*10,(int)this.getY()*10,5,5);
		
		
	}
	
	
	public void updateState(Landscape scape){
		//Implements rules of agents such that if cell has more than 3 neighbors within radius of 3
		//The grouper should move +/- 5 with 1% chance
		//Otherwise, the grouper should move +/-5
		Random gen = new Random();
		
		if(scape.getNeighbors(this.getX(),this.getY(),3.0).size()>3){
			if(gen.nextFloat()<=0.01){
				double r = gen.nextDouble()*2*Math.PI;
				this.setX(this.getX() + (double)(5*Math.cos(r)));
				this.setY(this.getY() + (double)(5*Math.sin(r)));
		
			}
		}
		
		else{
		
			double r = gen.nextDouble()*2*Math.PI;
			this.setX(this.getX() + (double)(5*Math.cos(r)));
			this.setY(this.getY() + (double)(5*Math.sin(r)));
		
		}
	
	}
	
	public static void main(String[] args){
		//Creates new grouper at position (5.0,3.0)
		Grouper gr = new Grouper(5.0,3.0);
		System.out.println(gr.toString());
	
	
	}
	
}