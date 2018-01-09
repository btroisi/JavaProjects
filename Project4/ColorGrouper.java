/*
Filename: ColorGrouperSimulation.java
Author: Brandon Troisi
Date: 10/4/2016

*/

import java.util.Random;
import java.lang.Math;
import java.awt.Graphics;
import java.awt.Color;

public class ColorGrouper extends Grouper{
	//Extends grouper implements 3rd type of agent that is based on colorgroupers
	

	private Color color;
	
	public ColorGrouper(double x0, double y0, Color color){
		//Calls parent class and sets color field
		super(x0,y0);
		this.color=color;
		
	}
	
	public Color getColor(){
		//Returns color of agent
		return this.color;
	}
	
	public void draw(Graphics g){
		//Draws agents as dots of the color of agent
		
		g.setColor(this.color);
		g.fillOval((int)this.getX()*10,(int)this.getY()*10,5,5);
		
		
	}
	
	public void updateState(Landscape scape){
		//Checks to see how many red, green, and blue neighbors within a radius 2 each grouper has
		//If there are more green than red, the cell moves +/-7 with a 50% chance
		//If there are more blue than red, cell moves up 10 and to the right 10 with a 10% chance
		//Otherwise, cell moves 5 to the right and 5 up
		
		Random gen = new Random();
		
		int red =0;
		int green =0; 
		int blue =0; 
		
		for(int i=0; i<scape.getNeighbors(this.getX(),this.getY(),2.0).size(); i++){
			if(scape.getNeighbors(this.getX(),this.getY(),2.0).get(i).getColor() == Color.red){
				red++;
			}
			
			if(scape.getNeighbors(this.getX(),this.getY(),2.0).get(i).getColor() == Color.green){
				green++;
			}
			else{
				blue++;
			}
		}
			
		if(green>red){
			if(gen.nextFloat()<=0.5){
				double r = gen.nextDouble()*2*Math.PI;
				this.setX(this.getX() + (double)(7*Math.cos(r)));
				this.setY(this.getY() + (double)(7*Math.sin(r)));
		
			}
		}
		
		if(blue>red){
			if(gen.nextFloat()<=0.1){
				this.setX(this.getX() + 10);
				this.setY(this.getY() + 10);
			}
		}
		else{
		
			
			this.setX(this.getX() + 5);
			this.setY(this.getY() + 5);
		
		
	
		}
		
	}
	
	
}




















