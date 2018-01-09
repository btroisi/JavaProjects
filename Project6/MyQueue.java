/*
Filename: MyQueue.java
Author: Brandon Troisi
Date: 10/25/2016

*/

import java.util.Iterator;

public class MyQueue<T> implements Iterable<T>{
	//Holds a checkout line represented by a queue

	private LinkedList<T> list;
	
	public MyQueue(){
		//Constructor
		this.list = new LinkedList<T>();
	
	}

	public int size(){
		//Returns size of line
		return list.size();
	}

	public void add(T item){
		//Adds item to line
		this.list.add(item);
	}
	
	public void remove(T item){
		//Removes item from line
		this.list.remove(item);
	}
	
	public T poll(){
		//Removes item from tail of line
		return this.list.removeFromTail();
	}
	
	public T peek(){
		//Peeks at tail of queue to see if there is something there
		//If there is, returns item at tail
		return this.list.peek();
	}
	
	public boolean offer(T item){
		//Inserts item in queue
		return this.list.offer(item);
		
	}
	
	public Iterator<T> iterator() {
		//Returns iterator
		return this.list.iterator();
	}
	
	
	public static void main(String args[]){
		//Test functions of queue
	
		MyQueue<Integer> q = new MyQueue<Integer>();
	
	
		q.add(1);
		q.add(2);
		q.add(30);
		
		System.out.printf("\nAfter setting %d\n", q.size());
		for (Integer item: q) {
			System.out.printf("thing %d\n", item);
		}
		
		q.poll();
		
		System.out.printf("\nAfter removing value from list\n");
		for (Integer item: q) {
			System.out.printf("thing %d\n", item);
		}
		
		System.out.println("\nAfter peeking... " + q.peek());
		
	
	}


}

