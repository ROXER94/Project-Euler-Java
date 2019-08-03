package projecteuler;

import java.util.List;

public class Problem381 {

	/**
	 * Calculates the sum of S(p) for primes between 5 and 100,000,000
	 */
	static void solution() {
		long ans = 0;
		List<Integer> primes = Functions.getPrimesList(100000000);
		primes.remove(0);
		primes.remove(0);
		for (int p : primes) {
			long modInverse = -3 * Functions.getModInverse(8, p);
			ans += modInverse - (long) (p * Math.floor((double) modInverse / p));
		}
		System.out.println(ans);
	}
}