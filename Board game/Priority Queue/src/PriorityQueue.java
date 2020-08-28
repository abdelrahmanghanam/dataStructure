
public interface PriorityQueue <K,V> {
	
	Entry<K,V> insert(K k, V v);
	Entry<K,V> removeMin();
	Entry<K,V> min();
	int size();
	boolean isEmpty();

}
