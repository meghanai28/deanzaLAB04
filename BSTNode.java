public class BSTNode {
	private Dollar data;
	private BSTNode rightChild;
	private BSTNode leftChild;
	
	public BSTNode ()
	{
		data = null;
		rightChild = null;
		leftChild = null;
	}
	
	public BSTNode (Dollar d)
	{
		data = d;
		rightChild = null;
		leftChild = null;
	}
	
	public BSTNode (Dollar d, BSTNode r, BSTNode l)
	{
		data = d;
		rightChild = r;
		leftChild = l;
	}
	
	public Dollar getData()
	{
		return data;
	}
	
	public void setData(Dollar d)
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
