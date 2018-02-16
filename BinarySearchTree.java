package edu.cofc.cs.csci230;

/**
 * 
 * Binary search that does not allow two (or more) binary nodes 
 * in the search tree to have the same element value.
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2016
 *
 * @param <AnyType>
 */
public class BinarySearchTree <AnyType extends Comparable> {
	
	// --------------------------------------
	// instance variable
	private BinaryNode<AnyType> root;
	
	/**
	 * Constructor with one parameter that
	 * sets the root node of the BST.
	 * 
	 * @param root
	 */
	public BinarySearchTree( AnyType rootElement ) throws NullBinaryNodeException {
		
		if ( rootElement == null ) {
			throw new NullBinaryNodeException();
		}
		
		this.root = new BinaryNode<AnyType>( rootElement ) ;
		
	} // end constructor
	
	/**
	 * If the BST does not have a root node, then the BST is empty. 
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		
		return ( root == null );
		
	} // end isEmpty() method
	
	/**
	 * Make the BST empty, i.e. a BST that has 
	 * no nodes (including a root node).
	 * 
	 */
	public void makeEmpty() {
		
		root = null;
		
	} // end makeEmpty() method
	
	/**
	 * Method that adds a new node with the specified element 
	 * value in the BST.
	 * 
	 * This method has one parameter:
	 *  1) The element value to be added
	 * 
	 * If the BST has an existing node with the same element 
	 * value, throw an duplicate element exception.
	 * 
	 * @param element
	 */
	public void add( AnyType element ) throws DuplicateElementException {
		
		add(root,element);
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * 
		 */
		
		
		
	} // end add() method
	
	/**
	 * Private recursive method that adds a new node (with the 
	 * specified element value) in the BST.
	 * 
	 * This method has two parameters:
	 *  1) The node visited while recursively walking the BST
	 *  2) The element value to be added
	 * 
	 * If the BST has an existing node with the same element 
	 * value, throw an duplicate element exception.
	 * 
	 * @param node
	 * @param element
	 */
	private void add( BinaryNode<AnyType> node, AnyType element )  throws DuplicateElementException {
		BinaryNode<AnyType> left = node.getLeft();
		BinaryNode<AnyType> right = node.getRight();
		
		//in the case that root node is null; set current node element to element
		if(node.getElement() == null){
			node.setElement(element);
		}else if(element == node.getElement()){
			throw new DuplicateElementException();
		}else if(element.compareTo(node.getElement()) < 0){
			if(left == null){										
				node.setLeft(new BinaryNode<AnyType>(element));		
			}else{
				add(left,element);
			}
		}
		else if(element.compareTo(node.getElement()) > 0){
			if(right == null){
				node.setRight(new BinaryNode<AnyType>(element));
			}else{
				add(right,element);
			}
		}
		else{
			throw new DuplicateElementException();
		}
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * Note: Your solution must use recursion
		 * 
		 */
		
		
		
	} // end add() overloaded method
	
	/**
	 * Method that determines if a node with the specified element value 
	 * exists in the BST. 
	 * 
	 * This method has one parameter:
	 *  1) The element value that is being searched.
	 * 
	 * If the BST is empty, throw an empty binary search tree
	 * exception.
	 * 
	 * @param element
	 * @return
	 */
	public boolean hasElement( AnyType element ) throws EmptyBSTException {
		
		if ( isEmpty() )
			throw new EmptyBSTException();
		
		return hasElement( root, element );
		
	} // end hasElement() method
	
	/**
	 * Private recursive method that determines if the element is 
	 * currently stored in the BST.
	 * 
	 * This method has two parameters:
	 *  1) The node visited while recursively walking the BST
	 *  2) The element value that is being searched.
	 *  
	 *  Hint: use the compareTo() method
	 * 
	 * @param element
	 * @param node
	 * @return
	 */
	private boolean hasElement( BinaryNode<AnyType> node, AnyType element ) {
		if(node.getElement() == element){
			return true;
		}
		else{
			return false;
		}
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * Note: Your solution must use recursion
		 * 
		 */
		
		
		
	} // end hasElement() overloaded method
	
	/**
	 * Find the node with the minimum element value in the BST.
	 * 
	 * This method has no parameters.
	 * 
	 * If the BST is empty, throw an empty binary search tree
	 * exception.
	 * 
	 * @return
	 * @throws EmptyBSTException
	 */
	public AnyType findMin() throws EmptyBSTException {
		
		if ( isEmpty() )
			throw new EmptyBSTException();
		
		return findMin( root ).getElement();
		
	} // end findMin() method
	
	/**
	 * Private recursive method that walks the BST searching
	 * for the node with the minimum element value.
	 * 
	 * This method has one parameter:
	 *  1) The node visited while recursively walking the BST
	 * 
	 * @param node
	 * @return
	 */
	private BinaryNode<AnyType> findMin( BinaryNode<AnyType> node ) {
		if(node.getLeft() == null){
			return node;
		}else{
			return findMin(node.getLeft());
		}
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * Note: Your solution must use recursion
		 * 
		 */
		
		
		
	} // end findMin() method
	
