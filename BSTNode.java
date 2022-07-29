/**
 * Lab 04
 * @author Lab Group 7: Meghana Indukuri & Joseph Khamisy
 * This program creates the class BSTNode with the important private attributes, constructors and methods .
 * July 29th 2022
 */
public class BSTNode {
	private Currency data; // the data of the BSTNode
	private BSTNode rightChild; // the right child of BSTNode
	private BSTNode leftChild; // the left child of BSTNode
	
	/**
	 * Default constructor
	 * @pre 
	 * @post all the attributes are set to null.
	 */
	public BSTNode ()
	{
		data = null;
		rightChild = null;
		leftChild = null;
	}
	
	/**
	 * Constructor that takes in a currency value and sets the data attribute to the given value. 
	 * @pre d - the currency value to be given to the node
	 * @post - the data attribute is set to the given currency and the two other attributes are set to null.
	 */
	public BSTNode (Currency d)
	{
		data = d;
		rightChild = null;
		leftChild = null;
	}
	
	/**
	 * Constructor that takes in a currency value, and right and left child to set the attributes to the given values.
	 * @pre d - currency value d to be given to the node
	 * 		r - the BSTNode to be given as right child
	 * 		l - the BSTNode to be given as left child
	 * @post sets the three attributes to their given values.
	 */
	public BSTNode (Currency d, BSTNode r, BSTNode l)
	{
		data = d;
		rightChild = r;
		leftChild = l;
	}
	
	/**
	 * Getter method for the data attribute
	 * @pre
	 * @post
	 * @return Currency - data
	 */
	public Currency getData()
	{
		return data;
	}
	
	/**
	 * Setter method for data attribute
	 * @pre d - Currency value to set the data attribute to.
	 * @post the data attribute is set to given value.
	 */
	public void setData(Currency d)
	{
		data = d;
	}
	
	/**
	 * Getter method for the rightChild attribute
	 * @pre
	 * @post
	 * @return BSTNode - rightChild
	 */
	public BSTNode getRightChild()
	{
		return rightChild;
	}
	
	/**
	 * Setter method for rightChild attribute
	 * @pre r - RightChild value to set the rightChild attribute to.
	 * @post the rightChild attribute is set to given value.
	 */
	public void setRightChild(BSTNode r)
	{
		rightChild = r;
	}
	
	/**
	 * Getter method for the leftChild attribute
	 * @pre
	 * @post
	 * @return BSTNode - leftChild
	 */
	public BSTNode getLeftChild()
	{
		return leftChild;
	}
	
	/**
	 * Setter method for leftChild attribute
	 * @pre l - LeftChild value to set the LeftChild attribute to.
	 * @post the LeftChild attribute is set to given value.
	 */
	public void setLeftChild(BSTNode l)
	{
		leftChild = l;
	}
}
