package projecteuler;

import java.math.BigInteger;

public class Problem057 {

	/**
	 * Calculates the number of fractions that contain a numerator with more digits than denominator in the first 1000 expansions of the continued fraction of
	 * √2
	 */
	static void solution() {
		int ans = 0;
		BigInteger n = BigInteger.valueOf(3);
		BigInteger d = BigInteger.valueOf(2);
		int currentIteration = 0;
		while (currentIteration != 1000) {
			if (n.toString().length() > d.toString().length())
				ans++;
			BigInteger n2 = d.multiply(BigInteger.valueOf(2)).add(n);
			BigInteger d2 = n.add(d);
			n = n2;
			d = d2;
			currentIteration++;
		}
		System.out.println(ans);
	}
}