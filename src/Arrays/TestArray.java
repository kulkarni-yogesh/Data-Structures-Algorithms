package arrays;

public class TestArray {

	public static void main(String[] args) {
		//System.out.println("Factorial is: ");
		//System.out.println(factorial(5));

		System.out.println(reverseString("yogesh"));
		//System.out.println(reverseString("kayak"));
		//System.out.println(reverseString("nua"));
		//print(5);
		//print2DArray(3, 4);
		int[] arr = new int[] {-3, 2, 3, 3, 6, 8 , 15};
		
		twoSumProblem(arr, 6);
		
		int[] arr1 = new int[] {2, 1, 5, 1, 3, 2};
		int k = 3;
		slidingWindow(arr1, k);
		
		int[] arr2 = new int[] {1, 9, -1, -2, 7, 3, -1, 2};
		int k2 = 4;
		slidingWindow(arr2, k2);
		
		prefixSum(arr1);
		
	}
	
	//Opposite Directional two pointers
	public static void twoSumProblem(int[] arr, int target) {
		
		int start = 0;
		int end = arr.length - 1;
		int[] result = new int[2];
		while(start < end) {
			int sum = arr[start]+arr[end];
			if(sum == target) {
				result[0] = start+1;
				result[1] = end+1;
				break;
			}else if(sum < target) {
				start++;
			}else {
				end--;
			}
		}
		System.out.println(result[0]+"-"+result[1]);
		
		
	}
	
	//Equi-directional two pointers technique which is also called sliding window
	public static void slidingWindow(int[] arr, int k) {
		int windowSum = 0;
		int maxSum = 0;
		int start = 0;
		int end = 0;
		while(end < k) {
			windowSum += arr[end++];
		}
		while(end < arr.length) {
			windowSum += arr[end++] - arr[start++];
			maxSum = Math.max(windowSum, maxSum);
		}
		
		System.out.println("Maximum sum of any contigious subarray of size k is: "+ maxSum);
	}
	
	public static void prefixSum(int[] arr) {
		int[] prefixSum = new int[arr.length];
		prefixSum[0] = arr[0];
		for(int i =1; i < arr.length; i++) {
			prefixSum[i] = prefixSum[i-1] + arr[i];
		}
		for(int temp : prefixSum) {
			System.out.println(temp+ " ");
		}
		System.out.println("Sum in the range of 1 to 4 is "+ (prefixSum[4] - prefixSum[0]));
	}

	public static int factorial(int number) {
		if (number == 0)
			return 1;

		return number * factorial(number - 1);

	}

	public static String reverseString(String str) {
		if (str.length() <= 1) {
			return str;
		}

		return reverseString(str.substring(1)) + str.charAt(0);
	}
	
	public static void print(int n) {
		if(n < 1) 
			return;		
		System.out.print("\nExecuting head recursion");
		print(n-1);
		System.out.print(n+"--");
		System.out.print("\nExecuting tail recursion");
		print(n-1);
		
	}
	
	public static void print2DArray(int row, int columns) {
		int[][] arr = { { 1, 2, 3, 0 }, { 3, 4, 5, 0 }, {6, 7, 8, 0} };
		for(int i=0; i < row; i++){
			for(int j=0; j < columns; j++) {
				System.out.print(arr[i][j] + "\t");
				
				
			}
			System.out.println();
		}
		
		
	}

}
