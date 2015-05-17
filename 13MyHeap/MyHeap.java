import java.util.*;

public class MyHeap{
    boolean isMax;
    int[] heap;

    public MyHeap(){
	isMax = true;
	heap = new int[10];
	heap[0] = 0;
    }

    public MyHeap(boolean isMax){
	this.isMax = isMax;
	heap = new int[10];
	heap[0] = 0;
    }

    public String name(){
	return "dickersin.nino";
    }

    public void add(int x){
	boolean notOrdered = true;
	heap[0] = heap[0] + 1;
	if(heap[0] >= heap.length){
	    this.enlarge();
	}
	heap[heap[0]] = x;
	int index = heap[0];
	while(notOrdered){
	    if(index == 1){
		notOrdered = false;
	    }else if(isMax){
		if(heap[index] > heap[index/2]){
		    this.swap(index, index/2);
		    index = index / 2;
		}else{
		    notOrdered = false;
		}
	    }else{
		if(heap[index] < heap[index/2]){
		    this.swap(index, index/2);
		    index = index / 2;
		}else{
		    notOrdered = false;
		}
	    }
	}
    }

    public void enlarge(){
	int[] copy = new int[heap[0] * 2];
	copy[0] = heap[0];
	for(int i = 1; i < heap.length; i ++){
	    copy[i] = heap[i];
	}
	heap = copy;
    }

    public void swap(int a, int b){
	int temp = heap[a];
	heap[a] = heap[b];
	heap[b] = temp;
    }

    public int peek(){
	if(heap[0] <= 0){
	    throw new NoSuchElementException();
	}
	return heap[1];
    }

    public int size(){
	return heap[0];
    }

    public int remove(){
	if(heap[0] <= 0){
	    throw new NoSuchElementException();
	}
	int a = peek();
	for(int i = 1; i < heap.length - 1; i++){
	    if(i + 1 == heap.length && heap[i] != 0){
		heap[i] = 0;
	    }else{
		heap[i] = heap[i + 1]; 
	    }
	}
	heap[0] = heap[0] - 1;
	return a;
    }

    public String toStringArray(){
	return Arrays.toString(heap);
    }

    public String toString(){
	String a = "";
	int rowCount = 0;
	int power = 0;
	for(int i = 1; i <= heap[0]; i++){
	    a += heap[i] + " ";
	    rowCount++;
	    if(rowCount == (int)Math.pow(2, power)){
		power++;
		a +="\n";
		rowCount = 0;
	    }
	}
	return a;
    }

    public static void main(String[]args){
	MyHeap a = new MyHeap(true);
	/**
	for(int i = 0; i <=10; i++){
	    a.add(2*i);
	}
	**/
	a.add(7);
	a.add(5);
	a.add(3);
	a.add(8);
	a.add(9);
	a.add(10);
	a.add(4);
	//	a.remove();
	//	System.out.println(a.peek());
	System.out.println(a.toStringArray());
	System.out.println(a);
    }
}
