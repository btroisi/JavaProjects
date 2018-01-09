/*
Filename: FertileGround.java
Author: Brandon Troisi
Date: 10/11/2016

*/
import java.awt.Graphics;
import java.awt.Color;

public class FertileGround extends Agent{
	//Represents fertile ground, or growth patch 

	private int xpos;
	private int ypos;

	
	public FertileGround(int r, int c){
		//Constructor
		super(r,c);
	}
	
	public void draw(Graphics g, int gridScale){
		//Draws growth patch
		g.setColor(Color.green);
		xpos=this.getCol()*gridScale;
		ypos=this.getRow()*gridScale;
		g.drawRect(xpos,ypos,gridScale,gridScale);
		
		
	
	}
	
	public static void main(String args[]){
		//Creates fertile ground object at (5,5) and sets it at (4,3).
		
		FertileGround fg = new FertileGround(5,5);
		System.out.println("Fertile ground" + fg.toString());
		fg.setRow(4);
		fg.setCol(3);
		System.out.println("Current fertile ground: " + fg.toString());
	
	
	}

}