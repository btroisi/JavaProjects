/*
Title:HuntTheWumpus
Author: Brandon Troisi
Date: 12/7/16
*/

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.Point;

import javax.imageio.ImageIO;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputAdapter;

import java.util.*;


public class HuntTheWumpus{
	//Represents a Hunt the Wumpus game
	//Where you are hunter and you have to explore caves to try and find monster called wumpus
	//All you have to kill the wumpus is one arrow 
	
	
	private JPanel canvas;
	private int height;
	private int width; 
	private Hunter hunter;
	private Wumpus wumpus; 
	private JLabel textMessage;
    private Landscape scape;
    private LandscapeDisplay display;
    private Graph graph; 
    

	// controls whether the simulation is playing or exiting
	// Enumerated types show different playstates of game 
	//PlayStates are PLAY,STOP,NONE
	//During PLAY, game runs, During  STOP exits program, during run game is not
	//running, but program is still running
	private enum PlayState { PLAY, STOP, NONE }
	private PlayState state= PlayState.PLAY;

	/**
		 * Creates the main window
		 * @param height the height of the window in pixels
		 * @param width the width of the window in pixels
		 **/		 

	public HuntTheWumpus(int row, int col){
	
		//Creates new landscape, landscape display, canvas
		this.scape = new Landscape(row,col);
		this.display = new LandscapeDisplay(scape,75); 
		this.canvas = new JPanel( new FlowLayout(FlowLayout.RIGHT));
		
		//Adds control and key listener
		Control control = new Control(); 
		this.display.addKeyListener(control);
		this.display.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		
		//Creates buttons for quit and reset and adds them to screen
		JButton quit = new JButton("Quit"); 
		JButton reset = new JButton("Reset"); 
		quit.addActionListener(control);
		reset.addActionListener(control); 
		canvas.add(quit);
		canvas.add(reset); 
		
		//Adds message "Welcome to Hunt the Wumpus!" to screen
		this.textMessage = new JLabel ("Welcome to Hunt the Wumpus!"); 
		canvas.add(textMessage); 
		
		//Need these to create display
		this.display.add(this.canvas, BorderLayout.SOUTH);
		this.display.pack();
		this.display.setVisible(true);
		this.display.setFocusable(true);
		this.display.requestFocus(); 
		
		//Creates graph and creates new Hunt The Wumpus game
		this.graph = new Graph();
		createGame(8,8); 
		
	}
	
	
	
