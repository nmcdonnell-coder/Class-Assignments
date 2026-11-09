public class BinarySearch {
	private static int binaryChecks;
	private static int linearChecks;
	public static int binarySearch(int[] a, int target, int low, int high) {
		if (low > high) {
			return -1;
		}
		int mid = low + (high - low) / 2;
		binaryChecks++;
		if (a[mid] == target) {
			return mid;
		}
		if (target < a[mid]) {
			return binarySearch(a, target, low, mid - 1);
		}
		return binarySearch(a, target, mid + 1, high);
	}
	public static int linearSearch(int[] a, int target) {
		linearChecks = 0;
		for (int i = 0; i < a.length; i++) {
			linearChecks++;
			if (a[i] == target) {
				return i;
			}
		}
		return -1;
	}
	private static void testSearches(int[] a, int target) {
		binaryChecks = 0;
		int binaryIndex = binarySearch(a, target, 0, a.length - 1);
		int checksForBinary = binaryChecks;
		int linearIndex = linearSearch(a, target);
		System.out.println("Target " + target + ": binary index=" + binaryIndex
				+ ", checks=" + checksForBinary + "; linear index=" + linearIndex
				+ ", checks=" + linearChecks);
	}
	public static void main(String[] args) {
		int[] numbers = new int[1000];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i;
		}
		testSearches(numbers, numbers[0]);
		testSearches(numbers, numbers[numbers.length - 1]);
		testSearches(numbers, numbers[numbers.length / 2]);
		testSearches(numbers, 1000);
	}
}
