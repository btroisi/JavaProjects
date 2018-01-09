/*
Filename: CategorizedGrouper.java
Author: Brandon Troisi
Date: 10/4/2016

*/

import java.util.Random;
import java.lang.Math;
import java.awt.Graphics;
import java.awt.Color; 

public class CategorizedGrouper extends Grouper{
	//Extends Grouper class, represents second agent based on integer categories


	private int cat;
	
	
	public CategorizedGrouper(double x0, double y0, int cat){
		//Calls parent constructor sets category
		super(x0,y0);
		this.cat=cat;
	
	}
	
	public int getCategory(){
		//Returns category value
		return this.cat;
	
	}
	
	public void draw(Graphics g){
		//draws agent as blue dot
		
		g.setColor(Color.blue);
		g.fillOval((int)this.getX()*10,(int)this.getY()*10,5,5);
		
		
	}
	
	
	public String toString(){
		//Returns string that indicates category of agent
		String s = Integer.toString(this.cat);
		return s;
	
	}
	
	public void updateState(Landscape scape){
		//If there are more neighbors that have the same category than a different category
		//Move +/- 5 with 1% chance
		//Otherwise move +/- 5
		
		Random gen = new Random();
		
		int diff =0;
		int same =0; 
		
		for(int i=0; i<scape.getNeighbors(this.getX(),this.getY(),3.0).size(); i++){
			if(scape.getNeighbors(this.getX(),this.getY(),3.0).get(i).getCategory() == (this.getCategory())){
				same++;
			}
			
			else{
				diff++;
			}
		}
			
		if(same>diff){
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

	public static void main(String args[]){
	
		CategorizedGrouper cg = new CategorizedGrouper(1,1,1);
		System.out.println(cg.getCategory());
		System.out.println(cg.toString());
		
	
	
	
	}






}