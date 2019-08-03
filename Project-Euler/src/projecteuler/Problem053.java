package projecteuler;

import java.math.BigInteger;

public class Problem053 {

	/**
	 * Calculates the number of values of nCk, for 1 ≤ n ≤ 100, that are greater than 1,000,000
	 */
	static void solution() {
		int ans = 0;
		for (int k = 1; k <= 100; k++)
			for (int n = k; n <= 100; n++)
				if (Functions.getnCk(n, k).compareTo(BigInteger.valueOf(1000000)) > 0)
					ans++;
		System.out.println(ans);
	}
}