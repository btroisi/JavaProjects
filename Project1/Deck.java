/**
* File: Deck.java
* Author: Brandon Troisi
* Date 09/14/2016
*/

import java.util.ArrayList;
import java.util.Random;

public class Deck{
	///Holds set of cards and shuffles them
	ArrayList<Card> deck;
	
	
	public Deck(){
		//Builds arrayList called deck of 52 cards and shuffles them
		deck = new ArrayList<Card>(52);
		build();
		shuffle();
		
	}
	
	public void build(){
		/*Builds deck of 52 cards where 36 cards have values 1-9 (every value in this range
		is assigned to 4 cards) and 16 cards with the value 10. 
		*/
	
		deck = new ArrayList<Card>(52);
		
	
		for(int i=0; i<4; i++){
			for(int j=1; j<10; j++){
			

				deck.add(new Card(j));
				
			}
		
		}
		
		for( int i=0; i<16; i++){
			
			
			deck.add(new Card(10));
		
		}	
			
	}
	
	public int size(){
		//Returns deck size
		return deck.size();
		
	}
	
	public Card deal(){
		//Deals by removing the first element from the deck array and returning that result
		Card result = deck.remove(0);
		return result;
		
	}
	
	public Card pick( int i ){
		//Removes the ith element from the deck array 
		Card result = deck.remove(i);
		return result;
		
	}
	
	public void shuffle(){
		//Shuffles the deck 
		ArrayList<Card> shuffdeck;
		Random r = new Random();
		shuffdeck = new ArrayList<Card>(52);
		
		for( int i=0; i<52; i++){
		
			int rint = r.nextInt(deck.size());
			shuffdeck.add(deck.get(rint));
			deck.remove(rint);
				
		}
	
		deck = shuffdeck;
		
	}
	
	public String toString(){
		///Returns a string that displays what the values of the cards in the deck are
	
		String s = "The values of the cards in your deck are: ";
		for(int i=0; i<deck.size();i++){
			s+= deck.get(i).getValue() + " ";
		}	
		
		return s;
	}

	
	public static void main( String[] args){
		/*Creates a new deck object d, shuffles it,prints the values of the deck, removes 
		the first element from the deck (deals) and returns the value of the card that was
		dealt.
		*/ 
		Deck d = new Deck();
		d.shuffle();
		System.out.println(d.toString());
		d.deal();
		System.out.println(d.toString());
		
		
			
	}


}