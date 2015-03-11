public class MyLinkedList{
    private LNode start;

    public MyLinkedList(int value){

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

    public void add(int value){
	add(this.size() - 1, value);
    }

    public void add(int index, int value){
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
    }

    public void remove(int index){
	if(index >= this.size()){
	    throw new IndexOutOfBoundsException("This index is not in the array.");
	}
	LNode current = start;
	int i = 0;
	while (current.getNext() != null && i != index){
	    current = current.getNext();
	    i++;
	}
	current.setNext((current.getNext()).getNext());
    }

    public int size(){
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
	String a = "[" + current.getValue() + ", ";
	while ((current.getNext()).getNext() != null){
	    current = current.getNext();
	    a += current.getValue() + ", ";
	}
	a += (current.getNext()).getValue() + "]";
	return a;
    }

    public static void main(String[]args){
	
    }
}
