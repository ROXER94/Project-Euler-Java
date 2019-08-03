package projecteuler;

import java.math.BigInteger;

public class Problem063 {

	/**
	 * Calculates the number of n-digit positive integers which are also an nth power
	 */
	static void solution() {
		int ans = 0;
		for (int i = 1; i <= 9; i++)
			for (int j = 1; j <= 25; j++)
				if (BigInteger.valueOf(i).pow(j).toString().length() == j)
					ans++;
		System.out.println(ans);
	}
}