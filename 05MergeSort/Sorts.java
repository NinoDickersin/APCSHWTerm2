import java.util.*;
import java.util.Arrays;


public class Sorts{

    public static void mergesort(int[] n){
	//base case
	if (n.length < 2){
	    return;
	}
	
	//split the list
	int[] a = new int[n.length / 2];
	int[] b = new int[n.length - a.length];
	boolean even = true;
	int count1 = 0;
	int count2 = 0;
	for(int i = 0; i < n.length; i ++){
	    if(even = ! even){
		a[count1] = n[i];
		count1 ++;
	    }else{
		b[count2] = n[i];
		count2 ++;
	    }
	}

	mergesort(a);
	mergesort(b);

	//add together

	int x = 0;
	int y = 0;
	int i = 0;
	while(x < a.length && y < b.length){
	    if (a[x] < b[y]){
		n[i] = a[x];
		x++;
		i++;
	    }else{
		n[i] = b[y];
		y++;
		i++;
	    }
	}
	if (x < y){
	    for(; x < a.length; x ++){
		n[i] = a[x];
		i++;
	    }
	}else{
	    for(; y < b.length; y ++){
		n[i] = b[y];
		i++;
	    }
	}
    }

    public static void main(String[]args){
	int[] a = new int[10000000];
	Random r = new Random();
	for(int i = 0; i < a.length; i ++){
	    a[i] = r.nextInt(2000000) - 1000000;
	}
	mergesort(a);
	//Arrays.sort(a);
    }
}
