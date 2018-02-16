package edu.cofc.cs.csci230;

import java.util.NoSuchElementException;

/**
 * A semi-constant time FIFO queue. The time complexity for 
 * the interface methods are:
 * ----------------------------------
 * 1) add: O(1) - not considering capacity resize operations
 * 2) remove: O(n) - not considering capacity resize operations
 * 3) peek: O(1)
 * 
 * Please note: the above time complexities do not factor in
 * capacity resize (grow and shrink) operations. Even though
 * capacity resize operations will occur, for this assignment 
 * you may assume the are negligible.
 * 
 * This data structure was discussed in class along with the 
 * operations, please review your notes.
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2016
 *
 * @param <AnyType>
 */
public class SemiConstantTimeQueue<AnyType extends Comparable> implements Queue<AnyType> {
	
	/**
	 * private instance variables
	 */
	private ArrayList<AnyType> list = new ArrayList<AnyType>();


	/**
	 * Inserts the specified element at the end of the queue in 
	 * constant time O(1)
	 * 
	 * @param t element to add
	 * @throws NullPointerException- if the specified element is null 
	 *                               (queue does not permit null elements)
	 */
	public void add(AnyType t) throws NullPointerException {
		if (t == null){
			throw new NullPointerException();
		}
		else{
			list.add(t);
		}
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your add solution must be a constant 
         * time O(1) operation (not considering capacity 
         * resize operations)
         * 
         */
		
		
		
	} // end add() method

	/**
	 * Retrieves and removes the head of the queue in
	 * linear time O(n).
	 * 
	 * Hint: shift operations will make this a linear time
	 * operation.
	 * 
	 * @return the head of the queue
	 * @throws NoSuchElementException - if this queue is empty
	 */
	public AnyType remove() throws NoSuchElementException {
		if(!list.isEmpty()){
		return list.remove(0);
		}
		else{
			throw new NoSuchElementException();
		}
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your push solution must be a linear 
         * time O(n) operation. See hint above.
         * 
         *
         */
		
		
		
	} // end remove() method

	/**
	 * Retrieves, but does not remove, the head of the queue, 
	 * or returns null if this queue is empty.
	 * 
	 * @return the head of this queue, or null if this queue is empty
	 */
	public AnyType peek() {
		if(list.get(0)==null){
			return null;
		}
		else{
			return list.get(0);	
		}
		
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your add solution must be a constant 
         * time O(1) operation 
         * 
         */
		
		
		
	} // end peek() method
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SemiConstantTimeQueue<Integer> Queue = new SemiConstantTimeQueue<Integer>();
		////////////peek on empty list
		System.out.println(Queue.peek());
		////////////remove on empty list
		try{
			Queue.remove();
		}catch(NoSuchElementException ex){
			System.out.println(ex);
		}
		///////////add a null value
		try{
			Queue.add(null);
		}catch(NullPointerException ex){
			System.out.println(ex);
		}
		/////////////add 25 elements
		System.out.println("add() : 0 - 25");
		
		for(int i = 0; i <= 25; i++){
			Queue.add(new Integer(i));
		}
		
		
		System.out.println("about to remove elements");
		//////////////////////////////////remove all 25 and peek at next element
		for(int i = 0; i <= 25; i++){
			
		Integer numb = Queue.remove();
		System.out.println("Just removed : " +  numb.toString());
		System.out.println("Peeked : " + Queue.peek());
		}
		///////////remove one that is not there
		try{
		Queue.remove();
		}catch(NoSuchElementException ex){
			System.out.println(ex);
		}
		/**
         * -------------------------------------------
         * TODO: You put your test cases here
         * 
         */
		
		

	} // end main() method

} // end ConstantTimeQueue class definition
