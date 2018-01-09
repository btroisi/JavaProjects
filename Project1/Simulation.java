/**
* File: Simulation.java
* Author: Brandon Troisi
* Date 09/14/2016
*/


public class Simulation{
	//Creates simulation of 1000 blackjack games

	public static void main( String[] args){
		/*Keeps track of how many games the player won, how many games the dealer won,
		and how many times a push(draw) occurred as a raw number and a percentage.
		
		*/
		int dealerwin=0;
		int draw=0;
		int playerwin=0;
		double pwp;
		double dwp;
		double drwp;
			
	
		for(int i =0; i<1000; i++){
			Blackjack blackjackgame = new Blackjack();
			int result = blackjackgame.playgame();
			
			
			if(result==-1){
				dealerwin+=1;
			}
			
			
			else if(result == 0){
				draw+=1;
			
			}
			
			
			else{
				playerwin+=1;	
			
			}
				
				
		}
		
		
		
		pwp = (playerwin/1000.0)*100;
		dwp = (dealerwin/1000.0)*100;
		drwp = (draw/1000.0)*100;
		System.out.println("The player won" + " " + playerwin + " times" ); 
		System.out.println("The dealer won" + " " + dealerwin + " times" ); 
		System.out.println("A draw occurred" + " " + draw + " times" ); 
		System.out.println("The player won" + " " + pwp + " percent of the games" ); 
		System.out.println("The dealer won" + " " + dwp + " percent of the games " ); 
		System.out.println("A draw occurred" + " " + drwp +  " percent of the games" ); 
	
	}
	
}
