import java.util.*;

public class Maze{
    public char[][] maze;
    public Coordinate start, end;
    public int size;
    

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
			     {'.','*','.','*','.'},
			     {'.','*','.','.','.'},
			     {'.','.','*','.','E'} };
	start = new Coordinate(0,0);
	end = new Coordinate(5,5);
	size = 5;
	next.addFirst(start);
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
	public Frontier<Coordinate> next = new Frontier<Coordinate>();
	while(current != end){
	    Coordinate current = next.getFirst();
	    int x = current.getX();
	    int y = current.getY();
	    if(x - 1 > 0 && !(maze[y][x - 1]).equals('*')){
	    
	    }
	    if(x + 1 < size && !(maze[y][x + 1]).equals('*')){

	    }
	    if(y - 1 > 0 && !(maze[y - 1][x]).equals('*')){

	    } if(y + 1 < size && !(maze[y + 1][x]).equals('*')){

	    }
	}
	return true;
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