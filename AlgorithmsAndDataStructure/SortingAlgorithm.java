package AlgorithmsAndDataStructure;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;

public class SortingAlgorithm {
    /**
     * Test
     */
    public static void main(String[] args) {
        test(SortingAlgorithm::bubbleSort, "bubble sort");
        test(SortingAlgorithm::selectionSort, "selection sort");
        test(SortingAlgorithm::insertionSort, "insertion sort");
        test((int[] elements) -> quickSort(elements, 0, elements.length), "quick sort");
    }

    /**
     * Tests the sorting algorithm.
     *
     * @param sortingAlgorithm Sorting Algorithm to be tested
     * @param name             Name of the sorting algorithm
     */
    private static void test(Consumer<int[]> sortingAlgorithm, String name) {
        int[] unsorted = random10Elements();
        System.out.println("Testing: " + name);
        System.out.println("Unsorted: " + Arrays.toString(unsorted));

        sortingAlgorithm.accept(unsorted);
        System.out.println("Result: " + Arrays.toString(unsorted));
        if (isOrdered(unsorted)) {
            System.out.println("FAILED");
        } else {
            System.out.println("PASSED");
        }
    }

    /**
     * Gives an int array of 10 random integers.
     *
     * @return An int array of 10 random integers.
     */
    private static int[] random10Elements() {
        int[] randoms = new int[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            randoms[i] = random.nextInt() % 11;
        }
        return randoms;
    }

    /**
     * Checks if the given array is in order, that is from least to greatest.
     *
     * @param array Array to check if it is in order
     * @return True if the all elements (other than index 0) are greater than or equal to the one before it, false otherwise.
     */
    private static boolean isOrdered(int[] array) {
        for (int i = 1; i < array.length; i++) {
            // Check if previous number is greater
            if (array[i - 1] > array[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Sorts the array using bubble sort. From smallest to greatest.
     * Best: O(n)
     * Average: O(n^2)
     * Worst: O(n^2)
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
     * Best: O(n^2)
     * Average: O(n^2)
     * Worst: O(n^2)
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
     * Best: O(n)
     * Average: O(n^2)
     * Worst: O(n^2)
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
     * Performs quicksort on the integer array. From smallest to greatest.
     * Best: O(NlogN)
     * Average: O(NlogN)
     * Worst: O(n^2)
     * <p>
     * This is the divide and conquer method and also know as the partition-exchange sorting algorithm.
     * This implementation does not return anything to make testing easier. This is an in-place algorithm, meaning that
     * no extra space is used up.
     *
     * @param array Array to be sorted
     * @param start Put 0
     * @param end   Put the length of the string
     */
    public static void quickSort(int[] array, int start, int end) {
        // This is the smallest block, so just return it
        if (end - start <= 1) {
            return;
        }

        // Divide such that the pivot is at the "middle" of the array, that is all the values to the left of the pivot
        // is less than or equal to the value, and all the values to the right are greater than or equal.
        int pivot = array[end - 1];
        int highIndex = end; // Large elements should be
        for(int i = start; i < end; i++){
            int current = array[i];
            // That means an element in the left side should be moved to the right
            if(current > pivot){
                array[i] = array[highIndex];
                
                highIndex--; // The element at the high index is at the "right" position. This does not mean it is it's
                             // permanent position.
            }
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