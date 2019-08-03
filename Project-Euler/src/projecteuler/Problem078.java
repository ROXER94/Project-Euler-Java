package projecteuler;

import java.math.BigInteger;

public class Problem078 {

	/**
	 * Calculates the smallest value of n for which p(n) is divisible by one million
	 */
	static void solution() {
		int n = 60000;
		BigInteger[] ways = new BigInteger[n + 1];
		for (int i = 0; i < ways.length; i++)
			ways[i] = BigInteger.ZERO;
		ways[0] = BigInteger.ONE;
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j++)
				ways[j] = ways[j].add(ways[j - i]);
			if (ways[i].mod(BigInteger.valueOf(1000000)).equals(BigInteger.ZERO)) {
				System.out.println(i);
				break;
			}
		}
	}
}