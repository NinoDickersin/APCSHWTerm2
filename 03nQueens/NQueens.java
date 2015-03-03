public class NQueens{
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    //instance variables
    private char[][]board;

    private int qCount = 0;

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
    public NQueens(int size){
	board = new char[size][size];
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[0].length; j++){
		board[i][j] = 'x';
	    }
	}
    }

    public String toString(){
	String ans = "\n";
	for(int i = 0; i < board.length; i ++){
	    for (int j = 0; j < board[0].length; j++){
		ans += board[i][j] + " ";
	    }
	    ans += "\n";
	}
	if(qCount == 8){
	    ans += "Solved\n";
	}else{
	    ans += "No Solution\n";
	}
	return  ans + "\n";
    }

    public String name(){
	return "dickersin.nino";
    }

    public boolean solve(){
	return solve(0);
    }
    public boolean solve(int x){
	return solve(x, 0);
    }
    public boolean solve(int x, int y){
	/**
	   if (x < 0 || y < 0 || x > board[0].length - 1 || y > board.length - 1){
	   return false;
	   }
	**/
	//base case
	if(qCount == 8){
	    return true;
	}
	for(int i = x;i < board[0].length; i++){
	    if(checkSpot(i,y)){
		board[y][i] = 'Q';
		qCount ++;
		if (solve(0, y + 1)){
		    return true;
		}
		board[y][i] = 'x';
		qCount --;
	    }
	}

	return false;
    }

    public boolean checkSpot(int x, int y){
	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board[0].length; j++){
		if(((i == y) || (j == x) || Math.abs(j - x) == Math.abs(i - y))
		   && board[i][j] == 'Q'){
		    return false;
		}
	    }
	}
	return true;
    }
    public static void main(String[]args){
	NQueens a = new NQueens(8);
	a.solve(3);
	System.out.println(a);
    }
}
