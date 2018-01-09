/*
Filename: Customer.java
Author: Brandon Troisi
Date: 10/11/2016
NOT COMPLETED YET!!!!!!!!!
*/

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;

public class Customer extends Agent{
	//Holds information about how a customer can move through checkout line

	private int phase;
	private int timeToSelect;
	private int strategy;
	private int numItems;
	private Cashier[] cashier;
	private int timeProcessed;

	public Customer(int r, int c, int strategy, int numItems){
		//Constructor
		super(r,c);
		this.phase=1;
		this.timeToSelect=5;
		this.strategy=strategy;
		this.numItems=1;	
		this.cashier = new Cashier[6];
		this.timeProcessed = 0;
	}
	
	
	public int getNumItems(){
		//Returns number of items that a customer has
		return this.numItems;
	}
	
	public void setItems(){
		//Sets number of items that a customer has
		this.numItems=numItems;
	}
	
	public int getPhase(){
		//Returns the phase of the checkout that the customer is in
		return this.phase;
	}
	
	public void setPhase(int phase){
		//Sets phase of the checkout that the customer is in
		this.phase=phase; 
	}
	
	public int getStrategy(){
		//Returns the strategy that the customer uses to move through checkout lines
		return this.strategy;
	}
	
	public void setStrategy(){
		//Sets strategy that customer uses to move through checkout
		this.strategy=strategy; 
	}
	
	public int getTimeToSelect(){
		//Returns amount of time customer has to choose a line
		return this.timeToSelect;
	}
	
	public void setTimeToSelect(){
		//Sets amount of time customer has to choose a line
		this.timeToSelect=timeToSelect;
	}
	
	public void checkout(){
		//Decreases numItems that customer has
		this.numItems--;
	}
	
	public void setTimeProcessed(){
		//Sets time customer spent in a line
		this.timeProcessed++; 
	}
	
	public int getTimeProcessed(){
		//Returns time customer spent in a line
		return this.timeProcessed;
	}
	
	
	
	public void updateState(Landscape scape){
		//Updates state of customer in the store
		if(this.phase==1){
			//Selection phase
			if(this.strategy==0){
				this.timeToSelect=1;
				//this.timeProcessed++;	
			}
			else if(this.strategy==1){
				this.timeToSelect=2;
				//this.timeProcessed+=2;
			}
			else{
				this.timeToSelect=4;
				//this.timeProcessed+=4;
			}
			this.phase=2;
		}
		
		else if(this.phase==2){
			//Wait phase
			while(this.timeToSelect!=0){
				this.timeToSelect--;
			}
			if(this.timeToSelect==0){
				this.phase=3;
			}
		}
		
		else if(this.phase==3){
			//Checkout phase, customers move through checkout line based on strategy
			
			if(this.strategy==0){
				//Places customer into random line
				int idx = scape.selectCashier();
				scape.addToLine(this, idx);
				
			}
			else if(this.strategy==1){
				//Places customer into shortest of 2 lines
				int cash1=scape.selectCashier();
				int cash2=scape.selectCashier();
				int cash1Size=scape.getCashier(cash1).size();
				int cash2Size=scape.getCashier(cash2).size();
				if(cash1Size<cash2Size){
					scape.addToLine(this, cash1);
				}
				else{
					scape.addToLine(this, cash2);
				}
			}
			else if(this.strategy==2){
				//Places customer into shortest line
				int smallest = 100;
				int smallestidx= 0; 
				for(int i=0; i<cashier.length; i++){
					int cashSize = scape.getCashier(i).size();
					if(cashSize<smallest){
						smallest = cashSize;
						smallestidx=i;
					}
				}
				
				scape.addToLine(this, smallestidx);
				
			}
		this.phase=4;
		}
		else{
			//Removes customer at front of line
			scape.removeFromLine(this);
		}
		if(this.phase<5){
			this.timeProcessed++;
		}
		
	}
		
	
	public void draw(Graphics g){
		//Draws customer. Each customer drawn with random color with black circle outlining it. 
		
		Random gen = new Random();
		int red = gen.nextInt(256);
		int green = gen.nextInt(256);
		int blue = gen.nextInt(256);
		Color randColor = new Color(red,green,blue);
		g.setColor(randColor);
		g.fillOval(this.getCol(),this.getRow(),5,5);
		g.setColor(Color.black);
		g.drawOval(this.getCol(),this.getRow(),5,5);
	}
}