
public class BSTNode {
	private Currency data;
	private BSTNode rightChild;
	private BSTNode leftChild;
	
	public BSTNode ()
	{
		data = null;
		rightChild = null;
		leftChild = null;
	}
	
	public BSTNode (Currency d)
	{
		data = d;
		rightChild = null;
		leftChild = null;
	}
	
	public BSTNode (Currency d, BSTNode r, BSTNode l)
	{
		data = d;
		rightChild = r;
		leftChild = l;
	}
	
	public Currency getData()
	{
		return data;
	}
	
	public void setData(Currency d)
	{
		data = d;
	}
	
	public BSTNode getRightChild()
	{
		return rightChild;
	}
	
	public void setRightChild(BSTNode r)
	{
		rightChild = r;
	}
	
	public BSTNode getLeftChild()
	{
		return leftChild;
	}
	
	public void setLeftChild(BSTNode l)
	{
		leftChild = l;
	}
}
