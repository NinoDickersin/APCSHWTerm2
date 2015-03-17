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
