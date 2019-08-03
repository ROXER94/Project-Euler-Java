package projecteuler;

public class Problem160 {

	/**
	 * @param n
	 * @param e
	 * @return the last e non-zero digits of n!
	 */
	static long getFactorialLastDigits(long n, int e) {
		long a = 1;
		long b = 1;
		long c = (long) Math.pow(10, e);
		long current;
		long mod = n > c ? n : c;
		for (long i = 1; i <= n; i++) {
			current = i % 2 == 0 ? b * i : a * i;
			while (current % 10 == 0) {
				current /= 10;
			}
			if (i % 2 == 0)
				a = current % mod;
			else
				b = current % mod;
		}
		return n % 2 == 0 ? a % c : b % c;
	}

	/**
	 * Calculates the last five non-zero digits in 1,000,000,000,000!
	 */
	static void solution() {
		System.out.println(getFactorialLastDigits((long) (Math.pow(10, 12) / Math.pow(5, 7)), 5));
	}
}