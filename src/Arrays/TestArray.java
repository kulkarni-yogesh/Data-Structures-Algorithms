package arrays;

public class TestArray {

	public static void main(String[] args) {
		System.out.println("Factorial is: ");
		System.out.println(factorial(5));

		System.out.println(reverseString("yogesh"));
		//System.out.println(reverseString("kayak"));
		//System.out.println(reverseString("nua"));
		print(5);

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

}
