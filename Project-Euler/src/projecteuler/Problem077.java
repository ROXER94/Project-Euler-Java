package projecteuler;

import java.util.HashMap;
import java.util.Map;

public class Problem077 {

	/**
	 * Calculates the first number which can be written as the sum of primes in over 5000 different ways
	 */
	static void solution() {
		int ans = 0;
		Map<Integer, Long> primesDict = new HashMap<Integer, Long>();
		for (long p : Functions.getPrimesList(100))
			primesDict.put(primesDict.size() + 1, p);
		int primeSummationCount = 0;
		while (primeSummationCount <= 5000) {
			ans++;
			int[] ways = new int[ans + 1];
			ways[0] = 1;
			for (int i = 1; i <= primesDict.size(); i++)
				for (int j = primesDict.get(i).intValue(); j <= ans; j++)
					ways[j] = ways[j] + ways[(int) (j - primesDict.get(i))];
			primeSummationCount = ways[ans];
		}
		System.out.println(ans);
	}
}