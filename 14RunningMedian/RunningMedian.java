import java.util.*;

public class RunningMedian{
    MyHeap minHeap;
    MyHeap maxHeap;

    public RunningMedian(){
	minHeap = new MyHeap(false);
	maxHeap = new MyHeap(true);
    }

    public void add(int value){

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
}