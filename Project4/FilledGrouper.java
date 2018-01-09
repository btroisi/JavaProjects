/*
Filename: FilledGrouper.java
Author: Brandon Troisi
Date: 10/4/2016

*/

import java.util.Random;
import java.awt.Graphics;
import java.awt.Color;

public class FilledGrouper extends Grouper{
	//Extension of Grouper that represents filled and unfilled grouper agents

	private boolean fill;
	
	public FilledGrouper(double x0, double y0, boolean fill){
		//Constructor method calls parent constructor
		//Set fill state
		super(x0,y0);
		this.fill=fill;
	
	}
	
	public boolean getFilled(){
		//Returns fill state
		
		return this.fill;
	
	}
	
	public void draw(Graphics g){
		//If fill is true agent is filled in green
		//If fill is false agent is drawn with blue circle that is not filled
		if(this.fill==true){
			g.setColor(Color.green);
			g.fillOval((int)this.getX()*10,(int)this.getY()*10,5,5);
		
		}
		
		else{
			g.setColor(Color.blue);
			g.drawOval((int)this.getX()*10,(int)this.getY()*10,5,5);
		
		}
	}
		
	public void updateState(Landscape scape){	
		//Checks to see how many neighbors are filled and unfilled
		//If number neighbors that are filled are greater than the neighbors that are not filled
		//Moves cell right and down random integer between 0 and 10 with 40% chance
		//Otherwise cell moves +/-5
		
		Random gen = new Random();
		
		int filled=0;
		int notfilled=0; 
		
		for(int i=0; i<scape.getNeighbors(this.getX(),this.getY(),2.0).size(); i++){
			if(scape.getNeighbors(this.getX(),this.getY(),2.0).get(i).getFilled() == true){
				filled++;
			}
			
			else if(scape.getNeighbors(this.getX(),this.getY(),2.0).get(i).getFilled() == false){
				notfilled++;
			
			}
		}
			
		if(filled>notfilled){
			if(gen.nextFloat()<=0.4){
				int rand = gen.nextInt(10);
				this.setX(this.getX() + rand );
				this.setY(this.getY() - rand);
		
			}
		}
		
		else{
		
			double r = gen.nextDouble()*2*Math.PI;
			this.setX(this.getX() + (double)(5*Math.cos(r)));
			this.setY(this.getY() + (double)(5*Math.sin(r)));
	
		}
		
	}


}
