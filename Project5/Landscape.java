/*
Filename: Landscape.java
Author: Brandon Troisi
Date: 10/11/2016

*/

import java.util.Random;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Landscape{
	//Represents landscape that can hold mushrooms, gatherer, and path verticies

	private int rows;
	private int cols;
	private int numGrowthPatches;
	private int numPathVerticies;
	private Random gen;
	private Mushroom[][] grid;
	private ArrayList<FertileGround> growthPatches;
	private LinkedList<PathVertex> path;
	private Gatherer gatherer;
		
	public Landscape(int rows, int cols, int numGrowthPatches, int numPathVerticies){
		//Constructor
	
		this.rows=rows;
		this.cols=cols;
		this.numGrowthPatches=numGrowthPatches;
		this.numPathVerticies=numPathVerticies;
		this.growthPatches = new ArrayList<FertileGround>(numGrowthPatches);
		int stride = cols/numGrowthPatches;
		this.path = new LinkedList<PathVertex>();
		stride=cols/numPathVerticies;
		this.gatherer = new Gatherer(0,0);
		
		Random gen = new Random();
		
		grid = new Mushroom[this.rows][this.cols];
		for(int i=0; i<this.rows;i++){
			for(int j=0; j<this.cols;j++){
				//creates mushrooms at every position on grid
			
				grid[i][j]= new Mushroom(i,j);
			
			}
 		
 		}	
 		
 		for( int i=0; i<this.numGrowthPatches; i++){
 			//Adds growth patches to landscape
 		
 			this.growthPatches.add(new FertileGround(rows/2-rows/6,i*stride+gen.nextInt(3*stride/4)));
 		
 		
 		}
 		
 		for(int i=0; i<this.numPathVerticies; i++){
 			//Adds path vertices to landscape
 		
 			this.path.add(new PathVertex(rows/2-rows/6,i*stride+stride/2));
 		
 		}
 		
 		

 		
	}
	
	public int getRows(){
		//Returns rows of landscape
		return this.rows;
	
	}
	
	public int getCols(){
		//Returns cols of landscape
		return this.cols;
	
	}
	
	public Mushroom getMushroom(int row, int col){
		//Returns reference to mushroom located at (row, col)
		
		return grid[row][col];
	
	}
	
	public String toString(){
		//Returns string indicates rows and cols of landscape
		String s = "Dimensions of landscape: " + this.rows + " rows and "+ this.cols + " columns ";
		return s; 
	
	}
	
	public void draw(Graphics g, int gridScale){
 		//draw all the mushrooms
 		for( int i=0; i<this.getRows(); i++){
 			for( int j=0; j<this.getCols(); j++){
 				this.grid[i][j].draw(g,gridScale);
 			}
 			
 		}
 		
 		//Draw fertile ground patches
 		for(int k=0; k<this.growthPatches.size(); k++){
 		
 			this.growthPatches.get(k).draw(g,gridScale);
 			
 		
 		}
	
		//Draw path vertex with line in between
		
		ArrayList<PathVertex> pathway = this.path.toArrayList();
		pathway.get(0).drawRect(g,gridScale);
		for(int l=1; l< pathway.size(); l++){
			int vrow = pathway.get(l-1).getRow()*gridScale;
			int vcol = pathway.get(l-1).getCol()*gridScale;
			
			pathway.get(l).drawRectandLine(g, gridScale, vrow, vcol);
		}
		
		
		
		//Draw gatherer
		
		this.gatherer.draw(g,gridScale);
 		
 	}
 	
 	
 	public void growMushrooms(int numTries){
 		//Grows mushroom numTries times 
 		//Grows mushroom based on distance from nearest growth patch
 		//Mushroom size is inversely proportional to distance from nearest growth patch
 	
 		Random gen = new Random();
 		
 		for(int i=0; i<numTries; i++){
 			
 			int r = gen.nextInt(this.rows);
 			int c = gen.nextInt(this.cols);
 			double d = this.findDistanceToNearestGrowthPatch( r, c );
        	double probability = 1/d; 
        	if ( gen.nextDouble() < probability ) {
            		this.grid[r][c].grow();
            }
            		      
        }
        
    }
 	
 	
 	
 	
 	public double findDistanceToNearestGrowthPatch(int row, int col){
 		//Finds smallest distance from location (row,col) to nearest growth patch
 	
 		double smallest = this.getRows();
 		for(int i=0; i<growthPatches.size(); i++){
 			
 			int row1 = this.growthPatches.get(i).getRow();
 			int col1 = this.growthPatches.get(i).getCol();
 			double dist = Math.sqrt((row1-row)*(row1-row)+(col1-col)*(col1-col));
 			
 			if(dist<smallest){
 			
 				smallest = dist; 
 			}
 			
 			
 		}
 		
 		return smallest;
 		
 	}
 	
 	public Iterator<PathVertex> getPathIterator(){
 		//Forward iterator
 		
 		return this.path.iterator();
 	}
 	
 	public Iterator<PathVertex> getPathBackwardIterator(){
 		//Backward iterator
 	
 		return this.path.backward_iterator();
 	}
 
 
 	public Gatherer getGatherer(){
 		//Gets gatherer
 	
 		return this.gatherer;
 	
 	}

 		
	public static void main(String args[]){
	
		//Creates 20x20 landscape with 5 growth patches and 5 path verticies
		//Gets reference to mushroom at (5,3)
		//Finds distance to nearest growth patch at (5,5), (1,2), and (3,7)
	
		Landscape scape = new Landscape(20,20,5,5);
		System.out.println(scape.toString());
		System.out.println("At (5,3) " + scape.getMushroom(5,3));
		System.out.println("The nearest growth patch to (5,5) is " + scape.findDistanceToNearestGrowthPatch(5,5) + " away");
		System.out.println("The nearest growth patch to (1,2) is " + scape.findDistanceToNearestGrowthPatch(1,2)+ " away");
		System.out.println("The nearest growth patch to (3,7) is " + scape.findDistanceToNearestGrowthPatch(3,7)+" away");
	
	}
	
}