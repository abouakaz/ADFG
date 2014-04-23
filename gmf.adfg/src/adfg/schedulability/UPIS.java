package adfg.schedulability;


/**
 * Class Ultimately Periodic Integer Sequence s=u(v)
 * @author Adnan Bouakaz
 *
 */
public class UPIS {
	
	private int[] sequence;
	private int prefixLength=0; //periodLenght = sequence.lenght - prefixLenght;
	
	public UPIS(String str){
		if(!str.matches("[0-9 ]*\\([0-9 ]+\\) *")) throw new Error("Error in syntax of a sequence");
		String[] Str=str.split("\\("); Str[1]=Str[1].replaceAll("\\)", " ");		
    	//Str[0] is the prefix
    	String u=Str[0].trim();
    	int[] prefix=null;
    	if(u.length()>0){
    		String[] uu=u.split(" +"); 
    		prefix= new int[uu.length];
    		for(int i=0;i<uu.length;i++) prefix[i]=Integer.parseInt(uu[i]);
    	}   	
    	if(prefix!=null) prefixLength=prefix.length;	
    	//Str[1] is the period
    	String v=Str[1].trim();
    	int[] period=null;
    	int sum=0;
    	if(v.length()>0){
    		String[] vv=v.split(" +");
    		period= new int[vv.length];
    		for(int i=0;i<vv.length;i++){ period[i]=Integer.parseInt(vv[i]); sum+=period[i]; }
    	}  	
    	if(sum==0) throw new Error("The sum of elements of a period must be greater than zero");
    	int sequenceSize=prefixLength+period.length;
    	sequence=new int[sequenceSize];
    	if(prefixLength!=0) System.arraycopy(prefix, 0, sequence, 0, prefix.length);
    	System.arraycopy(period, 0, sequence, prefixLength, period.length);
	}
	
	private UPIS(UPIS s){
		prefixLength=s.prefixLength;
		sequence = new int [s.sequence.length];
		System.arraycopy(s.sequence, 0, sequence, 0, sequence.length);
	}
	
	protected UPIS(int[] seq, int pref){
		prefixLength=pref;
		sequence=seq;
	}
	
	/**
	 * 1(02) ==>1020(20)
	 */
	public UPIS shift(int h){
		int[] shiftedSequence=new int[sequence.length+h];
		System.arraycopy(sequence, 0, shiftedSequence, 0, sequence.length);
		for(int i=0;i<h; i++) shiftedSequence[i+sequence.length]=elementAt(i+sequence.length+1);
		return new UPIS(shiftedSequence,prefixLength+h);
	}
	
	/**
	 * 1(02) ==> 1(0202)
	 * @param h is strictly positive
	 */
	public UPIS unfold(int h){
		if(h==0) throw new Error("cannot unfold sequence with parameter 0");
		int[] unfoldedSequence=new int[sequence.length+(h-1)*getPeriodLength()];
		System.arraycopy(sequence, 0, unfoldedSequence, 0, sequence.length);
		for(int i=1; i<h; i++) System.arraycopy(sequence, prefixLength, unfoldedSequence,sequence.length+(i-1)*getPeriodLength(), getPeriodLength());
		return new UPIS(unfoldedSequence,prefixLength);
	}
	
	public UPIS shiftUnfold(int h1, int h2){
		return shift(h1).unfold(h2);
	}
	
	/**
	 * 2(137) over 10(1001) ==> 20(1003)
	 * this must be a binary sequence.
	 */
	public UPIS distributOver(UPIS w){
		int[] seq=new int[sequence.length];
		System.arraycopy(sequence, 0, seq, 0, sequence.length);
		int nbNonZero=0;
		for(int i=0;i<seq.length;i++){
			if(seq[i]>0){
				seq[i]=w.elementAt(++nbNonZero);
			}
		}
		return new UPIS(seq,prefixLength);
	}
	
