import java.util.*;

public class RunningMedian{
    MyHeap minHeap;
    MyHeap maxHeap;

    public RunningMedian(){
	minHeap = new MyHeap(false);
	maxHeap = new MyHeap(true);
    }

    public String name(){
	return "dickersin.nino";
    }

    public void add(int value){
	if(minHeap.size() == 0 && maxHeap.size() == 0){
	    maxHeap.add(value);
	}
	if(value <= minHeap.peek()){
	    minHeap.add(value);
	    if(minHeap.size() + 1 > maxHeap.size()){
		maxHeap.add(minHeap.remove());
	    }
	}else{
	    maxHeap.add(value);
	    if(maxHeap.size() + 1 > minHeap.size()){
		minHeap.add(maxHeap.remove());
	    }
	}
	
    }

    public double getMedian(){
	if(minHeap.size() > maxHeap.size()){
	    return minHeap.peek();
	}else if(minHeap.size() < maxHeap.size()){
	    return maxHeap.peek();
	}else{
	    return (minHeap.peek() + maxHeap.peek()) / 2.0;
	}
    }

    public static void main(String[]args){
	RunningMedian a = new RunningMedian();
	for(int i = 0; i < 10; i ++){
	    a.add(i);
	    //	    a.add(i + 5);
	}
	System.out.println(i);
    }
}
