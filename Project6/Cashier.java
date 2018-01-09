/*
Filename: Checkout.java
Author: Brandon Troisi
Date: 10/25/2016

*/

import java.util.Iterator;
import java.awt.Graphics;
import java.util.Random;
import java.awt.Color;
import java.util.ArrayList;

public class Cashier extends Agent{
	//Creates cashiers that can process customers in line

	private MyQueue<Customer> line;
	private ArrayList<Integer> custRemoved;
	

	public Cashier(int r, int c){
		super(r,c);
		this.line=new MyQueue<Customer>();
		this.custRemoved = new ArrayList<Integer>();
	}
		
	public void addCustomer(Customer c){
		//add customers to line
		line.add(c);
		
	}
	
	public void removeCustomer(Customer c){
		//remove customers from line
		line.remove(c);
	}
	
	
	public Iterator<Customer> getPathIterator(){
 		//Forward iterator
 		
 		return this.line.iterator();
 	}
 	
 	public int size(){
 		//Returns size of line
 		return this.line.size();
 	}
 	
 	public ArrayList<Integer> getCustRemoved(){
 		//Returns list of customers removed from the line
 		return this.custRemoved;
 	}
 	
	
	
	public void updateState(Landscape scape){
		//Checks out customers by removing them from line
		if(this.line.peek()==null){
			//Checks for empty line
			return;
		}
		Customer firstCust = this.line.peek();
		if(firstCust.getNumItems()>0){
			//Decreases number of items customer has at head of line until it reaches 0
			firstCust.checkout();	
		}
		
		else if(firstCust.getNumItems()==0){
			//Once number of items customer has is 0, that customer is removed from line 
			//All other customers are moved one spot forward toward front of line. 
			removeCustomer(firstCust);
			this.custRemoved.add(firstCust.getTimeProcessed());
			firstCust.setPhase(5);
			for(Customer c: line){
				c.updateState(scape); 
			}	
		}
	}
	
	public void draw(Graphics g){
		//Draws cashier as red rectangles
		g.setColor(Color.red);
		g.fillRect(this.getCol(),this.getRow(),10,10);
	}
}