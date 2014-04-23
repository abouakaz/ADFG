package adfg.schedulability;



public class MathFunction {
	
	public static long GCD(long a, long b){
		if(b==0) return a;
		else return GCD(b,a%b);
    }
	
	public static long LCM(long a, long b){
    	return (a*b)/GCD(a, b);
    }
	
}
