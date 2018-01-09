/*
Author: Brandon Troisi
File: BSTMap.java
Date:11/2/16

*/

import java.util.Comparator;
import java.util.ArrayList; 

public class BSTMap<K,V> implements MyMap<K,V>{
	//Represents Binary Search Tree map(BSTMap)

	private TreeNode<K,V> root;
	private Comparator<K> comparator; 
	
	public BSTMap( Comparator<K> comparator){
		//Constructor
		this.comparator=comparator;
		this.root= null;	
	}
	
	public void put(K key, V value){
		//Puts key and value on BSTMap
		if(this.root==null){
			this.root=new TreeNode<K,V>(key,value,null,null);
		
		}
		root.put(key,value,this.comparator);
		
	}
	
	public boolean containsKey(K key){	
		//Checks to see if BSTMap contains key key.
		if(this.root==null){
			return false;
		}
		return root.contains(key,this.comparator);
	}
	
	
	public int depth(){
		//Calculates depth of BSTMap(how many levels)
		if(this.root==null){
			return 0;
		}
		return root.depth();
		
	}
	
	public int size(){
		//Calculates size of BSTMap(how many nodes)
		if(this.root==null){
			return 0;
		}
		return this.root.size();
	
	}
	
	
	public void printInOrder(){
		//Prints BSTMap using in-order traversal
		if(this.root==null){
			System.out.println("The tree is empty");
		}
		else{
			this.root.printInOrder();
		}
	
	}
	
	public ArrayList<KeyValuePair<K,V>> getPairs(){
		//Returns arraylist of key value pairs in BSTMap
		ArrayList<KeyValuePair<K,V>> pairs = new ArrayList<KeyValuePair<K,V>>();
		if(this.root==null){
			return pairs;
		}
		
		root.getPairs(pairs);
		return pairs;
	}
	
	public V get(K key){
		//Returns value associated with key key
		if(this.root==null){
			return null;
		}
		return root.getV(key,this.comparator);
	
	
	}
	
	public ArrayList<K> getKeys(){
		//Returns arraylist of keys in BSTMap
		if(this.root==null){
			return null;
		}
		ArrayList<KeyValuePair<K,V>> keyvalpair = new ArrayList<KeyValuePair<K,V>>(); 
		keyvalpair=this.getPairs();
		ArrayList<K> keylist = new ArrayList<K>();
		for(KeyValuePair<K,V> kv: keyvalpair){
			keylist.add(kv.getKey());
		}
		return keylist;
	
	}
	
	public void clear(){
		//Clears BSTMap
		this.root=null;
		
	}
	
	
	 public static void main( String[] args ) {
        System.out.println( "test code" );
        BSTMap<String,Integer> map = new BSTMap<String,Integer>(new AscendingStringComparator());
        map.put( "B", 2 );
        map.put( "A", 1);
        map.put( "D", 2 );
        map.put( "C", 2 );
        map.printInOrder();
        System.out.println();
        System.out.println( "Has A: " + map.containsKey( "A" ) );
        System.out.println( "Has G: " + map.containsKey( "G" ) );
        map.put( "D", 3 );
        System.out.println( "D now has value " + map.get( "D" ) );
        System.out.println( "The tree has " + map.size() + " elements" );
        System.out.println( "The tree has " + map.depth() + " levels" );
        ArrayList<KeyValuePair<String,Integer>> pairs  = map.getPairs();
        System.out.println( "In useful order: " );
        System.out.println( pairs );
    }        
}


class TreeNode<Key,Value>{	
	//Represents TreeNode 
	private KeyValuePair<Key,Value> pair;
	private TreeNode<Key,Value> left;
	private TreeNode<Key,Value> right;
	
	public TreeNode(Key this_key, Value this_val, TreeNode<Key,Value> l, TreeNode<Key,Value> r){
		//Constructor
		this.left= left;
		this.right=	right;
		this.pair=new KeyValuePair<Key,Value>(this_key,this_val);
		
		
	}
	
	public TreeNode<Key,Value> getRight(){
		//Returns right node
		return this.right;
	}
	
	public TreeNode<Key,Value> getLeft(){
		//Returns left node
		return this.left;
	
	}

	
	public void put(Key k, Value v, Comparator<Key> comp){
		//Puts key value pair onto BSTMap
		int comparison = comp.compare(k,this.pair.getKey());
		if(comparison <0){
			if(this.left==null){
				this.left=new TreeNode<Key,Value>(k,v,null,null);
				return;
			}
			else{
				this.left.put(k,v,comp);
			}	
		}
		
		else if(comparison>0){
			if(this.right==null){
				this.right=new TreeNode<Key,Value>(k,v,null,null);
				
			}
			else{
				this.right.put(k,v,comp);
				return;
			}
		}
		
		else{
			this.pair.setValue(v);
		}
		
		
	}
	
	public boolean contains(Key k, Comparator<Key> comp){
		//Checks if key k is in BSTMap.
		int comparison = comp.compare(k,this.pair.getKey());
		if(comparison<0){
			if(this.left==null){
				return false; 
			}
			else{
				return this.left.contains(k, comp);
			}
		}
		else if(comparison > 0){
			if(this.right==null){
				return false;
			}
			else{
				return this.right.contains(k, comp);
			}
		}
		
		return true;
		
	}
	
	public String toString(){
		//Returns string representation of key value pair
		return this.pair.toString();
	}
	
	public void getPairs(ArrayList<KeyValuePair<Key,Value>> pairs){
		//Gets pairs
		pairs.add(this.pair);
		
		if(this.left!=null){
			this.left.getPairs(pairs);
		}
		if(this.right!=null){
			this.right.getPairs(pairs);
		}
		
	
	}
	
	public int depth(){
		//Returns depth of BSTMap(number of levels)
		int leftdepth=0;
		if(this.left!=null){
			leftdepth+=this.left.depth();
			
		}
		int rightdepth=0;
		if(this.right!=null){
			this.right.depth();
			rightdepth+=right.depth();	
		}
		
		if(leftdepth>rightdepth){
			return leftdepth+1;
		}
		else if(rightdepth>leftdepth){
			return rightdepth+1;
		}	
		
		return leftdepth+rightdepth+1;
	
	}
	
	public int size(){
		//Returns size of BSTMap(number of nodes)
		int size=0;
		if(this.left!=null){
			size+=this.left.size();
			
		}
		int rightdepth=0;
		if(this.right!=null){
			size+=this.right.size();
				
		}
		
		return size+1;
		 
		
	}
	
	public void printInOrder(){
		//Prints nodes in BSTMap in order
	
		
		if(this.left!=null){
			this.left.printInOrder();
			
		}
		
		System.out.println(this.pair);
		if(this.right!=null){
			this.right.printInOrder();
				
		}
		
		
	}
	
	
	
	
	public Value getV(Key k, Comparator<Key> comp){	
		//Returns value associated with key k
		int comparison = comp.compare(k, this.pair.getKey());
		if(comparison == 0){
			return this.pair.getValue();
		}
		else if(comparison<0){
			if(this.left!=null){
			return this.left.getV(k,comp);
			}
		}
		
		else if(comparison>0){
			if(this.right!=null){
			return this.right.getV(k,comp);
			}
		}
		return null;
		
	}
}

class AscendingStringComparator implements Comparator<String> {
	//Need comparator that compares strings to one another
    public int compare( String i1, String i2 ) {
        // returns negative number if i2 comes after i1 lexicographically
        return i1.compareTo(i2);
    }
}