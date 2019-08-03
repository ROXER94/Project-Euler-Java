package projecteuler;

import java.util.List;
import java.util.Map;

public class Problem060 {

	/**
	 * @param primes
	 * @param primesDict
	 * @return True if concatenating any two primes yields another prime
	 */
	static boolean evaluatePrimes(int[] primes, Map<Integer, Boolean> primesDict) {
		String s0 = "";
		String s1 = "";
		String s2 = "";
		String s3 = "";
		String s4 = "";
		if (primes.length == 2) {
			s0 = new Integer(primes[0]).toString();
			s1 = new Integer(primes[1]).toString();
		} else if (primes.length == 3) {
			s0 = new Integer(primes[0]).toString();
			s1 = new Integer(primes[1]).toString();
			s2 = new Integer(primes[2]).toString();
		} else if (primes.length == 4) {
			s0 = new Integer(primes[0]).toString();
			s1 = new Integer(primes[1]).toString();
			s2 = new Integer(primes[2]).toString();
			s3 = new Integer(primes[3]).toString();
		} else {
			s0 = new Integer(primes[0]).toString();
			s1 = new Integer(primes[1]).toString();
			s2 = new Integer(primes[2]).toString();
			s3 = new Integer(primes[3]).toString();
			s4 = new Integer(primes[4]).toString();
		}
		if (primes.length == 2)
			return primesDict.containsKey(Integer.parseInt(s0 + s1)) && primesDict.containsKey(Integer.parseInt(s1 + s0));
		else if (primes.length == 3)
			return primesDict.containsKey(Integer.parseInt(s0 + s2)) && primesDict.containsKey(Integer.parseInt(s2 + s0))
					&& primesDict.containsKey(Integer.parseInt(s1 + s2)) && primesDict.containsKey(Integer.parseInt(s2 + s1));
		else if (primes.length == 4)
			return primesDict.containsKey(Integer.parseInt(s0 + s3)) && primesDict.containsKey(Integer.parseInt(s3 + s0))
					&& primesDict.containsKey(Integer.parseInt(s1 + s3)) && primesDict.containsKey(Integer.parseInt(s3 + s1))
					&& primesDict.containsKey(Integer.parseInt(s2 + s3)) && primesDict.containsKey(Integer.parseInt(s3 + s2));
		else
			return primesDict.containsKey(Integer.parseInt(s0 + s4)) && primesDict.containsKey(Integer.parseInt(s4 + s0))
					&& primesDict.containsKey(Integer.parseInt(s1 + s4)) && primesDict.containsKey(Integer.parseInt(s4 + s1))
					&& primesDict.containsKey(Integer.parseInt(s2 + s4)) && primesDict.containsKey(Integer.parseInt(s4 + s2))
					&& primesDict.containsKey(Integer.parseInt(s3 + s4)) && primesDict.containsKey(Integer.parseInt(s4 + s3));
	}

	/**
	 * Calculates the sum of a set of five primes for which any two primes concatenate to produce another prime
	 */
	static void solution() {
		Map<Integer, Boolean> primesDict = Functions.getPrimesDict(85000000);
		List<Integer> primes = Functions.getPrimesList(85000000);
		for (int a = 1; a < 10; a++)
			for (int b = a + 1; b < 700; b++)
				if (evaluatePrimes(new int[] { primes.get(a), primes.get(b) }, primesDict))
					for (int c = b + 1; c < 755; c++)
						if (evaluatePrimes(new int[] { primes.get(a), primes.get(b), primes.get(c) }, primesDict))
							for (int d = c + 1; d < 900; d++)
								if (evaluatePrimes(new int[] { primes.get(a), primes.get(b), primes.get(c), primes.get(d) }, primesDict))
									for (int e = d + 1; e < 1100; e++)
										if (evaluatePrimes(new int[] { primes.get(a), primes.get(b), primes.get(c), primes.get(d), primes.get(e) }, primesDict)) {
											System.out.println(primes.get(a) + primes.get(b) + primes.get(c) + primes.get(d) + primes.get(e));
											return;
										}
	}
}