public class LNode<T>{
    private T value;
    private LNode next = null;

    public LNode(T value){
	setValue(value);
    }

    public T getValue(){
	return value;
    }

    public void setValue(T x){
	value = x;
    }

    public LNode getNext(){
	return next;
    }

    public void setNext(LNode a){
	next = a;
    }

    public String toString(){
	return "" + this.getValue();
    }
}
