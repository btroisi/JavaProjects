/**
* File: CarStack.java
* Author: Brandon Troisi
* Date 09/27/2016
*/

import java.awt.Color;
import java.awt.Graphics;

public class ParkingGarage{
	//Stores lanes of Cars

	private CarStack[] garage;
	private CarStack holding;
	private int numLanes;
	private int maxLaneSize;
	
	
	public ParkingGarage(int numLanes, int maxLaneSize){
		//Constructor method initializes car stacks of lanes, holding area.
		//Sets max number of cars each lane can hold
		
		this.garage=new CarStack[numLanes];
		this.holding= new CarStack();
		this.maxLaneSize=maxLaneSize;
		
		
		for(int i=0; i<garage.length; i++){
		
			this.garage[i]=new CarStack();
		
		}
			
		
	
	}
	
	public int getNumLanes(){
		//Returns number of lanes in garage
		return garage.length;
	
	}
	
	public int getMaxLaneSize(){
		//Returns max number of cars that each lane can hold
		return maxLaneSize;
	
	}
	
	public boolean parkCar( Car car){
		//If there is a lane with an available spot, then car will be parked in that spot
		//Fills one lane at a time
		
		for(int i=0;i<this.garage.length;i++){
			if(garage[i].size()<maxLaneSize){
				garage[i].push(car);
				return true;
			}
		
		}
		return false;
		
	}
	
	
	public String toString(){
		//Returns string that shows state of parking lot. 
	
		String s="";
		for(int i=0; i<garage.length; i++){
			
			s+=garage[i].toString()+"\n"; 
			
	
		}
	
		return s;
	}
	
	public void draw(Graphics g, int scale){
		//Draws parking garage at given scale
		
		
		for(int i=0; i<garage.length; i++){
			g.setColor(Color.black);
			g.drawRect(i*scale*15 + 20, 20, 10*scale, (this.maxLaneSize*13*scale-6*scale));
			
			for(int j=0; j<garage[i].size(); j++){
				garage[i].elementAt(j).draw(g, 20+2*scale+i*scale*15, 20+2*scale+j*12*scale, 6*scale, 10*scale);	
			
			}
		}
		
	
	}
	
	public int retrieveCar(Car car){
		//Removes car from lane it's parked in.
		//If there are cars behind it, those cars get moved to holding area.
		//Once car is removed from garage, cars in holding area get moved to original spots 
		//Keeps track of how many cars are in holding area
	
		int lane=0;
		int index=0;
		
		for(int i=0; i<garage.length;i++){
			for(int j=0;j<garage[i].size();j++){
				if(garage[i].elementAt(j)==car){
					lane=i;
					index = j;
				}
			}
		}
		
		int hcount=0;
		for(int k=garage[lane].size();k>index;k--){
			holding.push(garage[lane].pop());
			hcount++;
			
		
		}
	
	
		garage[lane].pop();
		
		 
		for(int l=0; l<holding.size(); l++){
		
			garage[lane].push(holding.pop());
			l--;
			
		}
		return hcount;
	}
	
	public static void main(String args[]){
		//Creates parking garage with 5 lanes that can hold max of 10 cars
		ParkingGarage p = new ParkingGarage(5,10);
		
		for(int i=0; i< 50; i++){
			Car c = new Car(i+1, Color.green);
			p.parkCar(c);
		
		}
	
	
		System.out.println("Number of lanes: " + p.getNumLanes());
		System.out.println("Lane size: " + p.getMaxLaneSize());
		System.out.println("Parking Garage: " + "\n" + p.toString());
		
		
	
	
	
	}
	
}