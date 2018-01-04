/*
 * This class holds an Integer value that functions as one element in a binary search tree. Using this class, you can get references to the two nodes below it as well as access the
 * value of the node itself.
 */
public class TreeNode {
	//the value that is stored in the node
	private Integer value;
	//the reference to the right hand side node
	private TreeNode right;
	//the reference to the left hand side node
	private TreeNode left;
	
	/*
	 * constructs a TreeNode with the given val. sets the left and right references to null
	 * param: Integer val, the value stored by the node
	 * returns: none 
	 */
	public TreeNode(Integer val){
		value = val;
		right = null;
		left = null;
	}
	/*
	 * constructs a TreeNode with the given val. sets the left and right references to the given references
	 * param: Integer val, the value stored by the node, TreeNode right and left, the two nodes below the constructed node.
	 * returns: none 
	 */
	public TreeNode(Integer val, TreeNode left, TreeNode right){
		this.value = val;
		this.right = right;
		this.left = left;
	}
	/*
	 * returns the value stored by the node
	 * param: none
	 * return: Integer value, the value stored by the Node
	 */
	public Integer getValue(){return value;}
	/*
	 * returns the left node reference
	 * param: none
	 * return: Integer value, the value stored by the Node
	 */
	public TreeNode getLeft(){return left;}
	/*
	 * returns the right node reference
	 * param: none
	 * return: Integer value, the value stored by the Node
	 */
	public TreeNode getRight(){return right;}
	/*
	 * sets the current node value
	 * param: Integer value, the new value of the node
	 * return: none
	 */
	public void setValue(Integer val){value = val;}
	/*
	 * sets the left node reference
	 * param: treeNode the new node reference
	 * return: none
	 */
	public void setLeft(TreeNode left){this.left = left;} 
	/*
	 * sets the right node reference
	 * param: treeNode the new node reference
	 * return: none
	 */
	public void setRight(TreeNode right){this.right = right;} 

}
