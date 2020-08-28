import java.util.NoSuchElementException;

public class Arrays {

	public static void main(String[] args) {
		int [] i = { 1,2,3,4,5};
		for (int j=0;j<i.length;j++) {
			System.out.print(i[j]);
		}System.out.println();
		remove(2,i);
		for (int j=0;j<i.length;j++) {
			System.out.print(i[j]);
		}System.out.println();

	}
	public static void remove(int index, int [] arr) {
		if (index>=arr.length|| index<0)
			throw new NoSuchElementException();
		for (int i=index;i<arr.length;i++) {
			if (i==arr.length-1) {
				arr[i]=0;
			}else {
			arr[i]=arr[i+1];
			}
		}
		
	}
	public static void shift(int i1,int i2, int [] arr) {
		int temp;
		temp = arr[i1];
		arr[i1]= arr[i2];
		arr[i1]= temp;
	}
	public static <E> void shift(E e){
		
	}
	

	
}
