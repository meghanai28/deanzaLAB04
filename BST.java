import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;

/**
 * Lab 04
 * @author Lab Group 7: Meghana Indukuri & Joseph Khamisy
 * This program creates the class BST (Binary Search Tree) with private root and methods that include adding,searching and 
 * deleting nodes with Currency values.
 * July 29th 2022
 */
public class BST {
	
private BSTNode root;
	
	/**
	 * Default Constructor which sets the private attribute root to null
	 * @pre 
	 * @post private attribute root set to null
	 */
	public BST ()
	{
		root = null;
	}
	
	/**
	 * Checks to see if the Binary Search Tree is empty.
	 * @pre 
	 * @post checks if the root is equal to null
	 * @return returns true if the BST is empty, false if it is not empty.
	 */
	public boolean isEmpty()
	{
		return root == null;
	}
	
	
	/**
	 * Count returns the number of nodes in the Binary Search Tree starting at the root.
	 * @pre 
	 * @post calls a private method which recursively finds the number of nodes in the tree.
	 * @return int value with number of nodes.
	 */
	public int count ( )
	{
		return count(root);
	}
	
	/**
	 * This is a private overloaded method.Count returns the number of nodes in a BInary Search Tree 
	 * starting at a given Node. This method counts number of nodes using recursion.
	 * @pre Node which is where the counting of nodes will start
	 * @post
	 * @return int value with number of nodes starting at given node.
	 */
	private int count(BSTNode node)
	{
		if(node == null)
		{
			return 0;
		}
		else
		{
			return 1 + count(node.getLeftChild()) 
			+ count(node.getRightChild());
		}
	}
	
	/**
	 * Find returns a boolean on if the given currency Value exists in the binary search tree starting at the 
	 * root. 
	 * @pre val - the Currency to be searched for in the Binary Search Tree
	 * @post - calls a private method which recursively finds wether a currency value exists in the tree. If val is null
	 * an exception thrown.
	 * @return true if the currency val exists in the binary search tree, false otherwise. 
	 */
	public Boolean find(Currency val) throws Exception
	{
		if(val == null)
		{
			throw new IllegalArgumentException();
		}
		BSTNode test = find(root,val);
		return test!=null;
	}
	
	/**
	 * This is a private overloaded method for find. Find finds the BSTNode that contains the given
	 * currency value starting at a given node. If it is not in the binary search tree starting at a given node, 
	 * it returns a null node. 
	 * @pre node - A BSTNode where the find method will start at. Val the currency value to be searched for.
	 * @post
	 * @return BSTNode, the node that contains the currency value. If the currency value does not exist in the tree
	 * then null is returned. 
	 */
	private BSTNode find(BSTNode node, Currency val) throws Exception
	{
		if(node == null || node.getData().isEqual(val))
		{
			return node;
		}
		if(node.getData().isGreater(val))
		{
			return find(node.getLeftChild(),val);
		}
		else
		{
			return find(node.getRightChild(),val);
		}
	}
	
	
	
	/**
	 * Insert inserts a given currency value into the binary search tree starting at the root.
	 * @pre The currency value to be entered into the binary search tree
	 * @post calls a private recursive method to insert the currency value into the tree. Throws exception
	 * if the currency value is null, or if the insert causes memory to be too overflowed.
	 */
	public void insert(Currency value) throws Exception
	{
		if(value == null)
		{
			throw new IllegalArgumentException();
		}
		try
		{
			BSTNode newNode = new BSTNode(value);
			root = insert(root,newNode);
		}
		catch(OutOfMemoryError E) // overflow in tree 
		{
			throw new BufferOverflowException();
		}
	}
	
	/**
	 * This is a private overloaded method for inserting a given node starting at a given root node. Returns
	 * the root node of the new tree with the given node now inserted into the tree. This method uses recursion
	 * to insert the node at the correct spot in the tree.
	 * @pre r - the root of the tree where the node should be inserted.
	 * 		newNode - the Node to be inserted into the tree
	 * @post 
	 * @return return the root of the tree with the newNode inserted into the tree. 
	 */
	private BSTNode insert(BSTNode r, BSTNode newNode) throws Exception
	{
		if (r == null)
		{
			return newNode;
		}
		else
		{
			if(newNode.getData().isGreater(r.getData()))
			{
				r.setRightChild(insert(r.getRightChild(),newNode));
			}
			else
			{
				r.setLeftChild(insert(r.getLeftChild(),newNode));
			}
		}
		return r;
		
	}
	
