/**
* File: CarStack.java
* Author: Brandon Troisi
* Date 09/27/2016
*/

import java.util.Random;
import java.awt.Color;

public class CarStack{
	//Stores a stack of cars. Stores index of the top of stack and an array of Cars.

	private Car[] cStack;
	private int nextEmptySpace;

	public CarStack(){
		//Constructor method. Makes array of 10 cars and top index initialized to 0. 
	
		cStack=new Car[10];
		nextEmptySpace=0;	
	}
	
	public void push( Car new_item ){
		//Pushes new car object onto the carstack
		
		
		if(nextEmptySpace>=cStack.length){
			Car[] tempcStack;
			tempcStack=new Car[2*cStack.length];
			
			for(int i=0;i<cStack.length;i++){
				tempcStack[i]=cStack[i];
				
				
			}
			cStack=tempcStack;	
		}
		
		cStack[nextEmptySpace]=new_item;
		nextEmptySpace++;
		
	
	
	}
	
	public Car pop(){
		//Pops car off carstack and returns this car
		if(nextEmptySpace==0){
			return null;
			
		}
		nextEmptySpace--;
		return cStack[nextEmptySpace];
		
	
	}
	
	public Car elementAt( int index ){
		//Returns car object at given position
	
		return cStack[index];
	
	
	}
	
	public int size(){
		//Returns size of carstack
		return nextEmptySpace;
	
	}
	
	public boolean isEmpty(){
		//Returns true if stack is empty
		if(nextEmptySpace==0){
			return true;
		}
		
		else{
			return false;
		
		}
	}
	
	public String toString(){
		//Returns string that shows carstack
		String s="";
		for(int i=0; i<cStack.length; i++){
			s+=elementAt(i)+"\n"; 
	
		}
	
		return s;
	}

	
	public static void main(String[] args){
		//Creates new carstack, adds 10 cars to it, prints car object at index 3 and size.
		//Also prints false since the carstack is not empty. 
	
		
		CarStack cs = new CarStack();
		
		for(int i=0; i<10; i++){
			Car c = new Car(1+i,Color.red);
			cs.push(c);
		}
		
		
		System.out.println(cs.toString());
		System.out.println("Car 3: " + cs.elementAt(3));
		System.out.println("Size: " + cs.size());
		System.out.println(cs.isEmpty());
	
	}
	
	
}
