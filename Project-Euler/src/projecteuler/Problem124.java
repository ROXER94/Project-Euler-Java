package projecteuler;

import java.util.ArrayList;
import java.util.List;

public class Problem124 {

	/**
	 * Calculates the value of n in the 10,000th row of the sorted column of the radical of n for 1 ≤ n ≤ 100,000
	 */
	static void solution() {
		int N = 100000;
		int[] rad = new int[N];
		for (int i = 1; i < N; i++)
			rad[i] = 1;
		for (int i = 2; i < N; i++)
			if (rad[i] == 1)
				for (int j = i; j < N; j += i)
					rad[j] *= i;
		List<List<Integer>> sortedRadicals = new ArrayList<List<Integer>>();
		for (int i = 0; i < N; i++)
			sortedRadicals.add(Functions.getTuple(rad[i], i));
		sortedRadicals = Functions.getSortedIntegerLists(sortedRadicals);
		System.out.println(sortedRadicals.get(9999).get(1));
	}
}