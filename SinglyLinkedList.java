package edu.cofc.cs.csci230;

import java.util.ArrayList;

/**
 * Singly LinkedList Data Structure
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2016
 *
 * @param <AnyType>
 */
public class SinglyLinkedList<AnyType extends Comparable> implements List<AnyType> {

	// instance variables
	private Node<AnyType> headNode = null;
	private int size = 0;

	/**
	 * Appends the specified element to the end of this list.
	 * 
	 * @param t
	 */
	public void add(AnyType t) {

		addNode(new Node<AnyType>(t));

	} // end add() method

	/**
	 * implementation for public add(AnyType t) method
	 * 
	 * @param t
	 */
	private void addNode(Node<AnyType> t) {

		if (isEmpty())
			headNode = t;
		else
			getNode(size - 1).setNextNode(t);

		size++;

	} // end addNote() method

	/**
	 * Inserts the specified element at the specified position in this list.
	 * 
	 * @param index
	 * @param t
	 * @throws IndexOutOfBoundsException
	 */
	public void add(int index, AnyType t) throws IndexOutOfBoundsException {

		addNode(index, new Node<AnyType>(t));

	} // end add() method

	/*
	 * 
	 * Implementation for public add(int index, AnyType t) method
	 *
	 * @param index
	 * 
	 * @param t
	 * 
	 * @throws IndexOutOfBoundsException
	 */
	private void addNode(int index, Node<AnyType> t) throws IndexOutOfBoundsException {

		if (index == 0 && size != 0) {
			t.setNextNode(headNode);
			headNode = t;
			size++;
		} else if (index == size) {
			addNode(t);
		} else if (index > 0 && index < size) {
			Node<AnyType> beforeNewNode = getNode(index - 1);
			Node<AnyType> newNextNode = beforeNewNode.getNextNode();
			beforeNewNode.setNextNode(t);
			t.setNextNode(newNextNode);
			size++;
		}
		else if(size == 0 && index == 0){
			add(t.getData());
		}
		else if(index > size || index < 0){
			throw new IndexOutOfBoundsException(); 
		}
		/**
		 * ------------------------------------------- TODO: You fully implement
		 * this method
		 * 
		 */

	} // end addNode() method

	/**
	 * Replaces the element at the specified position in this list with the
	 * specified element.
	 * 
	 * @param index
	 * @param t
	 * @throws IndexOutOfBoundsException
	 */
	public void set(int index, AnyType t) throws IndexOutOfBoundsException {

		setNode(index, new Node<AnyType>(t));

	} // end set() method

	/**
	 * 
	 * Implementation for public set( int index, AnyType t ) method
	 *
	 * @param index
	 * @param t
	 * @throws IndexOutOfBoundsException
	 */
	private void setNode(int index, Node<AnyType> t) throws IndexOutOfBoundsException {
			getNode(index).setData(t.getData());
		
		
		/**
		 * ------------------------------------------- TODO: You fully implement
		 * this method
		 * 
		 */

	} // end setNode() method

