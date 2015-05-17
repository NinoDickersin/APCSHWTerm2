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
	if(maxHeap.size() == 0){
	    maxHeap.add(value);
	}else if(minHeap.size() == 0){
	    minHeap.add(value);
	}else if(value <= maxHeap.peek()){
	    maxHeap.add(value);
	    if(maxHeap.size() + 1 > minHeap.size()){
		minHeap.add(maxHeap.remove());
	    }
	}else{
	    minHeap.add(value);
	    if(maxHeap.size() + 1 < minHeap.size()){
		maxHeap.add(minHeap.remove());
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
	    a.add(i + 5);
	}
	System.out.println(a.getMedian());
    }
}
