import java.util.*;

public class Frontier<T>{

    public int type;
    public MyDeque<Coordinate> d = new MyDeque<Coordinate>();

    public Frontier(int t){
	type = t;
    }

    public void add(Coordinate value){
	if (type == 0){
	    d.addLast(value);
	}else if(type == 1){
	    d.addFirst(value);
	}
    }

    public void add(Coordinate value, int pri){
	d.add(value, pri);
    }

    public Coordinate removePri(){
	return d.removeSmallest();
    }

    public Coordinate remove(){
	return d.removeFirst();
    }
   
    public int size(){
	return d.size;
    }

    public String toString(){
	return d.toString();
    }
}
