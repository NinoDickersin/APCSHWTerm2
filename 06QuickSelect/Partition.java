import java.util.*;

public class Partition{

    int[] array;
    
    public int partition(int[] ary, int value, int si, int ei){
	if(si == ei){
	    
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
	for(int i = si; i <= ei; i ++){
	    if(ary[i] < ary[randVal]){
		d[trackFor] = ary[i];
		trackFor ++;
	    }else if(ary[i] > ary[randVal]){
		d[trackBack] = ary[i];
		trackBack --;
	    }
	}
	d[trackFor] = ary[randVal];
    }

    public int quickSelect(){
	
    }

    public static void main (String[] args){
	int[] a = new int[]{9,8,1,3,6,5,4,2,7,0};
	partition(a, 0, 7);
    }
}
