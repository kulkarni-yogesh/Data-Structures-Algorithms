package sorting;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = { 64, 34, 25, 12, 22, 11, 90 };

		bubbleSort(arr);

	}

	public static void bubbleSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					// swap arr[j+1] and arr[j]
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		System.out.println("Printing the array....");
		for (int print : arr) {
			System.out.print(print + " ");
		}
	}

}
