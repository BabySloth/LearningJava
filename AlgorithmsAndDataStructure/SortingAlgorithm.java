import java.util.Arrays;

public class SortingAlgorithm {
	/**
	 * Sorts the array using bubble sort. From smallest to greatest.
	 * O(n^2)
	 *
	 * @param array Array to be sorted.
	 */
	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			boolean hasSwapped = false;

			// The last element will be sorted
			// Minus one because we are comparing the second last element we care to last element we care
			// The elements we care about are up to the length minus i because bubble sort brings all the large
			// numbers to the end of the array, therefore making the last i elements sorted
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					swap(array, j, j + 1);
					hasSwapped = true;
				}
			}

			// If there hasn't been any swaps, that means it is done sorting
			if (!hasSwapped) {
				return;
			}
		}
	}

	/**
	 * Sorts the array using selection sort. From smallest to greatest integer.
	 * O(n^2)
	 * <p>
	 * How this works:
	 * Outer loop:
	 * The outer loop will go through all the values up to the second last one. We do not care about the second last one
	 * because it will be sorted out at the end of the array. The pivot is the value of the current element of the
	 * index. The smallestNumberIndex is the index of the element that is the smallest from pivot index onwards.
	 * <p>
	 * Inner loop:
	 * This loop will look for the smallest value from pivot onwards. The index of the smallest value will be stored in
	 * smallestNumberIndex.
	 * <p>
	 * Finally:
	 * The index of the pivot will be swapped with the index of the smallest value. It is possible that the pivot is
	 * the smallest value. In that case, the swap will just swap the same element and it doesn't really matter.
	 * <p>
	 * This is different from insertion sort because insertion sort looks at the elements before, which are sorted.
	 * Selection sort looks at the elements ahead, which are unsorted.
	 *
	 * @param array Array to be sorted
	 */
	public static void selectionSort(int[] array) {
		// Don't care about the last element because that will always be the largest
		for (int i = 0; i < array.length - 1; i++) {
			int pivot = array[i];
			int smallestNumberIndex = i;

			// Finds the index of the smallest number from i onwards
			for (int j = i; j < array.length; j++) {
				if (array[j] < array[smallestNumberIndex]) {
					smallestNumberIndex = j;
				}
			}

			swap(array, i, smallestNumberIndex);
		}
	}

	/**
	 * Sorts the array using insertion sort. From smallest to greatest.
	 * O(n ^ 2)
	 * <p>
	 * How this works:
	 * Passes through the array starting from the unsorted index to the sorted index. The unsorted index starts at 1 and
	 * goes to the end of the array. If an element
	 *
	 * @param array Array to be sorted
	 */
	public static void insertionSort(int[] array) {
		// Don't care about the first element because it will be sorted later
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			int index = i;
			while (index > 0 && array[index - 1] > temp) {
				array[index] = array[index - 1];
				index--;
			}
			array[index] = temp;
		}
	}

	/**
	 * Swaps the values in the array
	 *
	 * @param array  Array to have its elements swapped
	 * @param first  First index of the element to swap
	 * @param second Second index of the element to be swapped
	 */
	private static void swap(int[] array, int first, int second) {
		int temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}
}