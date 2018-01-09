/*
Filename: SuperSim.java
Author: Brandon Troisi
Date: 10/4/2016

*/

import java.util.Scanner;
import java.awt.Color; 
import java.util.Random;

public class SuperSim{
	//Combines all GrouperSimulations into one class

	public void GrouperSim(){
		//Runs GrouperSimulation
	
		
	
		Landscape scape = new Landscape(10,10);
        
        Random rando = new Random();
        
        for (int i = 0; i < 200; i++) {
           
           Grouper a = new Grouper((double)rando.nextInt(10),(double)rando.nextInt(10));
           scape.addAgent(a);
        }

        LandscapeDisplay display = new LandscapeDisplay(scape, 4);

		

 		for(int i=0; i<30; i++){
 		
            scape.updateAgents();
 			display.repaint();
 			
 			
 			try{
 				Thread.sleep(250);
 			}
 			
 			catch(InterruptedException e){
 			
 			}
	
 		}
	
 	}
	
	
	
	public void CatSim(){
		//Runs categorizedGrouperSimulation
	
		Landscape scape = new Landscape(100,100);
        
        Random gen = new Random();
        
        for (int i = 0; i < 200; i++) {
           
           CategorizedGrouper a = new CategorizedGrouper((double)gen.nextInt(10),(double)gen.nextInt(10),1);
           scape.addAgent(a);
           CategorizedGrouper b = new CategorizedGrouper((double)gen.nextInt(10),(double)gen.nextInt(10),2);
           scape.addAgent(b);
           CategorizedGrouper c = new CategorizedGrouper((double)gen.nextInt(10),(double)gen.nextInt(10),3);
           scape.addAgent(c);
        }

        LandscapeDisplay display = new LandscapeDisplay(scape, 4);

		

 		for(int i=0; i<30; i++){
 		
            scape.updateAgents();
 			display.repaint();
 			
 			
 			try{
 				Thread.sleep(250);
 			}
 			
 			catch(InterruptedException e){
 			
 			}

 		}
	
	}
	
	public void ColorSim(){
		//Runs ColorGrouperSimulation
	
		Landscape scape = new Landscape(100,100);
        
        Random gen = new Random();
        
        for (int i = 0; i < 200; i++) {
           
           ColorGrouper a = new ColorGrouper((double)gen.nextInt(10),(double)gen.nextInt(10),Color.blue);
           scape.addAgent(a);
           ColorGrouper b = new ColorGrouper((double)gen.nextInt(10),(double)gen.nextInt(10),Color.green);
           scape.addAgent(b);
           ColorGrouper c = new ColorGrouper((double)gen.nextInt(10),(double)gen.nextInt(10),Color.red);
           scape.addAgent(c);
        }

        LandscapeDisplay display = new LandscapeDisplay(scape, 4);

		

 		for(int i=0; i<30; i++){
 		
            scape.updateAgents();
 			display.repaint();
 			
 			
 			
 			try{
 				Thread.sleep(250);
 			}
 			
 			catch(InterruptedException e){
 			
 			}
 		
 		
 		}
 		
	
	}
	
	public void FilledSim(){
		//Runs FilledGrouper Simulation
	
		Landscape scape = new Landscape(10,10);
        
        Random gen = new Random();
        
        for (int i = 0; i < 200; i++) {
           
           FilledGrouper t = new FilledGrouper((double)gen.nextInt(10),(double)gen.nextInt(10),true);
           scape.addAgent(t);
           FilledGrouper f = new FilledGrouper((double)gen.nextInt(10),(double)gen.nextInt(10),false);
           scape.addAgent(f);
           
        }

        LandscapeDisplay display = new LandscapeDisplay(scape, 4);

		

 		for(int i=0; i<30; i++){
 		
            scape.updateAgents();
 			display.repaint();
 			try{
 				Thread.sleep(250);
 			}
 			
 			catch(InterruptedException e){
 			
 			}
 		
 		}
 			
	
	}
	

	public static void main(String args[]) {
		//Uses user input to choose which grouper simulation to run
	
		SuperSim sm = new SuperSim();
		Scanner sc = new Scanner(System.in); 
		System.out.println("Hello, welcome to grouper simulation");
		System.out.println("Please choose between 4 agent types: Grouper, Categorized, Color and Filled: ");
		String choice = sc.nextLine();
		
		if(choice.equalsIgnoreCase("Grouper")){
			sm.GrouperSim();
			
		}
		
		else if(choice.equalsIgnoreCase("Categorized")){
			sm.CatSim();
			
		}
		
		else if(choice.equalsIgnoreCase("Color")){
			sm.ColorSim();
		}
		
		else if(choice.equalsIgnoreCase("Filled")){
			sm.FilledSim();
		}
	}
}

