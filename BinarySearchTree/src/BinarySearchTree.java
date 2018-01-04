/*
 * $iddharth $alunkhe
 * This class represents a Binary search tree of integer TreeNodes where the smaller values are to the left of the root node and larger/equal
 * values are to the right. This makes ordering and finding values in the binary search tree much easier. The search tree can be traversed in
 * preorder, inorder and postorder routines.
 */
public class BinarySearchTree {
	//root node of the tree
	private TreeNode root;
	//keep track of the number of elements in the tree
	private int size;
	
	/*
	 * constructs a BinarySearchTree with a given integer value for the root
	 * 
	 * parameters: Integer root, the non-primitive version of integer values to create a new Node with. The root node is set to this node
	 * return: none
	 */
	public BinarySearchTree(Integer root){
		this.root = new TreeNode(root);
		size = 1;
	}
	/*
	 * adds an Integer value to the binary search tree. Values smaller than the root are added to the left, values larger/equal to the root
	 * are added to the right of the root. size is incremented as a value is added.
	 * 
	 * parameters: Integer val, the value you want to add to the binary search tree
	 * 
	 * returns: none
	 */
	public void add(Integer val){
		add(val,root);
		size++;
	}
	/*
	 * private helper method that actually does the work for add(Integer val). It recursively checks if the given node has a left/ right
	 * child node, and adds the value if there isn't. 
	 * parameters: Integer val, the value to be added; TreeNode node, the node which you want to add underneath and check its children 
	 * 												   for available spots to add the value.
	 * 
	 * returns: none
	 */
	private void add(Integer val, TreeNode node){
		if(val > node.getValue()){
			if(node.getRight() == null){
				node.setRight(new TreeNode(val));
				return;
			}
			else{
				add(val,node.getRight());
			}
		}
		else{
			if(node.getLeft() == null){
				node.setLeft(new TreeNode(val));
				return;
			}
			else{
				add(val,node.getLeft());
			}
		}
	}
	/*
	 * This method checks if the given value is in the binary search tree.
	 * 
	 * Parameters: Integer val, the value you are checking if it exists in the tree
	 * returns: true if it does exist in the tree. false if it doesn't
	 */
	public boolean contains(Integer val){
		return contains(val,root);
	}
	/*
	 * this helper method uses the given TreeNode to recursively check if the node has the given value. Otherwise it checks the right and left halves of the binary tree under the 
	 * given node. 
	 * Parameters: Integer val, the value you are checking if it exists in the tree; TreeNode node, the node that you are checking for the given value and all the values underneath it
	 */
	private boolean contains(Integer val, TreeNode node){
		boolean b = false;
		if(node != null){
			if(node.getValue() == val){
				return true;
			}
			b = contains(val, node.getLeft());
			if(b == true){
				return b;
			}
			b = contains(val, node.getRight());
			if(b == true){
				return b;
			}
		}
		return b;
	}
	/*
	 * returns the number of elements (nodes) in the search tree
	 * 
	 * parameters: none
	 * returns: int size, the number of elements in the tree
	 */
	public int size(){
		return size;
	}
/*
 	public int size(TreeNode node,int count){
 	
 	if(node.getLeft() != null){
			 count += size(node.getLeft(), count + 1);
		}
		
		count += 1;
		
		if(node.getRight() != null){
			count += toString(node.getRight(),count + 1);
		}
		return count;
 	}
 */
	/*
	 * returns an inorder String representation of the binary search tree. The left node is processed first, then the root, then the right node
	 * 
	 * parameters: none
	 * returns String str, the values of the binary search tree in left-root-right order (in order traversal).
	 */
	public String toString(){
		return "[" +  toString(root) + "]";
	}
	/*
	 * helper method for representing the binary search tree in inorder traversal. uses the given treeNode to recursively get the String on
	 * the right of the node and the left of the node and appropriately concatenates it to the value of the node in inorder.
	 * 
	 * parameters: TreeNode, the node of wich you get the string representation of the left and right
	 * returns: the string representation of everything under and including the given node 
	 */
	private String toString(TreeNode node){
		String str = "";
		if(node != null){
		str += toString(node.getLeft());
		
		str +=  node.getValue()  + " , ";
		
		str +=  toString(node.getRight());
		}
		return str;
	}
	/*
	 * returns an preorder String representation of the binary search tree. The root node is processed first, then the left, then the right node
	 * 
	 * parameters: none
	 * returns String str, the values of the binary search tree in root-left-right order (pre order traversal).
	 */
	public String preorderToString(){
		return "[" +preorderToString(root)+ "]";
	}
	/*
	 * helper method for representing the binary search tree in preorder traversal. uses the given treeNode to recursively get the String on
	 * the right of the node and the left of the node and appropriately concatenates it to the value of the node in preorder.
	 * 
	 * parameters: TreeNode, the node of which you get the string representation of the left and right
	 * returns: the string representation of everything under and including the given node 
	 */
	private String preorderToString(TreeNode node){
		String str = "";
		if(node != null){
			str +=  node.getValue() + " , ";
			
			str += toString(node.getLeft());
			
			str +=  toString(node.getRight());
			}
			return str;
		
	}
	/*
	 * returns an postorder String representation of the binary search tree. The left node is processed first, then the right, then the root node
	 * 
	 * parameters: none
	 * returns String str, the values of the binary search tree in left-right-root order (in order traversal).
	 */
	public String postorderToString(){
		return"[" + postorderToString(root)+ "]";
	}
	/*
	 * helper method for representing the binary search tree in postorder traversal. uses the given treeNode to recursively get the String on
	 * the right of the node and the left of the node and appropriately concatenates it to the value of the node in postorder.
	 * 
	 * parameters: TreeNode, the node of wich you get the string representation of the left and right
	 * returns: the string representation of everything under and including the given node 
	 */
	private String postorderToString(TreeNode node){
		String str = "";
		if(node != null){
			str += postorderToString(node.getLeft());
			
			str +=  postorderToString(node.getRight());
			
			str +=   node.getValue() + " , ";
		
			}
			return str;
	}
	public static void main(String[] args){
		BinarySearchTree tree = new BinarySearchTree(20);
		System.out.println(tree.size());
		tree.add(70);
		tree.add(12);
		tree.add(10);
		tree.add(9);
		System.out.println(tree.size());
		tree.add(33);
		tree.add(-2);
		tree.add(0);
		tree.add(7);
		tree.add(80);
		tree.add(106);
		System.out.println(tree.size());
		tree.add(13);
		tree.add(-20);
		tree.add(20);
		tree.add(69);
		System.out.println(tree.size());
		
		System.out.println(tree.postorderToString());
		System.out.println(tree.preorderToString());
		System.out.println(tree);
		System.out.println(tree.contains(20));
		System.out.println(tree.contains(106));
		System.out.println(tree.contains(-20));
		System.out.println(tree.contains(-4));
		System.out.println(tree.contains(9));
		System.out.println(tree.contains(33));
		System.out.println(tree.contains(-80));
		System.out.println(tree.contains(69));
	}
	
	
}

