/*
Filename: CommandLineSim.java
Author: Brandon Troisi
Date: 10/4/2016

*/

import java.util.Iterator;
import java.awt.Graphics;

public class CommandLineSim{

	public static void main(String args[]) throws InterruptedException{
		//Creates rowxcol landscape with numGrowthPatches growth patches and numPathVerticies path vertices
		//All based off command line parameters
	
		if(args.length<4){
			//If user does not input values correctly, print statement tells user what they should input
		
			System.out.println("Please input row, col, numGrowthPatches, and numPathVerticies");
			return;
		}
		
		int r = Integer.parseInt(args[0]);
 		int c = Integer.parseInt(args[1]);
 		int numGrowthPatches = Integer.parseInt(args[2]);
 		int numPathVerticies = Integer.parseInt(args[3]);
 		
	
		Landscape scape = new Landscape(r,c,numGrowthPatches,numPathVerticies);
		LandscapeDisplay display = new LandscapeDisplay(scape,10);
	
		display.repaint();
	
		scape.growMushrooms(10000);
		int j=0;
	
		for(int i=0; i<10; i++){
			//Gatherer traverses path 10 times
				
			Iterator<PathVertex> itr = scape.getPathIterator();
			Iterator<PathVertex> bitr = scape.getPathBackwardIterator();
	
			while(itr.hasNext()){
				//Traverses gatherer on path backward 
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
				//Updates gather's location in simulation
		
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
}
		
		











