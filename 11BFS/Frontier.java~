import java.util.*;

public class Frontier<T>{

    public Object[] queue;
    public int head;
    public int tail;
    public int size;

    public Frontier(){
	queue = new Object[10];
	head = 1;
	tail = 0;
	size = 0;
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
	if(head > queue.length){
	    head = 0;
	}
	size --;
	if (size < queue.length / 3){
	    shrink();
	}
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
	if (size < queue.length / 3){
	    shrink();
	}
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
	int j = 0;
	for(int i = head; i != tail; i ++){
	    if(i >= queue.length){
		i = 0;
	    }
	    copy[j] = queue[i];
	    j++;
	}
	copy[j] = queue[tail];
	head = 0;
	tail = j;
	queue = copy;
    }

    public void shrink(){
	Object[] copy = new Object[queue.length / 2];
	int j = 0;
	for(int i = head; i != tail; i ++){
	    if(i >= queue.length){
		i = 0;
	    }
	    copy[j] = queue[i];
	    j++;
	}
	copy[j] = queue[tail];
	head = 0;
	tail = j;
	queue = copy;
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
}