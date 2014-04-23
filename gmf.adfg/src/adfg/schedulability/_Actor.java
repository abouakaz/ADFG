package adfg.schedulability;


public class _Actor {
	
	public static final long UNDEFINED=-1;
	
	private static int IDcount=1;
	
	private int ID;
	
	private String name;
	
	private long wcet;
	
	private long period=UNDEFINED, phase=UNDEFINED, periodUpperBound=UNDEFINED, periodLowerBound=0;
	
	private Fraction symbolicDeadline=new Fraction(1,1); //deadline=period
	
	private long deadline=UNDEFINED;
	
	private int priority;
	
	private int nbPartition=1;
	
	public _Actor(String nm, long w){
		if(w<=0) throw new Error("The worst-case execution time must be strictly positive");
		ID=IDcount++;
		name=nm;
		wcet=w;
	}

	public int getID() {
		return ID;
	}

	protected void setPeriod(long p){
		period=p;
		concretizeSymbolicDeadline(p);
	}
	
	protected void setPhase(long ph){
		phase=ph;
	}
	
	public long getWcet() {
		return wcet;
	}

    protected void setWcet(long time){
    	wcet=time;
    }
    
	public long getPeriod() {
		return period;
	}

	public long getPhase() {
		return phase;
	}

	public void setPeriodUpperBound(long pub) {
		periodUpperBound = pub;
	}

	public long getPeriodUpperBound() {
		return periodUpperBound;
	}

	public void setPeriodLowerBound(long plb) {
		periodLowerBound = plb;
	}

	public long getPeriodLowerBound() {
		return (periodLowerBound<wcet)?wcet:periodLowerBound;
	}

	public void setSymbolicDeadline(Fraction sd) {
		symbolicDeadline = sd.clone();
	}

	public Fraction getSymbolicDeadline() {
		return symbolicDeadline.clone();
	}

	public String getName() {
		return name;
	}
	
	public void setName(String str){
		name=str;
	}
	
	public String toString(){
		return "("+name+", "+wcet+", "+((period!=UNDEFINED)?period:"*")+", "+((phase!=UNDEFINED)?phase:"*")+")";
	}

	protected void setDeadline(long d) {
		deadline = d;
	}
	
	private void concretizeSymbolicDeadline(long p){
		if(p==UNDEFINED) deadline=UNDEFINED;
		else deadline=p*symbolicDeadline.getA()/symbolicDeadline.getB();
	}

	public long getDeadline() {
		return deadline;
	}
	
	public boolean equals(Object obj){
		if(obj instanceof _Actor) return ((_Actor)obj).getID()==ID;
		return false;
	}

	public void setPriority(int pr) {
		priority = pr;
	}

	public int getPriority() {
		return priority;
	}
	
	public void setNbPartition(int nb) {
		nbPartition = nb;
	}

	public int getNbPartition() {
		return nbPartition;
	}

}
