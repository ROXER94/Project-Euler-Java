package projecteuler;

import java.math.BigInteger;

public class Problem132 {

	/**
	 * Calculates the sum of the first forty prime factors of R(10^9)
	 */
	static void solution() {
		long ans = 0;
		int count = 0;
		for (long p : Functions.getPrimesList(200000)) {
			if (count == 40)
				break;
			if (BigInteger.valueOf(10).modPow(BigInteger.valueOf(10).pow(9), BigInteger.valueOf(9 * p)).equals(BigInteger.ONE)) {
				ans += p;
				count++;
			}
		}
		System.out.println(ans);
	}
}