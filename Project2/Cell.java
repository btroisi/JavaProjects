/**
 * File: Cell.java
 * Author: Brandon Troisi
 * Date: 09/20/2016
 */
 
 import java.awt.Graphics;
 import java.awt.Color;
 import java.util.ArrayList;
 
 public class Cell{
 	//Represents one square of regular grid and stores cell's alive state
 	//
 
 	boolean alive;
 	
 	public Cell(){
 		//By default Cell is dead

 		this.alive=false;
 	}
 	
 	public Cell( boolean alive ){
 		this.alive=alive;
 	
 	}
 	
 	public boolean getAlive(){
 		//Returns cell's alive state
 		return alive;
 	
 	}
 	
 	public void setAlive( boolean alive ){
 		//Sets cell's alive state
 		this.alive=alive;
 	
 	}
 	
 	public String toString(){
 		//Returns string + if cell is alive, returns string - if cell is dead
 		if(alive==true){
 			return "+";
 		}
 		
 		else{
 			return "-";
 			
 		}
 	
 	}
 	
 	public void draw( Graphics g, int x, int y, int scale){
 		//Draws green square if cell is alive, draws red square if cell is dead
 		if (this.getAlive()) {
			g.setColor( Color.green );
 		}	
 		else {
			g.setColor( Color.red );
 		}
 		g.fillRect(x,y,scale,scale);
 	
 	}
 	
 	public void updateState( ArrayList<Cell> neighbors){
 		//Updates cell's alive state in next generation, given its neighbors current alive states
 		//If a live cell has 2 or 3 live neighbors, the cell is alive for the next generation
 		//If a dead cell has 3 live neighbors, the cell is alive for the next generation
 		//Otherwise, the cell is dead for the next generation 
		
 		if( alive==true && (neighbors.size()==2 || neighbors.size()==3) ){
 			this.setAlive(true);
 			
 		}
 		
 		else if ( alive == false && neighbors.size()==3 ) {
 			
 			this.alive = true;
 		}
		
  		else{
  			
 			this.setAlive(false);
 		}

 		
 	
 	}
 	
 	public static void main(String[] args){
 		//Creates new cell object and prints whether cell object is alive with boolean and toString method
 		
 	
 		Cell c = new Cell();
 		System.out.println(c.getAlive());
 		System.out.println(c.toString());
 		c.setAlive(c.alive);
 		System.out.println(c.getAlive());
 		System.out.println(c.toString());
 		
 		
 		
 		
 	
 	}
 	
 	
 }