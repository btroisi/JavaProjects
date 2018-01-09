/*
Filename: CategorizedGrouper.java
Author: Brandon Troisi
Date: 10/4/2016

*/

import java.util.Random;

public class CategorizedGrouper extends Grouper{

	private int cat;
	
	
	public CategorizedGrouper(double x0, double y0, int cat){
	
		Gropuper();
		this.cat=cat
	
	}
	
	public int getCategory(){
		return this.cat
	
	}
	
	public String toString(){
		return String(this.getCategory);
	
	}
	
	public void updateState(Landscape scape){
		Random rando = new Random();
		if(scape.getNeighbors.get(i).getCat.equals(this.getCategory)){
		
			float r = rando.nextFloat();
			
			if(rando.nextFloat()<=0.01){
				if(rando.nextFloat()<=0.5){
					this.setX(this.getX()+ 5.0*r);
					this.setY(this.getY()+ 5.0*r);
			
				}
				
				else{
					this.setX(this.getX()- 5.0*r);
					this.setY(this.getY()- 5.0*r);
				
				}
			}	
		
		
		
		}
		
	
		else{
			
			float r = rando.nextFloat();
			
			if(rando.nextFloat()<=0.5){
					this.setX(this.getX()+ 5.0*r);
					this.setY(this.getY()+ 5.0*r);
			
			}
				
				else{
					this.setX(this.getX()- 5.0*r);
					this.setY(this.getY()- 5.0*r);
				
				}
			
			
		}
	
	}

	public static void main(String args[]){
	
		CategorizedFrouper cg = new CategorizedFrouper();
		System.out.println(cg.getCategory());
		System.out.println(cg.toString());
		
	
	
	
	}






}