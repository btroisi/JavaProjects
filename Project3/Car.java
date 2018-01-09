/**
* File: Car.java
* Author: Brandon Troisi
* Date 09/27/2016
*/

import java.awt.Color;
import java.awt.Graphics;


public class Car{
	//Stores car's color, what time it wants to retrieved from parking garage

	private Color color;
	private int timeToLeave;

	public Car(int timeToLeave){
		//Constructor method sets default time for car to leave and default color for car
		timeToLeave=0;
		this.color = Color.red;
	}
		
	public Car(int timeToLeave, Color color){
		//Constructor method
		this.timeToLeave = timeToLeave;
		this.color = color;


	}
	
	public int getTimetoLeave(){
		//Returns time car wants to be retrieved from garage
		return timeToLeave;
	
	}
	
	public String toString(){
		//Returns string indicates what color car is and when it wants to be retrieved
		String s = "";
		s+="The car is " + this.color + " and will be retrieved at " + timeToLeave;  
		return s;
	}
	
	public void draw(Graphics g, int x, int y, int w,int h){
		//Draws car
	
		g.setColor(this.color);
		g.fillRect(x,y,w,h);
	}
	
	public static void main(String[] args){
		//Creates 2 car objects, prints color of each car and what time it wants to leave garage
		Car c1 = new Car(1,Color.green);
		Car c2 = new Car(2,Color.yellow);
		System.out.println(c1.getTimetoLeave());
		System.out.println(c1.toString());
		System.out.println(c2.getTimetoLeave());
		System.out.println(c2.toString());
	
	
	
	}

}