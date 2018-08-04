import java.util.Arrays;

public class Sorting{
	public static void main(String[] args){
		Integer[] numbers = {5, 10, 1, 25, 6, 3};
		System.out.println(Arrays.toString(insertionSort(numbers, 1)));
	}

	public static Integer[] insertionSort(Integer[] numbers, int pointer){
		// Pointer is pointing beyond array meaning everything is sorted
		if(numbers.length == pointer){
			return numbers;
		}

		// Copy since the pointer value will be constantly changing
		int moveKey = pointer;
		// Change operator depending on larger first (>) or smaller first (<)
		while(numbers[moveKey] > numbers[moveKey - 1]){  
			// Switches the values in the array
			int smaller = numbers[moveKey - 1];
			numbers[moveKey - 1] = numbers[moveKey];
			numbers[moveKey] = smaller;

			// Move key down to check if the new position "fits"
			moveKey--;

			// Prevent comparison for index of -1
			if(moveKey == 0){
				break;	
			}
		}
		return insertionSort(numbers, pointer + 1);
	}

	public static Integer[] quickSort(Integer[] numbers){
		return numbers;
	}
}