	/**
	 * This method delete deletes a given currency value from the binary search tree.
	 * If the value is not in the tree, the delete method returns false to signify nothing was 
	 * deleted.
	 * @pre value - The currency value to be deleted from the tree.
	 * @post uses the private overloaded method delete, and the find method. If value is null then an exception
	 * is thrown.
	 * @return true, if a node was deleted and false when a node was not deleted.
	 */
	public boolean delete(Currency value) throws Exception
	{
		if(value == null)
		{
			throw new IllegalArgumentException();
		}
		if(!find(value)) // check if value exists in tree
		{
			return false;
		}
		BSTNode newNode = new BSTNode(value);
		root = delete(root,newNode);
		
		return true;
		
	}
	
	/**
	 * This is a private overloaded method that deletes a given node starting at a given root. This 
	 * method uses recursion to delete the given node. It returns the root of the tree with the deleted node.
	 * @pre r - the root of the tree where the node should be deleted.
	 * 		newNode - the Node to be deleted from the tree
	 * @post makes use of the private recurisve overloaded method min. 
	 * @return the root of the tree with the newly deleted node. 
	 */
	private BSTNode delete(BSTNode r, BSTNode newNode) throws Exception
	{
		if(r == null)
		{
			return null;
		}
		if(r.getData().isGreater(newNode.getData()))
		{
			r.setLeftChild(delete(r.getLeftChild(),newNode));
		}
		else if(!r.getData().isEqual(newNode.getData()))
		{
			r.setRightChild(delete(r.getRightChild(),newNode));
		}
		else
		{
			if(r.getRightChild()== null && r.getLeftChild()== null) // both child null case
			{
				return null;
			}
			else if(r.getRightChild() == null) // right child null case
			{
				return r.getLeftChild();
			}
			else if(r.getLeftChild()== null) // left child null case
			{
				return r.getRightChild();
			}
			else // both child not null case
			{
				BSTNode largest = min(r.getRightChild()); // i decided to use the smallest in right subtree as sucessor.
				Currency value = largest.getData();
				delete(root,largest);
				r.setData(value);
			}
		}
		return r;
		
	}
	
	
	/**
	 * Returns the minimum currency value starting at the root.
	 * @pre
	 * @post makes use of private overloaded recursive method min. Throws an exception if the tree is null.
	 * @return the currency value of the minimum value in the binary search tree.
	 */
	public Currency min()
	{
		if(root == null)
		{
			throw new BufferUnderflowException();
		}
		return min(root).getData();
	}
	
	/**
	 * This is a private recurisve method that finds the minimum node starting at a given node. It returns the 
	 * node that is the minimum.
	 * @pre the node which the search for minimum node will begin.
	 * @post 
	 * @return the Node that is the minimum node.
	 */
	private BSTNode min(BSTNode node) 
	{
		if(node == null)
		{
			return null;
		}
		if(node.getLeftChild() == null)
		{
			return node;
		}
		
		return	min(node.getLeftChild());
			
	}
	
	/**
	 * Returns the maximum currency value starting at the root.
	 * @pre
	 * @post makes use of private overloaded recursive method max. Throws an exception if the tree is null.
	 * @return the currency value of the maximum value in the binary search tree.
	 */
	public Currency max()
	{
		if(root == null)
		{
			throw new BufferUnderflowException();
		}
		return max(root).getData();
	}
	
	/**
	 * This is a private recurisve method that finds the maximum node starting at a given node. It returns the 
	 * node that is the maximum.
	 * @pre the node which the search for maximum node will begin.
	 * @post 
	 * @return the Node that is the maximum node.
	 */
	private BSTNode max(BSTNode node) 
	{
		if(node == null)
		{
			return null;
		}
		if(node.getRightChild() == null)
		{
			return node;
		}
		
		return	max(node.getRightChild());
			
	}
	
