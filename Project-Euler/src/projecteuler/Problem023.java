package projecteuler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem023 {

	/**
	 * @param n
	 * @return True if n is abundant
	 */
	static boolean isAbundant(int n) {
		return Functions.getLongListSum(new ArrayList<Long>(Functions.getFactors(n))) > 2 * n;
	}

	/**
	 * Calculates the sum of all the positive integers which cannot be written as the sum of two abundant numbers
	 */
	static void solution() {
		int ans = 0;
		List<Integer> abundantList = new ArrayList<Integer>();
		for (int i = 1; i <= 28123; i++)
			if (isAbundant(i))
				abundantList.add(i);
		Set<Integer> sums = new HashSet<Integer>();
		for (int i : abundantList)
			for (int j : abundantList)
				if (j >= i)
					sums.add(i + j);
		for (int i = 1; i <= 28123; i++)
			if (!sums.contains(i))
				ans += i;
		System.out.println(ans);
	}
}