import java.util.*;

public class QuickSelect{

    int[] array;
    
    public static int partition(int[] ary, int value, int si, int ei){

	if(si == ei){
	    return ary[si];
	}

	Random r = new Random();
	int randVal = r.nextInt(ei - si + 1) + si;
	int[] d = new int[ary.length];
	for(int i = 0; i < ary.length; i ++){
	    if(i < si || i > ei){
		d[i] = ary[i];
	    }
	}
	int trackFor = si;
	int trackBack = ei;
	int pivot = ary[randVal];
	for(int i = si; i <= ei; i ++){
	    if(ary[i] < pivot){
		d[trackFor] = ary[i];
		trackFor ++;
	    }else if(ary[i] > pivot){
		d[trackBack] = ary[i];
		trackBack --;
	    }
	}
	d[trackFor] = pivot;
	if(trackFor + 1 == value){
	    return pivot;
	}else if(trackFor < value){
	    return partition(d, value, trackFor, ei);
	}else{
	    return partition(d, value, si, trackFor);
	}
    }

    public static int quickSelect(int[]ary, int value){
	return partition(ary, value, 0, ary.length - 1);
    }
    
    public static void main (String[] args){
	int[] a = new int[]{9,8,1,3,6,5,4,2,7,0};
	System.out.println(quickSelect(a, 5));
    }
}
