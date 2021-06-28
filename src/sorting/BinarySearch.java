package sorting;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {

		int[] arr = { 5, 6, 7, 8, 9, 10, 11, 12, 14, 15, 16, 17, 18, 19 };

		System.out.println(findElement(arr, 19));

		System.out.println(findElement(arr, 2));

	}

	public static String findElement(int[] arr, int element) {
		Arrays.sort(arr);
		int min = 0;
		int max = arr.length - 1;
		int pivot = arr.length / 2;
		if (arr[pivot] == element) {
			return element + " exists in the middle";
		}
		if (element > arr[pivot]) {
			min = pivot;
		} else {
			max = pivot;
		}
		for (int i = min; i < max; i++) {
			if (arr[i] == element) {
				return element + " exists in the given input array";
			}

		}
		return element + " does not exists in the given input array";
	}

}
