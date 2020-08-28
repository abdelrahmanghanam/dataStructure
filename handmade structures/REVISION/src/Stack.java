import java.util.Arrays; 
public class Stack <E> extends SinglyLinkedList<E>{
	public static void main(String []Args) {
		int [] i = {1,2,3};
		System.out.println(Arrays.toString(i)); 
		change(i);
		System.out.println(Arrays.toString(i)); 
	}
	public static void change(int [] arr) {
		Stack<Integer> s = new Stack<Integer>();
		for(int i=0;i<arr.length;i++) {
			s.push(arr[i]);
		}
		for(int i=0;i<arr.length;i++) {
			arr[i]=s.pop();
		}
		
		
	}
	
	public void push(E data) {
		super.addFirst(data);
	}
	public E pop() {
		return removeFirst();
	}
	public int size() {
		return super.size();
	}
	public boolean isEmpty() {
		return super.isEmpty();
	}

}
