import java.util.*;

public class RunningMedian{
    MyHeap minHeap;
    MyHeap maxHeap;

    public RunningMedian(){

    }

    public void add(int value){

    }

    public doible getMedian(){
	if(minHeap.size() > maxHeap.size()){
	    return minHeap.peek();
	}else if(minHeap.size() < maxHeap.size()){
	    return maxHeap.peek();
	}else{
	    return (minHeap.peek() + maxHeap.peek()) / 2.0;
	}
    }
}