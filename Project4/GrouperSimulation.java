/*
Filename: GrouperSimulaton.java
Author: Brandon Troisi
Date: 10/4/2016

*/

import java.util.Random;

public class GrouperSimulation{
 	//Runs a simulation of the game of life based on the rules created in the Cell and Landscape classes
 
 	public static void main(String[] args) throws InterruptedException {
 		//Uses command line arguments to determine size of grid and number of iterations in the simulation.
 		//Creates 200 grouper agents at random spots and runs simulation from there
 		
 		int width = Integer.parseInt(args[0]);
 		int height = Integer.parseInt(args[1]);
 		int iter = Integer.parseInt(args[2]);
        
        Landscape scape = new Landscape(width,height);
        
        Random rando = new Random();
        
        for (int i = 0; i < 200; i++) {
           
           Grouper a = new Grouper((double)rando.nextInt(width),(double)rando.nextInt(height));
           scape.addAgent(a);
        }

        LandscapeDisplay display = new LandscapeDisplay(scape, 4);

		

 		for(int i=0; i<iter; i++){
 		
            scape.updateAgents();
 			display.repaint();
 			Thread.sleep(250);

 		
 		
 		}
 	
		
 	}
 	
 	
 }