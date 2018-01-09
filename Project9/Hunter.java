/*
Title:Hunter 
Author: Brandon Troisi
Date: 12/7/16
*/

import java.awt.Graphics; 
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.Color; 

public class Hunter extends Agent{
	//Represents hunter in Hunt The Wumpus game
	private Vertex location;
	private boolean visible; 
	private boolean aimState; 
	
	
	public Hunter(int row,int col){
		//Constructor
		super(row,col);
		this.location = new Vertex(row,col);
		this.visible = true; 
		this.aimState = false; 
	}
	
	public Vertex getLocation(){
		//Returns vertex at which hunter is at 
		return this.location;
	}
	
	public boolean getVisible(){	
		//Returns boolean indicates whether hunter is visible in game or not
		return this.visible; 
	}
	
	public void setVisible(boolean vis){
		//Sets boolean of hunter's visibility to vis
		this.visible = vis; 
	}

	public void setLocation(Vertex v){	
		//Sets location of hunter to Vertex v
		this.location = v; 
	}
	
	public boolean getAimState(){
		//Returns aimState of hunter
		return this.aimState;
	}
	
	public void setAimState(boolean b){
		//Sets aimState of hunter
		this.aimState = b; 
	}
	

	public void draw(Graphics g, int gridScale){
		//If hunter is visible, hunter is drawn on screen at the vertex it is currently located at
		//Hunter is an image of a hunter from Skyrim
		if(this.visible){
			Image img1 = Toolkit.getDefaultToolkit().getImage("Hunter.png");
 			g.drawImage(img1,this.getLocation().getCol()*gridScale+5,this.getLocation().getRow()*gridScale+5, null);
 		}
		//g.setColor(Color.blue); 
		//g.drawOval(this.getCol()*gridScale+gridScale/4,this.getRow()*gridScale+gridScale/4,gridScale/2,gridScale/2);
	}

}