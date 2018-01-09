/*
Filename: Gatherer.java
Author: Brandon Troisi
Date: 10/11/2016

*/

import java.awt.Graphics;
import java.awt.Color;
import java.lang.Math;


public class Gatherer extends Agent{
	//Represents gatherer that consumes mushrooms based on certain rules

	private int r;
	private int c; 
	private int xpos;
	private int ypos;
	private int mushroomseaten=0;
	

	public Gatherer(int r, int c){
		//Constructor
		
		super(r,c);

	}
	
	public void draw(Graphics g, int gridScale){
		//Draws gatherer
		g.setColor(Color.red);
		xpos=this.getCol()*gridScale;
		ypos=this.getRow()*gridScale;
		g.fillRect(xpos,ypos,gridScale,gridScale);
		
	
	}
	
	public int updateState( PathVertex v, Landscape scape ) {
		//Gatherer keeps track of biggest mushroom in 7x7 grid, where gatherer in center of grid
		//Then gatherer, along with path vertex, moves to largest mushroom within this grid to consume it
		//Keeps track of how many mushrooms gatherer has consumed
		
		
		int row = v.getRow();
		int col = v.getCol();
		int biggest_mushroom = 0;
    	int biggest_ridx = row;
    	int biggest_cidx = col;
    	
    	 
       
       
        for(int i=Math.max(0,row-3); i< Math.min(scape.getRows(),row+3);i++){
 			for(int j=Math.max(0,col-3); j< Math.min(scape.getCols(),col+3);j++){
 				
 				if(scape.getMushroom(i,j).getSize()>biggest_mushroom){
 				
					biggest_mushroom = scape.getMushroom(i,j).getSize(); 				
 					biggest_ridx=scape.getMushroom(i,j).getRow();
 					biggest_cidx=scape.getMushroom(i,j).getCol();
 					scape.getMushroom(i,j).shrink();
 					mushroomseaten++;
 				}
 				
 				
 				
 			}
 		
 		}
       
       	v.setRow(biggest_ridx);
       	v.setCol(biggest_cidx);
        this.setRow(biggest_ridx );
        this.setCol( biggest_cidx );
        return mushroomseaten;
        
    
    	
    
    }
    
    public int getNumMushroomsEaten(){
    	//Returns number of mushrooms gatherer has consumed
    	return mushroomseaten;
    
    }
    
	

}