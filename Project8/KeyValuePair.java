/*
Author: Brandon Troisi
File: KeyValuePair.java
Date:11/2/16

*/

public class KeyValuePair<Key,Value>{
	//Represents KeyValue Pair

	private Key k;
	private Value v; 

	public KeyValuePair(Key k, Value v){
		//Constructor
		this.k = k;
		this.v = v;	
	}
	
	public Key getKey(){
		//Returns key
		return this.k;
	}
	
	public void setKey(Key k){
		this.k=k;
	}
	
	public Value getValue(){
		//Returns value
		return this.v;
	}
	
	public void setValue(Value v){
		//Sets value
		this.v=v;
	}
	
	public String toString(){
		//Prints key value pair
		String s =  this.k + " "+ this.v;
		return s; 
	}
	
	public static void main(String args[]){
		//Creates new key value pair (1,2), sets value to 3
		//Print statements are generated to test each method
		KeyValuePair<Integer,Integer> pair = new KeyValuePair<Integer,Integer>(1,2);
		System.out.println("Key: " + pair.getKey());
		System.out.println("Value: " + pair.getValue());
		pair.setValue(3);
		System.out.println("After setting new value, value is: " + pair.getValue());
		System.out.println(pair.toString());
	}


}