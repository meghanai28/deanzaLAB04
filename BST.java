
public class BST {
	
private BSTNode root;
	
	/*
	 * 
	 */
	public BST ()
	{
		root = null;
	}
	
	/*
	 * 
	 */
	public boolean isEmpty()
	{
		return root == null;
	}
	
	
	/*
	 * 
	 */
	public int count ( )
	{
		return count(root);
	}
	
	/*
	 * 
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
	
	/*
	 * 
	 */
	public Boolean find(Currency val) throws Exception
	{
		BSTNode test = find(root,val);
		return test!=null;
	}
	
	/*
	 * 
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
	
	
	
	/*
	 * 
	 */
	public void insert(Currency value) throws Exception
	{
		BSTNode newNode = new BSTNode(value);
		root = insert(root,newNode);
	}
	
	/*
	 * 
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
	
	/*
	 * 
	 */
	public boolean delete(Currency value) throws Exception
	{
		int count = count();
		BSTNode newNode = new BSTNode(value);
		root = delete(root,newNode);
		int count1 = count();
		if(count == count1)
		{
			return false;
		}
		return true;
		
	}
	
	/*
	 * 
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
			if(r.getRightChild()== null && r.getLeftChild()== null)
			{
				return null;
			}
			else if(r.getRightChild() == null)
			{
				return r.getLeftChild();
			}
			else if(r.getLeftChild()== null)
			{
				return r.getRightChild();
			}
			else
			{
				BSTNode largest = min(r.getRightChild()); // i decided to use the smallest in right subtree as sucessor.
				Currency value = largest.getData();
				delete(root,largest);
				r.setData(value);
			}
		}
		return r;
		
	}
	
	
	/*
	 * 
	 */
	public Currency min()
	{
		return min(root).getData();
	}
	
	/*
	 * 
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
	
	/*
	 * 
	 */
	public Currency max()
	{
		return max(root).getData();
	}
	
	/*
	 * 
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
	
	/*
	 * 
	 */
	public Queue breadthTraversal() throws Exception
	{
		Queue container = new Queue();
		
		
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
	
	/*
	 * 
	 */
	public Queue preOrderTraversal()
	{
		 Queue test = new Queue();
		 preOrderTraversal(test,root);
		 return test;
	}
	
	/*
	 * 
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
	
	
	/*
	 * 
	 */
	public Queue postOrderTraversal()
	{
		 Queue test = new Queue();
		 postOrderTraversal(test,root);
		 return test;
	}
	
	/*
	 * 
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
	
	
	/*
	 * 
	 */
	public Queue inOrderTraversal()
	{
		 Queue test = new Queue();
		 inOrderTraversal(test,root);
		 return test;
	}
	
	
	/*
	 * 
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
	
	/*
	 * 
	 */
	public String print() throws Exception
	{
		String breadth = breadthTraversal().printQueue();
		String inOrder = inOrderTraversal().printQueue();
		String preOrder = preOrderTraversal().printQueue();
		String postOrder = postOrderTraversal().printQueue();
		
		return breadth + "\n" + inOrder + "\n" + preOrder + "\n" + postOrder;
	}
	
	
	
	
}