	/**
	 * seq1 and seq2 are two binary sequences with equal lengths
	 */
	public static Pair<UPIS> hyperPeriod(UPIS seq1, UPIS seq2, UPIS w1, UPIS w2){
		/* shift */
		int u1=0; for(int i=1; i<=seq1.getPrefixLength();i++) if(seq1.elementAt(i)==1) u1++; /* u1 is the number of 1's in the prefix of seq1 */
		int v1=0; for(int i=1; i<=seq1.getPeriodLength();i++) if(seq1.elementAt(i+seq1.getPeriodLength())==1) v1++; /* v1 is the number of 1's in the period of seq1 */
		int l1=w1.getPrefixLength(), sh1=0;
		if(l1>0 && l1>u1){
			int nbof1=u1;
			while(nbof1<l1){ if(seq1.elementAt(sh1+seq1.prefixLength+1)==1) nbof1++; sh1++; }
		}
		int u2=0; for(int i=1; i<=seq2.getPrefixLength();i++) if(seq2.elementAt(i)==1) u2++; /* u2 is the number of 1's in the prefix of seq2 */
		int v2=0; for(int i=1; i<=seq2.getPeriodLength();i++) if(seq2.elementAt(i+seq2.getPeriodLength())==1) v2++; /* v2 is the number of 1's in the period of seq1 */
		int l2=w2.getPrefixLength(), sh2=0;
		if(l2>0 && l2>u2){
			int nbof1=u2;
			while(nbof1<l2){ if(seq2.elementAt(sh2+seq2.prefixLength+1)==1) nbof1++; sh2++; }
		}
		int sh; if(sh1>=sh2) sh=sh1; else sh=sh2;
		if(sh>0){
			seq1=seq1.shift(sh);
			seq2=seq2.shift(sh);
		}
		/* unfold */
		int k= (w1.getPeriodLength() * w2.getPeriodLength())/(int)MathFunction.GCD(w1.getPeriodLength()*v2,w2.getPeriodLength()*v1);
		if(k>1){
			seq1=seq1.unfold(k);
			seq2=seq2.unfold(k);
		}
		return new Pair<UPIS>(seq1,seq2);
	}
	/**
	 * @param i index starts from 1
	 */
	public int elementAt(int i){
		if(i<=sequence.length) return sequence[i-1];
		i= (i-prefixLength-1)%(sequence.length-prefixLength);
		return sequence[i+prefixLength];
	}
	
	public int getPrefixLength(){
		return prefixLength;
	}
	
	public int getPeriodLength(){
		return sequence.length-prefixLength;
	}
	
	public int getLength(){
		return sequence.length;
	}
	
	public int getCumulative(int j){
		int sum=0;
		for(int i=1; i<=j; i++) sum+=elementAt(i);
		return sum;
	}
	
	public int getSumPeriod(){
		int sum=0; for(int i=prefixLength; i<sequence.length;i++) sum+=sequence[i];
		return sum;
	}
	
	public int getSumPrefix(){
		int sum=0; for(int i=0; i<prefixLength;i++) sum+=sequence[i];
		return sum;
	}
	
	public int getSum(){
		int sum=0; for(int i=0; i<sequence.length;i++) sum+=sequence[i];
		return sum;
	}
	
	public Pair<Fraction> linearBounds(){
		int v=getPeriodLength(), sum_v=getSumPeriod(); Fraction slope=new Fraction(sum_v,v); 
		Fraction maxLambda=new Fraction(0,1), minLambda= new Fraction(0,1);
		int sum=0;
		for(int i=0; i<sequence.length; i++){
			sum+=sequence[i];
			Fraction temp=new Fraction(-(i+1),1).MUL(slope); temp=temp.ADD(new Fraction(sum,1));
			if(maxLambda.lessOrEquals(temp)) maxLambda=temp;
			if(!minLambda.lessOrEquals(temp)) minLambda=temp;
		}
		return new Pair<Fraction>(minLambda,maxLambda);
	}
	
	public Pair<Integer> constantBounds(){
		int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
		for(int i=0; i<sequence.length; i++){
			if(min>sequence[i]) min=sequence[i];
			if(max<sequence[i]) max=sequence[i];
		}
		return new Pair<Integer>(min,max);	
	}
	
	public UPIS clone(){
		return new UPIS(this);
	}
	
	public String toString(){
		String str="";
		for(int i=0;i<prefixLength;i++) str+=sequence[i]+" ";
		str+="( ";
		for(int i=prefixLength;i<sequence.length;i++) str+=sequence[i]+" ";
		str+=")";
		return str;
	}

}
