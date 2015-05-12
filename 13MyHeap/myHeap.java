public class MyHeap{
    boolean isMax;
    int[] heap;

    public MyHeap(){
	isMax = true;
	heap = new int[10];
	heap[0] = 0;
    }

    public MyHeap(boolean isMax){
	this.isMax = isMax;
	heap = new int[10];
	heap[0] = 0;
    }

    public void add(int x){
	boolean notOrdered = true;
	heap[0] ++;
	if(heap[0] >= heap.length()){
	    this.enlarge();
	}
	heap[heap[0]] = x;
	int index = heap[0];
	while(notOrdered){
	    if(isMax){
		if(heap[index] > heap[index/2]){
		    this.swap(index, index/2);
		}else{
		    notOrdered = false;
		}
	    }else{
		if(heap[index] < heap[index/2]){
		    this.swap(index, index/2);
		}else{
		    notOrdered = false;
		}
	    }
	}
    }

    public void enlarge(){
	int[] copy = new int[heap[0] * 2];
	copy[0] = heap[0];
	for(int i = 1; i < heap.length(); i ++){
	    copy[i] = heap[i];
	}
	heap = copy;
    }

    public void swap(int a, int b){
	int temp = heap[a];
	heap[a] = heap[b];
	heap[b] = temp;
    }

    public int peek(){
	return heap[1];
    }

    public int remove(){
	if(heap[0] <= 0){
	    throw new NoSuchElementException();
	}
	int a = peek();
	for(int i = 1; i < heap.length(); i++){
	    if(i + 1 = heap.length() && heap[i] != 0){
		heap[i] = 0;
	    }else{
		heap[i] = heap[i + 1]; 
	    }
	}
	heap[0] --;
	return a;
    }

    public String toString(){
	return Arrays.toString(heap);
    }

    public static void main (String[]args){

    }
}