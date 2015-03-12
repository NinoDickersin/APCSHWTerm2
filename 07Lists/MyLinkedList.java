public class MyLinkedList{
    private LNode start = null;

    public MyLinkedList(){

    }

    public int get(int index){
	LNode current = start;
	int i = 0;
	while (current.getNext() != null && i != index){
	    current = current.getNext();
	    i++;
	}
	return current.getValue();	
    }

    public void set(int index, int value){
	if(this.size() <= 0){
	    LNode l = new LNode(value);
	    start = l;
	}
	if(index >= this.size()){
	    throw new IndexOutOfBoundsException("This index is not in the array.");
	}
	LNode current = start;
	int i = 0;
	while (current.getNext() != null && i != index){
	    current = current.getNext();
	    i++;
	}
	current.setValue(value);
    } 

    public boolean add(int value){
	add(this.size() - 1, value);
	return true;
    }

    public boolean add(int index, int value){
	if(this.size() <=0){
	    LNode l = new LNode(value);
	    this.set(0, value);
	    return true;
	}
	if(index >= this.size()){
	    throw new IndexOutOfBoundsException("This index is not in the array.");
	}
	LNode current = start;
	int i = 0;
	while (current.getNext() != null && i != index){
	    current = current.getNext();
	    i++;
	}
	LNode a = current.getNext();
	LNode b = new LNode(value);
	current.setNext(b);
	b.setNext(a);
	return true;
    }

    public void remove(int index){
	if(index >= this.size()){
	    throw new IndexOutOfBoundsException("This index is not in the array.");
	}
	LNode current = start;
	int i = 1;
	while (i < index){
	    if((current.getNext()).getNext() == null){
		current.setNext(null);
		return;
	    }
	    current = current.getNext();
	    i++;
	}
	current.setNext((current.getNext()).getNext());
    }

    public int size(){
	if(start == null){
	    return 0;
	}
	LNode current = start;
	int i = 0;
	while (current.getNext() != null){
	    current = current.getNext();
	    i++;
	}
	return i + 1;
    }
    
    public int indexOf(int value){
	LNode current = start;
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
	LNode current = start;
	String a = "[";
	while (current != null){
	    a += current.getValue() + ", ";
	    current = current.getNext();
	}
	return a.substring(0, a.length() - 2) + "]";
    }

    public static void main(String[]args){
	MyLinkedList a = new MyLinkedList();
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
