public class Recursion implements hw1{

    public String name(){
	return "Dickersin,Nino";
    }

    public void illegalArg(double n){
	if (n < 0){
	    throw new IllegalArgumentException();
	} 
    }

    public int fact(int n){
	illegalArg(n);
	if (n < 2){
	    return 1;
	}
	return n * fact(n - 1);
    }

    public int fib(int n){
	illegalArg(n);
	if (n < 1){
	    return 0;
	}else if(n < 3){
	    return 1;
	}	
	return fib(n - 1) + fib (n - 2);
    }

    public double sqrt(double n){
	illegalArg(n);
	return guesser (n, n / 2);
    }

    public double guesser (double n, double guess){
	double g = guess - ((n / guess + guess) / 2);
	if (g < 0.00000001 && g > -0.00000001){
	    return guess;
	}
	return guesser (n, ((n / guess + guess) / 2));
    }

    
public static void main(String[]args){
    Recursion a = new Recursion();
    System.out.println(a.name());
    System.out.println(a.fact(5));
    System.out.println(a.fib(30));
    System.out.println(a.sqrt(18742));
}
    
}
