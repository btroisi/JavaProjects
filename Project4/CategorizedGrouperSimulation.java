/*
Filename: CategorizedGrouperSimulation.java
Author: Brandon Troisi
Date: 10/4/2016

*/

import java.util.Random;


public class CategorizedGrouperSimulation{
 	//Runs a simulation of CategorizedGrouper agent with given rules of Categorized grouper agent
 
 	
 	public static void main(String[] args) throws InterruptedException {
 		//Uses command line arguments to determine size of grid and number of iterations in the simulation.
 		//Creates 3 categories for agents  and places them at random locations in landscape
 		//Simulation runs from there with above conditions
 		
 		int width = Integer.parseInt(args[0]);
 		int height = Integer.parseInt(args[1]);
 		int iter = Integer.parseInt(args[2]);
        
        Landscape scape = new Landscape(width,height);
        
        Random gen = new Random();
        
        for (int i = 0; i < 200; i++) {
           
           CategorizedGrouper a = new CategorizedGrouper((double)gen.nextInt(width),(double)gen.nextInt(height),1);
           scape.addAgent(a);
           CategorizedGrouper b = new CategorizedGrouper((double)gen.nextInt(width),(double)gen.nextInt(height),2);
           scape.addAgent(b);
           CategorizedGrouper c = new CategorizedGrouper((double)gen.nextInt(width),(double)gen.nextInt(height),3);
           scape.addAgent(c);
        }

        LandscapeDisplay display = new LandscapeDisplay(scape, 4);

		

 		for(int i=0; i<iter; i++){
 		
            scape.updateAgents();
 			display.repaint();
 			Thread.sleep(250);

 		
 		
 		}
 	
		
 	}
 	
 	
 }