import java.util.*;

public class MyDeque<T>{

    public Object[] queue;
    public int head;
    public int tail;
    public int size;
    public int[] priority;

    public MyDeque(){
	queue = new Object[10];
	head = 1;
	tail = 0;
	size = 0;
	priority = new int[10];
    }

    public void add(T value, int pri){
	priority[head] = pri;
	addFirst(value);
    }

    public T removeSmallest(){
	int smallSpot = head;
	for(int i = head + 1; i != tail; i ++){
	    if(i >= queue.length){
		i = 0;
	    }
	    if(priority[smallSpot] > priority[i]){
		smallSpot = i;
	    }
	}
	T smallest = queue[smallSpot];
	queue[smallSpot] = queue[head];
	priority[smallSpot] = priority[head];
	queue[head] = null;
	priority[head] = null;
	if(head > tail){
	    head ++;
	}else{
	    head --;
	}
	if(head > length()){
	    head = 0;
	}else if(head < 0){
	    head = length() - 1;
	}
    }
    
    public void addFirst(T value){
	head --;
	if(head < 0){
	    head = queue.length - 1; 
	}
	if (size >= queue.length){
	    head++;
	    enlarge();
	    this.addFirst(value);
	    return;
	}
	queue[head] = value;
	size ++;
    }

    public void addLast(T value){
	tail ++;
	if(size >= queue.length){
	    tail--;
	    enlarge();
	    this.addLast(value);
	    return;
	}
	if(tail > queue.length - 1){
	    tail = 0;
	}
	queue[tail] = value;
	size ++;
    }

    public T removeFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	T a = (T)queue[head];
	queue[head] = null;
	head ++;
	if(head == queue.length){
	    head = 0;
	}
	size --;
	return a;
    }

    public T removeLast(){
    	if(size == 0){
	    throw new NoSuchElementException();
	}
	T a = (T)queue[tail];
	queue[tail] = null;
	tail --;
	if(tail < 0){
	    tail = queue.length - 1;
	}
	size --;
	return a;
    }

    public T getFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	return (T)queue[head];
    }

    public T getLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	return (T)queue[tail];
    }

    public void enlarge(){
	Object[] copy = new Object[size * 2];
	int pricopy = new int[size * 2];
	int j = 0;
	for(int i = head; i != tail; i ++){
	    if(i >= queue.length){
		i = 0;
	    }
	    copy[j] = queue[i];
	    pricopy[j] = priority[i];
	    j++;
	}
	copy[j] = queue[tail];
	pricopy[j] = priority[tail];
	head = 0;
	tail = j;
	queue = copy;
	priority = pricopy;
    }

    public int size(){
	return size;
    }

    public int length(){
	return queue.length;
    }

    public String toString(){
	if(queue.length == 0){
	    return "[]";
	}
	String a = "[" + queue[head];
	for(int i = head + 1; i != tail + 1; i ++){
	    if(i >= queue.length){
		i = 0;
	    }
	    a += ", " + queue[i];
	}
	a += "]";
	return a;
    }

    public static void main(String[]args){
	MyDeque<Integer> a = new MyDeque<Integer>();
	a.addFirst(1);
	a.addFirst(2);
	a.addFirst(3);
	a.addFirst(4);
	a.addFirst(5);
	a.addFirst(6);
	a.addLast(0);
	a.addLast(1);
	a.addLast(2);
	a.addLast(3);
	a.addLast(4);
	a.addLast(5);
	a.addLast(6);
	System.out.println(a.toString());
	System.out.println(a.size());
	System.out.println(a.length());
	a.removeFirst();
	a.removeFirst();
	a.removeFirst();
	a.removeFirst();
	a.removeLast();
	a.removeLast();
	a.removeLast();
	System.out.println(a.toString());
	System.out.println(a.getFirst());
	System.out.println(a.getLast());
	System.out.println(a.size());
	System.out.println(a.length());
    }
    
}