	/**
	 * This method returns a queue containing the traversal of the binary search tree in breadth order traversal.
	 * @pre 
	 * @post this method is done iteratively using two queues.
	 * @return a queue containing the breadth order traversal of the binary search tree.
	 */
	public Queue breadthTraversal() throws Exception
	{
		Queue container = new Queue();
		
		if(root == null)
		{
			return container;
		}
		
		Queue traverse = new Queue();
		traverse.enqueue(root.getData());
		
		while(true)
		{
			try
			{
				traverse.peekFront();
			}
			catch(Exception e)
			{
				break;
			}
			
			BSTNode node = find(root,traverse.dequeue());
			container.enqueue(node.getData());
			
			if(node.getLeftChild() != null)
			{
			  traverse.enqueue(node.getLeftChild().getData());
			}
	        if(node.getRightChild() != null) 
	        {
	        	traverse.enqueue(node.getRightChild().getData());
	        }
		}
		
		
		return container;
	}
	
	/**
	 * Returns a queue with the binary search tree in preOrder traversal.
	 * @pre
	 * @post uses a private, overloaded recursive method to get the queue with pre order traversal
	 * @return the queue with currency values from the binary search tree in pre order traversal.
	 */
	public Queue preOrderTraversal()
	{
		 Queue test = new Queue();
		 preOrderTraversal(test,root);
		 return test;
	}
	
	/**
	 * This is a private overloaded recurisve method, that traverses through the tree starting at a given node
	 * in pre order manner. 
	 * @pre test - the Queue which will contain the preOrder traversal of the tree.
	 * 		node - the node which the traversal will start at.
	 * @post
	 */
	private void preOrderTraversal(Queue test , BSTNode node)
	{
		
		if(node == null)
		{
			return;
		}
		
		test.enqueue(node.getData());
		preOrderTraversal(test,node.getLeftChild());
		preOrderTraversal(test,node.getRightChild());
	}
	
	
	/**
	 * Returns a queue with the binary search tree in postOrder traversal.
	 * @pre
	 * @post uses a private, overloaded recursive method to get the queue with post order traversal
	 * @return the queue with currency values from the binary search tree in post order traversal.
	 */
	public Queue postOrderTraversal()
	{
		 Queue test = new Queue();
		 postOrderTraversal(test,root);
		 return test;
	}
	
	/**
	 * This is a private overloaded recurisve method, that traverses through the tree starting at a given node
	 * in post order manner. 
	 * @pre test - the Queue which will contain the postOrder traversal of the tree.
	 * 		node - the node which the traversal will start at.
	 * @post
	 */
	private void postOrderTraversal(Queue test , BSTNode node)
	{
		
		if(node == null)
		{
			return;
		}
		postOrderTraversal(test,node.getLeftChild());
		postOrderTraversal(test,node.getRightChild());
		test.enqueue(node.getData());
	}
	
	
	/**
	 * Returns a queue with the binary search tree in inOrder traversal.
	 * @pre
	 * @post uses a private, overloaded recursive method to get the queue with inorder traversal
	 * @return the queue with currency values from the binary search tree in inorder traversal.
	 */
	public Queue inOrderTraversal()
	{
		 Queue test = new Queue();
		 inOrderTraversal(test,root);
		 return test;
	}
	
	
	/**
	 * This is a private overloaded recurisve method, that traverses through the tree starting at a given node
	 * in  inorder manner. 
	 * @pre test - the Queue which will contain the inOrder traversal of the tree.
	 * 		node - the node which the traversal will start at.
	 * @post
	 */
	private void inOrderTraversal(Queue test , BSTNode node)
	{
		
		if(node == null)
		{
			return;
		}
		inOrderTraversal(test,node.getLeftChild());
		test.enqueue(node.getData());
		inOrderTraversal(test,node.getRightChild());
	}
	
	/**
	 * Returns a string with all the 4 traversals in the specific order of breadth, inorder, preorder, and postorder.
	 * @pre
	 * @post
	 * @return string with all 4 traversals
	 */
	public String print() throws Exception
	{
		String breadth = breadthTraversal().printQueue();
		String inOrder = inOrderTraversal().printQueue();
		String preOrder =preOrderTraversal().printQueue();
		String postOrder=postOrderTraversal().printQueue();
		
		return breadth + "\n\n" + inOrder + "\n\n" + preOrder + "\n\n" + postOrder;
	}
	
	/**
	* Emptys the tree by setting the root to null
	* @pre 
	* @post root is set to null.
	*/
	public void empty()
	{
		root = null;
	}
	
	
}
