package projecteuler;

import java.util.Map;

public class Problem131 {

	/**
	 * Calculates the number of primes below 1,000,000 where n^3 + p*n^2 is a perfect cube
	 */
	static void solution() {
		int ans = 0;
		Map<Integer, Boolean> primesDict = Functions.getPrimesDict(1000000);
		for (int n = 0; n < 1000; n++)
			if (primesDict.containsKey(3 * n * n + 3 * n + 1))
				ans++;
		System.out.println(ans);
	}
}