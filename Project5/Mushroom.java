/*
Filename: Mushroom.java
Author: Brandon Troisi
Date: 10/11/2016

*/

import java.awt.Graphics;
import java.awt.Color;

public class Mushroom extends Agent{
	//Creates mushroom class extending agent

	private int r;
	private int c;
	private int size;
	
	public Mushroom(int r, int c){
		//Sets row and col positions for mushroom and initializes size to 0
		super(r,c);
		this.size=0;
	
	
	}
	
	public int getSize(){
		//Returns size of mushroom
		return size;
	}
	
	public void grow(){
		//Grows mushroom
		size++;
		
	}
	
	public void shrink(){
		//Shrinks mushroom until size is 0
		if(size>0){
			size--;
		
		}
		
	}
	
	public void die(){
		//Kills mushroom by setting its size to 0
		this.size=0;
	}
	
	public String toString(){
		//Returns string which indicates size of mushroom
		String s= "The size of the mushroom is " + size;
		return s;
	}
	
	public void draw(Graphics g, int gridScale) {
		//Draws mushroom
        if (this.size == 0) {
            return;
        }
        int xpos = this.getCol()*gridScale; // upper left corner of grid square.
        int ypos = this.getRow()*gridScale; // upper left corner of grid square.
        g.setColor( new Color( 0.87f, 0.72f, 0.53f ) );
        g.fillOval( xpos-this.size/2+gridScale/2, ypos-this.size/2+gridScale/2, this.size, this.size );
    }
    
 	public static void main(String args[]){
 		//Creates mushroom at (5,4), grows, shrinks, and kills mushroom
 	
 		Mushroom m = new Mushroom(5,4);
 		System.out.println(m.toString());
 		m.grow();
 		System.out.println("After growing " + m.toString());
 		m.shrink();
 		System.out.println("After shrinking " + m.toString());
 		m.shrink();
 		System.out.println("After shrinking a mushroom of size 0 " + m.toString());
 		m.grow();
 		m.grow();
 		System.out.println("After growing mushroom twice " +m.toString());
 		m.die();
 		System.out.println("Dead mushroom " + m.toString());
 	
 	
 	}   
    
}
    