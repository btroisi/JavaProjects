/*
Filename: Simulation.java
Author: Brandon Troisi
Date: 10/4/2016

*/

import java.awt.Graphics;
import java.util.Iterator;

public class Simulation{
	//Creates simulation for gatherer to consume mushrooms in landscape


	public void testGrowthPatches() throws InterruptedException{
		//Creates 40x50 landscape, with 10 growth patches and 10 path verticies
	
		
		Landscape scape = new Landscape(40,50,10,10);
		LandscapeDisplay display = new LandscapeDisplay(scape,10);
		
		display.repaint();
		
		scape.growMushrooms(1000);
		int j=0;
		for(int i=0; i<10; i++){
			//Gatherer traverses path 10 times
		
			Iterator<PathVertex> itr = scape.getPathIterator();
			Iterator<PathVertex> bitr = scape.getPathBackwardIterator();
			
		
			while(itr.hasNext()){
				//Traverses gatherer on path forward 
				//Mushrooms grow based on rules defined in growMushrooms method in landscape
				//Updates gather's location in simulation
			
				scape.growMushrooms(100);
				scape.getGatherer().updateState(itr.next(), scape);
				display.repaint();
				display.saveImage("data/life_frame_" + String.format("%03d",j) + ".png");
				j++;
				
				Thread.sleep(100);
				
				
			
			}
			
			
			while(bitr.hasNext()){
				//Traverses gatherer on path backward
				//Mushrooms grow based on rules defined in growMushrooms method in landscape
				//Updates gatherer's location in simulation
			
				scape.growMushrooms(100);
				scape.getGatherer().updateState(bitr.next(), scape);
				display.repaint();
				display.saveImage("data/life_frame_" + String.format("%03d",j) + ".png");
				j++;
				Thread.sleep(100);
				
			
			}
			
			
			
		}
		
		System.out.println("Number of mushrooms consumed: " + scape.getGatherer().getNumMushroomsEaten());
					
	}

	public static void main(String args[]) throws InterruptedException{
	
		//Runs simulation
	
		Simulation sim = new Simulation();
		sim.testGrowthPatches();
	
	
	}


}