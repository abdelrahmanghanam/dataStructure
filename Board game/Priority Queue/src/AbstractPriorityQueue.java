import java.util.Comparator;

public abstract class AbstractPriorityQueue<K,V> implements PriorityQueue<K,V> {
	private Comparator<K> comp;
	protected static class PQEntry <K,V> implements Entry<K, V>{
        private K k;
        private V v;
        
        public PQEntry(K k, V v) {
        	this.k = k;
        	this.v = v;
        }
		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return k;
		}

		@Override
		public V getValue() {
			// TODO Auto-generated method stub
			return v;
		}
		
		protected void setKey(K k) {
			this.k = k;
		
		}
		protected void setValue(V v) {
			this.v = v;
		}
		
	}

	
	protected AbstractPriorityQueue(Comparator c){
		comp = c;
	}
	protected AbstractPriorityQueue() {
		Comparator <K> c = new DefaultComparator<K>();
		comp = c;
	}
	protected int compare(Entry<K, V> a, Entry<K, V> b) {
		return comp.compare(a.getKey(),b.getKey());
	}
	protected boolean checkKey(K key) throws IllegalArgumentException {
		try {
			return (comp.compare(key, key)==0);
		} catch(ClassCastException e) {
			throw new IllegalArgumentException("wrong");
		}
	}
	
	public boolean isEmpty() {
		return size()==0;
	}

}



