/**
* File: Card.java
* Author: Brandon Troisi
* Date 09/14/2016
*/


public class Card{
	//Holds the value of the card, which ranges from 1-10
	
	private int v;
	
	public Card(int value){
	//Constructor method that holds the value of the card and makes sure it ranges from 1-10
		
		if (value<1 || value>10){	
			v= 1;
			System.out.println("This value for this card is not valid");
		}
		
		else{
			v = value;
		}	
	}
	
	public int getValue(){
		return v;
	
	}
	
	public static void main( String[] args ){
		//Creates 3 card objects with values of 1, 2, and 12
		//However, the card object with value 12 has its value reset to 1 since 12
		//is out of the range of card values
		Card a = new Card( 1 );
		Card b = new Card ( 2 );
		Card c = new Card ( 12 );
		System.out.println("The value of the first card is: " + a.getValue());
		System.out.println("The value of the second card is: " + b.getValue());
		System.out.println("The value of the third card is: " + c.getValue());
	}
}

