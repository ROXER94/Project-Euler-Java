package projecteuler;

import java.util.Arrays;
import java.util.List;

public class Problem043 {

	/**
	 * Calculates the sum of 10-digit pandigital numbers with a unique property
	 */
	static void solution() {
		long ans = 0;
		List<Integer[]> permutations = Functions.getPermutationsArray(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		for (Integer[] i : permutations) {
			String s = Arrays.toString(i).replaceAll("\\[|\\]|,|\\s", "");
			if (Integer.parseInt(s.substring(1, 4)) % 2 == 0 && Integer.parseInt(s.substring(1, 4)) % 2 == 0
					&& Integer.parseInt(s.substring(2, 5)) % 3 == 0 && Integer.parseInt(s.substring(3, 6)) % 5 == 0
					&& Integer.parseInt(s.substring(4, 7)) % 7 == 0 && Integer.parseInt(s.substring(5, 8)) % 11 == 0
					&& Integer.parseInt(s.substring(6, 9)) % 13 == 0 && Integer.parseInt(s.substring(7, 10)) % 17 == 0

			)
				ans += Long.parseLong(s);
		}
		System.out.println(ans);
	}
}