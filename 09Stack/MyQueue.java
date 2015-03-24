import java.util.*;

public class MyQueue<T>{
    MyLinkedList<T> queue;

    public MyQueue(){
	queue = new MyLinkedList<T>();
    }

    public boolean enqueue(T n){
	return queue.add(n);
    }

    public T dequeue(){
	if(queue.size() == 0){
	    throw new NoSuchElementException();
	}
	T a = queue.get(0);
	queue.remove(0);
	return a;
    }

    public String toString(){
	return queue.toString();
    }

    public String name(){
	return "dickersin.nino";
    }

    public static void main(String[]args){
	MyQueue<Integer> q = new MyQueue<Integer>();
	q.enqueue(5);
	System.out.println(q);
	q.enqueue(8);
	q.enqueue(2);
	System.out.println(q);
	q.dequeue();
	System.out.println(q);
    }
}
