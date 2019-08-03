package projecteuler;

import java.math.BigInteger;

public class Problem169 {

	/**
	 * @param n
	 * @return the nth term in Stern's Diatomic Series
	 */
	static long getFusc(BigInteger n) {
		long a = 1;
		long b = 0;
		while (n.compareTo(BigInteger.ZERO) > 0) {
			if (n.mod(BigInteger.valueOf(2)).compareTo(BigInteger.ZERO) == 0)
				a += b;
			else
				b += a;
			n = n.divide(BigInteger.valueOf(2));
		}
		return b;
	}

	/**
	 * Calculates the number of ways 10^25 can be expressed as a sum of powers of two using each power no more than twice
	 */
	static void solution() {
		System.out.println(getFusc(BigInteger.valueOf(10).pow(25).add(BigInteger.ONE)));
	}
}