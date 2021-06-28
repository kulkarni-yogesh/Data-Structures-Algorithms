package sorting;

public class LinearSearch {

	public static void main(String[] args) {

		int[] arr = { 5, 6, 7, 8, 9, 10, 11, 12, 14, 15, 16, 17, 18, 19 };

		System.out.println(findElement(arr, 19));

		System.out.println(findElement(arr, 2));

	}

	public static String findElement(int[] arr, int element) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == element) {
				return element + " exists in the given input array";
			}
		}
		return element + " does not exists in the given input array";
	}

}
