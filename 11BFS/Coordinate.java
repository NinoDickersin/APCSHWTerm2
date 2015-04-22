public class Coordinate{
    public int r; //row
    public int c; //column
    public int d; //distance from start
    public Coordinate last; //last spot
    public int endX, endY;
    
    public Coordinate(int row, int col, int eX, int eY){
	r = row;
	c = col;
	d = 0;
	last = null;
	endX = eX;
	endY = eY;
    }

    public Coordinate(int row, int col, int dist, Coordinate l, int eX, int eY){
	r = row;
	c = col;
	d = dist;
	last = l;
	endX = eX;
	endY = eY;
    }

    public int getRow(){
	return r;
    }

    public int getCol(){
	return c;
    }

    public int getDistanceFrom(){
	return d;
    }

    public int getDistanceTo(){
	return Math.abs(endX - this.getRow()) + Math.abs(endY  -this.getCol());
    }

    public Coordinate getLast(){
	return last;
    }

    public String toString(){
	return "(" + r + ", " + c + ")";
    }
}
