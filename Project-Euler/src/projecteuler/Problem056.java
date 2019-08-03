package projecteuler;

import java.math.BigInteger;

public class Problem056 {

	/**
	 * Calculates the maximum digital sum of natural numbers of the form a^b for a,b < 100
	 */
	static void solution() {
		int ans = 0;
		for (int a = 1; a < 100; a++)
			for (int b = 1; b < 100; b++) {
				int current = 0;
				for (char c : BigInteger.valueOf(a).pow(b).toString().toCharArray())
					current += c - '0';
				ans = Math.max(current, ans);
			}
		System.out.println(ans);
	}
}