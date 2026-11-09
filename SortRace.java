import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;
public class SortRace {
	public static void main(String[] args) {
		Random random = new Random();
		runRace(50_000, random);
		runRace(100_000, random);
	}
	private static void runRace(int size, Random random) {
		int[] numbers = new int[size];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt();
		}
		int[] selectionNumbers = Arrays.copyOf(numbers, numbers.length);
		int[] mergeNumbers = Arrays.copyOf(numbers, numbers.length);
		int[] libraryNumbers = Arrays.copyOf(numbers, numbers.length);
		Instant start = Instant.now();
		selectionSort(selectionNumbers);
		Duration selectionTime = Duration.between(start, Instant.now());
		start = Instant.now();
		mergeSort(mergeNumbers);
		Duration mergeTime = Duration.between(start, Instant.now());
		start = Instant.now();
		Arrays.sort(libraryNumbers);
		Duration libraryTime = Duration.between(start, Instant.now());
		System.out.println("Array size: " + size);
		printResult("Selection sort", selectionTime, isSorted(selectionNumbers));
		printResult("Merge sort", mergeTime, isSorted(mergeNumbers));
		printResult("Arrays.sort", libraryTime, isSorted(libraryNumbers));
	}
	private static void printResult(String name, Duration time, boolean sorted) {
		System.out.println(name + ": " + time.toMillis() + " ms; sorted: " + sorted);
	}
	private static void selectionSort(int[] values) {
		for (int i = 0; i < values.length - 1; i++) {
			int minimumIndex = i;
			for (int j = i + 1; j < values.length; j++) {
				if (values[j] < values[minimumIndex]) {
					minimumIndex = j;
				}
			}
			int temporary = values[i];
			values[i] = values[minimumIndex];
			values[minimumIndex] = temporary;
		}
	}
	private static void mergeSort(int[] values) {
		mergeSort(values, new int[values.length], 0, values.length);
	}
	private static void mergeSort(int[] values, int[] temporary, int start, int end) {
		if (end - start < 2) {
			return;
		}
		int middle = start + (end - start) / 2;
		mergeSort(values, temporary, start, middle);
		mergeSort(values, temporary, middle, end);

		int left = start;
		int right = middle;
		int index = start;
		while (left < middle && right < end) {
			if (values[left] <= values[right]) {
				temporary[index++] = values[left++];
			} else {
				temporary[index++] = values[right++];
			}
		}
		while (left < middle) {
			temporary[index++] = values[left++];
		}
		while (right < end) {
			temporary[index++] = values[right++];
		}
		System.arraycopy(temporary, start, values, start, end - start);
	}
	private static boolean isSorted(int[] values) {
		for (int i = 1; i < values.length; i++) {
			if (values[i - 1] > values[i]) {
				return false;
			}
		}
		return true;
	}
}
