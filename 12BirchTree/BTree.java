import java.io.*;
import java.util.*;

public class BTree<T>{

    public static class TreeNode<T>{
	private T data;
	private TreeNode<T> parent;
	private TreeNode<T> LChild, RChild;

	public TreeNode(T value, TreeNode p, TreeNode l, TreeNode r){
	    data = value;
	    parent = p;
	    LChild = l;
	    RChild = r;
	}

	public TreeNode(T value, TreeNode p){
	    data = value;
	    parent = p;
	    LChild = null;
	    RChild = null;
	}

	public TreeNode(T value){
       	    data = value;
	    parent = null;
	    LChild = null;
	    RChild = null;
	}

	public TreeNode(){
      	    data = null;
	    parent = null;
	    LChild = null;
	    RChild = null;
	}

	public TreeNode getParent(){
	    return parent;
	}

	public void setParent(TreeNode p){
	    parent = p;
	}

	public T getData(){
	    return data;
	}

	public void setData(T value){
	    data = value;
	}

	public void setLeft(TreeNode l){
	    LChild = l;
	}

	public TreeNode getLeft(){
	    return LChild;
	}

	public void setRight(TreeNode r){
	    RChild = r;
	}

	public TreeNode getRight(){
	    return RChild;
	}
    }

    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;    

    Random r = new Random(9001);

    private TreeNode<T> root;

    public BTree() {
	root = null;
    }

    public BTree(TreeNode r){
	root = r;
    }

    public TreeNode getRoot(){
	return root;
    }

    public void add(T d){
	TreeNode<T> a = new TreeNode(d);
	if(this.getRoot() == null){
	    root = a;
	    return;
	}
	add(this.getRoot(), a);
    }

    private void add(TreeNode<T> curr, TreeNode<T> bn){
	if(curr.getLeft() == null){
	    curr.setLeft(bn);
	    bn.setParent(curr);
	    return;
	}else if(curr.getRight() == null){
	    curr.setRight(bn);
	    bn.setParent(curr);
	    return;
	}else{
	    int c = r.nextInt(2);
	    if(c == 0){
		add(curr.getLeft(), bn);
	    }else{
		add(curr.getRight(), bn);
	    }
	}
    }

    public void traverse(int mode){
	if(mode == PRE_ORDER){
	    preOrder(root);
	}else if(mode == IN_ORDER){
	    inOrder(root);
	}else{
	    postOrder(root);
	}
	System.out.println();
    }

    public void preOrder(TreeNode<T> curr){
	if(curr != null){
	System.out.println(curr.getData());
	preOrder(curr.getLeft());
	preOrder(curr.getRight());
	}
    }



    public void inOrder(TreeNode<T> curr){
	if(curr != null){
	inOrder(curr.getLeft());
	System.out.println(curr.getData());
	inOrder(curr.getRight());
	}
    }



    public void postOrder(TreeNode<T> curr){
	if(curr != null){
	postOrder(curr.getLeft());
	postOrder(curr.getRight());
	System.out.println(curr.getData());
	}
    }



    public int getHeight(){
	return getHeight(root);
    }

    public int getHeight(TreeNode<T> curr){
	if(curr.getLeft() != null){
	    return 1+ getHeight(curr.getLeft());
	}
	if(curr.getRight() != null){
	    return 1+ getHeight(curr.getRight());
	}
	return 1;
    }

    private String getLevel(TreeNode<T> curr, int level){
	String a = "";
	if(this.getHeight() - this.getHeight(curr) == level){
	    a +=  " " + curr.getData() + ",";
	    return a;
	}
	if(curr.getLeft() != null){
	    a += getLevel(curr.getLeft(), level);
	}
	if(curr.getRight() != null){
	    a += getLevel(curr.getRight(), level);
	}
	return a;
    }

    public String toString(){
	String a = "";
	for(int i = 0; i < this.getHeight(); i++){
	    a += this.getLevel(this.getRoot(), i) + "\n";
	}
	return a;
    }

    public static void main(String[]args){
	BTree<Integer> t = new BTree<Integer>();
	for(int i = 0; i < 7; i ++){
	    t.add(i);
	}
	System.out.println( "Pre-order: ");
	t.traverse(0);
	System.out.println( "In-order: ");
	t.traverse(1);
	System.out.println( "Post-order: ");
	t.traverse(2);

	System.out.println("Height: " + t.getHeight());
	System.out.println("Height - 1: " + t.getHeight(t.getRoot().getLeft()));
	System.out.println();
	
	System.out.println("Level 2: " + t.getLevel(t.getRoot(), 2));

	System.out.println("Tree: \n" + t.toString());
    }
}
