import java.util.*;

public class Frontier<T>{

    public int type;
    public MyDeque<Coordinate> d = new MyDeque<Coordinate>();

    public Frontier(int t){
	type = t;
    }

    public void add(Coordinate value){
	if (type == 0){ // BFS
	    d.addLast(value);
	}else if(type == 1){ // DFS
	    d.addFirst(value);
	}else if(type == 2){ // Best First
	    d.add(value, value.getDistanceTo());
	}else if(type == 3){ // A*
	    d.add(value, value.getDistanceTo() + value.getDistanceFrom() );
	}
    }

    public Coordinate remove(){
	if( type == 2 || type == 3){
	    return d.removeSmallest();
	}else{
	    return d.removeFirst();
	}
    }
   
    public int size(){
	return d.size;
    }

    public String toString(){
	return d.toString();
    }
}
