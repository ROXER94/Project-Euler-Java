package projecteuler;

import java.util.Arrays;

public class Problem024 {

	/**
	 * Calculates the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8, and 9
	 */
	static void solution() {
		System.out.println(Arrays.toString(Functions.getPermutationsArray(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }).get(999999)).replaceAll(
				"\\[|\\]|,|\\s", ""));
	}
}