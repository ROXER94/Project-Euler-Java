package projecteuler;

public class Problem187 {

	/**
	 * Calculates the number of semiprimes below 100,000,000
	 */
	static void solution() {
		int ans = 0;
		int limit = 100000000;
		int[] primes = Functions.getPrimesList(limit / 2).stream().mapToInt(i -> i).toArray();
		for (int i = 0; (int) primes[i] < Math.sqrt(limit); i++)
			for (int j = i; j < primes.length; j++) {
				if (primes[i] * primes[j] >= limit)
					break;
				ans++;
			}
		System.out.println(ans);
	}
}