	public void createGame(int row, int col){
		//Creates a new HuntTheWumpus game by creating landscape, landscape display
		//and adding vertex objects, hunter, and wumpus to landscape
		//Hunter starts game at (0,0) and wumpus is at a random location on the landscape
		//Game is set on an 8x8 grid of vertex objects
		
		scape = new Landscape(row,col);
		if( display==null ){
			display = new LandscapeDisplay(scape,75);
		}
		
		else{
			display.setLandscape(scape); 
		}
	
		Vertex[][] array = new Vertex[8][8];
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				array[i][j] = new Vertex(i,j); 
				if(i!=0){
					graph.addEdge(array[i][j],Vertex.Direction.NORTH,array[i-1][j]);
				}
				if(j!=0){
					graph.addEdge(array[i][j],Vertex.Direction.WEST, array[i][j-1]); 
				}
			}	
			
		}
		
		for(Vertex v: graph.getVerticies()){
			this.scape.addBackGroundAgent(v);
			v.setVisible(false); 
		}
	
		hunter = scape.getHunter(); 
		wumpus = scape.getWumpus(); 
		Graphics g = canvas.getGraphics();
		
		Random gen = new Random();
		
		scape.addForegroundAgent(hunter);
		scape.addForegroundAgent(wumpus); 
		hunter.setLocation(array[0][0]);
		wumpus.setLocation(array[gen.nextInt(8)][gen.nextInt(8)]); 
		graph.shortestPath(wumpus.getLocation()); 
		hunter.getLocation().setVisible(true); 
	}
	
	private class Control extends KeyAdapter implements ActionListener {
		//This allows you to control the game using WASD and the spacebar
	
		public void popUpMessage(String s){
			//Displays a Pop-up message containing string s
			//Sets playState to NONE, which game is no longer played
			//but the screen is still displaying
			JPanel popupWindow = new JPanel();
			popupWindow.setSize(200,150);
			popupWindow.setLocation(width/2-100,height/2);
			JOptionPane.showMessageDialog(popupWindow,s);
			state = PlayState.NONE;
		}
	
		public void win(){
			//If player wins the game, popupMessage appears that you shot the wumpus
			//you win the game
			wumpus.setVisible(true);
			wumpus.setWumpusVictoryState(false);
			wumpus.getLocation().setVisible(true);  
			popUpMessage("You shot the wumpus! You win!");
			
		}
		
		
		
		public void loseByShooting(){
			//If player loses the game when he tries to shoot the wumpus
			//a pop up message appears that says you failed to shoot the wumpus
			//you lose
			wumpus.setVisible(true); 
			wumpus.setWumpusVictoryState(true); 
			hunter.setVisible(false); 
			wumpus.getLocation().setVisible(true); 
			popUpMessage("You failed to shoot the wumpus! You lose!");
			 
		}
		
		
		
        public void keyTyped(KeyEvent e) {
        	//Allows you to connect key board commands to movements of the game
			
			System.out.println( "Key Pressed: " + e.getKeyChar() );
			
			
			if(state == PlayState.PLAY){
				//If game is in PLAY mode
				if(("" + e.getKeyChar()).equalsIgnoreCase(" ") ){
					//If spacebar is pressed
					if(!hunter.getAimState()){
						//If hunter's aimState is false (hunter is not aiming)
						//Set aimState to true (arm the hunter)
						hunter.setAimState(true); 
						System.out.println("Ready to fire");
					}
					else{
						//Otherwise if hunter is not aiming to shoot wumpus
						//Set aimState to false (disarm hunter)
						hunter.setAimState(false);  
						System.out.println("You are now disarmed"); 
					}
				}
					
				else if( ("" + e.getKeyChar()).equalsIgnoreCase("w") ){
					//If w is pressed and the aimState of the hunter is false, hunter moves NORTH
					//If aimState of hunter is true, hunter shoots to the NORTH
					//If hunter shoots at wumpus successfully in northern direction from one
					//vertex away, hunter wins the game. Otherwise, hunter misses wumpus and loses the game
					//If there is no northern vertex for the hunter to move to, the hunter panics,
					//arms himself (aimState is set to true) and tries to shoot the wumpus. 
					//As a results you lose the game
					Vertex move = hunter.getLocation().getNeighbor(Vertex.Direction.NORTH);
					if(move == null){
						popUpMessage("You can't explore outside the cave! \n You will panic and try to shoot the wumpus! \n The wumpus will find you!");
						
					}
					
					if(!hunter.getAimState()&& move!=null){
						//If hunter is not in shooting mode
						System.out.println("Moving up");
						hunter.setVisible(true);
						move.setVisible(true);
						hunter.setLocation(move);
					}
					
					else{
						//If the hunter is in shooting mode
						Vertex nNeighbor = hunter.getLocation().getNeighbor(Vertex.Direction.NORTH); 
						if(nNeighbor == wumpus.getLocation()){
							win();		
						}
						else if(nNeighbor != wumpus.getLocation()){
							loseByShooting();	
						
						}
					}
				}
		
				else if( ("" + e.getKeyChar()).equalsIgnoreCase("s") ){
					//If s is pressed and the aimState of the hunter is false, hunter moves SOUTH
					//If aimState of hunter is true, hunter shoots to the SOUTH
					//If hunter shoots at wumpus successfully in northern direction from one
					//vertex away, hunter wins the game. Otherwise, hunter misses wumpus and loses the game
					//If there is no northern vertex for the hunter to move to, the hunter panics,
					//arms himself (aimState is set to true) and tries to shoot the wumpus. 
					//As a results you lose the game
					Vertex move = hunter.getLocation().getNeighbor(Vertex.Direction.SOUTH);
					if(move == null){
						popUpMessage("You can't explore outside the cave! \n You will panic and try to shoot the wumpus! \n The wumpus will find you!");
					}
					if(!hunter.getAimState()&& move!=null){
						//If hunter is not in shooting mode
						System.out.println("Moving down");
						move.setVisible(true);
						hunter.setLocation(move);
					}
					
					else{
						//If the hunter is in shooting mode
						Vertex sNeighbor = hunter.getLocation().getNeighbor(Vertex.Direction.SOUTH);
						
						if(sNeighbor == wumpus.getLocation()){
							win();	  	
						}
						
						else if(sNeighbor != wumpus.getLocation()){
							loseByShooting();	
						}
						
					}
				}
		
				else if( ("" + e.getKeyChar()).equalsIgnoreCase("a") ){
					//If a is pressed and the aimState of the hunter is false, hunter moves WEST
					//If aimState of hunter is true, hunter shoots to the WEST
					//If hunter shoots at wumpus successfully in northern direction from one
					//vertex away, hunter wins the game. Otherwise, hunter misses wumpus and loses the game
					//If there is no northern vertex for the hunter to move to, the hunter panics,
					//arms himself (aimState is set to true) and tries to shoot the wumpus. 
					//As a results you lose the game
					Vertex move = hunter.getLocation().getNeighbor(Vertex.Direction.WEST);
					if(move == null){
						popUpMessage("You can't explore outside the cave! \n You will panic and try to shoot the wumpus! \n The wumpus will find you!");
					}
					if(!hunter.getAimState()&&move!=null){
						//If hunter is not in shooting mode
						
						System.out.println("Moving left");
						move.setVisible(true);
						hunter.setLocation(move);
					
					}
					else{
						//If the hunter is in shooting mode
						Vertex wNeighbor = hunter.getLocation().getNeighbor(Vertex.Direction.WEST);
						
						if(wNeighbor == wumpus.getLocation()){
							win();
						}
						else if(wNeighbor != wumpus.getLocation()){
							loseByShooting();
						}
					}
				}
		
				else if( ("" + e.getKeyChar()).equalsIgnoreCase("d") ){
					//If s is pressed and the aimState of the hunter is false, hunter moves EAST
					//If aimState of hunter is true, hunter shoots to the EAST
					//If hunter shoots at wumpus successfully in northern direction from one
					//vertex away, hunter wins the game. Otherwise, hunter misses wumpus and loses the game
					//If there is no northern vertex for the hunter to move to, the hunter panics,
					//arms himself (aimState is set to true) and tries to shoot the wumpus. 
					//As a results you lose the game
					Vertex move = hunter.getLocation().getNeighbor(Vertex.Direction.EAST);
					if(move == null){
						popUpMessage("You can't explore outside the cave! \n You will panic and try to shoot the wumpus! \n The wumpus will find you!");
						
					}
					if(!hunter.getAimState()&&move!=null){
						//If hunter is not in shooting mode
						
						move.setVisible(true);
						System.out.println("Moving right");
						hunter.setLocation(move);
					
					}
					else{
						//If the hunter is in shooting mode
						Vertex eNeighbor = hunter.getLocation().getNeighbor(Vertex.Direction.EAST);
						
						if(eNeighbor == wumpus.getLocation()){
							win();
						}
						else if(eNeighbor != wumpus.getLocation()){
							loseByShooting();
				
						}
					
		
					}
				}
				
				if(hunter.getLocation()==wumpus.getLocation()){
					//If hunter's location is the same as the wumpus's location
					//Wumpus kills hunter and loses the game
					
					wumpus.setVisible(true);
					wumpus.setWumpusVictoryState(true);
					hunter.setVisible(false);
					popUpMessage("You stumbled into the wumpus's lair! You lose!"); 
					state = PlayState.NONE; 
					
				
				}
			
			
			}
				
		}
		
		
        
        public void actionPerformed(ActionEvent event){
        	//Allows you to attach commands to buttons on screen
			if(event.getActionCommand().equalsIgnoreCase("quit")){
				//If you hit the quit button, game stops playing and program exits
				state=PlayState.STOP;
				System.exit(0); 
				 
			}
			else if(event.getActionCommand().equalsIgnoreCase("reset")){
				//If you hit the reset button, game is reset
				createGame(8,8); 
				state=PlayState.PLAY; 
				display.requestFocus();
				display.update();
				
				
			}
		}
	
    }

	public void iterate(Graphics g) throws InterruptedException {
		//Draws landscape, repaints display, and sleeps for 33 ms
		this.scape.draw(g,100); 
		this.display.repaint();
		Thread.sleep(33); 
	
	}


	public static void main(String[] argv) throws InterruptedException {
		//Creates new hunt the wumps game
		HuntTheWumpus hw = new HuntTheWumpus( 8,8 );
		Graphics g = hw.canvas.getGraphics();
		while(hw.state != PlayState.STOP) {
			//While playstate is not STOP, game is still running
			hw.iterate(g);
		}
		hw.display.dispose();
	}
}