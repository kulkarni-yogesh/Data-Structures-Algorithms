package sorting;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = { 64, 25, 12, 22, 11 };

		selectionSort(arr);

	}

	public static void selectionSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int min_element = i;
			for (int j = i+1; j < n; j++) {
				if (arr[min_element] > arr[j]) {
					min_element = j;
				}
			}

			int temp = arr[min_element];
			arr[min_element] = arr[i];
			arr[i] = temp;
			

		}
		System.out.println("Printing the array....");
		for (int print : arr) {
			System.out.print(print + " ");
		}
	}

}
