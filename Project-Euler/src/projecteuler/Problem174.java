package projecteuler;

import java.util.HashMap;
import java.util.Map;

public class Problem174 {

	/**
	 * Calculates the sum of the number of t ≤ 1000000 such that t is type L(n) for 1 ≤ n ≤ 10
	 */
	static void solution() {
		int ans = 0;
		int n = 1000000;
		Map<Integer, Integer> tilesDict = new HashMap<Integer, Integer>();
		for (int l = 3; l <= n / 4 + 1; l++)
			for (int s = l - 2; s > 0; s -= 2) {
				int currentValue = l * l - s * s;
				if (currentValue <= n)
					tilesDict.merge(currentValue, 1, Integer::sum);
				else
					break;
			}
		for (int i : tilesDict.values())
			if (i <= 10)
				ans++;
		System.out.println(ans);
	}
}