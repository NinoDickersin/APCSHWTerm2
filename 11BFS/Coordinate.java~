public class Coordinate{
    public int r; //row
    public int c; //column
    public int d; //distance from start
    public Coordinate last; //last spot
    
    public Coordinate(int row, int col){
	r = row;
	c = col;
	d = 0;
	last = null;
    }

    public Coordinate(int row, int col, int dist, Coordinate l){
	r = row;
	c = col;
	d = dist;
	last = l;
    }

    public int getRow(){
	return r;
    }

    public int getCol(){
	return c;
    }

    public int getDistance(){
	return d;
    }

    public Coordinate getLast(){
	return last;
    }

    public String toString(){
	return "(" + r + ", " + c + ")";
    }
}
