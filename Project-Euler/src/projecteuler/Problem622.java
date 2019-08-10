package projecteuler;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

public class Problem622 {

	/**
	 * Calculates the sum of all values of n that satisfy s(n) = 60
	 */
	static void solution() {
		long ans = 0;
		int e = 60;
		SortedSet<Long> factors1 = Functions.getFactors((long) Math.pow(2, e / 2) + 1);
		SortedSet<Long> factors2 = Functions.getFactors((long) Math.pow(2, e / 2) - 1);
		List<Long> Factors = new ArrayList<Long>();
		for (long i : factors1)
			for (long j : factors2)
				Factors.add(i * j);
		Factors.remove(0);
		for (long n : Factors)
			if (Functions.getMultiplicativeOrder(2, n) == e)
				ans += n + 1;
		System.out.println(ans);
	}
}