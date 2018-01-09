/*
Filename: FilledGrouperSimulaton.java
Author: Brandon Troisi
Date: 10/4/2016

*/

import java.util.Random; 

public class FilledGrouperSimulation{
 	///Runs a simulation of FilledGrouper agents based on rules of such agents
 	
 	public static void main(String[] args) throws InterruptedException {
 		//Uses command line arguments to determine size of landscape and number of iterations in the simulation.
 		//Creates filled and unfilled grouper agents, places them in random location on landscape
 		//Simulation is run baseed on these random initial conditions stated above
 		
 		int width = Integer.parseInt(args[0]);
 		int height = Integer.parseInt(args[1]);
 		int iter = Integer.parseInt(args[2]);
        
        Landscape scape = new Landscape(width,height);
        
        Random gen = new Random();
        
        for (int i = 0; i < 200; i++) {
           
           FilledGrouper t = new FilledGrouper((double)gen.nextInt(width),(double)gen.nextInt(height),true);
           scape.addAgent(t);
           FilledGrouper f = new FilledGrouper((double)gen.nextInt(width),(double)gen.nextInt(height),false);
           scape.addAgent(f);
           
        }

        LandscapeDisplay display = new LandscapeDisplay(scape, 4);

		

 		for(int i=0; i<iter; i++){
 		
            scape.updateAgents();
 			display.repaint();
 			Thread.sleep(250);
 			
 			

 		
 		
 		}
 	
		
 	}
 	
 	
 }
