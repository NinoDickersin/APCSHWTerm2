import java.util.*;

public class Sorts{

    int[] array;
    
    public static int partition(int[] ary, int value, int si, int ei){

	if(si == ei){
	    return ary[si];
	}

	Random r = new Random();
	int randVal = r.nextInt(ei - si - 1) + si + 2;
	/**
	int[] d = new int[ary.length];
	for(int i = 0; i < ary.length; i ++){
	    if(i < si || i > ei){
		d[i] = ary[i];
	    }
	}
	**/
	int trackFor = si;
	int trackBack = ei;
	int pivot = ary[randVal];
	int marker;
	for(int i = si; i <= ei; i ++){
	    if(i == randVal){
		marker = ary[i + 1];
		ary[i + 1] = pivot;
		ary[randVal] = marker;
		randVal = i + 1;
		i --;
	    }else if(ary[i] < pivot){
		marker = ary[i];
		ary[i] = ary[trackFor];
		ary[trackFor] = marker;
		trackFor ++;
	    }else if(ary[i] > pivot){
		marker = ary[i];
		ary[i] = ary[trackBack];
		ary[trackBack] = marker;
		i--;
		trackBack --;
	    }
	}
	ary[trackFor] = pivot;
	if(trackFor + 1 == value){
	    return pivot;
	}else if(trackFor < value){
	    return partition(ary, value, trackFor, ei);
	}else{
	    return partition(ary, value, si, trackFor);
	}
    }

    public static int quickselect(int[]ary, int value){
	return partition(ary, value, 0, ary.length - 1);
    }

    public static void quicksort(int[] ary){
	
    }
    
    public static void main (String[] args){
	int[] a = new int[]{9,8,1,3,6,5,4,2,7,0};
	System.out.println(quickselect(a, 5));
    }
}
