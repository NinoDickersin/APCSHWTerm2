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

    public int compareTo(BSTreeNode<T> other){
	return (this.getData()).compareTo(other.getData());
    }

    public int compareTo(T value){
	return (this.getData()).compareTo(value);
    }
}


