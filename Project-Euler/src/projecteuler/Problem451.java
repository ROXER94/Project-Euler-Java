package projecteuler;

import java.util.HashSet;
import java.util.Set;

public class Problem451 {

	/**
	 * Calculates the sum of largest positive number m smaller than n-1 such that the modular inverse of m modulo n equals m itself for 3 ≤ n ≤ 20,000,000
	 */
	static void solution() {
		long ans = 1;
		int n = 20000000;
		int[] array = new int[n + 1];
		Set<Integer> primes = Functions.ToHashSet(Functions.getPrimesList(n));
		for (int i = 2; i <= n; i++)
			if (primes.contains(i))
				for (int j = i; j <= n; j += i)
					array[j] = i;
		primes.remove(2);
		Set<Long> seen = new HashSet<Long>();
		seen.add(1L);
		seen.add(2L);
		seen.add(4L);
		for (int e = 3; e <= (int) (Math.log(n) / Math.log(2)); e++) {
			long value = (long) Math.pow(2, e);
			seen.add(value);
			ans += value / 2 + 1;
		}
		for (int p : primes)
			for (int e = 1; e <= (int) (Math.log(n) / Math.log(3)); e++) {
				long value = (long) Math.pow(p, e);
				if (value <= n) {
					seen.add(value);
					ans++;
				} else
					break;
				if (2 * value <= n) {
					seen.add(2 * value);
					ans++;
				}
			}
		for (int i = 3; i <= n; i++)
			if (!seen.contains((long) i))
				for (long j = i - array[i]; j >= 0; j -= array[i])
					if ((j + 1) * (j + 1) % i == 1) {
						ans += j + 1;
						break;
					} else if ((j - 1) * (j - 1) % i == 1) {
						ans += j - 1;
						break;
					}
		System.out.println(ans);
	}
}