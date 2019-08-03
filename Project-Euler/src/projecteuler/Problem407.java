package projecteuler;

import java.util.HashSet;
import java.util.Set;

public class Problem407 {

	/**
	 * Calculates the sum of the largest value of a less than n such that a^2 ≡ a (mod n) for 1 ≤ n ≤ 10,000,000
	 */
	static void solution() {
		long ans = 0;
		int n = 10000000;
		int[] array = new int[n + 1];
		Set<Integer> primes = Functions.ToHashSet(Functions.getPrimesList(n));
		for (int i = 2; i <= n; i++)
			if (primes.contains(i))
				for (int j = i; j <= n; j += i)
					array[j] = i;
		Set<Long> seen = new HashSet<Long>();
		seen.add(1L);
		seen.add(2L);
		seen.add(4L);
		for (int p : primes)
			for (int e = 1; e <= (int) (Math.log(n) / Math.log(3)); e++) {
				long value = (long) Math.pow(p, e);
				if (value <= n) {
					seen.add(value);
					ans++;
				} else
					break;
			}
		for (int i = 3; i <= n; i++)
			if (!seen.contains((long) i))
				for (long j = i - array[i]; j >= 0; j -= array[i])
					if ((j + 1) * (j + 1) % i == j + 1) {
						ans += j + 1;
						break;
					} else if (j * j % i == j) {
						ans += j;
						break;
					}
		System.out.println(ans);
	}
}