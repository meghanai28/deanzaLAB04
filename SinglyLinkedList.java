/**
 * Lab 03
 * @author Lab Group 7: Meghana Indukuri & Joseph Khamisy
 * This program creates the class SinglyLinkedList with private attributes and methods that include adding and 
 * deleting nodes with given indexes and Currency values.
 * July 20th 2022
 */

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.util.NoSuchElementException;

public class SinglyLinkedList {
	
	private int count;// number of nodes in list
	private LinkNode start; // head node
	private LinkNode end; // tail node
	
	/**
	 * Default constructor, sets both start and end nodes to null
	 * and sets the count to 0.
	 */
	public SinglyLinkedList()
	{
		start = null;
		end = null;
		count = 0;
	}
	
	/**
	 * Getter method for starting node
	 * @pre the linked list must not be empty
	 * @post throws a noSuchElementException whenever the singlyLinkedList is empty.
	 * @return the start Linknode.
	 */
	public LinkNode getStart() 
	{
		if(start == null)
		{
			throw new NoSuchElementException();
		}
		return start;
	}
	
	/**
	 * Getter method for ending node
	 * @pre the linked list must not be empty
	 * @post throws a noSuchElementException whenever the singlyLinkedList is empty.
	 * @return the end Linknode.
	 */
	public LinkNode getEnd() 
	{
		if(end == null)
		{
			throw new NoSuchElementException();
		}
		return end;
	}
	
	/**
	 * Returns the count value (i.e the number of nodes)
	 * @pre
	 * @post
	 * @return returns the private attribute int count.
	 */
	public int countCurrency() 
	{
		return count;
	}
	
	/**
	 * Checks if the list is empty and returns true or false based on if its empty
	 * @pre
	 * @post
	 * @return if the list is empty, the method returns true, false otherwise.
	 */
	public boolean isListEmpty()
	{
		return start == null;
	}
	
	
	/**
	 * adds a LinkNode to the singlyLinkedList based on a given Currency value and a given index for placement of
	 * the node. 
	 * @pre Currency value - the value of the node to be added. value should not be null
	 * 		int index - the index of where the new node should be added. Index should be in bounds.
	 * 
	 * @post if any of the parameters are null or out of bounds an exception is thrown. If there is no more memory
	 * an overflow exception is thrown. Otherwise a node is added to the singlyLinkedList if all conditions are
	 * met and then count is incremented.
	 */
	public void addCurrency(Currency value, int index) 
	{
		try
		{
			if(value == null || index<0 || index> count)
			{
				throw new IllegalArgumentException();
			}
		
			LinkNode added = new LinkNode(value);
			if(start == null && index == 0)
			{
				start = added;
				end = added;
			}
			else if(start!= null && index ==0)
			{
				added.setNext(start);
				start = added;
			}
			else if(index == count)
			{
				end.setNext(added);
				end = added;
			}
			else
			{
				LinkNode prev = null;
				LinkNode curr = start;
				for(int i =0; i<index; i++)
				{
					prev = curr;
					curr = curr.getNext();
				}
				added.setNext(curr);
				prev.setNext(added);
			}
			count++;
		}
		catch(OutOfMemoryError E)
		{
			throw new BufferOverflowException();
		}
		
	}
	
	
	/**
	 * Removes the first Node that has the same data value as the given currency value.
	 * @pre Currency value - the value to be searched for and deleted. Cannot be null
	 *  
	 * @post  if the parameter is null, a exception is thrown. If the list is empty and the remove method is
	 * called, an exception is also thrown. Otherwise the currency is searched for and removed.count is decremented.
	 * However if the method cannot find a matching node to the given currency value, nothing is deleted. 
	 * @return Currency the removed node's value, returns null if value
	 * does not exist in linkedList
	 */
	public Currency removeCurrency(Currency value) throws Exception 
	{
		if(value == null)
		{
			throw new IllegalArgumentException();
		}
		if( start == null)
		{
			throw new BufferUnderflowException();
		}
		
		LinkNode prev = null;
		LinkNode curr = start;
		
		while(!curr.getData().isEqual(value) && curr.getNext()!= null)
		{
			prev = curr;
			curr = curr.getNext();
		}
		
		if(curr.getData().isEqual(value))
		{
			if(curr == start)
			{
				start = curr.getNext();
				if(count == 1)
				{
					end = null;
				}
			}
			else
			{
				if(curr== end)
				{
					end = prev;
				}
				prev.setNext(curr.getNext());
				
			}
			count--;
			return curr.getData();
		}
		return null;
	}
	
	
	
	/**
	 * Removes the node in the singlyLinkedList at the given index and returns the node's currency value.
	 * @pre int index - the index where the node should be deleted. Cannot be an outbounds/invalid index.
	 * 
	 * @post if the list is empty, and the remove method is called, there is an underflow exception thrown.
	 * Otherwise, the node at the index is removed and the count is decremented.
	 * @return Currency the removed node's value
	 */
	public Currency removeCurrency(int index) 
	{
		if( start == null )
		{
			throw new BufferUnderflowException();
		}
		
		if(index<0 || index>=count)
		{
			throw new IllegalArgumentException();
		}
		
		
		LinkNode prev = null;
		LinkNode curr = start;

		if(index ==0)
		{	
			start = curr.getNext();	
			if(count == 1)
			{
				end = null;
			}	
		}
		else
		{
			
			for(int i =0; i<index; i++)
			{
				prev = curr;
				curr = curr.getNext();		
			}
			
			if(end == curr)
			{
				end = prev;
			}
			
			prev.setNext(curr.getNext());
		}
		count--;
		return curr.getData();
		
	}
	
	
	/**
	 * Finds the index of given Currency Value. If no node matches the given currency value
	 * -1 is returned. 
	 * @pre Given currency value to be searched for. Value cannot be null
	 * @post if the given parameter is null, an exception is thrown. Or if the linkedList is empty exception is thrown.
	 * @return int, the index of the given currency value. If no node matches given
	 * value then -1 is returned to signify that. 
	 */
	public int findCurrency(Currency value) throws Exception 
	{
		if( start == null)
		{
			throw new IllegalStateException();
		}
		
		if(value == null)
		{
			throw new IllegalArgumentException();
		}

		LinkNode temp = start;
		int index =0;
		while(temp!=null && !temp.getData().isEqual(value))
		{
			temp = temp.getNext();
			index++;
		}
		if(temp == null)
		{
			return -1;
		}
		return index;
	}
	
	
	/**
	 * Gets the given node at a given index. if the list is empty, the node returned is null.
	 * @pre int index - the index at which the node should be retrieved. index cannot be outofbounds/invalid.
	 * @post throws exception when the index is outofbounds/invalid, or if the linkedlist is empty.
	 * @return Currency at given index. if list empty, node returned is null.
	 */
	public Currency getCurrency(int index) 
	{
		if( start == null)
		{
			throw new IllegalStateException();
		}
		
		if(index<0 || index>= count)
		{
			throw new IllegalArgumentException();
		}
		
		LinkNode temp = start;
		for(int i =0; i<index; i++)
		{
			temp = temp.getNext();
		}
		
		return temp.getData();
	}
	
	
	/**
	 * Returns a string with each Node value seperated by a tab in order of the index.
	 * @pre
	 * @post
	 * @return a string with each Node value seperated by a tab in order of the index.
	 */
	public String printList() 
	{
		LinkNode temp = start;
		String val = "";
		while(temp != null)
		{
			val += temp.getData()+ "	";
			temp = temp.getNext();
		}
		
		return val;
	}

	
	
}
