package projecteuler;

import java.math.BigInteger;

public class Problem129 {

	/**
	 * Calculates the least value of n for which A(n) first exceeds 1,000,000
	 */
	static void solution() {
		int ans = 1000013;
		while (true) {
			if (Functions.getGCD(ans, 10) == 1) {
				int k = 666681;
				while (!BigInteger.valueOf(10).modPow(BigInteger.valueOf(k), BigInteger.valueOf(ans)).equals(BigInteger.ONE))
					k++;
				if (k > 1000000)
					break;
			}
			ans += 2;
		}
		System.out.println(ans);
	}
}