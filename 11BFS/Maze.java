import java.util.*;

public class Maze{
    public char[][] maze;

    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";

    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }

    public String name(){
	return "dickersin.nino";
    }

    public Maze(String filename){
	String a = "";
	int r = 0;
	int c = 0;
	Scanner sc = new Scanner(new File (filename));
	while(sc.hasNextString()){
	    String c = sc.nextString();
	    if(c.equals("NEXT")){
		r ++;
		c = 0;
	    }else{
		a += c;
		c ++;
	    }
	}
	
    }

    public String toString(){
	return this.toString(false);
    }

    public String toString(boolean animate){
	String a = "";

    }

    public boolean solveBFS(boolean animate){

    }

    public boolean solveBFS(){
	return solveBFS(false);
    }

    public boolean solveDFS(boolean animate){
	
    }

    public boolean solveDFS(){
	return solveDFS(false);
    }

    public int[] solutionCoordinates(){

    }
}