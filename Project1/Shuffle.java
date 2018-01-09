/**
* File: Shuffle.java
* Author: Brandon Troisi
* Date 09/13/2016
*/

import java.util.ArrayList;
import java.util.Random;

public class Shuffle{

	public static void main( String[] args ){
		ArrayList<Integer> aList = new ArrayList<Integer>();
		Random r = new Random();
		
		for( int i=0; i<10; i++){
			int rint = r.nextInt(100);
			aList.add(rint); 
			System.out.println(rint);
		}
	
		
		for( int i=0; i<aList.size(); i++){
			System.out.println((int)(aList.get(i)));
		}
	
		for( int i=0; i<10; i++){
			int a = r.nextInt(aList.size());
			int b = aList.remove(a);
			System.out.println("The removed element is: " + b + " the remaining elements are: " + aList); 
			
		}
	
	}

}


	