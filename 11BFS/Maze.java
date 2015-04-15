import java.util.*;
import java.io.*;

public class Maze{
    public char[][] maze;
    public Coordinate start, end;
    public int maxX, maxY, startX, startY;
    public boolean solvable = true;
    

    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";

    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }

    public void wait(int millis){
	try{
	    Thread.sleep(millis);
	}
	catch(InterruptedException e){
	}
    }

    public String name(){
	return "dickersin.nino";
    }

    public Maze(String filename){
	String a = "";
	startX = -1;
	startY = -1;
	try{
	    Scanner sc = new Scanner(new File (filename));
	    while(sc.hasNext()){
		String b = sc.nextLine();
		if(maxY == 0){
		    maxX = b.length();
		}
		a += b;
		maxY++;
	    }
	}
	catch(Exception e){
	    System.out.println("File could not be read.");
	    e.printStackTrace();
	    System.exit(0);
	}

	maze = new char[maxX][maxY];
	for(int i = 0; i < a.length(); i ++){
	    char c = a.charAt(i);
	    maze[i % maxX][i / maxX] = c;
	    if(c=='S'){
		startX = i % maxX;
		startY = i / maxX;
	    }
	}
	start = new Coordinate(startX, startY);
    }

    
    public String toString(){
	String ans = "";
	for(int i = 0; i < maxX * maxY; i++){
	    if(i % maxX == 0 && i != 0){
		ans += "\n";
	    }
	    ans += maze[i % maxX][i / maxX];
	}
	return ans;
    }

    public String toString(boolean animate){
	if(animate){
	    return clear + hide + go(0,0) + toString() + "\n" + show;
	}else{
	    return toString() + "\n";
	}
    }

    public boolean solveBFS(boolean animate){
	return solve(animate, 0);
    }

    public boolean solveBFS(){
	return solveBFS(false);
    }

    public boolean solveDFS(boolean animate){
	return solve(animate, 1);
    }

    public boolean solveDFS(){
	return solveDFS(false);
    }

    public boolean solveBest(){

    }

    public boolean solveAStar(){

    }

    public boolean solve(boolean animate, int type){
	Frontier next = new Frontier(type);
	boolean found = false;
	next.add(start);
	while(!found){
	    if(next.size() == 0){
		System.out.println( toString(animate) );
		System.out.println("No solution");
		return false;
	    }else if(endFind(next, animate)){
		found = true;
	    }
	}
	if(found){
	    Coordinate x = end.getLast();
	    while(x.getDistance() > 0){
		if(animate){
		    System.out.println(toString(animate));
		    wait(50);
		}
		maze[x.getRow()][x.getCol()] = '@';
		x = x.getLast();
	    }
	    System.out.println(toString(animate));
	    return true;
	}
	return false;
    }

    public boolean endFind(Frontier a, boolean animate){
	if(animate){
	    System.out.println(toString(animate));
	    wait(70);
	}
	Coordinate y = a.remove();
	if(maze[y.getRow()][y.getCol()] == 'E'){
	    end = y;
	    return true;
	}
	if (maze[y.getRow()][y.getCol()] == ' ' || maze[y.getRow()][y.getCol()] == 'S'){
	    if ( maze[y.getRow()][y.getCol()] == ' ' ){
		maze[y.getRow()][y.getCol()] = 'x';
	    }
	    if ( maze[y.getRow()][y.getCol()+1] == ' ' || maze[y.getRow()][y.getCol()+1] == 'E' ){
		a.add(new Coordinate(y.getRow(), y.getCol()+1, y.getDistance()+1, y)); 
	    }
	    if ( maze[y.getRow()][y.getCol()-1] == ' ' || maze[y.getRow()][y.getCol()-1] == 'E'){
		a.add(new Coordinate(y.getRow(), y.getCol()-1, y.getDistance()+1, y)); 
	    }
	    if ( maze[y.getRow()+1][y.getCol()] == ' ' || maze[y.getRow()+1][y.getCol()] == 'E' ){
		a.add(new Coordinate(y.getRow()+1, y.getCol(), y.getDistance()+1, y));
	    }
	    if ( maze[y.getRow()-1][y.getCol()] == ' ' || maze[y.getRow()-1][y.getCol()] == 'E'){
		a.add(new Coordinate(y.getRow()-1, y.getCol(), y.getDistance()+1, y));
	    }
	}
	return false;
    }

    public int[] solutionCoordinates(){
	if(end == null){
	    return new int[0];
	}
	int[] a = new int[(end.getDistance() + 1) * 2];
	Coordinate current = end;
	for (int i = (end.getDistance() + 1) * 2 - 1; i >= 0; i -= 2){
	    a[i] = current.getCol();
	    a[i - 1] = current.getRow();
	    current = current.getLast();
	}
	return a;
    }

    public static void main(String[]args){
	Maze a = new Maze("MazeFile.txt");
	a.solveBFS(true);
	//	a.solveBFS(false);
	//	a.solveDFS(true);
	//	a.solveDFS(false);
	System.out.println(Arrays.toString(a.solutionCoordinates()));
    }
}
