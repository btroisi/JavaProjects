/*
Filename: Landscape.java
Author: Brandon Troisi
Date: 10/11/2016

*/

import java.util.Random;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class Landscape{
	//Represents landscape that can hold customers and checkout lines

	private int rows;
	private int cols;
	private int numIterations;
	private ArrayList<Customer> custList;
	private Cashier[] cashier;
	private ArrayList<Integer> waitTimes;
	 
	
	

	public Landscape(int rows, int cols, int numIterations){
		//Constructor
	
		this.rows=rows;
		this.cols=cols;
		this.numIterations=numIterations;
		this.custList = new ArrayList<Customer>();
		this.cashier=new Cashier[6];
		for(int i=0; i<cashier.length; i++){
			int x = i*20+30;
			int y= 300;
			this.cashier[i] = new Cashier(y,x);
			
		}
		this.waitTimes = new ArrayList<Integer>();
		
	}
	
	public int getRows(){
		//Returns rows of landscape
		return this.rows;
	
	}
	
	public int getCols(){
		//Returns cols of landscape
		return this.cols;
	
	}
	
	public Cashier getCashier(int cashidx){
		//Returns reference to a cashier at index cashidx
		return cashier[cashidx];
	}
	
	public void addCustomer(Customer c){
		//Adds customer to list of customers
		this.custList.add(c);
	}
	
	public void addToLine(Customer c, int cashidx){
		//Add customer to a particular line
		cashier[cashidx].addCustomer(c);
		int x = cashidx*20+30;
		int y= 300-5*cashier[cashidx].size();
		c.setRow( y );
		c.setCol( x );
	
	}
	
	public void removeFromLine(Customer c){
		//Removes customer at the head of the line for that particular line
		for(int i=0; i<cashier.length;i++){
			this.cashier[i].updateState(this);
			int x = i*20+30;
			int y= 300+5*cashier[i].size();
			c.setRow( y );
			c.setCol( x );
		}
	}
	
	public String toString(){
		//Returns string indicates rows and cols of landscape
		String s = "Dimensions of landscape: " + this.rows + " rows and "+ this.cols + " columns ";
		return s; 
	
	}
	
	
	public int selectCashier(){
		//Chooses a random cashier index
		Random gen = new Random();
		return gen.nextInt(cashier.length);
	
	}
	
	public void updateState(){
		//Updates state of all customers and cashiers
		for(Customer c: custList){
			c.updateState(this);
		}
		for(Cashier cash: cashier){
			cash.updateState(this);
		}
	}
	
	public double average(){
		//Calculates average time that customers passed through checkout
	
		this.waitTimes.clear();	
		for(int i=0; i<this.cashier.length; i++){
			for(int j=0; j<this.getCashier(i).getCustRemoved().size(); j++){
				this.waitTimes.add(this.getCashier(i).getCustRemoved().get(j));
			}
		}
		double avg=0;
		for(int i=0; i<waitTimes.size(); i++){
			avg+= waitTimes.get(i);
		}
		
		avg=avg/waitTimes.size();
		return avg;
		 

	}
	
	public double standardDeviation(){
		//Calculates standard deviation for average time that customers passed through checkout
	
		ArrayList<Double> standardDev = new ArrayList<Double>();
		double avg = this.average();
		for(int i=0; i<this.waitTimes.size(); i++){
			double stdev = Math.pow(avg-this.waitTimes.get(i),2);
			standardDev.add(stdev);
		
		}
		double mean = 0;
		for(int i=0; i<standardDev.size(); i++){
			mean+=standardDev.get(i);
		}
		
		mean=mean/standardDev.size();
		mean=Math.sqrt(mean);
		return mean;
	}
	public void draw(Graphics g){
		//Draws customers and cashiers
		
 		for(Customer c: this.custList){
			if(c.getPhase()==5){
				continue;
			}
			c.draw(g);
		}
		
		for(Cashier cash: this.cashier){
			cash.draw(g);
		}
 	}
	
}