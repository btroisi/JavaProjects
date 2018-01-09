/**
 * File: LifeSimulationExt.java
 * Author: Brandon Troisi
 * Date: 09/20/2016
 */
 
 import java.util.Random;
 import java.awt.Graphics;
 import java.util.ArrayList;
 
 public class LifeSimulationext{
    /*
    Creates simulation of game of life using the initial conditions of 6 gliders starting
    at (2,2), (7,5), (12,9), (2,8), (7,11), and (12,15). Please google the initial 
    shape of the glider in the game of life to see what it is suppose to look like.
    */
    
    
   
 	
 
 	public static void createGlider(int i,int j, Landscape scape){
 	    //Creates glider objects that look like its initial state on google.
 	
 		scape.getCell(i,j).setAlive(true);
        scape.getCell(i-1,j-1).setAlive(true);
        scape.getCell(i-1,j+1).setAlive(true);
        scape.getCell(i,j+1).setAlive(true);
        scape.getCell(i+1,j).setAlive(true);	
 	
 	}
 
 	public static void main(String[] args) throws InterruptedException {
 	    //Creates 6 gliders at (2,2), (7,5), (12,9), (2,8), (7,11), and (12,15) 
 	
 		Landscape scape = new Landscape(30,30);
 		scape.reset();
        LifeSimulationext.createGlider(2,2,scape);
        LifeSimulationext.createGlider(7,5,scape);
        LifeSimulationext.createGlider(12,9,scape);
        LifeSimulationext.createGlider(2,8,scape);
        LifeSimulationext.createGlider(7,11,scape);
        LifeSimulationext.createGlider(12,15,scape);
        
       
        LandscapeDisplay display = new LandscapeDisplay(scape, 10);
        

 		for(int i=0; i<50; i++){
 			//Goes through 50 generations so that the gliders move from the top left corner
 			//to the bottom right corner of the page
 		
 			
 			scape.advance();
 			display.repaint();
 			Thread.sleep(250);
 			
 		
 		}
 	
		
 	}
 	
 	
 }