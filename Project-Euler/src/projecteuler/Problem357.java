package projecteuler;

import java.util.Map;

public class Problem357 {

	/**
	 * @param n
	 * @param primesDict
	 * @return True if n is a prime generating integer
	 */
	static boolean isPrimeGeneratingInteger(int n, Map<Integer, Boolean> primesDict) {
		for (int d = 1; d <= Math.pow(n, .5); d++)
			if (n % d == 0 && !primesDict.containsKey(d + n / d))
				return false;
		return true;
	}

	/**
	 * Calculates the sum of all positive integers n below 100,000,000 such that the sum of each pair of factors of n is prime
	 */
	static void solution() {
		long ans = 1;
		Map<Integer, Boolean> primesDict = Functions.getPrimesDict(100000000);
		for (int i = 2; i < 100000000; i += 4)
			if (primesDict.containsKey(i + 1) && isPrimeGeneratingInteger(i, primesDict))
				ans += i;
		System.out.println(ans);
	}
}