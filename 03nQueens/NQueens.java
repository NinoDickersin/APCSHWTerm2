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
	return hide + clear + go(0,0) + ans + "\n" + show;
    }

    public String name(){
	return "dickersin.nino";
    }

    public boolean solve(){
	return solve(0);
    }
    /**
    public boolean solve(int x){
	return solve(0, x);
    }
    **/
    public boolean solve(int x){
	/**
 	if (x < 0 || y < 0 || x > board[0].length - 1 || y > board.length - 1){
	    return false;
	}
	**/
	System.out.println(this);
	wait(20);

	//base case
	if(qCount == 8){
	    return true;
	}
	for(int i = 0;i < board.length; i++){
	    if(checkSpot(x,i)){
		board[x][i] = 'Q';
		qCount ++;
		if (solve(x + 1)){
		    return true;
		}
	    board[x][i] = 'x';
	    qCount --;
	    }
	}

	return false;
    }

    public boolean checkSpot(int x, int y){
	for (int i = 0; i < board.length - 1; i++){
	    for (int j = 0; j < board[0].length - 1; j++){
		if(((i == y) || (j == x) || Math.abs(i - x) == Math.abs(j-y)) && board[j][i] == 'Q'){
		    return false;
		}
	    }
	}
	return true;
    }
    public static void main(String[]args){
	NQueens a = new NQueens(8);
	a.solve();
    }
}
