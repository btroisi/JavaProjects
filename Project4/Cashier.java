/*
Filename: Checkout.java
Author: Brandon Troisi
Date: 10/25/2016

*/

public class Cashier extends Agent{

	private MyQueue<Customer> line;
	private int size;
	
	
	
	public Checkout(int r, int c){
		super(r,c);
		this.line=MyQueue<Customer>;
		this.size=size;
	}
	
	//add customers to queue
	public void addCustomer(Customer c){
		line.add(c);
	}
	
	
	//remove customers from queue
	public void removeCustomer(Customer c){
		line.remove(c);
	}
	
	
	public Iterator<PathVertex> getPathIterator(){
 		//Forward iterator
 		
 		return this.path.iterator();
 	}
 	
 	public Iterator<PathVertex> getPathBackwardIterator(){
 		//Backward iterator
 	
 		return this.path.backward_iterator();
 	}
	
	
	public void updateState(Landscape scape){
		if(this.line.size()==0){
			return;
		}
		Customer firstCust = line.peek();
		else if(firstCust.getNumItems()>0){
			firstCust.checkout();	
		}
		
		else if(firstCust.getNumItems()==0){
			removeCustomer(firstCust);
			for(Customer c: line){
			Customer.updateState(); 
			}
		}

	}
	
	public void draw(graphics g, int gridScale){
	
	
	}
	


}