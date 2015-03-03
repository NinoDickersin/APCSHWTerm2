import java.util.*;
import java.io.*;

public class KnightsTour{
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    //instance variable
    private int[][]board;
    public boolean filled;

    public String name(){
	return "dickersin.nino";
    }

    //terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
 
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String toString(){
	String ans = "\n";
	String space;
	for(int i = 0; i < board.length; i ++){
	    for (int j = 0; j < board[0].length; j++){
		if(board[i][j] < 10){
		    space = " ";
		}else{
		    space = "";
		}
		ans += board[i][j] + space + " ";
	    }
	    ans += "\n";
	}
	if(filled){
	    ans += "Solved\n";
	}else{
	    ans += "No Solution\n";
	}
	return ans + "\n";
    }

    public KnightsTour(int size){
	board = new int[size][size];
    }
    
    public boolean solve(){
	return solve(0,0);
    }

    public boolean solve(int startx, int starty){
	return solve(startx, starty, 1);
    }
		
    public boolean solve(int x,int y,int currentMoveNumber){
	if (x < 0 || y < 0 || x > board[0].length - 1 || y > board.length - 1){
	    return false;
	}
	filled = true;
	for(int i = 0; i < board.length; i ++){
	    for (int j = 0; j < board[0].length; j++){
		if (board[i][j] == 0){
		    filled = false;
		}
	    }
	}
	//base case
	if(filled){
	    return true;
	}
	if(board[x][y] == 0){
	    board[x][y] = currentMoveNumber;
	    if(solve(x - 2, y + 1, currentMoveNumber + 1) ||
	       solve(x - 2, y - 1, currentMoveNumber + 1) ||
	       solve(x - 1, y - 2, currentMoveNumber + 1) ||
	       solve(x + 1, y - 2, currentMoveNumber + 1) ||
	       solve(x + 2, y + 1, currentMoveNumber + 1) ||
	       solve(x + 2, y - 1, currentMoveNumber + 1) ||
	       solve(x + 1, y + 2, currentMoveNumber + 1) ||
	       solve(x - 1, y + 2, currentMoveNumber + 1)){
		return true;
	    }
	board[x][y] = 0;
	}
	return false;
    }
    public static void main(String[]args){
	KnightsTour a = new KnightsTour(5);
	KnightsTour b = new KnightsTour(4);
	KnightsTour c = new KnightsTour(6);
	a.solve();
	b.solve();
	c.solve();
	System.out.println(a);
	System.out.println(b);
	System.out.println(c);
    }
}
