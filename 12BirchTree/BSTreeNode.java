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

    public boolean hasLeft() {
	return left != null;
    }

    public boolean isLeaf() {
      return (left == null && right == null);
    }

    public int compareTo(BSTreeNode<T> other){
	return data.compareTo(other.getData());
    }

    public int compareTo(T value){
	return data.compareTo(value);
    }

    public String toString() {
	return data + "";
    }
}


