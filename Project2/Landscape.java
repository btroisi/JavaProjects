/**
 * File: Landscape.java
 * Author: Brandon Troisi
 * Date: 09/20/2016
 */
 
 import java.lang.Math;
 import java.util.ArrayList;
 import java.awt.Graphics;
 import java.util.Random;
 
 
 public class Landscape{
 	//Holds 2D grid Cell object references
 	
 	private int rows;
 	private int cols;
 	Cell[][] grid = new Cell[rows][cols];
 	
 	public Landscape( int rows, int cols ){
 		//Sets number of rows and columns to specified values and allocates grid of Cell references
 	
 		Random rand = new Random();
 		this.rows=rows;
 		this.cols=cols;
 		grid = new Cell[this.rows][this.cols];
 		for(int i=0; i<this.rows; i++){
 			for(int j=0; j<this.cols;j++){
 				//grid[i][j]=new Cell();
 				grid[i][j]=new Cell(rand.nextBoolean());
 				
 			}
 		
 		}	
 	
 	}
 	
 	
 	public void reset(){
 		//Sets all cells to be dead
 	
 		for(int i=0;i<this.rows;i++) {
 			for(int j=0;j<this.cols;j++){
				grid[i][j].setAlive(false);
			}
		}
 		
 	
 	}
 	
 	public int getRows(){
 		//Returns number of rows of grid
 		return this.rows;
 	
 	}
 	
 	public int getCols(){
 		//Returns number of columns of grid
 		return this.cols;
 		
 	}
 	
 	public Cell getCell(int row, int col ){
 		//Returns reference to Cell located at position (row,col)
 		return grid[row][col];	
 	
 	}
 	
 	
 	public String toString(){
 		//Represents landscape of cell objects as a string
 		String s = "";
 		
 	
 		for(int i=0; i<this.rows;i++){
 			for(int j=0; j<this.cols;j++){
 					
 				s+= grid[i][j];
 					
 			}
		
 		s+= "\n";
 		}
 		
 		
 		return s ;
 		
 	}
 	
 	public ArrayList<Cell> getNeighbors( int row, int col ){
 		//Returns list of references of alive neighbors of the cell at location (row,col)
 		
 	
 		ArrayList<Cell> neighbor = new ArrayList<Cell>();
 		for(int i=Math.max(0,row-1); i<= Math.min(this.rows-1,row+1);i++){
 			for(int j=Math.max(0,col-1); j<= Math.min(this.cols-1,col+1);j++){
 				
 				if(!(i==row && j==col)){
 					if(grid[i][j].getAlive()){;
 						neighbor.add(grid[i][j]);
 						//System.out.println(Integer.toString(i)+" " +Integer.toString(j));
 						
 					}
 				}
 			}
 		
 		}
 		return neighbor;
 	}
 	
 	public void draw(Graphics g, int gridScale){
 		//draw all the cells
 		for( int i=0; i<this.getRows(); i++){
 			for( int j=0; j<this.getCols(); j++){
 				this.grid[i][j].draw(g, i*gridScale, j*gridScale, gridScale);
 			}
 			
 		}
 		
 	}
 	
 	public void advance(){
 		//Moves all cell forward one generation
 	
 		Cell[][] tempgrid = new Cell[this.rows][this.cols];
 		for(int i=0; i<this.rows; i++){
 			for(int j=0; j<this.cols;j++){
 				tempgrid[i][j]=new Cell(grid[i][j].getAlive());
 				
 				
 			}
 		
 		}	
 		
 		for(int i=0; i<this.rows; i++){
 			for(int j=0; j<this.cols;j++){
 				tempgrid[i][j].updateState(getNeighbors(i,j));
 				
 				
 			}
 		
 		}	
 		
 		grid=tempgrid;
 	
 	}

 	
 	public static void main(String[] args){
 		//Creates 5x5 landscape, prints the landscape, prints alive state for cell at (3,3) 
 		//Also prints neighbors of Cell object at (3,3), rows and columns of grid.
 		//Also prints the result of advancing all the cells one generation.
 	
 		Landscape l = new Landscape(5,5);
 		
 		System.out.println(l);
 		System.out.println(l.getNeighbors(3,3));
		System.out.println(l.getCell(3,3));
 		System.out.println(l.getRows());
  		System.out.println(l.getCols());
		l.advance();
		System.out.println(l);
 		
 	}
 	
 	
 }
 
 
 
 
 
 
 
 
 