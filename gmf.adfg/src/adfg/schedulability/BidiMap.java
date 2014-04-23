package adfg.schedulability;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class BidiMap<K, V> implements Iterable<Entry<K, V>> {

	private final HashMap<K, V>	forward;
	private final HashMap<V, K>	reverse;

	public BidiMap() {
		forward = new HashMap<K, V>();
		reverse = new HashMap<V, K>();
	}

	public void put(K k, V v) {
		forward.put(k, v);
		reverse.put(v, k);
	}

	public K getKey(V v) {
		return reverse.get(v);
	}

	public int size() {
		return forward.size();
	}

	public Iterator<Entry<K, V>> iterator() {
		return forward.entrySet().iterator();
	}

	public V getValue(K k) {
		return forward.get(k);
	}
	
	public boolean containsValue(V v){
		return reverse.containsKey(v);
	}
	
	public boolean containsKey(K k){
		return forward.containsKey(k);
	}

	public void removeKey(K k){
		V v=forward.get(k);
		forward.remove(k);
		reverse.remove(v);
	}
	
	public void removeValue(V v){
		K k=reverse.get(v);
		reverse.remove(v);
		forward.remove(k);
	}
	
	public Set<K> keySet(){
		return forward.keySet();
	}
	
	public Set<V> ValueSet(){
		return reverse.keySet();
	}
}
