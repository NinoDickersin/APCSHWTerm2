public class Coordinate{
    public int x;
    public int y;
    
    public Coordinate(int xcor, int ycor){
	x = xcor;
	y = ycor;
    }

    public void setX(int xcor){
	x = xcor;
    }

    public void setY(int ycor){
	y = ycor;
    }

    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }

    public String toString(){
	return "(" + x + ", " + y + ")";
    }
}