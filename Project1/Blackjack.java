/**
* File: Deck.java
* Author: Brandon Troisi
* Date 09/14/2016
*/

import java.util.ArrayList;
import java.util.Random;

public class Blackjack{
	//Implements version of blackjack 
	Hand playerHand;
	Hand dealerHand;
	Deck gameDeck;
	
	public Blackjack(){
		//Sets up and resets game.
		dealerHand= new Hand();
		playerHand = new Hand();
		gameDeck = new Deck();
		reset(true);
	}

	public void reset( boolean reshuffle ){
		//Sets up and resets game. If reshuffle is true, creates a new deck.
		if(reshuffle == true ){
			dealerHand= new Hand();
			playerHand = new Hand();
			gameDeck = new Deck();
			
		}
	
	
	}
	
	public void deal(){
		//Deals 2 cards to player.
		
		for(int i=0; i<2; i++){
			playerHand.addCard(gameDeck.deal());
			dealerHand.addCard(gameDeck.deal());	
		
		}
	
	}
	
	public String toString(){
		/*Returns a string that describes the state of the game. This means that
		how many cards the player has, what the values of his/her cards are, and the sum
		of his/her cards. It also means how many cards the dealer has, what the values of
		his/her cards are, and what the sum of his/her cards are.
		*/
		
		String a = "Player: " + playerHand + "The sum of the cards are " + playerHand.getTotalValue();
		String b = "Dealer: " + dealerHand + "The sum of the cards are " +dealerHand.getTotalValue();
		String c = "If the result below is 1, the player wins, if the result below is -1, the dealer wins, if the result is 0, the game is a draw";

		
		return a + "\n" + b + "\n"+ c; 
	}
	
	public boolean playerTurn(){
		//Player draws cards until the sum of his/her cards is greater than or equal to 16
		//If the sum of his/her cards exceeds 21, a bust occurs and function returns false.
	
		int sum = playerHand.getTotalValue();
		while( sum < 16){
			playerHand.addCard(gameDeck.deal());
			sum=playerHand.getTotalValue();
			
		}
		
		if(sum>21){
		
			return false;
			
		}
		
		else{
		
			return true;
		
		}
	}
	
	public boolean dealerTurn(){
	
		//Dealer draws cards until the sum of his/her cards is greater than or equal to 17
		//If the sum of his/her cards exceeds 21, a bust occurs and function returns false.
	
		int dsum = dealerHand.getTotalValue();
		while(dsum <17){
			dealerHand.addCard(gameDeck.deal());
			dsum=dealerHand.getTotalValue();			
		
		}
	
		if(dsum>21){
		
			return false;
			
		}
		
		else{
		
			return true;
		
		}
	
	}
	
	
	
	public int playgame(){
		/*Plays a game that returns 1 if the player wins, 0 if it is a push(draw),
		and -1 if the dealer wins.		
		*/
	
		if(this.gameDeck.size()<10){
			//If the size of the deck is less than 10, a new deck is created
			reset(true);	
		}
	
		deal();
		playerTurn();
		dealerTurn();
		
		if(playerTurn()==false){
			//If the playerTurn method returns false the player loses and the dealer wins
			return -1;
		}
		
		else if(dealerTurn()==false){
			//If the dealerTurn method returns false, the player wins
			return 1;
		}
		
		
		else if(dealerHand.getTotalValue()>playerHand.getTotalValue()){
			/*If the sum of the dealer's hand is greater than the sum of the player's 
			hand, the dealer wins
			*/
			return -1;
		}
		
		else if(dealerHand.getTotalValue()==playerHand.getTotalValue()){
			/*If the sum of the dealer's hand is equal to the sum of the player's hand,
			a draw is the result
			
			*/
			return 0;
		}
		
		else{
			/*The only other possible outcomes of the game is that the sum of the player's
			hand is greater than the sum of the dealer's hand and if the player's hand
			is equal to 21. So, the result is that the player wins.			
			*/
			return 1;
		}
	}
		
	public static void main (String[] args){
		/*Creates a new blackjack game and plays blackjack game that prints
		state of game and result of the game. 
		*/
		Blackjack blackjackgame = new Blackjack();
		int result = blackjackgame.playgame();
		System.out.println(blackjackgame.toString());
		System.out.println(result);
		
	
	
	}
	
	
}













