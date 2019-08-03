package projecteuler;

import java.math.BigInteger;

public class Problem113 {

	/**
	 * @param n
	 * @return the number of bouncy numbers below 10^n
	 */
	static BigInteger getBouncy(int n) {
		BigInteger X = BigInteger.ZERO;
		for (int i = 1; i <= n; i++)
			X = X.add(Functions.getnCk(9 + i, i));
		return BigInteger.valueOf(10).pow(n).subtract(Functions.getnCk(9 + n, n)).subtract(X).add(BigInteger.valueOf(10 * n));
	}

	/**
	 * Calculates the number of non-bouncy numbers under a googol
	 */
	static void solution() {
		System.out.println(BigInteger.valueOf(10).pow(100).subtract(getBouncy(100)).subtract(BigInteger.ONE));
	}
}