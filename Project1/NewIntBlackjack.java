/**
* File: NewIntBlackjack.java
* Author: Brandon Troisi
* Date 09/14/2016
*/

import java.util.Scanner;

public class NewIntBlackjack{
	//Creates an interactive blackjack game.

	private Hand playerHand;
	private Hand dealerHand;
	private Deck dgameDeck;
	private Deck pgameDeck;
	
	
	public NewIntBlackjack(){
	/*Sets up and resets game by creating playerHand object, dealerhand object,
	a player game deck object called pgameDeck, and a dealer game deck object called
	dgameDeck.
	
	*/
		playerHand = new Hand();
		dealerHand= new Hand();
		pgameDeck = new Deck();
		dgameDeck = new Deck();
		reset(true);
	}

	public void reset( boolean reshuffle ){
		//Resets game. If reshuffle is true, creates a new deck.
		
		if(reshuffle == true ){
			playerHand = new Hand();
			pgameDeck = new Deck();
			dealerHand = new Hand();
			dgameDeck = new Deck();
			
			
		}
	
	}

	public void initplayerdeal(){
		//Deals player 2 cards to start the game.
		
		for( int i=0; i<2; i++){
			playerHand.addCard(pgameDeck.deal());
		}	
	}
	
	public void gameplayerdeal(){
		//Deals cards to the player throughout the game
	
		playerHand.addCard(pgameDeck.deal());
			
	}
	
	public void dealerdeal(){
		//Deals cards to the dealer throughout the game.
		
		dealerHand.addCard(dgameDeck.deal());
			
	}
	
	public Hand getPlayerHand(){
		//Returns the player's hand
		return this.playerHand;

	}

	public Hand getDealerHand(){
		//Returns the dealer's hand
		return this.dealerHand;

	}
	public static void main( String[] args){
		/*Plays an interactive game of blackjack.
		
		*/
	
		Scanner user_input = new Scanner(System.in);
		String playeranswer;
		NewIntBlackjack blackjackgame = new NewIntBlackjack();
		
		blackjackgame.initplayerdeal();
		blackjackgame.dealerdeal();
		
		System.out.println("Hello, welcome to Blackjack. To win this game your sum must be greater than the dealer and be less than 21 or the sum of your hand must equal 21.");
		System.out.println(blackjackgame.getPlayerHand().toString());
		
		int psum = blackjackgame.getPlayerHand().getTotalValue();
		int dsum = blackjackgame.getDealerHand().getTotalValue();
		
		while(psum<21){
		
			/*While the sum of the player's hand is less than 21, the player will have a 
			choice as to whether or not he/she wants to draw cards from the deck.
			*/
			System.out.print("Would you like to draw another card? Please respond Yes or No: ");
			playeranswer=user_input.next();
			
			if(playeranswer.equals("Yes")){
				//If the user inputs Yes, they draw from the deck. 
				blackjackgame.gameplayerdeal();
				System.out.println(blackjackgame.playerHand);
				
				if(dsum<17){
				/*The dealer will continue to draw from his deck until the sum of his 
				cards stops at 17 or higher
				*/
					blackjackgame.dealerdeal();
					dsum = blackjackgame.getDealerHand().getTotalValue();
				}
			}
			
			psum = blackjackgame.getPlayerHand().getTotalValue();
		    
			
			if(playeranswer.equals("No")){
				//If the user inputs no, the player does not draw any more cards from the deck.
			 
				
				if(dsum<17){
					/*The dealer will continue to draw from his deck until the sum of his 
					cards stops at 17 or higher
					*/
					blackjackgame.dealerdeal();
					dsum = blackjackgame.getDealerHand().getTotalValue();
				}
				if(psum>dsum){
					/*If the sum of the player's hand is greater than the sum of the 
					dealer's hand, player wins.
					*/
					System.out.println("Congratulations, your sum is greater than the dealer's! You won the game!");
					System.out.println("Player sum:" + psum);
					System.out.println("Dealer sum:" + dsum);
				}
					
				if(dsum>psum){
				
					/*If the sum of the dealer's hand is greater than the sum of the 
					player's hand, dealer wins.
					*/	
					System.out.println("Player sum: " + psum);
					System.out.println("Dealer sum: " + dsum);	
					System.out.println("Sorry, the dealer sum is greater than yours, you lose");
						
				}
					
				if(dsum==psum){
					/*If the sum of the dealer's hand is equal to the sum of the player's
					hand, the dealer wins even though it is a draw because this is how
					it works in the real game of blackjack. 
					*/
					System.out.println("It appears we have come to a draw, too bad the dealer wins");
				}
				System.out.println(blackjackgame.playerHand);
				System.out.println("Dealer: " + blackjackgame.dealerHand);
			    break;
			}
			
				
			if(psum==21){
				//If the sum of the player's hand is 21, the player wins
				System.out.println("Congratulations, you reached 21 and won the game!");
				break;
			}
			
			if(psum>21){
				//If the sum of the player's hand is greater than 21, the player loses
				System.out.println("You overdrew your cards, you lost!");
				break;
			}
			
			if(dsum>21){
				//If the sum of the dealer's hand is greater than 21, the player wins
				System.out.println("Congratulations, you won the game!");
				break;
			}
			
			if(dsum==21){
				//If the sum of the dealer's hand is 21, the dealer wins
				System.out.println("The dealer reached 21, you lost");
				
			}

		}

	}
	


}