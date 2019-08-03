package projecteuler;

import java.util.List;

public class Problem027 {

	/**
	 * Calculates the product of the coefficients, a and b, for the quadratic expression n^2 + a*n+b that produces the maximum number of primes for consecutive
	 * values of n, starting with n = 0
	 */
	static void solution() {
		int ans = 0;
		int consecutiveCount = 0;
		List<Integer> primes = Functions.getPrimesList(1000);
		for (int a = 1; a < 1000; a++) {
			for (int b : primes) {
				int n = 0;
				int currentCount = 0;
				while (Functions.isPrime(n * n + a * n + b)) {
					currentCount++;
					if (currentCount > consecutiveCount) {
						consecutiveCount = currentCount;
						ans = a * b;
					}
					n++;
				}
				n = 0;
				currentCount = 0;
				while (Functions.isPrime(n * n - a * n + b)) {
					currentCount++;
					if (currentCount > consecutiveCount) {
						consecutiveCount = currentCount;
						ans = -a * b;
					}
					n++;
				}
				n = 0;
				currentCount = 0;
				while (Functions.isPrime(n * n + a * n - b)) {
					currentCount++;
					if (currentCount > consecutiveCount) {
						consecutiveCount = currentCount;
						ans = a * -b;
					}
					n++;
				}
				n = 0;
				currentCount = 0;
				while (Functions.isPrime(n * n - a * n - b)) {
					currentCount++;
					if (currentCount > consecutiveCount) {
						consecutiveCount = currentCount;
						ans = -a * -b;
					}
					n++;
				}
			}
		}
		System.out.println(ans);
	}
}