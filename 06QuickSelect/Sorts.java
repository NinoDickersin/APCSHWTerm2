import java.util.*;

public class Sorts{

   public static void quicksort(int[]ary){
	quicksortHelper(ary, 0, ary.length-1);
    }

    public static void quicksortHelper(int[] ary, int start, int end){
	if (start >= end){
	    return;
	}
	int pivot = partition(ary, start, end);
	quicksortHelper(ary, start, pivot-1);
	quicksortHelper(ary, pivot+1, end);
    }

    public static int partition(int[]ary, int si, int ei){
	int ri = si + (int)(Math.random()*(ei-si+1));
	int pivot = ary[ri];
	int start = si;
	int end = ei;
	int temp1,temp2;
	while (start != end){
	    if (ary[start] == pivot){
		temp1 = ary[start];
		temp2 = ary[start + 1];
		ary[start+1] = temp1;
		ary[start] = temp2;;
	    }
	    if (ary[end] == pivot){
		temp1 = ary[end];
		temp2 = ary[end-1];
		ary[end-1] = temp1;
		ary[end] = temp2;
	    }
	    if (ary[start] > ary[end]){
		temp1 = ary[start];
		temp2 = ary[end];
		ary[end] = temp1;
		ary[start] = temp2;
	    }
	    if (ary[end] > pivot){
		end--;
	    }
	    if (ary[start] < pivot){
		start++;
	    }
	}
	return start;
    }
    
    public static void main (String[] args){
	int[] a = new int[]{9,8,1,3,6,5,4,2,7,0};
	quicksort(a);
	System.out.println(Arrays.toString(a));
    }
}
