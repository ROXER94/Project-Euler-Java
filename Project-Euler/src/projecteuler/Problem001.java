package projecteuler;

public class Problem001 {

	/**
	 * @param n
	 * @param limit
	 * @return the sum of integers divisible by n up to and including the limit
	 */
	static int getSumDivisibleBy(int n, int limit) {
		int p = limit / n;
		return n * p * (p + 1) / 2;
	}

	/**
	 * Calculates the sum of all the multiples of 3 or 5 below 1000
	 */
	static void solution() {
		int limit = 999;
		System.out.println(getSumDivisibleBy(3, limit) + getSumDivisibleBy(5, limit) - getSumDivisibleBy(15, limit));
	}
}