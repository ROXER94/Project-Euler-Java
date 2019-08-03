package projecteuler;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem032 {

	/**
	 * Calculates the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital
	 */
	static void solution() {
		Set<Integer> ans = new HashSet<Integer>();
		for (Integer[] i : Functions.getPermutationsArray(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 })) {
			String s = Arrays.toString(i).replaceAll("\\[|\\]|,|\\s", "");
			if (i[0] * Integer.parseInt(s.substring(1, 5)) == Integer.parseInt(s.substring(5, 9))
					|| Integer.parseInt(s.substring(0, 2)) * Integer.parseInt(s.substring(2, 5)) == Integer.parseInt(s.substring(5, 9)))
				ans.add(Integer.parseInt(s.substring(5, 9)));
		}
		System.out.println(ans.stream().mapToInt(Integer::intValue).sum());
	}
}