	/**
	 * Find the node with the maximum element value in the BST.
	 * 
	 * This method has no parameters.
	 * 
	 * If the BST is empty, throw an empty binary search tree
	 * exception.
	 * 
	 * @return
	 * @throws EmptyBSTException
	 */
	public AnyType findMax() throws EmptyBSTException {
		
		if ( isEmpty() )
			throw new EmptyBSTException();
		
		return findMax( root ).getElement();
		
	} // end findMax() method
	
	/**
	 * Private recursive method that walks the BST searching
	 * for the node with the maximum element value.
	 * 
	 * This method has one parameter:
	 *  1) The node visited while recursively walking the BST
	 * 
	 * @param node
	 * @return
	 */
	private BinaryNode<AnyType> findMax( BinaryNode<AnyType> node ) {
		if(node.getRight() == null){
			return node;
		}else{
			return findMax(node.getRight());
		}
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * Note: Your solution must use recursion
		 * 
		 */
		
		
		
	} // end findMax() method
	
	/**
	 * 
	 * @param args
	 * @throws DuplicateElementException 
	 * @throws EmptyBSTException 
	 */
	public static void main( String[] args ) throws DuplicateElementException, EmptyBSTException {
		try {
			System.out.println("tree 1");
			BinarySearchTree<Integer> tree = new BinarySearchTree(new Integer(23));
			tree.add(new Integer(1337));
			tree.add(new Integer(300));
			tree.add(new Integer(4));
			tree.add(new Integer(69));
			tree.add(new Integer(3));
			tree.add(new Integer(42));
			System.out.println("min : " + tree.findMin());
			System.out.println("max : " + tree.findMax());
			
		} catch (NullBinaryNodeException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (DuplicateElementException d){
			System.out.println(d);
		} catch (EmptyBSTException ee){
			System.out.println(ee);
		}
///////////////////////////////////////////////////////////////////////////////////////////////////
		try {
			System.out.println("tree 2");
			BinarySearchTree<Integer> tree = new BinarySearchTree(new Integer(23));
			tree.add(new Integer(10));
			tree.add(new Integer(5));
			tree.add(new Integer(15));
			tree.add(new Integer(0));
			tree.add(new Integer(25));
			tree.add(new Integer(3));
			System.out.println("min : " + tree.findMin());
			System.out.println("max : " + tree.findMax());
			
		} catch (NullBinaryNodeException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (DuplicateElementException d){
			System.out.println(d);
		} catch (EmptyBSTException ee){
			System.out.println(ee);
		}
/////////////////////////////////////////////////////////////////////////////////////////////////			
		try {
			System.out.println("tree 3");
			BinarySearchTree<Integer> tree = new BinarySearchTree(new Integer(23));
			tree.add(new Integer(2));
			tree.add(new Integer(1));
			tree.add(new Integer(3));
			tree.add(new Integer(4));
			tree.add(new Integer(3));
			tree.add(new Integer(3));
			System.out.println("min : " + tree.findMin());
			System.out.println("max : " + tree.findMax());
			
		} catch (NullBinaryNodeException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (DuplicateElementException d){
			System.out.println(d);
		} catch (EmptyBSTException ee){
			System.out.println(ee);
		}
/////////////////////////////////////////////////////////////////////////////////////////////////
		try {
			System.out.println("tree 4");
			BinarySearchTree<Integer> tree = new BinarySearchTree(new Integer(23));
			tree.add(new Integer(1));
			tree.add(new Integer(2));
			tree.add(new Integer(3));
			tree.add(new Integer(4));
			tree.add(new Integer(5));
			tree.add(new Integer(6));
			System.out.println("min : " + tree.findMin());
			System.out.println("max : " + tree.findMax());
			
		} catch (NullBinaryNodeException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (DuplicateElementException d){
			System.out.println(d);
		} catch (EmptyBSTException ee){
			System.out.println(ee);
		}
//////////////////////////////////////////////////////////////////////////////////////////////////
		try {
			System.out.println("tree 5");
			BinarySearchTree<Integer> tree = new BinarySearchTree(new Integer(23));
			tree.add(new Integer(0));
			tree.add(new Integer(5));
			tree.add(new Integer(10));
			tree.add(new Integer(50));
			tree.add(new Integer(25));
			tree.add(new Integer(3));
			System.out.println("min : " + tree.findMin());
			System.out.println("max : " + tree.findMax());
			
		} catch (NullBinaryNodeException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (DuplicateElementException d){
			System.out.println(d);
		} catch (EmptyBSTException ee){
			System.out.println(ee);
		}
		
	} // end main method
	

} // end BinarySearchTree class
