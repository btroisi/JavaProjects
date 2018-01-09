/*
Filename: Checkout.java
Author: Brandon Troisi
Date: 10/25/2016

*/

public class Checkout extends Agent{

	private MyQueue<Customer> line1;
	private MyQueue<Customer> line2;
	private MyQueue<Customer> line3;
	private MyQueue<Customer> line4;
	private int size;
	
	
	
	public Checkout(int r, int c){
		super(r,c);
		this.line1 = new MyQueue(10);
		this.line2 = new MyQueue(10);
		this.line3 = new MyQueue(10);
		this.line4 = new MyQueue(10); 
		this.size=size;
	
	
	}
	
	//add customers to queue
	
	//update state
	
	public void updateState(){
		if(line1.size==0){
			return
		}
		else if
	
	}
	
	public static void main (String args[]){

	}



}