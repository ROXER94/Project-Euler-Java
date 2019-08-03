package projecteuler;

import java.math.BigInteger;

public class Problem065 {

	/**
	 * Calculates the sum of the digits in the numerator of the 100th convergent of the continued fraction for e
	 */
	static void solution() {
		int ans = 0;
		int k = 0;
		BigInteger e = BigInteger.ZERO;
		BigInteger n1 = BigInteger.valueOf(2);
		BigInteger n2 = BigInteger.valueOf(3);
		for (int i = 3; i <= 100; i++) {
			if (i % 3 == 0) {
				k += 2;
				e = n2.multiply(BigInteger.valueOf(k)).add(n1);
			} else
				e = n2.add(n1);
			n1 = n2;
			n2 = e;
		}
		for (char c : e.toString().toCharArray())
			ans += c - '0';
		System.out.println(ans);
	}
}