package projecteuler;

import java.util.List;

public class Problem347 {

	/**
	 * @param p
	 * @param q
	 * @param N
	 * @return the largest possible integer divisible by p and q ≤ N
	 */
	static long getM347(long p, long q, int N) {
		long result = 0;
		for (int i = 1; i <= (int) (Math.log(N / q) / Math.log(p)) + 1; i++)
			for (int j = 1; j <= (int) (Math.log(N / p) / Math.log(q)) + 1; j++) {
				long currentValue = (long) (Math.pow(p, i) * Math.pow(q, j));
				if (currentValue <= N && currentValue > result)
					result = currentValue;
			}
		return result;
	}

	/**
	 * Calculates the sum of M(p,q,10,000,000) for all distinct primes p and q
	 */
	static void solution() {
		long ans = 0;
		int N = 10000000;
		List<Integer> primes = Functions.getPrimesList(N / 2);
		for (int p = 0; p < primes.size() - 1; p++)
			for (int q = p + 1; q < primes.size(); q++)
				if (primes.get(p) * primes.get(q) > N)
					break;
				else
					ans += getM347(primes.get(p), primes.get(q), N);
		System.out.println(ans);
	}
}