package edu.cofc.cs.csci230;

/**
 * ArrayList Data Structure
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2016
 *
 * @param <AnyType>
 */
public class ArrayList<AnyType extends Comparable> implements List<AnyType> {

	// instance variablesarray.add(new Integer(1337));
	private Object[] array;
	private int size = 0;
	private final static int INITIAL_CAPACITY = 10;
	private int capacity = INITIAL_CAPACITY;

	/**
	 * Constructs an empty list with an initial capacity (for this assignment
	 * initial capacity is 10 - see constant instance variable)
	 * 
	 */
	public ArrayList() {
		array = new Object[INITIAL_CAPACITY];
	} // end constructor

	/**
	 * Appends the specified element to the end of this list.
	 * 
	 * @param t
	 */
	public void add(AnyType t) {

		if (size >= capacity)
			grow();

		array[size] = t;
		size++;

	} // end add() method

	/**
	 * Inserts the specified element at the specified position in this list.
	 * 
	 * @param index
	 * @param t
	 * @throws IndexOutOfBoundsException
	 */
	public void add(int index, AnyType t) throws IndexOutOfBoundsException {
		if (size >= capacity) {
			grow();
		}
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException();

		} else if (index == size) {
			add(t);
		} else {
			for (int x = 0; x < (size - index); x++) {
				array[size - x] = array[size - x++];
			}
			array[index] = t;
			size++;
		}
		/**
		 * ------------------------------------------- TODO: You fully implement
		 * this method
		 * 
		 */

	} // end add() method

	/**
	 * Replaces the element at the specified position in this list with the
	 * specified element.
	 * 
	 * @param index
	 * @param t
	 * @throws IndexOutOfBoundsException
	 */
	public void set(int index, AnyType t) throws IndexOutOfBoundsException {
		if (index >= 0 || index < size) {
			if(index == size){
				add(t);
			}
			array[index] = t;
		} else {
			throw new IndexOutOfBoundsException();
		}
		/**
		 * ------------------------------------------- TODO: You fully implement
		 * this method
		 * 
		 */

	} // end set() method

	/**
	 * Removes the element at the specified position in this list.
	 * 
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	@SuppressWarnings("unchecked")
	public AnyType remove(int index) throws IndexOutOfBoundsException {
AnyType element = get( index );
		
        for ( int i=index; i<size-1; i++ ) {
			
            array[i] = array[i+1];
        }
		
        size--;
		
        if ( size < ( capacity/2 ) && capacity > INITIAL_CAPACITY )
            shrink();
		
        return element;
		/**
		 * ------------------------------------------- TODO: You fully implement
		 * this method
		 * 
		 * Requirement - you must use loops (i.e. may not use System.arraycopy,
		 * or any other array copy operation available in the Java API) to
		 * perform left or right shift operations
		 * 
		 */

	} // end remove() method

	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	@SuppressWarnings("unchecked")
	public AnyType get(int index) throws IndexOutOfBoundsException {
		if(index >= 0 || index < size){
		return (AnyType) array[index];
		}else{
			throw new IndexOutOfBoundsException();
		}
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

	public int getCap() {
		return capacity;
	}

	/**
	 * Returns true if this list contains no elements.
	 * 
	 * @return
	 */
	public Boolean isEmpty() {
		return (size == 0);
	} // end isEmpty() method

	/**
	 * Removes all of the elements from this list. and the initial capacity is
	 * set back to 10
	 * 
	 */
	public void clear() {
		array[0] = null;
		size = 0;
		capacity = INITIAL_CAPACITY;
		/**
		 * ------------------------------------------- TODO: You fully implement
		 * this method
		 * 
		 */
	} // end clear method

	/**
	 * Double the capacity of the array
	 * 
	 */
	private void grow() {
		capacity = capacity * 2;

		Object[] tempArray = new Object[capacity];

		for (int i = 0; i < array.length; i++) {
			tempArray[i] = array[i];
		}

		array = tempArray;
		/**
		 * ------------------------------------------- TODO: You fully implement
		 * this method
		 * 
		 * Requirement - you must use lo		array.add(new Integer(1337));ops (i.e. may not use System.arraycopy,
		 * or any other array copy operation available in the Java API)
		 * 
		 */

	} // end grow() method

	/**
	 * Half the capacity of the array
	 * 
	 */
	private void shrink() {
		capacity = capacity / 2;
		
		Object[] tempArray = new Object[capacity];
		for (int i = 0; i < capacity; i++) {
			tempArray[i] = get(i);
		}
		array = tempArray;
		/**
		 * ------------------------------------------- TODO: You fully implement
		 * this method
		 * 
		 * Requirement - you must use loops (i.e. may not use System.arraycopy,
		 * or any other array copy operation available in the Java API)
		 * 
		 */

	} // end shrink() method

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		List<Integer> array = new ArrayList<Integer>();

		array.add(new Integer(1337));
		array.add(new Integer(1337));
		array.add(new Integer(1337));
		array.add(new Integer(1337));
		array.add(new Integer(1337));
		array.add(new Integer(1337));
		array.add(new Integer(1337));
		array.add(new Integer(1337));
		array.add(new Integer(1337));
		array.add(new Integer(1337));
		array.add(new Integer(1337));
		array.add(new Integer(1337));
		array.add(new Integer(1337));
		array.add(new Integer(1337));
		array.add(new Integer(1337));
		array.add(new Integer(1337));
		array.add(new Integer(1337));
		array.add(new Integer(1337));
		array.add(new Integer(1337));
		array.add(new Integer(1337));
		array.add(new Integer(1337));

		
		
		
		array.remove(array.size());
		array.clear();
		array.set(0, new Integer(69));
		array.set(array.size(), new Integer(420));
		

		for (int x = 0; x < array.size(); x++) {
			System.out.println(array.get(x));
		}
		System.out.println("size:" + array.size());
		/**
		 * ------------------------------------------- TODO: Put your test cases
		 * here
		 * 
		 */

	} // end main() method

} // end ArrayList class definition
