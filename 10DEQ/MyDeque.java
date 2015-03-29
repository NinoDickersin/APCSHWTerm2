import java.util.*;

public class MyDeque<T>{

    public Object[] queue;
    public int head;
    public int tail;
    public int size;

    public MyDeque(){
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
	if (queue[head] != null){
	    head++;
	    enlarge();
	    this.addFirst(value);
	}
	queue[head] = value;
	size ++;
    }

    public void addLast(T value){
	tail ++;
	if(tail > queue.length - 1){
	    tail = 0;
	}
	if(queue[tail] != null){
	    tail--;
	    enlarge();
	    this.addLast(value);
	}
	queue[tail] = value;
	size ++;
    }
    /**

    public T removeFirst(){

    }

    public T removeLast(){

    }

    public T getFirst(){

    }

    public T getLast(){

    }
    **/

    public void enlarge(){
	Object[] copy = new Object[size * 2];
	int j = 0;
	System.out.println(head);
	System.out.println(tail);
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
    /**
    public void shrink(){
	Object[] copy = new Object[size / 3];
	int j = 0;
	for(int i = head + 1; i != tail + 1; i ++){
	    if(i >= queue.length){
		i = 0;
	    }
	    copy[j] = queue[i];
	    j++;
	}
	head = 0;
	tail = j;
	queue = copy;
    }
    **/

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
    }
    
}
