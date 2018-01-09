/*
Filename: PathVertex.java
Author: Brandon Troisi
Date: 10/11/2016

*/

import java.awt.Graphics;
import java.awt.Color;

public class PathVertex extends Agent{
	//Represents path vertex


	
	public PathVertex(int r, int c){
		//Constructor
	
		super(r,c);
		
	}
	
	public void drawRect(Graphics g, int gridScale){
		//Draws path vertex
		g.setColor(Color.blue);
		int xpos=this.getCol()*gridScale;
		int ypos=this.getRow()*gridScale;
		g.drawRect(xpos,ypos,gridScale,gridScale);
		
		
	
	}
	
	public void drawRectandLine(Graphics g, int gridScale, int vrow, int vcol){
		//Draws line in between each path vertex
	
		g.setColor(Color.blue);
		int xpos=this.getCol()*gridScale;
		int ypos=this.getRow()*gridScale;
		g.drawRect(xpos,ypos,gridScale,gridScale);
		g.drawLine(vcol+gridScale/2,vrow+gridScale/2,xpos+gridScale/2,ypos+gridScale/2);
		
	
	
	}
	


}