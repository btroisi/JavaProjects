/*
Title: FindCommonWords
Author: Brandon Troisi
Date: 11/15/16
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.ArrayList; 

public class FindCommonWords{
	//Finds the most common words in a particular word file

	private WordCounter wc; 
	private PQHeap<KeyValuePair> heap;
	private String filename;
		
	public FindCommonWords(){
		//Constructor
		this.wc = new WordCounter();
		this.heap = new PQHeap<KeyValuePair>(new KVComparator());
	}
	
	
	public void readWordCountFile(String wordCountfilename) throws IOException{
		//Reads wordCount file and adds key value pair of word 
		//of word and number of times it appears in the document to heap
		BufferedReader br = new BufferedReader(new FileReader(wordCountfilename));
		String line = br.readLine();
		line = br.readLine();
		while(line!=null){
			KeyValuePair<String,Integer> pair = new KeyValuePair<String,Integer>("",0);
			String[] parse = line.split("[^a-zA-Z0-9_']+");// Regular expressions!
        	String key = parse[0].trim().toLowerCase();
        	int value = Integer.parseInt(parse[1]);
        	pair.setKey(key);
        	pair.setValue(value);
            this.heap.add(pair);
        	line = br.readLine();
	
		}
	}
	
	public PQHeap getHeap(){
		//Returns the heap
		return this.heap;
	}
	
	public static void main(String args[]) throws IOException{
		//
	
		FindCommonWords cw = new FindCommonWords();
		cw.readWordCountFile("counts_reddit_comments_2008.txt");
		//Code commented out below prints out key value pairs of word, number of times found in document
		//when readWordCountFile read in counts_short.txt 
		// ArrayList <KeyValuePair> pair = cw.getHeap().getHeap();
// 		for(KeyValuePair kv : pair){
// 			System.out.println(kv);
// 		}
		//The code below prints the 10 most common words in a file
		System.out.println("10 most common words in 2008: ");
		for(int i=0; i<11; i++){
			System.out.println(cw.getHeap().remove());
		}
		
		
	}
}	

class KVComparator implements Comparator<KeyValuePair<String,Integer>> {
	//Comparator for KeyValuePair where key is String and value is Integer
    public int compare( KeyValuePair<String,Integer> i1, KeyValuePair<String,Integer> i2 ) {
        // returns negative number if i2 comes after i1 lexicographically
        int diff = i1.getValue() - i2.getValue();
        return diff;
    }
}
	