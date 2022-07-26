/**
 * Lab 03
 * @author Lab Group 7: Meghana Indukuri & Joseph Khamisy
 * This program creates the class Queue which inherits the 
 * singlyLinkedList class. This program implements methods
 * for the Queue FIFO structure. Queue objects do not allow 
 * Linked List functions to be used on them.
 * July 20th 2022
 */
public class Queue extends SinglyLinkedList {

	/**
	 * Default Constructor which calls the super constructor
	 * to initalize a new Queue derived from the singlyLinkedList
	 */
	public Queue()
	{
		super();
	}
	
	/**
	 * Takes a Currency object as parameter and adds it to the end of the queue.
	 * @pre Currency val must not be null or exception is thrown from
	 * 		super addCurrency method.
	 * @post Exception is thrown when val is null or when the Queue is full
	 */
	public void enqueue(Currency val) 
	{
		super.addCurrency(val, super.countCurrency());
	}
	
	/**
	 * Removes and returns the Currency object from the front of the queue.
	 * @pre 
	 * @post Exception is thrown when queue is empty
	 * and the method dequeue is called.
	 * @return Currency val - the val that was dequeued off the queue
	 */
	public Currency dequeue()
	{
		
		return super.removeCurrency(0);
	}
	
	/**
	 * Returns the value at the front of the queue without
	 * modifying the queue in any way.
	 * @pre
	 * @post Throws an exception when the queue is empty and
	 * peekFront method is called.
	 * @return the Currency value that was at the front of the queue.
	 */
	public Currency peekFront() 
	{
		return super.getStart().getData();
	}
	
	/**
	 * Returns the value at the end of the queue without
	 * modifying the queue in any way.
	 * @pre
	 * @post Throws an exception when the queue is empty and
	 * peekRear method is called.
	 * @return the Currency value that was at the end of the queue.
	 */
	public Currency peekRear() 
	{
		return super.getEnd().getData();
	}
	
	/**
	 * Returns a string signifying the contents of the 
	 * queue from the front to end, spaced by a tab.(FIFO)
	 * @pre
	 * @post
	 * @return The string with the queue nodes from front 
	 * to end.
	 */
	public String printQueue() 
	{
		return super.printList();
	}
	
	
	
	
	
	/**
	 * @override
	 * This method throws an unsupportedOperationException
	 * whenever it is called on a stack object.
	 * @pre
	 * @post throws an exception
	 * 
	 */
	public LinkNode getStart()
	{
		throw new UnsupportedOperationException();
	}
	
	/**
	 * @override
	 * This method throws an unsupportedOperationException
	 * whenever it is called on a stack object.
	 * @pre
	 * @post throws an exception
	 * 
	 */
	public LinkNode getEnd() 
	{
		throw new UnsupportedOperationException();
	}
	
	/**
	 * @override
	 * This method throws an unsupportedOperationException
	 * whenever it is called on a stack object.
	 * @pre
	 * @post throws an exception
	 * 
	 */
	public int countCurrency() 
	{
		throw new UnsupportedOperationException();
	}
	
	/**
	 * @override
	 * This method throws an unsupportedOperationException
	 * whenever it is called on a stack object.
	 * @pre
	 * @post throws an exception
	 * 
	 */
	public boolean isListEmpty()
	{
		throw new UnsupportedOperationException();
	}
	
	/**
	 * @override
	 * This method throws an unsupportedOperationException
	 * whenever it is called on a stack object.
	 * @pre
	 * @post throws an exception
	 * 
	 */
	public void addCurrency(Currency value, int index) 
	{
		throw new UnsupportedOperationException();
		
		
	}
	
	/**
	 * @override
	 * This method throws an unsupportedOperationException
	 * whenever it is called on a stack object.
	 * @pre
	 * @post throws an exception
	 * 
	 */
	public Currency removeCurrency(Currency value) 
	{
		throw new UnsupportedOperationException();
					
	}
	
	/**
	 * @override
	 * This method throws an unsupportedOperationException
	 * whenever it is called on a stack object.
	 * @pre
	 * @post throws an exception
	 * 
	 */
	public Currency removeCurrency(int index) 
	{
		throw new UnsupportedOperationException();
		
	}
	
	/**
	 * @override
	 * This method throws an unsupportedOperationException
	 * whenever it is called on a stack object.
	 * @pre
	 * @post throws an exception
	 * 
	 */
	public int findCurrency(Currency value) 
	{
		throw new UnsupportedOperationException();
	}
	
	/**
	 * @override
	 * This method throws an unsupportedOperationException
	 * whenever it is called on a stack object.
	 * @pre
	 * @post throws an exception
	 * 
	 */
	public Currency getCurrency(int index) 
	{
		throw new UnsupportedOperationException();
	}
	
	/**
	 * @override
	 * This method throws an unsupportedOperationException
	 * whenever it is called on a stack object.
	 * @pre
	 * @post throws an exception
	 * 
	 */
	public String printList() 
	{
		throw new UnsupportedOperationException();
	}
	

	
}