	/**
	 * Removes the element at the specified position in this list.
	 * 
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	public AnyType remove(int index) throws IndexOutOfBoundsException {

		return removeNode(index).getData();

	} // end remove() method

	/**
	 *
	 * Implementation for public remove( int index ) method
	 *
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	private Node<AnyType> removeNode(int index) throws IndexOutOfBoundsException {
		Node<AnyType> removedNode = null;
		if (index == 0) {
			removedNode = headNode;
			headNode = headNode.getNextNode();
		} else if (index == size) {
			Node<AnyType> beforeNode = getNode(index - 1);
			removedNode = beforeNode.getNextNode();
			beforeNode.setNextNode(null);
		}
		else if(index > size || index < 0){
			throw new IndexOutOfBoundsException();
		}
		else {
			Node<AnyType> beforeNode = getNode(index - 1);
			removedNode = beforeNode.getNextNode();
			Node<AnyType> afterNode = removedNode.getNextNode();
			beforeNode.setNextNode(afterNode);
		}
		size--;

		return removedNode;
		/**
		 * ------------------------------------------- TODO: You fully implement
		 * this method
		 * 
		 */

	} // end removeNode() method

	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	public AnyType get(int index) throws IndexOutOfBoundsException {

		return getNode(index).getData();

	} // end get() method

	/**
	 *
	 * Implementation for public get(int index) method
	 * 
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	private Node<AnyType> getNode(int index) throws IndexOutOfBoundsException {
		
		if ( index < 0 || index > size )
			throw new IndexOutOfBoundsException();
		
		Node<AnyType> currentNode = headNode;
		for (int i = 0; i < index; i++) {
			currentNode = currentNode.getNextNode();
		}
		return currentNode;
		/**
		 * ------------------------------------------- TODO: You fully implement
		 * this method
		 * 
		 */

	} // end get() method

	/**
	 * Returns the number of elements in this list.
	 * 
	 * @return
	 */
	public int size() {

		return size;

	} // end size() method

	/**
	 * Returns true if this list contains no elements.
	 * 
	 * @return
	 */
	public Boolean isEmpty() {

		return (size == 0) ? true : false;

	} // end isEmpty() method

	/**
	 * Removes all of the elements from this list.
	 * 
	 */
	public void clear() {
		int index = size;
		for (int x = 1; x <= index; x++) {
			Node<AnyType> nextNode = headNode.getNextNode();
			headNode.setNextNode(null);
			headNode = nextNode;
			size--;
		}
		headNode = null;

		/**
		 * ------------------------------------------- TODO: You fully implement
		 * this method
		 * 
		 */

	} // end clear method

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("--TEST--");
		// make link list and arraylist
		List<Integer> linkList = new SinglyLinkedList<Integer>();
		ArrayList<Integer> aList = new ArrayList<Integer>();

		// at 1-10 to each list
		for (int i = 0; i < 10; i++) {
			linkList.add(new Integer(i));
			aList.add(new Integer(i));
		}

		// remove one from first index
		try {
			linkList.remove(0);
			aList.remove(0);
			System.out.println("removeing the FIRST index PASSED");
		} catch (NullPointerException ex) {
			System.out.println("removeing the FIRST index FAILED");
		}

		// remove one from the middle
		try {
			linkList.remove(5);
			aList.remove(5);
			System.out.println("removeing the MIDDLE index PASSED");
		} catch (NullPointerException ex) {
			System.out.println("removeing the MIDDLE index FAILED");
		}

		// remove from last index
		try {
			linkList.remove(linkList.size() - 1);
			aList.remove(aList.size() - 1);
			System.out.println("removeing the LAST index PASSED");
		} catch (IndexOutOfBoundsException ex) {
			System.out.println("removeing the LAST index FAILED");
		}
		// remove from after tail
		try {
			linkList.remove(linkList.size() + 1);
			aList.remove(aList.size() + 1);
			System.out.println("removeing AFTER TAIL index FAILD");
		} catch (IndexOutOfBoundsException ex) {
			System.out.println("removeing AFTER TAIL index PASSED");
		}
		// remove from before head
		try {
			linkList.remove(-1);
			aList.remove(-1);
			System.out.println("removeing BEFORE HEAD index FAILD");
		} catch (IndexOutOfBoundsException ex) {
			System.out.println("removeing BEFORE HEADindex PASSED");
		}
		///////////////////////////////////////////////////////////////////////////////////////////////////////
		// ADD to FIRST INDEX
		try {
			linkList.add(0, new Integer(100));
			aList.add(0, new Integer(100));
			System.out.println("ADDING the FIRST index PASSED");
		} catch (IndexOutOfBoundsException ex) {
			System.out.println("ADDING the FIRST index FAILED");
		}

		// //ADD one to the middle
		try {
			linkList.add(5, new Integer(66));
			aList.add(5, new Integer(66));
			System.out.println("ADDING the MIDDLE index PASSED");
		} catch (IndexOutOfBoundsException ex) {
			System.out.println("ADDING the MIDDLE index FAILED");
		}

		// ADD to TAIL
		try {
			linkList.add(linkList.size(), new Integer(9999));
			aList.add(aList.size(), new Integer(9999));
			System.out.println("ADDING the LAST index PASSED");
		} catch (IndexOutOfBoundsException ex) {
			System.out.println("ADDING the LAST index FAILED");
		}
		// //REMOVING from after tail
		try {
			linkList.add(linkList.size() + 1, new Integer(123219));
			aList.add(aList.size() + 1, new Integer(122399));
			System.out.println("ADDING AFTER TAIL index FAILD");
		} catch (IndexOutOfBoundsException ex) {
			System.out.println("ADDING AFTER TAIL index PASSED");
			System.out.println(ex);
		}
		// //remove from before head
		try {
			linkList.add(-1, new Integer(111111111));
			aList.add(-1, new Integer(111111111));
			System.out.println("removeing BEFORE HEAD index FAILD");
		} catch (IndexOutOfBoundsException ex) {
			System.out.println("ADDING BEFORE HEAD index PASSED");
			System.out.println(ex);
		}
		/////////////////////////////////////////////////////////////////////////////////////
		// set INDEX
		try {
			linkList.set(0, new Integer(1337));
			System.out.println("SET FIRST INDEX PASSED");
		} catch (IndexOutOfBoundsException ex) {
			System.out.println(ex);
		}
		// set BEFORE HEAD
		try {
			linkList.set(-2, new Integer(420));
			System.out.println("SET FIRST INDEX FAILED");
		} catch (IndexOutOfBoundsException ex) {
			System.out.println(ex);
		}
		// set BEFORE INDEX
		try {
			linkList.set(linkList.size() + 1, new Integer(420));
			System.out.println("SET BEFORE INDEX FAILED");
		} catch (IndexOutOfBoundsException ex) {
			System.out.println(ex);
		}
		////////////////////////////////////////////////////////////////////////////////////////
		//print out Link List
		////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("LIST :");
		for (int x = 0; x < linkList.size(); x++) {
			System.out.println(linkList.get(x).toString());
		}
		System.out.println("CLEARED LIST");
		//clear List
		linkList.clear();
		//test to see if list is cleared!
		
		linkList.add(3, new Integer(0));
		for (int x = 0; x < linkList.size(); x++) {
			System.out.println(linkList.get(x).toString());
		}
		/**
		 * ------------------------------------------- TODO: You put your test
		 * cases here
		 * 
		 */

	} // end main() method

} // end SinglyLinkedList class definition