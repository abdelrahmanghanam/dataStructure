
public class SinglyLinkedList<E> implements Cloneable{

	public static void main(String[] args) {
		SinglyLinkedList<String> sll = new SinglyLinkedList<String>();
		sll.addFirst("haha");
		sll.addFirst("dada");
		sll.addLast("mama");
		try {
			SinglyLinkedList<String> sll2 = sll.clone();
			System.out.println( sll2.removeLast());
			System.out.println(sll2.removeFirst());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		

	}
	class Node<E>{
		E data;
		Node<E> next;
		Node(E data, Node next){
			this.data = data;
			this.next = next;
		}
		Node(E data){
			this.data=data;
			this.next = null;
		}
		Node (){
			this.data= null;
			this.next = null;
		}
	}

	private Node<E> head = null;
	private Node<E> tail = null;
	private int size;
	
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public E first() {
		if (size==0)
			return null;
		return head.data;
	}
	public E last() {
		if (size==0)
			return null;
		return tail.data;
	}
	public void addFirst(E data) {
		head = new Node(data, head);
		if (size==0) 
			tail=head;
		size++;
	}
	public void addLast(E data) {
		Node<E> test = new Node(data);
		if(size==0) {
			addFirst(data);
		}else {
			if (tail.next==null)
		tail.next=new Node<E>(data,null);
		tail=test;
		if (size==0)
			head = tail;
		}
		size++;
	}
	public E removeFirst() {
		if (isEmpty()) {
			return null;
		}else {
			E answer = head.data;
			head = head.next;
			size--;
			if (size==0)
				tail=null;
			return answer;
		}
	}
	public E removeLast() {
		if (isEmpty()) {
			return null;
		}else {
			E answer = tail.data;
			Node<E> test = head;
			if (size==1) {
				return removeFirst();
			}
			while(test.next.next!=null)
				test = test.next;
			test.next= null;
			size--;
			if (size==0) {
				head = null;
				tail=null;
			}
			return answer;
		}
	}
	public SinglyLinkedList<E> clone() throws CloneNotSupportedException{
		SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone();
		if (size==0) {
			return null;
		}
		Node<E> test = head;
		other.head = new Node(head.data,null);
		Node <E> headTest = other.head;
		
		while(test.next!=null) {
			Node <E> n = new Node(test.next.data,null);
			headTest.next = n;
			headTest = headTest.next;
			test = test.next;
		}
		headTest = new Node(test.data,null);
		other.tail = headTest;
		return other;
	}
}
