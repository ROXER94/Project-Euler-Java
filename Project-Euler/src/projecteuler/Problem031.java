package projecteuler;

import java.util.Arrays;

public class Problem031 {

	/**
	 * Calculates the number of different ways £2 can be made using 1p, 2p, 5p, 10p, 20p, 50p, £1 and £2
	 */
	static void solution() {
		int coins[] = { 1, 2, 5, 10, 20, 50, 100, 200 };
		int n = 200;
		long[] ways = new long[n + 1];
		Arrays.fill(ways, 0);
		ways[0] = 1;
		for (int i = 0; i < coins.length; i++)
			for (int j = coins[i]; j <= n; j++)
				ways[j] += ways[j - coins[i]];
		System.out.println(ways[n]);
	}
}