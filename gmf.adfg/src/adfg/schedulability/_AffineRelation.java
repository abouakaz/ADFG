package adfg.schedulability;


/** 
 * @author Adnan Bouakaz
 *
 */
public class _AffineRelation {
	
	public static final int UNDEFINED=Integer.MIN_VALUE; 

	private int n, phi, d;
		
	public _AffineRelation(int a, int b, int c){
		if(a <= 0 || c<=0) throw new Error("parameters N and D of an affine relation must be stricly positive");
		int gcd=(int)MathFunction.GCD(a, c); /*Canonical form*/
		a=a/gcd;
		c=c/gcd;
		if(b==UNDEFINED){  n=2*a;  phi=UNDEFINED; d=2*c; }
		else if(b%gcd==0){ n=a; phi=b/gcd; d=c; }
		else { n=2*a; phi=(b>0)? 1+2*(b/gcd):-1+2*(b/gcd); d=2*c; }
	}

	public boolean isConsistentWith(_AffineRelation r){
		if ( (phi==UNDEFINED && r.phi==UNDEFINED) || (phi!=UNDEFINED && r.phi!=UNDEFINED) ) return equals(r);
		return new Fraction(n,d).equals(new Fraction(r.n,r.d));
	}
	
	public _AffineRelation getReverse(){
		_AffineRelation rtemp= new _AffineRelation(d,(phi==UNDEFINED)?UNDEFINED:-phi,n);
		return rtemp;
	}
	
	public Pair<UPIS> binaryEncoding(){
		boolean reversed=(phi<0);
		int  n1,phi1,d1;
		if(reversed){ n1=d; phi1=-phi; d1=n;} else{ n1=n; phi1=phi; d1=d;}
		int c1=(int) Math.ceil((double)phi1/n1); /* the length of the prefix */
		int c2; if(MathFunction.GCD(n1, d1)==1) c2=n1+d1-1; else c2=(n1+d1)/2; /* the length of the period */
		
		int[] sequence1=new int[c1+c2], sequence2=new int[c1+c2];
		for(int i=0;i<c1; i++){sequence1[i]=1; sequence2[i]=0; } 
		
		int added=0, k1=c1*n1, k2=phi1;
		while(added<c2){
			if(k1>k2){ sequence1[c1+added]=0; sequence2[c1+added]=1; k2+=d1; }
			else if (k1<k2){ sequence1[c1+added]=1; sequence2[c1+added]=0; k1+=n1;}
			else { sequence1[c1+added]=1; sequence2[c1+added]=1; k1+=n1; k2+=d1;}
			added++;
		}
		return (reversed)?new Pair<UPIS>(new UPIS(sequence2,c1), new UPIS(sequence1,c1)):new Pair<UPIS>(new UPIS(sequence1,c1), new UPIS(sequence2,c1));
	}
	
	
	public int getN() {
		return n;
	}

	public void setPhi(int b) {
		_AffineRelation r=new _AffineRelation(n,b,d);
		n=r.n; phi=r.phi; d=r.d;
	}

	public int getPhi() {
		return phi;
	}

	public int getD() {
		return d;
	}
	
	public _AffineRelation clone(){
		_AffineRelation rtemp= new _AffineRelation(n,phi,d);
		return rtemp;
	}
	
	public boolean equals(_AffineRelation r){
		return (n==r.n && phi==r.phi && d==r.d);
	}
	
	public String toString(){
		return "("+n+","+((phi==UNDEFINED)?"*":phi)+","+d+")";
	}
	
	private boolean problem=false;
	public void setIncorrect(){problem=true;}
	public boolean isIncorrect(){return problem;}


}
