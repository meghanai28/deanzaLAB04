
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
	public int countNodes ( )
	{
		return countNodes(root);
	}
	
	/*
	 * 
	 */
	private int countNodes(BSTNode node)
	{
		if(node == null)
		{
			return 0;
		}
		else
		{
			return 1 + countNodes(node.getLeftChild()) 
			+ countNodes(node.getRightChild());
		}
	}
	
	/*
	 * 
	 */
	public Dollar min()
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
	public Dollar max()
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
	public void insert(Dollar value) throws Exception
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
	public void delete(Dollar value) throws Exception
	{
		BSTNode newNode = new BSTNode(value);
		root = delete(root,newNode);
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
				BSTNode largest = min(r.getRightChild());
				Dollar value = largest.getData();
				delete(root,largest);
				r.setData(value);
			}
		}
		return r;
		
	}
	
	
	
	
	
	
	
	
	
}
