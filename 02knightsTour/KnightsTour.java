import java.util.*;
import java.io.*;

public class KnightsTour{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    //instance variable
    private int[][]board;
    private int xsize, ysize;


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
	//build your knights tour here...
	return hide + go(0,0) + ans + "\n" + show;
    }

    public KnightsTour(int size){
	board = new int[8][8];			
    }

    
    public void solve(){
	if 
    }

    public void solve(int startx, int starty){
	KnightsTour[startx][starty] = '1';
	return solve(startx, starty);
    }


		
    public boolean solve(int x,int y,int currentMoveNumber){
	boolean filled = true;
	for(int i = 0; i < board.length(); i ++){
	    for (int j = 0; j < board[].length(); j++){
		if (board[i][j] == ' '){
		    filled = false;
		}
	    }
	}
	System.out.println(this);
	wait(20);
	//base case
	if(){
	    return true;
	}
	if(board[x][y] == ' '){
	    board[x][y] = char(currentMoveNumber);
	    if(solve(x - 2, y + 1, currentMoveNumber + 1) || solve(x - 2, y - 1, currentMoveNumber + 1) || solve(x - 1, y - 2, currentMoveNumber + 1) || solve(x + 1, y - 2, currentMoveNumber + 1) || solve(x + 2, y + 1, currentMoveNumber + 1) || solve(x + 2, y - 1, currentMoveNumber + 1) || solve(x + 1, y + 2, currentMoveNumber + 1) || solve(x - 1, y + 2, currentMoveNumber + 1)){
		return true;
	    }
	    // marker: board[x][y] == '';
	}	
	return false;
    }


}