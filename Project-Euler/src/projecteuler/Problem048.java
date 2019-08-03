package projecteuler;

import java.math.BigInteger;

public class Problem048 {

	/**
	 * Calculates the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000
	 */
	static void solution() {
		BigInteger ans = BigInteger.ZERO;
		for (int i = 1; i <= 1000; i++)
			ans = ans.add(BigInteger.valueOf(i).modPow(BigInteger.valueOf(i), BigInteger.valueOf(10000000000L)));
		System.out.println(ans.mod(BigInteger.valueOf(10000000000L)));
	}
}