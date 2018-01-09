/**
* File: IntStack.java
* Author: Brandon Troisi
* Date 09/27/2016
*/

import java.util.Random;

public class IntStack{

	int[] data;
	int nextEmptySpace;

	public IntStack(){
	
		data=new int[10];
		nextEmptySpace=0;	
	}
	
	public void push( int new_item ){
		
		
		if(nextEmptySpace>=data.length){
			int[] tempdata;
			tempdata=new int[2*data.length];
			
			for(int i=0;i<data.length;i++){
				tempdata[i]=data[i];
				
				
			}
			data=tempdata;	
		}
		
		data[nextEmptySpace]=new_item;
		nextEmptySpace++;
		
	
	
	}
	
	public int pop(){
		nextEmptySpace--;
		int d = data[nextEmptySpace];
		data[nextEmptySpace]=0;
		return d;
	
	}
	
	public int elementAt( int index ){
	
		return data[index];
	
	
	}
	
	public int size(){
		return data.length;
	
	}
	
	public boolean isEmpty(){
		if(data.length==0){
			return true;
		}
		
		else{
			return false;
		
		}
	}
	
	public String toString(){
		String s="";
		for(int i=0; i<data.length; i++){
			s+=elementAt(i)+" "; 
	
		}
	
		return s;
	}
	
	public static void main(String[] args){
	
		Random rando = new Random();
		
		
		IntStack s = new IntStack();
		for(int i=0; i<20; i++){
			int r = rando.nextInt(100);
			s.push(r);
		
		}
		System.out.println(s.toString());
		System.out.println(s.pop());
		System.out.println(s.toString());
		System.out.println("Element 8: " + s.elementAt(8));
		System.out.println("Size: " + s.size());
		System.out.println(s.isEmpty());
	
	}
	
	
}
