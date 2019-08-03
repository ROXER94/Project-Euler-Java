package projecteuler;

import java.util.ArrayList;
import java.util.List;

public class Problem134 {

	/**
	 * Calculates the sum of the prime pair connection for every pair of consecutive primes below 1,000,000
	 */
	static void solution() {
		long ans = 0;
		List<Integer> primes = Functions.getPrimesList(1000004);
		primes.remove(0);
		primes.remove(0);
		for (int i = 0; i < primes.size() - 1; i++) {
			int p1 = primes.get(i);
			int p2 = primes.get(i + 1);
			List<Integer> relativePrimes = new ArrayList<Integer>();
			relativePrimes.add(p2);
			relativePrimes.add((int) Math.pow(10, new Integer(p1).toString().length()));
			List<Integer> remainders = new ArrayList<Integer>();
			remainders.add(0);
			remainders.add(p1);
			ans += Functions.getChineseRemainderTheorem(relativePrimes, remainders);
		}
		System.out.println(ans);
	}
}