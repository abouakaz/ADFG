package adfg.schedulability;


public class Fraction {

	private long a,b;
	
	public Fraction(long x, long y){
		if(y==0) throw new Error("Division by zero in a fraction");
		if(y<0){x=-x; y=-y;}
		long gcd=MathFunction.GCD( Math.abs(x), Math.abs(y) ); /*Canonical form*/
		a=x/gcd;
		b=y/gcd;
	}
	
	public double getValue(){
		return (double)a/b;
	}
	
	public Fraction MUL(Fraction f){
		return new Fraction(a*f.a, b*f.b);
	}
	
	public Fraction reverse(){
		if(a==0) throw new Error("Division by zero in a fraction");
		return new Fraction(b,a);
	}
	
	public Fraction DIV(Fraction f){
		return this.MUL(f.reverse());
	}
	
	public Fraction ADD(Fraction f){
		return new Fraction(a*f.b+f.a*b, b*f.b);
	}
	
	public Fraction DIF(Fraction f){
		return new Fraction(a*f.b-f.a*b, b*f.b);
	}
	
	public boolean lessOrEquals(Fraction f){
		return (a*f.b <= b*f.a);
	}
	
	public boolean less(Fraction f){
		return (a*f.b < b*f.a);
	}

	public long getA() {
		return a;
	}

	public long getB() {
		return b;
	}
	
	public Fraction clone(){
		return new Fraction(a,b);
	}
	
	public boolean equals(Fraction f){
		return (a==f.a && b==f.b);
	}
	
	public String toString(){
		return a+"/"+b;
	}
	
	
}
