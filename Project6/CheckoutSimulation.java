/*
Filename: CheckoutSimulation.java
Author: Brandon Troisi
Date: 10/25/2016
NOT COMPLETED YET
*/

import java.util.Random;

public class CheckoutSimulation{
	//Runs simulation of customers moving through checkout lines at store
	//Prints out average time customers were processed through line and standard devation.
	
	public static void main(String args[]) throws InterruptedException{
		Random gen = new Random();
		Landscape scape = new Landscape(400,400,100);
		int strat;
		
		if(args.length==0){
			//If length of args is 0, a random strategy for which customers will choose a line will be chosen
			System.out.println("A random strategy will be chosen for your customers");
			strat = gen.nextInt(3);
			System.out.println("Strategy chosen:"+strat);
		}
		else{
			//User input is used to determine strategy fo which customer chooses a line 
		strat = Integer.parseInt(args[0]);
			
		}
		
		if(strat == 0){
			//If the strategy is 0, the customers will be randomly placed into lines
			System.out.println("Your customers will be randomly placed into lines");
		}
		else if(strat ==1){
			//If the strategy is 1, the customers will choose between shorter of two random lines
			System.out.println("Your customers will be placed into two random lines, whichever is shorter");
		}
		else{
			//Otherwise, if strategy is 2 the customers will choose the shortest line
			System.out.println("Your customers will choose the shortest line");
		}
		
		Spawner s = new Spawner(50,50,strat,gen.nextInt(5));
		
		
		LandscapeDisplay display = new LandscapeDisplay(scape,5);
		
		while(true){
			//Customers spawned into landscape and simulation is carried on infinitely 
			//Prints average time customers spent in line and the standard deviation. 
			s.updateState(scape);
			scape.updateState();
			display.update();
			Thread.sleep(1000);	
			
			System.out.println("Average time at checkout: "+ scape.average());
 			System.out.println("Standard deviation: " + scape.standardDeviation());
		
		
 		}
 		
 		
 	}
}