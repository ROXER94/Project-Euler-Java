package projecteuler;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem041 {

	/**
	 * Calculates the largest n-digit pandigital prime
	 */
	static void solution() {
		List<Integer[]> permutations = Functions.getPermutationsArray(new Integer[] { 1, 2, 3, 4, 5, 6, 7 });
		Collections.reverse(permutations);
		for (Integer[] i : permutations) {
			String s = Arrays.toString(i).replaceAll("\\[|\\]|,|\\s", "");
			if (Functions.isPrime(Integer.parseInt(s))) {
				System.out.println(s);
				break;
			}
		}
	}
}