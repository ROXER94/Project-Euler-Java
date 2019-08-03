package projecteuler;

import java.math.BigInteger;

public class Problem080 {

	/**
	 * @param n
	 * @return the square root expansion of n
	 */
	static BigInteger getSquareRootExpansion(int n) {
		BigInteger a = BigInteger.valueOf(5).multiply(BigInteger.valueOf(n));
		BigInteger b = BigInteger.valueOf(5);
		while (b.toString().length() <= 101) {
			if (a.compareTo(b) > 0) {
				a = a.subtract(b);
				b = b.add(BigInteger.valueOf(10));
			} else {
				a = a.multiply(BigInteger.valueOf(100));
				b = BigInteger.valueOf(10).multiply(b).subtract(BigInteger.valueOf(45));
			}
		}
		return b;
	}

	/**
	 * Calculates the total of the digital sums of the first one hundred decimal digits for all irrational square roots
	 */
	static void solution() {
		int ans = 0;
		for (int i = 1; i <= 100; i++)
			if (!Functions.isSquare(i))
				for (char c : getSquareRootExpansion(i).toString().substring(0, 100).toCharArray())
					ans += c - '0';
		System.out.println(ans);
	}
}