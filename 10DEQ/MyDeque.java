import java.util.*;

public class MyDeque<T>{

    public Object[] queue;
    public int head;
    public int tail;

    public MyDeque(){
	queue = new Object[10];
	head = 1;
	tail = 1;
    }

    public void addFirst(T value){
	head --;
	if(head < 0){
	    head = queue.length - 1; 
	}
	if (queue[head] != null){
	    enlarge();
	    head = queue.length - 1;
	}
	queue[head] = value;
    }

    public void addLast(T value){
	
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

    }

    public void shrink(){

    }

    public void resize(){

    }

    public String toString(){
	String a = "[" + queue[head];
	for(int i = head + 1; i != tail; i ++){
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
	System.out.println(a.toString());
    }
    
}
