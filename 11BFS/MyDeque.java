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
	head --;
	if(head < 0){
	    head = length() - 1;
	}
	priority[head] = pri;
	head ++;
	if(head >= length()){
	    head = 0;
	}
	addFirst(value);
    }

    public T removeSmallest(){
	if(size < 1){
	    throw new NoSuchElementException();
	}
	int smallSpot = head;
	for(int i = head; i != tail;i++){
	    if(i >= length()){
		i = 0;
	    }
	    if(priority[smallSpot] > priority[i]){
		smallSpot = i;
	    }
	    if(i == tail){
		break;
	    }
	}
	T smallest = (T)queue[smallSpot];
	System.out.println(head);
	System.out.println(smallSpot);
	queue[smallSpot] = queue[head];
	priority[smallSpot] = priority[head];
	queue[head] = null;
	priority[head] = 0;
	if(head > tail){
	    head ++;
	}else{
	    head --;
	}
	if(head >= length()){
	    head = 0;
	}else if(head < 0){
	    head = length() - 1;
	}
	size --;
	return smallest;
    }
    
    public void addFirst(T value){
	head --;
	if(head < 0){
	    head = length() - 1; 
	}
	if (size >= length()){
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
	if(size >= length()){
	    tail--;
	    enlarge();
	    this.addLast(value);
	    return;
	}
	if(tail > length() - 1){
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
	int[] pricopy = new int[size * 2];
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
	if(length() == 0){
	    return "[]";
	}
	String a = "[" + queue[head];
	for(int i = head + 1; i != tail + 1; i ++){
	    if(i >= length()){
		i = 0;
	    }
	    a += ", " + queue[i];
	}
	a += "]";
	return a;
    }

    public String priToString(){
	return Arrays.toString(priority);
    }

    public static void main(String[]args){
	MyDeque<Integer> a = new MyDeque<Integer>();
	a.add(5,5);
	a.add(3, 8);
	a.add(-1, 9);
	a.add(4,1);
	System.out.println(a.toString());
	System.out.println(a.priToString());
	System.out.println(a.removeSmallest()); //4
	System.out.println(a.toString());
	System.out.println(a.priToString());
	System.out.println(a.removeSmallest()); //5
	System.out.println(a.toString());
	System.out.println(a.priToString());
	System.out.println(a.removeSmallest()); //3
	System.out.println(a.toString());
	a.add(3, -5);
	a.add(99, 65);
	System.out.println(a.toString());
	System.out.println(a.removeSmallest()); //3
	System.out.println(a.toString());
	System.out.println(a.removeSmallest()); //-1
	System.out.println(a.toString());
    }
    
}
