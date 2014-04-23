package adfg.schedulability;


public class Pair<T> {

	private T first, second;
	
	public Pair(T a, T b){
		first=a; second=b;
	}
	
	public Pair(Pair<T> p){
		first=p.first; second=p.second;
	}

	public T getFirst() {
		return first;
	}

	public T getSecond() {
		return second;
	}
	
	public String toString(){
		return "("+first+","+second+")";
	}
}
