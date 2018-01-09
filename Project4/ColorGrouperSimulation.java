/*
Filename: ColorGrouperSimulation.java
Author: Brandon Troisi
Date: 10/4/2016

*/

import java.util.Random;
import java.awt.Color;


public class ColorGrouperSimulation{
 	//Runs a simulation of ColorGrouper agents based on rules of such agents
 
 	
 	public static void main(String[] args) throws InterruptedException  {
 		//Uses command line arguments to determine size of grid and number of iterations in the simulation.
 		//Creates 3 color groupers, red, green, and blue  and places them at random locations
 		//Simulation runs from there
 		
 		int width = Integer.parseInt(args[0]);
 		int height = Integer.parseInt(args[1]);
 		int iter = Integer.parseInt(args[2]);
        
        Landscape scape = new Landscape(width,height);
        
        Random gen = new Random();
        
        for (int i = 0; i < 200; i++) {
           
           ColorGrouper a = new ColorGrouper((double)gen.nextInt(width),(double)gen.nextInt(height),Color.blue);
           scape.addAgent(a);
           ColorGrouper b = new ColorGrouper((double)gen.nextInt(width),(double)gen.nextInt(height),Color.green);
           scape.addAgent(b);
           ColorGrouper c = new ColorGrouper((double)gen.nextInt(width),(double)gen.nextInt(height),Color.red);
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