/*
Filename: LinkedList.java
Author: Brandon Troisi
Date: 10/4/2016

*/


import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;

public class LinkedList<T> implements Iterable<T>{

	private int size;
	private Node head;

	public LinkedList(){
	
		size=0;	
		head=null;
		
	}
		
		
	public void clear(){
		size=0;
		head=null;
		
	}
	
	public int size(){
		return size;
	
	}
	
	public void add(T item){
		Node n = new Node(item);
		n.setNext(head);
		head = n;
		size++;
		
	
	
	}

	private class Node{
	
		private Node head;
		private T container; 
		
		public Node(T item){
		
			this.head=null;
			this.container=item;
		
		}
		
		public T getThing(){
			return container;
		
		
		}
		
		public void setNext(Node n){
			head=n;
			
		
		}
		
		public Node getNext(){
			return head; 
	
		
		}
	
	}
	
	private class LLIterator implements Iterator<T>{
	
		private Node next_node;
		
		public LLIterator(Node head){
			next_node=head;
		
		}
		
		public boolean hasNext(){
			return next_node!=null;
		}
		
		public T next(){
		
			if(next_node == null){
				return null;
				
			}
			
			T ret = next_node.getThing();
			next_node=next_node.getNext();
			return ret;
			
		}
		
		public void remove(){}
		
	}

	public Iterator<T> iterator(){
		return new LLIterator(this.head);
	}

	public ArrayList<T> toArrayList(){
	
		ArrayList<T> l = new ArrayList<T>();
		Iterator it = iterator();
		for(T item:this){
			l.add(item);	
		
		}
		
		return l;	
	
	}
	
	
	public ArrayList<T> toShuffledList(){
	
		ArrayList<T> l = new ArrayList<T>();
		Collections.shuffle(l);
		return l;
		
	}
	
	public static void main(String[] args){
	
		LinkedList<Integer> llist = new LinkedList<Integer>();
		
		llist.add(5);
		llist.add(10);
		llist.add(20);
		
		System.out.printf("\nAfter setup %d\n", llist.size());
		for(Integer item: llist) {
			System.out.printf("thing %d\n", item);
		}
		
		llist.clear();
		
		System.out.printf("\nAfter clearing %d\n", llist.size());
		for (Integer item: llist) {
			System.out.printf("thing %d\n", item);
		}
		
		for (int i=0; i<20; i+=2) {
			llist.add(i);
		}
		
		System.out.printf("\nAfter setting %d\n", llist.size());
		for (Integer item: llist) {
			System.out.printf("thing %d\n", item);
		}

		ArrayList<Integer> alist = llist.toArrayList();
		System.out.printf("\nAfter copying %d\n", alist.size());
		for(Integer item: alist) {
			System.out.printf("thing %d\n", item);
		}						
	
		alist = llist.toShuffledList();	
		System.out.printf("\nAfter copying %d\n", alist.size());
		for(Integer item: alist) {
			System.out.printf("thing %d\n", item);
		}
	
	}
	
	
	

		
}



