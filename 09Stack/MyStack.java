import java.util.*;

public class MyStack<T>{

    MyLinkedList<T> stack;

    public MyStack(){
	stack = new MyLinkedList<T>();
    }

    public T peek(){
	if(stack.size() == 0){
	    throw new EmptyStackException();
	}
	return stack.get(stack.size() - 1);
    }

    public T pop(){
	if(stack.size() == 0){
	    throw new EmptyStackException();
	}
	T a = stack.get(stack.size() - 1);
	stack.remove(stack.size() - 1);
	return a;
    }

    public void push(T item){
	if (item == null) {
	    throw new NullPointerException();
	}
	stack.add(item);
    }

    public String toString(){
	return stack.toString();
    }

    public String name(){
	return "dickersin.nino";
    }

    public static void main(String[]args){
	MyStack<Integer> s = new MyStack<Integer>();
	s.push(10);
	s.push(15);
	s.push(3);
	System.out.println(s);
	System.out.println(s.peek());
	System.out.println(s.pop());
	System.out.println(s);
    }
}
