/*
Title:PQHeap
Author: Brandon Troisi
Date: 11/15/16
*/

import java.util.ArrayList;
import java.util.Comparator;

public class PQHeap<T>{
	//Represents a max heap

	private ArrayList<T> values;
	private int size;
	private Comparator<T> comp;

	public PQHeap(Comparator comp){
	//Constructor
		this.size = 0;
		this.comp = comp;
		this.values = new ArrayList<T>();
		
	}
	
	public int size(){
		//Returns size of heap
		return this.size;
	}
	
	public ArrayList<T> getHeap(){
		//Returns the arraylist representation of the heap
		return this.values; 
	}
	
	private void swap(int idx1, int idx2){
		//Swaps values at indicies idx1 and idx2
		T obj1 = this.values.get(idx1);
		T obj2 = this.values.get(idx2);
		
		this.values.set(idx1,obj2);
		this.values.set(idx2,obj1);
	}
	
	public T getValue(int idx){
		//Returns the value at index idx
		return this.values.get(idx);
	}
	
	public void add(T obj){
		//Adds object obj to heap
		values.add(obj);
		this.size++;
		int cur = this.size-1;
		int parent = (cur-1)/2;
		T curVal = this.values.get(cur);
		T parVal = this.values.get(parent);
		
		while(cur>0 && this.comp.compare(parVal,curVal)<0){
			this.swap(cur,parent);
			cur=parent;
			parent=(cur-1)/2;
			curVal = this.values.get(cur);
			parVal = this.values.get(parent);	
		}
		
	}
	
	public T remove(){
		//Removes and returns maximum value of heap
		
		if(this.size==0){
			return null;
		}
		T valToBeRemoved = this.values.get(0);
		this.values.set(0,this.values.get(this.size-1));
		this.size--;
		
		int cur = 0; 
		int lchild = 2*cur+1;
		int rchild = 2*cur+2;
		int largerChild;
		
		
		while(lchild<this.size()){
			if(lchild == this.size-1 || this.comp.compare(this.values.get(lchild),this.values.get(rchild))>0){
				largerChild = lchild;	
			}
			else{
				largerChild = rchild;	
			}
			
			T largercVal = this.values.get(largerChild);
			T curVal = this.values.get(cur);
			
			if(this.comp.compare(curVal,largercVal)<0){
				this.swap(cur, largerChild);
				cur=largerChild;
				lchild = 2*cur+1;
				rchild = 2*cur+2;	
			}
			
			else{
			
				break;
			}
			
		}		
		
		return valToBeRemoved; 
		
	}

}