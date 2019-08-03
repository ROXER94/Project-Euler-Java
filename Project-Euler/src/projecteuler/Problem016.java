package projecteuler;

import java.math.BigInteger;

public class Problem016 {

	/**
	 * Calculates the sum of the digits of the number 2^1000
	 */
	static void solution() {
		int ans = 0;
		for (char c : BigInteger.valueOf(2).pow(1000).toString().toCharArray())
			ans += c - '0';
		System.out.println(ans);
	}
}