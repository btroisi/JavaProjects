/*
Filename: LinkedList.java
Author: Brandon Troisi
Date: 10/11/2016

*/


import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;

public class LinkedList<T> implements Iterable<T>{
	//Represents doubly linked list

	private int size;
	private Node head;
	private Node tail;

	public LinkedList(){
		//Constructor sets size to 0 and head and tail pointers to null;
	
		size=0;	
		head=null;
		tail=null;
		
	}
		
		
	public void clear(){
		//Clears list
		size=0;
		head=null;
		tail=null;
		
	}
	
	public int size(){
		//Returns size of list
		return size;
	
	}
	
	public void add(T item){
		//Adds item to list
		Node n = new Node(item);
		n.setNext(head);
		n.setPrev(null);
		if(this.size==0){		
			tail=n;
		}
		if(head!=null){
			head.setPrev(n);
			
		
		}
		head = n;
		size++;
		
	
	
	}

	private class Node{
	
		private Node head;
		private Node tail; 
		private T container; 
		
		public Node(T item){
		
			this.head=null;
			this.container=item;
			this.tail=null;
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
		
		public void setPrev(Node n){
			tail=n;
		}
		
		public Node getPrev(){
			return tail;
		}
	
	}
	
	private class LLIterator implements Iterator<T>{
		//Iterates through list forward
	
		private Node next_node;
		
		public LLIterator(Node head){
			next_node=head;
		
		}
		
		public boolean hasNext(){
			//Checks if list has next value
			return next_node!=null;
		}
		
		public T next(){
			//Returns next item in list
		
			if(next_node == null){
				return null;
				
			}
			
			T ret = next_node.getThing();
			next_node=next_node.getNext();
			return ret;
			
		}
		
		public void remove(){}
		
	}
	
	private class LLBackwardIterator implements Iterator<T>{
		//Iterates through list backward
	
		private Node prev_node;
		
		public LLBackwardIterator(Node head){
			
			prev_node=tail;
		
		}
		
		public boolean hasNext(){
			//Checks if list has next value
			
			return prev_node!=null;
		}
		
		public T next(){
		
			if(prev_node == null){
				return null;
			}
			
			T ret = prev_node.getThing();
			prev_node=prev_node.getPrev();
			return ret;
			
		
		
		}
	
		public void remove(){}
	
	
	
	}

	public Iterator<T> iterator(){
		//Returns iterator given head
		return new LLIterator(this.head);
	}

	public Iterator<T> backward_iterator(){
		//Returns backward iterator given tail
	
		return new LLBackwardIterator(tail);
		
	}

	public ArrayList<T> toArrayList(){
		//Converts doubly linked list to arraylist.
	
		ArrayList<T> l = new ArrayList<T>();
		Iterator it = iterator();
		for(T item:this){
			l.add(item);	
		
		}
		
		return l;	
	
	}
	
	
	public ArrayList<T> toShuffledList(){
		//Converts doubly linked list to shuffled arraylist
	
		ArrayList<T> l = this.toArrayList();
		Collections.shuffle(l);
		return l;
		
	}
	
	public static void main(String[] args){
		//Tests all the methods traversing through list forward and backward
	
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
	
	
		System.out.println("\niterating backward" );
		Iterator bi = llist.backward_iterator();
		while(bi.hasNext()){
			System.out.println(bi.next());
		}
		
		llist.clear();
		
		System.out.printf("\nAfter clearing %d\n", llist.size());
		for (Integer item: llist) {
			System.out.printf("thing %d\n", item);
		}
		
		llist.add(1);
		llist.add(2);
		llist.add(30);
		
		System.out.printf("\nAfter setting %d\n", llist.size());
		for (Integer item: llist) {
			System.out.printf("thing %d\n", item);
		}
		
		
	
	}
	
	
	

		
}



