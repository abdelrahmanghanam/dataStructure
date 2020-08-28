import java.util.ArrayList;
import java.util.Comparator;

public class HeapPriorityQueue<K,V> extends AbstractPriorityQueue <K,V> {
	
	
	protected ArrayList<Entry<K, V>> h = new ArrayList<>();
	public HeapPriorityQueue() {
		super();
	}
	public HeapPriorityQueue(Comparator<K> comp) {
		super(comp);
	}
	protected int parent (int j) {
		return ((j-1)/2);
	}
	protected int left (int j) {
		return (2*j +1);
	}
	protected int right(int j) {
		return (2*j +2);
	}
	protected boolean hasLeft(int j) {
		return left(j)<h.size();
	}
	protected boolean hasRight(int j) {
		return right(j)<h.size();
	}
	protected void swap(int i, int j) {
		Entry<K, V> e = h.get(i);
		h.set(i,h.get(j));
		h.set(j,e);
	}
	protected void upHeap(int j) {
		while(j>0) {
			int p = parent(j);
			if (compare(h.get(j),h.get(p))>=0) {
				break;
			}
			swap(j,p);
			j=p;
		}
	}
	
	protected void downHeap(int j) {
		while (hasLeft(j)) {
			int leftIndex = left(j);
			int smallChildIndex = leftIndex;
			if (hasRight(j)) {
				int rightIndex = right(j);
				if (compare(h.get(leftIndex), h.get(rightIndex))>0)
					smallChildIndex = rightIndex;
			}
			if (compare(h.get(smallChildIndex), h.get(j))>=0) {
				break;
			}
			swap(j,smallChildIndex);
			j=smallChildIndex;
		}
	}
	@Override
	public Entry<K, V> insert(K k, V v) {
		checkKey(k);
		Entry<K,V> e = new PQEntry<>(k,v);
		h.add(e);
		upHeap(h.size()-1);
		return e;
	
	}
	@Override
	public Entry<K, V> removeMin() {
		if (h.isEmpty())
		return null;
		Entry<K,V> e =h.get(0);
		swap(0,h.size()-1);
		h.remove(h.size()-1);
		downHeap(0);
		return e;
	}
	@Override
	public Entry<K, V> min() {
		if (h.isEmpty())
		return null;
		return h.get(0);
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return h.size();
	}
	

}
