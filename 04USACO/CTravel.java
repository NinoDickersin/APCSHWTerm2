public class CTravel{

    public char[][] pasture;
    public int cowRow, cowCol, endRow, endCol;
    public int moves;

    public CTravel(int time){
	pasture = new char[][]{ {'.','.','.','*','.'},
				{'.','.','.','*','.'},
				{'.','.','.','.','.'},
				{'.','.','.','.','.'} };
	moves = time;
    }

    public int run(int cowRow, int cowCol, int endRow, int endCol){
	return run(cowRow - 1, cowCol - 1, endRow - 1, endCol - 1, moves);
    }

    public int run(int cowRow, int cowCol, int endRow, int endCol, int moves){
	if(moves == 0 && (cowRow != endRow || cowCol != endCol)){
	    return 0;
	}else if(moves == 0 && cowRow == endRow && cowCol == endCol){
	    return 1;
	}
	if (cowRow < 0 || cowRow >= pasture.length ||
	    cowCol < 0 || cowCol >= pasture[0].length){
	    return 0;
	}
	if(pasture[cowRow][cowCol] == '*'){
	    return 0;
	}
	return run(cowRow + 1, cowCol, endRow, endCol, moves - 1) +
	    run(cowRow - 1, cowCol, endRow, endCol, moves - 1) +
	    run(cowRow, cowCol + 1, endRow, endCol, moves - 1) +
	    run(cowRow, cowCol - 1, endRow, endCol, moves - 1);
    }

    public static void main(String[]args){
	CTravel a = new CTravel(6);
	System.out.println(a.run(1, 3, 1, 5));
    }
}
