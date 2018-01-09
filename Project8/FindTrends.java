/*
Author: Brandon Troisi
File: FindTrends.java
Date:11/27/16

*/

import java.util.ArrayList;
import java.io.IOException; 

public class FindTrends{
	//Finds frequency of series of words in reddit posts 2008-2015 that are input in command line

	private ArrayList<String> files;
	private ArrayList<String> words;
	
	public FindTrends(){
		//Constructor
		this.files = new ArrayList<String>();
		this.words = new ArrayList<String>();

	}
	
	public ArrayList<String> getFileNames(){
		//Returns list of filenames for which we find frequency of particular words in
		return this.files;
	}
	
	public ArrayList<String> getWords(){
		//Returns list of words for which we want to find frequency for in particular files
		return this.words; 
	}

	public void loadWords(String[] args){
		//Adds words from command line to list of words for which we want to find frequency for in particular files
		for(int i = 3; i<args.length; i++){
			words.add(args[i]);
		}
	
	}
	
	public void loadFilenames(String[] args){
		//Adds filenames in command line to list of files for which we want to find frequency of particular words in
		String base = args[0];
		int start = Integer.parseInt(args[1]);
		int end = Integer.parseInt(args[2]);
		for(int i = start; i<=end; i++){
			
			String filename = base + i + ".txt";
			this.files.add(filename);
		}
	
	}
	
	public void getFrequency(WordCounter wc, String word){
		//Returns frequency of a particular word
		System.out.print(wc.getFrequency(word) + " ");
	}
	

	public void wordFreqs() throws IOException{
		//Returns frequency of words in command line in files specified in the command line
		for(int i=0; i<this.words.size(); i++){
			System.out.println(this.words.get(i) + " ");
			for(int j=0; j<this.files.size(); j++){
				WordCounter wc = new WordCounter();
				wc.readWordCountFile(this.files.get(j)); 	
				this.getFrequency(wc, this.words.get(i));	
				System.out.println(files.get(j));
			}
			System.out.println(" ");
		}

	}
	public static void main(String[] args) throws IOException{
		//Find frequency of words in command line in files specified in command line
		//by calling loadFilenames, loadWords, and wordFreqs methods
		FindTrends ft = new FindTrends();
		ft.loadFilenames(args);
		ft.loadWords(args);
		ft.wordFreqs(); 
		
		
	}

}