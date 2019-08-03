package projecteuler;

public class Problem133 {

	/**
	 * @param n
	 * @return True if n is composed of 2's and 5's
	 */
	static boolean isComposedOf2and5(int n) {
		if (n == 0)
			return true;
		while (n % 2 == 0)
			n /= 2;
		while (n % 5 == 0)
			n /= 5;
		return n == 1;
	}

	/**
	 * Calculates the sum of all the primes below 100,000 that will never be a factor of R(10^n)
	 */
	static void solution() {
		int ans = 10;
		for (int p : Functions.getPrimesList(100000))
			if (Functions.getGCD(10, p) == 1 && !isComposedOf2and5(Functions.getMultiplicativeOrder(10, p)))
				ans += p;
		System.out.println(ans);
	}
}