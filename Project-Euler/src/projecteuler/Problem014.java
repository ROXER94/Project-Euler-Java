package projecteuler;

import java.util.HashMap;
import java.util.Map;

public class Problem014 {

	/**
	 * HashMap used to memoize the Collatz sequence
	 */
	static Map<Long, Long> collatzDict = new HashMap<Long, Long>();

	/**
	 * @param n
	 * @return the length of the Collatz chain of n via memoization
	 */
	static long getCollatz(long n) {
		if (!collatzDict.containsKey(n))
			collatzDict.put(n, getCollatzUncached(n));
		return collatzDict.get(n);
	}

	/**
	 * @param n
	 * @return the length of the Collatz chain of n via recursion
	 */
	static long getCollatzUncached(long n) {
		if (n == 1)
			return 1;
		else if (n % 2 != 0)
			return 2 + getCollatz((3 * n + 1) / 2);
		else
			return 1 + getCollatz(n / 2);
	}

	/**
	 * Calculates the number under one million that produces the longest Collatz sequence
	 */
	static void solution() {
		long ans = 0;
		long chain = 0;
		for (long i = 1; i < 1000000; i++) {
			getCollatz(i);
			if (collatzDict.get(i) > chain) {
				chain = collatzDict.get(i);
				ans = i;
			}
		}
		System.out.println(ans);
	}
}