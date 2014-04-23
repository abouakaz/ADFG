package adfg.schedulability;


public class _Channel {
	
	public static final int UNDEFINED=-1;

	private static int IDcount=1;
	
	private int ID;
	
	private int initial;
	
	private int size;
	
	private UPIS produce, consume; //Production rate and consumption rate
	
	private int dataSize=1; 
	
	public _Channel(UPIS prate, UPIS crate, int sz, int init){
		if(sz!=UNDEFINED && init!=UNDEFINED && sz<init) throw new Error("The size of the buffer must be greater than the number of initial tokens");
		ID=IDcount++;
		size=sz;
		initial=init;
		produce=prate.clone(); consume=crate.clone();
	}


	public int getID() {
		return ID;
	}


	public void setInitial(int initial) {
		this.initial = initial;
	}


	public int getInitial() {
		return initial;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public int getSize() {
		return size;
	}


	public void setDataSize(int dataSize) {
		this.dataSize = dataSize;
	}


	public int getDataSize() {
		return dataSize;
	}


	public UPIS getProduce() {
		return produce.clone();
	}
	
	public void setProduce(UPIS w){
		produce=w.clone();
	}


	public UPIS getConsume() {
		return consume.clone();
	}
	
	public void setConsume(UPIS w){
		consume=w.clone();
	}
	
	public String toString(){
		return "<"+((initial!=UNDEFINED)?initial:"*")+", "+((size!=UNDEFINED)?size:"*")+">";
	}
}
