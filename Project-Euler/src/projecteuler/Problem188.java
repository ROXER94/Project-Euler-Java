package projecteuler;

import java.math.BigInteger;

public class Problem188 {

	/**
	 * Calculates the last 8 digits of 1777↑↑1855
	 */
	static void solution() {
		BigInteger ans = BigInteger.ZERO;
		BigInteger a = BigInteger.valueOf(1777);
		BigInteger b = BigInteger.valueOf(1855);
		for (int i = 0; i < b.intValue(); i++)
			ans = a.modPow(ans, BigInteger.valueOf(10).pow(8));
		System.out.println(ans);
	}
}