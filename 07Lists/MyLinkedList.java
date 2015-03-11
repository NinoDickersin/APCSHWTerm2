public class MyLinkedList{
    private LNode start;

    public int get(int index){
	LNode current = start;
	int i = 0;
	while (current.getNext() != null && i != index){
	    current = current.getNext();
	    i++;
	}
	return current;	
    }

    public void set(int index, int value){
	
    } 

    public void add(int value){
	
    }

    public void add(int index, int value){

    }

    public void remove(int index){

    }

    public int size(){
	return 5;
    }
    
    public int indexOf(int value){

    }

    public String toString(){
	return "";
    }
}