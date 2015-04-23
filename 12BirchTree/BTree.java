import java.io.*;
import java.util.*;

public class BTree<T>{

    public class TreeNode<T>{
	private T data;
	private TreeNode<T> parent;
	private TreeNode<T> LChild, RChild;

	public TreeNode(){
	    TreeNode(null);
	}

	public TreeNode(T value){
	    TreeNode(value, null);
	}

	public TreeNode(T value, TreeNode p){
	    TreeNode(value, p, null, null);
	}

	public TreeNode(T value, TreeNode p, TreeNode l, TreeNode r){
	    data = value;
	    parent = p;
	    LChild = l;
	    RChild = r;
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

    Random r = new Random(421);

    private TreeNode<E> root;

    public BTree() {
	root = null;
    }

    public BTree(TreeNode r){
	root = r;
    }

    public void add(T d){
	TreeNode<T> = new TreeNode(d);
    }

    private void add(TreeNode<T> curr, TreeNode<T> bn){
	if(curr.getLeft() == null){
	    curr.setLeft(bn);
	    return;
	}else if(curr.getRight() == null){
	    curr.setRight(bn);
	    return;
	}else{
	    int c = r.nextInt(2);
	    if(c == 0){
		add(curr.getLeft(), bn);
	    }else{
		add(curr.getRight(), bn
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
	String a = "[";
	a += curr.getData(); + ", ";
	
    }

    public void inOrder(TreeNode<T> curr){
	String a = "";
    }

    public void postOrder(TreeNode<T> curr){
	String a = "";
    }

    public int getHeight(){
	return getHeight(root);
    }
    public int getHeight(TreeNode<T> curr){

    }

    private String getLevel(TreeNode<T> curr, int level, int currLevel){
	return "";
    }

    public String toString(){
	return "";
    }

    public static void main(String[]args){

    }
}