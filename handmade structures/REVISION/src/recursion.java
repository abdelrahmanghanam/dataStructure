
public class recursion {
	public static int fib(int n){
		if(n == 0){
			return 0;
		}
		if(n == 1 || n == 2){
				return 1;
			}
		return fib(n-2) + fib(n-1);
		}
	public static void main(String[] args) {
    System.out.println(fib(3));

	}
	public static int binarySearch(int arr[], int l, int r, int x) 
    { 
        if (r >= l) { 
            int mid = l + (r - l) / 2; 
  
            // If the element is present at the 
            // middle itself 
            if (arr[mid] == x) 
                return mid; 
  
            // If element is smaller than mid, then 
            // it can only be present in left subarray 
            if (arr[mid] > x) 
                return binarySearch(arr, l, mid - 1, x); 
  
            // Else the element can only be present 
            // in right subarray 
            return binarySearch(arr, mid + 1, r, x); 
        } 
  
        // We reach here when element is not present 
        // in array 
        return -1; 
    } 
	

}
