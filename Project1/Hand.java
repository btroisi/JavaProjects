/**
* File: Hand.java
* Author: Brandon Troisi
* Date 09/14/2016
*/

import java.util.ArrayList;

public class Hand{
	//Holds a set of cards
	
	ArrayList<Card> hand;
	
	
	public Hand(){
		//Creates the hand as an arraylist that holds card objects
		hand = new ArrayList<Card>();
	
	}
	
	public void reset(){
		//Resets the hand by emptying it
		hand.clear();
	
	}
	
	public void addCard(Card card){
		//Adds card object to the hand
		hand.add(card);
	
	}
	
	public int size(){
		//Returns the size of the hand
		return hand.size();
	
	}
	
	public Card getCard( int i ){
		//Returns the card that is in ith index of hand
		return hand.get(i);
	
	}
	
	public int getTotalValue(){
		//Calculates and returns the sum of the values of the cards in the hand
		
		
		int sum = 0;
		for(int i = 0; i<hand.size(); i++){
			sum+=hand.get(i).getValue();	
		} 
		return sum;
	}
	
	public String toString(){
		///Returns a string that states the size of the hand and what values it contains
		String s = "The size of your hand is " + hand.size()+ " and contains values of: ";
		for(int i=0; i<hand.size();i++){
			s+= hand.get(i).getValue() + " ";
		}	
		
		return s;
	}
	
	
	public static void main(String[] args){
		/*Creates 2 new card objects with values 2 and 5 and adds them to hand object
		h. Prints out the values of the cards in the hand and the sum of the values
		in the hand.
		*/
		Card c1 = new Card(2);
		Card c2 = new Card(5);
		Hand h = new Hand();
		h.addCard(c1);
		h.addCard(c2);
		int cardValue1 = c1.getValue();
		int cardValue2 = c2.getValue();
		System.out.println("The value of card 1 is: "+ cardValue1);
		System.out.println("The value of card 2 is: " + cardValue2);
		System.out.println(h.toString());
		System.out.println("The sum of the values of all the cards are: " + h.getTotalValue());
	}
	
	
	
	
	
	
}