/**
* File: ParkingSimulation.java
* Author: Brandon Troisi
* Date 09/27/2016
*/

import java.util.Random;
import java.util.ArrayList;
import java.awt.Color;

public class ParkingSimulation{

	

	public void run(double probabilityToPark) throws InterruptedException{
		//Runs simulation of parking garage
		//Initializes arrayList of all cars parked successfully, arrayList of cars that were retrieved.
		//Initializes variables of how many cars tried to park there, how many failed, 
		//how many in holding area, and current timestep 
	
		
		ArrayList<Car> masterList = new ArrayList<Car>();
		ArrayList<Car> retrievedCars = new ArrayList<Car>();
		int fail=0;
		int attempt=0;
		int curTimestep=0;
		int hold=0;
		
	
	
		Random gen = new Random();
		ParkingGarage p = new ParkingGarage(5,10);
		ParkingGarageDisplay display = new ParkingGarageDisplay(p, 5);
		
		//Parking garage created has 5 lanes with max capacity 10 cars
		//Parking garage display drawn at scale 5
	
	
		for(int currTimestep=0; currTimestep<200; currTimestep++){
			//Loops through 200 time steps
			
			
			curTimestep++;
			for(int i=0; i<2; i++){
				//At most 2 new cars parked in garage
				
				
				if(gen.nextFloat()<probabilityToPark){
					//If randomly chosen float is less than probability to park, new car created with 
					//randomly chosen value for its time to leave. 
					Car c = new Car( i + gen.nextInt(100), new Color( gen.nextFloat(), 
                	gen.nextFloat(), gen.nextFloat() ) );
                	attempt++;
                
                	boolean parked = p.parkCar(c);
                	if(parked){
                		//If car successfully parked, car gets added to master list.
						//If car is not parked successfully, fail counter increases
                		masterList.add(c);
                	}
                	else{
                		fail++;
                	}
				}
			}
		
		
		
			for(int i=0; i<masterList.size(); i++){
				//If current time step matches the time the car wants to leave car is retrieved
				//Also keeps track of how many cars placed in holding area throughout simulation
				if(masterList.get(i).getTimetoLeave()==curTimestep){
					
					hold+=p.retrieveCar(masterList.get(i));
					masterList.remove(masterList.get(i));
					i--;
					
		
				}
			}
			
			
		
			display.repaint();
			Thread.sleep(150);
		}

		System.out.println("Number of cars that tried to park: " + attempt);
		System.out.println("Number of cars that failed to park: " + fail);
		System.out.println("Number of cars that had to be placed in holding area: " + hold);
		System.out.println("Percent cars successfully parked: " + 100*((double)(attempt-fail)/(double)attempt));
	}
	
	public static void main(String[] args) throws InterruptedException{
		//Creates new simulation with probability to park 0.5.
	
		ParkingSimulation sim = new ParkingSimulation();
		sim.run(0.5);
	
		
		
	
	}



}