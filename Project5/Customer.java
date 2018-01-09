/*
Filename: Customer.java
Author: Brandon Troisi
Date: 10/25/2016

*/

public class Customer extends Agent{

	private int items;
	private int phase; 
	private int timeLeft;
	private Landscape scape;
	private int strategy;
	this.scape = new Landscape(100,100)
	
	public Customer(int r, int c){
		super(r,c);
		this.items = 1; 
	}
	
	public int getNumItems(){
		return this.items;
	}
	
	public int getPhase(){
		this.phase=phase;
	}
	
	public void setNumItems(){
		this.items=items;
	}
	
	public void setPhase(){
		return this.phase;
	}
	
	public void updateState(){
	
		if(this.getPhase()==1){
			
		}
		
		else if(this.getPhase()==2){
		
		}
		
		else{
			while(this.items!-0){
				this.items--;
			}
		}
	
	
	}
	
	



}