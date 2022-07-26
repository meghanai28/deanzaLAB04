/**
 * Lab 03
 * @author Lab Group 7: Meghana Indukuri & Joseph Khamisy
 * This program creates the class LinkNode with the important private attributes, constructors and methods .
 * July 20th 2022
 */
public class LinkNode {
	private Currency data; // Data of linkNode
	private LinkNode next; // Pointer to next LinkNode
	
	/**
	 * Default Constructor that sets both private attributes to null
	 */
	public LinkNode()
	{
		data = null;
		next = null;
	}
	
	/**
	 * Constructor that sets the next pointer to null, and the data attribute to a given value
	 * @pre Currency val - the value to be set for data attribute
	 */
	public LinkNode(Currency val)
	{
		data = val;
		next = null;
	}
	
	/**
	 * Constructor that sets the next pointer to a given next LinkNode, and the data attribute to a given value
	 * @pre Currency val - the value to be set for data attribute
	 * 		LinkNode nx - the next LinkNode
	 */
	public LinkNode(Currency val, LinkNode nx)
	{
		data = val;
		next = nx;
	}
	
	/**
	 * Getter method for private attribute data Currency
	 * @return Currency data - the private attribute that is the data contained by the LinkNode
	 */
	public Currency getData()
	{
		return data;
	}
	
	/**
	 * Getter method for private attribute next LinkNode.
	 * @return LinkNode next - the private attribute that is a pointer to next LinkNode
	 */
	public LinkNode getNext()
	{
		return next;
	}
	
	/**
	 * Setter method for private attribute data Currency.
	 * @pre Currency val - new currency to be set for the data attribute
	 * @post Sets the private attribute data to given currency. 
	 */
	public void setData(Currency val)
	{
		data = val;
	}
	
	/**
	 * Setter method for private attribute next LinkNode.
	 * @pre LinkNode nx - new LinkNode to be set for the next attribute
	 * @post Sets the private attribute next to given LinkNode. 
	 */
	public void setNext(LinkNode nx)
	{
		next = nx;
	}
	
}
