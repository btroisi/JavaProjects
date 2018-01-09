/**
 * File: LifeSimulation.java
 * Author: Brandon Troisi
 * Date: 09/20/2016
 */
 
 import java.util.Random;
 import java.awt.Graphics;
 import java.util.ArrayList;
 
 public class LifeSimulation{
 	//Runs a simulation of the game of life based on the rules created in the Cell and Landscape classes
 
 	public static void main(String[] args) throws InterruptedException {
 		//Uses command line arguments to determine size of grid and number of generations in the simulation.
 		//Uses random initial conditions and runs simulation from there
 		
 		int r = Integer.parseInt(args[0]);
 		int c = Integer.parseInt(args[1]);
 		int step = Integer.parseInt(args[2]);
        
        Landscape lscape = new Landscape(r,c);
        Random gen = new Random();
        double density = 0.3;
        for (int i = 0; i < lscape.getRows(); i++) {
            for (int j = 0; j < lscape.getCols(); j++ ) { 
                lscape.getCell( i, j ).setAlive( gen.nextDouble() <= density );
            }
        }

        LandscapeDisplay display = new LandscapeDisplay(lscape, 4);

		

 		for(int i=0; i<step; i++){
 		
 			
 			lscape.advance();
 			display.repaint();
 			Thread.sleep(250);

 		
 		
 		}
 	
		
 	}
 	
 	
 }