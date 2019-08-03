package projecteuler;

import java.util.List;

public class Problem123 {

	/**
	 * Calculates the smallest value of n for which the remainder first exceeds 10^10 in the equation (p(n)-1)^n + (p(n)+1)^n % p(n)^2
	 */
	static void solution() {
		int ans = 7037;
		List<Integer> primes = Functions.getPrimesList(300000);
		while ((long) 2 * (ans + 1) * primes.get(ans) < 10000000000L)
			ans += 2;
		ans += 2;
		System.out.println(ans);
	}
}