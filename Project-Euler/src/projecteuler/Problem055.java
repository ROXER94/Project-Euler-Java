package projecteuler;

import java.math.BigInteger;

public class Problem055 {

	/**
	 * @param n
	 * @return the sum of n and the reverse of n
	 */
	static BigInteger getLychrel(BigInteger n) {
		return n.add(new BigInteger(new StringBuilder(n.toString()).reverse().toString()));
	}

	/**
	 * Calculates the number of Lychrel numbers below 10,000
	 */
	static void solution() {
		int ans = 0;
		for (int i = 1; i < 10000; i++) {
			boolean isLychrel = true;
			BigInteger currentNumber = BigInteger.valueOf(i);
			int iterationCount = 0;
			while (iterationCount < 50) {
				currentNumber = getLychrel(currentNumber);
				if (Functions.isPalindrome(currentNumber.toString())) {
					isLychrel = false;
					break;
				}
				iterationCount++;
			}
			if (isLychrel)
				ans++;
		}
		System.out.println(ans);
	}
}