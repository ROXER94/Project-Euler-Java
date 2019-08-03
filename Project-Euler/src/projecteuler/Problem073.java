package projecteuler;

import java.util.HashSet;
import java.util.Set;

public class Problem073 {

	/**
	 * @param n
	 * @return the Farey Sequence of n between 1/3 and 1/2
	 */
	static Set<Double> getFareySequence(long n) {
		Set<Double> FareySequence = new HashSet<Double>();
		long a = 0;
		long b = 1;
		long c = 1;
		long d = n;
		while (c <= n) {
			long k = (n + b) / d;
			long p = c;
			long q = d;
			c = k * c - a;
			d = k * d - b;
			a = p;
			b = q;
			if (((double) a / b) > 1.0 / 3 && ((double) a / b) < 1.0 / 2)
				FareySequence.add((double) a / b);
		}
		return FareySequence;
	}

	/**
	 * Calculates the number of fractions that lie between 1/3 and 1/2 in the sorted set of reduced proper fractions for d ≤ 12,000
	 */
	static void solution() {
		Set<Double> FareySequence = getFareySequence(12000);
		System.out.println(FareySequence.size());
	}
}