import java.util.*;

public class Maze{
    public char[][] maze;
    public Frontier next = new Frontier();
    

    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";

    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }

    public String name(){
	return "dickersin.nino";
    }

    public Maze(){
	maze = new char[][]{ {'S','.','*','*','.'},
			     {'.','.','.','*','.'},
			     {'.','*','.','.','.'},
			     {'.','.','*','.','E'} };
    }
    /**
    public Maze(String filename){
	String a = "";
	int r = 0;
	int c = 0;
	Scanner sc = new Scanner(new File (filename));
	while(sc.hasNext()){
	    String c = sc.next();
	    if(c.equals("NEXT")){
		r ++;
		c = 0;
	    }else{
		a += c;
		c ++;
	    }
	}
	maze = new char[c][r];
	for(int i = 0; i < maze.length; i ++){
	    for(int j = 0; j < maze[0].length; j++){
		maze[i][j] = a.substring(0, 1);
		a = a.substring(1);
	    }
	}
    }
    **/

    public String toString(){
	return this.toString(false);
    }

    public String toString(boolean animate){
	String a = "";
	return "banana";
    }

    public boolean solveBFS(boolean animate){
	Frontier.addFirst();

    }

    public boolean solveBFS(){
	return solveBFS(false);
    }

    public boolean solveDFS(boolean animate){
	return true;
    }

    public boolean solveDFS(){
	return solveDFS(false);
    }

    /**
    public int[] solutionCoordinates(){
	
    }
    **/

    public static void main(String[]args){
	Maze a = new Maze();
	//	Maze b = new Maze("MazeFile.txt");
    }
}