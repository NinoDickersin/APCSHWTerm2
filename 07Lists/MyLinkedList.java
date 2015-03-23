public class MyLinkedList<T> implements Iterable<T>{

public class LNode<T>{
    private T value;
    private LNode<T> next = null;

    public LNode(T value){
	setValue(value);
    }

    public T getValue(){
	return value;
    }

    public void setValue(T x){
	value = x;
    }

    public LNode<T> getNext(){
	return next;
    }

    public void setNext(LNode<T> a){
	next = a;
    }

    public String toString(){
	return "" + this.getValue();
    }
}


    public class MLLIterator<T> implements Iterator<T>{
	private LNode<T> current;
	
	public MLLIterator(LNode<T> a){
	    current = a;
	}

	public T next(){
	    if(hasNext()){
		T value = current.getValue();
		current = current.getNext();
		return value;
	    }else{
		throw new NoSuchElementException("No 'next' element assigned.");
	    }
	}

	public boolean hasNext(){
	    return current != null;
	}

	public void remove(){
	    throw new UnsupportedOperationException("Remove = broke xD");
	}
    }

    private LNode<T> start;
    private int size;
    private LNode<T> end;


    public String name(){
	return "dickersin.nino";
    }

    public MyLinkedList(){
	size = 0;
	start = null;
	end = null;
    }

    public T get(int index){
	LNode<T> current = start;
	int i = 0;
	while (current.getNext() != null && i != index){
	    current = current.getNext();
	    i++;
	}
	return current.getValue();	
    }

    public void set(int index, T value){
	if(this.size() <= 0){
	    LNode<T> l = new LNode<T>(value);
	    start = l;
	    return;
	}
	if(index >= this.size()){
	    throw new IndexOutOfBoundsException("This index is not in the array.");
	}
	LNode<T> current = start;
	int i = 0;
	while (current.getNext() != null && i != index){
	    current = current.getNext();
	    i++;
	}
	current.setValue(value);
    } 

    public boolean add(T value){
	LNode<T> l = new LNode<T>(value);
	if(this.size() == 0){
	    start = l;
	    end = l;
	    size++;
	    return true;
	}
	end.setNext(l);
	end = end.getNext();
	size++;
	return true;
    }

    public boolean add(int index, T value){
	if(this.size() <=0){
	    LNode<T> l = new LNode<T>(value);
	    this.set(0, value);
	    size ++;
	    return true;
	}else if(index >= this.size()){
	    throw new IndexOutOfBoundsException("This index is not in the array.");
	}else if(index == this.size() - 1){
	    add(value);
	}
	LNode<T> current = start;
	int i = 0;
	while (current.getNext() != null && i != index){
	    current = current.getNext();
	    i++;
	}
	LNode<T> a = current.getNext();
	LNode<T> b = new LNode<T>(value);
	current.setNext(b);
	b.setNext(a);
	size ++;
	return true;
    }

    public void remove(int index){
	if(index >= this.size()){
	    throw new IndexOutOfBoundsException("This index is not in the array.");
	}
	LNode<T> current = start;
	int i = 1;
	while (i < index){
	    if((current.getNext()).getNext() == null){
		end = current;
		current.setNext(null);
		return;
	    }
	    current = current.getNext();
	    i++;
	}
	current.setNext((current.getNext()).getNext());
	size --;
    }

    public int size(){
	return size;
    }
    
    public int indexOf(T value){
	LNode<T> current = start;
	int i = 0;
	while (current.getNext() != null){
	    current = current.getNext();
	    i++;
	    if(current.getValue() == value){
		return i;
	    }
	}
	return -1;
    }

    public String toString(){
	LNode<T> current = start;
	String a = "[";
	while (current != null){
	    a += current.getValue() + ", ";
	    current = current.getNext();
	}
	return a.substring(0, a.length() - 2) + "]";
    }

    public static void main(String[]args){
	MyLinkedList<Integer> a = new MyLinkedList<Integer>();
	a.add(1);
	a.add(2);
	a.add(3);
	System.out.println(a.toString());
	System.out.println(a.get(0));
	a.set(0,0);
	a.set(1,1);
	a.set(2,2);
	System.out.println(a.size());
	System.out.println(a.indexOf(2));
	a.remove(2);
	System.out.println(a.toString());
    }
}
