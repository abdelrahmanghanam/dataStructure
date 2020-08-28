
public class Queue<E> extends SinglyLinkedList<E> {

	public static void main(String[] args) {
		Queue<String> q = new Queue<String>();
		q.enqueue("haha");
		q.enqueue("dada");
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}
	public void enqueue(E data) {
		super.addLast(data);
	}
	public E dequeue() {
		return removeFirst();
	}
	public int size() {
		return super.size();
	}
	public boolean isEmpty() {
		return super.isEmpty();
	}


}
