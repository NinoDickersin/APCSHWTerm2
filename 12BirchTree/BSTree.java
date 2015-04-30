//
//
//Your binary search tree Node skeleton file:


import java.io.*;
import java.util.*;

public class BSTreeNode<T extends Comparable> {


    private int tally;
    private T data;
    private BSTreeNode<T> left;
    private BSTreeNode<T> right;

    public BSTreeNode( T d ) {
	tally = 1;
	data = d;
	left = right = null;
    }
    
    //accessors
    public T getData() {
	return data;
    }
    public int getTally(){
	return tally;
    }
    public BSTreeNode<T> getLeft() {
	return left;
    }
    public BSTreeNode<T> getRight() {
	return right;
    }

    //mutators
    public void setData( T d ) {
	data = d;
    }
    public void setLeft( BSTreeNode<T> l ) {
	left = l;
    }
    public void setRight( BSTreeNode<T> r ) {
	right = r;
    }
    public void addTally(){
	tally++;
    }
}



//
//
//Your binary search tree skeleton file:


import java.io.*;
import java.util.*;

public class BSTree <T extends Comparable> {

    private BSTreeNode<T> root;

    public BSTree() {
	root = null;
    }

    public boolean isEmpty() {
	return root == null;
    }
    public boolean isLeaf( BSTreeNode<T> t ) {
	return (t.getLeft() == null && t.getRight() == null);
    }

    /*======== public void add() ==========
      Inputs:   T c  
      Returns: 

      Wrapper for the recursive add method
      ====================*/
    public void add( T c ) {
	root = add( root, new BSTreeNode<T>(c) );
    }

    /*======== public BSTreeNode<T> add() ==========
      Inputs:  BSTreeNode<T> curr
               BSTreeNode<T> t 
      Returns: 

      Add t to the correct place in the tree rooted at curr.
      ====================*/
    private BSTreeNode<T> add(BSTreeNode<T> curr, BSTreeNode<T> t) {
	if(curr == null){
	    return t;
	}else if(){

	}else if(t.compareTo){
	    curr.setLeft( add( root.getLeft(), tn));
	}
	return null;
    }

    /*======== public void remove() ==========
      Inputs:   T c  
      Returns: 
      
      Wrapper for the recursive remove method
      ====================*/
    public void remove( T c ) {
	root = remove( root, c );
    }

    /*======== public BSTreeNode<T> remove() ==========
      Inputs:   BSTreeNode<T> curr
		T c
      Returns: 

      Should remove the value c from the tree rooted at
      curr, if it exists.
      ====================*/
    private BSTreeNode<T> remove( BSTreeNode<T> curr, T c ) {
	return null;
    }


    /*======== public void inOrder()) ==========
      Inputs:   
      Returns: 

      Wrapper for the recursive inOrder method
      ====================*/
    public void inOrder() {
	inOrderHelper( root );
	System.out.println();
    }

    /*======== public void inOrderHelper() ==========
      Inputs:   BSTreeNode<T> t  
      Returns: 
      
      Performs an in-order traversal for the tree with 
      root t.
      ====================*/
    public void inOrderHelper( BSTreeNode<T> t ) {
	if (t == null) 
	    return;
	inOrderHelper( t.getLeft() );
	System.out.print( t.getData() + " ");
	inOrderHelper( t.getRight() );
    }

    public String toString() {
	String result = "";
	if (root != null) {
	    int height = getHeight();
	    for (int level = 1; level <= height; level++)
		result += spaces(Math.pow(2, height - level) - 1) +
		    getLevel(root, level, level, height).replaceFirst("\\s+$", "") +
		    "\n";
	}
	return result;
    }

    private String getLevel(TreeNode<E> curr, int currLevel, int targetLevel, int height) {
	if (currLevel == 1)
	    return curr.toString() + spaces(Math.pow(2, height - targetLevel + 1) - 1);
	String result = "";
	if (curr.getLeft() != null)
	    result += getLevel(curr.getLeft(), currLevel - 1, targetLevel, height);
	else result += spaces(Math.pow(2, height - targetLevel + currLevel - 1));
	if (curr.getRight() != null)
	    result += getLevel(curr.getRight(), currLevel - 1, targetLevel, height);
	else result += spaces(Math.pow(2, height - targetLevel + currLevel - 1));
	return result;
    }
    public static void main( String[] args ) {

    }

}