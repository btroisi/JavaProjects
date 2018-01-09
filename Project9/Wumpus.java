/*
Title:Wumpus
Author: Brandon Troisi
Date: 12/7/16
*/

import java.util.Random;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.Graphics; 


public class Wumpus extends Agent{
	//Represents wumpus in Hunt The Wumpus game

	private Vertex location;
	private boolean visible;
	private boolean wumpusVictoryState;
	
	
	public Wumpus(int row, int col){
		//Constructor
		super(row,col);
		Random gen = new Random();
		this.location = new Vertex(row, col); 
		this.visible=false;
		this.wumpusVictoryState=false; 
		
	}
	
	public Vertex getLocation(){
		//Returns Vertex at which wumpus is located 
		return this.location; 
	}
	
	public void setLocation( Vertex v){
		//Sets location of wumpus to Vertex v
		this.location = v; 
	}
	
	public boolean getVisible(){	
		//Returns boolean that represents if wumpus is visible on screen 
		return this.visible;
	}
	
	public void setVisible(boolean vis){
		//Sets boolean that represents if wumpus is visible on screen to vis
		this.visible = vis; 
	}
	
	public boolean getWumpusVictoryState(){
		//Returns victoryState of wumpus
		return this.wumpusVictoryState;
	}
	
	public void setWumpusVictoryState(boolean winState){
		//Sets victoryState of wumpus to winState
		this.wumpusVictoryState = winState; 
	}
	
	public void draw(Graphics g, int gridScale){
		//Draws wumpus on screen if wumpus is visible and can draw two different wumpuses
		//given whether wumpus won game or not
		if(this.getVisible() && this.getWumpusVictoryState()){
			//If wumpus is visible and the wumpus wins the game
			//What is drawn on screen is image of Locust from Gears of War at wumpus's location
			Image img1 = Toolkit.getDefaultToolkit().getImage("WumpusWin.png");
			g.drawImage(img1,this.getLocation().getCol()*gridScale+5,this.getLocation().getRow()*gridScale+5, null);
		}
		
		else if(this.getVisible() && !this.getWumpusVictoryState()){
			//If wumpus is visible and the wumpus loses the game
			//What is drawn on screen is image of dancing skeleton at wumpus's location
			Image img2 = Toolkit.getDefaultToolkit().getImage("WumpusLose.png");
			g.drawImage(img2,this.getLocation().getCol()*gridScale+5,this.getLocation().getRow()*gridScale+5, null);
		}
	}
}