package projecteuler;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem068 {

	/**
	 * Calculates the maximum 16-digit string for a magic 5-gon ring
	 */
	static void solution() {
		List<Integer[]> permutations = Functions.getPermutationsArray(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
		Collections.reverse(permutations);
		for (Integer[] ring : permutations) {
			int[] ans = new int[] { ring[0], ring[1], ring[2], ring[3], ring[2], ring[4], ring[5], ring[4], ring[6], ring[7], ring[6], ring[8], ring[9],
					ring[8], ring[1] };
			if (ring[0] + ring[1] + ring[2] == ring[3] + ring[2] + ring[4]
					&& ring[3] + ring[2] + ring[4] == ring[5] + ring[4] + ring[6]
					&& ring[5] + ring[4] + ring[6] == ring[7] + ring[6] + ring[8]
					&& ring[7] + ring[6] + ring[8] == ring[9] + ring[8] + ring[1]
					&& ring[9] + ring[8] + ring[1] == ring[0] + ring[1] + ring[2]
					&& (ring[0].toString() + ring[1].toString() + ring[2].toString() + ring[3].toString() + ring[2].toString() + ring[4].toString()
							+ ring[5].toString() + ring[4].toString() + ring[6].toString() + ring[7].toString() + ring[6].toString() + ring[8].toString()
							+ ring[9].toString() + ring[8].toString() + ring[1].toString()).length() == 16 && ans[0] < ans[3] && ans[0] < ans[6]
					&& ans[0] < ans[9] && ans[0] < ans[12]) {
				System.out.println(Arrays.toString(ans).replaceAll("\\[|\\]|,|\\s", ""));
				return;
			}
		}
	}
}