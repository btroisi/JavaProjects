/*
Filename: Landscape.java
Author: Brandon Troisi
Date: 10/25/2016

*/

import java.util.Random;

public class Spawner extends Agent{
	//Spawns customers in waiting area
	private int strategy;
	private int numItems;

	public Spawner(int r, int c, int strategy, int numItems){
	//Constructor
		super(r,c);
		this.strategy=strategy;
		this.numItems=numItems;
	
	
	}
	
	
	public void updateState(Landscape scape){
		Random gen = new Random();
		//Creates 50 customers every time step in waiting area
		for(int i=0; i<50; i++){
			Customer c = new Customer(gen.nextInt(200),gen.nextInt(200),this.strategy,gen.nextInt(5));
			scape.addCustomer(c);
		
		}
	
	
	}




}