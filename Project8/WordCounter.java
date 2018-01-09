/*
Author: Brandon Troisi
File: WordCounter.java
Date:11/27/16

*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;



public class WordCounter{
	//Counts number of words in a text document

	private int totalWordCount;
	private BSTMap<String,Integer> map;
	
	
	
	public WordCounter(){
		//Constructor
		this.totalWordCount = 0;
		this.map = new BSTMap<String,Integer>(new AscendingStringComparator());
		
	}
	
	public void clear(){
		//Clears BSTMap 
		this.map.clear();
		this.totalWordCount=0;
	}
	
	public void loadFromOriginalWordsFile(String filename) throws IOException{
		//Generates BSTMap of words after reading a file
		this.clear();
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line = br.readLine();
		while(line!=null){
			//While there is a line to read
			String[] parse = line.split("[^a-zA-Z']+");// Regular expressions!
        	for (int i = 0; i < parse.length; i++){
        		// split line into words. Any character other than a letter (a-z and A-Z) or a single quote
        		// is considered a non-word character and is used to split words.
            	String word = parse[i].trim().toLowerCase().replace("'"," ");
            	Integer wordExists = this.map.get(word);
            	if(wordExists != null){
            		//If the word that reader read already exists
            		//This word is put on map and value associated with word increases by 1
            		//every time the reader reads this word
            		map.put(word,wordExists+1); 
            	}
            	else{
            		//Otherwise, if the word that the reader reads is a new word
            		//This word is put on map and value associated with word is 1
            		map.put(word,1);		
            	}
            	this.totalWordCount++;
        	}
        	line = br.readLine();
        }
       
        
	}

	public int getTotalWordCount(){
		//returns total word count
		return this.totalWordCount;
	}
	
	public int getCount(String word){
		//Returns value associated with word
		if(this.map.get(word)!=null){
			return this.map.get(word);
		}
		return 0;
	
	}

	public double getFrequency(String word){
		//Returns frequency of word which is value of associated word divided by total word count		
		if(this.map.get(word)!=null){
			
			double freq = (double)this.map.get(word)/(double)this.totalWordCount;
			return freq;
			
		}
		return 0.0;
	}
	
	public void writeWordCountFile(String filename) throws IOException{
		//Writes word count file that shows each unique word
		//and how many times each unique word appeared in a file
		FileWriter fw = new FileWriter(filename);
		BufferedWriter writer = new BufferedWriter(fw);
		
		writer.write("total_word_count: " + this.totalWordCount + "\n");
		writer.write("number of unique words: " + this.map.size() + "\n");
		
		ArrayList<KeyValuePair<String,Integer>> pairs = map.getPairs();
		for(KeyValuePair<String,Integer> pair: pairs){
			writer.write(pair.getKey()+ " " + pair.getValue()+"\n");
		}
		writer.close();
		System.out.println("The results have been printed out in " + filename);
	}
	
	public void writeRelevantWordCountFile(String filename) throws IOException{
		//Writes word count file that shows each unique word
		//and how many times each unique word appeared in a file
		//However, only words that are deemed relevant put in BSTMap
		//Relevant means that a unique word that appeared more than 5 times in a file 
	
		FileWriter fw = new FileWriter(filename);
		BufferedWriter writer = new BufferedWriter(fw);
		
		writer.write("total_word_count: " + this.totalWordCount + "\n");
		writer.write("number of unique words: " + this.map.size() + "\n");
		
		ArrayList<KeyValuePair<String,Integer>> pairs = map.getPairs();
		
		int relevantWords = 0; 
		for(int i=0; i<pairs.size(); i++){
			if(pairs.get(i).getValue()<5){
				continue;
			}
			
			writer.write(pairs.get(i).toString()+"\n");
			relevantWords++;
			
		}
		writer.write("total_relevant_words: " + relevantWords + "\n");
		writer.close();
		System.out.println("The results have been printed out in " + filename);
	}
	
	public void readWordCountFile(String wordCountfilename) throws IOException{
		//Reads wordCount file and reconstructs BSTMap for that wordCount file
	
		BufferedReader br = new BufferedReader(new FileReader(wordCountfilename));
		String line = br.readLine();
		while(line!=null){
			String[] parse = line.split("[^a-zA-Z0-9_']+");// Regular expressions!
        	
        	if(parse[0].equals("total_word_count")){
        		this.totalWordCount = Integer.parseInt(parse[1]);
        	}
        	
        	else{
            	this.map.put(parse[0],Integer.parseInt(parse[1]));
            		 
        	}
        	
        	line = br.readLine();
	
		}
	}
	
	
	
	public static void main(String args[]) throws IOException{
	
		WordCounter wc = new WordCounter();
		
		
		//Tests loadWordsFromOriginalFile and prints key value pairs with short.text
		//Tests frequency method
//		wc.loadFromOriginalWordsFile("short.txt");
//		wc.map.printInOrder();
// 		System.out.println("Total wordcount: " + wc.getTotalWordCount());
// 		System.out.println("cs: " + wc.getFrequency("cs"));
// 		System.out.println("a: " +wc.getFrequency("a"));
// 		System.out.println("class: " + wc.getFrequency("class"));
// 		System.out.println("classy: " + wc.getFrequency("classy"));
// 		System.out.println("is: " + wc.getFrequency("is"));
// 		System.out.println("happy: " + wc.getFrequency("happy"));
// 		System.out.println("wonderful: " + wc.getFrequency("wonderful"));
// 		System.out.println("so: "+ wc.getFrequency("so"));

		//Tests readWordCountFile for short.txt
// 		wc.writeWordCountFile("wordcount.txt");
//		wc.readWordCountFile("wordcount.txt");
// 		wc.loadFromOriginalWordsFile("short.txt");
// 		wc.writeWordCountFile("counts_short.txt");
// 		wc.readWordCountFile("counts_short.txt");
// 		wc.writeWordCountFile("redo_counts_short.txt");

//		Testing reddit textfiles and counting words in each file
		wc.loadFromOriginalWordsFile("reddit_comments_2008.txt");
		wc.writeWordCountFile("counts_reddit_comments_2008.txt");
		wc.loadFromOriginalWordsFile("reddit_comments_2009.txt");
 		wc.writeWordCountFile("counts_reddit_comments_2009.txt"); 		
		wc.loadFromOriginalWordsFile("reddit_comments_2010.txt");
		wc.writeWordCountFile("counts_reddit_comments_2010.txt");	
		wc.loadFromOriginalWordsFile("reddit_comments_2011.txt");
		wc.writeWordCountFile("counts_reddit_comments_2011.txt");	
		wc.loadFromOriginalWordsFile("reddit_comments_2012.txt");
		wc.writeWordCountFile("counts_reddit_comments_2012.txt"); 		
		wc.loadFromOriginalWordsFile("reddit_comments_2013.txt");
		wc.writeWordCountFile("counts_reddit_comments_2013.txt");	
		wc.loadFromOriginalWordsFile("reddit_comments_2014.txt");
		wc.writeWordCountFile("counts_reddit_comments_2014.txt");	
		wc.loadFromOriginalWordsFile("reddit_comments_2015.txt");
		wc.writeWordCountFile("counts_reddit_comments_2015.txt");
 		
		//Testing reddit textfiles and counting relevant words in each file
	 	// wc.loadFromOriginalWordsFile("reddit_comments_2008.txt");
// 		wc.writeRelevantWordCountFile("relevant_counts_reddit_comments_2008.txt");
// 		wc.loadFromOriginalWordsFile("reddit_comments_2009.txt");
// 		wc.writeRelevantWordCountFile("relevant_counts_reddit_comments_2009.txt");
// 		wc.loadFromOriginalWordsFile("reddit_comments_2010.txt");
		// wc.writeRelevantWordCountFile("relevant_counts_reddit_comments_2010.txt");
// 		wc.loadFromOriginalWordsFile("reddit_comments_2011.txt");
// 		wc.writeRelevantWordCountFile("relevant_counts_reddit_comments_2011.txt");
// 		wc.loadFromOriginalWordsFile("reddit_comments_2012.txt");
// 		wc.writeRelevantWordCountFile("relevant_counts_reddit_comments_2012.txt");
// 		wc.loadFromOriginalWordsFile("reddit_comments_2013.txt");
// 		wc.writeRelevantWordCountFile("relevant_counts_reddit_comments_2013.txt");
// 		wc.loadFromOriginalWordsFile("reddit_comments_2014.txt");
// 		wc.writeRelevantWordCountFile("relevant_counts_reddit_comments_2014.txt");
// 		wc.loadFromOriginalWordsFile("reddit_comments_2015.txt");
// 		wc.writeRelevantWordCountFile("relevant_counts_reddit_comments_2015.txt");
 	
	}

}

