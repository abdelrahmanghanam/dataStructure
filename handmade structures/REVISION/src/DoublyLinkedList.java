

public class DoublyLinkedList <E> {
	public static void main(String [] args) {
		
		
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
		dll.addLast(4);
		dll.addFirst(1);
		
		dll.addFirst(2);
		dll.addFirst(3);
		
		System.out.println(dll.removeFirst());
		System.out.println(dll.removeFirst());
		
		System.out.println(dll.removeFirst());
		System.out.println(dll.removeLast());
		System.out.println(dll.size);
		
		
		
		
	}
	
	private Node<E> head;
	private Node<E> tail;
	private int size=0;

	class Node<E>{
		E data;
		Node<E> next;
		Node<E> previous;
		Node(E data, Node next,Node previous){
			this.data = data;
			this.next = next;
			this.previous=previous;
		}
		Node(E data){
			this.data=data;
			this.next = null;
			this.previous = null;
		}
		Node (){
			this.data= null;
			this.next = null;
			this.previous=null;
		}
	}
	
	public void addFirst(E data) {
		if (head == null) {
			head = new Node(data,null,null);
			tail = head;
		}else {
			Node<E> n = new Node(data,head,null);
			head.previous=n;
			head = n;
			if (size == 1) {
				tail.previous=head;
			}
		}
		size++;
	}
	
	public E removeFirst() {
	if (head==null) {
		return null;
	}else {
		E answer = head.data;
		head = head.next;
		if (head!=null) {
		head.previous=null;
		}
		size--;
		return answer;
	}
	}
	public void addLast(E data) {
		if (head==null) {
			addFirst(data);
		}else {
			tail.next = new Node(data,null,tail);
			tail = tail.next;
			size++;
		}
	}
	public E removeLast() {
		if(head==null) {
			return null;
		}else {
			E answer = tail.data;
			tail=tail.previous;
			if(tail!=null) {
			tail.next=null;
			}
			size--;
			return answer;
		}
	}
}
