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

	public void setRight(TreeNode r){
	    RChild = r;
	}
    }

    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;    

    private TreeNode<E> root;

    public BTree() {
	root = null;
    }

    public void add(T d){

    }

    private void add(TreeNode<T> curr, TreeNode<T> bn){

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

    }

    public void inOrder(TreeNode<T> curr){

    }

    public void postOrder(TreeNode<T> curr){

    }

    public int getHeight(){
	return getHeight(root);
    }
    public int getHeight(TreeNode<T> curr){

    }

    private String getLevel
}