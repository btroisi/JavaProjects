/*
Filename: LinkedList.java
Author: Brandon Troisi
Date: 10/25/2016

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
		//Adds item to head of list 
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

	public void remove(T thing){
		//Removes thing from list
		Node ptr=head;
		
		if(this.size==0){
			return;
		}
		
		if(this.size==1){
			head=null;
			tail=null;
			this.size--;
			return;
			
		}
		
		if(ptr.getThing()==thing){
			//Checks if thing to remove is at head of list	
			head=ptr.getNext();
			System.out.println("Ptr.getNext(): "+ head);
			ptr.getNext().setPrev(null);
			size--;
			System.out.println("Found removing beginning: ");
			return;
					
		}
		
		while(ptr.getNext()!=null){
			//Checks if thing to remove is somewhere between head and tail
			if(ptr.getThing() == thing){
			
				ptr.getPrev().setNext(ptr.getNext());	
				ptr.getNext().setPrev(ptr.getPrev());
				size--;
				System.out.println("Found removing middle: ");
				return;	
			}
			ptr=ptr.getNext();
		}
		
		if(ptr.getThing()==thing){
			//Checks if thing to remove is at tail
		
			tail=ptr.getPrev();
			ptr.getPrev().setNext(null);
			size--;
			//System.out.println("Found removing at end: ");
			return; 
		}	
	}
	
	public T peek(){
		//Peeks at tail to see if there is something there
		//If there is something there, returns thing that is at tail, otherwise returns null
		Node n = this.tail;
		if(this.size==0){
			return null;
		}
		return n.getThing();
	}
	
	public T element(){
		//Returns tail of queue
		Node n = this.tail;
		if(this.size==0){
			return null;
		}
		return n.getThing();
	
	}
	
	public boolean offer(T item){
		//Adds item to tail of list
	
		Node n = new Node(item);
		if(this.tail==null){
			this.tail=n;
			this.head=n;
		}
		else{
			this.tail.setNext(n);
			this.tail=n;
		
		}
		return true;
		
	}
	
	public T removeFromTail(){
		//Removes element in list from tail 
		
		Node ptr = this.tail;
		
		if(ptr == null){
			return null;
		}
		
		if(this.size==1){
			head=null;
			tail=null;
			return ptr.getThing();
		}
	
		ptr.getPrev().setNext(null);
		size--;	
		System.out.println("The thing that was removed was " + ptr.getThing());	
		return ptr.getThing();
		
	}


	private class Node{
		//Represents a node
	
		private Node head;
		private Node tail; 
		private T container; 
		
		public Node(T item){
			//Constructor
		
			this.head=null;
			this.container=item;
			this.tail=null;
		}
		
		public T getThing(){
			//Returns item in node
			return container;
		
		}
		
		public void setNext(Node n){
			//Sets next node
			head=n;
		}
		
		public Node getNext(){
			//Returns next node
			return head; 
	
		
		}
		
		public void setPrev(Node n){
			//Sets previous node
			tail=n;
		}
		
		public Node getPrev(){
			//Returns previous node
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
		
		//llist.remove(30);
		//llist.remove(2);
		//llist.remove(1);
		
		llist.removeFromTail();
		
		System.out.printf("\nAfter removing value from list %d\n", llist.size());
		for (Integer item: llist) {
			System.out.printf("thing %d\n", item);
		}	
	}	
}



